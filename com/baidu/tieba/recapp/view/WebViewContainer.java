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
    private int Fb;
    private float iON;
    private float iOO;
    private VelocityTracker iOP;
    private OnScrollChangedCallback iOQ;
    private int iOR;
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
        private final WebViewContainer iOS;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.iOS = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.iOS.iOO = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.iOS == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.iOS.Fb > 0;
            } else if (this.iOS.Fb < this.iOS.iOR) {
                return this.iOS.Fb > 0 || this.iOS.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.Fb = 0;
        this.iOR = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fb = 0;
        this.iOR = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Fb = 0;
        this.iOR = 0;
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
        if (this.Fb > ((int) motionEvent.getY()) || !this.mGestureDetector.onTouchEvent(motionEvent)) {
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
        if (this.Fb <= ((int) motionEvent.getY())) {
            super.onTouchEvent(motionEvent);
            if (this.iOP == null) {
                this.iOP = VelocityTracker.obtain();
            }
            this.iOP.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.iOP.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.iOP.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.Fb < this.iOR) || (yVelocity < 0 && this.Fb > 0))) {
                        yB(-yVelocity);
                    }
                    this.iOP.recycle();
                    this.iOP = null;
                    break;
                case 2:
                    this.iON = motionEvent.getRawY();
                    int yC = yC((int) (this.iOO - this.iON));
                    scrollBy(0, yC);
                    this.iOO -= yC;
                    break;
            }
            return true;
        }
        return false;
    }

    private void yB(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.iOO, 0, i, 0, 0, -500, 10000);
            invalidate();
        }
    }

    private int yC(int i) {
        int i2 = this.Fb - i;
        if (i2 < 0) {
            int i3 = this.Fb;
            this.Fb = 0;
            return i3;
        } else if (i2 > this.iOR) {
            int i4 = this.Fb - this.iOR;
            this.Fb = this.iOR;
            return i4;
        } else {
            this.Fb -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int yC = yC(this.mScroller.getCurrY());
            scrollBy(0, yC);
            this.iOO -= yC;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.iOQ != null) {
            this.iOQ.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.iOQ = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.Fb = i;
    }

    public void setTopLimit(int i) {
        this.iOR = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
