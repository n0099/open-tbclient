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
import com.baidu.adp.lib.util.l;
import java.lang.reflect.Field;
/* loaded from: classes8.dex */
public class CustomScrollView extends ScrollView {
    private int kHT;
    protected Field kHU;
    private a kHV;
    private GestureDetector mGestureDetector;
    private int view_height;

    /* loaded from: classes8.dex */
    public interface a {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kHT = 0;
        this.view_height = 0;
        this.mGestureDetector = new GestureDetector(context, new b());
        setFadingEdgeLength(0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            stopAnim();
        }
        return super.onInterceptTouchEvent(motionEvent) && this.mGestureDetector.onTouchEvent(motionEvent);
    }

    public void setOnScrollListener(a aVar) {
        this.kHV = aVar;
    }

    /* loaded from: classes8.dex */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return Math.abs(f2) > Math.abs(f);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.kHV != null) {
            this.kHV.onScrollChanged(i, i2, i3, i4);
        }
        boolean z = this.kHT - this.view_height == i2;
        if (i2 == 0 || z) {
            try {
                if (this.kHU == null) {
                    this.kHU = l.getDeclaredField(this, "mScroller");
                }
                Object obj = this.kHU.get(this);
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

    private void stopAnim() {
        try {
            if (this.kHU == null) {
                this.kHU = l.getDeclaredField(this, "mScroller");
            }
            Object obj = this.kHU.get(this);
            if (obj != null) {
                obj.getClass().getMethod("abortAnimation", new Class[0]).invoke(obj, new Object[0]);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected int computeVerticalScrollRange() {
        this.kHT = super.computeVerticalScrollRange();
        return this.kHT;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.view_height = i4 - i2;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view2 == null || !(view2 instanceof WebView)) {
            super.requestChildFocus(view, view2);
        }
    }
}
