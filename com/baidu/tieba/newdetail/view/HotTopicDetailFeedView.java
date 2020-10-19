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
    private PbListView fTv;
    private g gcx;
    private i hXO;
    private RecyclerView.OnScrollListener hyx;
    private BdTypeRecyclerView iuX;
    private l kJU;
    private a kJV;
    private RecyclerView.OnScrollListener kJo;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.hyx = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hXT;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hXO != null) {
                    HotTopicDetailFeedView.this.hXO.a(HotTopicDetailFeedView.this.iuX.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iuX.getLastVisiblePosition(), this.hXT, true);
                }
                if (HotTopicDetailFeedView.this.kJo != null) {
                    HotTopicDetailFeedView.this.kJo.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hXT = i3 <= 0;
                if (HotTopicDetailFeedView.this.kJo != null) {
                    HotTopicDetailFeedView.this.kJo.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.hyx = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hXT;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hXO != null) {
                    HotTopicDetailFeedView.this.hXO.a(HotTopicDetailFeedView.this.iuX.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iuX.getLastVisiblePosition(), this.hXT, true);
                }
                if (HotTopicDetailFeedView.this.kJo != null) {
                    HotTopicDetailFeedView.this.kJo.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hXT = i3 <= 0;
                if (HotTopicDetailFeedView.this.kJo != null) {
                    HotTopicDetailFeedView.this.kJo.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.hyx = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hXT;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hXO != null) {
                    HotTopicDetailFeedView.this.hXO.a(HotTopicDetailFeedView.this.iuX.getFirstVisiblePosition(), HotTopicDetailFeedView.this.iuX.getLastVisiblePosition(), this.hXT, true);
                }
                if (HotTopicDetailFeedView.this.kJo != null) {
                    HotTopicDetailFeedView.this.kJo.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hXT = i3 <= 0;
                if (HotTopicDetailFeedView.this.kJo != null) {
                    HotTopicDetailFeedView.this.kJo.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView EF(int i) {
        this.sortType = i;
        this.kJU.tb(i == 0);
        return this;
    }

    private void init(Context context) {
        e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        if (this.pageContext != null) {
            this.iuX = new BdTypeRecyclerView(context);
            this.iuX.setFadingEdgeLength(0);
            this.iuX.setOverScrollMode(2);
            this.iuX.setVerticalScrollBarEnabled(false);
            this.iuX.setLayoutManager(new LinearLayoutManager(context));
            this.iuX.addOnScrollListener(this.hyx);
            this.iuX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.iuX != null) {
                        HotTopicDetailFeedView.this.iuX.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.kJU = new l(this.pageContext, this.pageContext.getUniqueId(), this.iuX);
            addView(this.iuX);
            ((FrameLayout.LayoutParams) this.iuX.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.hXO == null) {
                this.hXO = new i(this.pageContext, this.iuX);
                this.hXO.GO(1);
                this.hXO.setUniqueId(this.pageContext.getUniqueId());
            }
            this.iuX.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.hXO != null) {
                        HotTopicDetailFeedView.this.hXO.cR(view);
                    }
                }
            });
            this.fTv = new PbListView(context);
            this.fTv.createView();
            this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fTv.setLineGone();
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
            this.iuX.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void hn(boolean z) {
        if (this.gcx == null) {
            this.gcx = new g(getContext());
            this.gcx.bwO();
            this.gcx.onChangeSkinType();
            this.gcx.setWrapStyle(true);
        }
        this.gcx.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this);
            this.gcx = null;
        }
    }

    public void ox(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).Ev(HotTopicDetailFeedView.this.sortType);
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

    public void SK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gcx != null) {
            this.gcx.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fTv.changeSkin(i);
        }
        if (this.kJU != null) {
            this.kJU.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.hXO != null) {
            this.hXO.destroy();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kJV);
    }

    public void resume() {
        if (this.hXO != null) {
            this.hXO.sw(true);
            if (this.iuX != null) {
                this.hXO.a(this.iuX.getFirstVisiblePosition(), this.iuX.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hXO != null) {
            this.hXO.cUt();
            this.hXO.sw(false);
        }
    }

    public void SI() {
        if (this.iuX != null && this.fTv != null) {
            this.iuX.setNextPage(this.fTv);
            this.fTv.setTextSize(R.dimen.tbfontsize33);
            this.fTv.showEmptyView(0);
            this.fTv.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.fTv.startLoadData();
        }
    }

    public void SJ() {
        if (this.iuX != null && this.fTv != null) {
            this.iuX.setNextPage(this.fTv);
            this.fTv.endLoadData();
            this.fTv.showEmptyView(0);
            this.fTv.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bKU() {
        if (this.iuX != null && this.fTv != null) {
            this.iuX.setNextPage(null);
            this.fTv.hideEmptyView();
        }
    }

    public void setData(@NonNull List<q> list) {
        this.kJU.setData(list);
        if (this.hXO != null) {
            this.hXO.a(this.iuX.getFirstVisiblePosition(), this.iuX.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.kJo = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements Runnable {
        int jAk;
        final /* synthetic */ HotTopicDetailFeedView kJW;

        @Override // java.lang.Runnable
        public void run() {
            this.kJW.iuX.smoothScrollBy(Math.abs(this.jAk), 1);
        }
    }
}
