package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
/* loaded from: classes13.dex */
public class WebViewContainer extends FrameLayout {
    private VelocityTracker jPA;
    private OnScrollChangedCallback jPB;
    private int jPC;
    private float jPy;
    private float jPz;
    private GestureDetector mGestureDetector;
    private OverScroller mScroller;
    private int mStyle;
    private int topMargin;

    /* loaded from: classes13.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        private final WebViewContainer jPD;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.jPD = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.jPD.jPz = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.jPD == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.jPD.topMargin > 0;
            } else if (this.jPD.topMargin < this.jPD.jPC) {
                return this.jPD.topMargin > 0 || this.jPD.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.topMargin = 0;
        this.jPC = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.topMargin = 0;
        this.jPC = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.topMargin = 0;
        this.jPC = 0;
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
            if (this.jPA == null) {
                this.jPA = VelocityTracker.obtain();
            }
            this.jPA.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.jPA.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.jPA.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.topMargin < this.jPC) || (yVelocity < 0 && this.topMargin > 0))) {
                        Bt(-yVelocity);
                    }
                    this.jPA.recycle();
                    this.jPA = null;
                    break;
                case 2:
                    this.jPy = motionEvent.getRawY();
                    int Bu = Bu((int) (this.jPz - this.jPy));
                    scrollBy(0, Bu);
                    this.jPz -= Bu;
                    break;
            }
            return true;
        }
        return false;
    }

    private void Bt(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.jPz, 0, i, 0, 0, -500, 10000);
            invalidate();
        }
    }

    private int Bu(int i) {
        int i2 = this.topMargin - i;
        if (i2 < 0) {
            int i3 = this.topMargin;
            this.topMargin = 0;
            return i3;
        } else if (i2 > this.jPC) {
            int i4 = this.topMargin - this.jPC;
            this.topMargin = this.jPC;
            return i4;
        } else {
            this.topMargin -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int Bu = Bu(this.mScroller.getCurrY());
            scrollBy(0, Bu);
            this.jPz -= Bu;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.jPB != null) {
            this.jPB.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.jPB = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.topMargin = i;
    }

    public void setTopLimit(int i) {
        this.jPC = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
