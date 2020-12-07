package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class a {
    private float cBL;
    private long fTP;
    private long fTQ;
    private boolean fTR;
    private boolean fTS;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;
    private InterfaceC0930a onI;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.livepager.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0930a {
        void bJY();

        void bJZ();

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
                this.cBL = motionEvent.getY();
                this.fTP = System.currentTimeMillis();
                this.fTR = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fTP < 100 && currentTimeMillis - this.fTQ < 500) {
                    this.fTS = true;
                } else {
                    this.fTS = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cBL - motionEvent.getY()) > 50.0f) {
                    this.fTS = false;
                    this.fTR = false;
                }
                if (this.fTS) {
                    if (this.onI != null) {
                        this.onI.y(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cBL - motionEvent.getY()) && this.onI != null) {
                    this.onI.bJZ();
                }
                if (!this.fTS && this.fTR && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cBL - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.fTS && a.this.fTR && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cBL - motionEvent.getY()) < 30.0f && a.this.onI != null) {
                                a.this.onI.bJY();
                            }
                        }
                    }, 300L);
                }
                this.fTQ = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0930a interfaceC0930a) {
        this.onI = interfaceC0930a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
