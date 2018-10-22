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
/* loaded from: classes4.dex */
public class a {
    private NoNetworkView bJX;
    private PbListView bJY;
    private BdTypeRecyclerView bMI;
    protected BdSwipeRefreshLayout bMJ;
    private e eWR;
    private boolean eWU;
    private View eXx;
    private InterfaceC0222a eXy;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private View.OnClickListener eXc = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bJY != null && a.this.eXy != null) {
                a.this.bJY.dX(0);
                a.this.bJY.setOnClickListener(null);
                a.this.bJY.DO();
                a.this.eXy.aCb();
            }
        }
    };
    private final j.b bMO = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bp(boolean z) {
            if (com.baidu.adp.lib.util.j.kX()) {
                if (a.this.eXy != null) {
                    a.this.eXy.aCc();
                }
            } else if (a.this.bMJ != null) {
                a.this.bMJ.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0222a {
        void aCb();

        void aCc();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.eXx = view.findViewById(e.g.agree_me_layout);
        o(tbPageContext);
        this.eWR = new com.baidu.tieba.imMessageCenter.mention.base.e(tbPageContext, this.bMI);
    }

    public void a(InterfaceC0222a interfaceC0222a) {
        this.eXy = interfaceC0222a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.eXx != null) {
            if (this.mPullView == null) {
                this.mPullView = new k(tbPageContext);
                this.mPullView.a(this.bMO);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.bJY == null) {
                this.bJY = new PbListView(tbPageContext.getPageActivity());
                this.bJY.getView();
            }
            this.bJY.dV(e.d.cp_bg_line_e);
            this.bJY.setHeight(l.h(tbPageContext.getContext(), e.C0175e.tbds182));
            this.bJY.DL();
            this.bJY.setTextSize(e.C0175e.tbfontsize33);
            this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bJY.dU(e.d.cp_cont_e);
            this.bJY.setOnClickListener(this.eXc);
            this.bJX = (NoNetworkView) this.eXx.findViewById(e.g.no_networkview);
            this.bJX.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.eXx.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(e.j.agree_me));
            this.bMJ = (BdSwipeRefreshLayout) this.eXx.findViewById(e.g.agree_me_pull_refresh_layout);
            this.bMJ.setProgressView(this.mPullView);
            this.bMI = (BdTypeRecyclerView) this.eXx.findViewById(e.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.bMI.getItemAnimator()).setSupportsChangeAnimations(false);
            this.bMI.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.bMI.setFadingEdgeLength(0);
            this.bMI.setBackgroundColor(al.getColor(e.d.transparent));
            this.bMI.setOverScrollMode(2);
            this.bMI.addItemDecoration(new d());
            this.bMI.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.bMI.setNextPage(this.bJY);
            this.bMI.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.bJY != null && a.this.eXy != null) {
                        a.this.bJY.dX(0);
                        a.this.bJY.setOnClickListener(null);
                        a.this.bJY.showLoading();
                        a.this.eXy.aCb();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<h> arrayList) {
        if (this.bMJ != null && this.bJY != null && this.bMI != null && this.eWR != null) {
            this.bMJ.setRefreshing(false);
            if (z) {
                this.bJY.dX(0);
                this.bJY.DP();
                this.bJY.setOnClickListener(this.eXc);
            } else {
                this.bJY.dX(0);
                this.bJY.DP();
                this.bJY.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.bJY.setOnClickListener(null);
            }
            if (v.J(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0175e.ds80)), NoDataViewFactory.d.dO(e.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eWU) {
                    this.eWU = true;
                    this.bMI.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bMI.setNextPage(null);
                return;
            }
            this.bMI.removeHeaderView(this.mNoDataView);
            this.eWU = false;
            this.bMI.setNextPage(this.bJY);
            this.eWR.setData(arrayList);
            this.eWR.notifyDataSetChanged();
        }
    }

    public void iX(boolean z) {
        if (this.bMJ != null) {
            this.bMJ.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        if (this.bJX != null) {
            this.bJX.onChangeSkinType(this.mContext, i);
        }
        if (this.bJY != null) {
            this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bJY.dW(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.eWR != null) {
            this.eWR.notifyDataSetChanged();
        }
        al.j(this.eXx, e.d.cp_bg_line_e);
        al.j(this.bMJ, e.d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.eWR != null) {
            this.eWR.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.eWR != null) {
            this.eWR.d(nVar);
        }
    }

    public List<h> getDatas() {
        if (this.bMI == null) {
            return null;
        }
        return this.bMI.getData();
    }

    public View getRootView() {
        return this.eXx;
    }
}
