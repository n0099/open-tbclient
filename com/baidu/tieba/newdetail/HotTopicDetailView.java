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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
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
    private static int jVI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String MK;
    private int bLP;
    private ValueAnimator eiM;
    private g fBv;
    private int hHO;
    private int hHP;
    private AppBarLayout.OnOffsetChangedListener hIP;
    private TbTabLayout hka;
    private ImageView iEP;
    private int iMD;
    private ClickableSpan iMI;
    private ClickableSpan iMJ;
    private c iMV;
    private PullRefreshFrameLayout.b igG;
    private PullRefreshFrameLayout.a igH;
    private Runnable igI;
    private boolean igy;
    private a.InterfaceC0700a jVJ;
    private View jVK;
    private boolean jVL;
    private ViewGroup jVM;
    private PullRefreshFrameLayout jVN;
    private HotTopicDetailHeadView jVO;
    private TextView jVP;
    private View jVQ;
    private AppBarLayout jVR;
    private View jVS;
    private HotTopicDetailPkLayout jVT;
    private HotTopicDetailSpecialLayout jVU;
    private CustomViewPager jVV;
    private HotTopicDetailPagerAdapter jVW;
    private View jVX;
    private RecyclerView.OnScrollListener jVY;
    private e jVZ;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0700a interfaceC0700a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.bLP = UtilHelper.getStatusBarHeight();
        this.jVL = false;
        this.MK = "";
        this.jVY = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.cHI();
            }
        };
        this.igy = false;
        this.hIP = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.jVN != null) {
                    HotTopicDetailView.this.jVN.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.Bd(i);
            }
        };
        this.igG = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void n(double d) {
                HotTopicDetailView.this.r(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                HotTopicDetailView.this.eiM = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.eiM.setDuration(150L);
                final int height = HotTopicDetailView.this.jVO.getHeight();
                HotTopicDetailView.this.eiM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.eiM.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bch() {
                final int i = HotTopicDetailView.this.hHP - HotTopicDetailView.this.hHO;
                if (i > 0) {
                    HotTopicDetailView.this.eiM = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.eiM.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.hHP;
                    HotTopicDetailView.this.eiM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.jVO != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.eiM.start();
                }
            }
        };
        this.igI = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.igy) {
                    HotTopicDetailView.this.cjf();
                }
            }
        };
        this.igH = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void bcg() {
                HotTopicDetailView.this.cje();
            }
        };
        this.iMI = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicDetailView.this.MK);
                if (HotTopicDetailView.this.MK.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicDetailView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicDetailView.this.iMJ, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.jVP.setText(spannableString);
                HotTopicDetailView.this.jVP.setHeight(HotTopicDetailView.this.iMD * HotTopicDetailView.this.jVP.getLineHeight());
                int lineCount = HotTopicDetailView.this.jVP.getLineCount() * HotTopicDetailView.this.jVP.getLineHeight();
                if (lineCount > HotTopicDetailView.this.iMD * HotTopicDetailView.this.jVP.getLineHeight()) {
                    HotTopicDetailView.this.jVP.scrollTo(0, lineCount - (HotTopicDetailView.this.iMD * HotTopicDetailView.this.jVP.getLineHeight()));
                }
                HotTopicDetailView.this.jVP.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.iMJ = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.jVP.setText(HotTopicDetailView.this.MK);
                HotTopicDetailView.this.cpA();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.mPageContext = tbPageContext;
        this.jVJ = interfaceC0700a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.jVK = findViewById(R.id.topBgView);
        this.jVK.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.iEP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bf.checkUpIsLogin(HotTopicDetailView.this.iEP.getContext())) {
                    HotTopicDetailView.this.jVJ.e(HotTopicDetailView.this.jVZ);
                }
            }
        });
        this.iEP.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.bLP;
        findViewById.setLayoutParams(layoutParams);
        this.jVM = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.jVN = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.jVN.setOnTouchCallback(this.igG);
        this.jVN.setOnPullRefreshListener(this.igH);
        this.jVN.setFromFrs();
        this.jVN.bcf();
        this.jVO = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.hHO = l.getDimens(getContext(), R.dimen.tbds600);
        this.hHP = this.hHO;
        this.jVS = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.jVS.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.bLP);
            }
        });
        this.jVP = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.jVT = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.jVU = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.jVU.x(this.mPageContext);
        this.jVQ = findViewById(R.id.contentContainer);
        this.jVR = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.jVR.addOnOffsetChangedListener(this.hIP);
        this.jVV = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.jVW = new HotTopicDetailPagerAdapter(getContext());
        this.jVW.setScrollListener(this.jVY);
        this.jVV.setAdapter(this.jVW);
        this.hka = (TbTabLayout) findViewById(R.id.tabLayout);
        this.hka.setSelectedTabTextBlod(true);
        this.hka.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.hka.setSelectedTabIndicatorColor(ao.getColor(R.color.cp_link_tip_a));
        this.hka.setupWithViewPager(this.jVV);
        this.jVX = findViewById(R.id.dividerShadow);
        this.iMV = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void r(double d) {
        if (this.jVO != null) {
            int i = (int) (this.hHO + (PullRefreshFrameLayout.eiv * d));
            ViewGroup.LayoutParams layoutParams = this.jVO.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hHP = layoutParams.height;
                this.jVO.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jVO != null && (layoutParams = this.jVO.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hHP = i;
            this.jVO.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd(int i) {
        int i2 = jVI + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / jVI);
        this.jVK.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        cHI();
        if (f > 0.1d) {
            aq.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            aq.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.jVZ == null) {
            SvgManager.baR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.baR().a(this.iEP, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.baR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.baR().a(this.iEP, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHI() {
        if (this.bLP + this.mNavigationBar.getHeight() >= this.jVQ.getY()) {
            ao.setBackgroundColor(this.hka, R.color.cp_bg_line_h);
            if (this.mSkinType == 0) {
                this.jVX.setVisibility(0);
                return;
            }
            return;
        }
        ao.setBackgroundColor(this.hka, R.color.transparent);
        this.jVX.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjf() {
        this.igy = false;
        if (this.jVN != null) {
            this.jVN.bce();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cHB() {
        if (this.fBv == null) {
            this.fBv = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fBv.attachView(this.jVM, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cHC() {
        if (this.fBv != null) {
            this.fBv.dettachView(this.jVM);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bxe() {
        if (this.igy) {
            cjf();
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.igI);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void rC(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.jVJ != null) {
                            HotTopicDetailView.this.jVJ.AU(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.jVM, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cHD() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.jVM);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void AX(int i) {
        this.jVW.AX(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void AY(int i) {
        this.jVW.AY(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void C(boolean z, int i) {
        this.jVW.C(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void AZ(int i) {
        this.jVW.AZ(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(@NonNull e eVar) {
        this.jVZ = eVar;
        if (this.jVZ.cpf() != null) {
            this.iMV.setTopicId(this.jVZ.cpf().eeI);
            this.iMV.zJ(this.jVZ.cpf().dQI);
        }
        h(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.jVZ != null) {
            this.jVW.c(this.jVZ.cpl());
        }
        this.jVW.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e cHE() {
        return this.jVZ;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d Ba(int i) {
        return this.jVW.Ba(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int cHF() {
        return this.jVW.cHF();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cHG() {
        this.jVW.cHG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cje() {
        com.baidu.adp.lib.f.e.lt().postDelayed(this.igI, 5000L);
        this.igy = true;
        this.jVJ.AU(cHF());
    }

    private void bmb() {
        if (!this.jVL) {
            this.jVL = true;
            this.iEP.setVisibility(0);
            SvgManager.baR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.baR().a(this.iEP, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ao.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            if (this.jVJ instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.jVJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpA() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.MK);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.jVP.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.iMI, length - 1, spannableString.length(), 33);
        this.jVP.setText(spannableString);
        this.jVP.setHeight(this.jVP.getLineHeight() * 2);
        this.jVP.scrollTo(0, 0);
        this.jVP.requestLayout();
    }

    private void h(@NonNull e eVar) {
        bmb();
        this.jVO.setTopicInfo(eVar.cpf());
        a(eVar.cpf());
        g(eVar);
        List<q> cpn = eVar.cpn();
        if (x.isEmpty(cpn)) {
            this.jVU.setVisibility(8);
        } else {
            this.jVU.setData(cpn);
            this.jVU.setVisibility(0);
        }
        if (eVar.cpf() != null) {
            String str = eVar.cpf().dQI;
            if (ae.getTextLengthWithEmoji(str) > 15) {
                str = ae.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.iKm)) {
            this.jVP.setVisibility(8);
        } else {
            this.jVP.setText(fVar.iKm);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.jVO.onChangeSkinType(skinType);
            ao.setViewTextColor(this.jVP, R.color.cp_cont_b, 1);
            ao.setBackgroundColor(this.jVS, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.jVK, R.color.cp_bg_line_h);
            ao.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.jVT.onChangeSkinType(skinType);
            this.hka.setTabTextColors(ao.getColor(R.color.cp_cont_j), ao.getColor(R.color.cp_cont_b));
            this.jVU.onChangeSkinType(skinType);
            this.jVW.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void d(long j, long j2, int i) {
        this.jVT.d(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void F(long j, long j2) {
        this.jVO.G(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.jVW != null) {
            this.jVW.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.jVW != null) {
            this.jVW.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        cHC();
        cHD();
        if (this.jVW != null) {
            this.jVW.destroy();
        }
        if (this.igy) {
            cjf();
        }
        if (this.eiM != null) {
            this.eiM.cancel();
            this.eiM.removeAllListeners();
            this.eiM.removeAllUpdateListeners();
            this.eiM = null;
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.igI);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void g(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cph() != null) {
            aVar = eVar.cph();
            aVar.iJN = 3;
        } else if (eVar.cpi() != null) {
            aVar = eVar.cpi();
            aVar.iJN = 2;
        } else if (eVar.cpj() != null) {
            aVar = eVar.cpj();
            aVar.iJN = 1;
        }
        this.jVO.setBlessInfo(aVar);
        if (eVar.cpg() == null) {
            this.jVT.setVisibility(8);
            return;
        }
        this.jVT.setVisibility(0);
        this.jVT.a(eVar.cpg());
    }
}
