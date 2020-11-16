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
/* loaded from: classes20.dex */
public class HotTopicListView extends RelativeLayout {
    private static int lbK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout Ym;
    private ValueAnimator eUt;
    private ViewGroup fLf;
    private PbListView giV;
    private g grV;
    private View iKq;
    private int iKr;
    private int iKs;
    private AppBarLayout.OnOffsetChangedListener iLs;
    private View iRF;
    private boolean jkb;
    private PullRefreshFrameLayout.d jkj;
    private PullRefreshFrameLayout.c jkk;
    private Runnable jkl;
    private BdTypeRecyclerView jmd;
    private View lbM;
    private boolean lbN;
    private ViewGroup lbO;
    private PullRefreshFrameLayout lbP;
    private b ljp;
    private ImageView ljq;
    private ImageView ljr;
    private com.baidu.tieba.newlist.a.a ljs;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jkb = false;
        this.lbN = false;
        this.iLs = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.lbP != null) {
                    HotTopicListView.this.lbP.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.lbK + i < 0) {
                    HotTopicListView.this.lbM.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.lbM.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.jkj = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                HotTopicListView.this.B(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicListView.this.eUt = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.eUt.setDuration(150L);
                final int height = HotTopicListView.this.iKq.getHeight();
                HotTopicListView.this.eUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.eUt.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void brS() {
                final int i = HotTopicListView.this.iKs - HotTopicListView.this.iKr;
                if (i > 0) {
                    HotTopicListView.this.eUt = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.eUt.setDuration(300L);
                    final int i2 = HotTopicListView.this.iKs;
                    HotTopicListView.this.eUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.iKq != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.eUt.start();
                }
            }
        };
        this.jkl = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.jkb) {
                    HotTopicListView.this.cFM();
                }
            }
        };
        this.jkk = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void brR() {
                HotTopicListView.this.cFL();
            }
        };
        this.mPageContext = tbPageContext;
        this.ljp = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.lbM = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iRF = findViewById(R.id.header_round_corner_layout);
        this.iKq = findViewById(R.id.headerContainerLayout);
        this.iKr = l.getDimens(getContext(), R.dimen.tbds520);
        this.iKs = this.iKr;
        this.ljq = (ImageView) findViewById(R.id.bgContainer);
        this.ljr = (ImageView) findViewById(R.id.bgImage);
        this.lbP = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lbP.setOnTouchCallback(this.jkj);
        this.lbP.setOnPullRefreshListener(this.jkk);
        this.lbP.setFromFrs();
        this.lbP.brO();
        this.Ym = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.Ym.addOnOffsetChangedListener(this.iLs);
        this.jmd = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.jmd.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jmd.setFadingEdgeLength(0);
        this.jmd.setOverScrollMode(2);
        this.jmd.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.ljs = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.jmd);
        this.fLf = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.lbO = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.giV = new PbListView(this.mPageContext.getPageActivity());
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
    }

    public void B(double d) {
        if (this.iKq != null) {
            int i = (int) (this.iKr + (PullRefreshFrameLayout.eTY * d));
            ViewGroup.LayoutParams layoutParams = this.iKq.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iKs = layoutParams.height;
                this.iKq.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.iKq != null && (layoutParams = this.iKq.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iKs = i;
            this.iKq.setLayoutParams(layoutParams);
        }
    }

    public void cFM() {
        this.jkb = false;
        if (this.lbP != null) {
            this.lbP.brN();
        }
    }

    public void bOA() {
        if (this.jkb) {
            cFM();
            e.mY().removeCallbacks(this.jkl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFL() {
        e.mY().postDelayed(this.jkl, 5000L);
        this.jkb = true;
        this.ljp.loadData();
    }

    public void setData(@NonNull List<q> list) {
        this.ljs.setData(list);
        this.jmd.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.fLf.getHeight() > HotTopicListView.this.jmd.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.iKq.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.iKq.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bCo();
    }

    private void bCo() {
        if (!this.lbN) {
            this.lbN = true;
            SvgManager.bqB().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0101);
            if (this.ljp instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.ljp);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.lbM, R.color.pic_huati_toplist_base_color);
            ap.setImageResource(this.ljq, R.drawable.pic_huati_toplist_base);
            ap.setImageResource(this.ljr, R.drawable.pic_huati_toplist_upper);
            ap.setBackgroundResource(this.iRF, R.drawable.bg_header_round_corner);
            if (this.giV != null) {
                this.giV.changeSkin(skinType);
                this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
            this.ljs.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.grV == null) {
            this.grV = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.grV.attachView(this.lbO, false);
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this.lbO);
        }
    }

    public void pb(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.ljp != null) {
                            HotTopicListView.this.ljp.loadData();
                        }
                    }
                });
            }
            this.iKq.setVisibility(8);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lbO, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void VB() {
        if (this.mRefreshView != null) {
            this.iKq.setVisibility(0);
            this.mRefreshView.dettachView(this.lbO);
            this.mRefreshView = null;
        }
    }

    public void VA() {
        this.jmd.setNextPage(this.giV);
        this.giV.endLoadData();
        this.giV.showEmptyView(0);
        this.giV.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        VB();
        if (this.jkb) {
            cFM();
        }
        if (this.eUt != null) {
            this.eUt.cancel();
            this.eUt.removeAllListeners();
            this.eUt.removeAllUpdateListeners();
            this.eUt = null;
        }
        e.mY().removeCallbacks(this.jkl);
    }
}
