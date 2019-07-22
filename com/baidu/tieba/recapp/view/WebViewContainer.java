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
    private int VN;
    private float iNi;
    private float iNj;
    private VelocityTracker iNk;
    private OnScrollChangedCallback iNl;
    private int iNm;
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
        private final WebViewContainer iNn;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.iNn = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.iNn.iNj = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.iNn == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.iNn.VN > 0;
            } else if (this.iNn.VN < this.iNn.iNm) {
                return this.iNn.VN > 0 || this.iNn.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.VN = 0;
        this.iNm = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VN = 0;
        this.iNm = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.VN = 0;
        this.iNm = 0;
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
        if (this.VN > ((int) motionEvent.getY()) || !this.mGestureDetector.onTouchEvent(motionEvent)) {
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
        if (this.VN <= ((int) motionEvent.getY())) {
            super.onTouchEvent(motionEvent);
            if (this.iNk == null) {
                this.iNk = VelocityTracker.obtain();
            }
            this.iNk.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.iNk.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.iNk.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.VN < this.iNm) || (yVelocity < 0 && this.VN > 0))) {
                        zR(-yVelocity);
                    }
                    this.iNk.recycle();
                    this.iNk = null;
                    break;
                case 2:
                    this.iNi = motionEvent.getRawY();
                    int zS = zS((int) (this.iNj - this.iNi));
                    scrollBy(0, zS);
                    this.iNj -= zS;
                    break;
            }
            return true;
        }
        return false;
    }

    private void zR(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.iNj, 0, i, 0, 0, -500, 10000);
            invalidate();
        }
    }

    private int zS(int i) {
        int i2 = this.VN - i;
        if (i2 < 0) {
            int i3 = this.VN;
            this.VN = 0;
            return i3;
        } else if (i2 > this.iNm) {
            int i4 = this.VN - this.iNm;
            this.VN = this.iNm;
            return i4;
        } else {
            this.VN -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int zS = zS(this.mScroller.getCurrY());
            scrollBy(0, zS);
            this.iNj -= zS;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.iNl != null) {
            this.iNl.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.iNl = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.VN = i;
    }

    public void setTopLimit(int i) {
        this.iNm = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
