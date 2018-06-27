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
    private NoNetworkView buT;
    private PbListView buU;
    private BdTypeRecyclerView bxH;
    protected BdSwipeRefreshLayout bxI;
    private View eEJ;
    private InterfaceC0187a eEK;
    private e eEd;
    private boolean eEg;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View.OnClickListener eEo = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.buU != null && a.this.eEK != null) {
                a.this.buU.dA(0);
                a.this.buU.setOnClickListener(null);
                a.this.buU.AH();
                a.this.eEK.aOn();
            }
        }
    };
    private final g.b bxO = new g.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void aU(boolean z) {
            if (j.jD()) {
                if (a.this.eEK != null) {
                    a.this.eEK.aOm();
                }
            } else if (a.this.bxI != null) {
                a.this.bxI.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0187a {
        void aOm();

        void aOn();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.eEJ = view.findViewById(d.g.agree_me_layout);
        o(tbPageContext);
        this.eEd = new e(tbPageContext, this.bxH);
    }

    public void a(InterfaceC0187a interfaceC0187a) {
        this.eEK = interfaceC0187a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.eEJ != null) {
            if (this.mPullView == null) {
                this.mPullView = new h(tbPageContext);
                this.mPullView.a(this.bxO);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.buU == null) {
                this.buU = new PbListView(tbPageContext.getPageActivity());
                this.buU.getView();
            }
            this.buU.dy(d.C0142d.cp_bg_line_e);
            this.buU.setHeight(l.e(tbPageContext.getContext(), d.e.tbds182));
            this.buU.AE();
            this.buU.setTextSize(d.e.tbfontsize33);
            this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
            this.buU.dx(d.C0142d.cp_cont_e);
            this.buU.setOnClickListener(this.eEo);
            this.buT = (NoNetworkView) this.eEJ.findViewById(d.g.no_networkview);
            this.buT.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.eEJ.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(d.k.agree_me));
            this.bxI = (BdSwipeRefreshLayout) this.eEJ.findViewById(d.g.agree_me_pull_refresh_layout);
            this.bxI.setProgressView(this.mPullView);
            this.bxH = (BdTypeRecyclerView) this.eEJ.findViewById(d.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.bxH.getItemAnimator()).setSupportsChangeAnimations(false);
            this.bxH.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.bxH.setFadingEdgeLength(0);
            this.bxH.setBackgroundColor(am.getColor(d.C0142d.transparent));
            this.bxH.setOverScrollMode(2);
            this.bxH.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
            this.bxH.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.bxH.setNextPage(this.buU);
            this.bxH.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.buU != null && a.this.eEK != null) {
                        a.this.buU.dA(0);
                        a.this.buU.setOnClickListener(null);
                        a.this.buU.showLoading();
                        a.this.eEK.aOn();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.bxI != null && this.buU != null && this.bxH != null && this.eEd != null) {
            this.bxI.setRefreshing(false);
            if (z) {
                this.buU.dA(0);
                this.buU.AI();
                this.buU.setOnClickListener(this.eEo);
            } else {
                this.buU.dA(0);
                this.buU.AI();
                this.buU.setText(this.mContext.getResources().getString(d.k.list_no_more));
                this.buU.setOnClickListener(null);
            }
            if (w.A(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.ds(d.k.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.j(this.mNoDataView, d.C0142d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eEg) {
                    this.eEg = true;
                    this.bxH.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bxH.setNextPage(null);
                return;
            }
            this.bxH.removeHeaderView(this.mNoDataView);
            this.eEg = false;
            this.bxH.setNextPage(this.buU);
            this.eEd.setData(arrayList);
            this.eEd.notifyDataSetChanged();
        }
    }

    public void ie(boolean z) {
        if (this.bxI != null) {
            this.bxI.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.buT != null) {
            this.buT.onChangeSkinType(this.mContext, i);
        }
        if (this.buU != null) {
            this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
            this.buU.dz(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.j(this.mNoDataView, d.C0142d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.eEd != null) {
            this.eEd.notifyDataSetChanged();
        }
        am.j(this.eEJ, d.C0142d.cp_bg_line_e);
        am.j(this.bxI, d.C0142d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.eEd != null) {
            this.eEd.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.eEd != null) {
            this.eEd.d(nVar);
        }
    }

    public List<com.baidu.adp.widget.ListView.h> getDatas() {
        if (this.bxH == null) {
            return null;
        }
        return this.bxH.getData();
    }

    public View getRootView() {
        return this.eEJ;
    }
}
