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
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.h0.z0.i0;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class HotTopicDetailView extends RelativeLayout implements d.b.i0.w1.b {
    public static int Q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public HotTopicDetailSpecialLayout A;
    public d.b.i0.b1.b.c B;
    public CustomViewPager C;
    public HotTopicDetailPagerAdapter D;
    public TbTabLayout E;
    public View F;
    public RecyclerView.OnScrollListener G;
    public boolean H;
    public ValueAnimator I;
    public d.b.i0.b1.c.e J;
    public AppBarLayout.OnOffsetChangedListener K;
    public PullRefreshFrameLayout.i L;
    public Runnable M;
    public PullRefreshFrameLayout.h N;
    public ClickableSpan O;
    public ClickableSpan P;

    /* renamed from: e  reason: collision with root package name */
    public int f19120e;

    /* renamed from: f  reason: collision with root package name */
    public int f19121f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f19122g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.w1.a f19123h;
    public View i;
    public NavigationBar j;
    public ImageView k;
    public boolean l;
    public ViewGroup m;
    public d.b.h0.d0.g n;
    public d.b.h0.d0.h o;
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
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            HotTopicDetailView.this.U();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.b.b.e.p.j.z()) {
                HotTopicDetailView.this.f19122g.showToast(R.string.topic_share_no_network);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(HotTopicDetailView.this.k.getContext())) {
                HotTopicDetailView.this.f19123h.shareTopic(HotTopicDetailView.this.J);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicDetailView.this.y.setMinimumHeight(HotTopicDetailView.this.j.getHeight() + HotTopicDetailView.this.f19121f);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        public e() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (HotTopicDetailView.this.p != null) {
                HotTopicDetailView.this.p.setInterceptScrollDown(i == 0);
            }
            HotTopicDetailView.this.W(i);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements PullRefreshFrameLayout.i {

        /* loaded from: classes3.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19130e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f19131f;

            public a(int i, int i2) {
                this.f19130e = i;
                this.f19131f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailView.this.setHeight((int) (this.f19130e - (valueAnimator.getAnimatedFraction() * this.f19131f)));
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19133e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f19134f;

            public b(int i, int i2) {
                this.f19133e = i;
                this.f19134f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i;
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (HotTopicDetailView.this.q == null || (i = this.f19133e) <= 0) {
                    return;
                }
                HotTopicDetailView.this.setHeight((int) (i - (floatValue * this.f19134f)));
            }
        }

        public f() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void o() {
            int i = HotTopicDetailView.this.r - HotTopicDetailView.this.s;
            if (i > 0) {
                HotTopicDetailView.this.I = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.I.setDuration(300L);
                HotTopicDetailView.this.I.addUpdateListener(new b(HotTopicDetailView.this.r, i));
                HotTopicDetailView.this.I.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void p(double d2) {
            HotTopicDetailView.this.a0(d2);
            HotTopicDetailView.this.p.r();
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void q(int i, double d2) {
            HotTopicDetailView.this.I = ValueAnimator.ofFloat(0.0f, 1.0f);
            HotTopicDetailView.this.I.setDuration(150L);
            HotTopicDetailView.this.I.addUpdateListener(new a(HotTopicDetailView.this.q.getHeight(), i));
            HotTopicDetailView.this.I.start();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.b.b.e.p.j.A() || HotTopicDetailView.this.f19123h == null) {
                return;
            }
            HotTopicDetailView.this.f19123h.refreshFullData(1);
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

    public HotTopicDetailView(TbPageContext<?> tbPageContext, d.b.i0.w1.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.f19120e = 3;
        this.f19121f = UtilHelper.getStatusBarHeight();
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
        this.f19122g = tbPageContext;
        this.f19123h = aVar;
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
        d.b.b.e.m.e.a().postDelayed(this.M, 5000L);
        this.H = true;
        this.f19123h.refreshFullData(h());
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

    public final void T(d.b.i0.b1.c.f fVar) {
        if (StringUtils.isNull(fVar.f52113g)) {
            this.t.setVisibility(8);
        } else {
            this.t.setText(fVar.f52113g);
        }
    }

    public final void U() {
        if (this.f19121f + this.j.getHeight() >= this.w.getY()) {
            SkinManager.setBackgroundColor(this.E, R.color.CAM_X0207);
            if (this.f19120e == 0) {
                this.F.setVisibility(0);
                return;
            }
            return;
        }
        SkinManager.setBackgroundColor(this.E, R.color.transparent);
        this.F.setVisibility(8);
    }

    public final void V(@NonNull d.b.i0.b1.c.e eVar) {
        Y();
        this.q.setTopicInfo(eVar.h());
        T(eVar.h());
        g(eVar);
        List<n> l = eVar.l();
        if (ListUtils.isEmpty(l)) {
            this.A.setVisibility(8);
        } else {
            this.A.setData(l);
            this.A.setVisibility(0);
        }
        if (eVar.h() != null) {
            String str = eVar.h().f52112f;
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
        this.i.setAlpha(f2);
        this.j.getCenterText().setAlpha(f2);
        U();
        double d2 = f2;
        if (d2 > 0.1d) {
            StatusbarColorUtils.setStatusBarDarkIcon(this.f19122g.getPageActivity().getWindow(), true);
        } else {
            StatusbarColorUtils.setStatusBarDarkIcon(this.f19122g.getPageActivity().getWindow(), false);
        }
        if ((d2 > 0.3d && this.f19120e == 0) || this.J == null) {
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
        this.i = findViewById;
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
        layoutParams.height = this.f19121f;
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
        hotTopicDetailSpecialLayout.F(this.f19122g);
        this.w = findViewById(R.id.contentContainer);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.x = appBarLayout;
        appBarLayout.addOnOffsetChangedListener(this.K);
        this.C = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = new HotTopicDetailPagerAdapter(getContext());
        this.D = hotTopicDetailPagerAdapter;
        hotTopicDetailPagerAdapter.x(this.G);
        this.C.setAdapter(this.D);
        TbTabLayout tbTabLayout = (TbTabLayout) findViewById(R.id.tabLayout);
        this.E = tbTabLayout;
        tbTabLayout.setSelectedTabTextBlod(true);
        this.E.setTabTextSize(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.E.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
        this.E.setupWithViewPager(this.C);
        this.F = findViewById(R.id.dividerShadow);
        this.B = new d.b.i0.b1.b.c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.f19122g);
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
        d.b.i0.w1.a aVar = this.f19123h;
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

    @Override // d.b.i0.w1.b
    public void a() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f19120e) {
            return;
        }
        this.q.h(skinType);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.y, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0207);
        SkinManager.setNavbarTitleColor(this.j.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        d.b.h0.d0.g gVar = this.n;
        if (gVar != null) {
            gVar.n(SkinManager.getColor(R.color.CAM_X0201));
        }
        this.z.m(skinType);
        this.E.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
        this.A.H(skinType);
        this.D.s(skinType);
        this.f19120e = skinType;
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

    @Override // d.b.i0.w1.b
    public d.b.i0.b1.c.e b() {
        return this.J;
    }

    @Override // d.b.i0.w1.b
    public void c() {
        if (this.n == null) {
            d.b.h0.d0.g gVar = new d.b.h0.d0.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            this.n = gVar;
            gVar.n(SkinManager.getColor(R.color.CAM_X0201));
        }
        this.n.attachView(this.m, false);
    }

    @Override // d.b.i0.w1.b
    public void d(int i2) {
        this.D.n(i2);
    }

    @Override // d.b.i0.w1.b
    public void destroy() {
        o();
        i();
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.D;
        if (hotTopicDetailPagerAdapter != null) {
            hotTopicDetailPagerAdapter.k();
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
        d.b.b.e.m.e.a().removeCallbacks(this.M);
    }

    @Override // d.b.i0.w1.b
    public void e(boolean z, int i2) {
        this.D.y(z, i2);
    }

    @Override // d.b.i0.w1.b
    public void f(int i2) {
        this.D.z(i2);
    }

    @Override // d.b.i0.w1.b
    public void g(d.b.i0.b1.c.e eVar) {
        d.b.i0.b1.c.a aVar;
        if (eVar.c() != null) {
            aVar = eVar.c();
            aVar.i = 3;
        } else if (eVar.d() != null) {
            aVar = eVar.d();
            aVar.i = 2;
        } else if (eVar.m() != null) {
            aVar = eVar.m();
            aVar.i = 1;
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

    @Override // d.b.i0.w1.b
    public int h() {
        return this.D.j();
    }

    @Override // d.b.i0.w1.b
    public void i() {
        d.b.h0.d0.h hVar = this.o;
        if (hVar != null) {
            hVar.dettachView(this.m);
            this.o = null;
        }
    }

    @Override // d.b.i0.w1.b
    public void j(boolean z) {
        d.b.h0.d0.h hVar = this.o;
        if (hVar == null || !hVar.isViewAttached()) {
            if (this.o == null) {
                this.o = new d.b.h0.d0.h(getContext(), new g());
            }
            this.o.j(this.f19122g.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.o.attachView(this.m, false);
            this.o.f(R.color.CAM_X0201);
            this.o.o();
        }
    }

    @Override // d.b.i0.w1.b
    public void k() {
        if (this.H) {
            Z();
            d.b.b.e.m.e.a().removeCallbacks(this.M);
        }
    }

    @Override // d.b.i0.w1.b
    public void l(@NonNull d.b.i0.b1.c.e eVar) {
        this.J = eVar;
        if (eVar.h() != null) {
            this.B.d(this.J.h().f52111e);
            this.B.c(this.J.h().f52112f);
        }
        V(eVar);
    }

    @Override // d.b.i0.w1.b
    public void m(long j2, long j3, int i2) {
        this.z.j(j2, j3, i2);
    }

    @Override // d.b.i0.w1.b
    public d.b.i0.b1.c.d n(int i2) {
        return this.D.i(i2);
    }

    @Override // d.b.i0.w1.b
    public void o() {
        d.b.h0.d0.g gVar = this.n;
        if (gVar != null) {
            gVar.dettachView(this.m);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // d.b.i0.w1.b
    public void p() {
        this.D.q();
    }

    @Override // d.b.i0.w1.b
    public void pause() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.D;
        if (hotTopicDetailPagerAdapter != null) {
            hotTopicDetailPagerAdapter.u();
        }
    }

    @Override // d.b.i0.w1.b
    public void q(int i2) {
        this.D.o(i2);
    }

    @Override // d.b.i0.w1.b
    public void r(d.b.i0.b1.c.d dVar, boolean z, int i2) {
        d.b.i0.b1.c.e eVar = this.J;
        if (eVar != null) {
            this.D.w(eVar.e());
        }
        this.D.A(dVar, z, i2);
    }

    @Override // d.b.i0.w1.b
    public void resume() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.D;
        if (hotTopicDetailPagerAdapter != null) {
            hotTopicDetailPagerAdapter.v();
        }
    }

    @Override // d.b.i0.w1.b
    public void s(long j2, long j3) {
        this.q.d(j2, j3);
    }
}
