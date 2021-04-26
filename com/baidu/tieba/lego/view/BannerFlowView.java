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
import d.a.c.j.e.n;
import d.a.i0.r.f0.r.b;
import d.a.j0.j1.o.l.l;
import d.a.j0.j1.t.a;
import java.util.List;
/* loaded from: classes4.dex */
public class BannerFlowView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f18769e;

    /* renamed from: f  reason: collision with root package name */
    public View f18770f;

    /* renamed from: g  reason: collision with root package name */
    public IndicatorView f18771g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.j1.t.b f18772h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.j1.t.a f18773i;
    public c j;

    /* loaded from: classes4.dex */
    public class a implements l {
        public a() {
        }

        @Override // d.a.j0.j1.o.l.l
        public void a(int i2) {
            if (BannerFlowView.this.j != null) {
                BannerFlowView.this.j.a(i2);
            }
        }

        @Override // d.a.j0.j1.o.l.l
        public void b(float f2) {
            if (BannerFlowView.this.j != null) {
                BannerFlowView.this.j.b(f2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (BannerFlowView.this.j != null) {
                BannerFlowView.this.j.onPageSelected(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c extends l {
        void onPageSelected(int i2);
    }

    public BannerFlowView(Context context) {
        super(context);
        c(context);
    }

    public final void b() {
        SkinManager.setBackgroundResource(this.f18770f, R.drawable.bg_pic_shadow);
        this.f18771g.setSelector(SkinManager.getDrawable(R.drawable.icon_diandian_white_s));
        this.f18771g.setDrawable(SkinManager.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public final void c(Context context) {
        this.f18769e = new ListViewPager(context);
        this.f18770f = new View(context);
        IndicatorView indicatorView = new IndicatorView(context);
        this.f18771g = indicatorView;
        indicatorView.setSpacing(0);
        b();
        this.f18772h = new d.a.j0.j1.t.b(context, this.f18769e, this.f18771g, null);
        this.f18773i = new d.a.j0.j1.t.a(context, d.a.i0.r.f0.r.d.a.f48943e);
        this.f18772h.m(5000L);
        this.f18772h.l(context, this.f18773i);
        this.f18772h.q(new b());
        addView(this.f18769e, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, d.a.c.e.p.l.g(context, R.dimen.ds80));
        layoutParams.gravity = 80;
        addView(this.f18770f, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        layoutParams2.setMargins(0, 0, d.a.c.e.p.l.g(context, R.dimen.ds20), d.a.c.e.p.l.g(context, R.dimen.ds16));
        addView(this.f18771g, layoutParams2);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.f18772h.m(j);
    }

    public void setData(List<n> list) {
        this.f18769e.removeAllViews();
        this.f18772h.n(list);
    }

    public void setDescOnPic(boolean z, boolean z2) {
        if (z) {
            View view = this.f18770f;
            if (view != null) {
                if (z2) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(4);
                }
            }
            this.f18772h.o(null);
            return;
        }
        View view2 = this.f18770f;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        this.f18772h.o(new a());
    }

    public void setDisableParentEvent(boolean z) {
        this.f18769e.setDisableParentEvent(z);
    }

    public void setIndicatorViewPosition(int i2) {
        IndicatorView indicatorView = this.f18771g;
        if (indicatorView != null) {
            if (i2 == 0) {
                indicatorView.setVisibility(8);
            } else if (i2 == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) indicatorView.getLayoutParams();
                layoutParams.gravity = 85;
                this.f18771g.setLayoutParams(layoutParams);
                this.f18771g.setVisibility(0);
            } else if (i2 != 2) {
                indicatorView.setVisibility(8);
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) indicatorView.getLayoutParams();
                layoutParams2.gravity = 81;
                layoutParams2.rightMargin = 0;
                layoutParams2.rightMargin = 0;
                this.f18771g.setLayoutParams(layoutParams2);
                this.f18771g.setVisibility(0);
            }
        }
    }

    public void setMaxScrollCountLimit(int i2) {
        this.f18772h.p(i2);
    }

    public void setOnItemClickListener(b.a<d.a.i0.r.f0.r.d.a, a.C1326a> aVar) {
        d.a.j0.j1.t.a aVar2 = this.f18773i;
        if (aVar2 != null) {
            aVar2.f(aVar);
        }
    }

    public void setOnPageSelected(c cVar) {
        this.j = cVar;
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.f18769e.setSwipeControlInterface(cVar);
        if (cVar != null) {
            this.f18769e.setDisableParentEvent(false);
        }
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }
}
