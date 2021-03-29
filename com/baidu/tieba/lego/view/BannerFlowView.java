package com.baidu.tieba.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import d.b.b.j.e.n;
import d.b.h0.r.f0.r.b;
import d.b.i0.i1.o.l.l;
import d.b.i0.i1.t.a;
import java.util.List;
/* loaded from: classes3.dex */
public class BannerFlowView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f18722e;

    /* renamed from: f  reason: collision with root package name */
    public View f18723f;

    /* renamed from: g  reason: collision with root package name */
    public IndicatorView f18724g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.i1.t.b f18725h;
    public d.b.i0.i1.t.a i;
    public c j;

    /* loaded from: classes3.dex */
    public class a implements l {
        public a() {
        }

        @Override // d.b.i0.i1.o.l.l
        public void a(int i) {
            if (BannerFlowView.this.j != null) {
                BannerFlowView.this.j.a(i);
            }
        }

        @Override // d.b.i0.i1.o.l.l
        public void b(float f2) {
            if (BannerFlowView.this.j != null) {
                BannerFlowView.this.j.b(f2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (BannerFlowView.this.j != null) {
                BannerFlowView.this.j.onPageSelected(i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c extends l {
        void onPageSelected(int i);
    }

    public BannerFlowView(Context context) {
        super(context);
        c(context);
    }

    public final void b() {
        SkinManager.setBackgroundResource(this.f18723f, R.drawable.bg_pic_shadow);
        this.f18724g.setSelector(SkinManager.getDrawable(R.drawable.icon_diandian_white_s));
        this.f18724g.setDrawable(SkinManager.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public final void c(Context context) {
        this.f18722e = new ListViewPager(context);
        this.f18723f = new View(context);
        IndicatorView indicatorView = new IndicatorView(context);
        this.f18724g = indicatorView;
        indicatorView.setSpacing(0);
        b();
        this.f18725h = new d.b.i0.i1.t.b(context, this.f18722e, this.f18724g, null);
        this.i = new d.b.i0.i1.t.a(context, d.b.h0.r.f0.r.d.a.f50584e);
        this.f18725h.m(5000L);
        this.f18725h.l(context, this.i);
        this.f18725h.q(new b());
        addView(this.f18722e, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, d.b.b.e.p.l.g(context, R.dimen.ds80));
        layoutParams.gravity = 80;
        addView(this.f18723f, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        layoutParams2.setMargins(0, 0, d.b.b.e.p.l.g(context, R.dimen.ds20), d.b.b.e.p.l.g(context, R.dimen.ds16));
        addView(this.f18724g, layoutParams2);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.f18725h.m(j);
    }

    public void setData(List<n> list) {
        this.f18722e.removeAllViews();
        this.f18725h.n(list);
    }

    public void setDescOnPic(boolean z, boolean z2) {
        if (z) {
            View view = this.f18723f;
            if (view != null) {
                if (z2) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(4);
                }
            }
            this.f18725h.o(null);
            return;
        }
        View view2 = this.f18723f;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        this.f18725h.o(new a());
    }

    public void setDisableParentEvent(boolean z) {
        this.f18722e.setDisableParentEvent(z);
    }

    public void setIndicatorViewPosition(int i) {
        IndicatorView indicatorView = this.f18724g;
        if (indicatorView != null) {
            if (i == 0) {
                indicatorView.setVisibility(8);
            } else if (i == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) indicatorView.getLayoutParams();
                layoutParams.gravity = 85;
                this.f18724g.setLayoutParams(layoutParams);
                this.f18724g.setVisibility(0);
            } else if (i != 2) {
                indicatorView.setVisibility(8);
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) indicatorView.getLayoutParams();
                layoutParams2.gravity = 81;
                layoutParams2.rightMargin = 0;
                layoutParams2.rightMargin = 0;
                this.f18724g.setLayoutParams(layoutParams2);
                this.f18724g.setVisibility(0);
            }
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.f18725h.p(i);
    }

    public void setOnItemClickListener(b.a<d.b.h0.r.f0.r.d.a, a.C1308a> aVar) {
        d.b.i0.i1.t.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.f(aVar);
        }
    }

    public void setOnPageSelected(c cVar) {
        this.j = cVar;
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.f18722e.setSwipeControlInterface(cVar);
        if (cVar != null) {
            this.f18722e.setDisableParentEvent(false);
        }
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }
}
