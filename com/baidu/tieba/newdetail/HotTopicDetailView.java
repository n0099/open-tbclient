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
    private static int kVv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private String Ob;
    private int coc;
    private ValueAnimator ePu;
    private TbTabLayout fJT;
    private g gmB;
    private int iDH;
    private int iDI;
    private AppBarLayout.OnOffsetChangedListener iEI;
    private ImageView jEa;
    private int jLM;
    private ClickableSpan jLR;
    private ClickableSpan jLS;
    private c jMe;
    private PullRefreshFrameLayout.d jdA;
    private PullRefreshFrameLayout.c jdB;
    private Runnable jdC;
    private boolean jds;
    private PullRefreshFrameLayout kVA;
    private HotTopicDetailHeadView kVB;
    private TextView kVC;
    private View kVD;
    private AppBarLayout kVE;
    private View kVF;
    private HotTopicDetailPkLayout kVG;
    private HotTopicDetailSpecialLayout kVH;
    private CustomViewPager kVI;
    private HotTopicDetailPagerAdapter kVJ;
    private View kVK;
    private RecyclerView.OnScrollListener kVL;
    private e kVM;
    private a.InterfaceC0781a kVw;
    private View kVx;
    private boolean kVy;
    private ViewGroup kVz;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicDetailView(TbPageContext<?> tbPageContext, a.InterfaceC0781a interfaceC0781a, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.coc = UtilHelper.getStatusBarHeight();
        this.kVy = false;
        this.Ob = "";
        this.kVL = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HotTopicDetailView.this.dcU();
            }
        };
        this.jds = false;
        this.iEI = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.5
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicDetailView.this.kVA != null) {
                    HotTopicDetailView.this.kVA.setInterceptScrollDown(i == 0);
                }
                HotTopicDetailView.this.EW(i);
            }
        };
        this.jdA = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void x(double d) {
                HotTopicDetailView.this.B(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicDetailView.this.ePu = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicDetailView.this.ePu.setDuration(150L);
                final int height = HotTopicDetailView.this.kVB.getHeight();
                HotTopicDetailView.this.ePu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicDetailView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicDetailView.this.ePu.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bqc() {
                final int i = HotTopicDetailView.this.iDI - HotTopicDetailView.this.iDH;
                if (i > 0) {
                    HotTopicDetailView.this.ePu = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicDetailView.this.ePu.setDuration(300L);
                    final int i2 = HotTopicDetailView.this.iDI;
                    HotTopicDetailView.this.ePu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.6.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicDetailView.this.kVB != null && i2 > 0) {
                                HotTopicDetailView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicDetailView.this.ePu.start();
                }
            }
        };
        this.jdC = new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.8
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailView.this.jds) {
                    HotTopicDetailView.this.cDG();
                }
            }
        };
        this.jdB = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bqb() {
                HotTopicDetailView.this.cDF();
            }
        };
        this.jLR = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.10
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
                spannableString.setSpan(HotTopicDetailView.this.jLS, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicDetailView.this.kVC.setText(spannableString);
                HotTopicDetailView.this.kVC.setHeight(HotTopicDetailView.this.jLM * HotTopicDetailView.this.kVC.getLineHeight());
                int lineCount = HotTopicDetailView.this.kVC.getLineCount() * HotTopicDetailView.this.kVC.getLineHeight();
                if (lineCount > HotTopicDetailView.this.jLM * HotTopicDetailView.this.kVC.getLineHeight()) {
                    HotTopicDetailView.this.kVC.scrollTo(0, lineCount - (HotTopicDetailView.this.jLM * HotTopicDetailView.this.kVC.getLineHeight()));
                }
                HotTopicDetailView.this.kVC.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jLS = new ClickableSpan() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicDetailView.this.kVC.setText(HotTopicDetailView.this.Ob);
                HotTopicDetailView.this.cKQ();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicDetailView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.mPageContext = tbPageContext;
        this.kVw = interfaceC0781a;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
        this.kVx = findViewById(R.id.topBgView);
        this.kVx.setAlpha(0.0f);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.getCenterText().setAlpha(0.0f);
        this.jEa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    HotTopicDetailView.this.mPageContext.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                if (ShareSwitch.isOn() || bg.checkUpIsLogin(HotTopicDetailView.this.jEa.getContext())) {
                    HotTopicDetailView.this.kVw.e(HotTopicDetailView.this.kVM);
                }
            }
        });
        this.jEa.setVisibility(4);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = this.coc;
        findViewById.setLayoutParams(layoutParams);
        this.kVz = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.kVA = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.kVA.setOnTouchCallback(this.jdA);
        this.kVA.setOnPullRefreshListener(this.jdB);
        this.kVA.setFromFrs();
        this.kVA.bpZ();
        this.kVB = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
        this.iDH = l.getDimens(getContext(), R.dimen.tbds600);
        this.iDI = this.iDH;
        this.kVF = findViewById(R.id.headerContainerLayout);
        this.mNavigationBar.post(new Runnable() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.4
            @Override // java.lang.Runnable
            public void run() {
                HotTopicDetailView.this.kVF.setMinimumHeight(HotTopicDetailView.this.mNavigationBar.getHeight() + HotTopicDetailView.this.coc);
            }
        });
        this.kVC = (TextView) findViewById(R.id.hotTopicInfoAbstract);
        this.kVG = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
        this.kVH = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
        this.kVH.x(this.mPageContext);
        this.kVD = findViewById(R.id.contentContainer);
        this.kVE = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.kVE.addOnOffsetChangedListener(this.iEI);
        this.kVI = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
        this.kVJ = new HotTopicDetailPagerAdapter(getContext());
        this.kVJ.setScrollListener(this.kVL);
        this.kVI.setAdapter(this.kVJ);
        this.fJT = (TbTabLayout) findViewById(R.id.tabLayout);
        this.fJT.setSelectedTabTextBlod(true);
        this.fJT.setTabTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
        this.fJT.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_link_tip_a));
        this.fJT.setupWithViewPager(this.kVI);
        this.kVK = findViewById(R.id.dividerShadow);
        this.jMe = new c((OvalActionButton) findViewById(R.id.topic_post_forum_button), this.mPageContext);
    }

    protected void B(double d) {
        if (this.kVB != null) {
            int i = (int) (this.iDH + (PullRefreshFrameLayout.ePb * d));
            ViewGroup.LayoutParams layoutParams = this.kVB.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iDI = layoutParams.height;
                this.kVB.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.kVB != null && (layoutParams = this.kVB.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iDI = i;
            this.kVB.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EW(int i) {
        int i2 = kVv + i;
        if (i2 < 0) {
            i2 = 0;
        }
        float f = 1.0f - ((i2 * 1.0f) / kVv);
        this.kVx.setAlpha(f);
        this.mNavigationBar.getCenterText().setAlpha(f);
        dcU();
        if (f > 0.1d) {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), true);
        } else {
            ar.setStatusBarDarkIcon(this.mPageContext.getPageActivity().getWindow(), false);
        }
        if ((f > 0.3d && this.mSkinType == 0) || this.kVM == null) {
            SvgManager.boN().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.boN().a(this.jEa, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.boN().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.boN().a(this.jEa, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcU() {
        if (this.coc + this.mNavigationBar.getHeight() >= this.kVD.getY()) {
            ap.setBackgroundColor(this.fJT, R.color.cp_bg_line_h);
            if (this.mSkinType == 0) {
                this.kVK.setVisibility(0);
                return;
            }
            return;
        }
        ap.setBackgroundColor(this.fJT, R.color.transparent);
        this.kVK.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDG() {
        this.jds = false;
        if (this.kVA != null) {
            this.kVA.bpY();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dcN() {
        if (this.gmB == null) {
            this.gmB = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gmB.attachView(this.kVz, false);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dcO() {
        if (this.gmB != null) {
            this.gmB.dettachView(this.kVz);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void bMH() {
        if (this.jds) {
            cDG();
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jdC);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void tq(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.HotTopicDetailView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicDetailView.this.kVw != null) {
                            HotTopicDetailView.this.kVw.EN(1);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.kVz, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dcP() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.kVz);
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void EQ(int i) {
        this.kVJ.EQ(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void ER(int i) {
        this.kVJ.ER(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void F(boolean z, int i) {
        this.kVJ.F(z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void ES(int i) {
        this.kVJ.ES(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void f(@NonNull e eVar) {
        this.kVM = eVar;
        if (this.kVM.cKw() != null) {
            this.jMe.setTopicId(this.kVM.cKw().eLl);
            this.jMe.DB(this.kVM.cKw().ewR);
        }
        h(eVar);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void a(d dVar, boolean z, int i) {
        if (this.kVM != null) {
            this.kVJ.c(this.kVM.cKC());
        }
        this.kVJ.a(dVar, z, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public e dcQ() {
        return this.kVM;
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public d ET(int i) {
        return this.kVJ.ET(i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public int dcR() {
        return this.kVJ.dcR();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void dcS() {
        this.kVJ.dcS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDF() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jdC, 5000L);
        this.jds = true;
        this.kVw.EN(dcR());
    }

    private void bAw() {
        if (!this.kVy) {
            this.kVy = true;
            this.jEa.setVisibility(0);
            SvgManager.boN().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.boN().a(this.jEa, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            if (this.kVw instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.kVw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKQ() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Ob);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.kVC.getLayout().getLineEnd(1) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jLR, length - 1, spannableString.length(), 33);
        this.kVC.setText(spannableString);
        this.kVC.setHeight(this.kVC.getLineHeight() * 2);
        this.kVC.scrollTo(0, 0);
        this.kVC.requestLayout();
    }

    private void h(@NonNull e eVar) {
        bAw();
        this.kVB.setTopicInfo(eVar.cKw());
        a(eVar.cKw());
        g(eVar);
        List<q> cKE = eVar.cKE();
        if (y.isEmpty(cKE)) {
            this.kVH.setVisibility(8);
        } else {
            this.kVH.setData(cKE);
            this.kVH.setVisibility(0);
        }
        if (eVar.cKw() != null) {
            String str = eVar.cKw().ewR;
            if (af.getTextLengthWithEmoji(str) > 15) {
                str = af.subStringWithEmoji(str, 15) + StringHelper.STRING_MORE;
            }
            this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
        }
    }

    private void a(f fVar) {
        if (StringUtils.isNull(fVar.jJv)) {
            this.kVC.setVisibility(8);
        } else {
            this.kVC.setText(fVar.jJv);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.kVB.onChangeSkinType(skinType);
            ap.setViewTextColor(this.kVC, R.color.cp_cont_b, 1);
            ap.setBackgroundColor(this.kVF, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.kVx, R.color.cp_bg_line_h);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.kVG.onChangeSkinType(skinType);
            this.fJT.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
            this.kVH.onChangeSkinType(skinType);
            this.kVJ.onChangeSkinType(skinType);
            this.mSkinType = skinType;
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void e(long j, long j2, int i) {
        this.kVG.e(j, j2, i);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void D(long j, long j2) {
        this.kVB.E(j, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void resume() {
        if (this.kVJ != null) {
            this.kVJ.resume();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void pause() {
        if (this.kVJ != null) {
            this.kVJ.pause();
        }
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void destroy() {
        dcO();
        dcP();
        if (this.kVJ != null) {
            this.kVJ.destroy();
        }
        if (this.jds) {
            cDG();
        }
        if (this.ePu != null) {
            this.ePu.cancel();
            this.ePu.removeAllListeners();
            this.ePu.removeAllUpdateListeners();
            this.ePu = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jdC);
    }

    @Override // com.baidu.tieba.newdetail.a.b
    public void g(e eVar) {
        com.baidu.tieba.hottopic.data.a aVar = null;
        if (eVar.cKy() != null) {
            aVar = eVar.cKy();
            aVar.jIW = 3;
        } else if (eVar.cKz() != null) {
            aVar = eVar.cKz();
            aVar.jIW = 2;
        } else if (eVar.cKA() != null) {
            aVar = eVar.cKA();
            aVar.jIW = 1;
        }
        this.kVB.setBlessInfo(aVar);
        if (eVar.cKx() == null) {
            this.kVG.setVisibility(8);
            return;
        }
        this.kVG.setVisibility(0);
        this.kVG.a(eVar.cKx());
    }
}
