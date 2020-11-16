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
/* loaded from: classes20.dex */
public class HotTopicDetailView extends RelativeLayout implements a.b {
    private static int lbK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String Ob;
    private int cso;
    private ValueAnimator eUt;
    private TbTabLayout fPs;
    private g grV;
    private int iKr;
    private int iKs;
    private AppBarLayout.OnOffsetChangedListener iLs;
    private ImageView jKJ;
    private c jSL;
    private int jSt;
    private ClickableSpan jSy;
    private ClickableSpan jSz;
    private boolean jkb;
    private PullRefreshFrameLayout.d jkj;
    private PullRefreshFrameLayout.c jkk;
    private Runnable jkl;
    private a.InterfaceC0798a lbL;
    private View lbM;
    private boolean lbN;
    private ViewGroup lbO;
    private PullRefreshFrameLayout lbP;
    private HotTopicDetailHeadView lbQ;
    private TextView lbR;
    private View lbS;
    private AppBarLayout lbT;
    private View lbU;
    private HotTopicDetailPkLayout lbV;
    private HotTopicDetailSpecialLayout lbW;
    private CustomViewPager lbX;
    private HotTopicDetailPagerAdapter lbY;
    private View lbZ;
    private RecyclerView.OnScrollListener lca;
    private e lcb;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0798a interfaceC0798a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cso = UtilHelper.getStatusBarHeight();
        this.lbN = false;
        this.Ob = "";
        this.lca = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.deT();
            }
        };
        this.jkb = false;
        this.iLs = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.lbP != null) {
                    HotTopicDetailView.this.lbP.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.FH(i);
            }
        };
        this.jkj = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                HotTopicDetailView.this.B(d);
                HotTopicDetailView.this.lbP.brP();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicDetailView.this.eUt = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.eUt.setDuration(150L);
                final int height = HotTopicDetailView.this.lbQ.getHeight();
                HotTopicDetailView.this.eUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.eUt.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void brS() {
                final int i = HotTopicDetailView.this.iKs - HotTopicDetailView.this.iKr;
                if (i > 0) {
                    HotTopicDetailView.this.eUt = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.eUt.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.iKs;
                    HotTopicDetailView.this.eUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.lbQ != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.eUt.start();
                }
            }
        };
        this.jkl = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.jkb) {
                    HotTopicDetailView.this.cFM();
                }
            }
        };
        this.jkk = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void brR() {
                HotTopicDetailView.this.cFL();
            }
        };
        this.jSy = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
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
                spannableString.setSpan(HotTopicDetailView.this.jSz, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.lbR.setText(spannableString);
                HotTopicDetailView.this.lbR.setHeight(HotTopicDetailView.this.jSt * HotTopicDetailView.this.lbR.getLineHeight());
                int lineCount = HotTopicDetailView.this.lbR.getLineCount() * HotTopicDetailView.this.lbR.getLineHeight();
                if (lineCount > HotTopicDetailView.this.jSt * HotTopicDetailView.this.lbR.getLineHeight()) {
                    HotTopicDetailView.this.lbR.scrollTo(0, lineCount - (HotTopicDetailView.this.jSt * HotTopicDetailView.this.lbR.getLineHeight()));
                }
                HotTopicDetailView.this.lbR.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.jSz = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.lbR.setText(HotTopicDetailView.this.Ob);
                HotTopicDetailView.this.cMX();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.mPageContext = tbPageContext;
        this.lbL = interfaceC0798a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.lbM = findViewById(R.id.topBgView);
        this.lbM.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.jKJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bh.checkUpIsLogin(HotTopicDetailView.this.jKJ.getContext())) {
                    HotTopicDetailView.this.lbL.e(HotTopicDetailView.this.lcb);
                }
            }
        });
        this.jKJ.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.cso;
        findViewById.setLayoutParams(layoutParams);
        this.lbO = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.lbP = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lbP.setOnTouchCallback(this.jkj);
        this.lbP.setOnPullRefreshListener(this.jkk);
        this.lbP.setFromFrs();
        this.lbP.brO();
        this.lbQ = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.iKr = l.getDimens(getContext(), R.dimen.tbds600);
        this.iKs = this.iKr;
        this.lbU = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.lbU.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.cso);
            }
        });
        this.lbR = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.lbV = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.lbW = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.lbW.x(this.mPageContext);
        this.lbS = findViewById(R.id.contentContainer);
        this.lbT = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.lbT.addOnOffsetChangedListener(this.iLs);
        this.lbX = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.lbY = new HotTopicDetailPagerAdapter(getContext());
        this.lbY.setScrollListener(this.lca);
        this.lbX.setAdapter(this.lbY);
        this.fPs = (TbTabLayout) findViewById(R.id.tabLayout);
        this.fPs.setSelectedTabTextBlod(true);
        this.fPs.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.fPs.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
        this.fPs.setupWithViewPager(this.lbX);
        this.lbZ = findViewById(R.id.dividerShadow);
        this.jSL = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void B(double d) {
        if (this.lbQ != null) {
            int i = (int) (this.iKr + (PullRefreshFrameLayout.eTY * d));
            ViewGroup.LayoutParams layoutParams = this.lbQ.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iKs = layoutParams.height;
                this.lbQ.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.lbQ != null && (layoutParams = this.lbQ.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iKs = i;
            this.lbQ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FH(int i) {
        int i2 = lbK + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / lbK);
        this.lbM.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        deT();
        if (f > 0.1d) {
            as.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            as.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.lcb == null) {
            SvgManager.bqB().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bqB().a(this.jKJ, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.bqB().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bqB().a(this.jKJ, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deT() {
        if (this.cso + this.mNavigationBar.getHeight() >= this.lbS.getY()) {
            ap.setBackgroundColor(this.fPs, R.color.CAM_X0207);
            if (this.mSkinType == 0) {
                this.lbZ.setVisibility(0);
                return;
            }
            return;
        }
        ap.setBackgroundColor(this.fPs, R.color.transparent);
        this.lbZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFM() {
        this.jkb = false;
        if (this.lbP != null) {
            this.lbP.brN();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void deM() {
        if (this.grV == null) {
            this.grV = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            this.grV.setBackground(ap.getColor(R.color.CAM_X0201));
        }
        this.grV.attachView(this.lbO, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void deN() {
        if (this.grV != null) {
            this.grV.dettachView(this.lbO);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bOA() {
        if (this.jkb) {
            cFM();
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jkl);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void tC(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.lbL != null) {
                            HotTopicDetailView.this.lbL.Fy(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lbO, false);
            this.mRefreshView.setBackGroundColor(R.color.CAM_X0201);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void deO() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lbO);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void FB(int i) {
        this.lbY.FB(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void FC(int i) {
        this.lbY.FC(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void F(boolean z, int i) {
        this.lbY.F(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void FD(int i) {
        this.lbY.FD(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(@NonNull e eVar) {
        this.lcb = eVar;
        if (this.lcb.cME() != null) {
            this.jSL.setTopicId(this.lcb.cME().eQb);
            this.jSL.Do(this.lcb.cME().eBa);
        }
        h(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.lcb != null) {
            this.lbY.c(this.lcb.cMK());
        }
        this.lbY.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e deP() {
        return this.lcb;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d FE(int i) {
        return this.lbY.FE(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int deQ() {
        return this.lbY.deQ();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void deR() {
        this.lbY.deR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFL() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jkl, 5000L);
        this.jkb = true;
        this.lbL.Fy(deQ());
    }

    private void bCo() {
        if (!this.lbN) {
            this.lbN = true;
            this.jKJ.setVisibility(0);
            SvgManager.bqB().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bqB().a(this.jKJ, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.lbL instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lbL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMX() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Ob);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.lbR.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jSy, length - 1, spannableString.length(), 33);
        this.lbR.setText(spannableString);
        this.lbR.setHeight(this.lbR.getLineHeight() * 2);
        this.lbR.scrollTo(0, 0);
        this.lbR.requestLayout();
    }

    private void h(@NonNull e eVar) {
        bCo();
        this.lbQ.setTopicInfo(eVar.cME());
        a(eVar.cME());
        g(eVar);
        List<q> cMM = eVar.cMM();
        if (y.isEmpty(cMM)) {
            this.lbW.setVisibility(8);
        } else {
            this.lbW.setData(cMM);
            this.lbW.setVisibility(0);
        }
        if (eVar.cME() != null) {
            String str = eVar.cME().eBa;
            if (ae.getTextLengthWithEmoji(str) > 15) {
                str = ae.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.jQd)) {
            this.lbR.setVisibility(8);
        } else {
            this.lbR.setText(fVar.jQd);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.lbQ.onChangeSkinType(skinType);
            ap.setViewTextColor(this.lbR, R.color.CAM_X0105, 1);
            ap.setBackgroundColor(this.lbU, R.color.CAM_X0201);
            ap.setBackgroundColor(this.lbM, R.color.CAM_X0207);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.grV != null) {
                this.grV.setBackground(ap.getColor(R.color.CAM_X0201));
            }
            this.lbV.onChangeSkinType(skinType);
            this.fPs.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
            this.lbW.onChangeSkinType(skinType);
            this.lbY.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(long j, long j2, int i) {
        this.lbV.e(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void E(long j, long j2) {
        this.lbQ.F(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.lbY != null) {
            this.lbY.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.lbY != null) {
            this.lbY.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        deN();
        deO();
        if (this.lbY != null) {
            this.lbY.destroy();
        }
        if (this.jkb) {
            cFM();
        }
        if (this.eUt != null) {
            this.eUt.cancel();
            this.eUt.removeAllListeners();
            this.eUt.removeAllUpdateListeners();
            this.eUt = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jkl);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void g(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cMG() != null) {
            aVar = eVar.cMG();
            aVar.jPE = 3;
        } else if (eVar.cMH() != null) {
            aVar = eVar.cMH();
            aVar.jPE = 2;
        } else if (eVar.cMI() != null) {
            aVar = eVar.cMI();
            aVar.jPE = 1;
        }
        this.lbQ.setBlessInfo(aVar);
        if (eVar.cMF() == null) {
            this.lbV.setVisibility(8);
            return;
        }
        this.lbV.setVisibility(0);
        this.lbV.a(eVar.cMF());
    }
}
