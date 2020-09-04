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
    private static int kln = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout Xx;
    private ValueAnimator esJ;
    private PbListView fEa;
    private g fMR;
    private ViewGroup fik;
    private View hVj;
    private int hVk;
    private int hVl;
    private AppBarLayout.OnOffsetChangedListener hWl;
    private View icy;
    private boolean iuK;
    private PullRefreshFrameLayout.d iuS;
    private PullRefreshFrameLayout.c iuT;
    private Runnable iuU;
    private BdTypeRecyclerView iwN;
    private View klp;
    private boolean klq;
    private ViewGroup klr;
    private PullRefreshFrameLayout kls;
    private b ksT;
    private ImageView ksU;
    private ImageView ksV;
    private com.baidu.tieba.newlist.a.a ksW;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iuK = false;
        this.klq = false;
        this.hWl = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.kls != null) {
                    HotTopicListView.this.kls.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.kln + i < 0) {
                    HotTopicListView.this.klp.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.klp.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.iuS = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void t(double d) {
                HotTopicListView.this.x(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicListView.this.esJ = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.esJ.setDuration(150L);
                final int height = HotTopicListView.this.hVj.getHeight();
                HotTopicListView.this.esJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.esJ.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bkE() {
                final int i = HotTopicListView.this.hVl - HotTopicListView.this.hVk;
                if (i > 0) {
                    HotTopicListView.this.esJ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.esJ.setDuration(300L);
                    final int i2 = HotTopicListView.this.hVl;
                    HotTopicListView.this.esJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.hVj != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.esJ.start();
                }
            }
        };
        this.iuU = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.iuK) {
                    HotTopicListView.this.ctK();
                }
            }
        };
        this.iuT = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bkD() {
                HotTopicListView.this.ctJ();
            }
        };
        this.mPageContext = tbPageContext;
        this.ksT = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.klp = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.icy = findViewById(R.id.header_round_corner_layout);
        this.hVj = findViewById(R.id.headerContainerLayout);
        this.hVk = l.getDimens(getContext(), R.dimen.tbds520);
        this.hVl = this.hVk;
        this.ksU = (ImageView) findViewById(R.id.bgContainer);
        this.ksV = (ImageView) findViewById(R.id.bgImage);
        this.kls = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.kls.setOnTouchCallback(this.iuS);
        this.kls.setOnPullRefreshListener(this.iuT);
        this.kls.setFromFrs();
        this.kls.bkB();
        this.Xx = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.Xx.addOnOffsetChangedListener(this.hWl);
        this.iwN = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.iwN.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iwN.setFadingEdgeLength(0);
        this.iwN.setOverScrollMode(2);
        this.iwN.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.ksW = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.iwN);
        this.fik = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.klr = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.fEa = new PbListView(this.mPageContext.getPageActivity());
        this.fEa.createView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void x(double d) {
        if (this.hVj != null) {
            int i = (int) (this.hVk + (PullRefreshFrameLayout.esq * d));
            ViewGroup.LayoutParams layoutParams = this.hVj.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hVl = layoutParams.height;
                this.hVj.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.hVj != null && (layoutParams = this.hVj.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hVl = i;
            this.hVj.setLayoutParams(layoutParams);
        }
    }

    public void ctK() {
        this.iuK = false;
        if (this.kls != null) {
            this.kls.bkA();
        }
    }

    public void bGe() {
        if (this.iuK) {
            ctK();
            e.mS().removeCallbacks(this.iuU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctJ() {
        e.mS().postDelayed(this.iuU, 5000L);
        this.iuK = true;
        this.ksT.loadData();
    }

    public void setData(@NonNull List<q> list) {
        this.ksW.setData(list);
        this.iwN.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.fik.getHeight() > HotTopicListView.this.iwN.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.hVj.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.hVj.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        buP();
    }

    private void buP() {
        if (!this.klq) {
            this.klq = true;
            SvgManager.bjq().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_a);
            if (this.ksT instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.ksT);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.klp, R.color.pic_huati_toplist_base_color);
            ap.setImageResource(this.ksU, R.drawable.pic_huati_toplist_base);
            ap.setImageResource(this.ksV, R.drawable.pic_huati_toplist_upper);
            ap.setBackgroundResource(this.icy, R.drawable.bg_header_round_corner);
            if (this.fEa != null) {
                this.fEa.changeSkin(skinType);
                this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            this.ksW.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.fMR == null) {
            this.fMR = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fMR.attachView(this.klr, false);
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this.klr);
        }
    }

    public void nM(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.ksT != null) {
                            HotTopicListView.this.ksT.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.klr, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void bFX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.klr);
            this.mRefreshView = null;
        }
    }

    public void bGT() {
        this.iwN.setNextPage(this.fEa);
        this.fEa.endLoadData();
        this.fEa.showEmptyView(0);
        this.fEa.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        bFX();
        if (this.iuK) {
            ctK();
        }
        if (this.esJ != null) {
            this.esJ.cancel();
            this.esJ.removeAllListeners();
            this.esJ.removeAllUpdateListeners();
            this.esJ = null;
        }
        e.mS().removeCallbacks(this.iuU);
    }
}
