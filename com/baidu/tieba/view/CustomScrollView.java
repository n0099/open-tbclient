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
import com.baidu.adp.lib.util.n;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class CustomScrollView extends ScrollView {
    private int ctg;
    private int cth;
    protected Field cti;
    private b ctj;
    private GestureDetector mGestureDetector;

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ctg = 0;
        this.cth = 0;
        this.mGestureDetector = new GestureDetector(context, new c(this));
        setFadingEdgeLength(0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            apt();
        }
        return super.onInterceptTouchEvent(motionEvent) && this.mGestureDetector.onTouchEvent(motionEvent);
    }

    public void setOnScrollListener(b bVar) {
        this.ctj = bVar;
    }

    public boolean aps() {
        return getScrollY() == (getChildAt(0).getBottom() + getPaddingBottom()) - getHeight();
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.ctj != null) {
            this.ctj.onScrollChanged(i, i2, i3, i4);
        }
        if (this.ctg - this.cth == i2) {
            z = true;
        }
        if (i2 == 0 || z) {
            try {
                if (this.cti == null) {
                    this.cti = n.c(this, "mScroller");
                }
                Object obj = this.cti.get(this);
                if (obj != null && (obj instanceof Scroller)) {
                    ((Scroller) obj).abortAnimation();
                } else {
                    return;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    private void apt() {
        try {
            if (this.cti == null) {
                this.cti = n.c(this, "mScroller");
            }
            Object obj = this.cti.get(this);
            if (obj != null) {
                obj.getClass().getMethod("abortAnimation", new Class[0]).invoke(obj, new Object[0]);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected int computeVerticalScrollRange() {
        this.ctg = super.computeVerticalScrollRange();
        return this.ctg;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.cth = i4 - i2;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view2 == null || !(view2 instanceof WebView)) {
            super.requestChildFocus(view, view2);
        }
    }
}
