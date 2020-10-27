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
    private static int kVv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout Yh;
    private ValueAnimator ePu;
    private ViewGroup fFM;
    private PbListView gdy;
    private g gmB;
    private View iDG;
    private int iDH;
    private int iDI;
    private AppBarLayout.OnOffsetChangedListener iEI;
    private View iKV;
    private PullRefreshFrameLayout.d jdA;
    private PullRefreshFrameLayout.c jdB;
    private Runnable jdC;
    private boolean jds;
    private BdTypeRecyclerView jfv;
    private PullRefreshFrameLayout kVA;
    private View kVx;
    private boolean kVy;
    private ViewGroup kVz;
    private b ldb;
    private ImageView ldc;
    private ImageView ldd;
    private com.baidu.tieba.newlist.a.a lde;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jds = false;
        this.kVy = false;
        this.iEI = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.kVA != null) {
                    HotTopicListView.this.kVA.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.kVv + i < 0) {
                    HotTopicListView.this.kVx.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.kVx.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.jdA = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void x(double d) {
                HotTopicListView.this.B(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicListView.this.ePu = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.ePu.setDuration(150L);
                final int height = HotTopicListView.this.iDG.getHeight();
                HotTopicListView.this.ePu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.ePu.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bqc() {
                final int i = HotTopicListView.this.iDI - HotTopicListView.this.iDH;
                if (i > 0) {
                    HotTopicListView.this.ePu = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.ePu.setDuration(300L);
                    final int i2 = HotTopicListView.this.iDI;
                    HotTopicListView.this.ePu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.iDG != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.ePu.start();
                }
            }
        };
        this.jdC = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.jds) {
                    HotTopicListView.this.cDG();
                }
            }
        };
        this.jdB = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bqb() {
                HotTopicListView.this.cDF();
            }
        };
        this.mPageContext = tbPageContext;
        this.ldb = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.kVx = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iKV = findViewById(R.id.header_round_corner_layout);
        this.iDG = findViewById(R.id.headerContainerLayout);
        this.iDH = l.getDimens(getContext(), R.dimen.tbds520);
        this.iDI = this.iDH;
        this.ldc = (ImageView) findViewById(R.id.bgContainer);
        this.ldd = (ImageView) findViewById(R.id.bgImage);
        this.kVA = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.kVA.setOnTouchCallback(this.jdA);
        this.kVA.setOnPullRefreshListener(this.jdB);
        this.kVA.setFromFrs();
        this.kVA.bpZ();
        this.Yh = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.Yh.addOnOffsetChangedListener(this.iEI);
        this.jfv = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.jfv.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jfv.setFadingEdgeLength(0);
        this.jfv.setOverScrollMode(2);
        this.jfv.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.lde = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.jfv);
        this.fFM = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.kVz = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.gdy = new PbListView(this.mPageContext.getPageActivity());
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void B(double d) {
        if (this.iDG != null) {
            int i = (int) (this.iDH + (PullRefreshFrameLayout.ePb * d));
            ViewGroup.LayoutParams layoutParams = this.iDG.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iDI = layoutParams.height;
                this.iDG.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.iDG != null && (layoutParams = this.iDG.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iDI = i;
            this.iDG.setLayoutParams(layoutParams);
        }
    }

    public void cDG() {
        this.jds = false;
        if (this.kVA != null) {
            this.kVA.bpY();
        }
    }

    public void bMH() {
        if (this.jds) {
            cDG();
            e.mY().removeCallbacks(this.jdC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDF() {
        e.mY().postDelayed(this.jdC, 5000L);
        this.jds = true;
        this.ldb.loadData();
    }

    public void setData(@NonNull List<q> list) {
        this.lde.setData(list);
        this.jfv.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.fFM.getHeight() > HotTopicListView.this.jfv.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.iDG.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.iDG.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bAw();
    }

    private void bAw() {
        if (!this.kVy) {
            this.kVy = true;
            SvgManager.boN().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_a);
            if (this.ldb instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.ldb);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.kVx, R.color.pic_huati_toplist_base_color);
            ap.setImageResource(this.ldc, R.drawable.pic_huati_toplist_base);
            ap.setImageResource(this.ldd, R.drawable.pic_huati_toplist_upper);
            ap.setBackgroundResource(this.iKV, R.drawable.bg_header_round_corner);
            if (this.gdy != null) {
                this.gdy.changeSkin(skinType);
                this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            this.lde.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.gmB == null) {
            this.gmB = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gmB.attachView(this.kVz, false);
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this.kVz);
        }
    }

    public void oP(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.ldb != null) {
                            HotTopicListView.this.ldb.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.kVz, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void TK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.kVz);
            this.mRefreshView = null;
        }
    }

    public void TJ() {
        this.jfv.setNextPage(this.gdy);
        this.gdy.endLoadData();
        this.gdy.showEmptyView(0);
        this.gdy.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        TK();
        if (this.jds) {
            cDG();
        }
        if (this.ePu != null) {
            this.ePu.cancel();
            this.ePu.removeAllListeners();
            this.ePu.removeAllUpdateListeners();
            this.ePu = null;
        }
        e.mY().removeCallbacks(this.jdC);
    }
}
