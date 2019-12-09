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
    private TbPageContext ceu;
    private NoNetworkView dvR;
    private PbListView dvS;
    protected BdSwipeRefreshLayout dxt;
    private e gVP;
    private boolean gVS;
    private View gWv;
    private InterfaceC0444a gWw;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private BdTypeRecyclerView yJ;
    private View.OnClickListener gWa = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dvS != null && a.this.gWw != null) {
                a.this.dvS.showEmptyView(0);
                a.this.dvS.setOnClickListener(null);
                a.this.dvS.startLoadData();
                a.this.gWw.aYW();
            }
        }
    };
    private final h.c dBK = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.gWw != null) {
                    a.this.gWw.bmy();
                }
            } else if (a.this.dxt != null) {
                a.this.dxt.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0444a {
        void aYW();

        void bmy();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.ceu = tbPageContext;
        this.gWv = view.findViewById(R.id.agree_me_layout);
        q(tbPageContext);
        this.gVP = new e(tbPageContext, this.yJ);
    }

    public void a(InterfaceC0444a interfaceC0444a) {
        this.gWw = interfaceC0444a;
    }

    private void q(TbPageContext tbPageContext) {
        if (this.gWv != null) {
            if (this.mPullView == null) {
                this.mPullView = new i(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.dBK);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.dvS == null) {
                this.dvS = new PbListView(tbPageContext.getPageActivity());
                this.dvS.getView();
            }
            this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.dvS.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.dvS.setLineGone();
            this.dvS.setTextSize(R.dimen.tbfontsize33);
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dvS.setOnClickListener(this.gWa);
            this.dvR = (NoNetworkView) this.gWv.findViewById(R.id.no_networkview);
            this.dvR.onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.gWv.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.ceu.getString(R.string.agree_me));
            this.dxt = (BdSwipeRefreshLayout) this.gWv.findViewById(R.id.agree_me_pull_refresh_layout);
            this.dxt.setProgressView(this.mPullView);
            this.yJ = (BdTypeRecyclerView) this.gWv.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.yJ.getItemAnimator()).setSupportsChangeAnimations(false);
            this.yJ.setLayoutManager(new LinearLayoutManager(this.ceu.getContext()));
            this.yJ.setFadingEdgeLength(0);
            this.yJ.setBackgroundColor(am.getColor(R.color.transparent));
            this.yJ.setOverScrollMode(2);
            this.yJ.addItemDecoration(new d());
            this.yJ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.yJ.setNextPage(this.dvS);
            this.yJ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.dvS != null && a.this.gWw != null) {
                        a.this.dvS.showEmptyView(0);
                        a.this.dvS.setOnClickListener(null);
                        a.this.dvS.showLoading();
                        a.this.gWw.aYW();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.dxt != null && this.dvS != null && this.yJ != null && this.gVP != null) {
            this.dxt.setRefreshing(false);
            if (z) {
                this.dvS.showEmptyView(0);
                this.dvS.endLoadData();
                this.dvS.setOnClickListener(this.gWa);
            } else {
                this.dvS.showEmptyView(0);
                this.dvS.endLoadData();
                this.dvS.setText(this.ceu.getResources().getString(R.string.list_no_more));
                this.dvS.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.ceu.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iK(R.string.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gVS) {
                    this.gVS = true;
                    this.yJ.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
                }
                this.yJ.setNextPage(null);
                return;
            }
            this.yJ.removeHeaderView(this.mNoDataView);
            this.gVS = false;
            this.yJ.setNextPage(this.dvS);
            this.gVP.setData(arrayList);
            this.gVP.notifyDataSetChanged();
        }
    }

    public void mH(boolean z) {
        if (this.dxt != null) {
            this.dxt.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.dvR != null) {
            this.dvR.onChangeSkinType(this.ceu, i);
        }
        if (this.dvS != null) {
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dvS.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ceu, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ceu, i);
        }
        if (this.gVP != null) {
            this.gVP.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.gWv, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.dxt, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.yJ, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.gVP != null) {
            this.gVP.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(s sVar) {
        if (this.gVP != null) {
            this.gVP.e(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.yJ == null) {
            return null;
        }
        return this.yJ.getData();
    }

    public View getRootView() {
        return this.gWv;
    }
}
