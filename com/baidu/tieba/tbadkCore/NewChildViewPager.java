package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class NewChildViewPager extends ViewPager {
    private b bdT;
    private boolean dyh;
    private boolean dyi;
    private float dyj;
    private float dyk;
    private Runnable dyl;
    private c dym;
    private boolean mIsBeingDragged;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface b {
        void gh(int i);
    }

    public NewChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dyh = false;
        initView();
    }

    public NewChildViewPager(Context context) {
        super(context);
        this.dyh = false;
        initView();
    }

    private void initView() {
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (h(motionEvent)) {
            return true;
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                requestParentDisallowInterceptTouchEvent(true);
                this.dyj = motionEvent.getX();
                this.dyk = motionEvent.getY();
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                requestParentDisallowInterceptTouchEvent(true);
                this.dyj = motionEvent.getX();
                this.dyk = motionEvent.getY();
                if (this.dyl == null) {
                    this.dyl = new a();
                }
                postDelayed(this.dyl, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                aCr();
                if (!this.mIsBeingDragged) {
                    setPressed(true);
                    if (this.dym == null) {
                        this.dym = new c();
                    }
                    this.dym.position = getCurrentItem();
                    postDelayed(this.dym, ViewConfiguration.getPressedStateDuration());
                }
                this.mIsBeingDragged = false;
                this.dyi = false;
                break;
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = x - this.dyj;
                float f2 = y - this.dyk;
                float abs = Math.abs(f);
                float abs2 = Math.abs(f2);
                int currentItem = getCurrentItem();
                int count = getAdapter().getCount();
                if (((currentItem == 0 && f > this.mTouchSlop) || (currentItem == count - 1 && f < (-this.mTouchSlop))) && this.dyh) {
                    requestParentDisallowInterceptTouchEvent(false);
                }
                if (abs > this.mTouchSlop) {
                    this.dyi = true;
                }
                if (!this.dyi && abs2 > this.mTouchSlop) {
                    requestParentDisallowInterceptTouchEvent(false);
                }
                if (!this.mIsBeingDragged && (abs > this.mTouchSlop || abs2 > this.mTouchSlop)) {
                    aCr();
                    setPressed(false);
                    this.mIsBeingDragged = true;
                    break;
                }
                break;
            case 3:
                aCr();
                if (!this.mIsBeingDragged) {
                    setPressed(false);
                }
                this.mIsBeingDragged = false;
                this.dyi = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aCr() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.dyl);
        }
    }

    private boolean h(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void mr(int i) {
        if (this.bdT != null) {
            this.bdT.gh(i);
        }
    }

    public b getOnItemClickListener() {
        return this.bdT;
    }

    public void setOnItemClickListener(b bVar) {
        this.bdT = bVar;
    }

    public void setAllowParentIntercept(boolean z) {
        this.dyh = z;
    }

    /* loaded from: classes.dex */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NewChildViewPager.this.setPressed(true);
        }
    }

    /* loaded from: classes.dex */
    final class c implements Runnable {
        public int position;

        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NewChildViewPager.this.setPressed(false);
            NewChildViewPager.this.mr(this.position);
        }
    }
}
