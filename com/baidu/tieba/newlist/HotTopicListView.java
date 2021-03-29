package com.baidu.tieba.newlist;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tieba.R;
import com.google.android.material.appbar.AppBarLayout;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.h0.d0.g;
import d.b.h0.d0.h;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class HotTopicListView extends RelativeLayout {
    public static int F = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public boolean A;
    public AppBarLayout.OnOffsetChangedListener B;
    public PullRefreshFrameLayout.i C;
    public Runnable D;
    public PullRefreshFrameLayout.h E;

    /* renamed from: e  reason: collision with root package name */
    public int f19376e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f19377f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.z1.b f19378g;

    /* renamed from: h  reason: collision with root package name */
    public View f19379h;
    public NavigationBar i;
    public ViewGroup j;
    public PullRefreshFrameLayout k;
    public AppBarLayout l;
    public View m;
    public ImageView n;
    public ImageView o;
    public View p;
    public BdTypeRecyclerView q;
    public d.b.i0.z1.c.a r;
    public ViewGroup s;
    public int t;
    public int u;
    public PbListView v;
    public g w;
    public h x;
    public boolean y;
    public ValueAnimator z;

    /* loaded from: classes3.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (HotTopicListView.this.k != null) {
                HotTopicListView.this.k.setInterceptScrollDown(i == 0);
            }
            if (i + HotTopicListView.F < 0) {
                HotTopicListView.this.f19379h.setVisibility(0);
                HotTopicListView.this.i.setCenterTextTitle(HotTopicListView.this.i.getContext().getString(R.string.hot_topic_rank_list_head));
                return;
            }
            HotTopicListView.this.f19379h.setVisibility(8);
            HotTopicListView.this.i.setCenterTextTitle(null);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements PullRefreshFrameLayout.i {

        /* loaded from: classes3.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19382e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f19383f;

            public a(int i, int i2) {
                this.f19382e = i;
                this.f19383f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicListView.this.setHeight((int) (this.f19382e - (valueAnimator.getAnimatedFraction() * this.f19383f)));
            }
        }

        /* renamed from: com.baidu.tieba.newlist.HotTopicListView$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0208b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19385e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f19386f;

            public C0208b(int i, int i2) {
                this.f19385e = i;
                this.f19386f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i;
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (HotTopicListView.this.m == null || (i = this.f19385e) <= 0) {
                    return;
                }
                HotTopicListView.this.setHeight((int) (i - (floatValue * this.f19386f)));
            }
        }

        public b() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void o() {
            int i = HotTopicListView.this.t - HotTopicListView.this.u;
            if (i > 0) {
                HotTopicListView.this.z = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.z.setDuration(300L);
                HotTopicListView.this.z.addUpdateListener(new C0208b(HotTopicListView.this.t, i));
                HotTopicListView.this.z.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void p(double d2) {
            HotTopicListView.this.x(d2);
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void q(int i, double d2) {
            HotTopicListView.this.z = ValueAnimator.ofFloat(0.0f, 1.0f);
            HotTopicListView.this.z.setDuration(150L);
            HotTopicListView.this.z.addUpdateListener(new a(HotTopicListView.this.m.getHeight(), i));
            HotTopicListView.this.z.start();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HotTopicListView.this.y) {
                HotTopicListView.this.w();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements PullRefreshFrameLayout.h {
        public d() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.h
        public void m() {
            HotTopicListView.this.q();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HotTopicListView.this.s.getHeight() > HotTopicListView.this.q.getHeight()) {
                ((AppBarLayout.LayoutParams) HotTopicListView.this.m.getLayoutParams()).setScrollFlags(0);
            } else {
                ((AppBarLayout.LayoutParams) HotTopicListView.this.m.getLayoutParams()).setScrollFlags(13);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A() || HotTopicListView.this.f19378g == null) {
                return;
            }
            HotTopicListView.this.f19378g.loadData();
        }
    }

    public HotTopicListView(TbPageContext<?> tbPageContext, d.b.i0.z1.b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.f19376e = 3;
        this.y = false;
        this.A = false;
        this.B = new a();
        this.C = new b();
        this.D = new c();
        this.E = new d();
        this.f19377f = tbPageContext;
        this.f19378g = bVar;
        t(bundle);
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.m;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = i;
        this.t = i;
        this.m.setLayoutParams(layoutParams);
    }

    public void A() {
        this.q.setNextPage(this.v);
        this.v.f();
        this.v.J(0);
        this.v.A(getResources().getString(R.string.really_great));
    }

    public void B() {
        if (this.y) {
            w();
            d.b.b.e.m.e.a().removeCallbacks(this.D);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        p();
        super.onDetachedFromWindow();
    }

    public void p() {
        r();
        s();
        if (this.y) {
            w();
        }
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.z.removeAllListeners();
            this.z.removeAllUpdateListeners();
            this.z = null;
        }
        d.b.b.e.m.e.a().removeCallbacks(this.D);
    }

    public final void q() {
        d.b.b.e.m.e.a().postDelayed(this.D, 5000L);
        this.y = true;
        this.f19378g.loadData();
    }

    public void r() {
        g gVar = this.w;
        if (gVar != null) {
            gVar.dettachView(this.j);
        }
    }

    public void s() {
        if (this.x != null) {
            this.m.setVisibility(0);
            this.x.dettachView(this.j);
            this.x = null;
        }
    }

    public void setData(@NonNull List<n> list) {
        this.r.c(list);
        this.q.post(new e());
        u();
    }

    public final void t(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.f19379h = findViewById(R.id.topBgView);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.i = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.p = findViewById(R.id.header_round_corner_layout);
        this.m = findViewById(R.id.headerContainerLayout);
        int g2 = l.g(getContext(), R.dimen.tbds520);
        this.u = g2;
        this.t = g2;
        this.n = (ImageView) findViewById(R.id.bgContainer);
        this.o = (ImageView) findViewById(R.id.bgImage);
        PullRefreshFrameLayout pullRefreshFrameLayout = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.k = pullRefreshFrameLayout;
        pullRefreshFrameLayout.setOnTouchCallback(this.C);
        this.k.setOnPullRefreshListener(this.E);
        this.k.setFromFrs();
        this.k.h();
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.l = appBarLayout;
        appBarLayout.addOnOffsetChangedListener(this.B);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.q = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.q.setFadingEdgeLength(0);
        this.q.setOverScrollMode(2);
        this.q.setPadding(0, l.g(getContext(), R.dimen.tbds16), 0, l.g(getContext(), R.dimen.tbds16));
        this.r = new d.b.i0.z1.c.a(this.f19377f, this.q);
        this.s = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.j = (ViewGroup) findViewById(R.id.contentRootLayout);
        PbListView pbListView = new PbListView(this.f19377f.getPageActivity());
        this.v = pbListView;
        pbListView.a();
        this.v.o(R.color.CAM_X0205);
    }

    public final void u() {
        if (this.A) {
            return;
        }
        this.A = true;
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.i.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setViewTextColor(this.i.getCenterText(), R.color.CAM_X0101);
        d.b.i0.z1.b bVar = this.f19378g;
        if (bVar instanceof Activity) {
            UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) bVar);
        }
    }

    public void v() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f19376e) {
            return;
        }
        SkinManager.setBackgroundColor(this.f19379h, R.color.pic_huati_toplist_base_color);
        SkinManager.setImageResource(this.n, R.drawable.pic_huati_toplist_base);
        SkinManager.setImageResource(this.o, R.drawable.pic_huati_toplist_upper);
        SkinManager.setBackgroundResource(this.p, R.drawable.bg_header_round_corner);
        PbListView pbListView = this.v;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.v.o(R.color.CAM_X0205);
        }
        this.r.b();
        this.f19376e = skinType;
    }

    public void w() {
        this.y = false;
        PullRefreshFrameLayout pullRefreshFrameLayout = this.k;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.p();
        }
    }

    public void x(double d2) {
        View view = this.m;
        if (view == null) {
            return;
        }
        int i = (int) (this.u + (PullRefreshFrameLayout.E * d2));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            this.t = i;
            this.m.setLayoutParams(layoutParams);
        }
    }

    public void y() {
        if (this.w == null) {
            this.w = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.w.attachView(this.j, false);
    }

    public void z(boolean z) {
        h hVar = this.x;
        if (hVar == null || !hVar.isViewAttached()) {
            if (this.x == null) {
                this.x = new h(getContext(), new f());
            }
            this.m.setVisibility(8);
            this.x.j(this.f19377f.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.x.attachView(this.j, z);
            this.x.o();
        }
    }
}
