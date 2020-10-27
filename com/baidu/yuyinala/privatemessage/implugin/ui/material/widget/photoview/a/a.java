package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class a implements d {
    float btA;
    float btz;
    final float inQ;
    private VelocityTracker mVelocityTracker;
    protected e otS;
    final float otT;
    private boolean otU;

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public void a(e eVar) {
        this.otS = eVar;
    }

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.otT = viewConfiguration.getScaledMinimumFlingVelocity();
        this.inQ = viewConfiguration.getScaledTouchSlop();
    }

    float an(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    float ao(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean edC() {
        return false;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean isDragging() {
        return this.otU;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mVelocityTracker = VelocityTracker.obtain();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.edD().i("CupcakeGestureDetector", "Velocity tracker is null");
                }
                this.btz = an(motionEvent);
                this.btA = ao(motionEvent);
                this.otU = false;
                break;
            case 1:
                if (this.otU && this.mVelocityTracker != null) {
                    this.btz = an(motionEvent);
                    this.btA = ao(motionEvent);
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float xVelocity = this.mVelocityTracker.getXVelocity();
                    float yVelocity = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.otT) {
                        this.otS.i(this.btz, this.btA, -xVelocity, -yVelocity);
                    }
                }
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
            case 2:
                float an = an(motionEvent);
                float ao = ao(motionEvent);
                float f = an - this.btz;
                float f2 = ao - this.btA;
                if (!this.otU) {
                    this.otU = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.inQ);
                }
                if (this.otU) {
                    this.otS.onDrag(f, f2);
                    this.btz = an;
                    this.btA = ao;
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
