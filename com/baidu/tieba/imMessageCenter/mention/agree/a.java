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
    private NoNetworkView bOx;
    private PbListView bOy;
    private BdTypeRecyclerView bRk;
    protected BdSwipeRefreshLayout bRl;
    private e feY;
    private View ffE;
    private InterfaceC0259a ffF;
    private boolean ffb;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private View.OnClickListener ffj = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bOy != null && a.this.ffF != null) {
                a.this.bOy.ez(0);
                a.this.bOy.setOnClickListener(null);
                a.this.bOy.Fc();
                a.this.ffF.aDi();
            }
        }
    };
    private final j.b bRq = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            if (com.baidu.adp.lib.util.j.kV()) {
                if (a.this.ffF != null) {
                    a.this.ffF.aDj();
                }
            } else if (a.this.bRl != null) {
                a.this.bRl.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0259a {
        void aDi();

        void aDj();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.ffE = view.findViewById(e.g.agree_me_layout);
        o(tbPageContext);
        this.feY = new com.baidu.tieba.imMessageCenter.mention.base.e(tbPageContext, this.bRk);
    }

    public void a(InterfaceC0259a interfaceC0259a) {
        this.ffF = interfaceC0259a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.ffE != null) {
            if (this.mPullView == null) {
                this.mPullView = new k(tbPageContext);
                this.mPullView.a(this.bRq);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.bOy == null) {
                this.bOy = new PbListView(tbPageContext.getPageActivity());
                this.bOy.getView();
            }
            this.bOy.ex(e.d.cp_bg_line_e);
            this.bOy.setHeight(l.h(tbPageContext.getContext(), e.C0210e.tbds182));
            this.bOy.EZ();
            this.bOy.setTextSize(e.C0210e.tbfontsize33);
            this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bOy.ew(e.d.cp_cont_e);
            this.bOy.setOnClickListener(this.ffj);
            this.bOx = (NoNetworkView) this.ffE.findViewById(e.g.no_networkview);
            this.bOx.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.ffE.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(e.j.agree_me));
            this.bRl = (BdSwipeRefreshLayout) this.ffE.findViewById(e.g.agree_me_pull_refresh_layout);
            this.bRl.setProgressView(this.mPullView);
            this.bRk = (BdTypeRecyclerView) this.ffE.findViewById(e.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.bRk.getItemAnimator()).setSupportsChangeAnimations(false);
            this.bRk.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.bRk.setFadingEdgeLength(0);
            this.bRk.setBackgroundColor(al.getColor(e.d.transparent));
            this.bRk.setOverScrollMode(2);
            this.bRk.addItemDecoration(new d());
            this.bRk.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.bRk.setNextPage(this.bOy);
            this.bRk.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.bOy != null && a.this.ffF != null) {
                        a.this.bOy.ez(0);
                        a.this.bOy.setOnClickListener(null);
                        a.this.bOy.showLoading();
                        a.this.ffF.aDi();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<h> arrayList) {
        if (this.bRl != null && this.bOy != null && this.bRk != null && this.feY != null) {
            this.bRl.setRefreshing(false);
            if (z) {
                this.bOy.ez(0);
                this.bOy.Fd();
                this.bOy.setOnClickListener(this.ffj);
            } else {
                this.bOy.ez(0);
                this.bOy.Fd();
                this.bOy.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.bOy.setOnClickListener(null);
            }
            if (v.I(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.ffb) {
                    this.ffb = true;
                    this.bRk.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bRk.setNextPage(null);
                return;
            }
            this.bRk.removeHeaderView(this.mNoDataView);
            this.ffb = false;
            this.bRk.setNextPage(this.bOy);
            this.feY.setData(arrayList);
            this.feY.notifyDataSetChanged();
        }
    }

    public void jj(boolean z) {
        if (this.bRl != null) {
            this.bRl.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.bOx != null) {
            this.bOx.onChangeSkinType(this.mContext, i);
        }
        if (this.bOy != null) {
            this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bOy.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.feY != null) {
            this.feY.notifyDataSetChanged();
        }
        al.j(this.ffE, e.d.cp_bg_line_e);
        al.j(this.bRl, e.d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.feY != null) {
            this.feY.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.feY != null) {
            this.feY.d(nVar);
        }
    }

    public List<h> getDatas() {
        if (this.bRk == null) {
            return null;
        }
        return this.bRk.getData();
    }

    public View getRootView() {
        return this.ffE;
    }
}
