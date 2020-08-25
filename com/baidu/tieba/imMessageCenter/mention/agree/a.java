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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.base.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private BdTypeRecyclerView Wu;
    private TbPageContext efn;
    private NoNetworkView fDV;
    private PbListView fDW;
    protected BdSwipeRefreshLayout fGi;
    private View jFZ;
    private e jFv;
    private boolean jFw;
    private InterfaceC0728a jGa;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener jFA = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fDW != null && a.this.jGa != null) {
                a.this.fDW.showEmptyView(0);
                a.this.fDW.setOnClickListener(null);
                a.this.fDW.startLoadData();
                a.this.jGa.cat();
            }
        }
    };
    private final f.c fKL = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.jGa != null) {
                    a.this.jGa.cpa();
                }
            } else if (a.this.fGi != null) {
                a.this.fGi.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0728a {
        void cat();

        void cpa();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.efn = tbPageContext;
        this.jFZ = view.findViewById(R.id.agree_me_layout);
        w(tbPageContext);
        this.jFv = new e(tbPageContext, this.Wu);
    }

    public void a(InterfaceC0728a interfaceC0728a) {
        this.jGa = interfaceC0728a;
    }

    private void w(TbPageContext tbPageContext) {
        if (this.jFZ != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.fKL);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.fDW == null) {
                this.fDW = new PbListView(tbPageContext.getPageActivity());
                this.fDW.getView();
            }
            this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fDW.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.fDW.setLineGone();
            this.fDW.setTextSize(R.dimen.tbfontsize33);
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fDW.setOnClickListener(this.jFA);
            this.fDV = (NoNetworkView) this.jFZ.findViewById(R.id.no_networkview);
            this.fDV.onChangeSkinType(this.efn, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.jFZ.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.jFZ.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.efn.getString(R.string.agree_me));
            this.fGi = (BdSwipeRefreshLayout) this.jFZ.findViewById(R.id.agree_me_pull_refresh_layout);
            this.fGi.setProgressView(this.mPullView);
            this.Wu = (BdTypeRecyclerView) this.jFZ.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Wu.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Wu.setLayoutManager(new LinearLayoutManager(this.efn.getContext()));
            this.Wu.setFadingEdgeLength(0);
            this.Wu.setBackgroundColor(ap.getColor(R.color.transparent));
            this.Wu.setOverScrollMode(2);
            this.Wu.addItemDecoration(new d());
            this.Wu.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Wu.setNextPage(this.fDW);
            this.Wu.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.fDW != null && a.this.jGa != null) {
                        a.this.fDW.showEmptyView(0);
                        a.this.fDW.setOnClickListener(null);
                        a.this.fDW.showLoading();
                        a.this.jGa.cat();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<q> arrayList) {
        if (this.fGi != null && this.fDW != null && this.Wu != null && this.jFv != null) {
            this.fGi.setRefreshing(false);
            if (z) {
                this.fDW.showEmptyView(0);
                this.fDW.endLoadData();
                this.fDW.setOnClickListener(this.jFA);
            } else {
                this.fDW.showEmptyView(0);
                this.fDW.endLoadData();
                this.fDW.setText(this.efn.getResources().getString(R.string.list_no_more));
                this.fDW.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.efn.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dE(null, this.efn.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.jFw) {
                    this.jFw = true;
                    this.Wu.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.efn, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Wu.setNextPage(null);
                return;
            }
            this.Wu.removeHeaderView(this.mNoDataView);
            this.jFw = false;
            this.Wu.setNextPage(this.fDW);
            this.jFv.setData(arrayList);
            this.jFv.notifyDataSetChanged();
        }
    }

    public void rh(boolean z) {
        if (this.fGi != null) {
            this.fGi.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fDV != null) {
            this.fDV.onChangeSkinType(this.efn, i);
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fDW.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.efn, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.efn, i);
        }
        if (this.jFv != null) {
            this.jFv.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.jFZ, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.fGi, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.Wu, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.jFv != null) {
            this.jFv.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(ab abVar) {
        if (this.jFv != null) {
            this.jFv.e(abVar);
        }
    }

    public List<q> getDatas() {
        if (this.Wu == null) {
            return null;
        }
        return this.Wu.getData();
    }

    public View getRootView() {
        return this.jFZ;
    }

    public RelativeLayout bGn() {
        return this.mContainer;
    }
}
