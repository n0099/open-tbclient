package com.baidu.tieba.newdetail;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatusbarColorUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.adapter.HotTopicDetailPagerAdapter;
import com.baidu.tieba.newdetail.view.HotTopicDetailHeadView;
import com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialLayout;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.material.appbar.AppBarLayout;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.j0.z0.i0;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class HotTopicDetailView extends RelativeLayout implements d.a.k0.x1.b {
    public static int Q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public HotTopicDetailSpecialLayout A;
    public d.a.k0.c1.b.c B;
    public CustomViewPager C;
    public HotTopicDetailPagerAdapter D;
    public TbTabLayout E;
    public View F;
    public RecyclerView.OnScrollListener G;
    public boolean H;
    public ValueAnimator I;
    public d.a.k0.c1.c.e J;
    public AppBarLayout.OnOffsetChangedListener K;
    public PullRefreshFrameLayout.i L;
    public Runnable M;
    public PullRefreshFrameLayout.h N;
    public ClickableSpan O;
    public ClickableSpan P;

    /* renamed from: e  reason: collision with root package name */
    public int f18530e;

    /* renamed from: f  reason: collision with root package name */
    public int f18531f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f18532g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.x1.a f18533h;

    /* renamed from: i  reason: collision with root package name */
    public View f18534i;
    public NavigationBar j;
    public ImageView k;
    public boolean l;
    public ViewGroup m;
    public d.a.j0.d0.g n;
    public d.a.j0.d0.h o;
    public PullRefreshFrameLayout p;
    public HotTopicDetailHeadView q;
    public int r;
    public int s;
    public TextView t;
    public String u;
    public int v;
    public View w;
    public AppBarLayout x;
    public View y;
    public HotTopicDetailPkLayout z;

    /* loaded from: classes3.dex */
    public class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            HotTopicDetailView.this.t.setText(HotTopicDetailView.this.u);
            HotTopicDetailView.this.S();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            HotTopicDetailView.this.U();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.a.c.e.p.j.z()) {
                HotTopicDetailView.this.f18532g.showToast(R.string.topic_share_no_network);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(HotTopicDetailView.this.k.getContext())) {
                HotTopicDetailView.this.f18533h.shareTopic(HotTopicDetailView.this.J);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicDetailView.this.y.setMinimumHeight(HotTopicDetailView.this.j.getHeight() + HotTopicDetailView.this.f18531f);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        public e() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (HotTopicDetailView.this.p != null) {
                HotTopicDetailView.this.p.setInterceptScrollDown(i2 == 0);
            }
            HotTopicDetailView.this.W(i2);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements PullRefreshFrameLayout.i {

        /* loaded from: classes3.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f18541e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f18542f;

            public a(int i2, int i3) {
                this.f18541e = i2;
                this.f18542f = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailView.this.setHeight((int) (this.f18541e - (valueAnimator.getAnimatedFraction() * this.f18542f)));
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f18544e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f18545f;

            public b(int i2, int i3) {
                this.f18544e = i2;
                this.f18545f = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i2;
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (HotTopicDetailView.this.q == null || (i2 = this.f18544e) <= 0) {
                    return;
                }
                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * this.f18545f)));
            }
        }

        public f() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void k() {
            int i2 = HotTopicDetailView.this.r - HotTopicDetailView.this.s;
            if (i2 > 0) {
                HotTopicDetailView.this.I = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.I.setDuration(300L);
                HotTopicDetailView.this.I.addUpdateListener(new b(HotTopicDetailView.this.r, i2));
                HotTopicDetailView.this.I.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void l(double d2) {
            HotTopicDetailView.this.a0(d2);
            HotTopicDetailView.this.p.r();
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void m(int i2, double d2) {
            HotTopicDetailView.this.I = ValueAnimator.ofFloat(0.0f, 1.0f);
            HotTopicDetailView.this.I.setDuration(150L);
            HotTopicDetailView.this.I.addUpdateListener(new a(HotTopicDetailView.this.q.getHeight(), i2));
            HotTopicDetailView.this.I.start();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.a.c.e.p.j.A() || HotTopicDetailView.this.f18533h == null) {
                return;
            }
            HotTopicDetailView.this.f18533h.refreshFullData(1);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HotTopicDetailView.this.H) {
                HotTopicDetailView.this.Z();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements PullRefreshFrameLayout.h {
        public i() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.h
        public void m() {
            HotTopicDetailView.this.R();
        }
    }

    /* loaded from: classes3.dex */
    public class j extends ClickableSpan {
        public j() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.u);
            if (HotTopicDetailView.this.u.length() > 500) {
                spannableStringBuilder.append((CharSequence) "...  ");
            }
            String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + GlideException.IndentedAppendable.INDENT;
            spannableStringBuilder.append((CharSequence) str);
            SpannableString spannableString = new SpannableString(spannableStringBuilder);
            spannableString.setSpan(HotTopicDetailView.this.P, spannableString.length() - str.length(), spannableString.length(), 33);
            HotTopicDetailView.this.t.setText(spannableString);
            HotTopicDetailView.this.t.setHeight(HotTopicDetailView.this.v * HotTopicDetailView.this.t.getLineHeight());
            int lineCount = HotTopicDetailView.this.t.getLineCount() * HotTopicDetailView.this.t.getLineHeight();
            if (lineCount > HotTopicDetailView.this.v * HotTopicDetailView.this.t.getLineHeight()) {
                HotTopicDetailView.this.t.scrollTo(0, lineCount - (HotTopicDetailView.this.v * HotTopicDetailView.this.t.getLineHeight()));
            }
            HotTopicDetailView.this.t.requestLayout();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
        }
    }

    public HotTopicDetailView(TbPageContext<?> tbPageContext, d.a.k0.x1.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.f18530e = 3;
        this.f18531f = UtilHelper.getStatusBarHeight();
        this.l = false;
        this.u = "";
        this.G = new b();
        this.H = false;
        this.K = new e();
        this.L = new f();
        this.M = new h();
        this.N = new i();
        this.O = new j();
        this.P = new a();
        this.f18532g = tbPageContext;
        this.f18533h = aVar;
        X(bundle);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i2) {
        ViewGroup.LayoutParams layoutParams;
        HotTopicDetailHeadView hotTopicDetailHeadView = this.q;
        if (hotTopicDetailHeadView == null || (layoutParams = hotTopicDetailHeadView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = i2;
        this.r = i2;
        this.q.setLayoutParams(layoutParams);
    }

    public final void R() {
        d.a.c.e.m.e.a().postDelayed(this.M, 5000L);
        this.H = true;
        this.f18533h.refreshFullData(k());
    }

    public final void S() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.u);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.t.getLayout().getLineEnd(1) - string.length()) - 2);
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.O, length - 1, spannableString.length(), 33);
        this.t.setText(spannableString);
        TextView textView = this.t;
        textView.setHeight(textView.getLineHeight() * 2);
        this.t.scrollTo(0, 0);
        this.t.requestLayout();
    }

    public final void T(d.a.k0.c1.c.f fVar) {
        if (StringUtils.isNull(fVar.f52395g)) {
            this.t.setVisibility(8);
        } else {
            this.t.setText(fVar.f52395g);
        }
    }

    public final void U() {
        if (this.f18531f + this.j.getHeight() >= this.w.getY()) {
            SkinManager.setBackgroundColor(this.E, R.color.CAM_X0207);
            if (this.f18530e == 0) {
                this.F.setVisibility(0);
                return;
            }
            return;
        }
        SkinManager.setBackgroundColor(this.E, R.color.transparent);
        this.F.setVisibility(8);
    }

    public final void V(@NonNull d.a.k0.c1.c.e eVar) {
        Y();
        this.q.setTopicInfo(eVar.h());
        T(eVar.h());
        c(eVar);
        List<n> l = eVar.l();
        if (ListUtils.isEmpty(l)) {
            this.A.setVisibility(8);
        } else {
            this.A.setData(l);
            this.A.setVisibility(0);
        }
        if (eVar.h() != null) {
            String str = eVar.h().f52394f;
            if (i0.d(str) > 15) {
                str = i0.m(str, 15) + StringHelper.STRING_MORE;
            }
            this.j.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    public final void W(int i2) {
        int i3 = i2 + Q;
        if (i3 < 0) {
            i3 = 0;
        }
        float f2 = 1.0f - ((i3 * 1.0f) / Q);
        this.f18534i.setAlpha(f2);
        this.j.getCenterText().setAlpha(f2);
        U();
        double d2 = f2;
        if (d2 > 0.1d) {
            StatusbarColorUtils.setStatusBarDarkIcon(this.f18532g.getPageActivity().getWindow(), true);
        } else {
            StatusbarColorUtils.setStatusBarDarkIcon(this.f18532g.getPageActivity().getWindow(), false);
        }
        if ((d2 > 0.3d && this.f18530e == 0) || this.J == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.j.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.j.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public final void X(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.topBgView);
        this.f18534i = findViewById;
        findViewById.setAlpha(0.0f);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.j = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.getCenterText().setAlpha(0.0f);
        ImageView imageView = (ImageView) this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new c());
        this.k = imageView;
        imageView.setVisibility(4);
        View findViewById2 = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
        layoutParams.height = this.f18531f;
        findViewById2.setLayoutParams(layoutParams);
        this.m = (ViewGroup) findViewById(R.id.contentRootLayout);
        PullRefreshFrameLayout pullRefreshFrameLayout = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.p = pullRefreshFrameLayout;
        pullRefreshFrameLayout.setOnTouchCallback(this.L);
        this.p.setOnPullRefreshListener(this.N);
        this.p.setFromFrs();
        this.p.h();
        this.q = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        int g2 = l.g(getContext(), R.dimen.tbds600);
        this.s = g2;
        this.r = g2;
        this.y = findViewById(R.id.headerContainerLayout);
        this.j.post(new d());
        this.t = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.z = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        HotTopicDetailSpecialLayout hotTopicDetailSpecialLayout = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.A = hotTopicDetailSpecialLayout;
        hotTopicDetailSpecialLayout.F(this.f18532g);
        this.w = findViewById(R.id.contentContainer);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.x = appBarLayout;
        appBarLayout.addOnOffsetChangedListener(this.K);
        this.C = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = new HotTopicDetailPagerAdapter(getContext());
        this.D = hotTopicDetailPagerAdapter;
        hotTopicDetailPagerAdapter.p(this.G);
        this.C.setAdapter(this.D);
        TbTabLayout tbTabLayout = (TbTabLayout) findViewById(R.id.tabLayout);
        this.E = tbTabLayout;
        tbTabLayout.setSelectedTabTextBlod(true);
        this.E.setTabTextSize(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.E.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
        this.E.setupWithViewPager(this.C);
        this.F = findViewById(R.id.dividerShadow);
        this.B = new d.a.k0.c1.b.c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.f18532g);
    }

    public final void Y() {
        if (this.l) {
            return;
        }
        this.l = true;
        this.k.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.j.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.j.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        d.a.k0.x1.a aVar = this.f18533h;
        if (aVar instanceof Activity) {
            UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) aVar);
        }
    }

    public final void Z() {
        this.H = false;
        PullRefreshFrameLayout pullRefreshFrameLayout = this.p;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.p();
        }
    }

    @Override // d.a.k0.x1.b
    public void a() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f18530e) {
            return;
        }
        this.q.h(skinType);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.y, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f18534i, R.color.CAM_X0207);
        SkinManager.setNavbarTitleColor(this.j.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        d.a.j0.d0.g gVar = this.n;
        if (gVar != null) {
            gVar.n(SkinManager.getColor(R.color.CAM_X0201));
        }
        this.z.m(skinType);
        this.E.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
        this.A.H(skinType);
        this.D.l(skinType);
        this.f18530e = skinType;
    }

    public void a0(double d2) {
        HotTopicDetailHeadView hotTopicDetailHeadView = this.q;
        if (hotTopicDetailHeadView == null) {
            return;
        }
        int i2 = (int) (this.s + (PullRefreshFrameLayout.E * d2));
        ViewGroup.LayoutParams layoutParams = hotTopicDetailHeadView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i2;
            this.r = i2;
            this.q.setLayoutParams(layoutParams);
        }
    }

    @Override // d.a.k0.x1.b
    public void b(int i2) {
        this.D.g(i2);
    }

    @Override // d.a.k0.x1.b
    public void c(d.a.k0.c1.c.e eVar) {
        d.a.k0.c1.c.a aVar;
        if (eVar.c() != null) {
            aVar = eVar.c();
            aVar.f52373i = 3;
        } else if (eVar.d() != null) {
            aVar = eVar.d();
            aVar.f52373i = 2;
        } else if (eVar.m() != null) {
            aVar = eVar.m();
            aVar.f52373i = 1;
        } else {
            aVar = null;
        }
        this.q.setBlessInfo(aVar);
        if (eVar.g() == null) {
            this.z.setVisibility(8);
            return;
        }
        this.z.setVisibility(0);
        this.z.i(eVar.g());
    }

    @Override // d.a.k0.x1.b
    public void d() {
        d.a.j0.d0.h hVar = this.o;
        if (hVar != null) {
            hVar.dettachView(this.m);
            this.o = null;
        }
    }

    @Override // d.a.k0.x1.b
    public void destroy() {
        p();
        d();
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.D;
        if (hotTopicDetailPagerAdapter != null) {
            hotTopicDetailPagerAdapter.d();
        }
        if (this.H) {
            Z();
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.I.removeAllListeners();
            this.I.removeAllUpdateListeners();
            this.I = null;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.M);
    }

    @Override // d.a.k0.x1.b
    public void e(boolean z) {
        d.a.j0.d0.h hVar = this.o;
        if (hVar == null || !hVar.isViewAttached()) {
            if (this.o == null) {
                this.o = new d.a.j0.d0.h(getContext(), new g());
            }
            this.o.j(this.f18532g.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.o.attachView(this.m, false);
            this.o.f(R.color.CAM_X0201);
            this.o.o();
        }
    }

    @Override // d.a.k0.x1.b
    public void f(long j2, long j3) {
        this.q.d(j2, j3);
    }

    @Override // d.a.k0.x1.b
    public d.a.k0.c1.c.e g() {
        return this.J;
    }

    @Override // d.a.k0.x1.b
    public void h() {
        if (this.n == null) {
            d.a.j0.d0.g gVar = new d.a.j0.d0.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            this.n = gVar;
            gVar.n(SkinManager.getColor(R.color.CAM_X0201));
        }
        this.n.attachView(this.m, false);
    }

    @Override // d.a.k0.x1.b
    public void i(boolean z, int i2) {
        this.D.q(z, i2);
    }

    @Override // d.a.k0.x1.b
    public void j(int i2) {
        this.D.r(i2);
    }

    @Override // d.a.k0.x1.b
    public int k() {
        return this.D.c();
    }

    @Override // d.a.k0.x1.b
    public void l() {
        if (this.H) {
            Z();
            d.a.c.e.m.e.a().removeCallbacks(this.M);
        }
    }

    @Override // d.a.k0.x1.b
    public void m(@NonNull d.a.k0.c1.c.e eVar) {
        this.J = eVar;
        if (eVar.h() != null) {
            this.B.d(this.J.h().f52393e);
            this.B.c(this.J.h().f52394f);
        }
        V(eVar);
    }

    @Override // d.a.k0.x1.b
    public void n(long j2, long j3, int i2) {
        this.z.j(j2, j3, i2);
    }

    @Override // d.a.k0.x1.b
    public d.a.k0.c1.c.d o(int i2) {
        return this.D.b(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // d.a.k0.x1.b
    public void p() {
        d.a.j0.d0.g gVar = this.n;
        if (gVar != null) {
            gVar.dettachView(this.m);
        }
    }

    @Override // d.a.k0.x1.b
    public void pause() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.D;
        if (hotTopicDetailPagerAdapter != null) {
            hotTopicDetailPagerAdapter.m();
        }
    }

    @Override // d.a.k0.x1.b
    public void q() {
        this.D.j();
    }

    @Override // d.a.k0.x1.b
    public void r(int i2) {
        this.D.h(i2);
    }

    @Override // d.a.k0.x1.b
    public void resume() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.D;
        if (hotTopicDetailPagerAdapter != null) {
            hotTopicDetailPagerAdapter.n();
        }
    }

    @Override // d.a.k0.x1.b
    public void s(d.a.k0.c1.c.d dVar, boolean z, int i2) {
        d.a.k0.c1.c.e eVar = this.J;
        if (eVar != null) {
            this.D.o(eVar.e());
        }
        this.D.s(dVar, z, i2);
    }
}
