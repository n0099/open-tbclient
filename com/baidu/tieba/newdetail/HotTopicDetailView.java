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
    private static int jVK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String MK;
    private int bLP;
    private ValueAnimator eiM;
    private g fBv;
    private int hHO;
    private int hHP;
    private AppBarLayout.OnOffsetChangedListener hIP;
    private TbTabLayout hka;
    private ImageView iER;
    private int iMF;
    private ClickableSpan iMK;
    private ClickableSpan iML;
    private c iMX;
    private boolean igA;
    private PullRefreshFrameLayout.b igI;
    private PullRefreshFrameLayout.a igJ;
    private Runnable igK;
    private a.InterfaceC0700a jVL;
    private View jVM;
    private boolean jVN;
    private ViewGroup jVO;
    private PullRefreshFrameLayout jVP;
    private HotTopicDetailHeadView jVQ;
    private TextView jVR;
    private View jVS;
    private AppBarLayout jVT;
    private View jVU;
    private HotTopicDetailPkLayout jVV;
    private HotTopicDetailSpecialLayout jVW;
    private CustomViewPager jVX;
    private HotTopicDetailPagerAdapter jVY;
    private View jVZ;
    private RecyclerView.OnScrollListener jWa;
    private e jWb;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0700a interfaceC0700a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.bLP = UtilHelper.getStatusBarHeight();
        this.jVN = false;
        this.MK = "";
        this.jWa = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.cHI();
            }
        };
        this.igA = false;
        this.hIP = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.jVP != null) {
                    HotTopicDetailView.this.jVP.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.Bd(i);
            }
        };
        this.igI = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void n(double d) {
                HotTopicDetailView.this.r(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                HotTopicDetailView.this.eiM = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.eiM.setDuration(150L);
                final int height = HotTopicDetailView.this.jVQ.getHeight();
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
                            if (HotTopicDetailView.this.jVQ != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.eiM.start();
                }
            }
        };
        this.igK = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.igA) {
                    HotTopicDetailView.this.cjf();
                }
            }
        };
        this.igJ = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void bcg() {
                HotTopicDetailView.this.cje();
            }
        };
        this.iMK = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
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
                spannableString.setSpan(HotTopicDetailView.this.iML, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.jVR.setText(spannableString);
                HotTopicDetailView.this.jVR.setHeight(HotTopicDetailView.this.iMF * HotTopicDetailView.this.jVR.getLineHeight());
                int lineCount = HotTopicDetailView.this.jVR.getLineCount() * HotTopicDetailView.this.jVR.getLineHeight();
                if (lineCount > HotTopicDetailView.this.iMF * HotTopicDetailView.this.jVR.getLineHeight()) {
                    HotTopicDetailView.this.jVR.scrollTo(0, lineCount - (HotTopicDetailView.this.iMF * HotTopicDetailView.this.jVR.getLineHeight()));
                }
                HotTopicDetailView.this.jVR.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.iML = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.jVR.setText(HotTopicDetailView.this.MK);
                HotTopicDetailView.this.cpA();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.mPageContext = tbPageContext;
        this.jVL = interfaceC0700a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.jVM = findViewById(R.id.topBgView);
        this.jVM.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.iER = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bf.checkUpIsLogin(HotTopicDetailView.this.iER.getContext())) {
                    HotTopicDetailView.this.jVL.e(HotTopicDetailView.this.jWb);
                }
            }
        });
        this.iER.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.bLP;
        findViewById.setLayoutParams(layoutParams);
        this.jVO = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.jVP = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.jVP.setOnTouchCallback(this.igI);
        this.jVP.setOnPullRefreshListener(this.igJ);
        this.jVP.setFromFrs();
        this.jVP.bcf();
        this.jVQ = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.hHO = l.getDimens(getContext(), R.dimen.tbds600);
        this.hHP = this.hHO;
        this.jVU = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.jVU.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.bLP);
            }
        });
        this.jVR = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.jVV = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.jVW = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.jVW.x(this.mPageContext);
        this.jVS = findViewById(R.id.contentContainer);
        this.jVT = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.jVT.addOnOffsetChangedListener(this.hIP);
        this.jVX = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.jVY = new HotTopicDetailPagerAdapter(getContext());
        this.jVY.setScrollListener(this.jWa);
        this.jVX.setAdapter(this.jVY);
        this.hka = (TbTabLayout) findViewById(R.id.tabLayout);
        this.hka.setSelectedTabTextBlod(true);
        this.hka.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.hka.setSelectedTabIndicatorColor(ao.getColor(R.color.cp_link_tip_a));
        this.hka.setupWithViewPager(this.jVX);
        this.jVZ = findViewById(R.id.dividerShadow);
        this.iMX = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void r(double d) {
        if (this.jVQ != null) {
            int i = (int) (this.hHO + (PullRefreshFrameLayout.eiv * d));
            ViewGroup.LayoutParams layoutParams = this.jVQ.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hHP = layoutParams.height;
                this.jVQ.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jVQ != null && (layoutParams = this.jVQ.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hHP = i;
            this.jVQ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd(int i) {
        int i2 = jVK + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / jVK);
        this.jVM.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        cHI();
        if (f > 0.1d) {
            aq.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            aq.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.jWb == null) {
            SvgManager.baR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.baR().a(this.iER, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.baR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.baR().a(this.iER, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHI() {
        if (this.bLP + this.mNavigationBar.getHeight() >= this.jVS.getY()) {
            ao.setBackgroundColor(this.hka, R.color.cp_bg_line_h);
            if (this.mSkinType == 0) {
                this.jVZ.setVisibility(0);
                return;
            }
            return;
        }
        ao.setBackgroundColor(this.hka, R.color.transparent);
        this.jVZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjf() {
        this.igA = false;
        if (this.jVP != null) {
            this.jVP.bce();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cHB() {
        if (this.fBv == null) {
            this.fBv = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fBv.attachView(this.jVO, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cHC() {
        if (this.fBv != null) {
            this.fBv.dettachView(this.jVO);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bxe() {
        if (this.igA) {
            cjf();
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.igK);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void rC(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.jVL != null) {
                            HotTopicDetailView.this.jVL.AU(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.jVO, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cHD() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.jVO);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void AX(int i) {
        this.jVY.AX(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void AY(int i) {
        this.jVY.AY(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void C(boolean z, int i) {
        this.jVY.C(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void AZ(int i) {
        this.jVY.AZ(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(@NonNull e eVar) {
        this.jWb = eVar;
        if (this.jWb.cpf() != null) {
            this.iMX.setTopicId(this.jWb.cpf().eeI);
            this.iMX.zJ(this.jWb.cpf().dQI);
        }
        h(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.jWb != null) {
            this.jVY.c(this.jWb.cpl());
        }
        this.jVY.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e cHE() {
        return this.jWb;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d Ba(int i) {
        return this.jVY.Ba(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int cHF() {
        return this.jVY.cHF();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void cHG() {
        this.jVY.cHG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cje() {
        com.baidu.adp.lib.f.e.lt().postDelayed(this.igK, 5000L);
        this.igA = true;
        this.jVL.AU(cHF());
    }

    private void bmb() {
        if (!this.jVN) {
            this.jVN = true;
            this.iER.setVisibility(0);
            SvgManager.baR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.baR().a(this.iER, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ao.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            if (this.jVL instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.jVL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpA() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.MK);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.jVR.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.iMK, length - 1, spannableString.length(), 33);
        this.jVR.setText(spannableString);
        this.jVR.setHeight(this.jVR.getLineHeight() * 2);
        this.jVR.scrollTo(0, 0);
        this.jVR.requestLayout();
    }

    private void h(@NonNull e eVar) {
        bmb();
        this.jVQ.setTopicInfo(eVar.cpf());
        a(eVar.cpf());
        g(eVar);
        List<q> cpn = eVar.cpn();
        if (x.isEmpty(cpn)) {
            this.jVW.setVisibility(8);
        } else {
            this.jVW.setData(cpn);
            this.jVW.setVisibility(0);
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
        if (StringUtils.isNull(fVar.iKo)) {
            this.jVR.setVisibility(8);
        } else {
            this.jVR.setText(fVar.iKo);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.jVQ.onChangeSkinType(skinType);
            ao.setViewTextColor(this.jVR, R.color.cp_cont_b, 1);
            ao.setBackgroundColor(this.jVU, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.jVM, R.color.cp_bg_line_h);
            ao.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.jVV.onChangeSkinType(skinType);
            this.hka.setTabTextColors(ao.getColor(R.color.cp_cont_j), ao.getColor(R.color.cp_cont_b));
            this.jVW.onChangeSkinType(skinType);
            this.jVY.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void d(long j, long j2, int i) {
        this.jVV.d(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void F(long j, long j2) {
        this.jVQ.G(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.jVY != null) {
            this.jVY.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.jVY != null) {
            this.jVY.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        cHC();
        cHD();
        if (this.jVY != null) {
            this.jVY.destroy();
        }
        if (this.igA) {
            cjf();
        }
        if (this.eiM != null) {
            this.eiM.cancel();
            this.eiM.removeAllListeners();
            this.eiM.removeAllUpdateListeners();
            this.eiM = null;
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.igK);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void g(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cph() != null) {
            aVar = eVar.cph();
            aVar.iJP = 3;
        } else if (eVar.cpi() != null) {
            aVar = eVar.cpi();
            aVar.iJP = 2;
        } else if (eVar.cpj() != null) {
            aVar = eVar.cpj();
            aVar.iJP = 1;
        }
        this.jVQ.setBlessInfo(aVar);
        if (eVar.cpg() == null) {
            this.jVV.setVisibility(8);
            return;
        }
        this.jVV.setVisibility(0);
        this.jVV.a(eVar.cpg());
    }
}
