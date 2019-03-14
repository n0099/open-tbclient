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
    private NoNetworkView dbm;
    private PbListView dbn;
    protected BdSwipeRefreshLayout dcA;
    private e gyF;
    private boolean gyI;
    private View gzk;
    private InterfaceC0327a gzl;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View.OnClickListener gyQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dbn != null && a.this.gzl != null) {
                a.this.dbn.id(0);
                a.this.dbn.setOnClickListener(null);
                a.this.dbn.aeC();
                a.this.gzl.bfd();
            }
        }
    };
    private final h.c dhq = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (j.kY()) {
                if (a.this.gzl != null) {
                    a.this.gzl.bfe();
                }
            } else if (a.this.dcA != null) {
                a.this.dcA.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0327a {
        void bfd();

        void bfe();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.gzk = view.findViewById(d.g.agree_me_layout);
        p(tbPageContext);
        this.gyF = new e(tbPageContext, this.Qr);
    }

    public void a(InterfaceC0327a interfaceC0327a) {
        this.gzl = interfaceC0327a;
    }

    private void p(TbPageContext tbPageContext) {
        if (this.gzk != null) {
            if (this.mPullView == null) {
                this.mPullView = new i(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.dhq);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.dbn == null) {
                this.dbn = new PbListView(tbPageContext.getPageActivity());
                this.dbn.getView();
            }
            this.dbn.ib(d.C0277d.cp_bg_line_e);
            this.dbn.setHeight(l.h(tbPageContext.getContext(), d.e.tbds182));
            this.dbn.aez();
            this.dbn.setTextSize(d.e.tbfontsize33);
            this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.dbn.ia(d.C0277d.cp_cont_e);
            this.dbn.setOnClickListener(this.gyQ);
            this.dbm = (NoNetworkView) this.gzk.findViewById(d.g.no_networkview);
            this.dbm.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.gzk.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(d.j.agree_me));
            this.dcA = (BdSwipeRefreshLayout) this.gzk.findViewById(d.g.agree_me_pull_refresh_layout);
            this.dcA.setProgressView(this.mPullView);
            this.Qr = (BdTypeRecyclerView) this.gzk.findViewById(d.g.agree_me_recycler_view);
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
            this.Qr.setNextPage(this.dbn);
            this.Qr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.dbn != null && a.this.gzl != null) {
                        a.this.dbn.id(0);
                        a.this.dbn.setOnClickListener(null);
                        a.this.dbn.showLoading();
                        a.this.gzl.bfd();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.dcA != null && this.dbn != null && this.Qr != null && this.gyF != null) {
            this.dcA.setRefreshing(false);
            if (z) {
                this.dbn.id(0);
                this.dbn.aeD();
                this.dbn.setOnClickListener(this.gyQ);
            } else {
                this.dbn.id(0);
                this.dbn.aeD();
                this.dbn.setText(this.mContext.getResources().getString(d.j.list_no_more));
                this.dbn.setOnClickListener(null);
            }
            if (v.T(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.hU(d.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gyI) {
                    this.gyI = true;
                    this.Qr.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Qr.setNextPage(null);
                return;
            }
            this.Qr.removeHeaderView(this.mNoDataView);
            this.gyI = false;
            this.Qr.setNextPage(this.dbn);
            this.gyF.setData(arrayList);
            this.gyF.notifyDataSetChanged();
        }
    }

    public void lM(boolean z) {
        if (this.dcA != null) {
            this.dcA.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.dbm != null) {
            this.dbm.onChangeSkinType(this.mContext, i);
        }
        if (this.dbn != null) {
            this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.dbn.ic(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.gyF != null) {
            this.gyF.notifyDataSetChanged();
        }
        al.l(this.gzk, d.C0277d.cp_bg_line_e);
        al.l(this.dcA, d.C0277d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.gyF != null) {
            this.gyF.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(s sVar) {
        if (this.gyF != null) {
            this.gyF.d(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.Qr == null) {
            return null;
        }
        return this.Qr.getData();
    }

    public View getRootView() {
        return this.gzk;
    }
}
