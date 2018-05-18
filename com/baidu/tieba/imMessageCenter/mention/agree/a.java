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
    private NoNetworkView blp;
    private PbListView blq;
    private BdTypeRecyclerView bof;
    protected BdSwipeRefreshLayout bog;
    private e eoW;
    private boolean eoZ;
    private View epC;
    private InterfaceC0169a epD;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private f mPullView;
    private View.OnClickListener eph = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (a.this.blq != null && a.this.epD != null) {
                a.this.blq.dx(0);
                a.this.blq.setOnClickListener(null);
                a.this.blq.wQ();
                a.this.epD.aIM();
            }
        }
    };
    private final e.b bom = new e.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.e.b
        public void aO(boolean z) {
            if (j.gP()) {
                if (a.this.epD != null) {
                    a.this.epD.aIL();
                }
            } else if (a.this.bog != null) {
                a.this.bog.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0169a {
        void aIL();

        void aIM();
    }

    public a(TbPageContext tbPageContext, View view2) {
        this.mContext = tbPageContext;
        this.epC = view2.findViewById(d.g.agree_me_layout);
        o(tbPageContext);
        this.eoW = new com.baidu.tieba.imMessageCenter.mention.base.e(tbPageContext, this.bof);
    }

    public void a(InterfaceC0169a interfaceC0169a) {
        this.epD = interfaceC0169a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.epC != null) {
            if (this.mPullView == null) {
                this.mPullView = new f(tbPageContext);
                this.mPullView.a(this.bom);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.blq == null) {
                this.blq = new PbListView(tbPageContext.getPageActivity());
                this.blq.getView();
            }
            this.blq.dv(d.C0126d.cp_bg_line_e);
            this.blq.setHeight(l.e(tbPageContext.getContext(), d.e.tbds182));
            this.blq.wN();
            this.blq.setTextSize(d.e.tbfontsize33);
            this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            this.blq.du(d.C0126d.cp_cont_e);
            this.blq.setOnClickListener(this.eph);
            this.blp = (NoNetworkView) this.epC.findViewById(d.g.no_networkview);
            this.blp.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.epC.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(d.k.agree_me));
            this.bog = (BdSwipeRefreshLayout) this.epC.findViewById(d.g.agree_me_pull_refresh_layout);
            this.bog.setProgressView(this.mPullView);
            this.bof = (BdTypeRecyclerView) this.epC.findViewById(d.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.bof.getItemAnimator()).setSupportsChangeAnimations(false);
            this.bof.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.bof.setFadingEdgeLength(0);
            this.bof.setOverScrollMode(2);
            this.bof.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
            this.bof.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                }
            });
            this.bof.setNextPage(this.blq);
            this.bof.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.blq != null && a.this.epD != null) {
                        a.this.blq.dx(0);
                        a.this.blq.setOnClickListener(null);
                        a.this.blq.showLoading();
                        a.this.epD.aIM();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<h> arrayList) {
        if (this.bog != null && this.blq != null && this.bof != null && this.eoW != null) {
            this.bog.setRefreshing(false);
            if (z) {
                this.blq.dx(0);
                this.blq.wR();
                this.blq.setOnClickListener(this.eph);
            } else {
                this.blq.dx(0);
                this.blq.wR();
                this.blq.setText(this.mContext.getResources().getString(d.k.list_no_more));
                this.blq.setOnClickListener(null);
            }
            if (v.w(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dp(d.k.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eoZ) {
                    this.eoZ = true;
                    this.bof.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bof.setNextPage(null);
                return;
            }
            this.bof.removeHeaderView(this.mNoDataView);
            this.eoZ = false;
            this.bof.setNextPage(this.blq);
            this.eoW.setData(arrayList);
            this.eoW.notifyDataSetChanged();
        }
    }

    public void hO(boolean z) {
        if (this.bog != null) {
            this.bog.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.blp != null) {
            this.blp.onChangeSkinType(this.mContext, i);
        }
        if (this.blq != null) {
            this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            this.blq.dw(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.eoW != null) {
            this.eoW.notifyDataSetChanged();
        }
        ak.j(this.bof, d.C0126d.cp_bg_line_e);
        ak.j(this.bog, d.C0126d.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.eoW != null) {
            this.eoW.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.eoW != null) {
            this.eoW.d(nVar);
        }
    }

    public List<h> getDatas() {
        if (this.bof == null) {
            return null;
        }
        return this.bof.getData();
    }

    public View getRootView() {
        return this.epC;
    }
}
