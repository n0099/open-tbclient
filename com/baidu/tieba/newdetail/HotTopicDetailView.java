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
/* loaded from: classes7.dex */
public class HotTopicDetailView extends RelativeLayout implements a.b {
    private static int lpO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String OX;
    private int czr;
    private ValueAnimator fgO;
    private g gGD;
    private TbTabLayout gcC;
    private PullRefreshFrameLayout.d jFF;
    private PullRefreshFrameLayout.c jFG;
    private Runnable jFH;
    private boolean jFx;
    private ImageView jMm;
    private int jcR;
    private int jcS;
    private AppBarLayout.OnOffsetChangedListener jdS;
    private int koG;
    private ClickableSpan koL;
    private ClickableSpan koM;
    private c koY;
    private a.InterfaceC0800a lpP;
    private View lpQ;
    private boolean lpR;
    private ViewGroup lpS;
    private PullRefreshFrameLayout lpT;
    private HotTopicDetailHeadView lpU;
    private TextView lpV;
    private View lpW;
    private AppBarLayout lpX;
    private View lpY;
    private HotTopicDetailPkLayout lpZ;
    private HotTopicDetailSpecialLayout lqa;
    private CustomViewPager lqb;
    private HotTopicDetailPagerAdapter lqc;
    private View lqd;
    private RecyclerView.OnScrollListener lqe;
    private e lqf;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0800a interfaceC0800a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.czr = UtilHelper.getStatusBarHeight();
        this.lpR = false;
        this.OX = "";
        this.lqe = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.dfZ();
            }
        };
        this.jFx = false;
        this.jdS = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.lpT != null) {
                    HotTopicDetailView.this.lpT.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.EI(i);
            }
        };
        this.jFF = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void q(double d) {
                HotTopicDetailView.this.v(d);
                HotTopicDetailView.this.lpT.btQ();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                HotTopicDetailView.this.fgO = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.fgO.setDuration(150L);
                final int height = HotTopicDetailView.this.lpU.getHeight();
                HotTopicDetailView.this.fgO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.fgO.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void btT() {
                final int i = HotTopicDetailView.this.jcS - HotTopicDetailView.this.jcR;
                if (i > 0) {
                    HotTopicDetailView.this.fgO = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.fgO.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.jcS;
                    HotTopicDetailView.this.fgO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.lpU != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.fgO.start();
                }
            }
        };
        this.jFH = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.jFx) {
                    HotTopicDetailView.this.cKn();
                }
            }
        };
        this.jFG = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void btS() {
                HotTopicDetailView.this.cKm();
            }
        };
        this.koL = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.OX);
                if (HotTopicDetailView.this.OX.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicDetailView.this.koM, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.lpV.setText(spannableString);
                HotTopicDetailView.this.lpV.setHeight(HotTopicDetailView.this.koG * HotTopicDetailView.this.lpV.getLineHeight());
                int lineCount = HotTopicDetailView.this.lpV.getLineCount() * HotTopicDetailView.this.lpV.getLineHeight();
                if (lineCount > HotTopicDetailView.this.koG * HotTopicDetailView.this.lpV.getLineHeight()) {
                    HotTopicDetailView.this.lpV.scrollTo(0, lineCount - (HotTopicDetailView.this.koG * HotTopicDetailView.this.lpV.getLineHeight()));
                }
                HotTopicDetailView.this.lpV.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.koM = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.lpV.setText(HotTopicDetailView.this.OX);
                HotTopicDetailView.this.cRB();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.mPageContext = tbPageContext;
        this.lpP = interfaceC0800a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.lpQ = findViewById(R.id.topBgView);
        this.lpQ.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.jMm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bg.checkUpIsLogin(HotTopicDetailView.this.jMm.getContext())) {
                    HotTopicDetailView.this.lpP.d(HotTopicDetailView.this.lqf);
                }
            }
        });
        this.jMm.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.czr;
        findViewById.setLayoutParams(layoutParams);
        this.lpS = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.lpT = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lpT.setOnTouchCallback(this.jFF);
        this.lpT.setOnPullRefreshListener(this.jFG);
        this.lpT.setFromFrs();
        this.lpT.btP();
        this.lpU = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.jcR = l.getDimens(getContext(), R.dimen.tbds600);
        this.jcS = this.jcR;
        this.lpY = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.lpY.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.czr);
            }
        });
        this.lpV = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.lpZ = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.lqa = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.lqa.w(this.mPageContext);
        this.lpW = findViewById(R.id.contentContainer);
        this.lpX = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.lpX.addOnOffsetChangedListener(this.jdS);
        this.lqb = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.lqc = new HotTopicDetailPagerAdapter(getContext());
        this.lqc.setScrollListener(this.lqe);
        this.lqb.setAdapter(this.lqc);
        this.gcC = (TbTabLayout) findViewById(R.id.tabLayout);
        this.gcC.setSelectedTabTextBlod(true);
        this.gcC.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.gcC.setSelectedTabIndicatorColor(ao.getColor(R.color.CAM_X0302));
        this.gcC.setupWithViewPager(this.lqb);
        this.lqd = findViewById(R.id.dividerShadow);
        this.koY = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void v(double d) {
        if (this.lpU != null) {
            int i = (int) (this.jcR + (PullRefreshFrameLayout.fgt * d));
            ViewGroup.LayoutParams layoutParams = this.lpU.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jcS = layoutParams.height;
                this.lpU.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.lpU != null && (layoutParams = this.lpU.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jcS = i;
            this.lpU.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EI(int i) {
        int i2 = lpO + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / lpO);
        this.lpQ.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        dfZ();
        if (f > 0.1d) {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.lqf == null) {
            SvgManager.bsx().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsx().a(this.jMm, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.bsx().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsx().a(this.jMm, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfZ() {
        if (this.czr + this.mNavigationBar.getHeight() >= this.lpW.getY()) {
            ao.setBackgroundColor(this.gcC, R.color.CAM_X0207);
            if (this.mSkinType == 0) {
                this.lqd.setVisibility(0);
                return;
            }
            return;
        }
        ao.setBackgroundColor(this.gcC, R.color.transparent);
        this.lqd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKn() {
        this.jFx = false;
        if (this.lpT != null) {
            this.lpT.btO();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dfS() {
        if (this.gGD == null) {
            this.gGD = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            this.gGD.setBackground(ao.getColor(R.color.CAM_X0201));
        }
        this.gGD.attachView(this.lpS, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dfT() {
        if (this.gGD != null) {
            this.gGD.dettachView(this.lpS);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bQX() {
        if (this.jFx) {
            cKn();
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jFH);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void ub(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.lpP != null) {
                            HotTopicDetailView.this.lpP.Ez(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lpS, false);
            this.mRefreshView.setBackGroundColor(R.color.CAM_X0201);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dfU() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lpS);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void EC(int i) {
        this.lqc.EC(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void ED(int i) {
        this.lqc.ED(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void E(boolean z, int i) {
        this.lqc.E(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void EE(int i) {
        this.lqc.EE(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(@NonNull e eVar) {
        this.lqf = eVar;
        if (this.lqf.cRi() != null) {
            this.koY.setTopicId(this.lqf.cRi().fci);
            this.koY.CH(this.lqf.cRi().eNh);
        }
        g(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.lqf != null) {
            this.lqc.c(this.lqf.cRo());
        }
        this.lqc.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e dfV() {
        return this.lqf;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d EF(int i) {
        return this.lqc.EF(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int dfW() {
        return this.lqc.dfW();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dfX() {
        this.lqc.dfX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKm() {
        com.baidu.adp.lib.f.e.mB().postDelayed(this.jFH, 5000L);
        this.jFx = true;
        this.lpP.Ez(dfW());
    }

    private void bEt() {
        if (!this.lpR) {
            this.lpR = true;
            this.jMm.setVisibility(0);
            SvgManager.bsx().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsx().a(this.jMm, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ao.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.lpP instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lpP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRB() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OX);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.lpV.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.koL, length - 1, spannableString.length(), 33);
        this.lpV.setText(spannableString);
        this.lpV.setHeight(this.lpV.getLineHeight() * 2);
        this.lpV.scrollTo(0, 0);
        this.lpV.requestLayout();
    }

    private void g(@NonNull e eVar) {
        bEt();
        this.lpU.setTopicInfo(eVar.cRi());
        a(eVar.cRi());
        f(eVar);
        List<n> cRq = eVar.cRq();
        if (x.isEmpty(cRq)) {
            this.lqa.setVisibility(8);
        } else {
            this.lqa.setData(cRq);
            this.lqa.setVisibility(0);
        }
        if (eVar.cRi() != null) {
            String str = eVar.cRi().eNh;
            if (ad.getTextLengthWithEmoji(str) > 15) {
                str = ad.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.kmp)) {
            this.lpV.setVisibility(8);
        } else {
            this.lpV.setText(fVar.kmp);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.lpU.onChangeSkinType(skinType);
            ao.setViewTextColor(this.lpV, R.color.CAM_X0105, 1);
            ao.setBackgroundColor(this.lpY, R.color.CAM_X0201);
            ao.setBackgroundColor(this.lpQ, R.color.CAM_X0207);
            ao.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.gGD != null) {
                this.gGD.setBackground(ao.getColor(R.color.CAM_X0201));
            }
            this.lpZ.onChangeSkinType(skinType);
            this.gcC.setTabTextColors(ao.getColor(R.color.CAM_X0107), ao.getColor(R.color.CAM_X0105));
            this.lqa.onChangeSkinType(skinType);
            this.lqc.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(long j, long j2, int i) {
        this.lpZ.f(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void G(long j, long j2) {
        this.lpU.H(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.lqc != null) {
            this.lqc.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.lqc != null) {
            this.lqc.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        dfT();
        dfU();
        if (this.lqc != null) {
            this.lqc.destroy();
        }
        if (this.jFx) {
            cKn();
        }
        if (this.fgO != null) {
            this.fgO.cancel();
            this.fgO.removeAllListeners();
            this.fgO.removeAllUpdateListeners();
            this.fgO = null;
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jFH);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cRk() != null) {
            aVar = eVar.cRk();
            aVar.klQ = 3;
        } else if (eVar.cRl() != null) {
            aVar = eVar.cRl();
            aVar.klQ = 2;
        } else if (eVar.cRm() != null) {
            aVar = eVar.cRm();
            aVar.klQ = 1;
        }
        this.lpU.setBlessInfo(aVar);
        if (eVar.cRj() == null) {
            this.lpZ.setVisibility(8);
            return;
        }
        this.lpZ.setVisibility(0);
        this.lpZ.a(eVar.cRj());
    }
}
