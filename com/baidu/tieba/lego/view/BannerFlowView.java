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
import d.a.m0.r.f0.r.b;
import d.a.n0.k1.o.l.l;
import d.a.n0.k1.t.a;
import java.util.List;
/* loaded from: classes4.dex */
public class BannerFlowView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f17994e;

    /* renamed from: f  reason: collision with root package name */
    public View f17995f;

    /* renamed from: g  reason: collision with root package name */
    public IndicatorView f17996g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.k1.t.b f17997h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.k1.t.a f17998i;
    public c j;

    /* loaded from: classes4.dex */
    public class a implements l {
        public a() {
        }

        @Override // d.a.n0.k1.o.l.l
        public void a(int i2) {
            if (BannerFlowView.this.j != null) {
                BannerFlowView.this.j.a(i2);
            }
        }

        @Override // d.a.n0.k1.o.l.l
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
        SkinManager.setBackgroundResource(this.f17995f, R.drawable.bg_pic_shadow);
        this.f17996g.setSelector(SkinManager.getDrawable(R.drawable.icon_diandian_white_s));
        this.f17996g.setDrawable(SkinManager.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public final void c(Context context) {
        this.f17994e = new ListViewPager(context);
        this.f17995f = new View(context);
        IndicatorView indicatorView = new IndicatorView(context);
        this.f17996g = indicatorView;
        indicatorView.setSpacing(0);
        b();
        this.f17997h = new d.a.n0.k1.t.b(context, this.f17994e, this.f17996g, null);
        this.f17998i = new d.a.n0.k1.t.a(context, d.a.m0.r.f0.r.d.a.f49817e);
        this.f17997h.m(5000L);
        this.f17997h.l(context, this.f17998i);
        this.f17997h.q(new b());
        addView(this.f17994e, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, d.a.c.e.p.l.g(context, R.dimen.ds80));
        layoutParams.gravity = 80;
        addView(this.f17995f, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        layoutParams2.setMargins(0, 0, d.a.c.e.p.l.g(context, R.dimen.ds20), d.a.c.e.p.l.g(context, R.dimen.ds16));
        addView(this.f17996g, layoutParams2);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.f17997h.m(j);
    }

    public void setData(List<n> list) {
        this.f17994e.removeAllViews();
        this.f17997h.n(list);
    }

    public void setDescOnPic(boolean z, boolean z2) {
        if (z) {
            View view = this.f17995f;
            if (view != null) {
                if (z2) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(4);
                }
            }
            this.f17997h.o(null);
            return;
        }
        View view2 = this.f17995f;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        this.f17997h.o(new a());
    }

    public void setDisableParentEvent(boolean z) {
        this.f17994e.setDisableParentEvent(z);
    }

    public void setIndicatorViewPosition(int i2) {
        IndicatorView indicatorView = this.f17996g;
        if (indicatorView != null) {
            if (i2 == 0) {
                indicatorView.setVisibility(8);
            } else if (i2 == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) indicatorView.getLayoutParams();
                layoutParams.gravity = 85;
                this.f17996g.setLayoutParams(layoutParams);
                this.f17996g.setVisibility(0);
            } else if (i2 != 2) {
                indicatorView.setVisibility(8);
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) indicatorView.getLayoutParams();
                layoutParams2.gravity = 81;
                layoutParams2.rightMargin = 0;
                layoutParams2.rightMargin = 0;
                this.f17996g.setLayoutParams(layoutParams2);
                this.f17996g.setVisibility(0);
            }
        }
    }

    public void setMaxScrollCountLimit(int i2) {
        this.f17997h.p(i2);
    }

    public void setOnItemClickListener(b.a<d.a.m0.r.f0.r.d.a, a.C1416a> aVar) {
        d.a.n0.k1.t.a aVar2 = this.f17998i;
        if (aVar2 != null) {
            aVar2.f(aVar);
        }
    }

    public void setOnPageSelected(c cVar) {
        this.j = cVar;
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.f17994e.setSwipeControlInterface(cVar);
        if (cVar != null) {
            this.f17994e.setDisableParentEvent(false);
        }
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }
}
