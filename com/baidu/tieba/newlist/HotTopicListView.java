package com.baidu.tieba.newlist;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes15.dex */
public class HotTopicListView extends RelativeLayout {
    private static int klg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout Xv;
    private ValueAnimator esF;
    private PbListView fDW;
    private g fMN;
    private ViewGroup fig;
    private View hVd;
    private int hVe;
    private int hVf;
    private AppBarLayout.OnOffsetChangedListener hWf;
    private View ics;
    private boolean iuE;
    private PullRefreshFrameLayout.d iuM;
    private PullRefreshFrameLayout.c iuN;
    private Runnable iuO;
    private BdTypeRecyclerView iwH;
    private View kli;
    private boolean klj;
    private ViewGroup klk;
    private PullRefreshFrameLayout kll;
    private b ksM;
    private ImageView ksN;
    private ImageView ksO;
    private com.baidu.tieba.newlist.a.a ksP;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iuE = false;
        this.klj = false;
        this.hWf = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.kll != null) {
                    HotTopicListView.this.kll.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.klg + i < 0) {
                    HotTopicListView.this.kli.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.kli.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.iuM = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void t(double d) {
                HotTopicListView.this.x(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicListView.this.esF = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.esF.setDuration(150L);
                final int height = HotTopicListView.this.hVd.getHeight();
                HotTopicListView.this.esF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.esF.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bkE() {
                final int i = HotTopicListView.this.hVf - HotTopicListView.this.hVe;
                if (i > 0) {
                    HotTopicListView.this.esF = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.esF.setDuration(300L);
                    final int i2 = HotTopicListView.this.hVf;
                    HotTopicListView.this.esF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.hVd != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.esF.start();
                }
            }
        };
        this.iuO = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.iuE) {
                    HotTopicListView.this.ctJ();
                }
            }
        };
        this.iuN = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bkD() {
                HotTopicListView.this.ctI();
            }
        };
        this.mPageContext = tbPageContext;
        this.ksM = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.kli = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ics = findViewById(R.id.header_round_corner_layout);
        this.hVd = findViewById(R.id.headerContainerLayout);
        this.hVe = l.getDimens(getContext(), R.dimen.tbds520);
        this.hVf = this.hVe;
        this.ksN = (ImageView) findViewById(R.id.bgContainer);
        this.ksO = (ImageView) findViewById(R.id.bgImage);
        this.kll = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.kll.setOnTouchCallback(this.iuM);
        this.kll.setOnPullRefreshListener(this.iuN);
        this.kll.setFromFrs();
        this.kll.bkB();
        this.Xv = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.Xv.addOnOffsetChangedListener(this.hWf);
        this.iwH = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.iwH.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iwH.setFadingEdgeLength(0);
        this.iwH.setOverScrollMode(2);
        this.iwH.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.ksP = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.iwH);
        this.fig = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.klk = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.fDW = new PbListView(this.mPageContext.getPageActivity());
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void x(double d) {
        if (this.hVd != null) {
            int i = (int) (this.hVe + (PullRefreshFrameLayout.esm * d));
            ViewGroup.LayoutParams layoutParams = this.hVd.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hVf = layoutParams.height;
                this.hVd.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.hVd != null && (layoutParams = this.hVd.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hVf = i;
            this.hVd.setLayoutParams(layoutParams);
        }
    }

    public void ctJ() {
        this.iuE = false;
        if (this.kll != null) {
            this.kll.bkA();
        }
    }

    public void bGd() {
        if (this.iuE) {
            ctJ();
            e.mS().removeCallbacks(this.iuO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctI() {
        e.mS().postDelayed(this.iuO, 5000L);
        this.iuE = true;
        this.ksM.loadData();
    }

    public void setData(@NonNull List<q> list) {
        this.ksP.setData(list);
        this.iwH.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.fig.getHeight() > HotTopicListView.this.iwH.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.hVd.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.hVd.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        buO();
    }

    private void buO() {
        if (!this.klj) {
            this.klj = true;
            SvgManager.bjq().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_a);
            if (this.ksM instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.ksM);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.kli, R.color.pic_huati_toplist_base_color);
            ap.setImageResource(this.ksN, R.drawable.pic_huati_toplist_base);
            ap.setImageResource(this.ksO, R.drawable.pic_huati_toplist_upper);
            ap.setBackgroundResource(this.ics, R.drawable.bg_header_round_corner);
            if (this.fDW != null) {
                this.fDW.changeSkin(skinType);
                this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            this.ksP.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.fMN == null) {
            this.fMN = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fMN.attachView(this.klk, false);
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this.klk);
        }
    }

    public void nK(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.ksM != null) {
                            HotTopicListView.this.ksM.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.klk, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void bFW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.klk);
            this.mRefreshView = null;
        }
    }

    public void bGS() {
        this.iwH.setNextPage(this.fDW);
        this.fDW.endLoadData();
        this.fDW.showEmptyView(0);
        this.fDW.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        bFW();
        if (this.iuE) {
            ctJ();
        }
        if (this.esF != null) {
            this.esF.cancel();
            this.esF.removeAllListeners();
            this.esF.removeAllUpdateListeners();
            this.esF = null;
        }
        e.mS().removeCallbacks(this.iuO);
    }
}
