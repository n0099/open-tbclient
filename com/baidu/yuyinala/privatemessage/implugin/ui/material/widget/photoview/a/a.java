package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
/* loaded from: classes10.dex */
public class a implements d {
    float bIs;
    float bIt;
    final float iUE;
    private VelocityTracker mVelocityTracker;
    protected e piw;
    final float pix;
    private boolean piy;

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public void a(e eVar) {
        this.piw = eVar;
    }

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.pix = viewConfiguration.getScaledMinimumFlingVelocity();
        this.iUE = viewConfiguration.getScaledTouchSlop();
    }

    float ar(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    float as(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean elZ() {
        return false;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean isDragging() {
        return this.piy;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mVelocityTracker = VelocityTracker.obtain();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ema().i("CupcakeGestureDetector", "Velocity tracker is null");
                }
                this.bIs = ar(motionEvent);
                this.bIt = as(motionEvent);
                this.piy = false;
                break;
            case 1:
                if (this.piy && this.mVelocityTracker != null) {
                    this.bIs = ar(motionEvent);
                    this.bIt = as(motionEvent);
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float xVelocity = this.mVelocityTracker.getXVelocity();
                    float yVelocity = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.pix) {
                        this.piw.i(this.bIs, this.bIt, -xVelocity, -yVelocity);
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
                float f = ar - this.bIs;
                float f2 = as - this.bIt;
                if (!this.piy) {
                    this.piy = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.iUE);
                }
                if (this.piy) {
                    this.piw.onDrag(f, f2);
                    this.bIs = ar;
                    this.bIt = as;
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
