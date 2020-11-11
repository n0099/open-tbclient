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
import com.baidu.tbadk.util.af;
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
    private static int lbs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String Ob;
    private int cua;
    private ValueAnimator eVj;
    private TbTabLayout fPJ;
    private g gso;
    private int iJE;
    private int iJF;
    private AppBarLayout.OnOffsetChangedListener iKF;
    private ImageView jJY;
    private int jRJ;
    private ClickableSpan jRO;
    private ClickableSpan jRP;
    private c jSb;
    private Runnable jjA;
    private boolean jjq;
    private PullRefreshFrameLayout.d jjy;
    private PullRefreshFrameLayout.c jjz;
    private View lbA;
    private AppBarLayout lbB;
    private View lbC;
    private HotTopicDetailPkLayout lbD;
    private HotTopicDetailSpecialLayout lbE;
    private CustomViewPager lbF;
    private HotTopicDetailPagerAdapter lbG;
    private View lbH;
    private RecyclerView.OnScrollListener lbI;
    private e lbJ;
    private a.InterfaceC0796a lbt;
    private View lbu;
    private boolean lbv;
    private ViewGroup lbw;
    private PullRefreshFrameLayout lbx;
    private HotTopicDetailHeadView lby;
    private TextView lbz;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0796a interfaceC0796a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cua = UtilHelper.getStatusBarHeight();
        this.lbv = false;
        this.Ob = "";
        this.lbI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.dfw();
            }
        };
        this.jjq = false;
        this.iKF = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.lbx != null) {
                    HotTopicDetailView.this.lbx.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.Fj(i);
            }
        };
        this.jjy = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void x(double d) {
                HotTopicDetailView.this.B(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicDetailView.this.eVj = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.eVj.setDuration(150L);
                final int height = HotTopicDetailView.this.lby.getHeight();
                HotTopicDetailView.this.eVj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.eVj.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bsC() {
                final int i = HotTopicDetailView.this.iJF - HotTopicDetailView.this.iJE;
                if (i > 0) {
                    HotTopicDetailView.this.eVj = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.eVj.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.iJF;
                    HotTopicDetailView.this.eVj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.lby != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.eVj.start();
                }
            }
        };
        this.jjA = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.jjq) {
                    HotTopicDetailView.this.cGh();
                }
            }
        };
        this.jjz = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bsB() {
                HotTopicDetailView.this.cGg();
            }
        };
        this.jRO = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.Ob);
                if (HotTopicDetailView.this.Ob.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicDetailView.this.jRP, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.lbz.setText(spannableString);
                HotTopicDetailView.this.lbz.setHeight(HotTopicDetailView.this.jRJ * HotTopicDetailView.this.lbz.getLineHeight());
                int lineCount = HotTopicDetailView.this.lbz.getLineCount() * HotTopicDetailView.this.lbz.getLineHeight();
                if (lineCount > HotTopicDetailView.this.jRJ * HotTopicDetailView.this.lbz.getLineHeight()) {
                    HotTopicDetailView.this.lbz.scrollTo(0, lineCount - (HotTopicDetailView.this.jRJ * HotTopicDetailView.this.lbz.getLineHeight()));
                }
                HotTopicDetailView.this.lbz.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jRP = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.lbz.setText(HotTopicDetailView.this.Ob);
                HotTopicDetailView.this.cNr();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.mPageContext = tbPageContext;
        this.lbt = interfaceC0796a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.lbu = findViewById(R.id.topBgView);
        this.lbu.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.jJY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bg.checkUpIsLogin(HotTopicDetailView.this.jJY.getContext())) {
                    HotTopicDetailView.this.lbt.e(HotTopicDetailView.this.lbJ);
                }
            }
        });
        this.jJY.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.cua;
        findViewById.setLayoutParams(layoutParams);
        this.lbw = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.lbx = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lbx.setOnTouchCallback(this.jjy);
        this.lbx.setOnPullRefreshListener(this.jjz);
        this.lbx.setFromFrs();
        this.lbx.bsz();
        this.lby = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.iJE = l.getDimens(getContext(), R.dimen.tbds600);
        this.iJF = this.iJE;
        this.lbC = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.lbC.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.cua);
            }
        });
        this.lbz = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.lbD = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.lbE = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.lbE.x(this.mPageContext);
        this.lbA = findViewById(R.id.contentContainer);
        this.lbB = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.lbB.addOnOffsetChangedListener(this.iKF);
        this.lbF = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.lbG = new HotTopicDetailPagerAdapter(getContext());
        this.lbG.setScrollListener(this.lbI);
        this.lbF.setAdapter(this.lbG);
        this.fPJ = (TbTabLayout) findViewById(R.id.tabLayout);
        this.fPJ.setSelectedTabTextBlod(true);
        this.fPJ.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.fPJ.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_link_tip_a));
        this.fPJ.setupWithViewPager(this.lbF);
        this.lbH = findViewById(R.id.dividerShadow);
        this.jSb = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void B(double d) {
        if (this.lby != null) {
            int i = (int) (this.iJE + (PullRefreshFrameLayout.eUQ * d));
            ViewGroup.LayoutParams layoutParams = this.lby.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iJF = layoutParams.height;
                this.lby.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.lby != null && (layoutParams = this.lby.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iJF = i;
            this.lby.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj(int i) {
        int i2 = lbs + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / lbs);
        this.lbu.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        dfw();
        if (f > 0.1d) {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.lbJ == null) {
            SvgManager.brn().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.brn().a(this.jJY, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.brn().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.brn().a(this.jJY, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfw() {
        if (this.cua + this.mNavigationBar.getHeight() >= this.lbA.getY()) {
            ap.setBackgroundColor(this.fPJ, R.color.cp_bg_line_h);
            if (this.mSkinType == 0) {
                this.lbH.setVisibility(0);
                return;
            }
            return;
        }
        ap.setBackgroundColor(this.fPJ, R.color.transparent);
        this.lbH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGh() {
        this.jjq = false;
        if (this.lbx != null) {
            this.lbx.bsy();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dfp() {
        if (this.gso == null) {
            this.gso = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gso.attachView(this.lbw, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dfq() {
        if (this.gso != null) {
            this.gso.dettachView(this.lbw);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bPh() {
        if (this.jjq) {
            cGh();
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jjA);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void tz(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.lbt != null) {
                            HotTopicDetailView.this.lbt.Fa(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lbw, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dfr() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lbw);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Fd(int i) {
        this.lbG.Fd(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Fe(int i) {
        this.lbG.Fe(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void F(boolean z, int i) {
        this.lbG.F(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Ff(int i) {
        this.lbG.Ff(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(@NonNull e eVar) {
        this.lbJ = eVar;
        if (this.lbJ.cMX() != null) {
            this.jSb.setTopicId(this.lbJ.cMX().eRa);
            this.jSb.DP(this.lbJ.cMX().eCJ);
        }
        h(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.lbJ != null) {
            this.lbG.c(this.lbJ.cNd());
        }
        this.lbG.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e dfs() {
        return this.lbJ;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d Fg(int i) {
        return this.lbG.Fg(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int dft() {
        return this.lbG.dft();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dfu() {
        this.lbG.dfu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGg() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jjA, 5000L);
        this.jjq = true;
        this.lbt.Fa(dft());
    }

    private void bCV() {
        if (!this.lbv) {
            this.lbv = true;
            this.jJY.setVisibility(0);
            SvgManager.brn().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.brn().a(this.jJY, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            if (this.lbt instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lbt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNr() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Ob);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.lbz.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jRO, length - 1, spannableString.length(), 33);
        this.lbz.setText(spannableString);
        this.lbz.setHeight(this.lbz.getLineHeight() * 2);
        this.lbz.scrollTo(0, 0);
        this.lbz.requestLayout();
    }

    private void h(@NonNull e eVar) {
        bCV();
        this.lby.setTopicInfo(eVar.cMX());
        a(eVar.cMX());
        g(eVar);
        List<q> cNf = eVar.cNf();
        if (y.isEmpty(cNf)) {
            this.lbE.setVisibility(8);
        } else {
            this.lbE.setData(cNf);
            this.lbE.setVisibility(0);
        }
        if (eVar.cMX() != null) {
            String str = eVar.cMX().eCJ;
            if (af.getTextLengthWithEmoji(str) > 15) {
                str = af.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.jPt)) {
            this.lbz.setVisibility(8);
        } else {
            this.lbz.setText(fVar.jPt);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.lby.onChangeSkinType(skinType);
            ap.setViewTextColor(this.lbz, R.color.cp_cont_b, 1);
            ap.setBackgroundColor(this.lbC, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.lbu, R.color.cp_bg_line_h);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.lbD.onChangeSkinType(skinType);
            this.fPJ.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
            this.lbE.onChangeSkinType(skinType);
            this.lbG.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(long j, long j2, int i) {
        this.lbD.e(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void E(long j, long j2) {
        this.lby.F(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.lbG != null) {
            this.lbG.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.lbG != null) {
            this.lbG.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        dfq();
        dfr();
        if (this.lbG != null) {
            this.lbG.destroy();
        }
        if (this.jjq) {
            cGh();
        }
        if (this.eVj != null) {
            this.eVj.cancel();
            this.eVj.removeAllListeners();
            this.eVj.removeAllUpdateListeners();
            this.eVj = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jjA);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void g(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cMZ() != null) {
            aVar = eVar.cMZ();
            aVar.jOU = 3;
        } else if (eVar.cNa() != null) {
            aVar = eVar.cNa();
            aVar.jOU = 2;
        } else if (eVar.cNb() != null) {
            aVar = eVar.cNb();
            aVar.jOU = 1;
        }
        this.lby.setBlessInfo(aVar);
        if (eVar.cMY() == null) {
            this.lbD.setVisibility(8);
            return;
        }
        this.lbD.setVisibility(0);
        this.lbD.a(eVar.cMY());
    }
}
