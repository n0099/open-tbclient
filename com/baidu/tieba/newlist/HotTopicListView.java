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
    private static int jVK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout WP;
    private ViewGroup eXx;
    private ValueAnimator eiM;
    private g fBv;
    private PbListView fsC;
    private View hHN;
    private int hHO;
    private int hHP;
    private AppBarLayout.OnOffsetChangedListener hIP;
    private View hOn;
    private boolean igA;
    private PullRefreshFrameLayout.b igI;
    private PullRefreshFrameLayout.a igJ;
    private Runnable igK;
    private BdTypeRecyclerView iiC;
    private View jVM;
    private boolean jVN;
    private ViewGroup jVO;
    private PullRefreshFrameLayout jVP;
    private b kdq;
    private ImageView kdr;
    private ImageView kds;
    private com.baidu.tieba.newlist.a.a kdt;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.igA = false;
        this.jVN = false;
        this.hIP = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.jVP != null) {
                    HotTopicListView.this.jVP.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.jVK + i < 0) {
                    HotTopicListView.this.jVM.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.jVM.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.igI = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
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
        this.igK = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.igA) {
                    HotTopicListView.this.cjf();
                }
            }
        };
        this.igJ = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void bcg() {
                HotTopicListView.this.cje();
            }
        };
        this.mPageContext = tbPageContext;
        this.kdq = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.jVM = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hOn = findViewById(R.id.header_round_corner_layout);
        this.hHN = findViewById(R.id.headerContainerLayout);
        this.hHO = l.getDimens(getContext(), R.dimen.tbds520);
        this.hHP = this.hHO;
        this.kdr = (ImageView) findViewById(R.id.bgContainer);
        this.kds = (ImageView) findViewById(R.id.bgImage);
        this.jVP = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.jVP.setOnTouchCallback(this.igI);
        this.jVP.setOnPullRefreshListener(this.igJ);
        this.jVP.setFromFrs();
        this.jVP.bcf();
        this.WP = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.WP.addOnOffsetChangedListener(this.hIP);
        this.iiC = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.iiC.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iiC.setFadingEdgeLength(0);
        this.iiC.setOverScrollMode(2);
        this.iiC.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.kdt = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.iiC);
        this.eXx = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.jVO = (ViewGroup) findViewById(R.id.contentRootLayout);
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
        this.igA = false;
        if (this.jVP != null) {
            this.jVP.bce();
        }
    }

    public void bxe() {
        if (this.igA) {
            cjf();
            e.lt().removeCallbacks(this.igK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cje() {
        e.lt().postDelayed(this.igK, 5000L);
        this.igA = true;
        this.kdq.loadData();
    }

    public void setData(@NonNull List<q> list) {
        this.kdt.setData(list);
        this.iiC.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.eXx.getHeight() > HotTopicListView.this.iiC.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.hHN.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.hHN.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bmb();
    }

    private void bmb() {
        if (!this.jVN) {
            this.jVN = true;
            SvgManager.baR().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ao.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_a);
            if (this.kdq instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.kdq);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setBackgroundColor(this.jVM, R.color.pic_huati_toplist_base_color);
            ao.setImageResource(this.kdr, R.drawable.pic_huati_toplist_base);
            ao.setImageResource(this.kds, R.drawable.pic_huati_toplist_upper);
            ao.setBackgroundResource(this.hOn, R.drawable.bg_header_round_corner);
            if (this.fsC != null) {
                this.fsC.changeSkin(skinType);
                this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            this.kdt.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.fBv == null) {
            this.fBv = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fBv.attachView(this.jVO, false);
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this.jVO);
        }
    }

    public void ng(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.kdq != null) {
                            HotTopicListView.this.kdq.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.jVO, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void bwX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.jVO);
            this.mRefreshView = null;
        }
    }

    public void bxT() {
        this.iiC.setNextPage(this.fsC);
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
        if (this.igA) {
            cjf();
        }
        if (this.eiM != null) {
            this.eiM.cancel();
            this.eiM.removeAllListeners();
            this.eiM.removeAllUpdateListeners();
            this.eiM = null;
        }
        e.lt().removeCallbacks(this.igK);
    }
}
