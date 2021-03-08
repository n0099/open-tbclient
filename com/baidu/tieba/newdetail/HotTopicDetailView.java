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
/* loaded from: classes7.dex */
public class HotTopicDetailView extends RelativeLayout implements a.b {
    private static int lAj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String Qu;
    private int cDn;
    private ValueAnimator fkG;
    private g gLk;
    private TbTabLayout ggz;
    private boolean jMY;
    private PullRefreshFrameLayout.d jNg;
    private PullRefreshFrameLayout.c jNh;
    private Runnable jNi;
    private ImageView jVU;
    private int jkv;
    private int jkw;
    private AppBarLayout.OnOffsetChangedListener jlw;
    private int kzd;
    private ClickableSpan kzi;
    private ClickableSpan kzj;
    private c kzv;
    private e lAA;
    private a.InterfaceC0808a lAk;
    private View lAl;
    private boolean lAm;
    private ViewGroup lAn;
    private PullRefreshFrameLayout lAo;
    private HotTopicDetailHeadView lAp;
    private TextView lAq;
    private View lAr;
    private AppBarLayout lAs;
    private View lAt;
    private HotTopicDetailPkLayout lAu;
    private HotTopicDetailSpecialLayout lAv;
    private CustomViewPager lAw;
    private HotTopicDetailPagerAdapter lAx;
    private View lAy;
    private RecyclerView.OnScrollListener lAz;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0808a interfaceC0808a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.cDn = UtilHelper.getStatusBarHeight();
        this.lAm = false;
        this.Qu = "";
        this.lAz = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.diq();
            }
        };
        this.jMY = false;
        this.jlw = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.lAo != null) {
                    HotTopicDetailView.this.lAo.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.Fd(i);
            }
        };
        this.jNg = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void q(double d) {
                HotTopicDetailView.this.v(d);
                HotTopicDetailView.this.lAo.bun();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                HotTopicDetailView.this.fkG = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.fkG.setDuration(150L);
                final int height = HotTopicDetailView.this.lAp.getHeight();
                HotTopicDetailView.this.fkG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.fkG.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void buq() {
                final int i = HotTopicDetailView.this.jkw - HotTopicDetailView.this.jkv;
                if (i > 0) {
                    HotTopicDetailView.this.fkG = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.fkG.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.jkw;
                    HotTopicDetailView.this.fkG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.lAp != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.fkG.start();
                }
            }
        };
        this.jNi = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.jMY) {
                    HotTopicDetailView.this.cLO();
                }
            }
        };
        this.jNh = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bup() {
                HotTopicDetailView.this.cLN();
            }
        };
        this.kzi = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.Qu);
                if (HotTopicDetailView.this.Qu.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicDetailView.this.kzj, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.lAq.setText(spannableString);
                HotTopicDetailView.this.lAq.setHeight(HotTopicDetailView.this.kzd * HotTopicDetailView.this.lAq.getLineHeight());
                int lineCount = HotTopicDetailView.this.lAq.getLineCount() * HotTopicDetailView.this.lAq.getLineHeight();
                if (lineCount > HotTopicDetailView.this.kzd * HotTopicDetailView.this.lAq.getLineHeight()) {
                    HotTopicDetailView.this.lAq.scrollTo(0, lineCount - (HotTopicDetailView.this.kzd * HotTopicDetailView.this.lAq.getLineHeight()));
                }
                HotTopicDetailView.this.lAq.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kzj = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.lAq.setText(HotTopicDetailView.this.Qu);
                HotTopicDetailView.this.cTO();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.mPageContext = tbPageContext;
        this.lAk = interfaceC0808a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.lAl = findViewById(R.id.topBgView);
        this.lAl.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.jVU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bh.checkUpIsLogin(HotTopicDetailView.this.jVU.getContext())) {
                    HotTopicDetailView.this.lAk.d(HotTopicDetailView.this.lAA);
                }
            }
        });
        this.jVU.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.cDn;
        findViewById.setLayoutParams(layoutParams);
        this.lAn = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.lAo = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lAo.setOnTouchCallback(this.jNg);
        this.lAo.setOnPullRefreshListener(this.jNh);
        this.lAo.setFromFrs();
        this.lAo.bum();
        this.lAp = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.jkv = l.getDimens(getContext(), R.dimen.tbds600);
        this.jkw = this.jkv;
        this.lAt = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.lAt.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.cDn);
            }
        });
        this.lAq = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.lAu = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.lAv = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.lAv.y(this.mPageContext);
        this.lAr = findViewById(R.id.contentContainer);
        this.lAs = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.lAs.addOnOffsetChangedListener(this.jlw);
        this.lAw = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.lAx = new HotTopicDetailPagerAdapter(getContext());
        this.lAx.setScrollListener(this.lAz);
        this.lAw.setAdapter(this.lAx);
        this.ggz = (TbTabLayout) findViewById(R.id.tabLayout);
        this.ggz.setSelectedTabTextBlod(true);
        this.ggz.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.ggz.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
        this.ggz.setupWithViewPager(this.lAw);
        this.lAy = findViewById(R.id.dividerShadow);
        this.kzv = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void v(double d) {
        if (this.lAp != null) {
            int i = (int) (this.jkv + (PullRefreshFrameLayout.fkl * d));
            ViewGroup.LayoutParams layoutParams = this.lAp.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jkw = layoutParams.height;
                this.lAp.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.lAp != null && (layoutParams = this.lAp.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jkw = i;
            this.lAp.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd(int i) {
        int i2 = lAj + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / lAj);
        this.lAl.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        diq();
        if (f > 0.1d) {
            as.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            as.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.lAA == null) {
            SvgManager.bsU().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsU().a(this.jVU, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.bsU().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsU().a(this.jVU, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diq() {
        if (this.cDn + this.mNavigationBar.getHeight() >= this.lAr.getY()) {
            ap.setBackgroundColor(this.ggz, R.color.CAM_X0207);
            if (this.mSkinType == 0) {
                this.lAy.setVisibility(0);
                return;
            }
            return;
        }
        ap.setBackgroundColor(this.ggz, R.color.transparent);
        this.lAy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLO() {
        this.jMY = false;
        if (this.lAo != null) {
            this.lAo.bul();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dij() {
        if (this.gLk == null) {
            this.gLk = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            this.gLk.setBackground(ap.getColor(R.color.CAM_X0201));
        }
        this.gLk.attachView(this.lAn, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dik() {
        if (this.gLk != null) {
            this.gLk.dettachView(this.lAn);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bRO() {
        if (this.jMY) {
            cLO();
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jNi);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void uo(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.lAk != null) {
                            HotTopicDetailView.this.lAk.EU(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lAn, false);
            this.mRefreshView.setBackGroundColor(R.color.CAM_X0201);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dil() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lAn);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void EX(int i) {
        this.lAx.EX(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void EY(int i) {
        this.lAx.EY(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void E(boolean z, int i) {
        this.lAx.E(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void EZ(int i) {
        this.lAx.EZ(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(@NonNull e eVar) {
        this.lAA = eVar;
        if (this.lAA.cTv() != null) {
            this.kzv.setTopicId(this.lAA.cTv().ffX);
            this.kzv.Dd(this.lAA.cTv().eQU);
        }
        g(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.lAA != null) {
            this.lAx.c(this.lAA.cTB());
        }
        this.lAx.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e dim() {
        return this.lAA;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d Fa(int i) {
        return this.lAx.Fa(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int din() {
        return this.lAx.din();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dio() {
        this.lAx.dio();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLN() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.jNi, 5000L);
        this.jMY = true;
        this.lAk.EU(din());
    }

    private void bEP() {
        if (!this.lAm) {
            this.lAm = true;
            this.jVU.setVisibility(0);
            SvgManager.bsU().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsU().a(this.jVU, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.lAk instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lAk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTO() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Qu);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.lAq.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.kzi, length - 1, spannableString.length(), 33);
        this.lAq.setText(spannableString);
        this.lAq.setHeight(this.lAq.getLineHeight() * 2);
        this.lAq.scrollTo(0, 0);
        this.lAq.requestLayout();
    }

    private void g(@NonNull e eVar) {
        bEP();
        this.lAp.setTopicInfo(eVar.cTv());
        a(eVar.cTv());
        f(eVar);
        List<n> cTD = eVar.cTD();
        if (y.isEmpty(cTD)) {
            this.lAv.setVisibility(8);
        } else {
            this.lAv.setData(cTD);
            this.lAv.setVisibility(0);
        }
        if (eVar.cTv() != null) {
            String str = eVar.cTv().eQU;
            if (ag.getTextLengthWithEmoji(str) > 15) {
                str = ag.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.kwM)) {
            this.lAq.setVisibility(8);
        } else {
            this.lAq.setText(fVar.kwM);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.lAp.onChangeSkinType(skinType);
            ap.setViewTextColor(this.lAq, R.color.CAM_X0105, 1);
            ap.setBackgroundColor(this.lAt, R.color.CAM_X0201);
            ap.setBackgroundColor(this.lAl, R.color.CAM_X0207);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.gLk != null) {
                this.gLk.setBackground(ap.getColor(R.color.CAM_X0201));
            }
            this.lAu.onChangeSkinType(skinType);
            this.ggz.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
            this.lAv.onChangeSkinType(skinType);
            this.lAx.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void d(long j, long j2, int i) {
        this.lAu.d(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void K(long j, long j2) {
        this.lAp.L(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.lAx != null) {
            this.lAx.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.lAx != null) {
            this.lAx.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        dik();
        dil();
        if (this.lAx != null) {
            this.lAx.destroy();
        }
        if (this.jMY) {
            cLO();
        }
        if (this.fkG != null) {
            this.fkG.cancel();
            this.fkG.removeAllListeners();
            this.fkG.removeAllUpdateListeners();
            this.fkG = null;
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jNi);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cTx() != null) {
            aVar = eVar.cTx();
            aVar.kwn = 3;
        } else if (eVar.cTy() != null) {
            aVar = eVar.cTy();
            aVar.kwn = 2;
        } else if (eVar.cTz() != null) {
            aVar = eVar.cTz();
            aVar.kwn = 1;
        }
        this.lAp.setBlessInfo(aVar);
        if (eVar.cTw() == null) {
            this.lAu.setVisibility(8);
            return;
        }
        this.lAu.setVisibility(0);
        this.lAu.a(eVar.cTw());
    }
}
