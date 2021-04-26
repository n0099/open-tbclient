package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f22047e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22048f;

    /* renamed from: g  reason: collision with root package name */
    public float f22049g;

    /* renamed from: h  reason: collision with root package name */
    public float f22050h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22051i;

    /* loaded from: classes5.dex */
    public interface a {
        boolean a(float f2, float f3, int i2);

        void b();

        void c(float f2);

        void d(float f2, float f3, int i2);
    }

    public ExpandViewRelativeLayout(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f22051i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f22049g = motionEvent.getY();
            this.f22050h = motionEvent.getY();
            a aVar = this.f22047e;
            if (aVar != null) {
                aVar.c(motionEvent.getY());
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && this.f22047e != null) {
                this.f22049g = motionEvent.getY();
                boolean a2 = this.f22047e.a(motionEvent.getY() - this.f22049g, motionEvent.getY(), motionEvent.getY() - this.f22050h > 0.0f ? 1 : 2);
                this.f22048f = a2;
                return a2;
            }
        } else {
            a aVar = this.f22047e;
            if (aVar != null) {
                boolean a3 = aVar.a(0.0f, motionEvent.getY(), 0);
                this.f22048f = a3;
                return a3;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f22051i) {
            super.onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY() - this.f22049g;
                int i2 = motionEvent.getY() - this.f22050h > 0.0f ? 1 : 2;
                if (this.f22048f && (aVar = this.f22047e) != null) {
                    aVar.d(motionEvent.getY(), y, i2);
                    return true;
                }
            }
        } else {
            this.f22048f = false;
            a aVar2 = this.f22047e;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }

    public void setIsCanLayout(boolean z) {
        this.f22051i = z;
    }

    public void setScrollCallBack(a aVar) {
        this.f22047e = aVar;
    }

    public ExpandViewRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ExpandViewRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
