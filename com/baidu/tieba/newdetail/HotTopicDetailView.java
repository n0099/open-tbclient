package com.baidu.tieba.newdetail;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.smartcolor.SmartColorSDK;
import com.baidu.smartcolor.utils.Tri;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StatusbarColorUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tbadk.switchs.IColorSDKSwitch;
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
import d.a.h0.a;
import d.a.m0.z0.i0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class HotTopicDetailView extends RelativeLayout implements d.a.n0.y1.b {
    public static int S = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    public HotTopicDetailPkLayout A;
    public HotTopicDetailSpecialLayout B;
    public d.a.n0.d1.b.c C;
    public CustomViewPager D;
    public HotTopicDetailPagerAdapter E;
    public TbTabLayout F;
    public View G;
    public RecyclerView.OnScrollListener H;
    public boolean I;
    public ValueAnimator J;
    public d.a.n0.d1.c.e K;
    public AppBarLayout.OnOffsetChangedListener L;
    public PullRefreshFrameLayout.i M;
    public final d.a.c.e.l.c<d.a.c.j.d.a> N;
    public Runnable O;
    public PullRefreshFrameLayout.h P;
    public ClickableSpan Q;
    public ClickableSpan R;

    /* renamed from: e  reason: collision with root package name */
    public int f18443e;

    /* renamed from: f  reason: collision with root package name */
    public int f18444f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f18445g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.y1.a f18446h;

    /* renamed from: i  reason: collision with root package name */
    public View f18447i;
    public NavigationBar j;
    public ImageView k;
    public boolean l;
    public ViewGroup m;
    public d.a.m0.d0.g n;
    public d.a.m0.d0.h o;
    public PullRefreshFrameLayout p;
    public HotTopicDetailHeadView q;
    public int r;
    public int s;
    public OvalActionButton t;
    public TextView u;
    public String v;
    public int w;
    public View x;
    public AppBarLayout y;
    public View z;

    /* loaded from: classes4.dex */
    public class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.v);
            if (HotTopicDetailView.this.v.length() > 500) {
                spannableStringBuilder.append((CharSequence) "...  ");
            }
            String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + GlideException.IndentedAppendable.INDENT;
            spannableStringBuilder.append((CharSequence) str);
            SpannableString spannableString = new SpannableString(spannableStringBuilder);
            spannableString.setSpan(HotTopicDetailView.this.R, spannableString.length() - str.length(), spannableString.length(), 33);
            HotTopicDetailView.this.u.setText(spannableString);
            HotTopicDetailView.this.u.setHeight(HotTopicDetailView.this.w * HotTopicDetailView.this.u.getLineHeight());
            int lineCount = HotTopicDetailView.this.u.getLineCount() * HotTopicDetailView.this.u.getLineHeight();
            if (lineCount > HotTopicDetailView.this.w * HotTopicDetailView.this.u.getLineHeight()) {
                HotTopicDetailView.this.u.scrollTo(0, lineCount - (HotTopicDetailView.this.w * HotTopicDetailView.this.u.getLineHeight()));
            }
            HotTopicDetailView.this.u.requestLayout();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            HotTopicDetailView.this.u.setText(HotTopicDetailView.this.v);
            HotTopicDetailView.this.V();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            HotTopicDetailView.this.X();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.a.c.e.p.j.z()) {
                HotTopicDetailView.this.f18445g.showToast(R.string.topic_share_no_network);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(HotTopicDetailView.this.k.getContext())) {
                HotTopicDetailView.this.f18446h.shareTopic(HotTopicDetailView.this.K);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicDetailView.this.z.setMinimumHeight(HotTopicDetailView.this.j.getHeight() + HotTopicDetailView.this.f18444f);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements AppBarLayout.OnOffsetChangedListener {
        public f() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (HotTopicDetailView.this.p != null) {
                HotTopicDetailView.this.p.setInterceptScrollDown(i2 == 0);
            }
            HotTopicDetailView.this.Z(i2);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements PullRefreshFrameLayout.i {

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f18455e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f18456f;

            public a(int i2, int i3) {
                this.f18455e = i2;
                this.f18456f = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailView.this.setHeight((int) (this.f18455e - (valueAnimator.getAnimatedFraction() * this.f18456f)));
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f18458e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f18459f;

            public b(int i2, int i3) {
                this.f18458e = i2;
                this.f18459f = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i2;
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (HotTopicDetailView.this.q == null || (i2 = this.f18458e) <= 0) {
                    return;
                }
                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * this.f18459f)));
            }
        }

        public g() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void k() {
            int i2 = HotTopicDetailView.this.r - HotTopicDetailView.this.s;
            if (i2 > 0) {
                HotTopicDetailView.this.J = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.J.setDuration(300L);
                HotTopicDetailView.this.J.addUpdateListener(new b(HotTopicDetailView.this.r, i2));
                HotTopicDetailView.this.J.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void l(double d2) {
            HotTopicDetailView.this.d0(d2);
            HotTopicDetailView.this.p.r();
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void m(int i2, double d2) {
            HotTopicDetailView.this.J = ValueAnimator.ofFloat(0.0f, 1.0f);
            HotTopicDetailView.this.J.setDuration(150L);
            HotTopicDetailView.this.J.addUpdateListener(new a(HotTopicDetailView.this.q.getHeight(), i2));
            HotTopicDetailView.this.J.start();
        }
    }

    /* loaded from: classes4.dex */
    public class h extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            Bitmap p;
            byte[] T;
            boolean z;
            int c2;
            super.onLoaded((h) aVar, str, i2);
            if (aVar == null || !aVar.w() || (p = aVar.p()) == null || (T = HotTopicDetailView.this.T(p, Bitmap.CompressFormat.JPEG, 100)) == null) {
                return;
            }
            a.C0541a c0541a = new a.C0541a();
            c0541a.c(Tri.TRUE);
            c0541a.b(Tri.TRUE);
            c0541a.d(50, 100);
            c0541a.e(40, 80);
            String c3 = SmartColorSDK.b().c(c0541a.a(), T, T.length);
            if (TextUtils.isEmpty(c3) || (c2 = d.a.n0.e3.c.c(c3)) == Integer.MAX_VALUE) {
                z = false;
            } else {
                z = true;
                if (HotTopicDetailView.this.t != null) {
                    HotTopicDetailView.this.t.setStartAndEndColor(c2, c2);
                }
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_COLOR_FETCH_COLOR);
            statisticItem.addParam("obj_type", z ? "1" : "0");
            if (!z) {
                if (str != null && str.length() > 100) {
                    statisticItem.addParam("obj_source", str.substring(0, 100));
                } else {
                    statisticItem.addParam("obj_source", str);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.a.c.e.p.j.A() || HotTopicDetailView.this.f18446h == null) {
                return;
            }
            HotTopicDetailView.this.f18446h.refreshFullData(1);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HotTopicDetailView.this.I) {
                HotTopicDetailView.this.c0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements PullRefreshFrameLayout.h {
        public k() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.h
        public void m() {
            HotTopicDetailView.this.U();
        }
    }

    public HotTopicDetailView(TbPageContext<?> tbPageContext, d.a.n0.y1.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.f18443e = 3;
        this.f18444f = UtilHelper.getStatusBarHeight();
        this.l = false;
        this.v = "";
        this.H = new c();
        this.I = false;
        this.L = new f();
        this.M = new g();
        this.N = new h();
        this.O = new j();
        this.P = new k();
        this.Q = new a();
        this.R = new b();
        this.f18445g = tbPageContext;
        this.f18446h = aVar;
        a0(bundle);
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

    public final byte[] T(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(compressFormat, i2, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void U() {
        d.a.c.e.m.e.a().postDelayed(this.O, 5000L);
        this.I = true;
        this.f18446h.refreshFullData(k());
    }

    public final void V() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.v);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.u.getLayout().getLineEnd(1) - string.length()) - 2);
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.Q, length - 1, spannableString.length(), 33);
        this.u.setText(spannableString);
        TextView textView = this.u;
        textView.setHeight(textView.getLineHeight() * 2);
        this.u.scrollTo(0, 0);
        this.u.requestLayout();
    }

    public final void W(d.a.n0.d1.c.f fVar) {
        if (StringUtils.isNull(fVar.f52575g)) {
            this.u.setVisibility(8);
        } else {
            this.u.setText(fVar.f52575g);
        }
    }

    public final void X() {
        if (this.f18444f + this.j.getHeight() >= this.x.getY()) {
            SkinManager.setBackgroundColor(this.F, R.color.CAM_X0207);
            if (this.f18443e == 0) {
                this.G.setVisibility(0);
                return;
            }
            return;
        }
        SkinManager.setBackgroundColor(this.F, R.color.transparent);
        this.G.setVisibility(8);
    }

    public final void Y(@NonNull d.a.n0.d1.c.e eVar) {
        b0();
        this.q.setTopicInfo(eVar.h());
        if (SwitchManager.getInstance().findType(IColorSDKSwitch.KEY) == 1 && eVar.h() != null && !TextUtils.isEmpty(eVar.h().f52577i)) {
            d.a.c.e.l.d.h().m(eVar.h().f52577i, 39, this.N, this.f18445g.getUniqueId());
        }
        W(eVar.h());
        c(eVar);
        List<n> l = eVar.l();
        if (ListUtils.isEmpty(l)) {
            this.B.setVisibility(8);
        } else {
            this.B.setData(l);
            this.B.setVisibility(0);
        }
        if (eVar.h() != null) {
            String str = eVar.h().f52574f;
            if (i0.d(str) > 15) {
                str = i0.m(str, 15) + StringHelper.STRING_MORE;
            }
            this.j.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    public final void Z(int i2) {
        int i3 = i2 + S;
        if (i3 < 0) {
            i3 = 0;
        }
        float f2 = 1.0f - ((i3 * 1.0f) / S);
        this.f18447i.setAlpha(f2);
        this.j.getCenterText().setAlpha(f2);
        X();
        double d2 = f2;
        if (d2 > 0.1d) {
            StatusbarColorUtils.setStatusBarDarkIcon(this.f18445g.getPageActivity().getWindow(), true);
        } else {
            StatusbarColorUtils.setStatusBarDarkIcon(this.f18445g.getPageActivity().getWindow(), false);
        }
        if ((d2 > 0.3d && this.f18443e == 0) || this.K == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.j.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.j.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // d.a.n0.y1.b
    public void a() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f18443e) {
            return;
        }
        this.q.h(skinType);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.z, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f18447i, R.color.CAM_X0207);
        SkinManager.setNavbarTitleColor(this.j.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        d.a.m0.d0.g gVar = this.n;
        if (gVar != null) {
            gVar.n(SkinManager.getColor(R.color.CAM_X0201));
        }
        this.A.m(skinType);
        this.F.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
        this.B.H(skinType);
        this.E.l(skinType);
        this.f18443e = skinType;
    }

    public final void a0(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.topBgView);
        this.f18447i = findViewById;
        findViewById.setAlpha(0.0f);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.j = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.getCenterText().setAlpha(0.0f);
        ImageView imageView = (ImageView) this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d());
        this.k = imageView;
        imageView.setVisibility(4);
        View findViewById2 = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
        layoutParams.height = this.f18444f;
        findViewById2.setLayoutParams(layoutParams);
        this.m = (ViewGroup) findViewById(R.id.contentRootLayout);
        PullRefreshFrameLayout pullRefreshFrameLayout = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.p = pullRefreshFrameLayout;
        pullRefreshFrameLayout.setOnTouchCallback(this.M);
        this.p.setOnPullRefreshListener(this.P);
        this.p.setFromFrs();
        this.p.h();
        this.q = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        int g2 = l.g(getContext(), R.dimen.tbds600);
        this.s = g2;
        this.r = g2;
        this.z = findViewById(R.id.headerContainerLayout);
        this.j.post(new e());
        this.u = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.A = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        HotTopicDetailSpecialLayout hotTopicDetailSpecialLayout = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.B = hotTopicDetailSpecialLayout;
        hotTopicDetailSpecialLayout.F(this.f18445g);
        this.x = findViewById(R.id.contentContainer);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.y = appBarLayout;
        appBarLayout.addOnOffsetChangedListener(this.L);
        this.D = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = new HotTopicDetailPagerAdapter(getContext());
        this.E = hotTopicDetailPagerAdapter;
        hotTopicDetailPagerAdapter.p(this.H);
        this.D.setAdapter(this.E);
        TbTabLayout tbTabLayout = (TbTabLayout) findViewById(R.id.tabLayout);
        this.F = tbTabLayout;
        tbTabLayout.setSelectedTabTextBlod(true);
        this.F.setTabTextSize(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.F.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
        this.F.setupWithViewPager(this.D);
        this.G = findViewById(R.id.dividerShadow);
        OvalActionButton ovalActionButton = (OvalActionButton) findViewById(R.id.topic_post_forum_button);
        this.t = ovalActionButton;
        this.C = new d.a.n0.d1.b.c(ovalActionButton, this.f18445g);
    }

    @Override // d.a.n0.y1.b
    public void b(int i2) {
        this.E.g(i2);
    }

    public final void b0() {
        if (this.l) {
            return;
        }
        this.l = true;
        this.k.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.j.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.j.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        d.a.n0.y1.a aVar = this.f18446h;
        if (aVar instanceof Activity) {
            UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) aVar);
        }
    }

    @Override // d.a.n0.y1.b
    public void c(d.a.n0.d1.c.e eVar) {
        d.a.n0.d1.c.a aVar;
        if (eVar.c() != null) {
            aVar = eVar.c();
            aVar.f52553i = 3;
        } else if (eVar.d() != null) {
            aVar = eVar.d();
            aVar.f52553i = 2;
        } else if (eVar.m() != null) {
            aVar = eVar.m();
            aVar.f52553i = 1;
        } else {
            aVar = null;
        }
        this.q.setBlessInfo(aVar);
        if (eVar.g() == null) {
            this.A.setVisibility(8);
            return;
        }
        this.A.setVisibility(0);
        this.A.i(eVar.g());
    }

    public final void c0() {
        this.I = false;
        PullRefreshFrameLayout pullRefreshFrameLayout = this.p;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.p();
        }
    }

    @Override // d.a.n0.y1.b
    public void d() {
        d.a.m0.d0.h hVar = this.o;
        if (hVar != null) {
            hVar.dettachView(this.m);
            this.o = null;
        }
    }

    public void d0(double d2) {
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

    @Override // d.a.n0.y1.b
    public void destroy() {
        p();
        d();
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.E;
        if (hotTopicDetailPagerAdapter != null) {
            hotTopicDetailPagerAdapter.d();
        }
        if (this.I) {
            c0();
        }
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.J.removeAllListeners();
            this.J.removeAllUpdateListeners();
            this.J = null;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.O);
    }

    @Override // d.a.n0.y1.b
    public void e(boolean z) {
        d.a.m0.d0.h hVar = this.o;
        if (hVar == null || !hVar.isViewAttached()) {
            if (this.o == null) {
                this.o = new d.a.m0.d0.h(getContext(), new i());
            }
            this.o.j(this.f18445g.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.o.attachView(this.m, false);
            this.o.f(R.color.CAM_X0201);
            this.o.o();
        }
    }

    @Override // d.a.n0.y1.b
    public void f(long j2, long j3) {
        this.q.d(j2, j3);
    }

    @Override // d.a.n0.y1.b
    public d.a.n0.d1.c.e g() {
        return this.K;
    }

    @Override // d.a.n0.y1.b
    public void h() {
        if (this.n == null) {
            d.a.m0.d0.g gVar = new d.a.m0.d0.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            this.n = gVar;
            gVar.n(SkinManager.getColor(R.color.CAM_X0201));
        }
        this.n.attachView(this.m, false);
    }

    @Override // d.a.n0.y1.b
    public void i(boolean z, int i2) {
        this.E.q(z, i2);
    }

    @Override // d.a.n0.y1.b
    public void j(int i2) {
        this.E.r(i2);
    }

    @Override // d.a.n0.y1.b
    public int k() {
        return this.E.c();
    }

    @Override // d.a.n0.y1.b
    public void l() {
        if (this.I) {
            c0();
            d.a.c.e.m.e.a().removeCallbacks(this.O);
        }
    }

    @Override // d.a.n0.y1.b
    public void m(@NonNull d.a.n0.d1.c.e eVar) {
        this.K = eVar;
        if (eVar.h() != null) {
            this.C.d(this.K.h().f52573e);
            this.C.c(this.K.h().f52574f);
        }
        Y(eVar);
    }

    @Override // d.a.n0.y1.b
    public void n(long j2, long j3, int i2) {
        this.A.j(j2, j3, i2);
    }

    @Override // d.a.n0.y1.b
    public d.a.n0.d1.c.d o(int i2) {
        return this.E.b(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // d.a.n0.y1.b
    public void p() {
        d.a.m0.d0.g gVar = this.n;
        if (gVar != null) {
            gVar.dettachView(this.m);
        }
    }

    @Override // d.a.n0.y1.b
    public void pause() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.E;
        if (hotTopicDetailPagerAdapter != null) {
            hotTopicDetailPagerAdapter.m();
        }
    }

    @Override // d.a.n0.y1.b
    public void q() {
        this.E.j();
    }

    @Override // d.a.n0.y1.b
    public void r(int i2) {
        this.E.h(i2);
    }

    @Override // d.a.n0.y1.b
    public void resume() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.E;
        if (hotTopicDetailPagerAdapter != null) {
            hotTopicDetailPagerAdapter.n();
        }
    }

    @Override // d.a.n0.y1.b
    public void s(d.a.n0.d1.c.d dVar, boolean z, int i2) {
        d.a.n0.d1.c.e eVar = this.K;
        if (eVar != null) {
            this.E.o(eVar.e());
        }
        this.E.s(dVar, z, i2);
    }
}
