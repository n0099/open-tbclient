package com.baidu.tieba.imMessageCenter.mention.agree;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.mention.base.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private NoNetworkView bBq;
    private PbListView bBr;
    private BdTypeRecyclerView bEd;
    protected BdSwipeRefreshLayout bEe;
    private View ePO;
    private InterfaceC0188a ePP;
    private e ePi;
    private boolean ePl;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private View.OnClickListener ePt = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bBr != null && a.this.ePP != null) {
                a.this.bBr.dN(0);
                a.this.bBr.setOnClickListener(null);
                a.this.bBr.BI();
                a.this.ePP.ayH();
            }
        }
    };
    private final j.b bEk = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bf(boolean z) {
            if (com.baidu.adp.lib.util.j.kK()) {
                if (a.this.ePP != null) {
                    a.this.ePP.ayI();
                }
            } else if (a.this.bEe != null) {
                a.this.bEe.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0188a {
        void ayH();

        void ayI();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.ePO = view.findViewById(e.g.agree_me_layout);
        o(tbPageContext);
        this.ePi = new com.baidu.tieba.imMessageCenter.mention.base.e(tbPageContext, this.bEd);
    }

    public void a(InterfaceC0188a interfaceC0188a) {
        this.ePP = interfaceC0188a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.ePO != null) {
            if (this.mPullView == null) {
                this.mPullView = new k(tbPageContext);
                this.mPullView.a(this.bEk);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.bBr == null) {
                this.bBr = new PbListView(tbPageContext.getPageActivity());
                this.bBr.getView();
            }
            this.bBr.dL(e.d.cp_bg_line_e);
            this.bBr.setHeight(l.h(tbPageContext.getContext(), e.C0141e.tbds182));
            this.bBr.BF();
            this.bBr.setTextSize(e.C0141e.tbfontsize33);
            this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bBr.dK(e.d.cp_cont_e);
            this.bBr.setOnClickListener(this.ePt);
            this.bBq = (NoNetworkView) this.ePO.findViewById(e.g.no_networkview);
            this.bBq.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.ePO.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(e.j.agree_me));
            this.bEe = (BdSwipeRefreshLayout) this.ePO.findViewById(e.g.agree_me_pull_refresh_layout);
            this.bEe.setProgressView(this.mPullView);
            this.bEd = (BdTypeRecyclerView) this.ePO.findViewById(e.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.bEd.getItemAnimator()).setSupportsChangeAnimations(false);
            this.bEd.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.bEd.setFadingEdgeLength(0);
            this.bEd.setBackgroundColor(al.getColor(e.d.transparent));
            this.bEd.setOverScrollMode(2);
            this.bEd.addItemDecoration(new d());
            this.bEd.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.bEd.setNextPage(this.bBr);
            this.bEd.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.bBr != null && a.this.ePP != null) {
                        a.this.bBr.dN(0);
                        a.this.bBr.setOnClickListener(null);
                        a.this.bBr.showLoading();
                        a.this.ePP.ayH();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<h> arrayList) {
        if (this.bEe != null && this.bBr != null && this.bEd != null && this.ePi != null) {
            this.bEe.setRefreshing(false);
            if (z) {
                this.bBr.dN(0);
                this.bBr.BJ();
                this.bBr.setOnClickListener(this.ePt);
            } else {
                this.bBr.dN(0);
                this.bBr.BJ();
                this.bBr.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.bBr.setOnClickListener(null);
            }
            if (v.z(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0141e.ds80)), NoDataViewFactory.d.dE(e.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.ePl) {
                    this.ePl = true;
                    this.bEd.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bEd.setNextPage(null);
                return;
            }
            this.bEd.removeHeaderView(this.mNoDataView);
            this.ePl = false;
            this.bEd.setNextPage(this.bBr);
            this.ePi.setData(arrayList);
            this.ePi.notifyDataSetChanged();
        }
    }

    public void iF(boolean z) {
        if (this.bEe != null) {
            this.bEe.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        if (this.bBq != null) {
            this.bBq.onChangeSkinType(this.mContext, i);
        }
        if (this.bBr != null) {
            this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bBr.dM(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.ePi != null) {
            this.ePi.notifyDataSetChanged();
        }
        al.j(this.ePO, e.d.cp_bg_line_e);
        al.j(this.bEe, e.d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.ePi != null) {
            this.ePi.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.ePi != null) {
            this.ePi.d(nVar);
        }
    }

    public List<h> getDatas() {
        if (this.bEd == null) {
            return null;
        }
        return this.bEd.getData();
    }

    public View getRootView() {
        return this.ePO;
    }
}
