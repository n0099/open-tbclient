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
import com.baidu.tbadk.core.util.ao;
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
    private g fBv;
    private PbListView fsC;
    private RecyclerView.OnScrollListener gPJ;
    private BdTypeRecyclerView hKL;
    private i hoU;
    private RecyclerView.OnScrollListener jVY;
    private l jWE;
    private a jWF;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.gPJ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hoZ;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hoU != null) {
                    HotTopicDetailFeedView.this.hoU.a(HotTopicDetailFeedView.this.hKL.getFirstVisiblePosition(), HotTopicDetailFeedView.this.hKL.getLastVisiblePosition(), this.hoZ, true);
                }
                if (HotTopicDetailFeedView.this.jVY != null) {
                    HotTopicDetailFeedView.this.jVY.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hoZ = i3 <= 0;
                if (HotTopicDetailFeedView.this.jVY != null) {
                    HotTopicDetailFeedView.this.jVY.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.gPJ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hoZ;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hoU != null) {
                    HotTopicDetailFeedView.this.hoU.a(HotTopicDetailFeedView.this.hKL.getFirstVisiblePosition(), HotTopicDetailFeedView.this.hKL.getLastVisiblePosition(), this.hoZ, true);
                }
                if (HotTopicDetailFeedView.this.jVY != null) {
                    HotTopicDetailFeedView.this.jVY.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hoZ = i3 <= 0;
                if (HotTopicDetailFeedView.this.jVY != null) {
                    HotTopicDetailFeedView.this.jVY.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.gPJ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean hoZ;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.hoU != null) {
                    HotTopicDetailFeedView.this.hoU.a(HotTopicDetailFeedView.this.hKL.getFirstVisiblePosition(), HotTopicDetailFeedView.this.hKL.getLastVisiblePosition(), this.hoZ, true);
                }
                if (HotTopicDetailFeedView.this.jVY != null) {
                    HotTopicDetailFeedView.this.jVY.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.hoZ = i3 <= 0;
                if (HotTopicDetailFeedView.this.jVY != null) {
                    HotTopicDetailFeedView.this.jVY.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView Bf(int i) {
        this.sortType = i;
        this.jWE.rE(i == 0);
        return this;
    }

    private void init(Context context) {
        e<?> G = com.baidu.adp.base.i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        if (this.pageContext != null) {
            this.hKL = new BdTypeRecyclerView(context);
            this.hKL.setFadingEdgeLength(0);
            this.hKL.setOverScrollMode(2);
            this.hKL.setVerticalScrollBarEnabled(false);
            this.hKL.setLayoutManager(new LinearLayoutManager(context));
            this.hKL.addOnScrollListener(this.gPJ);
            this.hKL.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.hKL != null) {
                        HotTopicDetailFeedView.this.hKL.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.jWE = new l(this.pageContext, this.pageContext.getUniqueId(), this.hKL);
            addView(this.hKL);
            ((FrameLayout.LayoutParams) this.hKL.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.hoU == null) {
                this.hoU = new i(this.pageContext, this.hKL);
                this.hoU.Dm(1);
                this.hoU.setUniqueId(this.pageContext.getUniqueId());
            }
            this.hKL.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.hoU != null) {
                        HotTopicDetailFeedView.this.hoU.cA(view);
                    }
                }
            });
            this.fsC = new PbListView(context);
            this.fsC.createView();
            this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fsC.setLineGone();
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
            this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
            this.hKL.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void gw(boolean z) {
        if (this.fBv == null) {
            this.fBv = new g(getContext());
            this.fBv.bkn();
            this.fBv.onChangeSkinType();
            this.fBv.setWrapStyle(true);
        }
        this.fBv.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this);
            this.fBv = null;
        }
    }

    public void ng(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).AV(HotTopicDetailFeedView.this.sortType);
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

    public void bwX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fBv != null) {
            this.fBv.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
            this.fsC.changeSkin(i);
        }
        if (this.jWE != null) {
            this.jWE.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.hoU != null) {
            this.hoU.destroy();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jWF);
    }

    public void resume() {
        if (this.hoU != null) {
            this.hoU.qZ(true);
            if (this.hKL != null) {
                this.hoU.a(this.hKL.getFirstVisiblePosition(), this.hKL.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hoU != null) {
            this.hoU.cCl();
            this.hoU.qZ(false);
        }
    }

    public void bxS() {
        if (this.hKL != null && this.fsC != null) {
            this.hKL.setNextPage(this.fsC);
            this.fsC.setTextSize(R.dimen.tbfontsize33);
            this.fsC.showEmptyView(0);
            this.fsC.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.fsC.startLoadData();
        }
    }

    public void bxT() {
        if (this.hKL != null && this.fsC != null) {
            this.hKL.setNextPage(this.fsC);
            this.fsC.endLoadData();
            this.fsC.showEmptyView(0);
            this.fsC.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bxU() {
        if (this.hKL != null && this.fsC != null) {
            this.hKL.setNextPage(null);
            this.fsC.hideEmptyView();
        }
    }

    public void setData(@NonNull List<q> list) {
        this.jWE.setData(list);
        if (this.hoU != null) {
            this.hoU.a(this.hKL.getFirstVisiblePosition(), this.hKL.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jVY = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        int iNA;
        final /* synthetic */ HotTopicDetailFeedView jWG;

        @Override // java.lang.Runnable
        public void run() {
            this.jWG.hKL.smoothScrollBy(Math.abs(this.iNA), 1);
        }
    }
}
