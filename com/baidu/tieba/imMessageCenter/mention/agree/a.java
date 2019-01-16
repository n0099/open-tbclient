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
    private NoNetworkView bPl;
    private PbListView bPm;
    private BdTypeRecyclerView bRY;
    protected BdSwipeRefreshLayout bRZ;
    private e fiF;
    private boolean fiI;
    private View fjm;
    private InterfaceC0259a fjn;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private View.OnClickListener fiQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bPm != null && a.this.fjn != null) {
                a.this.bPm.ez(0);
                a.this.bPm.setOnClickListener(null);
                a.this.bPm.Fp();
                a.this.fjn.aEu();
            }
        }
    };
    private final j.b bSe = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bI(boolean z) {
            if (com.baidu.adp.lib.util.j.kV()) {
                if (a.this.fjn != null) {
                    a.this.fjn.aEv();
                }
            } else if (a.this.bRZ != null) {
                a.this.bRZ.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0259a {
        void aEu();

        void aEv();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.fjm = view.findViewById(e.g.agree_me_layout);
        o(tbPageContext);
        this.fiF = new com.baidu.tieba.imMessageCenter.mention.base.e(tbPageContext, this.bRY);
    }

    public void a(InterfaceC0259a interfaceC0259a) {
        this.fjn = interfaceC0259a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.fjm != null) {
            if (this.mPullView == null) {
                this.mPullView = new k(tbPageContext);
                this.mPullView.a(this.bSe);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.bPm == null) {
                this.bPm = new PbListView(tbPageContext.getPageActivity());
                this.bPm.getView();
            }
            this.bPm.ex(e.d.cp_bg_line_e);
            this.bPm.setHeight(l.h(tbPageContext.getContext(), e.C0210e.tbds182));
            this.bPm.Fm();
            this.bPm.setTextSize(e.C0210e.tbfontsize33);
            this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bPm.ew(e.d.cp_cont_e);
            this.bPm.setOnClickListener(this.fiQ);
            this.bPl = (NoNetworkView) this.fjm.findViewById(e.g.no_networkview);
            this.bPl.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.fjm.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(e.j.agree_me));
            this.bRZ = (BdSwipeRefreshLayout) this.fjm.findViewById(e.g.agree_me_pull_refresh_layout);
            this.bRZ.setProgressView(this.mPullView);
            this.bRY = (BdTypeRecyclerView) this.fjm.findViewById(e.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.bRY.getItemAnimator()).setSupportsChangeAnimations(false);
            this.bRY.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.bRY.setFadingEdgeLength(0);
            this.bRY.setBackgroundColor(al.getColor(e.d.transparent));
            this.bRY.setOverScrollMode(2);
            this.bRY.addItemDecoration(new d());
            this.bRY.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.bRY.setNextPage(this.bPm);
            this.bRY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.bPm != null && a.this.fjn != null) {
                        a.this.bPm.ez(0);
                        a.this.bPm.setOnClickListener(null);
                        a.this.bPm.showLoading();
                        a.this.fjn.aEu();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<h> arrayList) {
        if (this.bRZ != null && this.bPm != null && this.bRY != null && this.fiF != null) {
            this.bRZ.setRefreshing(false);
            if (z) {
                this.bPm.ez(0);
                this.bPm.Fq();
                this.bPm.setOnClickListener(this.fiQ);
            } else {
                this.bPm.ez(0);
                this.bPm.Fq();
                this.bPm.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.bPm.setOnClickListener(null);
            }
            if (v.I(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.fiI) {
                    this.fiI = true;
                    this.bRY.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bRY.setNextPage(null);
                return;
            }
            this.bRY.removeHeaderView(this.mNoDataView);
            this.fiI = false;
            this.bRY.setNextPage(this.bPm);
            this.fiF.setData(arrayList);
            this.fiF.notifyDataSetChanged();
        }
    }

    public void jm(boolean z) {
        if (this.bRZ != null) {
            this.bRZ.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.bPl != null) {
            this.bPl.onChangeSkinType(this.mContext, i);
        }
        if (this.bPm != null) {
            this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bPm.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.fiF != null) {
            this.fiF.notifyDataSetChanged();
        }
        al.j(this.fjm, e.d.cp_bg_line_e);
        al.j(this.bRZ, e.d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.fiF != null) {
            this.fiF.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.fiF != null) {
            this.fiF.d(nVar);
        }
    }

    public List<h> getDatas() {
        if (this.bRY == null) {
            return null;
        }
        return this.bRY.getData();
    }

    public View getRootView() {
        return this.fjm;
    }
}
