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
/* loaded from: classes20.dex */
public class HotTopicDetailView extends RelativeLayout implements a.b {
    private static int ktM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String NI;
    private int bTp;
    private ValueAnimator euO;
    private g fQf;
    private TbTabLayout fpk;
    private boolean iCg;
    private PullRefreshFrameLayout.d iCo;
    private PullRefreshFrameLayout.c iCp;
    private Runnable iCq;
    private int ick;
    private int icl;
    private AppBarLayout.OnOffsetChangedListener idm;
    private ImageView jcB;
    private c jkH;
    private int jkp;
    private ClickableSpan jku;
    private ClickableSpan jkv;
    private a.InterfaceC0748a ktN;
    private View ktO;
    private boolean ktP;
    private ViewGroup ktQ;
    private PullRefreshFrameLayout ktR;
    private HotTopicDetailHeadView ktS;
    private TextView ktT;
    private View ktU;
    private AppBarLayout ktV;
    private View ktW;
    private HotTopicDetailPkLayout ktX;
    private HotTopicDetailSpecialLayout ktY;
    private CustomViewPager ktZ;
    private HotTopicDetailPagerAdapter kua;
    private View kub;
    private RecyclerView.OnScrollListener kuc;
    private e kud;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0748a interfaceC0748a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.bTp = UtilHelper.getStatusBarHeight();
        this.ktP = false;
        this.NI = "";
        this.kuc = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.cWd();
            }
        };
        this.iCg = false;
        this.idm = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.ktR != null) {
                    HotTopicDetailView.this.ktR.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.DX(i);
            }
        };
        this.iCo = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void t(double d) {
                HotTopicDetailView.this.x(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicDetailView.this.euO = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.euO.setDuration(150L);
                final int height = HotTopicDetailView.this.ktS.getHeight();
                HotTopicDetailView.this.euO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.euO.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void blz() {
                final int i = HotTopicDetailView.this.icl - HotTopicDetailView.this.ick;
                if (i > 0) {
                    HotTopicDetailView.this.euO = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.euO.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.icl;
                    HotTopicDetailView.this.euO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.ktS != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.euO.start();
                }
            }
        };
        this.iCq = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.iCg) {
                    HotTopicDetailView.this.cxc();
                }
            }
        };
        this.iCp = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bly() {
                HotTopicDetailView.this.cxb();
            }
        };
        this.jku = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.NI);
                if (HotTopicDetailView.this.NI.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicDetailView.this.jkv, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.ktT.setText(spannableString);
                HotTopicDetailView.this.ktT.setHeight(HotTopicDetailView.this.jkp * HotTopicDetailView.this.ktT.getLineHeight());
                int lineCount = HotTopicDetailView.this.ktT.getLineCount() * HotTopicDetailView.this.ktT.getLineHeight();
                if (lineCount > HotTopicDetailView.this.jkp * HotTopicDetailView.this.ktT.getLineHeight()) {
                    HotTopicDetailView.this.ktT.scrollTo(0, lineCount - (HotTopicDetailView.this.jkp * HotTopicDetailView.this.ktT.getLineHeight()));
                }
                HotTopicDetailView.this.ktT.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jkv = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.ktT.setText(HotTopicDetailView.this.NI);
                HotTopicDetailView.this.cEa();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.mPageContext = tbPageContext;
        this.ktN = interfaceC0748a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.ktO = findViewById(R.id.topBgView);
        this.ktO.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.jcB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bg.checkUpIsLogin(HotTopicDetailView.this.jcB.getContext())) {
                    HotTopicDetailView.this.ktN.e(HotTopicDetailView.this.kud);
                }
            }
        });
        this.jcB.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.bTp;
        findViewById.setLayoutParams(layoutParams);
        this.ktQ = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.ktR = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.ktR.setOnTouchCallback(this.iCo);
        this.ktR.setOnPullRefreshListener(this.iCp);
        this.ktR.setFromFrs();
        this.ktR.blw();
        this.ktS = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.ick = l.getDimens(getContext(), R.dimen.tbds600);
        this.icl = this.ick;
        this.ktW = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.ktW.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.bTp);
            }
        });
        this.ktT = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.ktX = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.ktY = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.ktY.x(this.mPageContext);
        this.ktU = findViewById(R.id.contentContainer);
        this.ktV = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.ktV.addOnOffsetChangedListener(this.idm);
        this.ktZ = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.kua = new HotTopicDetailPagerAdapter(getContext());
        this.kua.setScrollListener(this.kuc);
        this.ktZ.setAdapter(this.kua);
        this.fpk = (TbTabLayout) findViewById(R.id.tabLayout);
        this.fpk.setSelectedTabTextBlod(true);
        this.fpk.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.fpk.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_link_tip_a));
        this.fpk.setupWithViewPager(this.ktZ);
        this.kub = findViewById(R.id.dividerShadow);
        this.jkH = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void x(double d) {
        if (this.ktS != null) {
            int i = (int) (this.ick + (PullRefreshFrameLayout.euv * d));
            ViewGroup.LayoutParams layoutParams = this.ktS.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.icl = layoutParams.height;
                this.ktS.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.ktS != null && (layoutParams = this.ktS.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.icl = i;
            this.ktS.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DX(int i) {
        int i2 = ktM + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / ktM);
        this.ktO.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        cWd();
        if (f > 0.1d) {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.kud == null) {
            SvgManager.bkl().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bkl().a(this.jcB, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.bkl().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bkl().a(this.jcB, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWd() {
        if (this.bTp + this.mNavigationBar.getHeight() >= this.ktU.getY()) {
            ap.setBackgroundColor(this.fpk, R.color.cp_bg_line_h);
            if (this.mSkinType == 0) {
                this.kub.setVisibility(0);
                return;
            }
            return;
        }
        ap.setBackgroundColor(this.fpk, R.color.transparent);
        this.kub.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxc() {
        this.iCg = false;
        if (this.ktR != null) {
            this.ktR.blv();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cVW() {
        if (this.fQf == null) {
            this.fQf = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fQf.attachView(this.ktQ, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cVX() {
        if (this.fQf != null) {
            this.fQf.dettachView(this.ktQ);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bHu() {
        if (this.iCg) {
            cxc();
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iCq);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void ss(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.ktN != null) {
                            HotTopicDetailView.this.ktN.DO(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.ktQ, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cVY() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.ktQ);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void DR(int i) {
        this.kua.DR(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void DS(int i) {
        this.kua.DS(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void C(boolean z, int i) {
        this.kua.C(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void DT(int i) {
        this.kua.DT(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(@NonNull e eVar) {
        this.kud = eVar;
        if (this.kud.cDG() != null) {
            this.jkH.setTopicId(this.kud.cDG().eqD);
            this.jkH.Cw(this.kud.cDG().ecp);
        }
        h(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.kud != null) {
            this.kua.c(this.kud.cDM());
        }
        this.kua.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e cVZ() {
        return this.kud;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d DU(int i) {
        return this.kua.DU(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int cWa() {
        return this.kua.cWa();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cWb() {
        this.kua.cWb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxb() {
        com.baidu.adp.lib.f.e.mX().postDelayed(this.iCq, 5000L);
        this.iCg = true;
        this.ktN.DO(cWa());
    }

    private void bvT() {
        if (!this.ktP) {
            this.ktP = true;
            this.jcB.setVisibility(0);
            SvgManager.bkl().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bkl().a(this.jcB, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            if (this.ktN instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.ktN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEa() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.NI);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.ktT.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jku, length - 1, spannableString.length(), 33);
        this.ktT.setText(spannableString);
        this.ktT.setHeight(this.ktT.getLineHeight() * 2);
        this.ktT.scrollTo(0, 0);
        this.ktT.requestLayout();
    }

    private void h(@NonNull e eVar) {
        bvT();
        this.ktS.setTopicInfo(eVar.cDG());
        a(eVar.cDG());
        g(eVar);
        List<q> cDO = eVar.cDO();
        if (y.isEmpty(cDO)) {
            this.ktY.setVisibility(8);
        } else {
            this.ktY.setData(cDO);
            this.ktY.setVisibility(0);
        }
        if (eVar.cDG() != null) {
            String str = eVar.cDG().ecp;
            if (af.getTextLengthWithEmoji(str) > 15) {
                str = af.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.jhX)) {
            this.ktT.setVisibility(8);
        } else {
            this.ktT.setText(fVar.jhX);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.ktS.onChangeSkinType(skinType);
            ap.setViewTextColor(this.ktT, R.color.cp_cont_b, 1);
            ap.setBackgroundColor(this.ktW, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.ktO, R.color.cp_bg_line_h);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.ktX.onChangeSkinType(skinType);
            this.fpk.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
            this.ktY.onChangeSkinType(skinType);
            this.kua.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void d(long j, long j2, int i) {
        this.ktX.d(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void C(long j, long j2) {
        this.ktS.D(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.kua != null) {
            this.kua.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.kua != null) {
            this.kua.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        cVX();
        cVY();
        if (this.kua != null) {
            this.kua.destroy();
        }
        if (this.iCg) {
            cxc();
        }
        if (this.euO != null) {
            this.euO.cancel();
            this.euO.removeAllListeners();
            this.euO.removeAllUpdateListeners();
            this.euO = null;
        }
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iCq);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void g(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cDI() != null) {
            aVar = eVar.cDI();
            aVar.jhy = 3;
        } else if (eVar.cDJ() != null) {
            aVar = eVar.cDJ();
            aVar.jhy = 2;
        } else if (eVar.cDK() != null) {
            aVar = eVar.cDK();
            aVar.jhy = 1;
        }
        this.ktS.setBlessInfo(aVar);
        if (eVar.cDH() == null) {
            this.ktX.setVisibility(8);
            return;
        }
        this.ktX.setVisibility(0);
        this.ktX.a(eVar.cDH());
    }
}
