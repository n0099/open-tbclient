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
import com.baidu.tbadk.core.util.am;
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
    private BdTypeRecyclerView Op;
    private NoNetworkView dnM;
    private PbListView dnN;
    protected BdSwipeRefreshLayout dpp;
    private e gWL;
    private boolean gWO;
    private View gXr;
    private InterfaceC0349a gXs;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View.OnClickListener gWW = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dnN != null && a.this.gXs != null) {
                a.this.dnN.iW(0);
                a.this.dnN.setOnClickListener(null);
                a.this.dnN.akF();
                a.this.gXs.aYq();
            }
        }
    };
    private final h.c duo = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            if (j.kc()) {
                if (a.this.gXs != null) {
                    a.this.gXs.boK();
                }
            } else if (a.this.dpp != null) {
                a.this.dpp.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0349a {
        void aYq();

        void boK();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.gXr = view.findViewById(R.id.agree_me_layout);
        q(tbPageContext);
        this.gWL = new e(tbPageContext, this.Op);
    }

    public void a(InterfaceC0349a interfaceC0349a) {
        this.gXs = interfaceC0349a;
    }

    private void q(TbPageContext tbPageContext) {
        if (this.gXr != null) {
            if (this.mPullView == null) {
                this.mPullView = new i(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.duo);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.dnN == null) {
                this.dnN = new PbListView(tbPageContext.getPageActivity());
                this.dnN.getView();
            }
            this.dnN.iU(R.color.cp_bg_line_e);
            this.dnN.setHeight(l.g(tbPageContext.getContext(), R.dimen.tbds182));
            this.dnN.akC();
            this.dnN.setTextSize(R.dimen.tbfontsize33);
            this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dnN.iT(R.color.cp_cont_e);
            this.dnN.setOnClickListener(this.gWW);
            this.dnM = (NoNetworkView) this.gXr.findViewById(R.id.no_networkview);
            this.dnM.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.gXr.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(R.string.agree_me));
            this.dpp = (BdSwipeRefreshLayout) this.gXr.findViewById(R.id.agree_me_pull_refresh_layout);
            this.dpp.setProgressView(this.mPullView);
            this.Op = (BdTypeRecyclerView) this.gXr.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Op.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Op.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.Op.setFadingEdgeLength(0);
            this.Op.setBackgroundColor(am.getColor(R.color.transparent));
            this.Op.setOverScrollMode(2);
            this.Op.addItemDecoration(new d());
            this.Op.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Op.setNextPage(this.dnN);
            this.Op.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.dnN != null && a.this.gXs != null) {
                        a.this.dnN.iW(0);
                        a.this.dnN.setOnClickListener(null);
                        a.this.dnN.showLoading();
                        a.this.gXs.aYq();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.dpp != null && this.dnN != null && this.Op != null && this.gWL != null) {
            this.dpp.setRefreshing(false);
            if (z) {
                this.dnN.iW(0);
                this.dnN.akG();
                this.dnN.setOnClickListener(this.gWW);
            } else {
                this.dnN.iW(0);
                this.dnN.akG();
                this.dnN.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.dnN.setOnClickListener(null);
            }
            if (v.aa(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iN(R.string.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.l(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gWO) {
                    this.gWO = true;
                    this.Op.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Op.setNextPage(null);
                return;
            }
            this.Op.removeHeaderView(this.mNoDataView);
            this.gWO = false;
            this.Op.setNextPage(this.dnN);
            this.gWL.setData(arrayList);
            this.gWL.notifyDataSetChanged();
        }
    }

    public void mQ(boolean z) {
        if (this.dpp != null) {
            this.dpp.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.dnM != null) {
            this.dnM.onChangeSkinType(this.mContext, i);
        }
        if (this.dnN != null) {
            this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dnN.iV(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.l(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.gWL != null) {
            this.gWL.notifyDataSetChanged();
        }
        am.l(this.gXr, R.color.cp_bg_line_e);
        am.l(this.dpp, R.color.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.gWL != null) {
            this.gWL.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(s sVar) {
        if (this.gWL != null) {
            this.gWL.d(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.Op == null) {
            return null;
        }
        return this.Op.getData();
    }

    public View getRootView() {
        return this.gXr;
    }
}
