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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ad;
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
import com.google.android.material.appbar.AppBarLayout;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class HotTopicDetailView extends RelativeLayout implements a.b {
    private static int luu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String OZ;
    private int cEd;
    private ValueAnimator flz;
    private g gLj;
    private TbTabLayout ghk;
    private boolean jKd;
    private PullRefreshFrameLayout.d jKl;
    private PullRefreshFrameLayout.c jKm;
    private Runnable jKn;
    private ImageView jQR;
    private int jhy;
    private int jhz;
    private AppBarLayout.OnOffsetChangedListener jiA;
    private c ktD;
    private int ktl;
    private ClickableSpan ktq;
    private ClickableSpan ktr;
    private HotTopicDetailHeadView luA;
    private TextView luB;
    private View luC;
    private AppBarLayout luD;
    private View luE;
    private HotTopicDetailPkLayout luF;
    private HotTopicDetailSpecialLayout luG;
    private CustomViewPager luH;
    private HotTopicDetailPagerAdapter luI;
    private View luJ;
    private RecyclerView.OnScrollListener luK;
    private e luL;
    private a.InterfaceC0798a luv;
    private View luw;
    private boolean lux;
    private ViewGroup luy;
    private PullRefreshFrameLayout luz;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0798a interfaceC0798a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cEd = UtilHelper.getStatusBarHeight();
        this.lux = false;
        this.OZ = "";
        this.luK = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.djQ();
            }
        };
        this.jKd = false;
        this.jiA = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.luz != null) {
                    HotTopicDetailView.this.luz.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.Go(i);
            }
        };
        this.jKl = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                HotTopicDetailView.this.B(d);
                HotTopicDetailView.this.luz.bxJ();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                HotTopicDetailView.this.flz = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.flz.setDuration(150L);
                final int height = HotTopicDetailView.this.luA.getHeight();
                HotTopicDetailView.this.flz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.flz.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bxM() {
                final int i = HotTopicDetailView.this.jhz - HotTopicDetailView.this.jhy;
                if (i > 0) {
                    HotTopicDetailView.this.flz = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.flz.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.jhz;
                    HotTopicDetailView.this.flz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.luA != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.flz.start();
                }
            }
        };
        this.jKn = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.jKd) {
                    HotTopicDetailView.this.cOe();
                }
            }
        };
        this.jKm = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bxL() {
                HotTopicDetailView.this.cOd();
            }
        };
        this.ktq = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.OZ);
                if (HotTopicDetailView.this.OZ.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicDetailView.this.ktr, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.luB.setText(spannableString);
                HotTopicDetailView.this.luB.setHeight(HotTopicDetailView.this.ktl * HotTopicDetailView.this.luB.getLineHeight());
                int lineCount = HotTopicDetailView.this.luB.getLineCount() * HotTopicDetailView.this.luB.getLineHeight();
                if (lineCount > HotTopicDetailView.this.ktl * HotTopicDetailView.this.luB.getLineHeight()) {
                    HotTopicDetailView.this.luB.scrollTo(0, lineCount - (HotTopicDetailView.this.ktl * HotTopicDetailView.this.luB.getLineHeight()));
                }
                HotTopicDetailView.this.luB.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.ktr = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.luB.setText(HotTopicDetailView.this.OZ);
                HotTopicDetailView.this.cVs();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.mPageContext = tbPageContext;
        this.luv = interfaceC0798a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.luw = findViewById(R.id.topBgView);
        this.luw.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.jQR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bg.checkUpIsLogin(HotTopicDetailView.this.jQR.getContext())) {
                    HotTopicDetailView.this.luv.d(HotTopicDetailView.this.luL);
                }
            }
        });
        this.jQR.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.cEd;
        findViewById.setLayoutParams(layoutParams);
        this.luy = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.luz = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.luz.setOnTouchCallback(this.jKl);
        this.luz.setOnPullRefreshListener(this.jKm);
        this.luz.setFromFrs();
        this.luz.bxI();
        this.luA = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.jhy = l.getDimens(getContext(), R.dimen.tbds600);
        this.jhz = this.jhy;
        this.luE = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.luE.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.cEd);
            }
        });
        this.luB = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.luF = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.luG = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.luG.w(this.mPageContext);
        this.luC = findViewById(R.id.contentContainer);
        this.luD = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.luD.addOnOffsetChangedListener(this.jiA);
        this.luH = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.luI = new HotTopicDetailPagerAdapter(getContext());
        this.luI.setScrollListener(this.luK);
        this.luH.setAdapter(this.luI);
        this.ghk = (TbTabLayout) findViewById(R.id.tabLayout);
        this.ghk.setSelectedTabTextBlod(true);
        this.ghk.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.ghk.setSelectedTabIndicatorColor(ao.getColor(R.color.CAM_X0302));
        this.ghk.setupWithViewPager(this.luH);
        this.luJ = findViewById(R.id.dividerShadow);
        this.ktD = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void B(double d) {
        if (this.luA != null) {
            int i = (int) (this.jhy + (PullRefreshFrameLayout.fle * d));
            ViewGroup.LayoutParams layoutParams = this.luA.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jhz = layoutParams.height;
                this.luA.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.luA != null && (layoutParams = this.luA.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jhz = i;
            this.luA.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Go(int i) {
        int i2 = luu + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / luu);
        this.luw.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        djQ();
        if (f > 0.1d) {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.luL == null) {
            SvgManager.bwq().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bwq().a(this.jQR, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.bwq().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bwq().a(this.jQR, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djQ() {
        if (this.cEd + this.mNavigationBar.getHeight() >= this.luC.getY()) {
            ao.setBackgroundColor(this.ghk, R.color.CAM_X0207);
            if (this.mSkinType == 0) {
                this.luJ.setVisibility(0);
                return;
            }
            return;
        }
        ao.setBackgroundColor(this.ghk, R.color.transparent);
        this.luJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOe() {
        this.jKd = false;
        if (this.luz != null) {
            this.luz.bxH();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void djJ() {
        if (this.gLj == null) {
            this.gLj = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            this.gLj.setBackground(ao.getColor(R.color.CAM_X0201));
        }
        this.gLj.attachView(this.luy, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void djK() {
        if (this.gLj != null) {
            this.gLj.dettachView(this.luy);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bUO() {
        if (this.jKd) {
            cOe();
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jKn);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void uf(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.luv != null) {
                            HotTopicDetailView.this.luv.Gf(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.luy, false);
            this.mRefreshView.setBackGroundColor(R.color.CAM_X0201);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void djL() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.luy);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Gi(int i) {
        this.luI.Gi(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Gj(int i) {
        this.luI.Gj(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void E(boolean z, int i) {
        this.luI.E(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Gk(int i) {
        this.luI.Gk(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(@NonNull e eVar) {
        this.luL = eVar;
        if (this.luL.cUZ() != null) {
            this.ktD.setTopicId(this.luL.cUZ().fgR);
            this.ktD.DT(this.luL.cUZ().eRS);
        }
        g(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.luL != null) {
            this.luI.c(this.luL.cVf());
        }
        this.luI.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e djM() {
        return this.luL;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d Gl(int i) {
        return this.luI.Gl(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int djN() {
        return this.luI.djN();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void djO() {
        this.luI.djO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOd() {
        com.baidu.adp.lib.f.e.mB().postDelayed(this.jKn, 5000L);
        this.jKd = true;
        this.luv.Gf(djN());
    }

    private void bIk() {
        if (!this.lux) {
            this.lux = true;
            this.jQR.setVisibility(0);
            SvgManager.bwq().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bwq().a(this.jQR, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ao.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.luv instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.luv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVs() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OZ);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.luB.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.ktq, length - 1, spannableString.length(), 33);
        this.luB.setText(spannableString);
        this.luB.setHeight(this.luB.getLineHeight() * 2);
        this.luB.scrollTo(0, 0);
        this.luB.requestLayout();
    }

    private void g(@NonNull e eVar) {
        bIk();
        this.luA.setTopicInfo(eVar.cUZ());
        a(eVar.cUZ());
        f(eVar);
        List<n> cVh = eVar.cVh();
        if (x.isEmpty(cVh)) {
            this.luG.setVisibility(8);
        } else {
            this.luG.setData(cVh);
            this.luG.setVisibility(0);
        }
        if (eVar.cUZ() != null) {
            String str = eVar.cUZ().eRS;
            if (ad.getTextLengthWithEmoji(str) > 15) {
                str = ad.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.kqU)) {
            this.luB.setVisibility(8);
        } else {
            this.luB.setText(fVar.kqU);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.luA.onChangeSkinType(skinType);
            ao.setViewTextColor(this.luB, R.color.CAM_X0105, 1);
            ao.setBackgroundColor(this.luE, R.color.CAM_X0201);
            ao.setBackgroundColor(this.luw, R.color.CAM_X0207);
            ao.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.gLj != null) {
                this.gLj.setBackground(ao.getColor(R.color.CAM_X0201));
            }
            this.luF.onChangeSkinType(skinType);
            this.ghk.setTabTextColors(ao.getColor(R.color.CAM_X0107), ao.getColor(R.color.CAM_X0105));
            this.luG.onChangeSkinType(skinType);
            this.luI.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(long j, long j2, int i) {
        this.luF.f(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void G(long j, long j2) {
        this.luA.H(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.luI != null) {
            this.luI.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.luI != null) {
            this.luI.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        djK();
        djL();
        if (this.luI != null) {
            this.luI.destroy();
        }
        if (this.jKd) {
            cOe();
        }
        if (this.flz != null) {
            this.flz.cancel();
            this.flz.removeAllListeners();
            this.flz.removeAllUpdateListeners();
            this.flz = null;
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jKn);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cVb() != null) {
            aVar = eVar.cVb();
            aVar.kqv = 3;
        } else if (eVar.cVc() != null) {
            aVar = eVar.cVc();
            aVar.kqv = 2;
        } else if (eVar.cVd() != null) {
            aVar = eVar.cVd();
            aVar.kqv = 1;
        }
        this.luA.setBlessInfo(aVar);
        if (eVar.cVa() == null) {
            this.luF.setVisibility(8);
            return;
        }
        this.luF.setVisibility(0);
        this.luF.a(eVar.cVa());
    }
}
