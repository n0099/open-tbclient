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
    private NoNetworkView bKI;
    private PbListView bKJ;
    private BdTypeRecyclerView bNt;
    protected BdSwipeRefreshLayout bNu;
    private View eYP;
    private InterfaceC0248a eYQ;
    private e eYj;
    private boolean eYm;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private View.OnClickListener eYu = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bKJ != null && a.this.eYQ != null) {
                a.this.bKJ.el(0);
                a.this.bKJ.setOnClickListener(null);
                a.this.bKJ.DY();
                a.this.eYQ.aBy();
            }
        }
    };
    private final j.b bNz = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bG(boolean z) {
            if (com.baidu.adp.lib.util.j.kV()) {
                if (a.this.eYQ != null) {
                    a.this.eYQ.aBz();
                }
            } else if (a.this.bNu != null) {
                a.this.bNu.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0248a {
        void aBy();

        void aBz();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.eYP = view.findViewById(e.g.agree_me_layout);
        o(tbPageContext);
        this.eYj = new com.baidu.tieba.imMessageCenter.mention.base.e(tbPageContext, this.bNt);
    }

    public void a(InterfaceC0248a interfaceC0248a) {
        this.eYQ = interfaceC0248a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.eYP != null) {
            if (this.mPullView == null) {
                this.mPullView = new k(tbPageContext);
                this.mPullView.a(this.bNz);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.bKJ == null) {
                this.bKJ = new PbListView(tbPageContext.getPageActivity());
                this.bKJ.getView();
            }
            this.bKJ.ej(e.d.cp_bg_line_e);
            this.bKJ.setHeight(l.h(tbPageContext.getContext(), e.C0200e.tbds182));
            this.bKJ.DV();
            this.bKJ.setTextSize(e.C0200e.tbfontsize33);
            this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bKJ.ei(e.d.cp_cont_e);
            this.bKJ.setOnClickListener(this.eYu);
            this.bKI = (NoNetworkView) this.eYP.findViewById(e.g.no_networkview);
            this.bKI.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.eYP.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(e.j.agree_me));
            this.bNu = (BdSwipeRefreshLayout) this.eYP.findViewById(e.g.agree_me_pull_refresh_layout);
            this.bNu.setProgressView(this.mPullView);
            this.bNt = (BdTypeRecyclerView) this.eYP.findViewById(e.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.bNt.getItemAnimator()).setSupportsChangeAnimations(false);
            this.bNt.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.bNt.setFadingEdgeLength(0);
            this.bNt.setBackgroundColor(al.getColor(e.d.transparent));
            this.bNt.setOverScrollMode(2);
            this.bNt.addItemDecoration(new d());
            this.bNt.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.bNt.setNextPage(this.bKJ);
            this.bNt.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.bKJ != null && a.this.eYQ != null) {
                        a.this.bKJ.el(0);
                        a.this.bKJ.setOnClickListener(null);
                        a.this.bKJ.showLoading();
                        a.this.eYQ.aBy();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<h> arrayList) {
        if (this.bNu != null && this.bKJ != null && this.bNt != null && this.eYj != null) {
            this.bNu.setRefreshing(false);
            if (z) {
                this.bKJ.el(0);
                this.bKJ.DZ();
                this.bKJ.setOnClickListener(this.eYu);
            } else {
                this.bKJ.el(0);
                this.bKJ.DZ();
                this.bKJ.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.bKJ.setOnClickListener(null);
            }
            if (v.I(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0200e.ds80)), NoDataViewFactory.d.ec(e.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eYm) {
                    this.eYm = true;
                    this.bNt.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bNt.setNextPage(null);
                return;
            }
            this.bNt.removeHeaderView(this.mNoDataView);
            this.eYm = false;
            this.bNt.setNextPage(this.bKJ);
            this.eYj.setData(arrayList);
            this.eYj.notifyDataSetChanged();
        }
    }

    public void jg(boolean z) {
        if (this.bNu != null) {
            this.bNu.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        if (this.bKI != null) {
            this.bKI.onChangeSkinType(this.mContext, i);
        }
        if (this.bKJ != null) {
            this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bKJ.ek(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.eYj != null) {
            this.eYj.notifyDataSetChanged();
        }
        al.j(this.eYP, e.d.cp_bg_line_e);
        al.j(this.bNu, e.d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.eYj != null) {
            this.eYj.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.eYj != null) {
            this.eYj.d(nVar);
        }
    }

    public List<h> getDatas() {
        if (this.bNt == null) {
            return null;
        }
        return this.bNt.getData();
    }

    public View getRootView() {
        return this.eYP;
    }
}
