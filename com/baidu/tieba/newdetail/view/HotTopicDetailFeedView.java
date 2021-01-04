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
/* loaded from: classes8.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    private PbListView gCf;
    private g gLj;
    private i iOh;
    private RecyclerView.OnScrollListener ioM;
    private BdTypeRecyclerView jlj;
    private RecyclerView.OnScrollListener luK;
    private l lvq;
    private a lvr;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.ioM = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean flr;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iOh != null) {
                    HotTopicDetailFeedView.this.iOh.b(HotTopicDetailFeedView.this.jlj.getFirstVisiblePosition(), HotTopicDetailFeedView.this.jlj.getLastVisiblePosition(), this.flr, true);
                }
                if (HotTopicDetailFeedView.this.luK != null) {
                    HotTopicDetailFeedView.this.luK.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.flr = i3 <= 0;
                if (HotTopicDetailFeedView.this.luK != null) {
                    HotTopicDetailFeedView.this.luK.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.ioM = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean flr;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iOh != null) {
                    HotTopicDetailFeedView.this.iOh.b(HotTopicDetailFeedView.this.jlj.getFirstVisiblePosition(), HotTopicDetailFeedView.this.jlj.getLastVisiblePosition(), this.flr, true);
                }
                if (HotTopicDetailFeedView.this.luK != null) {
                    HotTopicDetailFeedView.this.luK.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.flr = i3 <= 0;
                if (HotTopicDetailFeedView.this.luK != null) {
                    HotTopicDetailFeedView.this.luK.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.ioM = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean flr;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iOh != null) {
                    HotTopicDetailFeedView.this.iOh.b(HotTopicDetailFeedView.this.jlj.getFirstVisiblePosition(), HotTopicDetailFeedView.this.jlj.getLastVisiblePosition(), this.flr, true);
                }
                if (HotTopicDetailFeedView.this.luK != null) {
                    HotTopicDetailFeedView.this.luK.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.flr = i3 <= 0;
                if (HotTopicDetailFeedView.this.luK != null) {
                    HotTopicDetailFeedView.this.luK.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView Gq(int i) {
        this.sortType = i;
        this.lvq.uh(i == 0);
        return this;
    }

    private void init(Context context) {
        f<?> K = j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        if (this.pageContext != null) {
            this.jlj = new BdTypeRecyclerView(context);
            this.jlj.setFadingEdgeLength(0);
            this.jlj.setOverScrollMode(2);
            this.jlj.setVerticalScrollBarEnabled(false);
            this.jlj.setLayoutManager(new LinearLayoutManager(context));
            this.jlj.addOnScrollListener(this.ioM);
            this.jlj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.jlj != null) {
                        HotTopicDetailFeedView.this.jlj.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.lvq = new l(this.pageContext, this.pageContext.getUniqueId(), this.jlj);
            addView(this.jlj);
            ((FrameLayout.LayoutParams) this.jlj.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.iOh == null) {
                this.iOh = new i(this.pageContext, this.jlj);
                this.iOh.ID(1);
                this.iOh.setUniqueId(this.pageContext.getUniqueId());
            }
            this.jlj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.iOh != null) {
                        HotTopicDetailFeedView.this.iOh.dv(view);
                    }
                }
            });
            this.gCf = new PbListView(context);
            this.gCf.createView();
            this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gCf.setLineGone();
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
            this.jlj.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void it(boolean z) {
        if (this.gLj == null) {
            this.gLj = new g(getContext());
            this.gLj.bGs();
            this.gLj.onChangeSkinType();
            this.gLj.setWrapStyle(true);
        }
        this.gLj.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this);
            this.gLj = null;
        }
    }

    public void pU(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).Gg(HotTopicDetailFeedView.this.sortType);
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

    public void Zi() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gLj != null) {
            this.gLj.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
        if (this.lvq != null) {
            this.lvq.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this, R.color.CAM_X0201);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.iOh != null) {
            this.iOh.destroy();
        }
        e.mB().removeCallbacks(this.lvr);
    }

    public void resume() {
        if (this.iOh != null) {
            this.iOh.tE(true);
            if (this.jlj != null) {
                this.iOh.b(this.jlj.getFirstVisiblePosition(), this.jlj.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iOh != null) {
            this.iOh.dev();
            this.iOh.tE(false);
        }
    }

    public void Zg() {
        if (this.jlj != null && this.gCf != null) {
            this.jlj.setNextPage(this.gCf);
            this.gCf.setTextSize(R.dimen.tbfontsize33);
            this.gCf.showEmptyView(0);
            this.gCf.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.gCf.startLoadData();
        }
    }

    public void Zh() {
        if (this.jlj != null && this.gCf != null) {
            this.jlj.setNextPage(this.gCf);
            this.gCf.endLoadData();
            this.gCf.showEmptyView(0);
            this.gCf.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bVF() {
        if (this.jlj != null && this.gCf != null) {
            this.jlj.setNextPage(null);
            this.gCf.hideEmptyView();
        }
    }

    public void setData(@NonNull List<n> list) {
        this.lvq.setData(list);
        if (this.iOh != null) {
            this.iOh.b(this.jlj.getFirstVisiblePosition(), this.jlj.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.luK = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        int kui;
        final /* synthetic */ HotTopicDetailFeedView lvs;

        @Override // java.lang.Runnable
        public void run() {
            this.lvs.jlj.smoothScrollBy(Math.abs(this.kui), 1);
        }
    }
}
