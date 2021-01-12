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
/* loaded from: classes7.dex */
public class HotTopicListView extends RelativeLayout {
    private static int lpO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    private AppBarLayout ZQ;
    private ViewGroup fXK;
    private ValueAnimator fgO;
    private g gGD;
    private PbListView gxy;
    private PullRefreshFrameLayout.d jFF;
    private PullRefreshFrameLayout.c jFG;
    private Runnable jFH;
    private boolean jFx;
    private BdTypeRecyclerView jHB;
    private View jcQ;
    private int jcR;
    private int jcS;
    private AppBarLayout.OnOffsetChangedListener jdS;
    private View jkk;
    private View lpQ;
    private boolean lpR;
    private ViewGroup lpS;
    private PullRefreshFrameLayout lpT;
    private b lxs;
    private ImageView lxt;
    private ImageView lxu;
    private com.baidu.tieba.newlist.a.a lxv;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private int mSkinType;

    public HotTopicListView(TbPageContext<?> tbPageContext, b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jFx = false;
        this.lpR = false;
        this.jdS = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (HotTopicListView.this.lpT != null) {
                    HotTopicListView.this.lpT.setInterceptScrollDown(i == 0);
                }
                if (HotTopicListView.lpO + i < 0) {
                    HotTopicListView.this.lpQ.setVisibility(0);
                    HotTopicListView.this.mNavigationBar.setCenterTextTitle(HotTopicListView.this.mNavigationBar.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                HotTopicListView.this.lpQ.setVisibility(8);
                HotTopicListView.this.mNavigationBar.setCenterTextTitle(null);
            }
        };
        this.jFF = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.newlist.HotTopicListView.2
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void q(double d) {
                HotTopicListView.this.v(d);
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                HotTopicListView.this.fgO = ValueAnimator.ofFloat(0.0f, 1.0f);
                HotTopicListView.this.fgO.setDuration(150L);
                final int height = HotTopicListView.this.jcQ.getHeight();
                HotTopicListView.this.fgO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HotTopicListView.this.setHeight((int) (height - (valueAnimator.getAnimatedFraction() * i)));
                    }
                });
                HotTopicListView.this.fgO.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void btT() {
                final int i = HotTopicListView.this.jcS - HotTopicListView.this.jcR;
                if (i > 0) {
                    HotTopicListView.this.fgO = ValueAnimator.ofFloat(0.0f, 1.0f);
                    HotTopicListView.this.fgO.setDuration(300L);
                    final int i2 = HotTopicListView.this.jcS;
                    HotTopicListView.this.fgO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.2.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (HotTopicListView.this.jcQ != null && i2 > 0) {
                                HotTopicListView.this.setHeight((int) (i2 - (floatValue * i)));
                            }
                        }
                    });
                    HotTopicListView.this.fgO.start();
                }
            }
        };
        this.jFH = new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.jFx) {
                    HotTopicListView.this.cKn();
                }
            }
        };
        this.jFG = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.newlist.HotTopicListView.4
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void btS() {
                HotTopicListView.this.cKm();
            }
        };
        this.mPageContext = tbPageContext;
        this.lxs = bVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
        this.lpQ = findViewById(R.id.topBgView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jkk = findViewById(R.id.header_round_corner_layout);
        this.jcQ = findViewById(R.id.headerContainerLayout);
        this.jcR = l.getDimens(getContext(), R.dimen.tbds520);
        this.jcS = this.jcR;
        this.lxt = (ImageView) findViewById(R.id.bgContainer);
        this.lxu = (ImageView) findViewById(R.id.bgImage);
        this.lpT = (PullRefreshFrameLayout) findViewById(R.id.contentLayout);
        this.lpT.setOnTouchCallback(this.jFF);
        this.lpT.setOnPullRefreshListener(this.jFG);
        this.lpT.setFromFrs();
        this.lpT.btP();
        this.ZQ = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.ZQ.addOnOffsetChangedListener(this.jdS);
        this.jHB = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
        this.jHB.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jHB.setFadingEdgeLength(0);
        this.jHB.setOverScrollMode(2);
        this.jHB.setPadding(0, l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.lxv = new com.baidu.tieba.newlist.a.a(this.mPageContext, this.jHB);
        this.fXK = (ViewGroup) findViewById(R.id.contentContainer);
        View findViewById = findViewById(R.id.statusBarViewHolder);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        findViewById.setLayoutParams(layoutParams);
        this.lpS = (ViewGroup) findViewById(R.id.contentRootLayout);
        this.gxy = new PbListView(this.mPageContext.getPageActivity());
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
    }

    public void v(double d) {
        if (this.jcQ != null) {
            int i = (int) (this.jcR + (PullRefreshFrameLayout.fgt * d));
            ViewGroup.LayoutParams layoutParams = this.jcQ.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jcS = layoutParams.height;
                this.jcQ.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jcQ != null && (layoutParams = this.jcQ.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jcS = i;
            this.jcQ.setLayoutParams(layoutParams);
        }
    }

    public void cKn() {
        this.jFx = false;
        if (this.lpT != null) {
            this.lpT.btO();
        }
    }

    public void bQX() {
        if (this.jFx) {
            cKn();
            e.mB().removeCallbacks(this.jFH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKm() {
        e.mB().postDelayed(this.jFH, 5000L);
        this.jFx = true;
        this.lxs.loadData();
    }

    public void setData(@NonNull List<n> list) {
        this.lxv.setData(list);
        this.jHB.post(new Runnable() { // from class: com.baidu.tieba.newlist.HotTopicListView.5
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicListView.this.fXK.getHeight() > HotTopicListView.this.jHB.getHeight()) {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.jcQ.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) HotTopicListView.this.jcQ.getLayoutParams()).setScrollFlags(13);
                }
            }
        });
        bEt();
    }

    private void bEt() {
        if (!this.lpR) {
            this.lpR = true;
            SvgManager.bsx().a((ImageView) this.mNavigationBar.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ao.setViewTextColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0101);
            if (this.lxs instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) this.lxs);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setBackgroundColor(this.lpQ, R.color.pic_huati_toplist_base_color);
            ao.setImageResource(this.lxt, R.drawable.pic_huati_toplist_base);
            ao.setImageResource(this.lxu, R.drawable.pic_huati_toplist_upper);
            ao.setBackgroundResource(this.jkk, R.drawable.bg_header_round_corner);
            if (this.gxy != null) {
                this.gxy.changeSkin(skinType);
                this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
            this.lxv.notifyDataSetChanged();
            this.mSkinType = skinType;
        }
    }

    public void showLoadingView() {
        if (this.gGD == null) {
            this.gGD = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gGD.attachView(this.lpS, false);
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this.lpS);
        }
    }

    public void pQ(boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newlist.HotTopicListView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicListView.this.lxs != null) {
                            HotTopicListView.this.lxs.loadData();
                        }
                    }
                });
            }
            this.jcQ.setVisibility(8);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.mRefreshView.attachView(this.lpS, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Vq() {
        if (this.mRefreshView != null) {
            this.jcQ.setVisibility(0);
            this.mRefreshView.dettachView(this.lpS);
            this.mRefreshView = null;
        }
    }

    public void Vp() {
        this.jHB.setNextPage(this.gxy);
        this.gxy.endLoadData();
        this.gxy.showEmptyView(0);
        this.gxy.setText(getResources().getString(R.string.really_great));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        hideLoadingView();
        Vq();
        if (this.jFx) {
            cKn();
        }
        if (this.fgO != null) {
            this.fgO.cancel();
            this.fgO.removeAllListeners();
            this.fgO.removeAllUpdateListeners();
            this.fgO = null;
        }
        e.mB().removeCallbacks(this.jFH);
    }
}
