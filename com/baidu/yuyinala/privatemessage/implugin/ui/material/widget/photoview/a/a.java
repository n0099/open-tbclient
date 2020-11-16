package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class a implements d {
    float bya;
    float byb;
    final float iuB;
    private VelocityTracker mVelocityTracker;
    protected e oEP;
    final float oEQ;
    private boolean oER;

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public void a(e eVar) {
        this.oEP = eVar;
    }

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.oEQ = viewConfiguration.getScaledMinimumFlingVelocity();
        this.iuB = viewConfiguration.getScaledTouchSlop();
    }

    float ao(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    float ap(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean ehp() {
        return false;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean isDragging() {
        return this.oER;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mVelocityTracker = VelocityTracker.obtain();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehq().i("CupcakeGestureDetector", "Velocity tracker is null");
                }
                this.bya = ao(motionEvent);
                this.byb = ap(motionEvent);
                this.oER = false;
                break;
            case 1:
                if (this.oER && this.mVelocityTracker != null) {
                    this.bya = ao(motionEvent);
                    this.byb = ap(motionEvent);
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float xVelocity = this.mVelocityTracker.getXVelocity();
                    float yVelocity = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.oEQ) {
                        this.oEP.i(this.bya, this.byb, -xVelocity, -yVelocity);
                    }
                }
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
            case 2:
                float ao = ao(motionEvent);
                float ap = ap(motionEvent);
                float f = ao - this.bya;
                float f2 = ap - this.byb;
                if (!this.oER) {
                    this.oER = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.iuB);
                }
                if (this.oER) {
                    this.oEP.onDrag(f, f2);
                    this.bya = ao;
                    this.byb = ap;
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
