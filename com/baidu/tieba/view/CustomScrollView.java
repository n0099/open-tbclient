package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.p.l;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class CustomScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public GestureDetector f22386e;

    /* renamed from: f  reason: collision with root package name */
    public int f22387f;

    /* renamed from: g  reason: collision with root package name */
    public int f22388g;

    /* renamed from: h  reason: collision with root package name */
    public Field f22389h;

    /* renamed from: i  reason: collision with root package name */
    public a f22390i;

    /* loaded from: classes5.dex */
    public interface a {
        void onScrollChanged(int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes5.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Math.abs(f3) > Math.abs(f2);
        }
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22387f = 0;
        this.f22388g = 0;
        this.f22386e = new GestureDetector(context, new b());
        setFadingEdgeLength(0);
    }

    public final void a() {
        try {
            if (this.f22389h == null) {
                this.f22389h = l.f(this, "mScroller");
            }
            Object obj = this.f22389h.get(this);
            if (obj == null) {
                return;
            }
            obj.getClass().getMethod("abortAnimation", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public int computeVerticalScrollRange() {
        int computeVerticalScrollRange = super.computeVerticalScrollRange();
        this.f22387f = computeVerticalScrollRange;
        return computeVerticalScrollRange;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            a();
        }
        return super.onInterceptTouchEvent(motionEvent) && this.f22386e.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            this.f22388g = i5 - i3;
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        a aVar = this.f22390i;
        if (aVar != null) {
            aVar.onScrollChanged(i2, i3, i4, i5);
        }
        boolean z = this.f22387f - this.f22388g == i3;
        if (i3 == 0 || z) {
            try {
                if (this.f22389h == null) {
                    this.f22389h = l.f(this, "mScroller");
                }
                Object obj = this.f22389h.get(this);
                if (obj != null && (obj instanceof Scroller)) {
                    ((Scroller) obj).abortAnimation();
                }
                return;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view2 == null || !(view2 instanceof WebView)) {
            super.requestChildFocus(view, view2);
        }
    }

    public void setOnScrollListener(a aVar) {
        this.f22390i = aVar;
    }
}
