package com.baidu.tieba.imMessageCenter.mention.agree;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private PbListView bvA;
    private NoNetworkView bvz;
    private BdTypeRecyclerView bym;
    protected BdSwipeRefreshLayout byn;
    private e eHX;
    private View eID;
    private InterfaceC0186a eIE;
    private boolean eIa;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View.OnClickListener eIi = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bvA != null && a.this.eIE != null) {
                a.this.bvA.dD(0);
                a.this.bvA.setOnClickListener(null);
                a.this.bvA.Ax();
                a.this.eIE.aPn();
            }
        }
    };
    private final g.b byt = new g.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void aS(boolean z) {
            if (j.jE()) {
                if (a.this.eIE != null) {
                    a.this.eIE.aPm();
                }
            } else if (a.this.byn != null) {
                a.this.byn.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0186a {
        void aPm();

        void aPn();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.eID = view.findViewById(d.g.agree_me_layout);
        o(tbPageContext);
        this.eHX = new e(tbPageContext, this.bym);
    }

    public void a(InterfaceC0186a interfaceC0186a) {
        this.eIE = interfaceC0186a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.eID != null) {
            if (this.mPullView == null) {
                this.mPullView = new h(tbPageContext);
                this.mPullView.a(this.byt);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.bvA == null) {
                this.bvA = new PbListView(tbPageContext.getPageActivity());
                this.bvA.getView();
            }
            this.bvA.dB(d.C0140d.cp_bg_line_e);
            this.bvA.setHeight(l.f(tbPageContext.getContext(), d.e.tbds182));
            this.bvA.Au();
            this.bvA.setTextSize(d.e.tbfontsize33);
            this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
            this.bvA.dA(d.C0140d.cp_cont_e);
            this.bvA.setOnClickListener(this.eIi);
            this.bvz = (NoNetworkView) this.eID.findViewById(d.g.no_networkview);
            this.bvz.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.eID.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(d.j.agree_me));
            this.byn = (BdSwipeRefreshLayout) this.eID.findViewById(d.g.agree_me_pull_refresh_layout);
            this.byn.setProgressView(this.mPullView);
            this.bym = (BdTypeRecyclerView) this.eID.findViewById(d.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.bym.getItemAnimator()).setSupportsChangeAnimations(false);
            this.bym.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.bym.setFadingEdgeLength(0);
            this.bym.setBackgroundColor(am.getColor(d.C0140d.transparent));
            this.bym.setOverScrollMode(2);
            this.bym.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
            this.bym.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.bym.setNextPage(this.bvA);
            this.bym.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.bvA != null && a.this.eIE != null) {
                        a.this.bvA.dD(0);
                        a.this.bvA.setOnClickListener(null);
                        a.this.bvA.showLoading();
                        a.this.eIE.aPn();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.byn != null && this.bvA != null && this.bym != null && this.eHX != null) {
            this.byn.setRefreshing(false);
            if (z) {
                this.bvA.dD(0);
                this.bvA.Ay();
                this.bvA.setOnClickListener(this.eIi);
            } else {
                this.bvA.dD(0);
                this.bvA.Ay();
                this.bvA.setText(this.mContext.getResources().getString(d.j.list_no_more));
                this.bvA.setOnClickListener(null);
            }
            if (w.z(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.du(d.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.j(this.mNoDataView, d.C0140d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eIa) {
                    this.eIa = true;
                    this.bym.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bym.setNextPage(null);
                return;
            }
            this.bym.removeHeaderView(this.mNoDataView);
            this.eIa = false;
            this.bym.setNextPage(this.bvA);
            this.eHX.setData(arrayList);
            this.eHX.notifyDataSetChanged();
        }
    }

    public void ih(boolean z) {
        if (this.byn != null) {
            this.byn.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        if (this.bvz != null) {
            this.bvz.onChangeSkinType(this.mContext, i);
        }
        if (this.bvA != null) {
            this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
            this.bvA.dC(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.j(this.mNoDataView, d.C0140d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.eHX != null) {
            this.eHX.notifyDataSetChanged();
        }
        am.j(this.eID, d.C0140d.cp_bg_line_e);
        am.j(this.byn, d.C0140d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.eHX != null) {
            this.eHX.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.eHX != null) {
            this.eHX.d(nVar);
        }
    }

    public List<com.baidu.adp.widget.ListView.h> getDatas() {
        if (this.bym == null) {
            return null;
        }
        return this.bym.getData();
    }

    public View getRootView() {
        return this.eID;
    }
}
