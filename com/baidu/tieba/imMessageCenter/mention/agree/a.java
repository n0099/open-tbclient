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
    private NoNetworkView bOA;
    private PbListView bOB;
    private BdTypeRecyclerView bRn;
    protected BdSwipeRefreshLayout bRo;
    private e fhP;
    private boolean fhS;
    private View fiw;
    private InterfaceC0259a fiy;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private View.OnClickListener fia = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bOB != null && a.this.fiy != null) {
                a.this.bOB.ez(0);
                a.this.bOB.setOnClickListener(null);
                a.this.bOB.Fc();
                a.this.fiy.aDX();
            }
        }
    };
    private final j.b bRt = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            if (com.baidu.adp.lib.util.j.kV()) {
                if (a.this.fiy != null) {
                    a.this.fiy.aDY();
                }
            } else if (a.this.bRo != null) {
                a.this.bRo.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0259a {
        void aDX();

        void aDY();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.fiw = view.findViewById(e.g.agree_me_layout);
        o(tbPageContext);
        this.fhP = new com.baidu.tieba.imMessageCenter.mention.base.e(tbPageContext, this.bRn);
    }

    public void a(InterfaceC0259a interfaceC0259a) {
        this.fiy = interfaceC0259a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.fiw != null) {
            if (this.mPullView == null) {
                this.mPullView = new k(tbPageContext);
                this.mPullView.a(this.bRt);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.bOB == null) {
                this.bOB = new PbListView(tbPageContext.getPageActivity());
                this.bOB.getView();
            }
            this.bOB.ex(e.d.cp_bg_line_e);
            this.bOB.setHeight(l.h(tbPageContext.getContext(), e.C0210e.tbds182));
            this.bOB.EZ();
            this.bOB.setTextSize(e.C0210e.tbfontsize33);
            this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bOB.ew(e.d.cp_cont_e);
            this.bOB.setOnClickListener(this.fia);
            this.bOA = (NoNetworkView) this.fiw.findViewById(e.g.no_networkview);
            this.bOA.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.fiw.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(e.j.agree_me));
            this.bRo = (BdSwipeRefreshLayout) this.fiw.findViewById(e.g.agree_me_pull_refresh_layout);
            this.bRo.setProgressView(this.mPullView);
            this.bRn = (BdTypeRecyclerView) this.fiw.findViewById(e.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.bRn.getItemAnimator()).setSupportsChangeAnimations(false);
            this.bRn.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.bRn.setFadingEdgeLength(0);
            this.bRn.setBackgroundColor(al.getColor(e.d.transparent));
            this.bRn.setOverScrollMode(2);
            this.bRn.addItemDecoration(new d());
            this.bRn.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.bRn.setNextPage(this.bOB);
            this.bRn.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.bOB != null && a.this.fiy != null) {
                        a.this.bOB.ez(0);
                        a.this.bOB.setOnClickListener(null);
                        a.this.bOB.showLoading();
                        a.this.fiy.aDX();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<h> arrayList) {
        if (this.bRo != null && this.bOB != null && this.bRn != null && this.fhP != null) {
            this.bRo.setRefreshing(false);
            if (z) {
                this.bOB.ez(0);
                this.bOB.Fd();
                this.bOB.setOnClickListener(this.fia);
            } else {
                this.bOB.ez(0);
                this.bOB.Fd();
                this.bOB.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.bOB.setOnClickListener(null);
            }
            if (v.I(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.fhS) {
                    this.fhS = true;
                    this.bRn.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bRn.setNextPage(null);
                return;
            }
            this.bRn.removeHeaderView(this.mNoDataView);
            this.fhS = false;
            this.bRn.setNextPage(this.bOB);
            this.fhP.setData(arrayList);
            this.fhP.notifyDataSetChanged();
        }
    }

    public void jm(boolean z) {
        if (this.bRo != null) {
            this.bRo.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.bOA != null) {
            this.bOA.onChangeSkinType(this.mContext, i);
        }
        if (this.bOB != null) {
            this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bOB.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.fhP != null) {
            this.fhP.notifyDataSetChanged();
        }
        al.j(this.fiw, e.d.cp_bg_line_e);
        al.j(this.bRo, e.d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.fhP != null) {
            this.fhP.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.fhP != null) {
            this.fhP.d(nVar);
        }
    }

    public List<h> getDatas() {
        if (this.bRn == null) {
            return null;
        }
        return this.bRn.getData();
    }

    public View getRootView() {
        return this.fiw;
    }
}
