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
/* loaded from: classes21.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    private PbListView gjo;
    private g gso;
    private RecyclerView.OnScrollListener hQQ;
    private BdTypeRecyclerView iNq;
    private i iqn;
    private RecyclerView.OnScrollListener lbI;
    private l lco;
    private a lcp;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.hQQ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean iqs;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iqn != null) {
                    HotTopicDetailFeedView.this.iqn.a(HotTopicDetailFeedView.this.iNq.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iNq.getLastVisiblePosition(), this.iqs, true);
                }
                if (HotTopicDetailFeedView.this.lbI != null) {
                    HotTopicDetailFeedView.this.lbI.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.iqs = i3 <= 0;
                if (HotTopicDetailFeedView.this.lbI != null) {
                    HotTopicDetailFeedView.this.lbI.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.hQQ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean iqs;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iqn != null) {
                    HotTopicDetailFeedView.this.iqn.a(HotTopicDetailFeedView.this.iNq.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iNq.getLastVisiblePosition(), this.iqs, true);
                }
                if (HotTopicDetailFeedView.this.lbI != null) {
                    HotTopicDetailFeedView.this.lbI.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.iqs = i3 <= 0;
                if (HotTopicDetailFeedView.this.lbI != null) {
                    HotTopicDetailFeedView.this.lbI.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.hQQ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean iqs;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iqn != null) {
                    HotTopicDetailFeedView.this.iqn.a(HotTopicDetailFeedView.this.iNq.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iNq.getLastVisiblePosition(), this.iqs, true);
                }
                if (HotTopicDetailFeedView.this.lbI != null) {
                    HotTopicDetailFeedView.this.lbI.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.iqs = i3 <= 0;
                if (HotTopicDetailFeedView.this.lbI != null) {
                    HotTopicDetailFeedView.this.lbI.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView Fl(int i) {
        this.sortType = i;
        this.lco.tB(i == 0);
        return this;
    }

    private void init(Context context) {
        e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        if (this.pageContext != null) {
            this.iNq = new BdTypeRecyclerView(context);
            this.iNq.setFadingEdgeLength(0);
            this.iNq.setOverScrollMode(2);
            this.iNq.setVerticalScrollBarEnabled(false);
            this.iNq.setLayoutManager(new LinearLayoutManager(context));
            this.iNq.addOnScrollListener(this.hQQ);
            this.iNq.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.iNq != null) {
                        HotTopicDetailFeedView.this.iNq.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.lco = new l(this.pageContext, this.pageContext.getUniqueId(), this.iNq);
            addView(this.iNq);
            ((FrameLayout.LayoutParams) this.iNq.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.iqn == null) {
                this.iqn = new i(this.pageContext, this.iNq);
                this.iqn.Hu(1);
                this.iqn.setUniqueId(this.pageContext.getUniqueId());
            }
            this.iNq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.iqn != null) {
                        HotTopicDetailFeedView.this.iqn.da(view);
                    }
                }
            });
            this.gjo = new PbListView(context);
            this.gjo.createView();
            this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.gjo.setLineGone();
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
            this.iNq.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void hJ(boolean z) {
        if (this.gso == null) {
            this.gso = new g(getContext());
            this.gso.bBg();
            this.gso.onChangeSkinType();
            this.gso.setWrapStyle(true);
        }
        this.gso.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this);
            this.gso = null;
        }
    }

    public void oY(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).Fb(HotTopicDetailFeedView.this.sortType);
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

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gso != null) {
            this.gso.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gjo.changeSkin(i);
        }
        if (this.lco != null) {
            this.lco.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.iqn != null) {
            this.iqn.destroy();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lcp);
    }

    public void resume() {
        if (this.iqn != null) {
            this.iqn.sX(true);
            if (this.iNq != null) {
                this.iqn.a(this.iNq.getFirstVisiblePosition(), this.iNq.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iqn != null) {
            this.iqn.dab();
            this.iqn.sX(false);
        }
    }

    public void Wi() {
        if (this.iNq != null && this.gjo != null) {
            this.iNq.setNextPage(this.gjo);
            this.gjo.setTextSize(R.dimen.tbfontsize33);
            this.gjo.showEmptyView(0);
            this.gjo.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.gjo.startLoadData();
        }
    }

    public void Wj() {
        if (this.iNq != null && this.gjo != null) {
            this.iNq.setNextPage(this.gjo);
            this.gjo.endLoadData();
            this.gjo.showEmptyView(0);
            this.gjo.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bPW() {
        if (this.iNq != null && this.gjo != null) {
            this.iNq.setNextPage(null);
            this.gjo.hideEmptyView();
        }
    }

    public void setData(@NonNull List<q> list) {
        this.lco.setData(list);
        if (this.iqn != null) {
            this.iqn.a(this.iNq.getFirstVisiblePosition(), this.iNq.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.lbI = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements Runnable {
        int jSG;
        final /* synthetic */ HotTopicDetailFeedView lcq;

        @Override // java.lang.Runnable
        public void run() {
            this.lcq.iNq.smoothScrollBy(Math.abs(this.jSG), 1);
        }
    }
}
