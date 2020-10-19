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
    private static int kIY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String Oa;
    private int cfD;
    private ValueAnimator eGY;
    private TbTabLayout fBy;
    private g gcx;
    private boolean iQW;
    private PullRefreshFrameLayout.d iRe;
    private PullRefreshFrameLayout.c iRf;
    private Runnable iRg;
    private int irl;
    private int irm;
    private AppBarLayout.OnOffsetChangedListener ism;
    private ImageView jrA;
    private c jzF;
    private int jzn;
    private ClickableSpan jzs;
    private ClickableSpan jzt;
    private a.InterfaceC0766a kIZ;
    private View kJa;
    private boolean kJb;
    private ViewGroup kJc;
    private PullRefreshFrameLayout kJd;
    private HotTopicDetailHeadView kJe;
    private TextView kJf;
    private View kJg;
    private AppBarLayout kJh;
    private View kJi;
    private HotTopicDetailPkLayout kJj;
    private HotTopicDetailSpecialLayout kJk;
    private CustomViewPager kJl;
    private HotTopicDetailPagerAdapter kJm;
    private View kJn;
    private RecyclerView.OnScrollListener kJo;
    private e kJp;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0766a interfaceC0766a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cfD = UtilHelper.getStatusBarHeight();
        this.kJb = false;
        this.Oa = "";
        this.kJo = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.cZM();
            }
        };
        this.iQW = false;
        this.ism = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.kJd != null) {
                    HotTopicDetailView.this.kJd.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.ED(i);
            }
        };
        this.iRe = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                HotTopicDetailView.this.A(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicDetailView.this.eGY = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.eGY.setDuration(150L);
                final int height = HotTopicDetailView.this.kJe.getHeight();
                HotTopicDetailView.this.eGY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.eGY.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void boj() {
                final int i = HotTopicDetailView.this.irm - HotTopicDetailView.this.irl;
                if (i > 0) {
                    HotTopicDetailView.this.eGY = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.eGY.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.irm;
                    HotTopicDetailView.this.eGY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.kJe != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.eGY.start();
                }
            }
        };
        this.iRg = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.iQW) {
                    HotTopicDetailView.this.cAz();
                }
            }
        };
        this.iRf = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void boi() {
                HotTopicDetailView.this.cAy();
            }
        };
        this.jzs = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.Oa);
                if (HotTopicDetailView.this.Oa.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicDetailView.this.jzt, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.kJf.setText(spannableString);
                HotTopicDetailView.this.kJf.setHeight(HotTopicDetailView.this.jzn * HotTopicDetailView.this.kJf.getLineHeight());
                int lineCount = HotTopicDetailView.this.kJf.getLineCount() * HotTopicDetailView.this.kJf.getLineHeight();
                if (lineCount > HotTopicDetailView.this.jzn * HotTopicDetailView.this.kJf.getLineHeight()) {
                    HotTopicDetailView.this.kJf.scrollTo(0, lineCount - (HotTopicDetailView.this.jzn * HotTopicDetailView.this.kJf.getLineHeight()));
                }
                HotTopicDetailView.this.kJf.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jzt = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.kJf.setText(HotTopicDetailView.this.Oa);
                HotTopicDetailView.this.cHJ();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.mPageContext = tbPageContext;
        this.kIZ = interfaceC0766a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.kJa = findViewById(R.id.topBgView);
        this.kJa.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.jrA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bg.checkUpIsLogin(HotTopicDetailView.this.jrA.getContext())) {
                    HotTopicDetailView.this.kIZ.e(HotTopicDetailView.this.kJp);
                }
            }
        });
        this.jrA.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.cfD;
        findViewById.setLayoutParams(layoutParams);
        this.kJc = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.kJd = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.kJd.setOnTouchCallback(this.iRe);
        this.kJd.setOnPullRefreshListener(this.iRf);
        this.kJd.setFromFrs();
        this.kJd.bog();
        this.kJe = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.irl = l.getDimens(getContext(), R.dimen.tbds600);
        this.irm = this.irl;
        this.kJi = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.kJi.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.cfD);
            }
        });
        this.kJf = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.kJj = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.kJk = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.kJk.x(this.mPageContext);
        this.kJg = findViewById(R.id.contentContainer);
        this.kJh = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.kJh.addOnOffsetChangedListener(this.ism);
        this.kJl = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.kJm = new HotTopicDetailPagerAdapter(getContext());
        this.kJm.setScrollListener(this.kJo);
        this.kJl.setAdapter(this.kJm);
        this.fBy = (TbTabLayout) findViewById(R.id.tabLayout);
        this.fBy.setSelectedTabTextBlod(true);
        this.fBy.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.fBy.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_link_tip_a));
        this.fBy.setupWithViewPager(this.kJl);
        this.kJn = findViewById(R.id.dividerShadow);
        this.jzF = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void A(double d) {
        if (this.kJe != null) {
            int i = (int) (this.irl + (PullRefreshFrameLayout.eGF * d));
            ViewGroup.LayoutParams layoutParams = this.kJe.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.irm = layoutParams.height;
                this.kJe.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.kJe != null && (layoutParams = this.kJe.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.irm = i;
            this.kJe.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ED(int i) {
        int i2 = kIY + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / kIY);
        this.kJa.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        cZM();
        if (f > 0.1d) {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.kJp == null) {
            SvgManager.bmU().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bmU().a(this.jrA, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.bmU().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bmU().a(this.jrA, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZM() {
        if (this.cfD + this.mNavigationBar.getHeight() >= this.kJg.getY()) {
            ap.setBackgroundColor(this.fBy, R.color.cp_bg_line_h);
            if (this.mSkinType == 0) {
                this.kJn.setVisibility(0);
                return;
            }
            return;
        }
        ap.setBackgroundColor(this.fBy, R.color.transparent);
        this.kJn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAz() {
        this.iQW = false;
        if (this.kJd != null) {
            this.kJd.bof();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cZF() {
        if (this.gcx == null) {
            this.gcx = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gcx.attachView(this.kJc, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cZG() {
        if (this.gcx != null) {
            this.gcx.dettachView(this.kJc);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bKf() {
        if (this.iQW) {
            cAz();
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iRg);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void sZ(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.kIZ != null) {
                            HotTopicDetailView.this.kIZ.Eu(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.kJc, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cZH() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.kJc);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Ex(int i) {
        this.kJm.Ex(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Ey(int i) {
        this.kJm.Ey(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void F(boolean z, int i) {
        this.kJm.F(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void Ez(int i) {
        this.kJm.Ez(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(@NonNull e eVar) {
        this.kJp = eVar;
        if (this.kJp.cHp() != null) {
            this.jzF.setTopicId(this.kJp.cHp().eCP);
            this.jzF.Di(this.kJp.cHp().eou);
        }
        h(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.kJp != null) {
            this.kJm.c(this.kJp.cHv());
        }
        this.kJm.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e cZI() {
        return this.kJp;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d EA(int i) {
        return this.kJm.EA(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int cZJ() {
        return this.kJm.cZJ();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cZK() {
        this.kJm.cZK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAy() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.iRg, 5000L);
        this.iQW = true;
        this.kIZ.Eu(cZJ());
    }

    private void byD() {
        if (!this.kJb) {
            this.kJb = true;
            this.jrA.setVisibility(0);
            SvgManager.bmU().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bmU().a(this.jrA, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            if (this.kIZ instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.kIZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHJ() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Oa);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.kJf.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jzs, length - 1, spannableString.length(), 33);
        this.kJf.setText(spannableString);
        this.kJf.setHeight(this.kJf.getLineHeight() * 2);
        this.kJf.scrollTo(0, 0);
        this.kJf.requestLayout();
    }

    private void h(@NonNull e eVar) {
        byD();
        this.kJe.setTopicInfo(eVar.cHp());
        a(eVar.cHp());
        g(eVar);
        List<q> cHx = eVar.cHx();
        if (y.isEmpty(cHx)) {
            this.kJk.setVisibility(8);
        } else {
            this.kJk.setData(cHx);
            this.kJk.setVisibility(0);
        }
        if (eVar.cHp() != null) {
            String str = eVar.cHp().eou;
            if (af.getTextLengthWithEmoji(str) > 15) {
                str = af.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.jwW)) {
            this.kJf.setVisibility(8);
        } else {
            this.kJf.setText(fVar.jwW);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.kJe.onChangeSkinType(skinType);
            ap.setViewTextColor(this.kJf, R.color.cp_cont_b, 1);
            ap.setBackgroundColor(this.kJi, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.kJa, R.color.cp_bg_line_h);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.kJj.onChangeSkinType(skinType);
            this.fBy.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
            this.kJk.onChangeSkinType(skinType);
            this.kJm.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(long j, long j2, int i) {
        this.kJj.e(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void C(long j, long j2) {
        this.kJe.D(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.kJm != null) {
            this.kJm.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.kJm != null) {
            this.kJm.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        cZG();
        cZH();
        if (this.kJm != null) {
            this.kJm.destroy();
        }
        if (this.iQW) {
            cAz();
        }
        if (this.eGY != null) {
            this.eGY.cancel();
            this.eGY.removeAllListeners();
            this.eGY.removeAllUpdateListeners();
            this.eGY = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iRg);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void g(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cHr() != null) {
            aVar = eVar.cHr();
            aVar.jwx = 3;
        } else if (eVar.cHs() != null) {
            aVar = eVar.cHs();
            aVar.jwx = 2;
        } else if (eVar.cHt() != null) {
            aVar = eVar.cHt();
            aVar.jwx = 1;
        }
        this.kJe.setBlessInfo(aVar);
        if (eVar.cHq() == null) {
            this.kJj.setVisibility(8);
            return;
        }
        this.kJj.setVisibility(0);
        this.kJj.a(eVar.cHq());
    }
}
