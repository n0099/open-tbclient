package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
/* loaded from: classes3.dex */
public class WebViewContainer extends FrameLayout {
    private VelocityTracker gKA;
    private OnScrollChangedCallback gKB;
    private int gKC;
    private float gKy;
    private float gKz;
    private GestureDetector mGestureDetector;
    private OverScroller mScroller;
    private int mStyle;
    private int topMargin;

    /* loaded from: classes3.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        private final WebViewContainer gKD;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.gKD = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.gKD.gKz = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.gKD == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.gKD.topMargin > 0;
            } else if (this.gKD.topMargin < this.gKD.gKC) {
                return this.gKD.topMargin > 0 || this.gKD.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.topMargin = 0;
        this.gKC = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.topMargin = 0;
        this.gKC = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.topMargin = 0;
        this.gKC = 0;
        this.mStyle = 1;
        init(context);
    }

    private void init(Context context) {
        this.mScroller = new OverScroller(context);
        this.mGestureDetector = new GestureDetector(context, new YScrollDetector(this));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mStyle == 2) {
            return false;
        }
        if (this.topMargin > ((int) motionEvent.getY()) || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mStyle == 2) {
            return false;
        }
        if (this.topMargin <= ((int) motionEvent.getY())) {
            super.onTouchEvent(motionEvent);
            if (this.gKA == null) {
                this.gKA = VelocityTracker.obtain();
            }
            this.gKA.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.gKA.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.gKA.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.topMargin < this.gKC) || (yVelocity < 0 && this.topMargin > 0))) {
                        tr(-yVelocity);
                    }
                    this.gKA.recycle();
                    this.gKA = null;
                    break;
                case 2:
                    this.gKy = motionEvent.getRawY();
                    int ts = ts((int) (this.gKz - this.gKy));
                    scrollBy(0, ts);
                    this.gKz -= ts;
                    break;
            }
            return true;
        }
        return false;
    }

    private void tr(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.gKz, 0, i, 0, 0, -500, 10000);
            invalidate();
        }
    }

    private int ts(int i) {
        int i2 = this.topMargin - i;
        if (i2 < 0) {
            int i3 = this.topMargin;
            this.topMargin = 0;
            return i3;
        } else if (i2 > this.gKC) {
            int i4 = this.topMargin - this.gKC;
            this.topMargin = this.gKC;
            return i4;
        } else {
            this.topMargin -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int ts = ts(this.mScroller.getCurrY());
            scrollBy(0, ts);
            this.gKz -= ts;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.gKB != null) {
            this.gKB.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.gKB = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.topMargin = i;
    }

    public void setTopLimit(int i) {
        this.gKC = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
