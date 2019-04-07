package com.baidu.tieba.imMessageCenter.mention.agree;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView Qr;
    private NoNetworkView dbq;
    private PbListView dbr;
    protected BdSwipeRefreshLayout dcE;
    private View gyX;
    private InterfaceC0327a gyY;
    private e gys;
    private boolean gyv;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View.OnClickListener gyD = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dbr != null && a.this.gyY != null) {
                a.this.dbr.ic(0);
                a.this.dbr.setOnClickListener(null);
                a.this.dbr.aez();
                a.this.gyY.bfb();
            }
        }
    };
    private final h.c dht = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (j.kY()) {
                if (a.this.gyY != null) {
                    a.this.gyY.bfc();
                }
            } else if (a.this.dcE != null) {
                a.this.dcE.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0327a {
        void bfb();

        void bfc();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.gyX = view.findViewById(d.g.agree_me_layout);
        o(tbPageContext);
        this.gys = new e(tbPageContext, this.Qr);
    }

    public void a(InterfaceC0327a interfaceC0327a) {
        this.gyY = interfaceC0327a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.gyX != null) {
            if (this.mPullView == null) {
                this.mPullView = new i(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.dht);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.dbr == null) {
                this.dbr = new PbListView(tbPageContext.getPageActivity());
                this.dbr.getView();
            }
            this.dbr.ia(d.C0277d.cp_bg_line_e);
            this.dbr.setHeight(l.h(tbPageContext.getContext(), d.e.tbds182));
            this.dbr.aew();
            this.dbr.setTextSize(d.e.tbfontsize33);
            this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.dbr.hZ(d.C0277d.cp_cont_e);
            this.dbr.setOnClickListener(this.gyD);
            this.dbq = (NoNetworkView) this.gyX.findViewById(d.g.no_networkview);
            this.dbq.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.gyX.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(d.j.agree_me));
            this.dcE = (BdSwipeRefreshLayout) this.gyX.findViewById(d.g.agree_me_pull_refresh_layout);
            this.dcE.setProgressView(this.mPullView);
            this.Qr = (BdTypeRecyclerView) this.gyX.findViewById(d.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Qr.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Qr.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.Qr.setFadingEdgeLength(0);
            this.Qr.setBackgroundColor(al.getColor(d.C0277d.transparent));
            this.Qr.setOverScrollMode(2);
            this.Qr.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
            this.Qr.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Qr.setNextPage(this.dbr);
            this.Qr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.dbr != null && a.this.gyY != null) {
                        a.this.dbr.ic(0);
                        a.this.dbr.setOnClickListener(null);
                        a.this.dbr.showLoading();
                        a.this.gyY.bfb();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.dcE != null && this.dbr != null && this.Qr != null && this.gys != null) {
            this.dcE.setRefreshing(false);
            if (z) {
                this.dbr.ic(0);
                this.dbr.aeA();
                this.dbr.setOnClickListener(this.gyD);
            } else {
                this.dbr.ic(0);
                this.dbr.aeA();
                this.dbr.setText(this.mContext.getResources().getString(d.j.list_no_more));
                this.dbr.setOnClickListener(null);
            }
            if (v.T(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.hT(d.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gyv) {
                    this.gyv = true;
                    this.Qr.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Qr.setNextPage(null);
                return;
            }
            this.Qr.removeHeaderView(this.mNoDataView);
            this.gyv = false;
            this.Qr.setNextPage(this.dbr);
            this.gys.setData(arrayList);
            this.gys.notifyDataSetChanged();
        }
    }

    public void lM(boolean z) {
        if (this.dcE != null) {
            this.dcE.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        if (this.dbq != null) {
            this.dbq.onChangeSkinType(this.mContext, i);
        }
        if (this.dbr != null) {
            this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.dbr.ib(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.gys != null) {
            this.gys.notifyDataSetChanged();
        }
        al.l(this.gyX, d.C0277d.cp_bg_line_e);
        al.l(this.dcE, d.C0277d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.gys != null) {
            this.gys.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(s sVar) {
        if (this.gys != null) {
            this.gys.d(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.Qr == null) {
            return null;
        }
        return this.Qr.getData();
    }

    public View getRootView() {
        return this.gyX;
    }
}
