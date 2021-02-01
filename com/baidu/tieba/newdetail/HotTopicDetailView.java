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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ag;
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
    private static int lxS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String OV;
    private int cBN;
    private ValueAnimator fjh;
    private g gJn;
    private TbTabLayout geR;
    private boolean jLb;
    private PullRefreshFrameLayout.d jLj;
    private PullRefreshFrameLayout.c jLk;
    private Runnable jLl;
    private ImageView jTp;
    private int jiy;
    private int jiz;
    private AppBarLayout.OnOffsetChangedListener jjz;
    private int kwN;
    private ClickableSpan kwS;
    private ClickableSpan kwT;
    private c kxf;
    private a.InterfaceC0801a lxT;
    private View lxU;
    private boolean lxV;
    private ViewGroup lxW;
    private PullRefreshFrameLayout lxX;
    private HotTopicDetailHeadView lxY;
    private TextView lxZ;
    private View lya;
    private AppBarLayout lyb;
    private View lyc;
    private HotTopicDetailPkLayout lyd;
    private HotTopicDetailSpecialLayout lye;
    private CustomViewPager lyf;
    private HotTopicDetailPagerAdapter lyg;
    private View lyh;
    private RecyclerView.OnScrollListener lyi;
    private e lyj;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0801a interfaceC0801a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cBN = UtilHelper.getStatusBarHeight();
        this.lxV = false;
        this.OV = "";
        this.lyi = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.dia();
            }
        };
        this.jLb = false;
        this.jjz = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.lxX != null) {
                    HotTopicDetailView.this.lxX.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.Fa(i);
            }
        };
        this.jLj = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void q(double d) {
                HotTopicDetailView.this.v(d);
                HotTopicDetailView.this.lxX.buk();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                HotTopicDetailView.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.fjh.setDuration(150L);
                final int height = HotTopicDetailView.this.lxY.getHeight();
                HotTopicDetailView.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.fjh.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bun() {
                final int i = HotTopicDetailView.this.jiz - HotTopicDetailView.this.jiy;
                if (i > 0) {
                    HotTopicDetailView.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.fjh.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.jiz;
                    HotTopicDetailView.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.lxY != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.fjh.start();
                }
            }
        };
        this.jLl = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.jLb) {
                    HotTopicDetailView.this.cLB();
                }
            }
        };
        this.jLk = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bum() {
                HotTopicDetailView.this.cLA();
            }
        };
        this.kwS = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.OV);
                if (HotTopicDetailView.this.OV.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicDetailView.this.kwT, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.lxZ.setText(spannableString);
                HotTopicDetailView.this.lxZ.setHeight(HotTopicDetailView.this.kwN * HotTopicDetailView.this.lxZ.getLineHeight());
                int lineCount = HotTopicDetailView.this.lxZ.getLineCount() * HotTopicDetailView.this.lxZ.getLineHeight();
                if (lineCount > HotTopicDetailView.this.kwN * HotTopicDetailView.this.lxZ.getLineHeight()) {
                    HotTopicDetailView.this.lxZ.scrollTo(0, lineCount - (HotTopicDetailView.this.kwN * HotTopicDetailView.this.lxZ.getLineHeight()));
                }
                HotTopicDetailView.this.lxZ.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kwT = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.lxZ.setText(HotTopicDetailView.this.OV);
                HotTopicDetailView.this.cTA();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.mPageContext = tbPageContext;
        this.lxT = interfaceC0801a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.lxU = findViewById(R.id.topBgView);
        this.lxU.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.jTp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bh.checkUpIsLogin(HotTopicDetailView.this.jTp.getContext())) {
                    HotTopicDetailView.this.lxT.d(HotTopicDetailView.this.lyj);
                }
            }
        });
        this.jTp.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.cBN;
        findViewById.setLayoutParams(layoutParams);
        this.lxW = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.lxX = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lxX.setOnTouchCallback(this.jLj);
        this.lxX.setOnPullRefreshListener(this.jLk);
        this.lxX.setFromFrs();
        this.lxX.buj();
        this.lxY = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.jiy = l.getDimens(getContext(), R.dimen.tbds600);
        this.jiz = this.jiy;
        this.lyc = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.lyc.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.cBN);
            }
        });
        this.lxZ = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.lyd = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.lye = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.lye.y(this.mPageContext);
        this.lya = findViewById(R.id.contentContainer);
        this.lyb = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.lyb.addOnOffsetChangedListener(this.jjz);
        this.lyf = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.lyg = new HotTopicDetailPagerAdapter(getContext());
        this.lyg.setScrollListener(this.lyi);
        this.lyf.setAdapter(this.lyg);
        this.geR = (TbTabLayout) findViewById(R.id.tabLayout);
        this.geR.setSelectedTabTextBlod(true);
        this.geR.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.geR.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
        this.geR.setupWithViewPager(this.lyf);
        this.lyh = findViewById(R.id.dividerShadow);
        this.kxf = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void v(double d) {
        if (this.lxY != null) {
            int i = (int) (this.jiy + (PullRefreshFrameLayout.fiM * d));
            ViewGroup.LayoutParams layoutParams = this.lxY.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jiz = layoutParams.height;
                this.lxY.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.lxY != null && (layoutParams = this.lxY.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jiz = i;
            this.lxY.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fa(int i) {
        int i2 = lxS + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / lxS);
        this.lxU.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        dia();
        if (f > 0.1d) {
            as.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            as.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.lyj == null) {
            SvgManager.bsR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.jTp, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.bsR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsR().a(this.jTp, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dia() {
        if (this.cBN + this.mNavigationBar.getHeight() >= this.lya.getY()) {
            ap.setBackgroundColor(this.geR, R.color.CAM_X0207);
            if (this.mSkinType == 0) {
                this.lyh.setVisibility(0);
                return;
            }
            return;
        }
        ap.setBackgroundColor(this.geR, R.color.transparent);
        this.lyh.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLB() {
        this.jLb = false;
        if (this.lxX != null) {
            this.lxX.bui();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dhT() {
        if (this.gJn == null) {
            this.gJn = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            this.gJn.setBackground(ap.getColor(R.color.CAM_X0201));
        }
        this.gJn.attachView(this.lxW, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dhU() {
        if (this.gJn != null) {
            this.gJn.dettachView(this.lxW);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bRB() {
        if (this.jLb) {
            cLB();
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jLl);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void uo(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.lxT != null) {
                            HotTopicDetailView.this.lxT.ER(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lxW, false);
            this.mRefreshView.setBackGroundColor(R.color.CAM_X0201);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dhV() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lxW);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void EU(int i) {
        this.lyg.EU(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void EV(int i) {
        this.lyg.EV(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void E(boolean z, int i) {
        this.lyg.E(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void EW(int i) {
        this.lyg.EW(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(@NonNull e eVar) {
        this.lyj = eVar;
        if (this.lyj.cTh() != null) {
            this.kxf.setTopicId(this.lyj.cTh().fey);
            this.kxf.CY(this.lyj.cTh().ePt);
        }
        g(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.lyj != null) {
            this.lyg.c(this.lyj.cTn());
        }
        this.lyg.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e dhW() {
        return this.lyj;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d EX(int i) {
        return this.lyg.EX(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int dhX() {
        return this.lyg.dhX();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dhY() {
        this.lyg.dhY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLA() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.jLl, 5000L);
        this.jLb = true;
        this.lxT.ER(dhX());
    }

    private void bEL() {
        if (!this.lxV) {
            this.lxV = true;
            this.jTp.setVisibility(0);
            SvgManager.bsR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.jTp, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.lxT instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lxT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTA() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OV);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.lxZ.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.kwS, length - 1, spannableString.length(), 33);
        this.lxZ.setText(spannableString);
        this.lxZ.setHeight(this.lxZ.getLineHeight() * 2);
        this.lxZ.scrollTo(0, 0);
        this.lxZ.requestLayout();
    }

    private void g(@NonNull e eVar) {
        bEL();
        this.lxY.setTopicInfo(eVar.cTh());
        a(eVar.cTh());
        f(eVar);
        List<n> cTp = eVar.cTp();
        if (y.isEmpty(cTp)) {
            this.lye.setVisibility(8);
        } else {
            this.lye.setData(cTp);
            this.lye.setVisibility(0);
        }
        if (eVar.cTh() != null) {
            String str = eVar.cTh().ePt;
            if (ag.getTextLengthWithEmoji(str) > 15) {
                str = ag.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.kuw)) {
            this.lxZ.setVisibility(8);
        } else {
            this.lxZ.setText(fVar.kuw);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.lxY.onChangeSkinType(skinType);
            ap.setViewTextColor(this.lxZ, R.color.CAM_X0105, 1);
            ap.setBackgroundColor(this.lyc, R.color.CAM_X0201);
            ap.setBackgroundColor(this.lxU, R.color.CAM_X0207);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.gJn != null) {
                this.gJn.setBackground(ap.getColor(R.color.CAM_X0201));
            }
            this.lyd.onChangeSkinType(skinType);
            this.geR.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
            this.lye.onChangeSkinType(skinType);
            this.lyg.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(long j, long j2, int i) {
        this.lyd.e(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void K(long j, long j2) {
        this.lxY.L(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.lyg != null) {
            this.lyg.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.lyg != null) {
            this.lyg.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        dhU();
        dhV();
        if (this.lyg != null) {
            this.lyg.destroy();
        }
        if (this.jLb) {
            cLB();
        }
        if (this.fjh != null) {
            this.fjh.cancel();
            this.fjh.removeAllListeners();
            this.fjh.removeAllUpdateListeners();
            this.fjh = null;
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jLl);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cTj() != null) {
            aVar = eVar.cTj();
            aVar.ktX = 3;
        } else if (eVar.cTk() != null) {
            aVar = eVar.cTk();
            aVar.ktX = 2;
        } else if (eVar.cTl() != null) {
            aVar = eVar.cTl();
            aVar.ktX = 1;
        }
        this.lxY.setBlessInfo(aVar);
        if (eVar.cTi() == null) {
            this.lyd.setVisibility(8);
            return;
        }
        this.lyd.setVisibility(0);
        this.lyd.a(eVar.cTi());
    }
}
