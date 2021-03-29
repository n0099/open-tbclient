package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f21734e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21735f;

    /* renamed from: g  reason: collision with root package name */
    public float f21736g;

    /* renamed from: h  reason: collision with root package name */
    public float f21737h;
    public boolean i;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b(float f2);

        boolean c(float f2, float f3, int i);

        void d(float f2, float f3, int i);
    }

    public ExpandViewRelativeLayout(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f21736g = motionEvent.getY();
            this.f21737h = motionEvent.getY();
            a aVar = this.f21734e;
            if (aVar != null) {
                aVar.b(motionEvent.getY());
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && this.f21734e != null) {
                this.f21736g = motionEvent.getY();
                boolean c2 = this.f21734e.c(motionEvent.getY() - this.f21736g, motionEvent.getY(), motionEvent.getY() - this.f21737h > 0.0f ? 1 : 2);
                this.f21735f = c2;
                return c2;
            }
        } else {
            a aVar = this.f21734e;
            if (aVar != null) {
                boolean c3 = aVar.c(0.0f, motionEvent.getY(), 0);
                this.f21735f = c3;
                return c3;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.i) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY() - this.f21736g;
                int i = motionEvent.getY() - this.f21737h > 0.0f ? 1 : 2;
                if (this.f21735f && (aVar = this.f21734e) != null) {
                    aVar.d(motionEvent.getY(), y, i);
                    return true;
                }
            }
        } else {
            this.f21735f = false;
            a aVar2 = this.f21734e;
            if (aVar2 != null) {
                aVar2.a();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }

    public void setIsCanLayout(boolean z) {
        this.i = z;
    }

    public void setScrollCallBack(a aVar) {
        this.f21734e = aVar;
    }

    public ExpandViewRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ExpandViewRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
