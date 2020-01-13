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
import com.baidu.adp.widget.ListView.s;
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
/* loaded from: classes7.dex */
public class a {
    private BdTypeRecyclerView Bs;
    private TbPageContext cRe;
    private NoNetworkView ehd;
    private PbListView ehe;
    protected BdSwipeRefreshLayout ejj;
    private e hNu;
    private boolean hNx;
    private View hOb;
    private InterfaceC0535a hOc;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View.OnClickListener hNE = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ehe != null && a.this.hOc != null) {
                a.this.ehe.showEmptyView(0);
                a.this.ehe.setOnClickListener(null);
                a.this.ehe.startLoadData();
                a.this.hOc.bsc();
            }
        }
    };
    private final g.c enH = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.hOc != null) {
                    a.this.hOc.bEV();
                }
            } else if (a.this.ejj != null) {
                a.this.ejj.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0535a {
        void bEV();

        void bsc();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.cRe = tbPageContext;
        this.hOb = view.findViewById(R.id.agree_me_layout);
        c(tbPageContext);
        this.hNu = new e(tbPageContext, this.Bs);
    }

    public void a(InterfaceC0535a interfaceC0535a) {
        this.hOc = interfaceC0535a;
    }

    private void c(TbPageContext tbPageContext) {
        if (this.hOb != null) {
            if (this.mPullView == null) {
                this.mPullView = new h(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.enH);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.ehe == null) {
                this.ehe = new PbListView(tbPageContext.getPageActivity());
                this.ehe.getView();
            }
            this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.ehe.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.ehe.setLineGone();
            this.ehe.setTextSize(R.dimen.tbfontsize33);
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ehe.setOnClickListener(this.hNE);
            this.ehd = (NoNetworkView) this.hOb.findViewById(R.id.no_networkview);
            this.ehd.onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.hOb.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.hOb.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.cRe.getString(R.string.agree_me));
            this.ejj = (BdSwipeRefreshLayout) this.hOb.findViewById(R.id.agree_me_pull_refresh_layout);
            this.ejj.setProgressView(this.mPullView);
            this.Bs = (BdTypeRecyclerView) this.hOb.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Bs.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Bs.setLayoutManager(new LinearLayoutManager(this.cRe.getContext()));
            this.Bs.setFadingEdgeLength(0);
            this.Bs.setBackgroundColor(am.getColor(R.color.transparent));
            this.Bs.setOverScrollMode(2);
            this.Bs.addItemDecoration(new d());
            this.Bs.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Bs.setNextPage(this.ehe);
            this.Bs.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.ehe != null && a.this.hOc != null) {
                        a.this.ehe.showEmptyView(0);
                        a.this.ehe.setOnClickListener(null);
                        a.this.ehe.showLoading();
                        a.this.hOc.bsc();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.ejj != null && this.ehe != null && this.Bs != null && this.hNu != null) {
            this.ejj.setRefreshing(false);
            if (z) {
                this.ehe.showEmptyView(0);
                this.ehe.endLoadData();
                this.ehe.setOnClickListener(this.hNE);
            } else {
                this.ehe.showEmptyView(0);
                this.ehe.endLoadData();
                this.ehe.setText(this.cRe.getResources().getString(R.string.list_no_more));
                this.ehe.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.cRe.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cr(null, this.cRe.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.hNx) {
                    this.hNx = true;
                    this.Bs.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Bs.setNextPage(null);
                return;
            }
            this.Bs.removeHeaderView(this.mNoDataView);
            this.hNx = false;
            this.Bs.setNextPage(this.ehe);
            this.hNu.setData(arrayList);
            this.hNu.notifyDataSetChanged();
        }
    }

    public void og(boolean z) {
        if (this.ejj != null) {
            this.ejj.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ehd != null) {
            this.ehd.onChangeSkinType(this.cRe, i);
        }
        if (this.ehe != null) {
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ehe.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cRe, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cRe, i);
        }
        if (this.hNu != null) {
            this.hNu.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.hOb, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.ejj, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.Bs, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.hNu != null) {
            this.hNu.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(s sVar) {
        if (this.hNu != null) {
            this.hNu.e(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.Bs == null) {
            return null;
        }
        return this.Bs.getData();
    }

    public View getRootView() {
        return this.hOb;
    }

    public RelativeLayout bax() {
        return this.mContainer;
    }
}
