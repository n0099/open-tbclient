package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.base.f;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.adapter.a.l;
import com.baidu.tieba.play.i;
import java.util.List;
/* loaded from: classes7.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    private g gGD;
    private PbListView gxy;
    private i iJA;
    private RecyclerView.OnScrollListener ikd;
    private BdTypeRecyclerView jgC;
    private l lqK;
    private a lqL;
    private RecyclerView.OnScrollListener lqe;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.ikd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fgG;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iJA != null) {
                    HotTopicDetailFeedView.this.iJA.b(HotTopicDetailFeedView.this.jgC.getFirstVisiblePosition(), HotTopicDetailFeedView.this.jgC.getLastVisiblePosition(), this.fgG, true);
                }
                if (HotTopicDetailFeedView.this.lqe != null) {
                    HotTopicDetailFeedView.this.lqe.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fgG = i3 <= 0;
                if (HotTopicDetailFeedView.this.lqe != null) {
                    HotTopicDetailFeedView.this.lqe.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.ikd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fgG;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iJA != null) {
                    HotTopicDetailFeedView.this.iJA.b(HotTopicDetailFeedView.this.jgC.getFirstVisiblePosition(), HotTopicDetailFeedView.this.jgC.getLastVisiblePosition(), this.fgG, true);
                }
                if (HotTopicDetailFeedView.this.lqe != null) {
                    HotTopicDetailFeedView.this.lqe.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fgG = i3 <= 0;
                if (HotTopicDetailFeedView.this.lqe != null) {
                    HotTopicDetailFeedView.this.lqe.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.ikd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fgG;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iJA != null) {
                    HotTopicDetailFeedView.this.iJA.b(HotTopicDetailFeedView.this.jgC.getFirstVisiblePosition(), HotTopicDetailFeedView.this.jgC.getLastVisiblePosition(), this.fgG, true);
                }
                if (HotTopicDetailFeedView.this.lqe != null) {
                    HotTopicDetailFeedView.this.lqe.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fgG = i3 <= 0;
                if (HotTopicDetailFeedView.this.lqe != null) {
                    HotTopicDetailFeedView.this.lqe.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView EK(int i) {
        this.sortType = i;
        this.lqK.ud(i == 0);
        return this;
    }

    private void init(Context context) {
        f<?> K = j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        if (this.pageContext != null) {
            this.jgC = new BdTypeRecyclerView(context);
            this.jgC.setFadingEdgeLength(0);
            this.jgC.setOverScrollMode(2);
            this.jgC.setVerticalScrollBarEnabled(false);
            this.jgC.setLayoutManager(new LinearLayoutManager(context));
            this.jgC.addOnScrollListener(this.ikd);
            this.jgC.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.jgC != null) {
                        HotTopicDetailFeedView.this.jgC.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.lqK = new l(this.pageContext, this.pageContext.getUniqueId(), this.jgC);
            addView(this.jgC);
            ((FrameLayout.LayoutParams) this.jgC.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.iJA == null) {
                this.iJA = new i(this.pageContext, this.jgC);
                this.iJA.GW(1);
                this.iJA.setUniqueId(this.pageContext.getUniqueId());
            }
            this.jgC.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.iJA != null) {
                        HotTopicDetailFeedView.this.iJA.dv(view);
                    }
                }
            });
            this.gxy = new PbListView(context);
            this.gxy.createView();
            this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gxy.setLineGone();
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
            this.jgC.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void ip(boolean z) {
        if (this.gGD == null) {
            this.gGD = new g(getContext());
            this.gGD.bCA();
            this.gGD.onChangeSkinType();
            this.gGD.setWrapStyle(true);
        }
        this.gGD.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this);
            this.gGD = null;
        }
    }

    public void pQ(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).EA(HotTopicDetailFeedView.this.sortType);
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

    public void Vq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gGD != null) {
            this.gGD.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gxy.changeSkin(i);
        }
        if (this.lqK != null) {
            this.lqK.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this, R.color.CAM_X0201);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.iJA != null) {
            this.iJA.destroy();
        }
        e.mB().removeCallbacks(this.lqL);
    }

    public void resume() {
        if (this.iJA != null) {
            this.iJA.tA(true);
            if (this.jgC != null) {
                this.iJA.b(this.jgC.getFirstVisiblePosition(), this.jgC.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iJA != null) {
            this.iJA.daE();
            this.iJA.tA(false);
        }
    }

    public void Vo() {
        if (this.jgC != null && this.gxy != null) {
            this.jgC.setNextPage(this.gxy);
            this.gxy.setTextSize(R.dimen.tbfontsize33);
            this.gxy.showEmptyView(0);
            this.gxy.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.gxy.startLoadData();
        }
    }

    public void Vp() {
        if (this.jgC != null && this.gxy != null) {
            this.jgC.setNextPage(this.gxy);
            this.gxy.endLoadData();
            this.gxy.showEmptyView(0);
            this.gxy.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bRO() {
        if (this.jgC != null && this.gxy != null) {
            this.jgC.setNextPage(null);
            this.gxy.hideEmptyView();
        }
    }

    public void setData(@NonNull List<n> list) {
        this.lqK.setData(list);
        if (this.iJA != null) {
            this.iJA.b(this.jgC.getFirstVisiblePosition(), this.jgC.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.lqe = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        int kpD;
        final /* synthetic */ HotTopicDetailFeedView lqM;

        @Override // java.lang.Runnable
        public void run() {
            this.lqM.jgC.smoothScrollBy(Math.abs(this.kpD), 1);
        }
    }
}
