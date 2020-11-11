package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class a implements d {
    float bzL;
    float bzM;
    final float itN;
    private VelocityTracker mVelocityTracker;
    protected e oDl;
    final float oDm;
    private boolean oDn;

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public void a(e eVar) {
        this.oDl = eVar;
    }

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.oDm = viewConfiguration.getScaledMinimumFlingVelocity();
        this.itN = viewConfiguration.getScaledTouchSlop();
    }

    float ao(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    float ap(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean ehr() {
        return false;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean isDragging() {
        return this.oDn;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mVelocityTracker = VelocityTracker.obtain();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehs().i("CupcakeGestureDetector", "Velocity tracker is null");
                }
                this.bzL = ao(motionEvent);
                this.bzM = ap(motionEvent);
                this.oDn = false;
                break;
            case 1:
                if (this.oDn && this.mVelocityTracker != null) {
                    this.bzL = ao(motionEvent);
                    this.bzM = ap(motionEvent);
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float xVelocity = this.mVelocityTracker.getXVelocity();
                    float yVelocity = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.oDm) {
                        this.oDl.i(this.bzL, this.bzM, -xVelocity, -yVelocity);
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
                float f = ao - this.bzL;
                float f2 = ap - this.bzM;
                if (!this.oDn) {
                    this.oDn = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.itN);
                }
                if (this.oDn) {
                    this.oDl.onDrag(f, f2);
                    this.bzL = ao;
                    this.bzM = ap;
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
