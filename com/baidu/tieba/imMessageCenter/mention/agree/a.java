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
    private NoNetworkView dbr;
    private PbListView dbs;
    protected BdSwipeRefreshLayout dcF;
    private View gyY;
    private InterfaceC0327a gyZ;
    private e gyt;
    private boolean gyw;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View.OnClickListener gyE = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dbs != null && a.this.gyZ != null) {
                a.this.dbs.ic(0);
                a.this.dbs.setOnClickListener(null);
                a.this.dbs.aez();
                a.this.gyZ.bfb();
            }
        }
    };
    private final h.c dhu = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (j.kY()) {
                if (a.this.gyZ != null) {
                    a.this.gyZ.bfc();
                }
            } else if (a.this.dcF != null) {
                a.this.dcF.setRefreshing(false);
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
        this.gyY = view.findViewById(d.g.agree_me_layout);
        o(tbPageContext);
        this.gyt = new e(tbPageContext, this.Qr);
    }

    public void a(InterfaceC0327a interfaceC0327a) {
        this.gyZ = interfaceC0327a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.gyY != null) {
            if (this.mPullView == null) {
                this.mPullView = new i(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.dhu);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.dbs == null) {
                this.dbs = new PbListView(tbPageContext.getPageActivity());
                this.dbs.getView();
            }
            this.dbs.ia(d.C0277d.cp_bg_line_e);
            this.dbs.setHeight(l.h(tbPageContext.getContext(), d.e.tbds182));
            this.dbs.aew();
            this.dbs.setTextSize(d.e.tbfontsize33);
            this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.dbs.hZ(d.C0277d.cp_cont_e);
            this.dbs.setOnClickListener(this.gyE);
            this.dbr = (NoNetworkView) this.gyY.findViewById(d.g.no_networkview);
            this.dbr.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.gyY.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(d.j.agree_me));
            this.dcF = (BdSwipeRefreshLayout) this.gyY.findViewById(d.g.agree_me_pull_refresh_layout);
            this.dcF.setProgressView(this.mPullView);
            this.Qr = (BdTypeRecyclerView) this.gyY.findViewById(d.g.agree_me_recycler_view);
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
            this.Qr.setNextPage(this.dbs);
            this.Qr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.dbs != null && a.this.gyZ != null) {
                        a.this.dbs.ic(0);
                        a.this.dbs.setOnClickListener(null);
                        a.this.dbs.showLoading();
                        a.this.gyZ.bfb();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.dcF != null && this.dbs != null && this.Qr != null && this.gyt != null) {
            this.dcF.setRefreshing(false);
            if (z) {
                this.dbs.ic(0);
                this.dbs.aeA();
                this.dbs.setOnClickListener(this.gyE);
            } else {
                this.dbs.ic(0);
                this.dbs.aeA();
                this.dbs.setText(this.mContext.getResources().getString(d.j.list_no_more));
                this.dbs.setOnClickListener(null);
            }
            if (v.T(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.hT(d.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gyw) {
                    this.gyw = true;
                    this.Qr.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Qr.setNextPage(null);
                return;
            }
            this.Qr.removeHeaderView(this.mNoDataView);
            this.gyw = false;
            this.Qr.setNextPage(this.dbs);
            this.gyt.setData(arrayList);
            this.gyt.notifyDataSetChanged();
        }
    }

    public void lM(boolean z) {
        if (this.dcF != null) {
            this.dcF.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        if (this.dbr != null) {
            this.dbr.onChangeSkinType(this.mContext, i);
        }
        if (this.dbs != null) {
            this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.dbs.ib(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.gyt != null) {
            this.gyt.notifyDataSetChanged();
        }
        al.l(this.gyY, d.C0277d.cp_bg_line_e);
        al.l(this.dcF, d.C0277d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.gyt != null) {
            this.gyt.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(s sVar) {
        if (this.gyt != null) {
            this.gyt.d(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.Qr == null) {
            return null;
        }
        return this.Qr.getData();
    }

    public View getRootView() {
        return this.gyY;
    }
}
