package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
/* loaded from: classes4.dex */
public class WebViewContainer extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public OverScroller f20572e;

    /* renamed from: f  reason: collision with root package name */
    public float f20573f;

    /* renamed from: g  reason: collision with root package name */
    public float f20574g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector f20575h;
    public VelocityTracker i;
    public OnScrollChangedCallback j;
    public int k;
    public int l;
    public int m;

    /* loaded from: classes4.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2);
    }

    /* loaded from: classes4.dex */
    public static class YScrollDetector extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public final WebViewContainer f20576e;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.f20576e = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.f20576e.f20574g = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            WebViewContainer webViewContainer;
            if (Math.abs(f3) > Math.abs(f2) && (webViewContainer = this.f20576e) != null) {
                if (f3 > 0.0f) {
                    return webViewContainer.k > 0;
                } else if (webViewContainer.k < this.f20576e.l) {
                    return this.f20576e.k > 0 || this.f20576e.m != 1;
                }
            }
            return false;
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.k = 0;
        this.l = 0;
        this.m = 1;
        g(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f20572e.computeScrollOffset()) {
            int e2 = e(this.f20572e.getCurrY());
            scrollBy(0, e2);
            this.f20574g -= e2;
            invalidate();
        }
    }

    public final int e(int i) {
        int i2 = this.k;
        int i3 = i2 - i;
        if (i3 < 0) {
            this.k = 0;
            return i2;
        }
        int i4 = this.l;
        if (i3 > i4) {
            int i5 = i2 - i4;
            this.k = i4;
            return i5;
        }
        this.k = i2 - i;
        return i;
    }

    public final void f(int i) {
        OverScroller overScroller = this.f20572e;
        if (overScroller == null) {
            return;
        }
        overScroller.fling(0, (int) this.f20574g, 0, i, 0, 0, AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL, 10000);
        invalidate();
    }

    public final void g(Context context) {
        this.f20572e = new OverScroller(context);
        this.f20575h = new GestureDetector(context, new YScrollDetector(this));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.m == 2) {
            return false;
        }
        if (this.k <= ((int) motionEvent.getY()) && this.f20575h.onTouchEvent(motionEvent)) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangedCallback onScrollChangedCallback = this.j;
        if (onScrollChangedCallback != null) {
            onScrollChangedCallback.onScroll(i - i3, i2 - i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.m == 2) {
            return false;
        }
        if (this.k > ((int) motionEvent.getY())) {
            return false;
        }
        super.onTouchEvent(motionEvent);
        if (this.i == null) {
            this.i = VelocityTracker.obtain();
        }
        this.i.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.i.computeCurrentVelocity(1000);
                int yVelocity = (int) this.i.getYVelocity();
                if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.k < this.l) || (yVelocity < 0 && this.k > 0))) {
                    f(-yVelocity);
                }
                this.i.recycle();
                this.i = null;
            } else if (action == 2) {
                float rawY = motionEvent.getRawY();
                this.f20573f = rawY;
                int e2 = e((int) (this.f20574g - rawY));
                scrollBy(0, e2);
                this.f20574g -= e2;
            }
        } else if (!this.f20572e.isFinished()) {
            this.f20572e.abortAnimation();
        }
        return true;
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.j = onScrollChangedCallback;
    }

    public void setStyle(int i) {
        this.m = i;
    }

    public void setTopLimit(int i) {
        this.l = i;
    }

    public void setTopMargin(int i) {
        this.k = i;
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0;
        this.l = 0;
        this.m = 1;
        g(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 0;
        this.l = 0;
        this.m = 1;
        g(context);
    }
}
