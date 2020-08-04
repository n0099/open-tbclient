package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
/* loaded from: classes20.dex */
public class WebViewContainer extends FrameLayout {
    private float lti;
    private float ltj;
    private VelocityTracker ltk;
    private OnScrollChangedCallback ltl;
    private int ltm;
    private GestureDetector mGestureDetector;
    private OverScroller mScroller;
    private int mStyle;
    private int topMargin;

    /* loaded from: classes20.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        private final WebViewContainer ltn;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.ltn = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.ltn.ltj = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.ltn == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.ltn.topMargin > 0;
            } else if (this.ltn.topMargin < this.ltn.ltm) {
                return this.ltn.topMargin > 0 || this.ltn.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.topMargin = 0;
        this.ltm = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.topMargin = 0;
        this.ltm = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.topMargin = 0;
        this.ltm = 0;
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
            if (this.ltk == null) {
                this.ltk = VelocityTracker.obtain();
            }
            this.ltk.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.ltk.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.ltk.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.topMargin < this.ltm) || (yVelocity < 0 && this.topMargin > 0))) {
                        Ed(-yVelocity);
                    }
                    this.ltk.recycle();
                    this.ltk = null;
                    break;
                case 2:
                    this.lti = motionEvent.getRawY();
                    int Ee = Ee((int) (this.ltj - this.lti));
                    scrollBy(0, Ee);
                    this.ltj -= Ee;
                    break;
            }
            return true;
        }
        return false;
    }

    private void Ed(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.ltj, 0, i, 0, 0, -500, 10000);
            invalidate();
        }
    }

    private int Ee(int i) {
        int i2 = this.topMargin - i;
        if (i2 < 0) {
            int i3 = this.topMargin;
            this.topMargin = 0;
            return i3;
        } else if (i2 > this.ltm) {
            int i4 = this.topMargin - this.ltm;
            this.topMargin = this.ltm;
            return i4;
        } else {
            this.topMargin -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int Ee = Ee(this.mScroller.getCurrY());
            scrollBy(0, Ee);
            this.ltj -= Ee;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.ltl != null) {
            this.ltl.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.ltl = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.topMargin = i;
    }

    public void setTopLimit(int i) {
        this.ltm = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
