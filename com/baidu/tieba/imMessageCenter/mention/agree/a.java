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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private NoNetworkView btu;
    private PbListView btv;
    private BdTypeRecyclerView bwl;
    protected BdSwipeRefreshLayout bwm;
    private View eAT;
    private InterfaceC0185a eAU;
    private e eAn;
    private boolean eAq;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener eAy = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.btv != null && a.this.eAU != null) {
                a.this.btv.dz(0);
                a.this.btv.setOnClickListener(null);
                a.this.btv.Ar();
                a.this.eAU.aNH();
            }
        }
    };
    private final f.b bws = new f.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void aS(boolean z) {
            if (j.jD()) {
                if (a.this.eAU != null) {
                    a.this.eAU.aNG();
                }
            } else if (a.this.bwm != null) {
                a.this.bwm.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0185a {
        void aNG();

        void aNH();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.eAT = view.findViewById(d.g.agree_me_layout);
        o(tbPageContext);
        this.eAn = new e(tbPageContext, this.bwl);
    }

    public void a(InterfaceC0185a interfaceC0185a) {
        this.eAU = interfaceC0185a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.eAT != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.a(this.bws);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.btv == null) {
                this.btv = new PbListView(tbPageContext.getPageActivity());
                this.btv.getView();
            }
            this.btv.dx(d.C0141d.cp_bg_line_e);
            this.btv.setHeight(l.e(tbPageContext.getContext(), d.e.tbds182));
            this.btv.Ao();
            this.btv.setTextSize(d.e.tbfontsize33);
            this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_d));
            this.btv.dw(d.C0141d.cp_cont_e);
            this.btv.setOnClickListener(this.eAy);
            this.btu = (NoNetworkView) this.eAT.findViewById(d.g.no_networkview);
            this.btu.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.eAT.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(d.k.agree_me));
            this.bwm = (BdSwipeRefreshLayout) this.eAT.findViewById(d.g.agree_me_pull_refresh_layout);
            this.bwm.setProgressView(this.mPullView);
            this.bwl = (BdTypeRecyclerView) this.eAT.findViewById(d.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.bwl.getItemAnimator()).setSupportsChangeAnimations(false);
            this.bwl.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.bwl.setFadingEdgeLength(0);
            this.bwl.setOverScrollMode(2);
            this.bwl.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
            this.bwl.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.bwl.setNextPage(this.btv);
            this.bwl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.btv != null && a.this.eAU != null) {
                        a.this.btv.dz(0);
                        a.this.btv.setOnClickListener(null);
                        a.this.btv.showLoading();
                        a.this.eAU.aNH();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<h> arrayList) {
        if (this.bwm != null && this.btv != null && this.bwl != null && this.eAn != null) {
            this.bwm.setRefreshing(false);
            if (z) {
                this.btv.dz(0);
                this.btv.As();
                this.btv.setOnClickListener(this.eAy);
            } else {
                this.btv.dz(0);
                this.btv.As();
                this.btv.setText(this.mContext.getResources().getString(d.k.list_no_more));
                this.btv.setOnClickListener(null);
            }
            if (w.z(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dr(d.k.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.j(this.mNoDataView, d.C0141d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eAq) {
                    this.eAq = true;
                    this.bwl.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bwl.setNextPage(null);
                return;
            }
            this.bwl.removeHeaderView(this.mNoDataView);
            this.eAq = false;
            this.bwl.setNextPage(this.btv);
            this.eAn.setData(arrayList);
            this.eAn.notifyDataSetChanged();
        }
    }

    public void hU(boolean z) {
        if (this.bwm != null) {
            this.bwm.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        if (this.btu != null) {
            this.btu.onChangeSkinType(this.mContext, i);
        }
        if (this.btv != null) {
            this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_d));
            this.btv.dy(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, d.C0141d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.eAn != null) {
            this.eAn.notifyDataSetChanged();
        }
        al.j(this.bwl, d.C0141d.cp_bg_line_e);
        al.j(this.bwm, d.C0141d.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.eAn != null) {
            this.eAn.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.eAn != null) {
            this.eAn.d(nVar);
        }
    }

    public List<h> getDatas() {
        if (this.bwl == null) {
            return null;
        }
        return this.bwl.getData();
    }

    public View getRootView() {
        return this.eAT;
    }
}
