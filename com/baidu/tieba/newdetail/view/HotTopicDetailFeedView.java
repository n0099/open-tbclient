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
/* loaded from: classes8.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    private PbListView gAw;
    private g gJB;
    private i iPw;
    private RecyclerView.OnScrollListener ipZ;
    private BdTypeRecyclerView jmy;
    private RecyclerView.OnScrollListener lyx;
    private l lzd;
    private a lze;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.ipZ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fiZ;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iPw != null) {
                    HotTopicDetailFeedView.this.iPw.b(HotTopicDetailFeedView.this.jmy.getFirstVisiblePosition(), HotTopicDetailFeedView.this.jmy.getLastVisiblePosition(), this.fiZ, true);
                }
                if (HotTopicDetailFeedView.this.lyx != null) {
                    HotTopicDetailFeedView.this.lyx.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fiZ = i3 <= 0;
                if (HotTopicDetailFeedView.this.lyx != null) {
                    HotTopicDetailFeedView.this.lyx.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.ipZ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fiZ;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iPw != null) {
                    HotTopicDetailFeedView.this.iPw.b(HotTopicDetailFeedView.this.jmy.getFirstVisiblePosition(), HotTopicDetailFeedView.this.jmy.getLastVisiblePosition(), this.fiZ, true);
                }
                if (HotTopicDetailFeedView.this.lyx != null) {
                    HotTopicDetailFeedView.this.lyx.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fiZ = i3 <= 0;
                if (HotTopicDetailFeedView.this.lyx != null) {
                    HotTopicDetailFeedView.this.lyx.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.ipZ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fiZ;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iPw != null) {
                    HotTopicDetailFeedView.this.iPw.b(HotTopicDetailFeedView.this.jmy.getFirstVisiblePosition(), HotTopicDetailFeedView.this.jmy.getLastVisiblePosition(), this.fiZ, true);
                }
                if (HotTopicDetailFeedView.this.lyx != null) {
                    HotTopicDetailFeedView.this.lyx.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fiZ = i3 <= 0;
                if (HotTopicDetailFeedView.this.lyx != null) {
                    HotTopicDetailFeedView.this.lyx.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView Fc(int i) {
        this.sortType = i;
        this.lzd.uq(i == 0);
        return this;
    }

    private void init(Context context) {
        f<?> K = j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        if (this.pageContext != null) {
            this.jmy = new BdTypeRecyclerView(context);
            this.jmy.setFadingEdgeLength(0);
            this.jmy.setOverScrollMode(2);
            this.jmy.setVerticalScrollBarEnabled(false);
            this.jmy.setLayoutManager(new LinearLayoutManager(context));
            this.jmy.addOnScrollListener(this.ipZ);
            this.jmy.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.jmy != null) {
                        HotTopicDetailFeedView.this.jmy.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.lzd = new l(this.pageContext, this.pageContext.getUniqueId(), this.jmy);
            addView(this.jmy);
            ((FrameLayout.LayoutParams) this.jmy.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.iPw == null) {
                this.iPw = new i(this.pageContext, this.jmy);
                this.iPw.Ho(1);
                this.iPw.setUniqueId(this.pageContext.getUniqueId());
            }
            this.jmy.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.iPw != null) {
                        HotTopicDetailFeedView.this.iPw.dt(view);
                    }
                }
            });
            this.gAw = new PbListView(context);
            this.gAw.createView();
            this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gAw.setLineGone();
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
            this.jmy.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void ir(boolean z) {
        if (this.gJB == null) {
            this.gJB = new g(getContext());
            this.gJB.bCS();
            this.gJB.onChangeSkinType();
            this.gJB.setWrapStyle(true);
        }
        this.gJB.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this);
            this.gJB = null;
        }
    }

    public void qa(boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).ES(HotTopicDetailFeedView.this.sortType);
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

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gJB != null) {
            this.gJB.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAw.changeSkin(i);
        }
        if (this.lzd != null) {
            this.lzd.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this, R.color.CAM_X0201);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.iPw != null) {
            this.iPw.destroy();
        }
        e.mA().removeCallbacks(this.lze);
    }

    public void resume() {
        if (this.iPw != null) {
            this.iPw.tN(true);
            if (this.jmy != null) {
                this.iPw.b(this.jmy.getFirstVisiblePosition(), this.jmy.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iPw != null) {
            this.iPw.dcJ();
            this.iPw.tN(false);
        }
    }

    public void WX() {
        if (this.jmy != null && this.gAw != null) {
            this.jmy.setNextPage(this.gAw);
            this.gAw.setTextSize(R.dimen.tbfontsize33);
            this.gAw.showEmptyView(0);
            this.gAw.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.gAw.startLoadData();
        }
    }

    public void WY() {
        if (this.jmy != null && this.gAw != null) {
            this.jmy.setNextPage(this.gAw);
            this.gAw.endLoadData();
            this.gAw.showEmptyView(0);
            this.gAw.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bSy() {
        if (this.jmy != null && this.gAw != null) {
            this.jmy.setNextPage(null);
            this.gAw.hideEmptyView();
        }
    }

    public void setData(@NonNull List<n> list) {
        this.lzd.setData(list);
        if (this.iPw != null) {
            this.iPw.b(this.jmy.getFirstVisiblePosition(), this.jmy.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.lyx = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        int kxY;
        final /* synthetic */ HotTopicDetailFeedView lzf;

        @Override // java.lang.Runnable
        public void run() {
            this.lzf.jmy.smoothScrollBy(Math.abs(this.kxY), 1);
        }
    }
}
