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
    private PbListView gAi;
    private g gJn;
    private i iPi;
    private RecyclerView.OnScrollListener ipL;
    private BdTypeRecyclerView jmj;
    private l lyP;
    private a lyQ;
    private RecyclerView.OnScrollListener lyi;
    private h mRefreshView;
    private TbPageContext<HotTopicDetailActivity> pageContext;
    public int sortType;

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sortType = 1;
        this.ipL = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fiZ;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iPi != null) {
                    HotTopicDetailFeedView.this.iPi.b(HotTopicDetailFeedView.this.jmj.getFirstVisiblePosition(), HotTopicDetailFeedView.this.jmj.getLastVisiblePosition(), this.fiZ, true);
                }
                if (HotTopicDetailFeedView.this.lyi != null) {
                    HotTopicDetailFeedView.this.lyi.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fiZ = i3 <= 0;
                if (HotTopicDetailFeedView.this.lyi != null) {
                    HotTopicDetailFeedView.this.lyi.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sortType = 1;
        this.ipL = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fiZ;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iPi != null) {
                    HotTopicDetailFeedView.this.iPi.b(HotTopicDetailFeedView.this.jmj.getFirstVisiblePosition(), HotTopicDetailFeedView.this.jmj.getLastVisiblePosition(), this.fiZ, true);
                }
                if (HotTopicDetailFeedView.this.lyi != null) {
                    HotTopicDetailFeedView.this.lyi.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fiZ = i3 <= 0;
                if (HotTopicDetailFeedView.this.lyi != null) {
                    HotTopicDetailFeedView.this.lyi.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.sortType = 1;
        this.ipL = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.1
            private boolean fiZ;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0 && HotTopicDetailFeedView.this.iPi != null) {
                    HotTopicDetailFeedView.this.iPi.b(HotTopicDetailFeedView.this.jmj.getFirstVisiblePosition(), HotTopicDetailFeedView.this.jmj.getLastVisiblePosition(), this.fiZ, true);
                }
                if (HotTopicDetailFeedView.this.lyi != null) {
                    HotTopicDetailFeedView.this.lyi.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                this.fiZ = i3 <= 0;
                if (HotTopicDetailFeedView.this.lyi != null) {
                    HotTopicDetailFeedView.this.lyi.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        init(context);
    }

    public HotTopicDetailFeedView Fc(int i) {
        this.sortType = i;
        this.lyP.uq(i == 0);
        return this;
    }

    private void init(Context context) {
        f<?> K = j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        if (this.pageContext != null) {
            this.jmj = new BdTypeRecyclerView(context);
            this.jmj.setFadingEdgeLength(0);
            this.jmj.setOverScrollMode(2);
            this.jmj.setVerticalScrollBarEnabled(false);
            this.jmj.setLayoutManager(new LinearLayoutManager(context));
            this.jmj.addOnScrollListener(this.ipL);
            this.jmj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (HotTopicDetailFeedView.this.jmj != null) {
                        HotTopicDetailFeedView.this.jmj.stopScroll();
                    }
                    ((HotTopicDetailActivity) HotTopicDetailFeedView.this.pageContext.getOrignalPage()).onScrollToBottom();
                }
            });
            this.lyP = new l(this.pageContext, this.pageContext.getUniqueId(), this.jmj);
            addView(this.jmj);
            ((FrameLayout.LayoutParams) this.jmj.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.iPi == null) {
                this.iPi = new i(this.pageContext, this.jmj);
                this.iPi.Ho(1);
                this.iPi.setUniqueId(this.pageContext.getUniqueId());
            }
            this.jmj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailFeedView.3
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                    if (view != null && HotTopicDetailFeedView.this.iPi != null) {
                        HotTopicDetailFeedView.this.iPi.dt(view);
                    }
                }
            });
            this.gAi = new PbListView(context);
            this.gAi.createView();
            this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gAi.setLineGone();
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
            this.jmj.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void ir(boolean z) {
        if (this.gJn == null) {
            this.gJn = new g(getContext());
            this.gJn.bCS();
            this.gJn.onChangeSkinType();
            this.gJn.setWrapStyle(true);
        }
        this.gJn.attachView(this, z);
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this);
            this.gJn = null;
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
        if (this.gJn != null) {
            this.gJn.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAi.changeSkin(i);
        }
        if (this.lyP != null) {
            this.lyP.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this, R.color.CAM_X0201);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.iPi != null) {
            this.iPi.destroy();
        }
        e.mA().removeCallbacks(this.lyQ);
    }

    public void resume() {
        if (this.iPi != null) {
            this.iPi.tN(true);
            if (this.jmj != null) {
                this.iPi.b(this.jmj.getFirstVisiblePosition(), this.jmj.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iPi != null) {
            this.iPi.dcC();
            this.iPi.tN(false);
        }
    }

    public void WX() {
        if (this.jmj != null && this.gAi != null) {
            this.jmj.setNextPage(this.gAi);
            this.gAi.setTextSize(R.dimen.tbfontsize33);
            this.gAi.showEmptyView(0);
            this.gAi.setHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds182));
            this.gAi.startLoadData();
        }
    }

    public void WY() {
        if (this.jmj != null && this.gAi != null) {
            this.jmj.setNextPage(this.gAi);
            this.gAi.endLoadData();
            this.gAi.showEmptyView(0);
            this.gAi.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bSr() {
        if (this.jmj != null && this.gAi != null) {
            this.jmj.setNextPage(null);
            this.gAi.hideEmptyView();
        }
    }

    public void setData(@NonNull List<n> list) {
        this.lyP.setData(list);
        if (this.iPi != null) {
            this.iPi.b(this.jmj.getFirstVisiblePosition(), this.jmj.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.lyi = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        int kxK;
        final /* synthetic */ HotTopicDetailFeedView lyR;

        @Override // java.lang.Runnable
        public void run() {
            this.lyR.jmj.smoothScrollBy(Math.abs(this.kxK), 1);
        }
    }
}
