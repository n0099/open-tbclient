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
    private static int lpm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String OW;
    private int czk;
    private TbTabLayout fXD;
    private ValueAnimator fbQ;
    private g gAg;
    private int iVm;
    private int iVn;
    private AppBarLayout.OnOffsetChangedListener iWn;
    private ImageView jYo;
    private boolean jxG;
    private PullRefreshFrameLayout.d jxO;
    private PullRefreshFrameLayout.c jxP;
    private Runnable jxQ;
    private int kfZ;
    private ClickableSpan kge;
    private ClickableSpan kgf;
    private c kgr;
    private HotTopicDetailPagerAdapter lpA;
    private View lpB;
    private RecyclerView.OnScrollListener lpC;
    private e lpD;
    private a.InterfaceC0814a lpn;
    private View lpo;
    private boolean lpp;
    private ViewGroup lpq;
    private PullRefreshFrameLayout lpr;
    private HotTopicDetailHeadView lps;
    private TextView lpt;
    private View lpu;
    private AppBarLayout lpv;
    private View lpw;
    private HotTopicDetailPkLayout lpx;
    private HotTopicDetailSpecialLayout lpy;
    private CustomViewPager lpz;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0814a interfaceC0814a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.czk = UtilHelper.getStatusBarHeight();
        this.lpp = false;
        this.OW = "";
        this.lpC = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.dkg();
            }
        };
        this.jxG = false;
        this.iWn = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.lpr != null) {
                    HotTopicDetailView.this.lpr.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.Gw(i);
            }
        };
        this.jxO = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                HotTopicDetailView.this.C(d);
                HotTopicDetailView.this.lpr.bvo();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicDetailView.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.fbQ.setDuration(150L);
                final int height = HotTopicDetailView.this.lps.getHeight();
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
                final int i = HotTopicDetailView.this.iVn - HotTopicDetailView.this.iVm;
                if (i > 0) {
                    HotTopicDetailView.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.fbQ.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.iVn;
                    HotTopicDetailView.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.lps != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.fbQ.start();
                }
            }
        };
        this.jxQ = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.jxG) {
                    HotTopicDetailView.this.cLd();
                }
            }
        };
        this.jxP = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bvq() {
                HotTopicDetailView.this.cLc();
            }
        };
        this.kge = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
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
                spannableString.setSpan(HotTopicDetailView.this.kgf, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.lpt.setText(spannableString);
                HotTopicDetailView.this.lpt.setHeight(HotTopicDetailView.this.kfZ * HotTopicDetailView.this.lpt.getLineHeight());
                int lineCount = HotTopicDetailView.this.lpt.getLineCount() * HotTopicDetailView.this.lpt.getLineHeight();
                if (lineCount > HotTopicDetailView.this.kfZ * HotTopicDetailView.this.lpt.getLineHeight()) {
                    HotTopicDetailView.this.lpt.scrollTo(0, lineCount - (HotTopicDetailView.this.kfZ * HotTopicDetailView.this.lpt.getLineHeight()));
                }
                HotTopicDetailView.this.lpt.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kgf = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.lpt.setText(HotTopicDetailView.this.OW);
                HotTopicDetailView.this.cSm();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.mPageContext = tbPageContext;
        this.lpn = interfaceC0814a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.lpo = findViewById(R.id.topBgView);
        this.lpo.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.jYo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bh.checkUpIsLogin(HotTopicDetailView.this.jYo.getContext())) {
                    HotTopicDetailView.this.lpn.e(HotTopicDetailView.this.lpD);
                }
            }
        });
        this.jYo.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.czk;
        findViewById.setLayoutParams(layoutParams);
        this.lpq = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.lpr = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lpr.setOnTouchCallback(this.jxO);
        this.lpr.setOnPullRefreshListener(this.jxP);
        this.lpr.setFromFrs();
        this.lpr.bvn();
        this.lps = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.iVm = l.getDimens(getContext(), R.dimen.tbds600);
        this.iVn = this.iVm;
        this.lpw = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.lpw.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.czk);
            }
        });
        this.lpt = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.lpx = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.lpy = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.lpy.x(this.mPageContext);
        this.lpu = findViewById(R.id.contentContainer);
        this.lpv = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.lpv.addOnOffsetChangedListener(this.iWn);
        this.lpz = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.lpA = new HotTopicDetailPagerAdapter(getContext());
        this.lpA.setScrollListener(this.lpC);
        this.lpz.setAdapter(this.lpA);
        this.fXD = (TbTabLayout) findViewById(R.id.tabLayout);
        this.fXD.setSelectedTabTextBlod(true);
        this.fXD.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.fXD.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
        this.fXD.setupWithViewPager(this.lpz);
        this.lpB = findViewById(R.id.dividerShadow);
        this.kgr = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void C(double d) {
        if (this.lps != null) {
            int i = (int) (this.iVm + (PullRefreshFrameLayout.fbv * d));
            ViewGroup.LayoutParams layoutParams = this.lps.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iVn = layoutParams.height;
                this.lps.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.lps != null && (layoutParams = this.lps.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iVn = i;
            this.lps.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gw(int i) {
        int i2 = lpm + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / lpm);
        this.lpo.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        dkg();
        if (f > 0.1d) {
            as.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            as.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.lpD == null) {
            SvgManager.btW().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.jYo, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.btW().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.btW().a(this.jYo, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkg() {
        if (this.czk + this.mNavigationBar.getHeight() >= this.lpu.getY()) {
            ap.setBackgroundColor(this.fXD, R.color.CAM_X0207);
            if (this.mSkinType == 0) {
                this.lpB.setVisibility(0);
                return;
            }
            return;
        }
        ap.setBackgroundColor(this.fXD, R.color.transparent);
        this.lpB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLd() {
        this.jxG = false;
        if (this.lpr != null) {
            this.lpr.bvm();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void djZ() {
        if (this.gAg == null) {
            this.gAg = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            this.gAg.setBackground(ap.getColor(R.color.CAM_X0201));
        }
        this.gAg.attachView(this.lpq, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dka() {
        if (this.gAg != null) {
            this.gAg.dettachView(this.lpq);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bSm() {
        if (this.jxG) {
            cLd();
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxQ);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void ue(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.lpn != null) {
                            HotTopicDetailView.this.lpn.Gn(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lpq, false);
            this.mRefreshView.setBackGroundColor(R.color.CAM_X0201);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dkb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lpq);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Gq(int i) {
        this.lpA.Gq(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Gr(int i) {
        this.lpA.Gr(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void F(boolean z, int i) {
        this.lpA.F(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Gs(int i) {
        this.lpA.Gs(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(@NonNull e eVar) {
        this.lpD = eVar;
        if (this.lpD.cRT() != null) {
            this.kgr.setTopicId(this.lpD.cRT().eXq);
            this.kgr.DW(this.lpD.cRT().eIa);
        }
        h(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.lpD != null) {
            this.lpA.c(this.lpD.cRZ());
        }
        this.lpA.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e dkc() {
        return this.lpD;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d Gt(int i) {
        return this.lpA.Gt(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int dkd() {
        return this.lpA.dkd();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dke() {
        this.lpA.dke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLc() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jxQ, 5000L);
        this.jxG = true;
        this.lpn.Gn(dkd());
    }

    private void bFP() {
        if (!this.lpp) {
            this.lpp = true;
            this.jYo.setVisibility(0);
            SvgManager.btW().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.jYo, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.lpn instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lpn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSm() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OW);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.lpt.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.kge, length - 1, spannableString.length(), 33);
        this.lpt.setText(spannableString);
        this.lpt.setHeight(this.lpt.getLineHeight() * 2);
        this.lpt.scrollTo(0, 0);
        this.lpt.requestLayout();
    }

    private void h(@NonNull e eVar) {
        bFP();
        this.lps.setTopicInfo(eVar.cRT());
        a(eVar.cRT());
        g(eVar);
        List<q> cSb = eVar.cSb();
        if (y.isEmpty(cSb)) {
            this.lpy.setVisibility(8);
        } else {
            this.lpy.setData(cSb);
            this.lpy.setVisibility(0);
        }
        if (eVar.cRT() != null) {
            String str = eVar.cRT().eIa;
            if (ae.getTextLengthWithEmoji(str) > 15) {
                str = ae.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.kdI)) {
            this.lpt.setVisibility(8);
        } else {
            this.lpt.setText(fVar.kdI);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.lps.onChangeSkinType(skinType);
            ap.setViewTextColor(this.lpt, R.color.CAM_X0105, 1);
            ap.setBackgroundColor(this.lpw, R.color.CAM_X0201);
            ap.setBackgroundColor(this.lpo, R.color.CAM_X0207);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.gAg != null) {
                this.gAg.setBackground(ap.getColor(R.color.CAM_X0201));
            }
            this.lpx.onChangeSkinType(skinType);
            this.fXD.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
            this.lpy.onChangeSkinType(skinType);
            this.lpA.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(long j, long j2, int i) {
        this.lpx.e(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void D(long j, long j2) {
        this.lps.E(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.lpA != null) {
            this.lpA.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.lpA != null) {
            this.lpA.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        dka();
        dkb();
        if (this.lpA != null) {
            this.lpA.destroy();
        }
        if (this.jxG) {
            cLd();
        }
        if (this.fbQ != null) {
            this.fbQ.cancel();
            this.fbQ.removeAllListeners();
            this.fbQ.removeAllUpdateListeners();
            this.fbQ = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxQ);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void g(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cRV() != null) {
            aVar = eVar.cRV();
            aVar.kdj = 3;
        } else if (eVar.cRW() != null) {
            aVar = eVar.cRW();
            aVar.kdj = 2;
        } else if (eVar.cRX() != null) {
            aVar = eVar.cRX();
            aVar.kdj = 1;
        }
        this.lps.setBlessInfo(aVar);
        if (eVar.cRU() == null) {
            this.lpx.setVisibility(8);
            return;
        }
        this.lpx.setVisibility(0);
        this.lpx.a(eVar.cRU());
    }
}
