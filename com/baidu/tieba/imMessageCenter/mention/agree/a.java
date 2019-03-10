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
    private BdTypeRecyclerView Qq;
    private NoNetworkView dbq;
    private PbListView dbr;
    protected BdSwipeRefreshLayout dcE;
    private e gyG;
    private boolean gyJ;
    private View gzl;
    private InterfaceC0264a gzm;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View.OnClickListener gyR = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dbr != null && a.this.gzm != null) {
                a.this.dbr.id(0);
                a.this.dbr.setOnClickListener(null);
                a.this.dbr.aeC();
                a.this.gzm.bfe();
            }
        }
    };
    private final h.c dhu = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (j.kY()) {
                if (a.this.gzm != null) {
                    a.this.gzm.bff();
                }
            } else if (a.this.dcE != null) {
                a.this.dcE.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0264a {
        void bfe();

        void bff();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.gzl = view.findViewById(d.g.agree_me_layout);
        p(tbPageContext);
        this.gyG = new e(tbPageContext, this.Qq);
    }

    public void a(InterfaceC0264a interfaceC0264a) {
        this.gzm = interfaceC0264a;
    }

    private void p(TbPageContext tbPageContext) {
        if (this.gzl != null) {
            if (this.mPullView == null) {
                this.mPullView = new i(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.dhu);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.dbr == null) {
                this.dbr = new PbListView(tbPageContext.getPageActivity());
                this.dbr.getView();
            }
            this.dbr.ib(d.C0236d.cp_bg_line_e);
            this.dbr.setHeight(l.h(tbPageContext.getContext(), d.e.tbds182));
            this.dbr.aez();
            this.dbr.setTextSize(d.e.tbfontsize33);
            this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_d));
            this.dbr.ia(d.C0236d.cp_cont_e);
            this.dbr.setOnClickListener(this.gyR);
            this.dbq = (NoNetworkView) this.gzl.findViewById(d.g.no_networkview);
            this.dbq.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.gzl.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(d.j.agree_me));
            this.dcE = (BdSwipeRefreshLayout) this.gzl.findViewById(d.g.agree_me_pull_refresh_layout);
            this.dcE.setProgressView(this.mPullView);
            this.Qq = (BdTypeRecyclerView) this.gzl.findViewById(d.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Qq.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Qq.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.Qq.setFadingEdgeLength(0);
            this.Qq.setBackgroundColor(al.getColor(d.C0236d.transparent));
            this.Qq.setOverScrollMode(2);
            this.Qq.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
            this.Qq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Qq.setNextPage(this.dbr);
            this.Qq.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.dbr != null && a.this.gzm != null) {
                        a.this.dbr.id(0);
                        a.this.dbr.setOnClickListener(null);
                        a.this.dbr.showLoading();
                        a.this.gzm.bfe();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.dcE != null && this.dbr != null && this.Qq != null && this.gyG != null) {
            this.dcE.setRefreshing(false);
            if (z) {
                this.dbr.id(0);
                this.dbr.aeD();
                this.dbr.setOnClickListener(this.gyR);
            } else {
                this.dbr.id(0);
                this.dbr.aeD();
                this.dbr.setText(this.mContext.getResources().getString(d.j.list_no_more));
                this.dbr.setOnClickListener(null);
            }
            if (v.T(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.hU(d.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.l(this.mNoDataView, d.C0236d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gyJ) {
                    this.gyJ = true;
                    this.Qq.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Qq.setNextPage(null);
                return;
            }
            this.Qq.removeHeaderView(this.mNoDataView);
            this.gyJ = false;
            this.Qq.setNextPage(this.dbr);
            this.gyG.setData(arrayList);
            this.gyG.notifyDataSetChanged();
        }
    }

    public void lM(boolean z) {
        if (this.dcE != null) {
            this.dcE.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.dbq != null) {
            this.dbq.onChangeSkinType(this.mContext, i);
        }
        if (this.dbr != null) {
            this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_d));
            this.dbr.ic(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, d.C0236d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.gyG != null) {
            this.gyG.notifyDataSetChanged();
        }
        al.l(this.gzl, d.C0236d.cp_bg_line_e);
        al.l(this.dcE, d.C0236d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.gyG != null) {
            this.gyG.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(s sVar) {
        if (this.gyG != null) {
            this.gyG.d(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.Qq == null) {
            return null;
        }
        return this.Qq.getData();
    }

    public View getRootView() {
        return this.gzl;
    }
}
