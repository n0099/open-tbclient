package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f21292e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21293f;

    /* renamed from: g  reason: collision with root package name */
    public float f21294g;

    /* renamed from: h  reason: collision with root package name */
    public float f21295h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21296i;

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
        this.f21296i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f21294g = motionEvent.getY();
            this.f21295h = motionEvent.getY();
            a aVar = this.f21292e;
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
            if (action == 2 && this.f21292e != null) {
                this.f21294g = motionEvent.getY();
                boolean a2 = this.f21292e.a(motionEvent.getY() - this.f21294g, motionEvent.getY(), motionEvent.getY() - this.f21295h > 0.0f ? 1 : 2);
                this.f21293f = a2;
                return a2;
            }
        } else {
            a aVar = this.f21292e;
            if (aVar != null) {
                boolean a3 = aVar.a(0.0f, motionEvent.getY(), 0);
                this.f21293f = a3;
                return a3;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f21296i) {
            super.onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY() - this.f21294g;
                int i2 = motionEvent.getY() - this.f21295h > 0.0f ? 1 : 2;
                if (this.f21293f && (aVar = this.f21292e) != null) {
                    aVar.d(motionEvent.getY(), y, i2);
                    return true;
                }
            }
        } else {
            this.f21293f = false;
            a aVar2 = this.f21292e;
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
        this.f21296i = z;
    }

    public void setScrollCallBack(a aVar) {
        this.f21292e = aVar;
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
