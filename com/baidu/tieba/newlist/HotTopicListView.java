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
import com.baidu.tbadk.core.util.ao;
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
    private static int luu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout ZS;
    private ValueAnimator flz;
    private PbListView gCf;
    private g gLj;
    private ViewGroup gcs;
    private boolean jKd;
    private PullRefreshFrameLayout.d jKl;
    private PullRefreshFrameLayout.c jKm;
    private Runnable jKn;
    private BdTypeRecyclerView jMh;
    private View jhx;
    private int jhy;
    private int jhz;
    private AppBarLayout.OnOffsetChangedListener jiA;
    private View joR;
    private b lBY;
    private ImageView lBZ;
    private ImageView lCa;
    private com.baidu.tieba.newlist.a.a lCb;
    private View luw;
    private boolean lux;
    private ViewGroup luy;
    private PullRefreshFrameLayout luz;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jKd = false;
        this.lux = false;
        this.jiA = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.luz != null) {
                    HotTopicListView.this.luz.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.luu + i < 0) {
                    HotTopicListView.this.luw.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.luw.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.jKl = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                HotTopicListView.this.B(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                HotTopicListView.this.flz = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.flz.setDuration(150L);
                final int height = HotTopicListView.this.jhx.getHeight();
                HotTopicListView.this.flz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.flz.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bxN() {
                final int i = HotTopicListView.this.jhz - HotTopicListView.this.jhy;
                if (i > 0) {
                    HotTopicListView.this.flz = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.flz.setDuration(300L);
                    final int i2 = HotTopicListView.this.jhz;
                    HotTopicListView.this.flz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.jhx != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.flz.start();
                }
            }
        };
        this.jKn = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.jKd) {
                    HotTopicListView.this.cOf();
                }
            }
        };
        this.jKm = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bxM() {
                HotTopicListView.this.cOe();
            }
        };
        this.mPageContext = tbPageContext;
        this.lBY = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.luw = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.joR = findViewById(R.id.header_round_corner_layout);
        this.jhx = findViewById(R.id.headerContainerLayout);
        this.jhy = l.getDimens(getContext(), R.dimen.tbds520);
        this.jhz = this.jhy;
        this.lBZ = (ImageView) findViewById(R.id.bgContainer);
        this.lCa = (ImageView) findViewById(R.id.bgImage);
        this.luz = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.luz.setOnTouchCallback(this.jKl);
        this.luz.setOnPullRefreshListener(this.jKm);
        this.luz.setFromFrs();
        this.luz.bxJ();
        this.ZS = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.ZS.addOnOffsetChangedListener(this.jiA);
        this.jMh = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.jMh.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jMh.setFadingEdgeLength(0);
        this.jMh.setOverScrollMode(2);
        this.jMh.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.lCb = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.jMh);
        this.gcs = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.luy = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
    }

    public void B(double d) {
        if (this.jhx != null) {
            int i = (int) (this.jhy + (PullRefreshFrameLayout.fle * d));
            ViewGroup.LayoutParams layoutParams = this.jhx.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jhz = layoutParams.height;
                this.jhx.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jhx != null && (layoutParams = this.jhx.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jhz = i;
            this.jhx.setLayoutParams(layoutParams);
        }
    }

    public void cOf() {
        this.jKd = false;
        if (this.luz != null) {
            this.luz.bxI();
        }
    }

    public void bUP() {
        if (this.jKd) {
            cOf();
            e.mB().removeCallbacks(this.jKn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOe() {
        e.mB().postDelayed(this.jKn, 5000L);
        this.jKd = true;
        this.lBY.loadData();
    }

    public void setData(@NonNull List<n> list) {
        this.lCb.setData(list);
        this.jMh.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.gcs.getHeight() > HotTopicListView.this.jMh.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.jhx.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.jhx.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bIl();
    }

    private void bIl() {
        if (!this.lux) {
            this.lux = true;
            SvgManager.bwr().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ao.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0101);
            if (this.lBY instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lBY);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setBackgroundColor(this.luw, R.color.pic_huati_toplist_base_color);
            ao.setImageResource(this.lBZ, R.drawable.pic_huati_toplist_base);
            ao.setImageResource(this.lCa, R.drawable.pic_huati_toplist_upper);
            ao.setBackgroundResource(this.joR, R.drawable.bg_header_round_corner);
            if (this.gCf != null) {
                this.gCf.changeSkin(skinType);
                this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
            this.lCb.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.gLj == null) {
            this.gLj = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gLj.attachView(this.luy, false);
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this.luy);
        }
    }

    public void pU(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.lBY != null) {
                            HotTopicListView.this.lBY.loadData();
                        }
                    }
                });
            }
            this.jhx.setVisibility(8);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.luy, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Zj() {
        if (this.mRefreshView != null) {
            this.jhx.setVisibility(0);
            this.mRefreshView.dettachView(this.luy);
            this.mRefreshView = null;
        }
    }

    public void Zi() {
        this.jMh.setNextPage(this.gCf);
        this.gCf.endLoadData();
        this.gCf.showEmptyView(0);
        this.gCf.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        Zj();
        if (this.jKd) {
            cOf();
        }
        if (this.flz != null) {
            this.flz.cancel();
            this.flz.removeAllListeners();
            this.flz.removeAllUpdateListeners();
            this.flz = null;
        }
        e.mB().removeCallbacks(this.jKn);
    }
}
