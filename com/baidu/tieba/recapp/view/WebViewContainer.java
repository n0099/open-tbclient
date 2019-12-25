package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
/* loaded from: classes10.dex */
public class WebViewContainer extends FrameLayout {
    private int JM;
    private float jJb;
    private float jJc;
    private VelocityTracker jJd;
    private OnScrollChangedCallback jJe;
    private int jJf;
    private GestureDetector mGestureDetector;
    private OverScroller mScroller;
    private int mStyle;

    /* loaded from: classes10.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        private final WebViewContainer jJg;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.jJg = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.jJg.jJc = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.jJg == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.jJg.JM > 0;
            } else if (this.jJg.JM < this.jJg.jJf) {
                return this.jJg.JM > 0 || this.jJg.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.JM = 0;
        this.jJf = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.JM = 0;
        this.jJf = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.JM = 0;
        this.jJf = 0;
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
        if (this.JM > ((int) motionEvent.getY()) || !this.mGestureDetector.onTouchEvent(motionEvent)) {
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
        if (this.JM <= ((int) motionEvent.getY())) {
            super.onTouchEvent(motionEvent);
            if (this.jJd == null) {
                this.jJd = VelocityTracker.obtain();
            }
            this.jJd.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.jJd.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.jJd.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.JM < this.jJf) || (yVelocity < 0 && this.JM > 0))) {
                        AX(-yVelocity);
                    }
                    this.jJd.recycle();
                    this.jJd = null;
                    break;
                case 2:
                    this.jJb = motionEvent.getRawY();
                    int AY = AY((int) (this.jJc - this.jJb));
                    scrollBy(0, AY);
                    this.jJc -= AY;
                    break;
            }
            return true;
        }
        return false;
    }

    private void AX(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.jJc, 0, i, 0, 0, -500, 10000);
            invalidate();
        }
    }

    private int AY(int i) {
        int i2 = this.JM - i;
        if (i2 < 0) {
            int i3 = this.JM;
            this.JM = 0;
            return i3;
        } else if (i2 > this.jJf) {
            int i4 = this.JM - this.jJf;
            this.JM = this.jJf;
            return i4;
        } else {
            this.JM -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int AY = AY(this.mScroller.getCurrY());
            scrollBy(0, AY);
            this.jJc -= AY;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.jJe != null) {
            this.jJe.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.jJe = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.JM = i;
    }

    public void setTopLimit(int i) {
        this.jJf = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
