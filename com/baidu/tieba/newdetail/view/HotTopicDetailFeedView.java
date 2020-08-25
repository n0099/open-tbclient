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
    private PbListView fDW;
    private g fMN;
    private i hBL;
    private BdTypeRecyclerView hYQ;
    private RecyclerView.OnScrollListener hcz;
    private RecyclerView.OnScrollListener klw;
    private l kmc;
    private a kmd;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.hcz = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hBQ;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hBL != null) {
                    HotTopicDetailFeedView.this.hBL.a(HotTopicDetailFeedView.this.hYQ.getFirstVisiblePosition(), HotTopicDetailFeedView.this.hYQ.getLastVisiblePosition(), this.hBQ, true);
                }
                if (HotTopicDetailFeedView.this.klw != null) {
                    HotTopicDetailFeedView.this.klw.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hBQ = i3 <= 0;
                if (HotTopicDetailFeedView.this.klw != null) {
                    HotTopicDetailFeedView.this.klw.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.hcz = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hBQ;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hBL != null) {
                    HotTopicDetailFeedView.this.hBL.a(HotTopicDetailFeedView.this.hYQ.getFirstVisiblePosition(), HotTopicDetailFeedView.this.hYQ.getLastVisiblePosition(), this.hBQ, true);
                }
                if (HotTopicDetailFeedView.this.klw != null) {
                    HotTopicDetailFeedView.this.klw.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hBQ = i3 <= 0;
                if (HotTopicDetailFeedView.this.klw != null) {
                    HotTopicDetailFeedView.this.klw.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.hcz = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hBQ;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hBL != null) {
                    HotTopicDetailFeedView.this.hBL.a(HotTopicDetailFeedView.this.hYQ.getFirstVisiblePosition(), HotTopicDetailFeedView.this.hYQ.getLastVisiblePosition(), this.hBQ, true);
                }
                if (HotTopicDetailFeedView.this.klw != null) {
                    HotTopicDetailFeedView.this.klw.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hBQ = i3 <= 0;
                if (HotTopicDetailFeedView.this.klw != null) {
                    HotTopicDetailFeedView.this.klw.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView Dy(int i) {
        this.sortType = i;
        this.kmc.sk(i == 0);
        return this;
    }

    private void init(Context context) {
        e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        if (this.pageContext != null) {
            this.hYQ = new BdTypeRecyclerView(context);
            this.hYQ.setFadingEdgeLength(0);
            this.hYQ.setOverScrollMode(2);
            this.hYQ.setVerticalScrollBarEnabled(false);
            this.hYQ.setLayoutManager(new LinearLayoutManager(context));
            this.hYQ.addOnScrollListener(this.hcz);
            this.hYQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.hYQ != null) {
                        HotTopicDetailFeedView.this.hYQ.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.kmc = new l(this.pageContext, this.pageContext.getUniqueId(), this.hYQ);
            addView(this.hYQ);
            ((FrameLayout.LayoutParams) this.hYQ.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.hBL == null) {
                this.hBL = new i(this.pageContext, this.hYQ);
                this.hBL.FH(1);
                this.hBL.setUniqueId(this.pageContext.getUniqueId());
            }
            this.hYQ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.hBL != null) {
                        HotTopicDetailFeedView.this.hBL.cE(view);
                    }
                }
            });
            this.fDW = new PbListView(context);
            this.fDW.createView();
            this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fDW.setLineGone();
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
            this.hYQ.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void gS(boolean z) {
        if (this.fMN == null) {
            this.fMN = new g(getContext());
            this.fMN.bsZ();
            this.fMN.onChangeSkinType();
            this.fMN.setWrapStyle(true);
        }
        this.fMN.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this);
            this.fMN = null;
        }
    }

    public void nK(boolean z) {
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

    public void bFW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fMN != null) {
            this.fMN.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fDW.changeSkin(i);
        }
        if (this.kmc != null) {
            this.kmc.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.hBL != null) {
            this.hBL.destroy();
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kmd);
    }

    public void resume() {
        if (this.hBL != null) {
            this.hBL.rF(true);
            if (this.hYQ != null) {
                this.hBL.a(this.hYQ.getFirstVisiblePosition(), this.hYQ.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hBL != null) {
            this.hBL.cNd();
            this.hBL.rF(false);
        }
    }

    public void bGR() {
        if (this.hYQ != null && this.fDW != null) {
            this.hYQ.setNextPage(this.fDW);
            this.fDW.setTextSize(R.dimen.tbfontsize33);
            this.fDW.showEmptyView(0);
            this.fDW.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.fDW.startLoadData();
        }
    }

    public void bGS() {
        if (this.hYQ != null && this.fDW != null) {
            this.hYQ.setNextPage(this.fDW);
            this.fDW.endLoadData();
            this.fDW.showEmptyView(0);
            this.fDW.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bGT() {
        if (this.hYQ != null && this.fDW != null) {
            this.hYQ.setNextPage(null);
            this.fDW.hideEmptyView();
        }
    }

    public void setData(@NonNull List<q> list) {
        this.kmc.setData(list);
        if (this.hBL != null) {
            this.hBL.a(this.hYQ.getFirstVisiblePosition(), this.hYQ.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.klw = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        int jcA;
        final /* synthetic */ HotTopicDetailFeedView kme;

        @Override // java.lang.Runnable
        public void run() {
            this.kme.hYQ.smoothScrollBy(Math.abs(this.jcA), 1);
        }
    }
}
