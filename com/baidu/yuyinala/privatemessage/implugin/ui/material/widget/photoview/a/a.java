package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class a implements d {
    float bDi;
    float bDj;
    final float iFt;
    private VelocityTracker mVelocityTracker;
    protected e oTV;
    final float oTW;
    private boolean oTX;

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public void a(e eVar) {
        this.oTV = eVar;
    }

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.oTW = viewConfiguration.getScaledMinimumFlingVelocity();
        this.iFt = viewConfiguration.getScaledTouchSlop();
    }

    float ap(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    float aq(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean ene() {
        return false;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean isDragging() {
        return this.oTX;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mVelocityTracker = VelocityTracker.obtain();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enf().i("CupcakeGestureDetector", "Velocity tracker is null");
                }
                this.bDi = ap(motionEvent);
                this.bDj = aq(motionEvent);
                this.oTX = false;
                break;
            case 1:
                if (this.oTX && this.mVelocityTracker != null) {
                    this.bDi = ap(motionEvent);
                    this.bDj = aq(motionEvent);
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float xVelocity = this.mVelocityTracker.getXVelocity();
                    float yVelocity = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.oTW) {
                        this.oTV.i(this.bDi, this.bDj, -xVelocity, -yVelocity);
                    }
                }
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
            case 2:
                float ap = ap(motionEvent);
                float aq = aq(motionEvent);
                float f = ap - this.bDi;
                float f2 = aq - this.bDj;
                if (!this.oTX) {
                    this.oTX = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.iFt);
                }
                if (this.oTX) {
                    this.oTV.onDrag(f, f2);
                    this.bDi = ap;
                    this.bDj = aq;
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
