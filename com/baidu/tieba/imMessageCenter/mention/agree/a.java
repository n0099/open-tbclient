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
    private NoNetworkView dlX;
    private PbListView dlY;
    protected BdSwipeRefreshLayout dni;
    private e gPH;
    private boolean gPK;
    private View gQn;
    private InterfaceC0344a gQo;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View.OnClickListener gPS = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dlY != null && a.this.gQo != null) {
                a.this.dlY.iQ(0);
                a.this.dlY.setOnClickListener(null);
                a.this.dlY.ajy();
                a.this.gQo.aWs();
            }
        }
    };
    private final h.c drY = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            if (j.jS()) {
                if (a.this.gQo != null) {
                    a.this.gQo.bmw();
                }
            } else if (a.this.dni != null) {
                a.this.dni.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0344a {
        void aWs();

        void bmw();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.gQn = view.findViewById(R.id.agree_me_layout);
        o(tbPageContext);
        this.gPH = new e(tbPageContext, this.NZ);
    }

    public void a(InterfaceC0344a interfaceC0344a) {
        this.gQo = interfaceC0344a;
    }

    private void o(TbPageContext tbPageContext) {
        if (this.gQn != null) {
            if (this.mPullView == null) {
                this.mPullView = new i(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.drY);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.dlY == null) {
                this.dlY = new PbListView(tbPageContext.getPageActivity());
                this.dlY.getView();
            }
            this.dlY.iO(R.color.cp_bg_line_e);
            this.dlY.setHeight(l.g(tbPageContext.getContext(), R.dimen.tbds182));
            this.dlY.ajv();
            this.dlY.setTextSize(R.dimen.tbfontsize33);
            this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
            this.dlY.iN(R.color.cp_cont_e);
            this.dlY.setOnClickListener(this.gPS);
            this.dlX = (NoNetworkView) this.gQn.findViewById(R.id.no_networkview);
            this.dlX.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.gQn.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(R.string.agree_me));
            this.dni = (BdSwipeRefreshLayout) this.gQn.findViewById(R.id.agree_me_pull_refresh_layout);
            this.dni.setProgressView(this.mPullView);
            this.NZ = (BdTypeRecyclerView) this.gQn.findViewById(R.id.agree_me_recycler_view);
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
            this.NZ.setNextPage(this.dlY);
            this.NZ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.dlY != null && a.this.gQo != null) {
                        a.this.dlY.iQ(0);
                        a.this.dlY.setOnClickListener(null);
                        a.this.dlY.showLoading();
                        a.this.gQo.aWs();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.dni != null && this.dlY != null && this.NZ != null && this.gPH != null) {
            this.dni.setRefreshing(false);
            if (z) {
                this.dlY.iQ(0);
                this.dlY.ajz();
                this.dlY.setOnClickListener(this.gPS);
            } else {
                this.dlY.iQ(0);
                this.dlY.ajz();
                this.dlY.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.dlY.setOnClickListener(null);
            }
            if (v.aa(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iH(R.string.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    al.l(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gPK) {
                    this.gPK = true;
                    this.NZ.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.NZ.setNextPage(null);
                return;
            }
            this.NZ.removeHeaderView(this.mNoDataView);
            this.gPK = false;
            this.NZ.setNextPage(this.dlY);
            this.gPH.setData(arrayList);
            this.gPH.notifyDataSetChanged();
        }
    }

    public void mB(boolean z) {
        if (this.dni != null) {
            this.dni.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.dlX != null) {
            this.dlX.onChangeSkinType(this.mContext, i);
        }
        if (this.dlY != null) {
            this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
            this.dlY.iP(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.gPH != null) {
            this.gPH.notifyDataSetChanged();
        }
        al.l(this.gQn, R.color.cp_bg_line_e);
        al.l(this.dni, R.color.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.gPH != null) {
            this.gPH.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(s sVar) {
        if (this.gPH != null) {
            this.gPH.d(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.NZ == null) {
            return null;
        }
        return this.NZ.getData();
    }

    public View getRootView() {
        return this.gQn;
    }
}
