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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes15.dex */
public class HotTopicDetailView extends RelativeLayout implements a.b {
    private static int klg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String Np;
    private int bRl;
    private ValueAnimator esF;
    private g fMN;
    private int hVe;
    private int hVf;
    private AppBarLayout.OnOffsetChangedListener hWf;
    private TbTabLayout hwR;
    private ImageView iTP;
    private boolean iuE;
    private PullRefreshFrameLayout.d iuM;
    private PullRefreshFrameLayout.c iuN;
    private Runnable iuO;
    private int jbD;
    private ClickableSpan jbI;
    private ClickableSpan jbJ;
    private c jbV;
    private a.InterfaceC0751a klh;
    private View kli;
    private boolean klj;
    private ViewGroup klk;
    private PullRefreshFrameLayout kll;
    private HotTopicDetailHeadView klm;
    private TextView kln;
    private View klo;
    private AppBarLayout klp;
    private View klq;
    private HotTopicDetailPkLayout klr;
    private HotTopicDetailSpecialLayout kls;
    private CustomViewPager klt;
    private HotTopicDetailPagerAdapter klu;
    private View klv;
    private RecyclerView.OnScrollListener klw;
    private e klx;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0751a interfaceC0751a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.bRl = UtilHelper.getStatusBarHeight();
        this.klj = false;
        this.Np = "";
        this.klw = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.cSx();
            }
        };
        this.iuE = false;
        this.hWf = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.kll != null) {
                    HotTopicDetailView.this.kll.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.Dw(i);
            }
        };
        this.iuM = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void t(double d) {
                HotTopicDetailView.this.x(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicDetailView.this.esF = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.esF.setDuration(150L);
                final int height = HotTopicDetailView.this.klm.getHeight();
                HotTopicDetailView.this.esF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.esF.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bkE() {
                final int i = HotTopicDetailView.this.hVf - HotTopicDetailView.this.hVe;
                if (i > 0) {
                    HotTopicDetailView.this.esF = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.esF.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.hVf;
                    HotTopicDetailView.this.esF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.klm != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.esF.start();
                }
            }
        };
        this.iuO = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.iuE) {
                    HotTopicDetailView.this.ctJ();
                }
            }
        };
        this.iuN = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bkD() {
                HotTopicDetailView.this.ctI();
            }
        };
        this.jbI = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.Np);
                if (HotTopicDetailView.this.Np.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicDetailView.this.jbJ, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.kln.setText(spannableString);
                HotTopicDetailView.this.kln.setHeight(HotTopicDetailView.this.jbD * HotTopicDetailView.this.kln.getLineHeight());
                int lineCount = HotTopicDetailView.this.kln.getLineCount() * HotTopicDetailView.this.kln.getLineHeight();
                if (lineCount > HotTopicDetailView.this.jbD * HotTopicDetailView.this.kln.getLineHeight()) {
                    HotTopicDetailView.this.kln.scrollTo(0, lineCount - (HotTopicDetailView.this.jbD * HotTopicDetailView.this.kln.getLineHeight()));
                }
                HotTopicDetailView.this.kln.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jbJ = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.kln.setText(HotTopicDetailView.this.Np);
                HotTopicDetailView.this.cAs();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.mPageContext = tbPageContext;
        this.klh = interfaceC0751a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.kli = findViewById(R.id.topBgView);
        this.kli.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.iTP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bg.checkUpIsLogin(HotTopicDetailView.this.iTP.getContext())) {
                    HotTopicDetailView.this.klh.e(HotTopicDetailView.this.klx);
                }
            }
        });
        this.iTP.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.bRl;
        findViewById.setLayoutParams(layoutParams);
        this.klk = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.kll = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.kll.setOnTouchCallback(this.iuM);
        this.kll.setOnPullRefreshListener(this.iuN);
        this.kll.setFromFrs();
        this.kll.bkB();
        this.klm = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.hVe = l.getDimens(getContext(), R.dimen.tbds600);
        this.hVf = this.hVe;
        this.klq = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.klq.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.bRl);
            }
        });
        this.kln = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.klr = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.kls = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.kls.x(this.mPageContext);
        this.klo = findViewById(R.id.contentContainer);
        this.klp = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.klp.addOnOffsetChangedListener(this.hWf);
        this.klt = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.klu = new HotTopicDetailPagerAdapter(getContext());
        this.klu.setScrollListener(this.klw);
        this.klt.setAdapter(this.klu);
        this.hwR = (TbTabLayout) findViewById(R.id.tabLayout);
        this.hwR.setSelectedTabTextBlod(true);
        this.hwR.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.hwR.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_link_tip_a));
        this.hwR.setupWithViewPager(this.klt);
        this.klv = findViewById(R.id.dividerShadow);
        this.jbV = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void x(double d) {
        if (this.klm != null) {
            int i = (int) (this.hVe + (PullRefreshFrameLayout.esm * d));
            ViewGroup.LayoutParams layoutParams = this.klm.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hVf = layoutParams.height;
                this.klm.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.klm != null && (layoutParams = this.klm.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hVf = i;
            this.klm.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dw(int i) {
        int i2 = klg + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / klg);
        this.kli.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        cSx();
        if (f > 0.1d) {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.klx == null) {
            SvgManager.bjq().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.iTP, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.bjq().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bjq().a(this.iTP, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSx() {
        if (this.bRl + this.mNavigationBar.getHeight() >= this.klo.getY()) {
            ap.setBackgroundColor(this.hwR, R.color.cp_bg_line_h);
            if (this.mSkinType == 0) {
                this.klv.setVisibility(0);
                return;
            }
            return;
        }
        ap.setBackgroundColor(this.hwR, R.color.transparent);
        this.klv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctJ() {
        this.iuE = false;
        if (this.kll != null) {
            this.kll.bkA();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cSq() {
        if (this.fMN == null) {
            this.fMN = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fMN.attachView(this.klk, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cSr() {
        if (this.fMN != null) {
            this.fMN.dettachView(this.klk);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bGd() {
        if (this.iuE) {
            ctJ();
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iuO);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void si(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.klh != null) {
                            HotTopicDetailView.this.klh.Dn(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.klk, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cSs() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.klk);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Dq(int i) {
        this.klu.Dq(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Dr(int i) {
        this.klu.Dr(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void C(boolean z, int i) {
        this.klu.C(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Ds(int i) {
        this.klu.Ds(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(@NonNull e eVar) {
        this.klx = eVar;
        if (this.klx.czY() != null) {
            this.jbV.setTopicId(this.klx.czY().eoj);
            this.jbV.BZ(this.klx.czY().eab);
        }
        h(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.klx != null) {
            this.klu.c(this.klx.cAe());
        }
        this.klu.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e cSt() {
        return this.klx;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d Dt(int i) {
        return this.klu.Dt(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int cSu() {
        return this.klu.cSu();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cSv() {
        this.klu.cSv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctI() {
        com.baidu.adp.lib.f.e.mS().postDelayed(this.iuO, 5000L);
        this.iuE = true;
        this.klh.Dn(cSu());
    }

    private void buO() {
        if (!this.klj) {
            this.klj = true;
            this.iTP.setVisibility(0);
            SvgManager.bjq().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.iTP, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            if (this.klh instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.klh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAs() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Np);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.kln.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jbI, length - 1, spannableString.length(), 33);
        this.kln.setText(spannableString);
        this.kln.setHeight(this.kln.getLineHeight() * 2);
        this.kln.scrollTo(0, 0);
        this.kln.requestLayout();
    }

    private void h(@NonNull e eVar) {
        buO();
        this.klm.setTopicInfo(eVar.czY());
        a(eVar.czY());
        g(eVar);
        List<q> cAg = eVar.cAg();
        if (y.isEmpty(cAg)) {
            this.kls.setVisibility(8);
        } else {
            this.kls.setData(cAg);
            this.kls.setVisibility(0);
        }
        if (eVar.czY() != null) {
            String str = eVar.czY().eab;
            if (ae.getTextLengthWithEmoji(str) > 15) {
                str = ae.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.iZm)) {
            this.kln.setVisibility(8);
        } else {
            this.kln.setText(fVar.iZm);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.klm.onChangeSkinType(skinType);
            ap.setViewTextColor(this.kln, R.color.cp_cont_b, 1);
            ap.setBackgroundColor(this.klq, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.kli, R.color.cp_bg_line_h);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.klr.onChangeSkinType(skinType);
            this.hwR.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
            this.kls.onChangeSkinType(skinType);
            this.klu.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void d(long j, long j2, int i) {
        this.klr.d(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void F(long j, long j2) {
        this.klm.G(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.klu != null) {
            this.klu.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.klu != null) {
            this.klu.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        cSr();
        cSs();
        if (this.klu != null) {
            this.klu.destroy();
        }
        if (this.iuE) {
            ctJ();
        }
        if (this.esF != null) {
            this.esF.cancel();
            this.esF.removeAllListeners();
            this.esF.removeAllUpdateListeners();
            this.esF = null;
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iuO);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void g(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cAa() != null) {
            aVar = eVar.cAa();
            aVar.iYN = 3;
        } else if (eVar.cAb() != null) {
            aVar = eVar.cAb();
            aVar.iYN = 2;
        } else if (eVar.cAc() != null) {
            aVar = eVar.cAc();
            aVar.iYN = 1;
        }
        this.klm.setBlessInfo(aVar);
        if (eVar.czZ() == null) {
            this.klr.setVisibility(8);
            return;
        }
        this.klr.setVisibility(0);
        this.klr.a(eVar.czZ());
    }
}
