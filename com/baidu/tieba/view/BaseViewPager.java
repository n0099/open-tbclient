package com.baidu.tieba.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class BaseViewPager extends ViewPager implements GestureDetector.OnGestureListener {
    public static final int SCROLL_NEXT = 0;
    public static final int SCROLL_PRE = 1;
    GestureDetector mGestureDetector;
    OnScrollOutListener mOnScrollOutListener;

    /* loaded from: classes.dex */
    public interface OnScrollOutListener {
        void onScrollOut(int i);
    }

    public BaseViewPager(Context context) {
        super(context);
        this.mGestureDetector = null;
        this.mOnScrollOutListener = null;
        init();
    }

    public BaseViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mGestureDetector = null;
        this.mOnScrollOutListener = null;
        init();
    }

    public void setOnScrollOutListener(OnScrollOutListener listener) {
        this.mOnScrollOutListener = listener;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mGestureDetector == null || getAdapter() == null || getAdapter().getCount() == 0 || (getCurrentItem() != 0 && getAdapter().getCount() != getCurrentItem() + 1)) {
            return super.onTouchEvent(event);
        }
        this.mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private void init() {
        this.mGestureDetector = new GestureDetector(this);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent arg0) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
        if (this.mOnScrollOutListener != null) {
            if (arg2 < 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.mOnScrollOutListener.onScrollOut(0);
                return true;
            } else if (arg2 > 0.0f && getCurrentItem() == 0) {
                this.mOnScrollOutListener.onScrollOut(1);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent arg0) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent arg0) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent arg0) {
        return false;
    }
}
