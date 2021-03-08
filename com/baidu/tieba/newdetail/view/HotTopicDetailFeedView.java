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
import com.baidu.tbadk.core.util.ap;
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
    private PbListView gCf;
    private g gLk;
    private i iRf;
    private RecyclerView.OnScrollListener irI;
    private BdTypeRecyclerView joh;
    private RecyclerView.OnScrollListener lAz;
    private l lBf;
    private a lBg;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.irI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fky;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iRf != null) {
                    HotTopicDetailFeedView.this.iRf.b(HotTopicDetailFeedView.this.joh.getFirstVisiblePosition(), HotTopicDetailFeedView.this.joh.getLastVisiblePosition(), this.fky, true);
                }
                if (HotTopicDetailFeedView.this.lAz != null) {
                    HotTopicDetailFeedView.this.lAz.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fky = i3 <= 0;
                if (HotTopicDetailFeedView.this.lAz != null) {
                    HotTopicDetailFeedView.this.lAz.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.irI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fky;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iRf != null) {
                    HotTopicDetailFeedView.this.iRf.b(HotTopicDetailFeedView.this.joh.getFirstVisiblePosition(), HotTopicDetailFeedView.this.joh.getLastVisiblePosition(), this.fky, true);
                }
                if (HotTopicDetailFeedView.this.lAz != null) {
                    HotTopicDetailFeedView.this.lAz.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fky = i3 <= 0;
                if (HotTopicDetailFeedView.this.lAz != null) {
                    HotTopicDetailFeedView.this.lAz.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.irI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fky;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iRf != null) {
                    HotTopicDetailFeedView.this.iRf.b(HotTopicDetailFeedView.this.joh.getFirstVisiblePosition(), HotTopicDetailFeedView.this.joh.getLastVisiblePosition(), this.fky, true);
                }
                if (HotTopicDetailFeedView.this.lAz != null) {
                    HotTopicDetailFeedView.this.lAz.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fky = i3 <= 0;
                if (HotTopicDetailFeedView.this.lAz != null) {
                    HotTopicDetailFeedView.this.lAz.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView Ff(int i) {
        this.sortType = i;
        this.lBf.uq(i == 0);
        return this;
    }

    private void init(Context context) {
        f<?> J = j.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        if (this.pageContext != null) {
            this.joh = new BdTypeRecyclerView(context);
            this.joh.setFadingEdgeLength(0);
            this.joh.setOverScrollMode(2);
            this.joh.setVerticalScrollBarEnabled(false);
            this.joh.setLayoutManager(new LinearLayoutManager(context));
            this.joh.addOnScrollListener(this.irI);
            this.joh.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.joh != null) {
                        HotTopicDetailFeedView.this.joh.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.lBf = new l(this.pageContext, this.pageContext.getUniqueId(), this.joh);
            addView(this.joh);
            ((FrameLayout.LayoutParams) this.joh.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.iRf == null) {
                this.iRf = new i(this.pageContext, this.joh);
                this.iRf.Hr(1);
                this.iRf.setUniqueId(this.pageContext.getUniqueId());
            }
            this.joh.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.iRf != null) {
                        HotTopicDetailFeedView.this.iRf.dt(view);
                    }
                }
            });
            this.gCf = new PbListView(context);
            this.gCf.createView();
            this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gCf.setLineGone();
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
            this.joh.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void ir(boolean z) {
        if (this.gLk == null) {
            this.gLk = new g(getContext());
            this.gLk.bCV();
            this.gLk.onChangeSkinType();
            this.gLk.setWrapStyle(true);
        }
        this.gLk.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this);
            this.gLk = null;
        }
    }

    public void qa(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).EV(HotTopicDetailFeedView.this.sortType);
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

    public void Xc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gLk != null) {
            this.gLk.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
        if (this.lBf != null) {
            this.lBf.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this, R.color.CAM_X0201);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.iRf != null) {
            this.iRf.destroy();
        }
        e.mA().removeCallbacks(this.lBg);
    }

    public void resume() {
        if (this.iRf != null) {
            this.iRf.tN(true);
            if (this.joh != null) {
                this.iRf.b(this.joh.getFirstVisiblePosition(), this.joh.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iRf != null) {
            this.iRf.dcS();
            this.iRf.tN(false);
        }
    }

    public void Xa() {
        if (this.joh != null && this.gCf != null) {
            this.joh.setNextPage(this.gCf);
            this.gCf.setTextSize(R.dimen.tbfontsize33);
            this.gCf.showEmptyView(0);
            this.gCf.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.gCf.startLoadData();
        }
    }

    public void Xb() {
        if (this.joh != null && this.gCf != null) {
            this.joh.setNextPage(this.gCf);
            this.gCf.endLoadData();
            this.gCf.showEmptyView(0);
            this.gCf.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bSE() {
        if (this.joh != null && this.gCf != null) {
            this.joh.setNextPage(null);
            this.gCf.hideEmptyView();
        }
    }

    public void setData(@NonNull List<n> list) {
        this.lBf.setData(list);
        if (this.iRf != null) {
            this.iRf.b(this.joh.getFirstVisiblePosition(), this.joh.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.lAz = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        int kAa;
        final /* synthetic */ HotTopicDetailFeedView lBh;

        @Override // java.lang.Runnable
        public void run() {
            this.lBh.joh.smoothScrollBy(Math.abs(this.kAa), 1);
        }
    }
}
