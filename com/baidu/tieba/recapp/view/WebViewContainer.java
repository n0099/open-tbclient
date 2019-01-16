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
    private float gWO;
    private float gWP;
    private VelocityTracker gWQ;
    private OnScrollChangedCallback gWR;
    private int gWS;
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
        private final WebViewContainer gWT;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.gWT = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.gWT.gWP = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.gWT == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.gWT.topMargin > 0;
            } else if (this.gWT.topMargin < this.gWT.gWS) {
                return this.gWT.topMargin > 0 || this.gWT.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.topMargin = 0;
        this.gWS = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.topMargin = 0;
        this.gWS = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.topMargin = 0;
        this.gWS = 0;
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
            if (this.gWQ == null) {
                this.gWQ = VelocityTracker.obtain();
            }
            this.gWQ.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.gWQ.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.gWQ.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.topMargin < this.gWS) || (yVelocity < 0 && this.topMargin > 0))) {
                        uu(-yVelocity);
                    }
                    this.gWQ.recycle();
                    this.gWQ = null;
                    break;
                case 2:
                    this.gWO = motionEvent.getRawY();
                    int uv = uv((int) (this.gWP - this.gWO));
                    scrollBy(0, uv);
                    this.gWP -= uv;
                    break;
            }
            return true;
        }
        return false;
    }

    private void uu(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.gWP, 0, i, 0, 0, -500, 10000);
            invalidate();
        }
    }

    private int uv(int i) {
        int i2 = this.topMargin - i;
        if (i2 < 0) {
            int i3 = this.topMargin;
            this.topMargin = 0;
            return i3;
        } else if (i2 > this.gWS) {
            int i4 = this.topMargin - this.gWS;
            this.topMargin = this.gWS;
            return i4;
        } else {
            this.topMargin -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int uv = uv(this.mScroller.getCurrY());
            scrollBy(0, uv);
            this.gWP -= uv;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.gWR != null) {
            this.gWR.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.gWR = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.topMargin = i;
    }

    public void setTopLimit(int i) {
        this.gWS = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
