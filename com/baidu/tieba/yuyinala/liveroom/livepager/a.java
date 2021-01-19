package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes10.dex */
public class a {
    private float cBP;
    private long fYK;
    private long fYL;
    private boolean fYM;
    private boolean fYN;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;
    private InterfaceC0925a oms;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.livepager.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0925a {
        void bIA();

        void bIz();

        void z(float f, float f2);
    }

    public a(View view) {
        this.mView = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownX = motionEvent.getX();
                this.cBP = motionEvent.getY();
                this.fYK = System.currentTimeMillis();
                this.fYM = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fYK < 100 && currentTimeMillis - this.fYL < 500) {
                    this.fYN = true;
                } else {
                    this.fYN = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cBP - motionEvent.getY()) > 50.0f) {
                    this.fYN = false;
                    this.fYM = false;
                }
                if (this.fYN) {
                    if (this.oms != null) {
                        this.oms.z(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cBP - motionEvent.getY()) && this.oms != null) {
                    this.oms.bIA();
                }
                if (!this.fYN && this.fYM && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cBP - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.fYN && a.this.fYM && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cBP - motionEvent.getY()) < 30.0f && a.this.oms != null) {
                                a.this.oms.bIz();
                            }
                        }
                    }, 300L);
                }
                this.fYL = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0925a interfaceC0925a) {
        this.oms = interfaceC0925a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
