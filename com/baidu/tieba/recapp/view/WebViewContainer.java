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
    private int VM;
    private float iQI;
    private float iQJ;
    private VelocityTracker iQK;
    private OnScrollChangedCallback iQL;
    private int iQM;
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
        private final WebViewContainer iQN;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.iQN = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.iQN.iQJ = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.iQN == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.iQN.VM > 0;
            } else if (this.iQN.VM < this.iQN.iQM) {
                return this.iQN.VM > 0 || this.iQN.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.VM = 0;
        this.iQM = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VM = 0;
        this.iQM = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.VM = 0;
        this.iQM = 0;
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
        if (this.VM > ((int) motionEvent.getY()) || !this.mGestureDetector.onTouchEvent(motionEvent)) {
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
        if (this.VM <= ((int) motionEvent.getY())) {
            super.onTouchEvent(motionEvent);
            if (this.iQK == null) {
                this.iQK = VelocityTracker.obtain();
            }
            this.iQK.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.iQK.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.iQK.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.VM < this.iQM) || (yVelocity < 0 && this.VM > 0))) {
                        zW(-yVelocity);
                    }
                    this.iQK.recycle();
                    this.iQK = null;
                    break;
                case 2:
                    this.iQI = motionEvent.getRawY();
                    int zX = zX((int) (this.iQJ - this.iQI));
                    scrollBy(0, zX);
                    this.iQJ -= zX;
                    break;
            }
            return true;
        }
        return false;
    }

    private void zW(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.iQJ, 0, i, 0, 0, -500, 10000);
            invalidate();
        }
    }

    private int zX(int i) {
        int i2 = this.VM - i;
        if (i2 < 0) {
            int i3 = this.VM;
            this.VM = 0;
            return i3;
        } else if (i2 > this.iQM) {
            int i4 = this.VM - this.iQM;
            this.VM = this.iQM;
            return i4;
        } else {
            this.VM -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int zX = zX(this.mScroller.getCurrY());
            scrollBy(0, zX);
            this.iQJ -= zX;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.iQL != null) {
            this.iQL.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.iQL = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.VM = i;
    }

    public void setTopLimit(int i) {
        this.iQM = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
