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
    public OverScroller f20295e;

    /* renamed from: f  reason: collision with root package name */
    public float f20296f;

    /* renamed from: g  reason: collision with root package name */
    public float f20297g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector f20298h;

    /* renamed from: i  reason: collision with root package name */
    public VelocityTracker f20299i;
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
        public final WebViewContainer f20300e;

        public YScrollDetector(WebViewContainer webViewContainer) {
            this.f20300e = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.f20300e.f20297g = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            WebViewContainer webViewContainer;
            if (Math.abs(f3) > Math.abs(f2) && (webViewContainer = this.f20300e) != null) {
                if (f3 > 0.0f) {
                    return webViewContainer.k > 0;
                } else if (webViewContainer.k < this.f20300e.l) {
                    return this.f20300e.k > 0 || this.f20300e.m != 1;
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
        if (this.f20295e.computeScrollOffset()) {
            int e2 = e(this.f20295e.getCurrY());
            scrollBy(0, e2);
            this.f20297g -= e2;
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
        OverScroller overScroller = this.f20295e;
        if (overScroller == null) {
            return;
        }
        overScroller.fling(0, (int) this.f20297g, 0, i2, 0, 0, AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL, 10000);
        invalidate();
    }

    public final void g(Context context) {
        this.f20295e = new OverScroller(context);
        this.f20298h = new GestureDetector(context, new YScrollDetector(this));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.m == 2) {
            return false;
        }
        if (this.k <= ((int) motionEvent.getY()) && this.f20298h.onTouchEvent(motionEvent)) {
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
        if (this.f20299i == null) {
            this.f20299i = VelocityTracker.obtain();
        }
        this.f20299i.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f20299i.computeCurrentVelocity(1000);
                int yVelocity = (int) this.f20299i.getYVelocity();
                if (Math.abs(yVelocity) > 2000 && ((yVelocity > 0 && this.k < this.l) || (yVelocity < 0 && this.k > 0))) {
                    f(-yVelocity);
                }
                this.f20299i.recycle();
                this.f20299i = null;
            } else if (action == 2) {
                float rawY = motionEvent.getRawY();
                this.f20296f = rawY;
                int e2 = e((int) (this.f20297g - rawY));
                scrollBy(0, e2);
                this.f20297g -= e2;
            }
        } else if (!this.f20295e.isFinished()) {
            this.f20295e.abortAnimation();
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
