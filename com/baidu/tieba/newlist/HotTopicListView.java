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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class HotTopicListView extends RelativeLayout {
    private static int jNk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout WW;
    private ViewGroup eRc;
    private ValueAnimator ecC;
    private PbListView fnt;
    private g fwo;
    private View hBP;
    private int hBQ;
    private int hBR;
    private AppBarLayout.OnOffsetChangedListener hCR;
    private View hIl;
    private PullRefreshFrameLayout.b iaE;
    private PullRefreshFrameLayout.a iaF;
    private Runnable iaG;
    private boolean iaw;
    private BdTypeRecyclerView icy;
    private View jNm;
    private boolean jNn;
    private ViewGroup jNo;
    private PullRefreshFrameLayout jNp;
    private b jUP;
    private ImageView jUQ;
    private ImageView jUR;
    private com.baidu.tieba.newlist.a.a jUS;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iaw = false;
        this.jNn = false;
        this.hCR = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.jNp != null) {
                    HotTopicListView.this.jNp.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.jNk + i < 0) {
                    HotTopicListView.this.jNm.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.jNm.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.iaE = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void n(double d) {
                HotTopicListView.this.r(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                HotTopicListView.this.ecC = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.ecC.setDuration(150L);
                final int height = HotTopicListView.this.hBP.getHeight();
                HotTopicListView.this.ecC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.ecC.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void aYh() {
                final int i = HotTopicListView.this.hBR - HotTopicListView.this.hBQ;
                if (i > 0) {
                    HotTopicListView.this.ecC = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.ecC.setDuration(300L);
                    final int i2 = HotTopicListView.this.hBR;
                    HotTopicListView.this.ecC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.hBP != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.ecC.start();
                }
            }
        };
        this.iaG = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.iaw) {
                    HotTopicListView.this.cfG();
                }
            }
        };
        this.iaF = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void aYg() {
                HotTopicListView.this.cfF();
            }
        };
        this.mPageContext = tbPageContext;
        this.jUP = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.jNm = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hIl = findViewById(R.id.header_round_corner_layout);
        this.hBP = findViewById(R.id.headerContainerLayout);
        this.hBQ = l.getDimens(getContext(), R.dimen.tbds520);
        this.hBR = this.hBQ;
        this.jUQ = (ImageView) findViewById(R.id.bgContainer);
        this.jUR = (ImageView) findViewById(R.id.bgImage);
        this.jNp = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.jNp.setOnTouchCallback(this.iaE);
        this.jNp.setOnPullRefreshListener(this.iaF);
        this.jNp.setFromFrs();
        this.jNp.aYf();
        this.WW = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.WW.addOnOffsetChangedListener(this.hCR);
        this.icy = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.icy.setLayoutManager(new LinearLayoutManager(getContext()));
        this.icy.setFadingEdgeLength(0);
        this.icy.setOverScrollMode(2);
        this.icy.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.jUS = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.icy);
        this.eRc = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.jNo = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.fnt = new PbListView(this.mPageContext.getPageActivity());
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void r(double d) {
        if (this.hBP != null) {
            int i = (int) (this.hBQ + (PullRefreshFrameLayout.ecl * d));
            ViewGroup.LayoutParams layoutParams = this.hBP.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hBR = layoutParams.height;
                this.hBP.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.hBP != null && (layoutParams = this.hBP.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hBR = i;
            this.hBP.setLayoutParams(layoutParams);
        }
    }

    public void cfG() {
        this.iaw = false;
        if (this.jNp != null) {
            this.jNp.aYe();
        }
    }

    public void btV() {
        if (this.iaw) {
            cfG();
            e.lt().removeCallbacks(this.iaG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfF() {
        e.lt().postDelayed(this.iaG, 5000L);
        this.iaw = true;
        this.jUP.loadData();
    }

    public void setData(@NonNull List<q> list) {
        this.jUS.setData(list);
        this.icy.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.eRc.getHeight() > HotTopicListView.this.icy.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.hBP.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.hBP.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        biq();
    }

    private void biq() {
        if (!this.jNn) {
            this.jNn = true;
            SvgManager.aWQ().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            an.setViewTextColor(this.mNavigationBar.getCenterText(), (int) R.color.cp_cont_a);
            if (this.jUP instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.jUP);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            an.setBackgroundColor(this.jNm, R.color.pic_huati_toplist_base_color);
            an.setImageResource(this.jUQ, R.drawable.pic_huati_toplist_base);
            an.setImageResource(this.jUR, R.drawable.pic_huati_toplist_upper);
            an.setBackgroundResource(this.hIl, R.drawable.bg_header_round_corner);
            if (this.fnt != null) {
                this.fnt.changeSkin(skinType);
                this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            this.jUS.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.fwo == null) {
            this.fwo = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fwo.attachView(this.jNo, false);
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this.jNo);
        }
    }

    public void mB(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.jUP != null) {
                            HotTopicListView.this.jUP.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.jNo, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void btO() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.jNo);
            this.mRefreshView = null;
        }
    }

    public void buK() {
        this.icy.setNextPage(this.fnt);
        this.fnt.endLoadData();
        this.fnt.showEmptyView(0);
        this.fnt.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        btO();
        if (this.iaw) {
            cfG();
        }
        if (this.ecC != null) {
            this.ecC.cancel();
            this.ecC.removeAllListeners();
            this.ecC.removeAllUpdateListeners();
            this.ecC = null;
        }
        e.lt().removeCallbacks(this.iaG);
    }
}
