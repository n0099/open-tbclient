package com.baidu.tieba.imMessageCenter.mention.agree;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.base.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView Bn;
    private TbPageContext cQU;
    private NoNetworkView egT;
    private PbListView egU;
    protected BdSwipeRefreshLayout eiv;
    private e hJR;
    private boolean hJU;
    private View hKy;
    private InterfaceC0530a hKz;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View.OnClickListener hKb = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.egU != null && a.this.hKz != null) {
                a.this.egU.showEmptyView(0);
                a.this.egU.setOnClickListener(null);
                a.this.egU.startLoadData();
                a.this.hKz.bra();
            }
        }
    };
    private final g.c emI = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.hKz != null) {
                    a.this.hKz.bDT();
                }
            } else if (a.this.eiv != null) {
                a.this.eiv.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0530a {
        void bDT();

        void bra();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.cQU = tbPageContext;
        this.hKy = view.findViewById(R.id.agree_me_layout);
        c(tbPageContext);
        this.hJR = new e(tbPageContext, this.Bn);
    }

    public void a(InterfaceC0530a interfaceC0530a) {
        this.hKz = interfaceC0530a;
    }

    private void c(TbPageContext tbPageContext) {
        if (this.hKy != null) {
            if (this.mPullView == null) {
                this.mPullView = new h(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.emI);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.egU == null) {
                this.egU = new PbListView(tbPageContext.getPageActivity());
                this.egU.getView();
            }
            this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.egU.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.egU.setLineGone();
            this.egU.setTextSize(R.dimen.tbfontsize33);
            this.egU.setTextColor(am.getColor(R.color.cp_cont_d));
            this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
            this.egU.setOnClickListener(this.hKb);
            this.egT = (NoNetworkView) this.hKy.findViewById(R.id.no_networkview);
            this.egT.onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.hKy.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.hKy.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.cQU.getString(R.string.agree_me));
            this.eiv = (BdSwipeRefreshLayout) this.hKy.findViewById(R.id.agree_me_pull_refresh_layout);
            this.eiv.setProgressView(this.mPullView);
            this.Bn = (BdTypeRecyclerView) this.hKy.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Bn.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Bn.setLayoutManager(new LinearLayoutManager(this.cQU.getContext()));
            this.Bn.setFadingEdgeLength(0);
            this.Bn.setBackgroundColor(am.getColor(R.color.transparent));
            this.Bn.setOverScrollMode(2);
            this.Bn.addItemDecoration(new d());
            this.Bn.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Bn.setNextPage(this.egU);
            this.Bn.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.egU != null && a.this.hKz != null) {
                        a.this.egU.showEmptyView(0);
                        a.this.egU.setOnClickListener(null);
                        a.this.egU.showLoading();
                        a.this.hKz.bra();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.eiv != null && this.egU != null && this.Bn != null && this.hJR != null) {
            this.eiv.setRefreshing(false);
            if (z) {
                this.egU.showEmptyView(0);
                this.egU.endLoadData();
                this.egU.setOnClickListener(this.hKb);
            } else {
                this.egU.showEmptyView(0);
                this.egU.endLoadData();
                this.egU.setText(this.cQU.getResources().getString(R.string.list_no_more));
                this.egU.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.cQU.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cr(null, this.cQU.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.hJU) {
                    this.hJU = true;
                    this.Bn.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Bn.setNextPage(null);
                return;
            }
            this.Bn.removeHeaderView(this.mNoDataView);
            this.hJU = false;
            this.Bn.setNextPage(this.egU);
            this.hJR.setData(arrayList);
            this.hJR.notifyDataSetChanged();
        }
    }

    public void nU(boolean z) {
        if (this.eiv != null) {
            this.eiv.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.egT != null) {
            this.egT.onChangeSkinType(this.cQU, i);
        }
        if (this.egU != null) {
            this.egU.setTextColor(am.getColor(R.color.cp_cont_d));
            this.egU.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cQU, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cQU, i);
        }
        if (this.hJR != null) {
            this.hJR.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.hKy, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.eiv, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.Bn, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.hJR != null) {
            this.hJR.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(s sVar) {
        if (this.hJR != null) {
            this.hJR.e(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.Bn == null) {
            return null;
        }
        return this.Bn.getData();
    }

    public View getRootView() {
        return this.hKy;
    }

    public RelativeLayout aZY() {
        return this.mContainer;
    }
}
