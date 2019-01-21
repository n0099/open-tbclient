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
    private NoNetworkView bPm;
    private PbListView bPn;
    private BdTypeRecyclerView bRZ;
    protected BdSwipeRefreshLayout bSa;
    private e fiG;
    private boolean fiJ;
    private View fjn;
    private InterfaceC0259a fjo;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private View.OnClickListener fiR = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bPn != null && a.this.fjo != null) {
                a.this.bPn.ez(0);
                a.this.bPn.setOnClickListener(null);
                a.this.bPn.Fp();
                a.this.fjo.aEu();
            }
        }
    };
    private final j.b bSf = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bI(boolean z) {
            if (com.baidu.adp.lib.util.j.kV()) {
                if (a.this.fjo != null) {
                    a.this.fjo.aEv();
                }
            } else if (a.this.bSa != null) {
                a.this.bSa.setRefreshing(false);
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
        this.fjn = view.findViewById(e.g.agree_me_layout);
        o(tbPageContext);
        this.fiG = new com.baidu.tieba.imMessageCenter.mention.base.e(tbPageContext, this.bRZ);
    }

    public void a(InterfaceC0259a interfaceC0259a) {
        this.fjo = interfaceC0259a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.fjn != null) {
            if (this.mPullView == null) {
                this.mPullView = new k(tbPageContext);
                this.mPullView.a(this.bSf);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.bPn == null) {
                this.bPn = new PbListView(tbPageContext.getPageActivity());
                this.bPn.getView();
            }
            this.bPn.ex(e.d.cp_bg_line_e);
            this.bPn.setHeight(l.h(tbPageContext.getContext(), e.C0210e.tbds182));
            this.bPn.Fm();
            this.bPn.setTextSize(e.C0210e.tbfontsize33);
            this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bPn.ew(e.d.cp_cont_e);
            this.bPn.setOnClickListener(this.fiR);
            this.bPm = (NoNetworkView) this.fjn.findViewById(e.g.no_networkview);
            this.bPm.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.fjn.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(e.j.agree_me));
            this.bSa = (BdSwipeRefreshLayout) this.fjn.findViewById(e.g.agree_me_pull_refresh_layout);
            this.bSa.setProgressView(this.mPullView);
            this.bRZ = (BdTypeRecyclerView) this.fjn.findViewById(e.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.bRZ.getItemAnimator()).setSupportsChangeAnimations(false);
            this.bRZ.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.bRZ.setFadingEdgeLength(0);
            this.bRZ.setBackgroundColor(al.getColor(e.d.transparent));
            this.bRZ.setOverScrollMode(2);
            this.bRZ.addItemDecoration(new d());
            this.bRZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.bRZ.setNextPage(this.bPn);
            this.bRZ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.bPn != null && a.this.fjo != null) {
                        a.this.bPn.ez(0);
                        a.this.bPn.setOnClickListener(null);
                        a.this.bPn.showLoading();
                        a.this.fjo.aEu();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<h> arrayList) {
        if (this.bSa != null && this.bPn != null && this.bRZ != null && this.fiG != null) {
            this.bSa.setRefreshing(false);
            if (z) {
                this.bPn.ez(0);
                this.bPn.Fq();
                this.bPn.setOnClickListener(this.fiR);
            } else {
                this.bPn.ez(0);
                this.bPn.Fq();
                this.bPn.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.bPn.setOnClickListener(null);
            }
            if (v.I(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.fiJ) {
                    this.fiJ = true;
                    this.bRZ.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bRZ.setNextPage(null);
                return;
            }
            this.bRZ.removeHeaderView(this.mNoDataView);
            this.fiJ = false;
            this.bRZ.setNextPage(this.bPn);
            this.fiG.setData(arrayList);
            this.fiG.notifyDataSetChanged();
        }
    }

    public void jm(boolean z) {
        if (this.bSa != null) {
            this.bSa.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.bPm != null) {
            this.bPm.onChangeSkinType(this.mContext, i);
        }
        if (this.bPn != null) {
            this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bPn.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.fiG != null) {
            this.fiG.notifyDataSetChanged();
        }
        al.j(this.fjn, e.d.cp_bg_line_e);
        al.j(this.bSa, e.d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.fiG != null) {
            this.fiG.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.fiG != null) {
            this.fiG.d(nVar);
        }
    }

    public List<h> getDatas() {
        if (this.bRZ == null) {
            return null;
        }
        return this.bRZ.getData();
    }

    public View getRootView() {
        return this.fjn;
    }
}
