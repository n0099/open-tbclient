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
/* loaded from: classes15.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    private PbListView fEa;
    private g fMR;
    private i hBR;
    private BdTypeRecyclerView hYW;
    private RecyclerView.OnScrollListener hcD;
    private RecyclerView.OnScrollListener klD;
    private l kmj;
    private a kmk;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.hcD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hBW;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hBR != null) {
                    HotTopicDetailFeedView.this.hBR.a(HotTopicDetailFeedView.this.hYW.getFirstVisiblePosition(), HotTopicDetailFeedView.this.hYW.getLastVisiblePosition(), this.hBW, true);
                }
                if (HotTopicDetailFeedView.this.klD != null) {
                    HotTopicDetailFeedView.this.klD.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hBW = i3 <= 0;
                if (HotTopicDetailFeedView.this.klD != null) {
                    HotTopicDetailFeedView.this.klD.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.hcD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hBW;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hBR != null) {
                    HotTopicDetailFeedView.this.hBR.a(HotTopicDetailFeedView.this.hYW.getFirstVisiblePosition(), HotTopicDetailFeedView.this.hYW.getLastVisiblePosition(), this.hBW, true);
                }
                if (HotTopicDetailFeedView.this.klD != null) {
                    HotTopicDetailFeedView.this.klD.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hBW = i3 <= 0;
                if (HotTopicDetailFeedView.this.klD != null) {
                    HotTopicDetailFeedView.this.klD.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.hcD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hBW;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hBR != null) {
                    HotTopicDetailFeedView.this.hBR.a(HotTopicDetailFeedView.this.hYW.getFirstVisiblePosition(), HotTopicDetailFeedView.this.hYW.getLastVisiblePosition(), this.hBW, true);
                }
                if (HotTopicDetailFeedView.this.klD != null) {
                    HotTopicDetailFeedView.this.klD.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hBW = i3 <= 0;
                if (HotTopicDetailFeedView.this.klD != null) {
                    HotTopicDetailFeedView.this.klD.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView Dy(int i) {
        this.sortType = i;
        this.kmj.sm(i == 0);
        return this;
    }

    private void init(Context context) {
        e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        if (this.pageContext != null) {
            this.hYW = new BdTypeRecyclerView(context);
            this.hYW.setFadingEdgeLength(0);
            this.hYW.setOverScrollMode(2);
            this.hYW.setVerticalScrollBarEnabled(false);
            this.hYW.setLayoutManager(new LinearLayoutManager(context));
            this.hYW.addOnScrollListener(this.hcD);
            this.hYW.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.hYW != null) {
                        HotTopicDetailFeedView.this.hYW.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.kmj = new l(this.pageContext, this.pageContext.getUniqueId(), this.hYW);
            addView(this.hYW);
            ((FrameLayout.LayoutParams) this.hYW.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.hBR == null) {
                this.hBR = new i(this.pageContext, this.hYW);
                this.hBR.FH(1);
                this.hBR.setUniqueId(this.pageContext.getUniqueId());
            }
            this.hYW.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.hBR != null) {
                        HotTopicDetailFeedView.this.hBR.cE(view);
                    }
                }
            });
            this.fEa = new PbListView(context);
            this.fEa.createView();
            this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fEa.setLineGone();
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
            this.hYW.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void gT(boolean z) {
        if (this.fMR == null) {
            this.fMR = new g(getContext());
            this.fMR.bta();
            this.fMR.onChangeSkinType();
            this.fMR.setWrapStyle(true);
        }
        this.fMR.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this);
            this.fMR = null;
        }
    }

    public void nM(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).Do(HotTopicDetailFeedView.this.sortType);
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

    public void bFX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fMR != null) {
            this.fMR.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fEa.changeSkin(i);
        }
        if (this.kmj != null) {
            this.kmj.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.hBR != null) {
            this.hBR.destroy();
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kmk);
    }

    public void resume() {
        if (this.hBR != null) {
            this.hBR.rH(true);
            if (this.hYW != null) {
                this.hBR.a(this.hYW.getFirstVisiblePosition(), this.hYW.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hBR != null) {
            this.hBR.cNe();
            this.hBR.rH(false);
        }
    }

    public void bGS() {
        if (this.hYW != null && this.fEa != null) {
            this.hYW.setNextPage(this.fEa);
            this.fEa.setTextSize(R.dimen.tbfontsize33);
            this.fEa.showEmptyView(0);
            this.fEa.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.fEa.startLoadData();
        }
    }

    public void bGT() {
        if (this.hYW != null && this.fEa != null) {
            this.hYW.setNextPage(this.fEa);
            this.fEa.endLoadData();
            this.fEa.showEmptyView(0);
            this.fEa.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bGU() {
        if (this.hYW != null && this.fEa != null) {
            this.hYW.setNextPage(null);
            this.fEa.hideEmptyView();
        }
    }

    public void setData(@NonNull List<q> list) {
        this.kmj.setData(list);
        if (this.hBR != null) {
            this.hBR.a(this.hYW.getFirstVisiblePosition(), this.hYW.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.klD = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        int jcG;
        final /* synthetic */ HotTopicDetailFeedView kml;

        @Override // java.lang.Runnable
        public void run() {
            this.kml.hYW.smoothScrollBy(Math.abs(this.jcG), 1);
        }
    }
}
