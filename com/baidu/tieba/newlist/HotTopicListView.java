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
    private static int ktM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout XP;
    private ValueAnimator euO;
    private PbListView fHm;
    private g fQf;
    private ViewGroup fld;
    private boolean iCg;
    private PullRefreshFrameLayout.d iCo;
    private PullRefreshFrameLayout.c iCp;
    private Runnable iCq;
    private BdTypeRecyclerView iEj;
    private View icj;
    private int ick;
    private int icl;
    private AppBarLayout.OnOffsetChangedListener idm;
    private View ijC;
    private b kBs;
    private ImageView kBt;
    private ImageView kBu;
    private com.baidu.tieba.newlist.a.a kBv;
    private View ktO;
    private boolean ktP;
    private ViewGroup ktQ;
    private PullRefreshFrameLayout ktR;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iCg = false;
        this.ktP = false;
        this.idm = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.ktR != null) {
                    HotTopicListView.this.ktR.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.ktM + i < 0) {
                    HotTopicListView.this.ktO.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.ktO.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.iCo = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void t(double d) {
                HotTopicListView.this.x(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicListView.this.euO = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.euO.setDuration(150L);
                final int height = HotTopicListView.this.icj.getHeight();
                HotTopicListView.this.euO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.euO.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void blz() {
                final int i = HotTopicListView.this.icl - HotTopicListView.this.ick;
                if (i > 0) {
                    HotTopicListView.this.euO = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.euO.setDuration(300L);
                    final int i2 = HotTopicListView.this.icl;
                    HotTopicListView.this.euO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.icj != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.euO.start();
                }
            }
        };
        this.iCq = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.iCg) {
                    HotTopicListView.this.cxc();
                }
            }
        };
        this.iCp = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bly() {
                HotTopicListView.this.cxb();
            }
        };
        this.mPageContext = tbPageContext;
        this.kBs = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.ktO = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ijC = findViewById(R.id.header_round_corner_layout);
        this.icj = findViewById(R.id.headerContainerLayout);
        this.ick = l.getDimens(getContext(), R.dimen.tbds520);
        this.icl = this.ick;
        this.kBt = (ImageView) findViewById(R.id.bgContainer);
        this.kBu = (ImageView) findViewById(R.id.bgImage);
        this.ktR = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.ktR.setOnTouchCallback(this.iCo);
        this.ktR.setOnPullRefreshListener(this.iCp);
        this.ktR.setFromFrs();
        this.ktR.blw();
        this.XP = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.XP.addOnOffsetChangedListener(this.idm);
        this.iEj = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.iEj.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iEj.setFadingEdgeLength(0);
        this.iEj.setOverScrollMode(2);
        this.iEj.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.kBv = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.iEj);
        this.fld = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.ktQ = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.fHm = new PbListView(this.mPageContext.getPageActivity());
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void x(double d) {
        if (this.icj != null) {
            int i = (int) (this.ick + (PullRefreshFrameLayout.euv * d));
            ViewGroup.LayoutParams layoutParams = this.icj.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.icl = layoutParams.height;
                this.icj.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.icj != null && (layoutParams = this.icj.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.icl = i;
            this.icj.setLayoutParams(layoutParams);
        }
    }

    public void cxc() {
        this.iCg = false;
        if (this.ktR != null) {
            this.ktR.blv();
        }
    }

    public void bHu() {
        if (this.iCg) {
            cxc();
            e.mX().removeCallbacks(this.iCq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxb() {
        e.mX().postDelayed(this.iCq, 5000L);
        this.iCg = true;
        this.kBs.loadData();
    }

    public void setData(@NonNull List<q> list) {
        this.kBv.setData(list);
        this.iEj.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.fld.getHeight() > HotTopicListView.this.iEj.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.icj.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.icj.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bvT();
    }

    private void bvT() {
        if (!this.ktP) {
            this.ktP = true;
            SvgManager.bkl().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_a);
            if (this.kBs instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.kBs);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.ktO, R.color.pic_huati_toplist_base_color);
            ap.setImageResource(this.kBt, R.drawable.pic_huati_toplist_base);
            ap.setImageResource(this.kBu, R.drawable.pic_huati_toplist_upper);
            ap.setBackgroundResource(this.ijC, R.drawable.bg_header_round_corner);
            if (this.fHm != null) {
                this.fHm.changeSkin(skinType);
                this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            this.kBv.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.fQf == null) {
            this.fQf = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fQf.attachView(this.ktQ, false);
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this.ktQ);
        }
    }

    public void nS(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.kBs != null) {
                            HotTopicListView.this.kBs.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.ktQ, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.ktQ);
            this.mRefreshView = null;
        }
    }

    public void bIj() {
        this.iEj.setNextPage(this.fHm);
        this.fHm.endLoadData();
        this.fHm.showEmptyView(0);
        this.fHm.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        bHn();
        if (this.iCg) {
            cxc();
        }
        if (this.euO != null) {
            this.euO.cancel();
            this.euO.removeAllListeners();
            this.euO.removeAllUpdateListeners();
            this.euO = null;
        }
        e.mX().removeCallbacks(this.iCq);
    }
}
