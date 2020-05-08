package com.baidu.tieba.imMessageCenter.mention.agree;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.base.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Vi;
    private TbPageContext duK;
    private NoNetworkView ePq;
    private PbListView ePr;
    protected BdSwipeRefreshLayout eRB;
    private View iBK;
    private InterfaceC0601a iBL;
    private e iBd;
    private boolean iBg;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View.OnClickListener iBn = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ePr != null && a.this.iBL != null) {
                a.this.ePr.showEmptyView(0);
                a.this.ePr.setOnClickListener(null);
                a.this.ePr.startLoadData();
                a.this.iBL.bDx();
            }
        }
    };
    private final g.c eWe = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.iBL != null) {
                    a.this.iBL.bRl();
                }
            } else if (a.this.eRB != null) {
                a.this.eRB.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0601a {
        void bDx();

        void bRl();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.duK = tbPageContext;
        this.iBK = view.findViewById(R.id.agree_me_layout);
        c(tbPageContext);
        this.iBd = new e(tbPageContext, this.Vi);
    }

    public void a(InterfaceC0601a interfaceC0601a) {
        this.iBL = interfaceC0601a;
    }

    private void c(TbPageContext tbPageContext) {
        if (this.iBK != null) {
            if (this.mPullView == null) {
                this.mPullView = new h(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.eWe);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.ePr == null) {
                this.ePr = new PbListView(tbPageContext.getPageActivity());
                this.ePr.getView();
            }
            this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.ePr.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.ePr.setLineGone();
            this.ePr.setTextSize(R.dimen.tbfontsize33);
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ePr.setOnClickListener(this.iBn);
            this.ePq = (NoNetworkView) this.iBK.findViewById(R.id.no_networkview);
            this.ePq.onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.iBK.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.iBK.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.duK.getString(R.string.agree_me));
            this.eRB = (BdSwipeRefreshLayout) this.iBK.findViewById(R.id.agree_me_pull_refresh_layout);
            this.eRB.setProgressView(this.mPullView);
            this.Vi = (BdTypeRecyclerView) this.iBK.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Vi.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Vi.setLayoutManager(new LinearLayoutManager(this.duK.getContext()));
            this.Vi.setFadingEdgeLength(0);
            this.Vi.setBackgroundColor(am.getColor(R.color.transparent));
            this.Vi.setOverScrollMode(2);
            this.Vi.addItemDecoration(new d());
            this.Vi.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Vi.setNextPage(this.ePr);
            this.Vi.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.ePr != null && a.this.iBL != null) {
                        a.this.ePr.showEmptyView(0);
                        a.this.ePr.setOnClickListener(null);
                        a.this.ePr.showLoading();
                        a.this.iBL.bDx();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.eRB != null && this.ePr != null && this.Vi != null && this.iBd != null) {
            this.eRB.setRefreshing(false);
            if (z) {
                this.ePr.showEmptyView(0);
                this.ePr.endLoadData();
                this.ePr.setOnClickListener(this.iBn);
            } else {
                this.ePr.showEmptyView(0);
                this.ePr.endLoadData();
                this.ePr.setText(this.duK.getResources().getString(R.string.list_no_more));
                this.ePr.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.duK.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cK(null, this.duK.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.iBg) {
                    this.iBg = true;
                    this.Vi.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Vi.setNextPage(null);
                return;
            }
            this.Vi.removeHeaderView(this.mNoDataView);
            this.iBg = false;
            this.Vi.setNextPage(this.ePr);
            this.iBd.setData(arrayList);
            this.iBd.notifyDataSetChanged();
        }
    }

    public void ps(boolean z) {
        if (this.eRB != null) {
            this.eRB.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ePq != null) {
            this.ePq.onChangeSkinType(this.duK, i);
        }
        if (this.ePr != null) {
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ePr.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.duK, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.duK, i);
        }
        if (this.iBd != null) {
            this.iBd.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.iBK, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.eRB, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.Vi, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.iBd != null) {
            this.iBd.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(com.baidu.adp.widget.ListView.v vVar) {
        if (this.iBd != null) {
            this.iBd.e(vVar);
        }
    }

    public List<m> getDatas() {
        if (this.Vi == null) {
            return null;
        }
        return this.Vi.getData();
    }

    public View getRootView() {
        return this.iBK;
    }

    public RelativeLayout blI() {
        return this.mContainer;
    }
}
