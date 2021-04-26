package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
/* loaded from: classes5.dex */
public class WebViewContainer extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public OverScroller f21129e;

    /* renamed from: f  reason: collision with root package name */
    public float f21130f;

    /* renamed from: g  reason: collision with root package name */
    public float f21131g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector f21132h;

    /* renamed from: i  reason: collision with root package name */
    public VelocityTracker f21133i;
    public OnScrollChangedCallback j;
    public int k;
    public int l;
    public int m;

    /* loaded from: classes5.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i2, int i3);
    }

    /* loaded from: classes5.dex */
    public static class YScrollDetector extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public final WebViewContainer f21134e;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.f21134e = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.f21134e.f21131g = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            WebViewContainer webViewContainer;
            if (Math.abs(f3) > Math.abs(f2) && (webViewContainer = this.f21134e) != null) {
                if (f3 > 0.0f) {
                    return webViewContainer.k > 0;
                } else if (webViewContainer.k < this.f21134e.l) {
                    return this.f21134e.k > 0 || this.f21134e.m != 1;
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
        if (this.f21129e.computeScrollOffset()) {
            int e2 = e(this.f21129e.getCurrY());
            scrollBy(0, e2);
            this.f21131g -= e2;
            invalidate();
        }
    }

    public final int e(int i2) {
        int i3 = this.k;
        int i4 = i3 - i2;
        if (i4 < 0) {
            this.k = 0;
            return i3;
        }
        int i5 = this.l;
        if (i4 > i5) {
            int i6 = i3 - i5;
            this.k = i5;
            return i6;
        }
        this.k = i3 - i2;
        return i2;
    }

    public final void f(int i2) {
        OverScroller overScroller = this.f21129e;
        if (overScroller == null) {
            return;
        }
        overScroller.fling(0, (int) this.f21131g, 0, i2, 0, 0, AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL, 10000);
        invalidate();
    }

    public final void g(Context context) {
        this.f21129e = new OverScroller(context);
        this.f21132h = new GestureDetector(context, new YScrollDetector(this));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.m == 2) {
            return false;
        }
        if (this.k <= ((int) motionEvent.getY()) && this.f21132h.onTouchEvent(motionEvent)) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        OnScrollChangedCallback onScrollChangedCallback = this.j;
        if (onScrollChangedCallback != null) {
            onScrollChangedCallback.onScroll(i2 - i4, i3 - i5);
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
        if (this.f21133i == null) {
            this.f21133i = VelocityTracker.obtain();
        }
        this.f21133i.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f21133i.computeCurrentVelocity(1000);
                int yVelocity = (int) this.f21133i.getYVelocity();
                if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.k < this.l) || (yVelocity < 0 && this.k > 0))) {
                    f(-yVelocity);
                }
                this.f21133i.recycle();
                this.f21133i = null;
            } else if (action == 2) {
                float rawY = motionEvent.getRawY();
                this.f21130f = rawY;
                int e2 = e((int) (this.f21131g - rawY));
                scrollBy(0, e2);
                this.f21131g -= e2;
            }
        } else if (!this.f21129e.isFinished()) {
            this.f21129e.abortAnimation();
        }
        return true;
    }

    public void setOnScrollChangeListener(OnScrollChangedCallback onScrollChangedCallback) {
        this.j = onScrollChangedCallback;
    }

    public void setStyle(int i2) {
        this.m = i2;
    }

    public void setTopLimit(int i2) {
        this.l = i2;
    }

    public void setTopMargin(int i2) {
        this.k = i2;
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0;
        this.l = 0;
        this.m = 1;
        g(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = 0;
        this.l = 0;
        this.m = 1;
        g(context);
    }
}
