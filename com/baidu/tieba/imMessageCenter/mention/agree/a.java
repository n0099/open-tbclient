package com.baidu.tieba.imMessageCenter.mention.agree;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private TbPageContext adf;
    private NoNetworkView bla;
    private PbListView blb;
    private BdTypeRecyclerView bnQ;
    protected BdSwipeRefreshLayout bnR;
    private e enQ;
    private boolean enT;
    private View eow;
    private InterfaceC0169a eox;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private f mPullView;
    private View.OnClickListener eob = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (a.this.blb != null && a.this.eox != null) {
                a.this.blb.dx(0);
                a.this.blb.setOnClickListener(null);
                a.this.blb.wR();
                a.this.eox.aIN();
            }
        }
    };
    private final e.b bnX = new e.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.e.b
        public void aO(boolean z) {
            if (j.gP()) {
                if (a.this.eox != null) {
                    a.this.eox.aIM();
                }
            } else if (a.this.bnR != null) {
                a.this.bnR.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0169a {
        void aIM();

        void aIN();
    }

    public a(TbPageContext tbPageContext, View view2) {
        this.adf = tbPageContext;
        this.eow = view2.findViewById(d.g.agree_me_layout);
        n(tbPageContext);
        this.enQ = new com.baidu.tieba.imMessageCenter.mention.base.e(tbPageContext, this.bnQ);
    }

    public void a(InterfaceC0169a interfaceC0169a) {
        this.eox = interfaceC0169a;
    }

    private void n(TbPageContext tbPageContext) {
        if (this.eow != null) {
            if (this.mPullView == null) {
                this.mPullView = new f(tbPageContext);
                this.mPullView.a(this.bnX);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.blb == null) {
                this.blb = new PbListView(tbPageContext.getPageActivity());
                this.blb.getView();
            }
            this.blb.dv(d.C0126d.cp_bg_line_e);
            this.blb.setHeight(l.e(tbPageContext.getContext(), d.e.tbds182));
            this.blb.wO();
            this.blb.setTextSize(d.e.tbfontsize33);
            this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            this.blb.du(d.C0126d.cp_cont_e);
            this.blb.setOnClickListener(this.eob);
            this.bla = (NoNetworkView) this.eow.findViewById(d.g.no_networkview);
            this.bla.onChangeSkinType(this.adf, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.eow.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.adf.getString(d.k.agree_me));
            this.bnR = (BdSwipeRefreshLayout) this.eow.findViewById(d.g.agree_me_pull_refresh_layout);
            this.bnR.setProgressView(this.mPullView);
            this.bnQ = (BdTypeRecyclerView) this.eow.findViewById(d.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.bnQ.getItemAnimator()).setSupportsChangeAnimations(false);
            this.bnQ.setLayoutManager(new LinearLayoutManager(this.adf.getContext()));
            this.bnQ.setFadingEdgeLength(0);
            this.bnQ.setOverScrollMode(2);
            this.bnQ.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
            this.bnQ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                }
            });
            this.bnQ.setNextPage(this.blb);
            this.bnQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.blb != null && a.this.eox != null) {
                        a.this.blb.dx(0);
                        a.this.blb.setOnClickListener(null);
                        a.this.blb.showLoading();
                        a.this.eox.aIN();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<h> arrayList) {
        if (this.bnR != null && this.blb != null && this.bnQ != null && this.enQ != null) {
            this.bnR.setRefreshing(false);
            if (z) {
                this.blb.dx(0);
                this.blb.wS();
                this.blb.setOnClickListener(this.eob);
            } else {
                this.blb.dx(0);
                this.blb.wS();
                this.blb.setText(this.adf.getResources().getString(d.k.list_no_more));
                this.blb.setOnClickListener(null);
            }
            if (v.w(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.adf.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.adf.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dp(d.k.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.enT) {
                    this.enT = true;
                    this.bnQ.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.adf, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bnQ.setNextPage(null);
                return;
            }
            this.bnQ.removeHeaderView(this.mNoDataView);
            this.enT = false;
            this.bnQ.setNextPage(this.blb);
            this.enQ.setData(arrayList);
            this.enQ.notifyDataSetChanged();
        }
    }

    public void hN(boolean z) {
        if (this.bnR != null) {
            this.bnR.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.bla != null) {
            this.bla.onChangeSkinType(this.adf, i);
        }
        if (this.blb != null) {
            this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            this.blb.dw(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.adf, i);
            ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.adf, i);
        }
        if (this.enQ != null) {
            this.enQ.notifyDataSetChanged();
        }
        ak.j(this.bnQ, d.C0126d.cp_bg_line_e);
        ak.j(this.bnR, d.C0126d.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.enQ != null) {
            this.enQ.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.enQ != null) {
            this.enQ.d(nVar);
        }
    }

    public List<h> getDatas() {
        if (this.bnQ == null) {
            return null;
        }
        return this.bnQ.getData();
    }

    public View getRootView() {
        return this.eow;
    }
}
