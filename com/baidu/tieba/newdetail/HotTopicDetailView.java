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
    private static int lyg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String OV;
    private int cBN;
    private ValueAnimator fjh;
    private g gJB;
    private TbTabLayout geW;
    private boolean jLp;
    private PullRefreshFrameLayout.d jLx;
    private PullRefreshFrameLayout.c jLy;
    private Runnable jLz;
    private ImageView jTD;
    private int jiM;
    private int jiN;
    private AppBarLayout.OnOffsetChangedListener jjN;
    private int kxb;
    private ClickableSpan kxg;
    private ClickableSpan kxh;
    private c kxt;
    private a.InterfaceC0802a lyh;
    private View lyi;
    private boolean lyj;
    private ViewGroup lyk;
    private PullRefreshFrameLayout lyl;
    private HotTopicDetailHeadView lym;
    private TextView lyn;
    private View lyp;
    private AppBarLayout lyq;
    private View lyr;
    private HotTopicDetailPkLayout lys;
    private HotTopicDetailSpecialLayout lyt;
    private CustomViewPager lyu;
    private HotTopicDetailPagerAdapter lyv;
    private View lyw;
    private RecyclerView.OnScrollListener lyx;
    private e lyy;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0802a interfaceC0802a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cBN = UtilHelper.getStatusBarHeight();
        this.lyj = false;
        this.OV = "";
        this.lyx = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.dih();
            }
        };
        this.jLp = false;
        this.jjN = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.lyl != null) {
                    HotTopicDetailView.this.lyl.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.Fa(i);
            }
        };
        this.jLx = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void q(double d) {
                HotTopicDetailView.this.v(d);
                HotTopicDetailView.this.lyl.buk();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                HotTopicDetailView.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.fjh.setDuration(150L);
                final int height = HotTopicDetailView.this.lym.getHeight();
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
                final int i = HotTopicDetailView.this.jiN - HotTopicDetailView.this.jiM;
                if (i > 0) {
                    HotTopicDetailView.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.fjh.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.jiN;
                    HotTopicDetailView.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.lym != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.fjh.start();
                }
            }
        };
        this.jLz = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.jLp) {
                    HotTopicDetailView.this.cLI();
                }
            }
        };
        this.jLy = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bum() {
                HotTopicDetailView.this.cLH();
            }
        };
        this.kxg = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
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
                spannableString.setSpan(HotTopicDetailView.this.kxh, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.lyn.setText(spannableString);
                HotTopicDetailView.this.lyn.setHeight(HotTopicDetailView.this.kxb * HotTopicDetailView.this.lyn.getLineHeight());
                int lineCount = HotTopicDetailView.this.lyn.getLineCount() * HotTopicDetailView.this.lyn.getLineHeight();
                if (lineCount > HotTopicDetailView.this.kxb * HotTopicDetailView.this.lyn.getLineHeight()) {
                    HotTopicDetailView.this.lyn.scrollTo(0, lineCount - (HotTopicDetailView.this.kxb * HotTopicDetailView.this.lyn.getLineHeight()));
                }
                HotTopicDetailView.this.lyn.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kxh = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.lyn.setText(HotTopicDetailView.this.OV);
                HotTopicDetailView.this.cTH();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.mPageContext = tbPageContext;
        this.lyh = interfaceC0802a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.lyi = findViewById(R.id.topBgView);
        this.lyi.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.jTD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bh.checkUpIsLogin(HotTopicDetailView.this.jTD.getContext())) {
                    HotTopicDetailView.this.lyh.d(HotTopicDetailView.this.lyy);
                }
            }
        });
        this.jTD.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.cBN;
        findViewById.setLayoutParams(layoutParams);
        this.lyk = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.lyl = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lyl.setOnTouchCallback(this.jLx);
        this.lyl.setOnPullRefreshListener(this.jLy);
        this.lyl.setFromFrs();
        this.lyl.buj();
        this.lym = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.jiM = l.getDimens(getContext(), R.dimen.tbds600);
        this.jiN = this.jiM;
        this.lyr = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.lyr.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.cBN);
            }
        });
        this.lyn = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.lys = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.lyt = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.lyt.y(this.mPageContext);
        this.lyp = findViewById(R.id.contentContainer);
        this.lyq = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.lyq.addOnOffsetChangedListener(this.jjN);
        this.lyu = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.lyv = new HotTopicDetailPagerAdapter(getContext());
        this.lyv.setScrollListener(this.lyx);
        this.lyu.setAdapter(this.lyv);
        this.geW = (TbTabLayout) findViewById(R.id.tabLayout);
        this.geW.setSelectedTabTextBlod(true);
        this.geW.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.geW.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
        this.geW.setupWithViewPager(this.lyu);
        this.lyw = findViewById(R.id.dividerShadow);
        this.kxt = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void v(double d) {
        if (this.lym != null) {
            int i = (int) (this.jiM + (PullRefreshFrameLayout.fiM * d));
            ViewGroup.LayoutParams layoutParams = this.lym.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jiN = layoutParams.height;
                this.lym.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.lym != null && (layoutParams = this.lym.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jiN = i;
            this.lym.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fa(int i) {
        int i2 = lyg + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / lyg);
        this.lyi.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        dih();
        if (f > 0.1d) {
            as.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            as.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.lyy == null) {
            SvgManager.bsR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.jTD, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.bsR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsR().a(this.jTD, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dih() {
        if (this.cBN + this.mNavigationBar.getHeight() >= this.lyp.getY()) {
            ap.setBackgroundColor(this.geW, R.color.CAM_X0207);
            if (this.mSkinType == 0) {
                this.lyw.setVisibility(0);
                return;
            }
            return;
        }
        ap.setBackgroundColor(this.geW, R.color.transparent);
        this.lyw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLI() {
        this.jLp = false;
        if (this.lyl != null) {
            this.lyl.bui();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dia() {
        if (this.gJB == null) {
            this.gJB = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            this.gJB.setBackground(ap.getColor(R.color.CAM_X0201));
        }
        this.gJB.attachView(this.lyk, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dib() {
        if (this.gJB != null) {
            this.gJB.dettachView(this.lyk);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bRI() {
        if (this.jLp) {
            cLI();
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jLz);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void uo(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.lyh != null) {
                            HotTopicDetailView.this.lyh.ER(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lyk, false);
            this.mRefreshView.setBackGroundColor(R.color.CAM_X0201);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dic() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lyk);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void EU(int i) {
        this.lyv.EU(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void EV(int i) {
        this.lyv.EV(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void E(boolean z, int i) {
        this.lyv.E(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void EW(int i) {
        this.lyv.EW(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(@NonNull e eVar) {
        this.lyy = eVar;
        if (this.lyy.cTo() != null) {
            this.kxt.setTopicId(this.lyy.cTo().fey);
            this.kxt.CW(this.lyy.cTo().ePt);
        }
        g(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.lyy != null) {
            this.lyv.c(this.lyy.cTu());
        }
        this.lyv.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e did() {
        return this.lyy;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d EX(int i) {
        return this.lyv.EX(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int die() {
        return this.lyv.die();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dif() {
        this.lyv.dif();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLH() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.jLz, 5000L);
        this.jLp = true;
        this.lyh.ER(die());
    }

    private void bEL() {
        if (!this.lyj) {
            this.lyj = true;
            this.jTD.setVisibility(0);
            SvgManager.bsR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.jTD, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.lyh instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lyh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTH() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OV);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.lyn.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.kxg, length - 1, spannableString.length(), 33);
        this.lyn.setText(spannableString);
        this.lyn.setHeight(this.lyn.getLineHeight() * 2);
        this.lyn.scrollTo(0, 0);
        this.lyn.requestLayout();
    }

    private void g(@NonNull e eVar) {
        bEL();
        this.lym.setTopicInfo(eVar.cTo());
        a(eVar.cTo());
        f(eVar);
        List<n> cTw = eVar.cTw();
        if (y.isEmpty(cTw)) {
            this.lyt.setVisibility(8);
        } else {
            this.lyt.setData(cTw);
            this.lyt.setVisibility(0);
        }
        if (eVar.cTo() != null) {
            String str = eVar.cTo().ePt;
            if (ag.getTextLengthWithEmoji(str) > 15) {
                str = ag.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.kuK)) {
            this.lyn.setVisibility(8);
        } else {
            this.lyn.setText(fVar.kuK);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.lym.onChangeSkinType(skinType);
            ap.setViewTextColor(this.lyn, R.color.CAM_X0105, 1);
            ap.setBackgroundColor(this.lyr, R.color.CAM_X0201);
            ap.setBackgroundColor(this.lyi, R.color.CAM_X0207);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.gJB != null) {
                this.gJB.setBackground(ap.getColor(R.color.CAM_X0201));
            }
            this.lys.onChangeSkinType(skinType);
            this.geW.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
            this.lyt.onChangeSkinType(skinType);
            this.lyv.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(long j, long j2, int i) {
        this.lys.e(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void K(long j, long j2) {
        this.lym.L(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.lyv != null) {
            this.lyv.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.lyv != null) {
            this.lyv.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        dib();
        dic();
        if (this.lyv != null) {
            this.lyv.destroy();
        }
        if (this.jLp) {
            cLI();
        }
        if (this.fjh != null) {
            this.fjh.cancel();
            this.fjh.removeAllListeners();
            this.fjh.removeAllUpdateListeners();
            this.fjh = null;
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jLz);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cTq() != null) {
            aVar = eVar.cTq();
            aVar.kul = 3;
        } else if (eVar.cTr() != null) {
            aVar = eVar.cTr();
            aVar.kul = 2;
        } else if (eVar.cTs() != null) {
            aVar = eVar.cTs();
            aVar.kul = 1;
        }
        this.lym.setBlessInfo(aVar);
        if (eVar.cTp() == null) {
            this.lys.setVisibility(8);
            return;
        }
        this.lys.setVisibility(0);
        this.lys.a(eVar.cTp());
    }
}
