package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
/* loaded from: classes11.dex */
public class a implements d {
    float bGS;
    float bGT;
    final float iSH;
    private VelocityTracker mVelocityTracker;
    protected e pfO;
    final float pfP;
    private boolean pfQ;

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public void a(e eVar) {
        this.pfO = eVar;
    }

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.pfP = viewConfiguration.getScaledMinimumFlingVelocity();
        this.iSH = viewConfiguration.getScaledTouchSlop();
    }

    float ar(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    float as(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean elH() {
        return false;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean isDragging() {
        return this.pfQ;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mVelocityTracker = VelocityTracker.obtain();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elI().i("CupcakeGestureDetector", "Velocity tracker is null");
                }
                this.bGS = ar(motionEvent);
                this.bGT = as(motionEvent);
                this.pfQ = false;
                break;
            case 1:
                if (this.pfQ && this.mVelocityTracker != null) {
                    this.bGS = ar(motionEvent);
                    this.bGT = as(motionEvent);
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float xVelocity = this.mVelocityTracker.getXVelocity();
                    float yVelocity = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.pfP) {
                        this.pfO.i(this.bGS, this.bGT, -xVelocity, -yVelocity);
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
                if (!this.pfQ) {
                    this.pfQ = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.iSH);
                }
                if (this.pfQ) {
                    this.pfO.onDrag(f, f2);
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
