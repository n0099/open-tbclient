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
import com.baidu.tieba.f;
import com.baidu.tieba.imMessageCenter.mention.base.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private NoNetworkView bvB;
    private PbListView bvC;
    private BdTypeRecyclerView byo;
    protected BdSwipeRefreshLayout byp;
    private e eHS;
    private boolean eHV;
    private View eIy;
    private InterfaceC0186a eIz;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View.OnClickListener eId = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bvC != null && a.this.eIz != null) {
                a.this.bvC.dC(0);
                a.this.bvC.setOnClickListener(null);
                a.this.bvC.Av();
                a.this.eIz.aPk();
            }
        }
    };
    private final g.b byv = new g.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void aT(boolean z) {
            if (j.jE()) {
                if (a.this.eIz != null) {
                    a.this.eIz.aPj();
                }
            } else if (a.this.byp != null) {
                a.this.byp.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0186a {
        void aPj();

        void aPk();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.eIy = view.findViewById(f.g.agree_me_layout);
        o(tbPageContext);
        this.eHS = new e(tbPageContext, this.byo);
    }

    public void a(InterfaceC0186a interfaceC0186a) {
        this.eIz = interfaceC0186a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.eIy != null) {
            if (this.mPullView == null) {
                this.mPullView = new h(tbPageContext);
                this.mPullView.a(this.byv);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.bvC == null) {
                this.bvC = new PbListView(tbPageContext.getPageActivity());
                this.bvC.getView();
            }
            this.bvC.dA(f.d.cp_bg_line_e);
            this.bvC.setHeight(l.f(tbPageContext.getContext(), f.e.tbds182));
            this.bvC.As();
            this.bvC.setTextSize(f.e.tbfontsize33);
            this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
            this.bvC.dz(f.d.cp_cont_e);
            this.bvC.setOnClickListener(this.eId);
            this.bvB = (NoNetworkView) this.eIy.findViewById(f.g.no_networkview);
            this.bvB.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.eIy.findViewById(f.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(f.j.agree_me));
            this.byp = (BdSwipeRefreshLayout) this.eIy.findViewById(f.g.agree_me_pull_refresh_layout);
            this.byp.setProgressView(this.mPullView);
            this.byo = (BdTypeRecyclerView) this.eIy.findViewById(f.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.byo.getItemAnimator()).setSupportsChangeAnimations(false);
            this.byo.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.byo.setFadingEdgeLength(0);
            this.byo.setBackgroundColor(am.getColor(f.d.transparent));
            this.byo.setOverScrollMode(2);
            this.byo.addItemDecoration(new d());
            this.byo.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.byo.setNextPage(this.bvC);
            this.byo.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.bvC != null && a.this.eIz != null) {
                        a.this.bvC.dC(0);
                        a.this.bvC.setOnClickListener(null);
                        a.this.bvC.showLoading();
                        a.this.eIz.aPk();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.byp != null && this.bvC != null && this.byo != null && this.eHS != null) {
            this.byp.setRefreshing(false);
            if (z) {
                this.bvC.dC(0);
                this.bvC.Aw();
                this.bvC.setOnClickListener(this.eId);
            } else {
                this.bvC.dC(0);
                this.bvC.Aw();
                this.bvC.setText(this.mContext.getResources().getString(f.j.list_no_more));
                this.bvC.setOnClickListener(null);
            }
            if (w.z(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(f.e.ds80)), NoDataViewFactory.d.dt(f.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.j(this.mNoDataView, f.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eHV) {
                    this.eHV = true;
                    this.byo.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.byo.setNextPage(null);
                return;
            }
            this.byo.removeHeaderView(this.mNoDataView);
            this.eHV = false;
            this.byo.setNextPage(this.bvC);
            this.eHS.setData(arrayList);
            this.eHS.notifyDataSetChanged();
        }
    }

    public void ih(boolean z) {
        if (this.byp != null) {
            this.byp.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        if (this.bvB != null) {
            this.bvB.onChangeSkinType(this.mContext, i);
        }
        if (this.bvC != null) {
            this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
            this.bvC.dB(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.j(this.mNoDataView, f.d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.eHS != null) {
            this.eHS.notifyDataSetChanged();
        }
        am.j(this.eIy, f.d.cp_bg_line_e);
        am.j(this.byp, f.d.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.eHS != null) {
            this.eHS.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(n nVar) {
        if (this.eHS != null) {
            this.eHS.d(nVar);
        }
    }

    public List<com.baidu.adp.widget.ListView.h> getDatas() {
        if (this.byo == null) {
            return null;
        }
        return this.byo.getData();
    }

    public View getRootView() {
        return this.eIy;
    }
}
