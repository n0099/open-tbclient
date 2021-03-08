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
/* loaded from: classes7.dex */
public class HotTopicListView extends RelativeLayout {
    private static int lAj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout abf;
    private ValueAnimator fkG;
    private PbListView gCf;
    private g gLk;
    private ViewGroup gbB;
    private boolean jMY;
    private PullRefreshFrameLayout.d jNg;
    private PullRefreshFrameLayout.c jNh;
    private Runnable jNi;
    private BdTypeRecyclerView jPc;
    private View jku;
    private int jkv;
    private int jkw;
    private AppBarLayout.OnOffsetChangedListener jlw;
    private View jrO;
    private View lAl;
    private boolean lAm;
    private ViewGroup lAn;
    private PullRefreshFrameLayout lAo;
    private b lHM;
    private ImageView lHN;
    private ImageView lHO;
    private com.baidu.tieba.newlist.a.a lHP;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jMY = false;
        this.lAm = false;
        this.jlw = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.lAo != null) {
                    HotTopicListView.this.lAo.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.lAj + i < 0) {
                    HotTopicListView.this.lAl.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.lAl.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.jNg = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void q(double d) {
                HotTopicListView.this.v(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                HotTopicListView.this.fkG = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.fkG.setDuration(150L);
                final int height = HotTopicListView.this.jku.getHeight();
                HotTopicListView.this.fkG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.fkG.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void buq() {
                final int i = HotTopicListView.this.jkw - HotTopicListView.this.jkv;
                if (i > 0) {
                    HotTopicListView.this.fkG = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.fkG.setDuration(300L);
                    final int i2 = HotTopicListView.this.jkw;
                    HotTopicListView.this.fkG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.jku != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.fkG.start();
                }
            }
        };
        this.jNi = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.jMY) {
                    HotTopicListView.this.cLO();
                }
            }
        };
        this.jNh = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bup() {
                HotTopicListView.this.cLN();
            }
        };
        this.mPageContext = tbPageContext;
        this.lHM = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.lAl = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jrO = findViewById(R.id.header_round_corner_layout);
        this.jku = findViewById(R.id.headerContainerLayout);
        this.jkv = l.getDimens(getContext(), R.dimen.tbds520);
        this.jkw = this.jkv;
        this.lHN = (ImageView) findViewById(R.id.bgContainer);
        this.lHO = (ImageView) findViewById(R.id.bgImage);
        this.lAo = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lAo.setOnTouchCallback(this.jNg);
        this.lAo.setOnPullRefreshListener(this.jNh);
        this.lAo.setFromFrs();
        this.lAo.bum();
        this.abf = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.abf.addOnOffsetChangedListener(this.jlw);
        this.jPc = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.jPc.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jPc.setFadingEdgeLength(0);
        this.jPc.setOverScrollMode(2);
        this.jPc.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.lHP = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.jPc);
        this.gbB = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.lAn = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
    }

    public void v(double d) {
        if (this.jku != null) {
            int i = (int) (this.jkv + (PullRefreshFrameLayout.fkl * d));
            ViewGroup.LayoutParams layoutParams = this.jku.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jkw = layoutParams.height;
                this.jku.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jku != null && (layoutParams = this.jku.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jkw = i;
            this.jku.setLayoutParams(layoutParams);
        }
    }

    public void cLO() {
        this.jMY = false;
        if (this.lAo != null) {
            this.lAo.bul();
        }
    }

    public void bRO() {
        if (this.jMY) {
            cLO();
            e.mA().removeCallbacks(this.jNi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLN() {
        e.mA().postDelayed(this.jNi, 5000L);
        this.jMY = true;
        this.lHM.loadData();
    }

    public void setData(@NonNull List<n> list) {
        this.lHP.setData(list);
        this.jPc.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.gbB.getHeight() > HotTopicListView.this.jPc.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.jku.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.jku.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bEP();
    }

    private void bEP() {
        if (!this.lAm) {
            this.lAm = true;
            SvgManager.bsU().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0101);
            if (this.lHM instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lHM);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.lAl, R.color.pic_huati_toplist_base_color);
            ap.setImageResource(this.lHN, R.drawable.pic_huati_toplist_base);
            ap.setImageResource(this.lHO, R.drawable.pic_huati_toplist_upper);
            ap.setBackgroundResource(this.jrO, R.drawable.bg_header_round_corner);
            if (this.gCf != null) {
                this.gCf.changeSkin(skinType);
                this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
            this.lHP.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.gLk == null) {
            this.gLk = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gLk.attachView(this.lAn, false);
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this.lAn);
        }
    }

    public void qa(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.lHM != null) {
                            HotTopicListView.this.lHM.loadData();
                        }
                    }
                });
            }
            this.jku.setVisibility(8);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lAn, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Xc() {
        if (this.mRefreshView != null) {
            this.jku.setVisibility(0);
            this.mRefreshView.dettachView(this.lAn);
            this.mRefreshView = null;
        }
    }

    public void Xb() {
        this.jPc.setNextPage(this.gCf);
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
        Xc();
        if (this.jMY) {
            cLO();
        }
        if (this.fkG != null) {
            this.fkG.cancel();
            this.fkG.removeAllListeners();
            this.fkG.removeAllUpdateListeners();
            this.fkG = null;
        }
        e.mA().removeCallbacks(this.jNi);
    }
}
