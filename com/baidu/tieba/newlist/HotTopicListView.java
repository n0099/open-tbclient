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
    private static int lyg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout ZM;
    private ValueAnimator fjh;
    private PbListView gAw;
    private g gJB;
    private ViewGroup gaa;
    private boolean jLp;
    private PullRefreshFrameLayout.d jLx;
    private PullRefreshFrameLayout.c jLy;
    private Runnable jLz;
    private BdTypeRecyclerView jNt;
    private View jiL;
    private int jiM;
    private int jiN;
    private AppBarLayout.OnOffsetChangedListener jjN;
    private View jqf;
    private b lFK;
    private ImageView lFL;
    private ImageView lFM;
    private com.baidu.tieba.newlist.a.a lFN;
    private View lyi;
    private boolean lyj;
    private ViewGroup lyk;
    private PullRefreshFrameLayout lyl;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jLp = false;
        this.lyj = false;
        this.jjN = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.lyl != null) {
                    HotTopicListView.this.lyl.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.lyg + i < 0) {
                    HotTopicListView.this.lyi.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.lyi.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.jLx = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void q(double d) {
                HotTopicListView.this.v(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                HotTopicListView.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.fjh.setDuration(150L);
                final int height = HotTopicListView.this.jiL.getHeight();
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
                final int i = HotTopicListView.this.jiN - HotTopicListView.this.jiM;
                if (i > 0) {
                    HotTopicListView.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.fjh.setDuration(300L);
                    final int i2 = HotTopicListView.this.jiN;
                    HotTopicListView.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.jiL != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.fjh.start();
                }
            }
        };
        this.jLz = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.jLp) {
                    HotTopicListView.this.cLI();
                }
            }
        };
        this.jLy = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bum() {
                HotTopicListView.this.cLH();
            }
        };
        this.mPageContext = tbPageContext;
        this.lFK = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.lyi = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jqf = findViewById(R.id.header_round_corner_layout);
        this.jiL = findViewById(R.id.headerContainerLayout);
        this.jiM = l.getDimens(getContext(), R.dimen.tbds520);
        this.jiN = this.jiM;
        this.lFL = (ImageView) findViewById(R.id.bgContainer);
        this.lFM = (ImageView) findViewById(R.id.bgImage);
        this.lyl = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lyl.setOnTouchCallback(this.jLx);
        this.lyl.setOnPullRefreshListener(this.jLy);
        this.lyl.setFromFrs();
        this.lyl.buj();
        this.ZM = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.ZM.addOnOffsetChangedListener(this.jjN);
        this.jNt = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.jNt.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jNt.setFadingEdgeLength(0);
        this.jNt.setOverScrollMode(2);
        this.jNt.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.lFN = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.jNt);
        this.gaa = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.lyk = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.gAw = new PbListView(this.mPageContext.getPageActivity());
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
    }

    public void v(double d) {
        if (this.jiL != null) {
            int i = (int) (this.jiM + (PullRefreshFrameLayout.fiM * d));
            ViewGroup.LayoutParams layoutParams = this.jiL.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jiN = layoutParams.height;
                this.jiL.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jiL != null && (layoutParams = this.jiL.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jiN = i;
            this.jiL.setLayoutParams(layoutParams);
        }
    }

    public void cLI() {
        this.jLp = false;
        if (this.lyl != null) {
            this.lyl.bui();
        }
    }

    public void bRI() {
        if (this.jLp) {
            cLI();
            e.mA().removeCallbacks(this.jLz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLH() {
        e.mA().postDelayed(this.jLz, 5000L);
        this.jLp = true;
        this.lFK.loadData();
    }

    public void setData(@NonNull List<n> list) {
        this.lFN.setData(list);
        this.jNt.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.gaa.getHeight() > HotTopicListView.this.jNt.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.jiL.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.jiL.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bEL();
    }

    private void bEL() {
        if (!this.lyj) {
            this.lyj = true;
            SvgManager.bsR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0101);
            if (this.lFK instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lFK);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.lyi, R.color.pic_huati_toplist_base_color);
            ap.setImageResource(this.lFL, R.drawable.pic_huati_toplist_base);
            ap.setImageResource(this.lFM, R.drawable.pic_huati_toplist_upper);
            ap.setBackgroundResource(this.jqf, R.drawable.bg_header_round_corner);
            if (this.gAw != null) {
                this.gAw.changeSkin(skinType);
                this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
            this.lFN.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.gJB == null) {
            this.gJB = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gJB.attachView(this.lyk, false);
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this.lyk);
        }
    }

    public void qa(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.lFK != null) {
                            HotTopicListView.this.lFK.loadData();
                        }
                    }
                });
            }
            this.jiL.setVisibility(8);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lyk, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.jiL.setVisibility(0);
            this.mRefreshView.dettachView(this.lyk);
            this.mRefreshView = null;
        }
    }

    public void WY() {
        this.jNt.setNextPage(this.gAw);
        this.gAw.endLoadData();
        this.gAw.showEmptyView(0);
        this.gAw.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        WZ();
        if (this.jLp) {
            cLI();
        }
        if (this.fjh != null) {
            this.fjh.cancel();
            this.fjh.removeAllListeners();
            this.fjh.removeAllUpdateListeners();
            this.fjh = null;
        }
        e.mA().removeCallbacks(this.jLz);
    }
}
