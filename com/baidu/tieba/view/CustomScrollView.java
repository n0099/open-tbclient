package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.baidu.tieba.util.UtilHelper;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class CustomScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    protected Field f1942a;
    private GestureDetector b;
    private int c;
    private int d;

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.d = 0;
        this.b = new GestureDetector(context, new i(this));
        setFadingEdgeLength(0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            a();
        }
        return super.onInterceptTouchEvent(motionEvent) && this.b.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.c - this.d == i2) {
            z = true;
        }
        if (i2 == 0 || z) {
            try {
                if (this.f1942a == null) {
                    this.f1942a = UtilHelper.a(this, "mScroller");
                }
                Object obj = this.f1942a.get(this);
                if (obj != null && (obj instanceof Scroller)) {
                    ((Scroller) obj).abortAnimation();
                } else {
                    return;
                }
            } catch (Exception e) {
                com.baidu.tieba.util.av.b(getClass().getName(), "onScrollChanged", e.getMessage());
            }
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    private void a() {
        try {
            if (this.f1942a == null) {
                this.f1942a = UtilHelper.a(this, "mScroller");
            }
            Object obj = this.f1942a.get(this);
            if (obj != null) {
                obj.getClass().getMethod("abortAnimation", new Class[0]).invoke(obj, new Object[0]);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "stopAnim", e.getMessage());
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected int computeVerticalScrollRange() {
        this.c = super.computeVerticalScrollRange();
        return this.c;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.d = i4 - i2;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view2 == null || !(view2 instanceof WebView)) {
            super.requestChildFocus(view, view2);
        }
    }
}
