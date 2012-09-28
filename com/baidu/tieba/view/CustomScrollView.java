package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class CustomScrollView extends ScrollView {
    private int Scroll_height;
    private GestureDetector mGestureDetector;
    private int view_height;

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.Scroll_height = 0;
        this.view_height = 0;
        this.mGestureDetector = new GestureDetector(context, new YScrollDetector());
        setFadingEdgeLength(0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            stopAnim();
        }
        boolean ret = super.onInterceptTouchEvent(ev);
        boolean ret2 = this.mGestureDetector.onTouchEvent(ev);
        return ret && ret2;
    }

    /* loaded from: classes.dex */
    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        YScrollDetector() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return Math.abs(distanceY) > Math.abs(distanceX);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        boolean stop = false;
        if (this.Scroll_height - this.view_height == t) {
            stop = true;
        }
        if (t == 0 || stop) {
            try {
                Field filed = UtilHelper.getDeclaredField(this, "mScroller");
                Object ob = filed.get(this);
                if (ob != null && (ob instanceof Scroller)) {
                    Scroller sc = (Scroller) ob;
                    sc.abortAnimation();
                } else {
                    return;
                }
            } catch (Exception e) {
                TiebaLog.e(getClass().getName(), "onScrollChanged", e.getMessage());
            }
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    private void stopAnim() {
        try {
            Field filed = UtilHelper.getDeclaredField(this, "mScroller");
            Object ob = filed.get(this);
            if (ob != null) {
                Method method = ob.getClass().getMethod("abortAnimation", new Class[0]);
                method.invoke(ob, new Object[0]);
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "stopAnim", ex.getMessage());
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected int computeVerticalScrollRange() {
        this.Scroll_height = super.computeVerticalScrollRange();
        return this.Scroll_height;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            this.view_height = b - t;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View child, View focused) {
        if (focused == null || !(focused instanceof WebView)) {
            super.requestChildFocus(child, focused);
        }
    }
}
