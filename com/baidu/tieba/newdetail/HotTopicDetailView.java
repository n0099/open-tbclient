package com.baidu.tieba.newdetail;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.c;
import com.baidu.tieba.hottopic.data.d;
import com.baidu.tieba.hottopic.data.e;
import com.baidu.tieba.hottopic.data.f;
import com.baidu.tieba.newdetail.a;
import com.baidu.tieba.newdetail.adapter.HotTopicDetailPagerAdapter;
import com.baidu.tieba.newdetail.view.HotTopicDetailHeadView;
import com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialLayout;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes21.dex */
public class HotTopicDetailView extends RelativeLayout implements a.b {
    private static int lpk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String OW;
    private int czk;
    private TbTabLayout fXB;
    private ValueAnimator fbQ;
    private g gAe;
    private int iVk;
    private int iVl;
    private AppBarLayout.OnOffsetChangedListener iWl;
    private ImageView jYm;
    private boolean jxE;
    private PullRefreshFrameLayout.d jxM;
    private PullRefreshFrameLayout.c jxN;
    private Runnable jxO;
    private int kfX;
    private ClickableSpan kgc;
    private ClickableSpan kgd;
    private c kgp;
    private RecyclerView.OnScrollListener lpA;
    private e lpB;
    private a.InterfaceC0814a lpl;
    private View lpm;
    private boolean lpn;
    private ViewGroup lpo;
    private PullRefreshFrameLayout lpp;
    private HotTopicDetailHeadView lpq;
    private TextView lpr;
    private View lps;
    private AppBarLayout lpt;
    private View lpu;
    private HotTopicDetailPkLayout lpv;
    private HotTopicDetailSpecialLayout lpw;
    private CustomViewPager lpx;
    private HotTopicDetailPagerAdapter lpy;
    private View lpz;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0814a interfaceC0814a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.czk = UtilHelper.getStatusBarHeight();
        this.lpn = false;
        this.OW = "";
        this.lpA = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.dkf();
            }
        };
        this.jxE = false;
        this.iWl = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.lpp != null) {
                    HotTopicDetailView.this.lpp.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.Gw(i);
            }
        };
        this.jxM = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                HotTopicDetailView.this.C(d);
                HotTopicDetailView.this.lpp.bvo();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicDetailView.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.fbQ.setDuration(150L);
                final int height = HotTopicDetailView.this.lpq.getHeight();
                HotTopicDetailView.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.fbQ.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bvr() {
                final int i = HotTopicDetailView.this.iVl - HotTopicDetailView.this.iVk;
                if (i > 0) {
                    HotTopicDetailView.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.fbQ.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.iVl;
                    HotTopicDetailView.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.lpq != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.fbQ.start();
                }
            }
        };
        this.jxO = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.jxE) {
                    HotTopicDetailView.this.cLc();
                }
            }
        };
        this.jxN = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bvq() {
                HotTopicDetailView.this.cLb();
            }
        };
        this.kgc = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.OW);
                if (HotTopicDetailView.this.OW.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicDetailView.this.kgd, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.lpr.setText(spannableString);
                HotTopicDetailView.this.lpr.setHeight(HotTopicDetailView.this.kfX * HotTopicDetailView.this.lpr.getLineHeight());
                int lineCount = HotTopicDetailView.this.lpr.getLineCount() * HotTopicDetailView.this.lpr.getLineHeight();
                if (lineCount > HotTopicDetailView.this.kfX * HotTopicDetailView.this.lpr.getLineHeight()) {
                    HotTopicDetailView.this.lpr.scrollTo(0, lineCount - (HotTopicDetailView.this.kfX * HotTopicDetailView.this.lpr.getLineHeight()));
                }
                HotTopicDetailView.this.lpr.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kgd = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.lpr.setText(HotTopicDetailView.this.OW);
                HotTopicDetailView.this.cSl();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.mPageContext = tbPageContext;
        this.lpl = interfaceC0814a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.lpm = findViewById(R.id.topBgView);
        this.lpm.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.jYm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bh.checkUpIsLogin(HotTopicDetailView.this.jYm.getContext())) {
                    HotTopicDetailView.this.lpl.e(HotTopicDetailView.this.lpB);
                }
            }
        });
        this.jYm.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.czk;
        findViewById.setLayoutParams(layoutParams);
        this.lpo = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.lpp = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lpp.setOnTouchCallback(this.jxM);
        this.lpp.setOnPullRefreshListener(this.jxN);
        this.lpp.setFromFrs();
        this.lpp.bvn();
        this.lpq = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.iVk = l.getDimens(getContext(), R.dimen.tbds600);
        this.iVl = this.iVk;
        this.lpu = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.lpu.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.czk);
            }
        });
        this.lpr = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.lpv = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.lpw = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.lpw.x(this.mPageContext);
        this.lps = findViewById(R.id.contentContainer);
        this.lpt = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.lpt.addOnOffsetChangedListener(this.iWl);
        this.lpx = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.lpy = new HotTopicDetailPagerAdapter(getContext());
        this.lpy.setScrollListener(this.lpA);
        this.lpx.setAdapter(this.lpy);
        this.fXB = (TbTabLayout) findViewById(R.id.tabLayout);
        this.fXB.setSelectedTabTextBlod(true);
        this.fXB.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.fXB.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
        this.fXB.setupWithViewPager(this.lpx);
        this.lpz = findViewById(R.id.dividerShadow);
        this.kgp = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void C(double d) {
        if (this.lpq != null) {
            int i = (int) (this.iVk + (PullRefreshFrameLayout.fbv * d));
            ViewGroup.LayoutParams layoutParams = this.lpq.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iVl = layoutParams.height;
                this.lpq.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.lpq != null && (layoutParams = this.lpq.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iVl = i;
            this.lpq.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gw(int i) {
        int i2 = lpk + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / lpk);
        this.lpm.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        dkf();
        if (f > 0.1d) {
            as.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            as.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.lpB == null) {
            SvgManager.btW().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.jYm, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.btW().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.btW().a(this.jYm, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkf() {
        if (this.czk + this.mNavigationBar.getHeight() >= this.lps.getY()) {
            ap.setBackgroundColor(this.fXB, R.color.CAM_X0207);
            if (this.mSkinType == 0) {
                this.lpz.setVisibility(0);
                return;
            }
            return;
        }
        ap.setBackgroundColor(this.fXB, R.color.transparent);
        this.lpz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLc() {
        this.jxE = false;
        if (this.lpp != null) {
            this.lpp.bvm();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void djY() {
        if (this.gAe == null) {
            this.gAe = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            this.gAe.setBackground(ap.getColor(R.color.CAM_X0201));
        }
        this.gAe.attachView(this.lpo, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void djZ() {
        if (this.gAe != null) {
            this.gAe.dettachView(this.lpo);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bSl() {
        if (this.jxE) {
            cLc();
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxO);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void ue(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.lpl != null) {
                            HotTopicDetailView.this.lpl.Gn(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lpo, false);
            this.mRefreshView.setBackGroundColor(R.color.CAM_X0201);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dka() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lpo);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Gq(int i) {
        this.lpy.Gq(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Gr(int i) {
        this.lpy.Gr(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void F(boolean z, int i) {
        this.lpy.F(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Gs(int i) {
        this.lpy.Gs(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(@NonNull e eVar) {
        this.lpB = eVar;
        if (this.lpB.cRS() != null) {
            this.kgp.setTopicId(this.lpB.cRS().eXq);
            this.kgp.DW(this.lpB.cRS().eIa);
        }
        h(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.lpB != null) {
            this.lpy.c(this.lpB.cRY());
        }
        this.lpy.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e dkb() {
        return this.lpB;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d Gt(int i) {
        return this.lpy.Gt(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int dkc() {
        return this.lpy.dkc();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dkd() {
        this.lpy.dkd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLb() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jxO, 5000L);
        this.jxE = true;
        this.lpl.Gn(dkc());
    }

    private void bFP() {
        if (!this.lpn) {
            this.lpn = true;
            this.jYm.setVisibility(0);
            SvgManager.btW().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.jYm, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.lpl instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lpl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSl() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OW);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.lpr.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.kgc, length - 1, spannableString.length(), 33);
        this.lpr.setText(spannableString);
        this.lpr.setHeight(this.lpr.getLineHeight() * 2);
        this.lpr.scrollTo(0, 0);
        this.lpr.requestLayout();
    }

    private void h(@NonNull e eVar) {
        bFP();
        this.lpq.setTopicInfo(eVar.cRS());
        a(eVar.cRS());
        g(eVar);
        List<q> cSa = eVar.cSa();
        if (y.isEmpty(cSa)) {
            this.lpw.setVisibility(8);
        } else {
            this.lpw.setData(cSa);
            this.lpw.setVisibility(0);
        }
        if (eVar.cRS() != null) {
            String str = eVar.cRS().eIa;
            if (ae.getTextLengthWithEmoji(str) > 15) {
                str = ae.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.kdG)) {
            this.lpr.setVisibility(8);
        } else {
            this.lpr.setText(fVar.kdG);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.lpq.onChangeSkinType(skinType);
            ap.setViewTextColor(this.lpr, R.color.CAM_X0105, 1);
            ap.setBackgroundColor(this.lpu, R.color.CAM_X0201);
            ap.setBackgroundColor(this.lpm, R.color.CAM_X0207);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.gAe != null) {
                this.gAe.setBackground(ap.getColor(R.color.CAM_X0201));
            }
            this.lpv.onChangeSkinType(skinType);
            this.fXB.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
            this.lpw.onChangeSkinType(skinType);
            this.lpy.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(long j, long j2, int i) {
        this.lpv.e(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void D(long j, long j2) {
        this.lpq.E(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.lpy != null) {
            this.lpy.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.lpy != null) {
            this.lpy.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        djZ();
        dka();
        if (this.lpy != null) {
            this.lpy.destroy();
        }
        if (this.jxE) {
            cLc();
        }
        if (this.fbQ != null) {
            this.fbQ.cancel();
            this.fbQ.removeAllListeners();
            this.fbQ.removeAllUpdateListeners();
            this.fbQ = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxO);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void g(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cRU() != null) {
            aVar = eVar.cRU();
            aVar.kdh = 3;
        } else if (eVar.cRV() != null) {
            aVar = eVar.cRV();
            aVar.kdh = 2;
        } else if (eVar.cRW() != null) {
            aVar = eVar.cRW();
            aVar.kdh = 1;
        }
        this.lpq.setBlessInfo(aVar);
        if (eVar.cRT() == null) {
            this.lpv.setVisibility(8);
            return;
        }
        this.lpv.setVisibility(0);
        this.lpv.a(eVar.cRT());
    }
}
