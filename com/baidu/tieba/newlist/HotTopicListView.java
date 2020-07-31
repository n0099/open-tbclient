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
import com.baidu.tbadk.core.util.ao;
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
    private static int jVI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout WP;
    private ViewGroup eXx;
    private ValueAnimator eiM;
    private g fBv;
    private PbListView fsC;
    private View hHN;
    private int hHO;
    private int hHP;
    private AppBarLayout.OnOffsetChangedListener hIP;
    private View hOl;
    private PullRefreshFrameLayout.b igG;
    private PullRefreshFrameLayout.a igH;
    private Runnable igI;
    private boolean igy;
    private BdTypeRecyclerView iiA;
    private View jVK;
    private boolean jVL;
    private ViewGroup jVM;
    private PullRefreshFrameLayout jVN;
    private b kdo;
    private ImageView kdp;
    private ImageView kdq;
    private com.baidu.tieba.newlist.a.a kdr;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.igy = false;
        this.jVL = false;
        this.hIP = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.jVN != null) {
                    HotTopicListView.this.jVN.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.jVI + i < 0) {
                    HotTopicListView.this.jVK.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.jVK.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.igG = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void n(double d) {
                HotTopicListView.this.r(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                HotTopicListView.this.eiM = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.eiM.setDuration(150L);
                final int height = HotTopicListView.this.hHN.getHeight();
                HotTopicListView.this.eiM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.eiM.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bch() {
                final int i = HotTopicListView.this.hHP - HotTopicListView.this.hHO;
                if (i > 0) {
                    HotTopicListView.this.eiM = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.eiM.setDuration(300L);
                    final int i2 = HotTopicListView.this.hHP;
                    HotTopicListView.this.eiM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.hHN != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.eiM.start();
                }
            }
        };
        this.igI = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.igy) {
                    HotTopicListView.this.cjf();
                }
            }
        };
        this.igH = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void bcg() {
                HotTopicListView.this.cje();
            }
        };
        this.mPageContext = tbPageContext;
        this.kdo = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.jVK = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hOl = findViewById(R.id.header_round_corner_layout);
        this.hHN = findViewById(R.id.headerContainerLayout);
        this.hHO = l.getDimens(getContext(), R.dimen.tbds520);
        this.hHP = this.hHO;
        this.kdp = (ImageView) findViewById(R.id.bgContainer);
        this.kdq = (ImageView) findViewById(R.id.bgImage);
        this.jVN = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.jVN.setOnTouchCallback(this.igG);
        this.jVN.setOnPullRefreshListener(this.igH);
        this.jVN.setFromFrs();
        this.jVN.bcf();
        this.WP = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.WP.addOnOffsetChangedListener(this.hIP);
        this.iiA = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.iiA.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iiA.setFadingEdgeLength(0);
        this.iiA.setOverScrollMode(2);
        this.iiA.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.kdr = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.iiA);
        this.eXx = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.jVM = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.fsC = new PbListView(this.mPageContext.getPageActivity());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void r(double d) {
        if (this.hHN != null) {
            int i = (int) (this.hHO + (PullRefreshFrameLayout.eiv * d));
            ViewGroup.LayoutParams layoutParams = this.hHN.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hHP = layoutParams.height;
                this.hHN.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.hHN != null && (layoutParams = this.hHN.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hHP = i;
            this.hHN.setLayoutParams(layoutParams);
        }
    }

    public void cjf() {
        this.igy = false;
        if (this.jVN != null) {
            this.jVN.bce();
        }
    }

    public void bxe() {
        if (this.igy) {
            cjf();
            e.lt().removeCallbacks(this.igI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cje() {
        e.lt().postDelayed(this.igI, 5000L);
        this.igy = true;
        this.kdo.loadData();
    }

    public void setData(@NonNull List<q> list) {
        this.kdr.setData(list);
        this.iiA.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.eXx.getHeight() > HotTopicListView.this.iiA.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.hHN.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.hHN.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bmb();
    }

    private void bmb() {
        if (!this.jVL) {
            this.jVL = true;
            SvgManager.baR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ao.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_a);
            if (this.kdo instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.kdo);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setBackgroundColor(this.jVK, R.color.pic_huati_toplist_base_color);
            ao.setImageResource(this.kdp, R.drawable.pic_huati_toplist_base);
            ao.setImageResource(this.kdq, R.drawable.pic_huati_toplist_upper);
            ao.setBackgroundResource(this.hOl, R.drawable.bg_header_round_corner);
            if (this.fsC != null) {
                this.fsC.changeSkin(skinType);
                this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            this.kdr.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.fBv == null) {
            this.fBv = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fBv.attachView(this.jVM, false);
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this.jVM);
        }
    }

    public void ng(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.kdo != null) {
                            HotTopicListView.this.kdo.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.jVM, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void bwX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.jVM);
            this.mRefreshView = null;
        }
    }

    public void bxT() {
        this.iiA.setNextPage(this.fsC);
        this.fsC.endLoadData();
        this.fsC.showEmptyView(0);
        this.fsC.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        bwX();
        if (this.igy) {
            cjf();
        }
        if (this.eiM != null) {
            this.eiM.cancel();
            this.eiM.removeAllListeners();
            this.eiM.removeAllUpdateListeners();
            this.eiM = null;
        }
        e.lt().removeCallbacks(this.igI);
    }
}
