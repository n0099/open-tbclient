package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.adapter.a.l;
import com.baidu.tieba.play.i;
import java.util.List;
/* loaded from: classes21.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    private g gAe;
    private PbListView gre;
    private i iBT;
    private BdTypeRecyclerView iYU;
    private RecyclerView.OnScrollListener ick;
    private RecyclerView.OnScrollListener lpA;
    private l lqg;
    private a lqh;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.ick = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fbI;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iBT != null) {
                    HotTopicDetailFeedView.this.iBT.a(HotTopicDetailFeedView.this.iYU.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iYU.getLastVisiblePosition(), this.fbI, true);
                }
                if (HotTopicDetailFeedView.this.lpA != null) {
                    HotTopicDetailFeedView.this.lpA.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fbI = i3 <= 0;
                if (HotTopicDetailFeedView.this.lpA != null) {
                    HotTopicDetailFeedView.this.lpA.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.ick = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fbI;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iBT != null) {
                    HotTopicDetailFeedView.this.iBT.a(HotTopicDetailFeedView.this.iYU.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iYU.getLastVisiblePosition(), this.fbI, true);
                }
                if (HotTopicDetailFeedView.this.lpA != null) {
                    HotTopicDetailFeedView.this.lpA.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fbI = i3 <= 0;
                if (HotTopicDetailFeedView.this.lpA != null) {
                    HotTopicDetailFeedView.this.lpA.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.ick = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fbI;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iBT != null) {
                    HotTopicDetailFeedView.this.iBT.a(HotTopicDetailFeedView.this.iYU.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iYU.getLastVisiblePosition(), this.fbI, true);
                }
                if (HotTopicDetailFeedView.this.lpA != null) {
                    HotTopicDetailFeedView.this.lpA.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fbI = i3 <= 0;
                if (HotTopicDetailFeedView.this.lpA != null) {
                    HotTopicDetailFeedView.this.lpA.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView Gy(int i) {
        this.sortType = i;
        this.lqg.ug(i == 0);
        return this;
    }

    private void init(Context context) {
        e<?> J = com.baidu.adp.base.i.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        if (this.pageContext != null) {
            this.iYU = new BdTypeRecyclerView(context);
            this.iYU.setFadingEdgeLength(0);
            this.iYU.setOverScrollMode(2);
            this.iYU.setVerticalScrollBarEnabled(false);
            this.iYU.setLayoutManager(new LinearLayoutManager(context));
            this.iYU.addOnScrollListener(this.ick);
            this.iYU.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.iYU != null) {
                        HotTopicDetailFeedView.this.iYU.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.lqg = new l(this.pageContext, this.pageContext.getUniqueId(), this.iYU);
            addView(this.iYU);
            ((FrameLayout.LayoutParams) this.iYU.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.iBT == null) {
                this.iBT = new i(this.pageContext, this.iYU);
                this.iBT.IJ(1);
                this.iBT.setUniqueId(this.pageContext.getUniqueId());
            }
            this.iYU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.iBT != null) {
                        HotTopicDetailFeedView.this.iBT.dl(view);
                    }
                }
            });
            this.gre = new PbListView(context);
            this.gre.createView();
            this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gre.setLineGone();
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
            this.iYU.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void ib(boolean z) {
        if (this.gAe == null) {
            this.gAe = new g(getContext());
            this.gAe.bDY();
            this.gAe.onChangeSkinType();
            this.gAe.setWrapStyle(true);
        }
        this.gAe.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this);
            this.gAe = null;
        }
    }

    public void px(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).Go(HotTopicDetailFeedView.this.sortType);
                    }
                }
            });
            this.mRefreshView.setWrapStyle(false);
        }
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        if (z) {
            this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        } else {
            this.mRefreshView.setTitle(getResources().getString(R.string.hot_topic_no_data));
        }
        this.mRefreshView.getAttachedView().setClickable(false);
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gAe != null) {
            this.gAe.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gre.changeSkin(i);
        }
        if (this.lqg != null) {
            this.lqg.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this, R.color.CAM_X0201);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.iBT != null) {
            this.iBT.destroy();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lqh);
    }

    public void resume() {
        if (this.iBT != null) {
            this.iBT.tC(true);
            if (this.iYU != null) {
                this.iBT.a(this.iYU.getFirstVisiblePosition(), this.iYU.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iBT != null) {
            this.iBT.deJ();
            this.iBT.tC(false);
        }
    }

    public void XZ() {
        if (this.iYU != null && this.gre != null) {
            this.iYU.setNextPage(this.gre);
            this.gre.setTextSize(R.dimen.tbfontsize33);
            this.gre.showEmptyView(0);
            this.gre.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.gre.startLoadData();
        }
    }

    public void Ya() {
        if (this.iYU != null && this.gre != null) {
            this.iYU.setNextPage(this.gre);
            this.gre.endLoadData();
            this.gre.showEmptyView(0);
            this.gre.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bTa() {
        if (this.iYU != null && this.gre != null) {
            this.iYU.setNextPage(null);
            this.gre.hideEmptyView();
        }
    }

    public void setData(@NonNull List<q> list) {
        this.lqg.setData(list);
        if (this.iBT != null) {
            this.iBT.a(this.iYU.getFirstVisiblePosition(), this.iYU.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.lpA = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements Runnable {
        int kgU;
        final /* synthetic */ HotTopicDetailFeedView lqi;

        @Override // java.lang.Runnable
        public void run() {
            this.lqi.iYU.smoothScrollBy(Math.abs(this.kgU), 1);
        }
    }
}
