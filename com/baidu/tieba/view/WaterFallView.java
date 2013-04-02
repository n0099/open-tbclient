package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.baidu.tieba.R;
import com.baidu.zeus.WebChromeClient;
/* loaded from: classes.dex */
public class WaterFallView extends ScrollView {
    private int a;
    private LinearLayout b;
    private LinearLayout c;
    private am d;
    private LinearLayout e;
    private am f;
    private View g;
    private View h;
    private View i;
    private int j;
    private Handler k;
    private int l;
    private int m;
    private int n;
    private an o;

    public WaterFallView(Context context) {
        super(context);
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.k = null;
        this.l = 0;
        this.m = 0;
        this.n = 20;
        this.o = null;
        c();
    }

    public WaterFallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.k = null;
        this.l = 0;
        this.m = 0;
        this.n = 20;
        this.o = null;
        c();
    }

    public WaterFallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.k = null;
        this.l = 0;
        this.m = 0;
        this.n = 20;
        this.o = null;
        c();
    }

    public void setOnScrollListener(an anVar) {
        this.o = anVar;
    }

    public void a(View view) {
        if (this.g != null) {
            this.b.removeView(this.g);
        }
        this.b.addView(view, 0, new LinearLayout.LayoutParams(-1, -2));
        this.g = view;
    }

    public View getHeader() {
        return this.g;
    }

    public void b(View view) {
        if (this.h != null) {
            this.b.removeView(this.h);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (this.g == null) {
            this.b.addView(view, 0, layoutParams);
        } else {
            this.b.addView(view, 1, layoutParams);
        }
        this.h = view;
    }

    public void a() {
        if (this.h != null) {
            this.b.removeView(this.h);
            this.h = null;
        }
    }

    public View getHeader2() {
        return this.h;
    }

    public void c(View view) {
        if (this.i != null) {
            this.b.removeView(this.i);
        }
        this.b.addView(view, new LinearLayout.LayoutParams(-1, -2));
        this.i = view;
    }

    public View getFooter() {
        return this.i;
    }

    private void c() {
        this.d = new am(this);
        this.f = new am(this);
        this.n = com.baidu.tieba.c.ai.a(getContext(), 20.0f);
        this.a = com.baidu.tieba.c.ai.a(getContext(), 3.0f);
        this.b = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.water_fall_view, (ViewGroup) null);
        addView(this.b);
        this.c = (LinearLayout) this.b.findViewById(R.id.line1);
        this.e = (LinearLayout) this.b.findViewById(R.id.line2);
        measure(View.MeasureSpec.makeMeasureSpec(com.baidu.tieba.c.ai.a(getContext()), 1073741824), 0);
        this.j = this.c.getMeasuredWidth();
        d();
    }

    public int getLineWidth() {
        return this.j;
    }

    private void d() {
        this.k = new al(this);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.k.removeMessages(WebChromeClient.STRING_DLG_TITLE_DATETIME);
        boolean z = false;
        if (this.m - this.l == i2) {
            z = true;
        }
        if (i2 == 0 || z) {
            try {
                Object obj = com.baidu.tieba.c.ai.a(this, "mScroller").get(this);
                if (obj != null && (obj instanceof Scroller)) {
                    ((Scroller) obj).abortAnimation();
                }
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "onScrollChanged", e.getMessage());
            }
        }
        if (this.o != null) {
            if (i2 == 0) {
                this.o.b();
            } else if (this.b.getHeight() - this.n <= getScrollY() + getHeight() && i2 > i4) {
                this.o.a();
            }
            this.o.c();
            this.k.sendMessageDelayed(this.k.obtainMessage(WebChromeClient.STRING_DLG_TITLE_DATETIME), 300L);
        }
    }

    public void a(View view, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i);
        layoutParams.topMargin = this.a;
        layoutParams.bottomMargin = this.a;
        if (this.d.b() <= this.f.b()) {
            this.c.addView(view, layoutParams);
            this.d.a((this.a * 2) + i);
            return;
        }
        this.e.addView(view, layoutParams);
        this.f.a((this.a * 2) + i);
    }

    public LinearLayout a(int i) {
        return i == 2 ? this.e : this.c;
    }

    public int b(int i) {
        Rect rect = new Rect();
        if (i == 2) {
            this.e.getLocalVisibleRect(rect);
            return this.f.b(rect.top);
        }
        this.c.getLocalVisibleRect(rect);
        return this.d.b(rect.top);
    }

    public int c(int i) {
        Rect rect = new Rect();
        if (i == 2) {
            this.e.getLocalVisibleRect(rect);
            return this.f.c(rect.bottom);
        }
        this.c.getLocalVisibleRect(rect);
        return this.d.c(rect.bottom);
    }

    public void b() {
        this.c.removeAllViews();
        this.d.a();
        this.e.removeAllViews();
        this.f.a();
    }

    @Override // android.widget.ScrollView, android.view.View
    protected int computeVerticalScrollRange() {
        this.m = super.computeVerticalScrollRange();
        return this.m;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.l = i4 - i2;
        }
        this.k.removeMessages(WebChromeClient.STRING_DLG_TITLE_DATETIME);
        this.k.sendMessageDelayed(this.k.obtainMessage(WebChromeClient.STRING_DLG_TITLE_DATETIME), 300L);
    }
}
