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
    private float iOm;
    private float iOn;
    private VelocityTracker iOo;
    private OnScrollChangedCallback iOp;
    private int iOq;
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
        private final WebViewContainer iOr;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.iOr = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.iOr.iOn = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.iOr == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.iOr.VN > 0;
            } else if (this.iOr.VN < this.iOr.iOq) {
                return this.iOr.VN > 0 || this.iOr.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.VN = 0;
        this.iOq = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VN = 0;
        this.iOq = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.VN = 0;
        this.iOq = 0;
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
            if (this.iOo == null) {
                this.iOo = VelocityTracker.obtain();
            }
            this.iOo.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.iOo.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.iOo.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.VN < this.iOq) || (yVelocity < 0 && this.VN > 0))) {
                        zT(-yVelocity);
                    }
                    this.iOo.recycle();
                    this.iOo = null;
                    break;
                case 2:
                    this.iOm = motionEvent.getRawY();
                    int zU = zU((int) (this.iOn - this.iOm));
                    scrollBy(0, zU);
                    this.iOn -= zU;
                    break;
            }
            return true;
        }
        return false;
    }

    private void zT(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.iOn, 0, i, 0, 0, -500, 10000);
            invalidate();
        }
    }

    private int zU(int i) {
        int i2 = this.VN - i;
        if (i2 < 0) {
            int i3 = this.VN;
            this.VN = 0;
            return i3;
        } else if (i2 > this.iOq) {
            int i4 = this.VN - this.iOq;
            this.VN = this.iOq;
            return i4;
        } else {
            this.VN -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int zU = zU(this.mScroller.getCurrY());
            scrollBy(0, zU);
            this.iOn -= zU;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.iOp != null) {
            this.iOp.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.iOp = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.VN = i;
    }

    public void setTopLimit(int i) {
        this.iOq = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
