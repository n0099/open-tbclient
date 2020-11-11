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
/* loaded from: classes21.dex */
public class HotTopicListView extends RelativeLayout {
    private static int lbs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout Yh;
    private ValueAnimator eVj;
    private ViewGroup fLC;
    private PbListView gjo;
    private g gso;
    private View iJD;
    private int iJE;
    private int iJF;
    private AppBarLayout.OnOffsetChangedListener iKF;
    private View iQS;
    private Runnable jjA;
    private boolean jjq;
    private PullRefreshFrameLayout.d jjy;
    private PullRefreshFrameLayout.c jjz;
    private BdTypeRecyclerView jlt;
    private View lbu;
    private boolean lbv;
    private ViewGroup lbw;
    private PullRefreshFrameLayout lbx;
    private b liY;
    private ImageView liZ;
    private ImageView lja;
    private com.baidu.tieba.newlist.a.a ljb;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jjq = false;
        this.lbv = false;
        this.iKF = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.lbx != null) {
                    HotTopicListView.this.lbx.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.lbs + i < 0) {
                    HotTopicListView.this.lbu.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.lbu.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.jjy = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void x(double d) {
                HotTopicListView.this.B(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicListView.this.eVj = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.eVj.setDuration(150L);
                final int height = HotTopicListView.this.iJD.getHeight();
                HotTopicListView.this.eVj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.eVj.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bsC() {
                final int i = HotTopicListView.this.iJF - HotTopicListView.this.iJE;
                if (i > 0) {
                    HotTopicListView.this.eVj = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.eVj.setDuration(300L);
                    final int i2 = HotTopicListView.this.iJF;
                    HotTopicListView.this.eVj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.iJD != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.eVj.start();
                }
            }
        };
        this.jjA = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.jjq) {
                    HotTopicListView.this.cGh();
                }
            }
        };
        this.jjz = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bsB() {
                HotTopicListView.this.cGg();
            }
        };
        this.mPageContext = tbPageContext;
        this.liY = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.lbu = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iQS = findViewById(R.id.header_round_corner_layout);
        this.iJD = findViewById(R.id.headerContainerLayout);
        this.iJE = l.getDimens(getContext(), R.dimen.tbds520);
        this.iJF = this.iJE;
        this.liZ = (ImageView) findViewById(R.id.bgContainer);
        this.lja = (ImageView) findViewById(R.id.bgImage);
        this.lbx = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lbx.setOnTouchCallback(this.jjy);
        this.lbx.setOnPullRefreshListener(this.jjz);
        this.lbx.setFromFrs();
        this.lbx.bsz();
        this.Yh = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.Yh.addOnOffsetChangedListener(this.iKF);
        this.jlt = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.jlt.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jlt.setFadingEdgeLength(0);
        this.jlt.setOverScrollMode(2);
        this.jlt.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.ljb = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.jlt);
        this.fLC = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.lbw = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.gjo = new PbListView(this.mPageContext.getPageActivity());
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void B(double d) {
        if (this.iJD != null) {
            int i = (int) (this.iJE + (PullRefreshFrameLayout.eUQ * d));
            ViewGroup.LayoutParams layoutParams = this.iJD.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iJF = layoutParams.height;
                this.iJD.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.iJD != null && (layoutParams = this.iJD.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iJF = i;
            this.iJD.setLayoutParams(layoutParams);
        }
    }

    public void cGh() {
        this.jjq = false;
        if (this.lbx != null) {
            this.lbx.bsy();
        }
    }

    public void bPh() {
        if (this.jjq) {
            cGh();
            e.mY().removeCallbacks(this.jjA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGg() {
        e.mY().postDelayed(this.jjA, 5000L);
        this.jjq = true;
        this.liY.loadData();
    }

    public void setData(@NonNull List<q> list) {
        this.ljb.setData(list);
        this.jlt.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.fLC.getHeight() > HotTopicListView.this.jlt.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.iJD.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.iJD.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bCV();
    }

    private void bCV() {
        if (!this.lbv) {
            this.lbv = true;
            SvgManager.brn().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_a);
            if (this.liY instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.liY);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.lbu, R.color.pic_huati_toplist_base_color);
            ap.setImageResource(this.liZ, R.drawable.pic_huati_toplist_base);
            ap.setImageResource(this.lja, R.drawable.pic_huati_toplist_upper);
            ap.setBackgroundResource(this.iQS, R.drawable.bg_header_round_corner);
            if (this.gjo != null) {
                this.gjo.changeSkin(skinType);
                this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            this.ljb.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.gso == null) {
            this.gso = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gso.attachView(this.lbw, false);
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this.lbw);
        }
    }

    public void oY(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.liY != null) {
                            HotTopicListView.this.liY.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lbw, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lbw);
            this.mRefreshView = null;
        }
    }

    public void Wj() {
        this.jlt.setNextPage(this.gjo);
        this.gjo.endLoadData();
        this.gjo.showEmptyView(0);
        this.gjo.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        Wk();
        if (this.jjq) {
            cGh();
        }
        if (this.eVj != null) {
            this.eVj.cancel();
            this.eVj.removeAllListeners();
            this.eVj.removeAllUpdateListeners();
            this.eVj = null;
        }
        e.mY().removeCallbacks(this.jjA);
    }
}
