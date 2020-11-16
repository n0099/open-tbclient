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
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.adapter.a.l;
import com.baidu.tieba.play.i;
import java.util.List;
/* loaded from: classes20.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    private PbListView giV;
    private g grV;
    private RecyclerView.OnScrollListener hRq;
    private BdTypeRecyclerView iOd;
    private i irb;
    private l lcG;
    private a lcH;
    private RecyclerView.OnScrollListener lca;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.hRq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean eUl;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.irb != null) {
                    HotTopicDetailFeedView.this.irb.a(HotTopicDetailFeedView.this.iOd.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iOd.getLastVisiblePosition(), this.eUl, true);
                }
                if (HotTopicDetailFeedView.this.lca != null) {
                    HotTopicDetailFeedView.this.lca.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.eUl = i3 <= 0;
                if (HotTopicDetailFeedView.this.lca != null) {
                    HotTopicDetailFeedView.this.lca.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.hRq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean eUl;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.irb != null) {
                    HotTopicDetailFeedView.this.irb.a(HotTopicDetailFeedView.this.iOd.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iOd.getLastVisiblePosition(), this.eUl, true);
                }
                if (HotTopicDetailFeedView.this.lca != null) {
                    HotTopicDetailFeedView.this.lca.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.eUl = i3 <= 0;
                if (HotTopicDetailFeedView.this.lca != null) {
                    HotTopicDetailFeedView.this.lca.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.hRq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean eUl;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.irb != null) {
                    HotTopicDetailFeedView.this.irb.a(HotTopicDetailFeedView.this.iOd.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iOd.getLastVisiblePosition(), this.eUl, true);
                }
                if (HotTopicDetailFeedView.this.lca != null) {
                    HotTopicDetailFeedView.this.lca.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.eUl = i3 <= 0;
                if (HotTopicDetailFeedView.this.lca != null) {
                    HotTopicDetailFeedView.this.lca.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView FJ(int i) {
        this.sortType = i;
        this.lcG.tE(i == 0);
        return this;
    }

    private void init(Context context) {
        e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        if (this.pageContext != null) {
            this.iOd = new BdTypeRecyclerView(context);
            this.iOd.setFadingEdgeLength(0);
            this.iOd.setOverScrollMode(2);
            this.iOd.setVerticalScrollBarEnabled(false);
            this.iOd.setLayoutManager(new LinearLayoutManager(context));
            this.iOd.addOnScrollListener(this.hRq);
            this.iOd.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.iOd != null) {
                        HotTopicDetailFeedView.this.iOd.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.lcG = new l(this.pageContext, this.pageContext.getUniqueId(), this.iOd);
            addView(this.iOd);
            ((FrameLayout.LayoutParams) this.iOd.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.irb == null) {
                this.irb = new i(this.pageContext, this.iOd);
                this.irb.HS(1);
                this.irb.setUniqueId(this.pageContext.getUniqueId());
            }
            this.iOd.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.irb != null) {
                        HotTopicDetailFeedView.this.irb.de(view);
                    }
                }
            });
            this.giV = new PbListView(context);
            this.giV.createView();
            this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.giV.setLineGone();
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
            this.iOd.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void hM(boolean z) {
        if (this.grV == null) {
            this.grV = new g(getContext());
            this.grV.bAw();
            this.grV.onChangeSkinType();
            this.grV.setWrapStyle(true);
        }
        this.grV.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this);
            this.grV = null;
        }
    }

    public void pb(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).Fz(HotTopicDetailFeedView.this.sortType);
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

    public void VB() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.grV != null) {
            this.grV.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.giV.changeSkin(i);
        }
        if (this.lcG != null) {
            this.lcG.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this, R.color.CAM_X0201);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.irb != null) {
            this.irb.destroy();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lcH);
    }

    public void resume() {
        if (this.irb != null) {
            this.irb.ta(true);
            if (this.iOd != null) {
                this.irb.a(this.iOd.getFirstVisiblePosition(), this.iOd.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.irb != null) {
            this.irb.cZy();
            this.irb.ta(false);
        }
    }

    public void Vz() {
        if (this.iOd != null && this.giV != null) {
            this.iOd.setNextPage(this.giV);
            this.giV.setTextSize(R.dimen.tbfontsize33);
            this.giV.showEmptyView(0);
            this.giV.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.giV.startLoadData();
        }
    }

    public void VA() {
        if (this.iOd != null && this.giV != null) {
            this.iOd.setNextPage(this.giV);
            this.giV.endLoadData();
            this.giV.showEmptyView(0);
            this.giV.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bPp() {
        if (this.iOd != null && this.giV != null) {
            this.iOd.setNextPage(null);
            this.giV.hideEmptyView();
        }
    }

    public void setData(@NonNull List<q> list) {
        this.lcG.setData(list);
        if (this.irb != null) {
            this.irb.a(this.iOd.getFirstVisiblePosition(), this.iOd.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.lca = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements Runnable {
        int jTq;
        final /* synthetic */ HotTopicDetailFeedView lcI;

        @Override // java.lang.Runnable
        public void run() {
            this.lcI.iOd.smoothScrollBy(Math.abs(this.jTq), 1);
        }
    }
}
