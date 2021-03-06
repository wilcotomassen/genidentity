import java.util.ArrayList;

import com.thomasdiewald.pixelflow.java.fluid.DwFluid2D;

import processing.core.PVector;

class MyFluidData implements DwFluid2D.FluidData{

	/**
	 * 
	 */
	private final Main main;
	
	ArrayList<PVector> emitters = new ArrayList<PVector>();

	/**
	 * @param main
	 */
	MyFluidData(Main main) {
		this.main = main;
	}

	// update() is called during the fluid-simulation update step.
	@Override
	public void update(DwFluid2D fluid) {

		float px, py, vx, vy, radius, vscale, temperature;

		// add impulse: density + temperature
//		px = this.main.width-80;
//		py = 30;
//		radius = 60;
//		vx = 0;
//		vy = 50;
//		fluid.addDensity(px, py, radius, 1, 1, 1, 1);
//		temperature = 4;
//		fluid.addTemperature(px, py, radius, temperature);
//
//		// add impulse: density + velocit
//		px = this.main.width/2;
//		py = this.main.height/2;
//		radius = 15;
//		vx = 0;
//		vy = -50;
//		fluid.addDensity(px, py, radius, 1, 1, 1, 1);
//		temperature = -4;
//		fluid.addTemperature(px, py, radius, temperature);

		boolean mouse_input = !this.main.cp5.isMouseOver() && this.main.mousePressed;

		// add impulse: density + velocity
		if(mouse_input && this.main.mouseButton == Main.LEFT){
			
			emitters.add(new PVector(this.main.mouseX, this.main.mouseY, 15));
			
//			vscale = 15;
//			px     = this.main.mouseX;
//			py     = this.main.height-this.main.mouseY;
//			vx     = (this.main.mouseX - this.main.pmouseX) * +vscale;
//			vy     = (this.main.mouseY - this.main.pmouseY) * -vscale;
//			radius = 8;
//			fluid.addDensity(px, py, radius, 1, 1, 1f, 1.0f);
//			radius = 15;
//			fluid.addVelocity(px, py, radius, vx, vy);
		}

//		// add impulse: density + velocity
//		if(mouse_input && this.main.mouseButton == Main.RIGHT){
//			vscale = 15;
//			px     = this.main.mouseX;
//			py     = this.main.height-this.main.mouseY;
//			vx     = (this.main.mouseX - this.main.pmouseX) * +vscale;
//			vy     = (this.main.mouseY - this.main.pmouseY) * -vscale;
//			radius = 30;
//			fluid.addDensity(px, py, radius, 0, 0.4f, 1f, 1f, 1);
//			radius = 20;
//			temperature = 1;
//			fluid.addTemperature(px, py, radius, temperature);
//		}
		
		for (PVector v: emitters) {
			
			
			vscale = 15;
			px     = v.x;
			py     = this.main.height-v.y;
			vx     = (v.x - 100) * vscale;
			vy     = (v.y + 30) * vscale;
			radius = v.z;
			fluid.addDensity(px, py, radius, 1, 1, 1f, 1.0f);
			radius *= 0.5f;
			fluid.addVelocity(px, py, radius, vx, vy);
			
			v.z *= 0.9f;
			
			
		}

	}
}