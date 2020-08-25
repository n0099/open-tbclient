package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
/* loaded from: classes20.dex */
public class WebViewContainer extends FrameLayout {
    private float lJD;
    private float lJE;
    private VelocityTracker lJF;
    private OnScrollChangedCallback lJG;
    private int lJH;
    private GestureDetector mGestureDetector;
    private OverScroller mScroller;
    private int mStyle;
    private int topMargin;

    /* loaded from: classes20.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        private final WebViewContainer lJI;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.lJI = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.lJI.lJE = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) <= Math.abs(f) || this.lJI == null) {
                return false;
            }
            if (f2 > 0.0f) {
                return this.lJI.topMargin > 0;
            } else if (this.lJI.topMargin < this.lJI.lJH) {
                return this.lJI.topMargin > 0 || this.lJI.mStyle != 1;
            } else {
                return false;
            }
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.topMargin = 0;
        this.lJH = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.topMargin = 0;
        this.lJH = 0;
        this.mStyle = 1;
        init(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.topMargin = 0;
        this.lJH = 0;
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
            if (this.lJF == null) {
                this.lJF = VelocityTracker.obtain();
            }
            this.lJF.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        break;
                    }
                    break;
                case 1:
                    this.lJF.computeCurrentVelocity(1000);
                    int yVelocity = (int) this.lJF.getYVelocity();
                    if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.topMargin < this.lJH) || (yVelocity < 0 && this.topMargin > 0))) {
                        Gy(-yVelocity);
                    }
                    this.lJF.recycle();
                    this.lJF = null;
                    break;
                case 2:
                    this.lJD = motionEvent.getRawY();
                    int Gz = Gz((int) (this.lJE - this.lJD));
                    scrollBy(0, Gz);
                    this.lJE -= Gz;
                    break;
            }
            return true;
        }
        return false;
    }

    private void Gy(int i) {
        if (this.mScroller != null) {
            this.mScroller.fling(0, (int) this.lJE, 0, i, 0, 0, AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL, 10000);
            invalidate();
        }
    }

    private int Gz(int i) {
        int i2 = this.topMargin - i;
        if (i2 < 0) {
            int i3 = this.topMargin;
            this.topMargin = 0;
            return i3;
        } else if (i2 > this.lJH) {
            int i4 = this.topMargin - this.lJH;
            this.topMargin = this.lJH;
            return i4;
        } else {
            this.topMargin -= i;
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int Gz = Gz(this.mScroller.getCurrY());
            scrollBy(0, Gz);
            this.lJE -= Gz;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.lJG != null) {
            this.lJG.onScroll(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.lJG = onScrollChangedCallback;
    }

    public void setTopMargin(int i) {
        this.topMargin = i;
    }

    public void setTopLimit(int i) {
        this.lJH = i;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }
}
