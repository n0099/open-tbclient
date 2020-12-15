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
    private static int lpm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout Zj;
    private ViewGroup fSQ;
    private ValueAnimator fbQ;
    private g gAg;
    private PbListView grg;
    private View iVl;
    private int iVm;
    private int iVn;
    private AppBarLayout.OnOffsetChangedListener iWn;
    private View jcz;
    private boolean jxG;
    private PullRefreshFrameLayout.d jxO;
    private PullRefreshFrameLayout.c jxP;
    private Runnable jxQ;
    private BdTypeRecyclerView jzI;
    private View lpo;
    private boolean lpp;
    private ViewGroup lpq;
    private PullRefreshFrameLayout lpr;
    private b lwQ;
    private ImageView lwR;
    private ImageView lwS;
    private com.baidu.tieba.newlist.a.a lwT;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jxG = false;
        this.lpp = false;
        this.iWn = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.lpr != null) {
                    HotTopicListView.this.lpr.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.lpm + i < 0) {
                    HotTopicListView.this.lpo.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.lpo.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.jxO = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                HotTopicListView.this.C(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicListView.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.fbQ.setDuration(150L);
                final int height = HotTopicListView.this.iVl.getHeight();
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
                final int i = HotTopicListView.this.iVn - HotTopicListView.this.iVm;
                if (i > 0) {
                    HotTopicListView.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.fbQ.setDuration(300L);
                    final int i2 = HotTopicListView.this.iVn;
                    HotTopicListView.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.iVl != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.fbQ.start();
                }
            }
        };
        this.jxQ = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.jxG) {
                    HotTopicListView.this.cLd();
                }
            }
        };
        this.jxP = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bvq() {
                HotTopicListView.this.cLc();
            }
        };
        this.mPageContext = tbPageContext;
        this.lwQ = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.lpo = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jcz = findViewById(R.id.header_round_corner_layout);
        this.iVl = findViewById(R.id.headerContainerLayout);
        this.iVm = l.getDimens(getContext(), R.dimen.tbds520);
        this.iVn = this.iVm;
        this.lwR = (ImageView) findViewById(R.id.bgContainer);
        this.lwS = (ImageView) findViewById(R.id.bgImage);
        this.lpr = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lpr.setOnTouchCallback(this.jxO);
        this.lpr.setOnPullRefreshListener(this.jxP);
        this.lpr.setFromFrs();
        this.lpr.bvn();
        this.Zj = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.Zj.addOnOffsetChangedListener(this.iWn);
        this.jzI = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.jzI.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jzI.setFadingEdgeLength(0);
        this.jzI.setOverScrollMode(2);
        this.jzI.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.lwT = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.jzI);
        this.fSQ = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.lpq = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.grg = new PbListView(this.mPageContext.getPageActivity());
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
    }

    public void C(double d) {
        if (this.iVl != null) {
            int i = (int) (this.iVm + (PullRefreshFrameLayout.fbv * d));
            ViewGroup.LayoutParams layoutParams = this.iVl.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iVn = layoutParams.height;
                this.iVl.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.iVl != null && (layoutParams = this.iVl.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iVn = i;
            this.iVl.setLayoutParams(layoutParams);
        }
    }

    public void cLd() {
        this.jxG = false;
        if (this.lpr != null) {
            this.lpr.bvm();
        }
    }

    public void bSm() {
        if (this.jxG) {
            cLd();
            e.mY().removeCallbacks(this.jxQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLc() {
        e.mY().postDelayed(this.jxQ, 5000L);
        this.jxG = true;
        this.lwQ.loadData();
    }

    public void setData(@NonNull List<q> list) {
        this.lwT.setData(list);
        this.jzI.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.fSQ.getHeight() > HotTopicListView.this.jzI.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.iVl.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.iVl.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bFP();
    }

    private void bFP() {
        if (!this.lpp) {
            this.lpp = true;
            SvgManager.btW().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0101);
            if (this.lwQ instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lwQ);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.lpo, R.color.pic_huati_toplist_base_color);
            ap.setImageResource(this.lwR, R.drawable.pic_huati_toplist_base);
            ap.setImageResource(this.lwS, R.drawable.pic_huati_toplist_upper);
            ap.setBackgroundResource(this.jcz, R.drawable.bg_header_round_corner);
            if (this.grg != null) {
                this.grg.changeSkin(skinType);
                this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
            this.lwT.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.gAg == null) {
            this.gAg = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gAg.attachView(this.lpq, false);
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this.lpq);
        }
    }

    public void px(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.lwQ != null) {
                            HotTopicListView.this.lwQ.loadData();
                        }
                    }
                });
            }
            this.iVl.setVisibility(8);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lpq, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.iVl.setVisibility(0);
            this.mRefreshView.dettachView(this.lpq);
            this.mRefreshView = null;
        }
    }

    public void Ya() {
        this.jzI.setNextPage(this.grg);
        this.grg.endLoadData();
        this.grg.showEmptyView(0);
        this.grg.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        Yb();
        if (this.jxG) {
            cLd();
        }
        if (this.fbQ != null) {
            this.fbQ.cancel();
            this.fbQ.removeAllListeners();
            this.fbQ.removeAllUpdateListeners();
            this.fbQ = null;
        }
        e.mY().removeCallbacks(this.jxQ);
    }
}
