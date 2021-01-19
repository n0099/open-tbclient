package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
/* loaded from: classes10.dex */
public class a implements d {
    float bDi;
    float bDj;
    final float iNa;
    private VelocityTracker mVelocityTracker;
    protected e oVB;
    final float oVC;
    private boolean oVD;

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public void a(e eVar) {
        this.oVB = eVar;
    }

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.oVC = viewConfiguration.getScaledMinimumFlingVelocity();
        this.iNa = viewConfiguration.getScaledTouchSlop();
    }

    float ar(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    float as(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean ejn() {
        return false;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean isDragging() {
        return this.oVD;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mVelocityTracker = VelocityTracker.obtain();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().i("CupcakeGestureDetector", "Velocity tracker is null");
                }
                this.bDi = ar(motionEvent);
                this.bDj = as(motionEvent);
                this.oVD = false;
                break;
            case 1:
                if (this.oVD && this.mVelocityTracker != null) {
                    this.bDi = ar(motionEvent);
                    this.bDj = as(motionEvent);
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float xVelocity = this.mVelocityTracker.getXVelocity();
                    float yVelocity = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.oVC) {
                        this.oVB.i(this.bDi, this.bDj, -xVelocity, -yVelocity);
                    }
                }
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
            case 2:
                float ar = ar(motionEvent);
                float as = as(motionEvent);
                float f = ar - this.bDi;
                float f2 = as - this.bDj;
                if (!this.oVD) {
                    this.oVD = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.iNa);
                }
                if (this.oVD) {
                    this.oVB.onDrag(f, f2);
                    this.bDi = ar;
                    this.bDj = as;
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.addMovement(motionEvent);
                        break;
                    }
                }
                break;
            case 3:
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
        }
        return true;
    }
}
