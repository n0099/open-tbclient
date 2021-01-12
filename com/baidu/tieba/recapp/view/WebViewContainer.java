package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
/* loaded from: classes7.dex */
public class WebViewContainer extends FrameLayout {
    private int agC;
    private GestureDetector mGestureDetector;
    private float mPT;
    private float mPU;
    private VelocityTracker mPV;
    private OnScrollChangedCallback mPW;
    private int mPX;
    private OverScroller mScroller;
    private int mStyle;

    /* loaded from: classes7.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        private final WebViewContainer mPY;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.mPY = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.mPY.mPU = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.mPY == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.mPY.agC > 0;
            } else if (this.mPY.agC < this.mPY.mPX) {
                return this.mPY.agC > 0 || this.mPY.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.agC = 0;
        this.mPX = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agC = 0;
        this.mPX = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agC = 0;
        this.mPX = 0;
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
        if (this.agC > ((int) motionEvent.getY()) || !this.mGestureDetector.onTouchEvent(motionEvent)) {
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
        if (this.agC <= ((int) motionEvent.getY())) {
            super.onTouchEvent(motionEvent);
            if (this.mPV == null) {
                this.mPV = VelocityTracker.obtain();
            }
            this.mPV.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.mPV.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.mPV.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.agC < this.mPX) || (yVelocity < 0 && this.agC > 0))) {
                        HQ(-yVelocity);
                    }
                    this.mPV.recycle();
                    this.mPV = null;
                    break;
                case 2:
                    this.mPT = motionEvent.getRawY();
                    int HR = HR((int) (this.mPU - this.mPT));
                    scrollBy(0, HR);
                    this.mPU -= HR;
                    break;
            }
            return true;
        }
        return false;
    }

    private void HQ(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.mPU, 0, i, 0, 0, AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL, 10000);
            invalidate();
        }
    }

    private int HR(int i) {
        int i2 = this.agC - i;
        if (i2 < 0) {
            int i3 = this.agC;
            this.agC = 0;
            return i3;
        } else if (i2 > this.mPX) {
            int i4 = this.agC - this.mPX;
            this.agC = this.mPX;
            return i4;
        } else {
            this.agC -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int HR = HR(this.mScroller.getCurrY());
            scrollBy(0, HR);
            this.mPU -= HR;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mPW != null) {
            this.mPW.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.mPW = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.agC = i;
    }

    public void setTopLimit(int i) {
        this.mPX = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
