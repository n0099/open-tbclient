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
    private static int kln = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String Np;
    private int bRp;
    private ValueAnimator esJ;
    private g fMR;
    private int hVk;
    private int hVl;
    private AppBarLayout.OnOffsetChangedListener hWl;
    private TbTabLayout hwX;
    private ImageView iTV;
    private boolean iuK;
    private PullRefreshFrameLayout.d iuS;
    private PullRefreshFrameLayout.c iuT;
    private Runnable iuU;
    private int jbJ;
    private ClickableSpan jbO;
    private ClickableSpan jbP;
    private c jcb;
    private CustomViewPager klA;
    private HotTopicDetailPagerAdapter klB;
    private View klC;
    private RecyclerView.OnScrollListener klD;
    private e klE;
    private a.InterfaceC0751a klo;
    private View klp;
    private boolean klq;
    private ViewGroup klr;
    private PullRefreshFrameLayout kls;
    private HotTopicDetailHeadView klt;
    private TextView klu;
    private View klv;
    private AppBarLayout klw;
    private View klx;
    private HotTopicDetailPkLayout kly;
    private HotTopicDetailSpecialLayout klz;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0751a interfaceC0751a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.bRp = UtilHelper.getStatusBarHeight();
        this.klq = false;
        this.Np = "";
        this.klD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.cSy();
            }
        };
        this.iuK = false;
        this.hWl = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.kls != null) {
                    HotTopicDetailView.this.kls.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.Dw(i);
            }
        };
        this.iuS = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void t(double d) {
                HotTopicDetailView.this.x(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicDetailView.this.esJ = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.esJ.setDuration(150L);
                final int height = HotTopicDetailView.this.klt.getHeight();
                HotTopicDetailView.this.esJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.esJ.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bkE() {
                final int i = HotTopicDetailView.this.hVl - HotTopicDetailView.this.hVk;
                if (i > 0) {
                    HotTopicDetailView.this.esJ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.esJ.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.hVl;
                    HotTopicDetailView.this.esJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.klt != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.esJ.start();
                }
            }
        };
        this.iuU = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.iuK) {
                    HotTopicDetailView.this.ctK();
                }
            }
        };
        this.iuT = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bkD() {
                HotTopicDetailView.this.ctJ();
            }
        };
        this.jbO = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
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
                spannableString.setSpan(HotTopicDetailView.this.jbP, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.klu.setText(spannableString);
                HotTopicDetailView.this.klu.setHeight(HotTopicDetailView.this.jbJ * HotTopicDetailView.this.klu.getLineHeight());
                int lineCount = HotTopicDetailView.this.klu.getLineCount() * HotTopicDetailView.this.klu.getLineHeight();
                if (lineCount > HotTopicDetailView.this.jbJ * HotTopicDetailView.this.klu.getLineHeight()) {
                    HotTopicDetailView.this.klu.scrollTo(0, lineCount - (HotTopicDetailView.this.jbJ * HotTopicDetailView.this.klu.getLineHeight()));
                }
                HotTopicDetailView.this.klu.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jbP = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.klu.setText(HotTopicDetailView.this.Np);
                HotTopicDetailView.this.cAt();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.mPageContext = tbPageContext;
        this.klo = interfaceC0751a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.klp = findViewById(R.id.topBgView);
        this.klp.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.iTV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bg.checkUpIsLogin(HotTopicDetailView.this.iTV.getContext())) {
                    HotTopicDetailView.this.klo.e(HotTopicDetailView.this.klE);
                }
            }
        });
        this.iTV.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.bRp;
        findViewById.setLayoutParams(layoutParams);
        this.klr = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.kls = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.kls.setOnTouchCallback(this.iuS);
        this.kls.setOnPullRefreshListener(this.iuT);
        this.kls.setFromFrs();
        this.kls.bkB();
        this.klt = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.hVk = l.getDimens(getContext(), R.dimen.tbds600);
        this.hVl = this.hVk;
        this.klx = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.klx.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.bRp);
            }
        });
        this.klu = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.kly = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.klz = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.klz.x(this.mPageContext);
        this.klv = findViewById(R.id.contentContainer);
        this.klw = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.klw.addOnOffsetChangedListener(this.hWl);
        this.klA = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.klB = new HotTopicDetailPagerAdapter(getContext());
        this.klB.setScrollListener(this.klD);
        this.klA.setAdapter(this.klB);
        this.hwX = (TbTabLayout) findViewById(R.id.tabLayout);
        this.hwX.setSelectedTabTextBlod(true);
        this.hwX.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.hwX.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_link_tip_a));
        this.hwX.setupWithViewPager(this.klA);
        this.klC = findViewById(R.id.dividerShadow);
        this.jcb = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void x(double d) {
        if (this.klt != null) {
            int i = (int) (this.hVk + (PullRefreshFrameLayout.esq * d));
            ViewGroup.LayoutParams layoutParams = this.klt.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hVl = layoutParams.height;
                this.klt.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.klt != null && (layoutParams = this.klt.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hVl = i;
            this.klt.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dw(int i) {
        int i2 = kln + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / kln);
        this.klp.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        cSy();
        if (f > 0.1d) {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.klE == null) {
            SvgManager.bjq().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.iTV, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.bjq().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bjq().a(this.iTV, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSy() {
        if (this.bRp + this.mNavigationBar.getHeight() >= this.klv.getY()) {
            ap.setBackgroundColor(this.hwX, R.color.cp_bg_line_h);
            if (this.mSkinType == 0) {
                this.klC.setVisibility(0);
                return;
            }
            return;
        }
        ap.setBackgroundColor(this.hwX, R.color.transparent);
        this.klC.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctK() {
        this.iuK = false;
        if (this.kls != null) {
            this.kls.bkA();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cSr() {
        if (this.fMR == null) {
            this.fMR = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fMR.attachView(this.klr, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cSs() {
        if (this.fMR != null) {
            this.fMR.dettachView(this.klr);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bGe() {
        if (this.iuK) {
            ctK();
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iuU);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void sk(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.klo != null) {
                            HotTopicDetailView.this.klo.Dn(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.klr, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cSt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.klr);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Dq(int i) {
        this.klB.Dq(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Dr(int i) {
        this.klB.Dr(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void C(boolean z, int i) {
        this.klB.C(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Ds(int i) {
        this.klB.Ds(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(@NonNull e eVar) {
        this.klE = eVar;
        if (this.klE.czZ() != null) {
            this.jcb.setTopicId(this.klE.czZ().eon);
            this.jcb.Ca(this.klE.czZ().eaf);
        }
        h(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.klE != null) {
            this.klB.c(this.klE.cAf());
        }
        this.klB.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e cSu() {
        return this.klE;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d Dt(int i) {
        return this.klB.Dt(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int cSv() {
        return this.klB.cSv();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cSw() {
        this.klB.cSw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctJ() {
        com.baidu.adp.lib.f.e.mS().postDelayed(this.iuU, 5000L);
        this.iuK = true;
        this.klo.Dn(cSv());
    }

    private void buP() {
        if (!this.klq) {
            this.klq = true;
            this.iTV.setVisibility(0);
            SvgManager.bjq().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.iTV, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            if (this.klo instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.klo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAt() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Np);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.klu.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jbO, length - 1, spannableString.length(), 33);
        this.klu.setText(spannableString);
        this.klu.setHeight(this.klu.getLineHeight() * 2);
        this.klu.scrollTo(0, 0);
        this.klu.requestLayout();
    }

    private void h(@NonNull e eVar) {
        buP();
        this.klt.setTopicInfo(eVar.czZ());
        a(eVar.czZ());
        g(eVar);
        List<q> cAh = eVar.cAh();
        if (y.isEmpty(cAh)) {
            this.klz.setVisibility(8);
        } else {
            this.klz.setData(cAh);
            this.klz.setVisibility(0);
        }
        if (eVar.czZ() != null) {
            String str = eVar.czZ().eaf;
            if (ae.getTextLengthWithEmoji(str) > 15) {
                str = ae.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.iZs)) {
            this.klu.setVisibility(8);
        } else {
            this.klu.setText(fVar.iZs);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.klt.onChangeSkinType(skinType);
            ap.setViewTextColor(this.klu, R.color.cp_cont_b, 1);
            ap.setBackgroundColor(this.klx, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.klp, R.color.cp_bg_line_h);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.kly.onChangeSkinType(skinType);
            this.hwX.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
            this.klz.onChangeSkinType(skinType);
            this.klB.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void d(long j, long j2, int i) {
        this.kly.d(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void F(long j, long j2) {
        this.klt.G(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.klB != null) {
            this.klB.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.klB != null) {
            this.klB.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        cSs();
        cSt();
        if (this.klB != null) {
            this.klB.destroy();
        }
        if (this.iuK) {
            ctK();
        }
        if (this.esJ != null) {
            this.esJ.cancel();
            this.esJ.removeAllListeners();
            this.esJ.removeAllUpdateListeners();
            this.esJ = null;
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iuU);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void g(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cAb() != null) {
            aVar = eVar.cAb();
            aVar.iYT = 3;
        } else if (eVar.cAc() != null) {
            aVar = eVar.cAc();
            aVar.iYT = 2;
        } else if (eVar.cAd() != null) {
            aVar = eVar.cAd();
            aVar.iYT = 1;
        }
        this.klt.setBlessInfo(aVar);
        if (eVar.cAa() == null) {
            this.kly.setVisibility(8);
            return;
        }
        this.kly.setVisibility(0);
        this.kly.a(eVar.cAa());
    }
}
