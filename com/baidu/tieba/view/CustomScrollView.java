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
import com.baidu.adp.lib.util.k;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class CustomScrollView extends ScrollView {
    private int elI;
    private int elJ;
    protected Field elK;
    private a elL;
    private GestureDetector mGestureDetector;

    /* loaded from: classes.dex */
    public interface a {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.elI = 0;
        this.elJ = 0;
        this.mGestureDetector = new GestureDetector(context, new b());
        setFadingEdgeLength(0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            aSb();
        }
        return super.onInterceptTouchEvent(motionEvent) && this.mGestureDetector.onTouchEvent(motionEvent);
    }

    public void setOnScrollListener(a aVar) {
        this.elL = aVar;
    }

    /* loaded from: classes.dex */
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
        boolean z = false;
        if (this.elL != null) {
            this.elL.onScrollChanged(i, i2, i3, i4);
        }
        if (this.elI - this.elJ == i2) {
            z = true;
        }
        if (i2 == 0 || z) {
            try {
                if (this.elK == null) {
                    this.elK = k.d(this, "mScroller");
                }
                Object obj = this.elK.get(this);
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

    private void aSb() {
        try {
            if (this.elK == null) {
                this.elK = k.d(this, "mScroller");
            }
            Object obj = this.elK.get(this);
            if (obj != null) {
                obj.getClass().getMethod("abortAnimation", new Class[0]).invoke(obj, new Object[0]);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected int computeVerticalScrollRange() {
        this.elI = super.computeVerticalScrollRange();
        return this.elI;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.elJ = i4 - i2;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view2 == null || !(view2 instanceof WebView)) {
            super.requestChildFocus(view, view2);
        }
    }
}
