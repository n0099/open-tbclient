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
    private static int kIY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout Yg;
    private ValueAnimator eGY;
    private PbListView fTv;
    private ViewGroup fxr;
    private g gcx;
    private boolean iQW;
    private PullRefreshFrameLayout.d iRe;
    private PullRefreshFrameLayout.c iRf;
    private Runnable iRg;
    private BdTypeRecyclerView iSZ;
    private View irk;
    private int irl;
    private int irm;
    private AppBarLayout.OnOffsetChangedListener ism;
    private View iyz;
    private View kJa;
    private boolean kJb;
    private ViewGroup kJc;
    private PullRefreshFrameLayout kJd;
    private b kQD;
    private ImageView kQE;
    private ImageView kQF;
    private com.baidu.tieba.newlist.a.a kQG;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iQW = false;
        this.kJb = false;
        this.ism = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.kJd != null) {
                    HotTopicListView.this.kJd.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.kIY + i < 0) {
                    HotTopicListView.this.kJa.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.kJa.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.iRe = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                HotTopicListView.this.A(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                HotTopicListView.this.eGY = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.eGY.setDuration(150L);
                final int height = HotTopicListView.this.irk.getHeight();
                HotTopicListView.this.eGY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.eGY.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void boj() {
                final int i = HotTopicListView.this.irm - HotTopicListView.this.irl;
                if (i > 0) {
                    HotTopicListView.this.eGY = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.eGY.setDuration(300L);
                    final int i2 = HotTopicListView.this.irm;
                    HotTopicListView.this.eGY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.irk != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.eGY.start();
                }
            }
        };
        this.iRg = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.iQW) {
                    HotTopicListView.this.cAz();
                }
            }
        };
        this.iRf = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void boi() {
                HotTopicListView.this.cAy();
            }
        };
        this.mPageContext = tbPageContext;
        this.kQD = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.kJa = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iyz = findViewById(R.id.header_round_corner_layout);
        this.irk = findViewById(R.id.headerContainerLayout);
        this.irl = l.getDimens(getContext(), R.dimen.tbds520);
        this.irm = this.irl;
        this.kQE = (ImageView) findViewById(R.id.bgContainer);
        this.kQF = (ImageView) findViewById(R.id.bgImage);
        this.kJd = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.kJd.setOnTouchCallback(this.iRe);
        this.kJd.setOnPullRefreshListener(this.iRf);
        this.kJd.setFromFrs();
        this.kJd.bog();
        this.Yg = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.Yg.addOnOffsetChangedListener(this.ism);
        this.iSZ = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.iSZ.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iSZ.setFadingEdgeLength(0);
        this.iSZ.setOverScrollMode(2);
        this.iSZ.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.kQG = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.iSZ);
        this.fxr = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.kJc = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.fTv = new PbListView(this.mPageContext.getPageActivity());
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void A(double d) {
        if (this.irk != null) {
            int i = (int) (this.irl + (PullRefreshFrameLayout.eGF * d));
            ViewGroup.LayoutParams layoutParams = this.irk.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.irm = layoutParams.height;
                this.irk.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.irk != null && (layoutParams = this.irk.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.irm = i;
            this.irk.setLayoutParams(layoutParams);
        }
    }

    public void cAz() {
        this.iQW = false;
        if (this.kJd != null) {
            this.kJd.bof();
        }
    }

    public void bKf() {
        if (this.iQW) {
            cAz();
            e.mY().removeCallbacks(this.iRg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAy() {
        e.mY().postDelayed(this.iRg, 5000L);
        this.iQW = true;
        this.kQD.loadData();
    }

    public void setData(@NonNull List<q> list) {
        this.kQG.setData(list);
        this.iSZ.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.fxr.getHeight() > HotTopicListView.this.iSZ.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.irk.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.irk.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        byD();
    }

    private void byD() {
        if (!this.kJb) {
            this.kJb = true;
            SvgManager.bmU().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.cp_cont_a);
            if (this.kQD instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.kQD);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.kJa, R.color.pic_huati_toplist_base_color);
            ap.setImageResource(this.kQE, R.drawable.pic_huati_toplist_base);
            ap.setImageResource(this.kQF, R.drawable.pic_huati_toplist_upper);
            ap.setBackgroundResource(this.iyz, R.drawable.bg_header_round_corner);
            if (this.fTv != null) {
                this.fTv.changeSkin(skinType);
                this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            this.kQG.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.gcx == null) {
            this.gcx = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gcx.attachView(this.kJc, false);
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this.kJc);
        }
    }

    public void ox(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.kQD != null) {
                            HotTopicListView.this.kQD.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.kJc, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void SK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.kJc);
            this.mRefreshView = null;
        }
    }

    public void SJ() {
        this.iSZ.setNextPage(this.fTv);
        this.fTv.endLoadData();
        this.fTv.showEmptyView(0);
        this.fTv.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        SK();
        if (this.iQW) {
            cAz();
        }
        if (this.eGY != null) {
            this.eGY.cancel();
            this.eGY.removeAllListeners();
            this.eGY.removeAllUpdateListeners();
            this.eGY = null;
        }
        e.mY().removeCallbacks(this.iRg);
    }
}
