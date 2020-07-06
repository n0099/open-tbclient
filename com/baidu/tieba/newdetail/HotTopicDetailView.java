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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
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
/* loaded from: classes8.dex */
public class HotTopicDetailView extends RelativeLayout implements a.b {
    private static int jNk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String MN;
    private int bLt;
    private ValueAnimator ecC;
    private g fwo;
    private int hBQ;
    private int hBR;
    private AppBarLayout.OnOffsetChangedListener hCR;
    private TbTabLayout heq;
    private ClickableSpan iGD;
    private ClickableSpan iGE;
    private c iGQ;
    private int iGy;
    private PullRefreshFrameLayout.b iaE;
    private PullRefreshFrameLayout.a iaF;
    private Runnable iaG;
    private boolean iaw;
    private ImageView iyL;
    private RecyclerView.OnScrollListener jNA;
    private e jNB;
    private a.InterfaceC0688a jNl;
    private View jNm;
    private boolean jNn;
    private ViewGroup jNo;
    private PullRefreshFrameLayout jNp;
    private HotTopicDetailHeadView jNq;
    private TextView jNr;
    private View jNs;
    private AppBarLayout jNt;
    private View jNu;
    private HotTopicDetailPkLayout jNv;
    private HotTopicDetailSpecialLayout jNw;
    private CustomViewPager jNx;
    private HotTopicDetailPagerAdapter jNy;
    private View jNz;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0688a interfaceC0688a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.bLt = UtilHelper.getStatusBarHeight();
        this.jNn = false;
        this.MN = "";
        this.jNA = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.cEa();
            }
        };
        this.iaw = false;
        this.hCR = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.jNp != null) {
                    HotTopicDetailView.this.jNp.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.AE(i);
            }
        };
        this.iaE = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void n(double d) {
                HotTopicDetailView.this.r(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                HotTopicDetailView.this.ecC = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.ecC.setDuration(150L);
                final int height = HotTopicDetailView.this.jNq.getHeight();
                HotTopicDetailView.this.ecC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.ecC.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void aYh() {
                final int i = HotTopicDetailView.this.hBR - HotTopicDetailView.this.hBQ;
                if (i > 0) {
                    HotTopicDetailView.this.ecC = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.ecC.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.hBR;
                    HotTopicDetailView.this.ecC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.jNq != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.ecC.start();
                }
            }
        };
        this.iaG = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.iaw) {
                    HotTopicDetailView.this.cfG();
                }
            }
        };
        this.iaF = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void aYg() {
                HotTopicDetailView.this.cfF();
            }
        };
        this.iGD = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.MN);
                if (HotTopicDetailView.this.MN.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicDetailView.this.iGE, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.jNr.setText(spannableString);
                HotTopicDetailView.this.jNr.setHeight(HotTopicDetailView.this.iGy * HotTopicDetailView.this.jNr.getLineHeight());
                int lineCount = HotTopicDetailView.this.jNr.getLineCount() * HotTopicDetailView.this.jNr.getLineHeight();
                if (lineCount > HotTopicDetailView.this.iGy * HotTopicDetailView.this.jNr.getLineHeight()) {
                    HotTopicDetailView.this.jNr.scrollTo(0, lineCount - (HotTopicDetailView.this.iGy * HotTopicDetailView.this.jNr.getLineHeight()));
                }
                HotTopicDetailView.this.jNr.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.iGE = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.jNr.setText(HotTopicDetailView.this.MN);
                HotTopicDetailView.this.cma();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.mPageContext = tbPageContext;
        this.jNl = interfaceC0688a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.jNm = findViewById(R.id.topBgView);
        this.jNm.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.iyL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || be.checkUpIsLogin(HotTopicDetailView.this.iyL.getContext())) {
                    HotTopicDetailView.this.jNl.e(HotTopicDetailView.this.jNB);
                }
            }
        });
        this.iyL.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.bLt;
        findViewById.setLayoutParams(layoutParams);
        this.jNo = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.jNp = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.jNp.setOnTouchCallback(this.iaE);
        this.jNp.setOnPullRefreshListener(this.iaF);
        this.jNp.setFromFrs();
        this.jNp.aYf();
        this.jNq = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.hBQ = l.getDimens(getContext(), R.dimen.tbds600);
        this.hBR = this.hBQ;
        this.jNu = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.jNu.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.bLt);
            }
        });
        this.jNr = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.jNv = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.jNw = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.jNw.y(this.mPageContext);
        this.jNs = findViewById(R.id.contentContainer);
        this.jNt = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.jNt.addOnOffsetChangedListener(this.hCR);
        this.jNx = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.jNy = new HotTopicDetailPagerAdapter(getContext());
        this.jNy.setScrollListener(this.jNA);
        this.jNx.setAdapter(this.jNy);
        this.heq = (TbTabLayout) findViewById(R.id.tabLayout);
        this.heq.setSelectedTabTextBlod(true);
        this.heq.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.heq.setSelectedTabIndicatorColor(an.getColor(R.color.cp_link_tip_a));
        this.heq.setupWithViewPager(this.jNx);
        this.jNz = findViewById(R.id.dividerShadow);
        this.iGQ = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void r(double d) {
        if (this.jNq != null) {
            int i = (int) (this.hBQ + (PullRefreshFrameLayout.ecl * d));
            ViewGroup.LayoutParams layoutParams = this.jNq.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hBR = layoutParams.height;
                this.jNq.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jNq != null && (layoutParams = this.jNq.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hBR = i;
            this.jNq.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AE(int i) {
        int i2 = jNk + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / jNk);
        this.jNm.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        cEa();
        if (f > 0.1d) {
            ap.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            ap.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.jNB == null) {
            SvgManager.aWQ().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aWQ().a(this.iyL, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.aWQ().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aWQ().a(this.iyL, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEa() {
        if (this.bLt + this.mNavigationBar.getHeight() >= this.jNs.getY()) {
            an.setBackgroundColor(this.heq, R.color.cp_bg_line_h);
            if (this.mSkinType == 0) {
                this.jNz.setVisibility(0);
                return;
            }
            return;
        }
        an.setBackgroundColor(this.heq, R.color.transparent);
        this.jNz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfG() {
        this.iaw = false;
        if (this.jNp != null) {
            this.jNp.aYe();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cDT() {
        if (this.fwo == null) {
            this.fwo = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fwo.attachView(this.jNo, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cDU() {
        if (this.fwo != null) {
            this.fwo.dettachView(this.jNo);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void btV() {
        if (this.iaw) {
            cfG();
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iaG);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void qX(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.jNl != null) {
                            HotTopicDetailView.this.jNl.Av(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.jNo, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cDV() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.jNo);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Ay(int i) {
        this.jNy.Ay(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Az(int i) {
        this.jNy.Az(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void C(boolean z, int i) {
        this.jNy.C(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void AA(int i) {
        this.jNy.AA(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(@NonNull e eVar) {
        this.jNB = eVar;
        if (this.jNB.clF() != null) {
            this.iGQ.setTopicId(this.jNB.clF().dYw);
            this.iGQ.yD(this.jNB.clF().dKw);
        }
        h(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.jNB != null) {
            this.jNy.c(this.jNB.clL());
        }
        this.jNy.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e cDW() {
        return this.jNB;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d AB(int i) {
        return this.jNy.AB(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int cDX() {
        return this.jNy.cDX();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cDY() {
        this.jNy.cDY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfF() {
        com.baidu.adp.lib.f.e.lt().postDelayed(this.iaG, 5000L);
        this.iaw = true;
        this.jNl.Av(cDX());
    }

    private void biq() {
        if (!this.jNn) {
            this.jNn = true;
            this.iyL.setVisibility(0);
            SvgManager.aWQ().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aWQ().a(this.iyL, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            an.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            if (this.jNl instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.jNl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cma() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.MN);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.jNr.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.iGD, length - 1, spannableString.length(), 33);
        this.jNr.setText(spannableString);
        this.jNr.setHeight(this.jNr.getLineHeight() * 2);
        this.jNr.scrollTo(0, 0);
        this.jNr.requestLayout();
    }

    private void h(@NonNull e eVar) {
        biq();
        this.jNq.setTopicInfo(eVar.clF());
        a(eVar.clF());
        g(eVar);
        List<q> clN = eVar.clN();
        if (w.isEmpty(clN)) {
            this.jNw.setVisibility(8);
        } else {
            this.jNw.setData(clN);
            this.jNw.setVisibility(0);
        }
        if (eVar.clF() != null) {
            String str = eVar.clF().dKw;
            if (ae.getTextLengthWithEmoji(str) > 15) {
                str = ae.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.iEi)) {
            this.jNr.setVisibility(8);
        } else {
            this.jNr.setText(fVar.iEi);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.jNq.onChangeSkinType(skinType);
            an.setViewTextColor(this.jNr, R.color.cp_cont_b, 1);
            an.setBackgroundColor(this.jNu, R.color.cp_bg_line_d);
            an.setBackgroundColor(this.jNm, R.color.cp_bg_line_h);
            an.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.jNv.onChangeSkinType(skinType);
            this.heq.setTabTextColors(an.getColor(R.color.cp_cont_j), an.getColor(R.color.cp_cont_b));
            this.jNw.onChangeSkinType(skinType);
            this.jNy.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void c(long j, long j2, int i) {
        this.jNv.c(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void E(long j, long j2) {
        this.jNq.F(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.jNy != null) {
            this.jNy.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.jNy != null) {
            this.jNy.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        cDU();
        cDV();
        if (this.jNy != null) {
            this.jNy.destroy();
        }
        if (this.iaw) {
            cfG();
        }
        if (this.ecC != null) {
            this.ecC.cancel();
            this.ecC.removeAllListeners();
            this.ecC.removeAllUpdateListeners();
            this.ecC = null;
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iaG);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void g(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.clH() != null) {
            aVar = eVar.clH();
            aVar.iDJ = 3;
        } else if (eVar.clI() != null) {
            aVar = eVar.clI();
            aVar.iDJ = 2;
        } else if (eVar.clJ() != null) {
            aVar = eVar.clJ();
            aVar.iDJ = 1;
        }
        this.jNq.setBlessInfo(aVar);
        if (eVar.clG() == null) {
            this.jNv.setVisibility(8);
            return;
        }
        this.jNv.setVisibility(0);
        this.jNv.a(eVar.clG());
    }
}
