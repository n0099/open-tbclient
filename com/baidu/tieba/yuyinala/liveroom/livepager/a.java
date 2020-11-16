package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class a {
    private float cuT;
    private long fMe;
    private long fMf;
    private boolean fMg;
    private boolean fMh;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;
    private InterfaceC0913a nYI;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.livepager.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0913a {
        void bGy();

        void bGz();

        void y(float f, float f2);
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
                this.cuT = motionEvent.getY();
                this.fMe = System.currentTimeMillis();
                this.fMg = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fMe < 100 && currentTimeMillis - this.fMf < 500) {
                    this.fMh = true;
                } else {
                    this.fMh = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cuT - motionEvent.getY()) > 50.0f) {
                    this.fMh = false;
                    this.fMg = false;
                }
                if (this.fMh) {
                    if (this.nYI != null) {
                        this.nYI.y(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cuT - motionEvent.getY()) && this.nYI != null) {
                    this.nYI.bGz();
                }
                if (!this.fMh && this.fMg && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cuT - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.fMh && a.this.fMg && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cuT - motionEvent.getY()) < 30.0f && a.this.nYI != null) {
                                a.this.nYI.bGy();
                            }
                        }
                    }, 300L);
                }
                this.fMf = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0913a interfaceC0913a) {
        this.nYI = interfaceC0913a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
