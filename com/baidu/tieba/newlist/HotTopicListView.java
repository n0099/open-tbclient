package com.baidu.tieba.newlist;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
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
import com.google.android.material.appbar.AppBarLayout;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class HotTopicListView extends RelativeLayout {
    private static int lxS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout ZM;
    private ValueAnimator fjh;
    private PbListView gAi;
    private g gJn;
    private ViewGroup gaa;
    private boolean jLb;
    private PullRefreshFrameLayout.d jLj;
    private PullRefreshFrameLayout.c jLk;
    private Runnable jLl;
    private BdTypeRecyclerView jNf;
    private View jix;
    private int jiy;
    private int jiz;
    private AppBarLayout.OnOffsetChangedListener jjz;
    private View jpR;
    private b lFw;
    private ImageView lFx;
    private ImageView lFy;
    private com.baidu.tieba.newlist.a.a lFz;
    private View lxU;
    private boolean lxV;
    private ViewGroup lxW;
    private PullRefreshFrameLayout lxX;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jLb = false;
        this.lxV = false;
        this.jjz = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.lxX != null) {
                    HotTopicListView.this.lxX.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.lxS + i < 0) {
                    HotTopicListView.this.lxU.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.lxU.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.jLj = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void q(double d) {
                HotTopicListView.this.v(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                HotTopicListView.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.fjh.setDuration(150L);
                final int height = HotTopicListView.this.jix.getHeight();
                HotTopicListView.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.fjh.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bun() {
                final int i = HotTopicListView.this.jiz - HotTopicListView.this.jiy;
                if (i > 0) {
                    HotTopicListView.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.fjh.setDuration(300L);
                    final int i2 = HotTopicListView.this.jiz;
                    HotTopicListView.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.jix != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.fjh.start();
                }
            }
        };
        this.jLl = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.jLb) {
                    HotTopicListView.this.cLB();
                }
            }
        };
        this.jLk = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bum() {
                HotTopicListView.this.cLA();
            }
        };
        this.mPageContext = tbPageContext;
        this.lFw = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.lxU = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jpR = findViewById(R.id.header_round_corner_layout);
        this.jix = findViewById(R.id.headerContainerLayout);
        this.jiy = l.getDimens(getContext(), R.dimen.tbds520);
        this.jiz = this.jiy;
        this.lFx = (ImageView) findViewById(R.id.bgContainer);
        this.lFy = (ImageView) findViewById(R.id.bgImage);
        this.lxX = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lxX.setOnTouchCallback(this.jLj);
        this.lxX.setOnPullRefreshListener(this.jLk);
        this.lxX.setFromFrs();
        this.lxX.buj();
        this.ZM = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.ZM.addOnOffsetChangedListener(this.jjz);
        this.jNf = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.jNf.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jNf.setFadingEdgeLength(0);
        this.jNf.setOverScrollMode(2);
        this.jNf.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.lFz = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.jNf);
        this.gaa = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.lxW = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.gAi = new PbListView(this.mPageContext.getPageActivity());
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
    }

    public void v(double d) {
        if (this.jix != null) {
            int i = (int) (this.jiy + (PullRefreshFrameLayout.fiM * d));
            ViewGroup.LayoutParams layoutParams = this.jix.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jiz = layoutParams.height;
                this.jix.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jix != null && (layoutParams = this.jix.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jiz = i;
            this.jix.setLayoutParams(layoutParams);
        }
    }

    public void cLB() {
        this.jLb = false;
        if (this.lxX != null) {
            this.lxX.bui();
        }
    }

    public void bRB() {
        if (this.jLb) {
            cLB();
            e.mA().removeCallbacks(this.jLl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLA() {
        e.mA().postDelayed(this.jLl, 5000L);
        this.jLb = true;
        this.lFw.loadData();
    }

    public void setData(@NonNull List<n> list) {
        this.lFz.setData(list);
        this.jNf.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.gaa.getHeight() > HotTopicListView.this.jNf.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.jix.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.jix.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bEL();
    }

    private void bEL() {
        if (!this.lxV) {
            this.lxV = true;
            SvgManager.bsR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0101);
            if (this.lFw instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lFw);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.lxU, R.color.pic_huati_toplist_base_color);
            ap.setImageResource(this.lFx, R.drawable.pic_huati_toplist_base);
            ap.setImageResource(this.lFy, R.drawable.pic_huati_toplist_upper);
            ap.setBackgroundResource(this.jpR, R.drawable.bg_header_round_corner);
            if (this.gAi != null) {
                this.gAi.changeSkin(skinType);
                this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
            this.lFz.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.gJn == null) {
            this.gJn = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gJn.attachView(this.lxW, false);
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this.lxW);
        }
    }

    public void qa(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.lFw != null) {
                            HotTopicListView.this.lFw.loadData();
                        }
                    }
                });
            }
            this.jix.setVisibility(8);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lxW, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.jix.setVisibility(0);
            this.mRefreshView.dettachView(this.lxW);
            this.mRefreshView = null;
        }
    }

    public void WY() {
        this.jNf.setNextPage(this.gAi);
        this.gAi.endLoadData();
        this.gAi.showEmptyView(0);
        this.gAi.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        WZ();
        if (this.jLb) {
            cLB();
        }
        if (this.fjh != null) {
            this.fjh.cancel();
            this.fjh.removeAllListeners();
            this.fjh.removeAllUpdateListeners();
            this.fjh = null;
        }
        e.mA().removeCallbacks(this.jLl);
    }
}
