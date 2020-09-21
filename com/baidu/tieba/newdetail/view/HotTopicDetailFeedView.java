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
    private PbListView fHm;
    private g fQf;
    private i hIT;
    private RecyclerView.OnScrollListener hjC;
    private BdTypeRecyclerView iga;
    private l kuI;
    private a kuJ;
    private RecyclerView.OnScrollListener kuc;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.hjC = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hIY;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hIT != null) {
                    HotTopicDetailFeedView.this.hIT.a(HotTopicDetailFeedView.this.iga.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iga.getLastVisiblePosition(), this.hIY, true);
                }
                if (HotTopicDetailFeedView.this.kuc != null) {
                    HotTopicDetailFeedView.this.kuc.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hIY = i3 <= 0;
                if (HotTopicDetailFeedView.this.kuc != null) {
                    HotTopicDetailFeedView.this.kuc.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.hjC = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hIY;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hIT != null) {
                    HotTopicDetailFeedView.this.hIT.a(HotTopicDetailFeedView.this.iga.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iga.getLastVisiblePosition(), this.hIY, true);
                }
                if (HotTopicDetailFeedView.this.kuc != null) {
                    HotTopicDetailFeedView.this.kuc.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hIY = i3 <= 0;
                if (HotTopicDetailFeedView.this.kuc != null) {
                    HotTopicDetailFeedView.this.kuc.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.hjC = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hIY;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hIT != null) {
                    HotTopicDetailFeedView.this.hIT.a(HotTopicDetailFeedView.this.iga.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iga.getLastVisiblePosition(), this.hIY, true);
                }
                if (HotTopicDetailFeedView.this.kuc != null) {
                    HotTopicDetailFeedView.this.kuc.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hIY = i3 <= 0;
                if (HotTopicDetailFeedView.this.kuc != null) {
                    HotTopicDetailFeedView.this.kuc.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView DZ(int i) {
        this.sortType = i;
        this.kuI.su(i == 0);
        return this;
    }

    private void init(Context context) {
        e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        if (this.pageContext != null) {
            this.iga = new BdTypeRecyclerView(context);
            this.iga.setFadingEdgeLength(0);
            this.iga.setOverScrollMode(2);
            this.iga.setVerticalScrollBarEnabled(false);
            this.iga.setLayoutManager(new LinearLayoutManager(context));
            this.iga.addOnScrollListener(this.hjC);
            this.iga.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.iga != null) {
                        HotTopicDetailFeedView.this.iga.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.kuI = new l(this.pageContext, this.pageContext.getUniqueId(), this.iga);
            addView(this.iga);
            ((FrameLayout.LayoutParams) this.iga.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.hIT == null) {
                this.hIT = new i(this.pageContext, this.iga);
                this.hIT.Gi(1);
                this.hIT.setUniqueId(this.pageContext.getUniqueId());
            }
            this.iga.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.hIT != null) {
                        HotTopicDetailFeedView.this.hIT.cN(view);
                    }
                }
            });
            this.fHm = new PbListView(context);
            this.fHm.createView();
            this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fHm.setLineGone();
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
            this.iga.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void gR(boolean z) {
        if (this.fQf == null) {
            this.fQf = new g(getContext());
            this.fQf.bue();
            this.fQf.onChangeSkinType();
            this.fQf.setWrapStyle(true);
        }
        this.fQf.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this);
            this.fQf = null;
        }
    }

    public void nS(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).DP(HotTopicDetailFeedView.this.sortType);
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

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fQf != null) {
            this.fQf.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fHm.changeSkin(i);
        }
        if (this.kuI != null) {
            this.kuI.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.hIT != null) {
            this.hIT.destroy();
        }
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.kuJ);
    }

    public void resume() {
        if (this.hIT != null) {
            this.hIT.rP(true);
            if (this.iga != null) {
                this.hIT.a(this.iga.getFirstVisiblePosition(), this.iga.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hIT != null) {
            this.hIT.cQJ();
            this.hIT.rP(false);
        }
    }

    public void bIi() {
        if (this.iga != null && this.fHm != null) {
            this.iga.setNextPage(this.fHm);
            this.fHm.setTextSize(R.dimen.tbfontsize33);
            this.fHm.showEmptyView(0);
            this.fHm.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.fHm.startLoadData();
        }
    }

    public void bIj() {
        if (this.iga != null && this.fHm != null) {
            this.iga.setNextPage(this.fHm);
            this.fHm.endLoadData();
            this.fHm.showEmptyView(0);
            this.fHm.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bIk() {
        if (this.iga != null && this.fHm != null) {
            this.iga.setNextPage(null);
            this.fHm.hideEmptyView();
        }
    }

    public void setData(@NonNull List<q> list) {
        this.kuI.setData(list);
        if (this.hIT != null) {
            this.hIT.a(this.iga.getFirstVisiblePosition(), this.iga.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.kuc = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements Runnable {
        int jlm;
        final /* synthetic */ HotTopicDetailFeedView kuK;

        @Override // java.lang.Runnable
        public void run() {
            this.kuK.iga.smoothScrollBy(Math.abs(this.jlm), 1);
        }
    }
}
