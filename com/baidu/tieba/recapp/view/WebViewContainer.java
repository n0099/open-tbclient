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
    private int FB;
    private float iPE;
    private float iPF;
    private VelocityTracker iPG;
    private OnScrollChangedCallback iPH;
    private int iPI;
    private GestureDetector mGestureDetector;
    private OverScroller mScroller;
    private int mStyle;

    /* loaded from: classes3.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        private final WebViewContainer iPJ;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.iPJ = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.iPJ.iPF = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.iPJ == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.iPJ.FB > 0;
            } else if (this.iPJ.FB < this.iPJ.iPI) {
                return this.iPJ.FB > 0 || this.iPJ.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.FB = 0;
        this.iPI = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FB = 0;
        this.iPI = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.FB = 0;
        this.iPI = 0;
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
        if (this.FB > ((int) motionEvent.getY()) || !this.mGestureDetector.onTouchEvent(motionEvent)) {
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
        if (this.FB <= ((int) motionEvent.getY())) {
            super.onTouchEvent(motionEvent);
            if (this.iPG == null) {
                this.iPG = VelocityTracker.obtain();
            }
            this.iPG.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.iPG.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.iPG.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.FB < this.iPI) || (yVelocity < 0 && this.FB > 0))) {
                        yC(-yVelocity);
                    }
                    this.iPG.recycle();
                    this.iPG = null;
                    break;
                case 2:
                    this.iPE = motionEvent.getRawY();
                    int yD = yD((int) (this.iPF - this.iPE));
                    scrollBy(0, yD);
                    this.iPF -= yD;
                    break;
            }
            return true;
        }
        return false;
    }

    private void yC(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.iPF, 0, i, 0, 0, -500, 10000);
            invalidate();
        }
    }

    private int yD(int i) {
        int i2 = this.FB - i;
        if (i2 < 0) {
            int i3 = this.FB;
            this.FB = 0;
            return i3;
        } else if (i2 > this.iPI) {
            int i4 = this.FB - this.iPI;
            this.FB = this.iPI;
            return i4;
        } else {
            this.FB -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int yD = yD(this.mScroller.getCurrY());
            scrollBy(0, yD);
            this.iPF -= yD;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.iPH != null) {
            this.iPH.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.iPH = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.FB = i;
    }

    public void setTopLimit(int i) {
        this.iPI = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
