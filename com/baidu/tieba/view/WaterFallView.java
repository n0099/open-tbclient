package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class WaterFallView extends BdPullRefreshScrollView {
    private int b;
    private LinearLayout c;
    private LinearLayout d;
    private cl e;
    private LinearLayout f;
    private cl g;
    private View h;
    private View i;
    private int j;
    private Handler k;
    private int l;
    private int m;
    private int n;
    private cm o;

    public WaterFallView(Context context) {
        super(context);
        this.b = 0;
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
        h();
    }

    public WaterFallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
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
        h();
    }

    public void setOnScrollListener(cm cmVar) {
        this.o = cmVar;
    }

    public void a(View view) {
        if (this.h != null) {
            this.c.removeView(this.h);
        }
        this.c.addView(view, 0, new LinearLayout.LayoutParams(-1, -2));
        this.h = view;
    }

    public void f() {
        if (this.h != null) {
            this.c.removeView(this.h);
            this.h = null;
        }
    }

    public View getHeader2() {
        return this.h;
    }

    public void b(View view) {
        if (this.i != null) {
            this.c.removeView(this.i);
        }
        this.c.addView(view, new LinearLayout.LayoutParams(-1, -2));
        this.i = view;
    }

    public View getFooter() {
        return this.i;
    }

    private void h() {
        this.e = new cl(this);
        this.g = new cl(this);
        this.n = com.baidu.adp.lib.h.g.a(getContext(), 20.0f);
        this.b = com.baidu.adp.lib.h.g.a(getContext(), 3.0f);
        this.c = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.water_fall_view, (ViewGroup) null);
        addView(this.c);
        this.d = (LinearLayout) this.c.findViewById(R.id.line1);
        this.f = (LinearLayout) this.c.findViewById(R.id.line2);
        measure(View.MeasureSpec.makeMeasureSpec(com.baidu.adp.lib.h.g.b(getContext()), 1073741824), 0);
        this.j = this.d.getMeasuredWidth();
        i();
    }

    public int getLineWidth() {
        return this.j;
    }

    private void i() {
        this.k = new ck(this);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.k.removeMessages(101);
        boolean z = this.m - this.l == i2;
        if (i2 == 0 || z) {
            try {
                Object obj = com.baidu.adp.lib.h.g.a(this, "mScroller").get(this);
                if (obj != null && (obj instanceof Scroller)) {
                    ((Scroller) obj).abortAnimation();
                }
            } catch (Exception e) {
                com.baidu.tieba.util.bo.b(getClass().getName(), "onScrollChanged", e.getMessage());
            }
        }
        if (this.o != null) {
            if (i2 == 0) {
                this.o.b();
            } else if (this.c.getHeight() - this.n <= getScrollY() + getHeight() && i2 > i4) {
                this.o.a();
            }
            this.o.c();
            this.k.sendMessageDelayed(this.k.obtainMessage(101), 300L);
        }
    }

    public void a(View view, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i);
        layoutParams.topMargin = this.b;
        layoutParams.bottomMargin = this.b;
        if (this.e.b() <= this.g.b()) {
            this.d.addView(view, layoutParams);
            this.e.a((this.b * 2) + i);
            return;
        }
        this.f.addView(view, layoutParams);
        this.g.a((this.b * 2) + i);
    }

    public LinearLayout a(int i) {
        return i == 2 ? this.f : this.d;
    }

    public int b(int i) {
        Rect rect = new Rect();
        if (i == 2) {
            this.f.getLocalVisibleRect(rect);
            return this.g.b(rect.top);
        }
        this.d.getLocalVisibleRect(rect);
        return this.e.b(rect.top);
    }

    public int c(int i) {
        Rect rect = new Rect();
        if (i == 2) {
            this.f.getLocalVisibleRect(rect);
            return this.g.c(rect.bottom);
        }
        this.d.getLocalVisibleRect(rect);
        return this.e.c(rect.bottom);
    }

    public void g() {
        this.d.removeAllViews();
        this.e.a();
        this.f.removeAllViews();
        this.g.a();
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
        this.k.removeMessages(101);
        this.k.sendMessageDelayed(this.k.obtainMessage(101), 300L);
    }

    public void d(int i) {
        this.d.invalidate();
        this.f.invalidate();
        for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) this.d.getChildAt(i2);
            if (frsWaterFallItem != null) {
                frsWaterFallItem.a(i);
                frsWaterFallItem.invalidate();
            }
        }
        for (int i3 = 0; i3 < this.f.getChildCount(); i3++) {
            FrsWaterFallItem frsWaterFallItem2 = (FrsWaterFallItem) this.f.getChildAt(i3);
            if (frsWaterFallItem2 != null) {
                frsWaterFallItem2.a(i);
                frsWaterFallItem2.invalidate();
            }
        }
    }
}
