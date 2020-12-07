package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
/* loaded from: classes26.dex */
public class WebViewContainer extends FrameLayout {
    private int agU;
    private GestureDetector mGestureDetector;
    private float mPp;
    private float mPq;
    private VelocityTracker mPr;
    private OnScrollChangedCallback mPs;
    private int mPt;
    private OverScroller mScroller;
    private int mStyle;

    /* loaded from: classes26.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        private final WebViewContainer mPu;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.mPu = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.mPu.mPq = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.mPu == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.mPu.agU > 0;
            } else if (this.mPu.agU < this.mPu.mPt) {
                return this.mPu.agU > 0 || this.mPu.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.agU = 0;
        this.mPt = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agU = 0;
        this.mPt = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agU = 0;
        this.mPt = 0;
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
        if (this.agU > ((int) motionEvent.getY()) || !this.mGestureDetector.onTouchEvent(motionEvent)) {
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
        if (this.agU <= ((int) motionEvent.getY())) {
            super.onTouchEvent(motionEvent);
            if (this.mPr == null) {
                this.mPr = VelocityTracker.obtain();
            }
            this.mPr.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.mPr.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.mPr.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.agU < this.mPt) || (yVelocity < 0 && this.agU > 0))) {
                        JD(-yVelocity);
                    }
                    this.mPr.recycle();
                    this.mPr = null;
                    break;
                case 2:
                    this.mPp = motionEvent.getRawY();
                    int JE = JE((int) (this.mPq - this.mPp));
                    scrollBy(0, JE);
                    this.mPq -= JE;
                    break;
            }
            return true;
        }
        return false;
    }

    private void JD(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.mPq, 0, i, 0, 0, AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL, 10000);
            invalidate();
        }
    }

    private int JE(int i) {
        int i2 = this.agU - i;
        if (i2 < 0) {
            int i3 = this.agU;
            this.agU = 0;
            return i3;
        } else if (i2 > this.mPt) {
            int i4 = this.agU - this.mPt;
            this.agU = this.mPt;
            return i4;
        } else {
            this.agU -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int JE = JE(this.mScroller.getCurrY());
            scrollBy(0, JE);
            this.mPq -= JE;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mPs != null) {
            this.mPs.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.mPs = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.agU = i;
    }

    public void setTopLimit(int i) {
        this.mPt = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
