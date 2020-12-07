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
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes21.dex */
public class HotTopicListView extends RelativeLayout {
    private static int lpk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout Zj;
    private ViewGroup fSQ;
    private ValueAnimator fbQ;
    private g gAe;
    private PbListView gre;
    private View iVj;
    private int iVk;
    private int iVl;
    private AppBarLayout.OnOffsetChangedListener iWl;
    private View jcx;
    private boolean jxE;
    private PullRefreshFrameLayout.d jxM;
    private PullRefreshFrameLayout.c jxN;
    private Runnable jxO;
    private BdTypeRecyclerView jzG;
    private View lpm;
    private boolean lpn;
    private ViewGroup lpo;
    private PullRefreshFrameLayout lpp;
    private b lwO;
    private ImageView lwP;
    private ImageView lwQ;
    private com.baidu.tieba.newlist.a.a lwR;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jxE = false;
        this.lpn = false;
        this.iWl = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.lpp != null) {
                    HotTopicListView.this.lpp.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.lpk + i < 0) {
                    HotTopicListView.this.lpm.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.lpm.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.jxM = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                HotTopicListView.this.C(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicListView.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.fbQ.setDuration(150L);
                final int height = HotTopicListView.this.iVj.getHeight();
                HotTopicListView.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.fbQ.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bvr() {
                final int i = HotTopicListView.this.iVl - HotTopicListView.this.iVk;
                if (i > 0) {
                    HotTopicListView.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.fbQ.setDuration(300L);
                    final int i2 = HotTopicListView.this.iVl;
                    HotTopicListView.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.iVj != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.fbQ.start();
                }
            }
        };
        this.jxO = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.jxE) {
                    HotTopicListView.this.cLc();
                }
            }
        };
        this.jxN = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bvq() {
                HotTopicListView.this.cLb();
            }
        };
        this.mPageContext = tbPageContext;
        this.lwO = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.lpm = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jcx = findViewById(R.id.header_round_corner_layout);
        this.iVj = findViewById(R.id.headerContainerLayout);
        this.iVk = l.getDimens(getContext(), R.dimen.tbds520);
        this.iVl = this.iVk;
        this.lwP = (ImageView) findViewById(R.id.bgContainer);
        this.lwQ = (ImageView) findViewById(R.id.bgImage);
        this.lpp = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lpp.setOnTouchCallback(this.jxM);
        this.lpp.setOnPullRefreshListener(this.jxN);
        this.lpp.setFromFrs();
        this.lpp.bvn();
        this.Zj = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.Zj.addOnOffsetChangedListener(this.iWl);
        this.jzG = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.jzG.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jzG.setFadingEdgeLength(0);
        this.jzG.setOverScrollMode(2);
        this.jzG.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.lwR = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.jzG);
        this.fSQ = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.lpo = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.gre = new PbListView(this.mPageContext.getPageActivity());
        this.gre.createView();
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
    }

    public void C(double d) {
        if (this.iVj != null) {
            int i = (int) (this.iVk + (PullRefreshFrameLayout.fbv * d));
            ViewGroup.LayoutParams layoutParams = this.iVj.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iVl = layoutParams.height;
                this.iVj.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.iVj != null && (layoutParams = this.iVj.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iVl = i;
            this.iVj.setLayoutParams(layoutParams);
        }
    }

    public void cLc() {
        this.jxE = false;
        if (this.lpp != null) {
            this.lpp.bvm();
        }
    }

    public void bSl() {
        if (this.jxE) {
            cLc();
            e.mY().removeCallbacks(this.jxO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLb() {
        e.mY().postDelayed(this.jxO, 5000L);
        this.jxE = true;
        this.lwO.loadData();
    }

    public void setData(@NonNull List<q> list) {
        this.lwR.setData(list);
        this.jzG.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.fSQ.getHeight() > HotTopicListView.this.jzG.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.iVj.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.iVj.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bFP();
    }

    private void bFP() {
        if (!this.lpn) {
            this.lpn = true;
            SvgManager.btW().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0101);
            if (this.lwO instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lwO);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.lpm, R.color.pic_huati_toplist_base_color);
            ap.setImageResource(this.lwP, R.drawable.pic_huati_toplist_base);
            ap.setImageResource(this.lwQ, R.drawable.pic_huati_toplist_upper);
            ap.setBackgroundResource(this.jcx, R.drawable.bg_header_round_corner);
            if (this.gre != null) {
                this.gre.changeSkin(skinType);
                this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
            this.lwR.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.gAe == null) {
            this.gAe = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gAe.attachView(this.lpo, false);
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this.lpo);
        }
    }

    public void px(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.lwO != null) {
                            HotTopicListView.this.lwO.loadData();
                        }
                    }
                });
            }
            this.iVj.setVisibility(8);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lpo, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.iVj.setVisibility(0);
            this.mRefreshView.dettachView(this.lpo);
            this.mRefreshView = null;
        }
    }

    public void Ya() {
        this.jzG.setNextPage(this.gre);
        this.gre.endLoadData();
        this.gre.showEmptyView(0);
        this.gre.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        Yb();
        if (this.jxE) {
            cLc();
        }
        if (this.fbQ != null) {
            this.fbQ.cancel();
            this.fbQ.removeAllListeners();
            this.fbQ.removeAllUpdateListeners();
            this.fbQ = null;
        }
        e.mY().removeCallbacks(this.jxO);
    }
}
