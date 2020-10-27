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
    private PbListView gdy;
    private g gmB;
    private RecyclerView.OnScrollListener hKT;
    private BdTypeRecyclerView iHt;
    private i iko;
    private RecyclerView.OnScrollListener kVL;
    private l kWr;
    private a kWs;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.hKT = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean ikt;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iko != null) {
                    HotTopicDetailFeedView.this.iko.a(HotTopicDetailFeedView.this.iHt.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iHt.getLastVisiblePosition(), this.ikt, true);
                }
                if (HotTopicDetailFeedView.this.kVL != null) {
                    HotTopicDetailFeedView.this.kVL.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.ikt = i3 <= 0;
                if (HotTopicDetailFeedView.this.kVL != null) {
                    HotTopicDetailFeedView.this.kVL.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.hKT = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean ikt;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iko != null) {
                    HotTopicDetailFeedView.this.iko.a(HotTopicDetailFeedView.this.iHt.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iHt.getLastVisiblePosition(), this.ikt, true);
                }
                if (HotTopicDetailFeedView.this.kVL != null) {
                    HotTopicDetailFeedView.this.kVL.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.ikt = i3 <= 0;
                if (HotTopicDetailFeedView.this.kVL != null) {
                    HotTopicDetailFeedView.this.kVL.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.hKT = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean ikt;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iko != null) {
                    HotTopicDetailFeedView.this.iko.a(HotTopicDetailFeedView.this.iHt.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iHt.getLastVisiblePosition(), this.ikt, true);
                }
                if (HotTopicDetailFeedView.this.kVL != null) {
                    HotTopicDetailFeedView.this.kVL.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.ikt = i3 <= 0;
                if (HotTopicDetailFeedView.this.kVL != null) {
                    HotTopicDetailFeedView.this.kVL.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView EY(int i) {
        this.sortType = i;
        this.kWr.ts(i == 0);
        return this;
    }

    private void init(Context context) {
        e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        if (this.pageContext != null) {
            this.iHt = new BdTypeRecyclerView(context);
            this.iHt.setFadingEdgeLength(0);
            this.iHt.setOverScrollMode(2);
            this.iHt.setVerticalScrollBarEnabled(false);
            this.iHt.setLayoutManager(new LinearLayoutManager(context));
            this.iHt.addOnScrollListener(this.hKT);
            this.iHt.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.iHt != null) {
                        HotTopicDetailFeedView.this.iHt.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.kWr = new l(this.pageContext, this.pageContext.getUniqueId(), this.iHt);
            addView(this.iHt);
            ((FrameLayout.LayoutParams) this.iHt.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.iko == null) {
                this.iko = new i(this.pageContext, this.iHt);
                this.iko.Hh(1);
                this.iko.setUniqueId(this.pageContext.getUniqueId());
            }
            this.iHt.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.iko != null) {
                        HotTopicDetailFeedView.this.iko.cV(view);
                    }
                }
            });
            this.gdy = new PbListView(context);
            this.gdy.createView();
            this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.gdy.setLineGone();
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
            this.iHt.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void hA(boolean z) {
        if (this.gmB == null) {
            this.gmB = new g(getContext());
            this.gmB.byH();
            this.gmB.onChangeSkinType();
            this.gmB.setWrapStyle(true);
        }
        this.gmB.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this);
            this.gmB = null;
        }
    }

    public void oP(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).EO(HotTopicDetailFeedView.this.sortType);
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

    public void TK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gmB != null) {
            this.gmB.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gdy.changeSkin(i);
        }
        if (this.kWr != null) {
            this.kWr.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.iko != null) {
            this.iko.destroy();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kWs);
    }

    public void resume() {
        if (this.iko != null) {
            this.iko.sO(true);
            if (this.iHt != null) {
                this.iko.a(this.iHt.getFirstVisiblePosition(), this.iHt.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iko != null) {
            this.iko.cXA();
            this.iko.sO(false);
        }
    }

    public void TI() {
        if (this.iHt != null && this.gdy != null) {
            this.iHt.setNextPage(this.gdy);
            this.gdy.setTextSize(R.dimen.tbfontsize33);
            this.gdy.showEmptyView(0);
            this.gdy.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.gdy.startLoadData();
        }
    }

    public void TJ() {
        if (this.iHt != null && this.gdy != null) {
            this.iHt.setNextPage(this.gdy);
            this.gdy.endLoadData();
            this.gdy.showEmptyView(0);
            this.gdy.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bNw() {
        if (this.iHt != null && this.gdy != null) {
            this.iHt.setNextPage(null);
            this.gdy.hideEmptyView();
        }
    }

    public void setData(@NonNull List<q> list) {
        this.kWr.setData(list);
        if (this.iko != null) {
            this.iko.a(this.iHt.getFirstVisiblePosition(), this.iHt.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.kVL = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements Runnable {
        int jMJ;
        final /* synthetic */ HotTopicDetailFeedView kWt;

        @Override // java.lang.Runnable
        public void run() {
            this.kWt.iHt.smoothScrollBy(Math.abs(this.jMJ), 1);
        }
    }
}
