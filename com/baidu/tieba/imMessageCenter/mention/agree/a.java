package com.baidu.tieba.imMessageCenter.mention.agree;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.base.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView NZ;
    private NoNetworkView dlW;
    private PbListView dlX;
    protected BdSwipeRefreshLayout dnh;
    private e gPF;
    private boolean gPI;
    private View gQk;
    private InterfaceC0344a gQl;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View.OnClickListener gPQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dlX != null && a.this.gQl != null) {
                a.this.dlX.iQ(0);
                a.this.dlX.setOnClickListener(null);
                a.this.dlX.ajy();
                a.this.gQl.aWp();
            }
        }
    };
    private final h.c drX = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            if (j.jS()) {
                if (a.this.gQl != null) {
                    a.this.gQl.bmt();
                }
            } else if (a.this.dnh != null) {
                a.this.dnh.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0344a {
        void aWp();

        void bmt();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.gQk = view.findViewById(R.id.agree_me_layout);
        o(tbPageContext);
        this.gPF = new e(tbPageContext, this.NZ);
    }

    public void a(InterfaceC0344a interfaceC0344a) {
        this.gQl = interfaceC0344a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.gQk != null) {
            if (this.mPullView == null) {
                this.mPullView = new i(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.drX);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.dlX == null) {
                this.dlX = new PbListView(tbPageContext.getPageActivity());
                this.dlX.getView();
            }
            this.dlX.iO(R.color.cp_bg_line_e);
            this.dlX.setHeight(l.g(tbPageContext.getContext(), R.dimen.tbds182));
            this.dlX.ajv();
            this.dlX.setTextSize(R.dimen.tbfontsize33);
            this.dlX.setTextColor(al.getColor(R.color.cp_cont_d));
            this.dlX.iN(R.color.cp_cont_e);
            this.dlX.setOnClickListener(this.gPQ);
            this.dlW = (NoNetworkView) this.gQk.findViewById(R.id.no_networkview);
            this.dlW.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.gQk.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(R.string.agree_me));
            this.dnh = (BdSwipeRefreshLayout) this.gQk.findViewById(R.id.agree_me_pull_refresh_layout);
            this.dnh.setProgressView(this.mPullView);
            this.NZ = (BdTypeRecyclerView) this.gQk.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.NZ.getItemAnimator()).setSupportsChangeAnimations(false);
            this.NZ.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.NZ.setFadingEdgeLength(0);
            this.NZ.setBackgroundColor(al.getColor(R.color.transparent));
            this.NZ.setOverScrollMode(2);
            this.NZ.addItemDecoration(new d());
            this.NZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.NZ.setNextPage(this.dlX);
            this.NZ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.dlX != null && a.this.gQl != null) {
                        a.this.dlX.iQ(0);
                        a.this.dlX.setOnClickListener(null);
                        a.this.dlX.showLoading();
                        a.this.gQl.aWp();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.dnh != null && this.dlX != null && this.NZ != null && this.gPF != null) {
            this.dnh.setRefreshing(false);
            if (z) {
                this.dlX.iQ(0);
                this.dlX.ajz();
                this.dlX.setOnClickListener(this.gPQ);
            } else {
                this.dlX.iQ(0);
                this.dlX.ajz();
                this.dlX.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.dlX.setOnClickListener(null);
            }
            if (v.aa(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iH(R.string.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.l(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gPI) {
                    this.gPI = true;
                    this.NZ.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.NZ.setNextPage(null);
                return;
            }
            this.NZ.removeHeaderView(this.mNoDataView);
            this.gPI = false;
            this.NZ.setNextPage(this.dlX);
            this.gPF.setData(arrayList);
            this.gPF.notifyDataSetChanged();
        }
    }

    public void mB(boolean z) {
        if (this.dnh != null) {
            this.dnh.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.dlW != null) {
            this.dlW.onChangeSkinType(this.mContext, i);
        }
        if (this.dlX != null) {
            this.dlX.setTextColor(al.getColor(R.color.cp_cont_d));
            this.dlX.iP(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.gPF != null) {
            this.gPF.notifyDataSetChanged();
        }
        al.l(this.gQk, R.color.cp_bg_line_e);
        al.l(this.dnh, R.color.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.gPF != null) {
            this.gPF.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(s sVar) {
        if (this.gPF != null) {
            this.gPF.d(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.NZ == null) {
            return null;
        }
        return this.NZ.getData();
    }

    public View getRootView() {
        return this.gQk;
    }
}
