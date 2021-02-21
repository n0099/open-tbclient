package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
/* loaded from: classes11.dex */
public class a implements d {
    float bGS;
    float bGT;
    final float iSV;
    private VelocityTracker mVelocityTracker;
    protected e pgo;
    final float pgp;
    private boolean pgq;

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public void a(e eVar) {
        this.pgo = eVar;
    }

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.pgp = viewConfiguration.getScaledMinimumFlingVelocity();
        this.iSV = viewConfiguration.getScaledTouchSlop();
    }

    float ar(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    float as(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean elP() {
        return false;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean isDragging() {
        return this.pgq;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mVelocityTracker = VelocityTracker.obtain();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elQ().i("CupcakeGestureDetector", "Velocity tracker is null");
                }
                this.bGS = ar(motionEvent);
                this.bGT = as(motionEvent);
                this.pgq = false;
                break;
            case 1:
                if (this.pgq && this.mVelocityTracker != null) {
                    this.bGS = ar(motionEvent);
                    this.bGT = as(motionEvent);
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float xVelocity = this.mVelocityTracker.getXVelocity();
                    float yVelocity = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.pgp) {
                        this.pgo.i(this.bGS, this.bGT, -xVelocity, -yVelocity);
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
                float f = ar - this.bGS;
                float f2 = as - this.bGT;
                if (!this.pgq) {
                    this.pgq = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.iSV);
                }
                if (this.pgq) {
                    this.pgo.onDrag(f, f2);
                    this.bGS = ar;
                    this.bGT = as;
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
