package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.adapter.a.l;
import com.baidu.tieba.play.m;
import java.util.List;
/* loaded from: classes8.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    private PbListView fnt;
    private g fwo;
    private RecyclerView.OnScrollListener gKd;
    private BdTypeRecyclerView hEN;
    private m hjm;
    private RecyclerView.OnScrollListener jNA;
    private l jOg;
    private a jOh;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.gKd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hjr;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hjm != null) {
                    HotTopicDetailFeedView.this.hjm.a(HotTopicDetailFeedView.this.hEN.getFirstVisiblePosition(), HotTopicDetailFeedView.this.hEN.getLastVisiblePosition(), this.hjr, true);
                }
                if (HotTopicDetailFeedView.this.jNA != null) {
                    HotTopicDetailFeedView.this.jNA.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hjr = i3 <= 0;
                if (HotTopicDetailFeedView.this.jNA != null) {
                    HotTopicDetailFeedView.this.jNA.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.gKd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hjr;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hjm != null) {
                    HotTopicDetailFeedView.this.hjm.a(HotTopicDetailFeedView.this.hEN.getFirstVisiblePosition(), HotTopicDetailFeedView.this.hEN.getLastVisiblePosition(), this.hjr, true);
                }
                if (HotTopicDetailFeedView.this.jNA != null) {
                    HotTopicDetailFeedView.this.jNA.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hjr = i3 <= 0;
                if (HotTopicDetailFeedView.this.jNA != null) {
                    HotTopicDetailFeedView.this.jNA.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.gKd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hjr;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hjm != null) {
                    HotTopicDetailFeedView.this.hjm.a(HotTopicDetailFeedView.this.hEN.getFirstVisiblePosition(), HotTopicDetailFeedView.this.hEN.getLastVisiblePosition(), this.hjr, true);
                }
                if (HotTopicDetailFeedView.this.jNA != null) {
                    HotTopicDetailFeedView.this.jNA.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hjr = i3 <= 0;
                if (HotTopicDetailFeedView.this.jNA != null) {
                    HotTopicDetailFeedView.this.jNA.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView AG(int i) {
        this.sortType = i;
        this.jOg.qZ(i == 0);
        return this;
    }

    private void init(Context context) {
        e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        if (this.pageContext != null) {
            this.hEN = new BdTypeRecyclerView(context);
            this.hEN.setFadingEdgeLength(0);
            this.hEN.setOverScrollMode(2);
            this.hEN.setVerticalScrollBarEnabled(false);
            this.hEN.setLayoutManager(new LinearLayoutManager(context));
            this.hEN.addOnScrollListener(this.gKd);
            this.hEN.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.hEN != null) {
                        HotTopicDetailFeedView.this.hEN.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.jOg = new l(this.pageContext, this.pageContext.getUniqueId(), this.hEN);
            addView(this.hEN);
            ((FrameLayout.LayoutParams) this.hEN.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.hjm == null) {
                this.hjm = new m(this.pageContext, this.hEN);
                this.hjm.CN(1);
                this.hjm.setUniqueId(this.pageContext.getUniqueId());
            }
            this.hEN.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.hjm != null) {
                        HotTopicDetailFeedView.this.hjm.cu(view);
                    }
                }
            });
            this.fnt = new PbListView(context);
            this.fnt.createView();
            this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fnt.setLineGone();
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
            this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
            this.hEN.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void ga(boolean z) {
        if (this.fwo == null) {
            this.fwo = new g(getContext());
            this.fwo.bgC();
            this.fwo.onChangeSkinType();
            this.fwo.setWrapStyle(true);
        }
        this.fwo.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this);
            this.fwo = null;
        }
    }

    public void mB(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).Aw(HotTopicDetailFeedView.this.sortType);
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

    public void btN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fwo != null) {
            this.fwo.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
            this.fnt.changeSkin(i);
        }
        if (this.jOg != null) {
            this.jOg.notifyDataSetChanged();
        }
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.hjm != null) {
            this.hjm.destroy();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jOh);
    }

    public void resume() {
        if (this.hjm != null) {
            this.hjm.qs(true);
            if (this.hEN != null) {
                this.hjm.a(this.hEN.getFirstVisiblePosition(), this.hEN.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hjm != null) {
            this.hjm.cym();
            this.hjm.qs(false);
        }
    }

    public void buI() {
        if (this.hEN != null && this.fnt != null) {
            this.hEN.setNextPage(this.fnt);
            this.fnt.setTextSize(R.dimen.tbfontsize33);
            this.fnt.showEmptyView(0);
            this.fnt.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.fnt.startLoadData();
        }
    }

    public void buJ() {
        if (this.hEN != null && this.fnt != null) {
            this.hEN.setNextPage(this.fnt);
            this.fnt.endLoadData();
            this.fnt.showEmptyView(0);
            this.fnt.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void buK() {
        if (this.hEN != null && this.fnt != null) {
            this.hEN.setNextPage(null);
            this.fnt.hideEmptyView();
        }
    }

    public void setData(@NonNull List<q> list) {
        this.jOg.setData(list);
        if (this.hjm != null) {
            this.hjm.a(this.hEN.getFirstVisiblePosition(), this.hEN.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jNA = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        int iHv;
        final /* synthetic */ HotTopicDetailFeedView jOi;

        @Override // java.lang.Runnable
        public void run() {
            this.jOi.hEN.smoothScrollBy(Math.abs(this.iHv), 1);
        }
    }
}
