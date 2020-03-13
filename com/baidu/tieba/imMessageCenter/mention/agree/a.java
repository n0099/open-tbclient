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
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView BK;
    private TbPageContext cVi;
    private NoNetworkView elv;
    private PbListView elw;
    protected BdSwipeRefreshLayout enH;
    private e hPG;
    private boolean hPJ;
    private View hQn;
    private InterfaceC0542a hQo;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View.OnClickListener hPQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.elw != null && a.this.hQo != null) {
                a.this.elw.showEmptyView(0);
                a.this.elw.setOnClickListener(null);
                a.this.elw.startLoadData();
                a.this.hQo.btJ();
            }
        }
    };
    private final g.c esh = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.hQo != null) {
                    a.this.hQo.bGA();
                }
            } else if (a.this.enH != null) {
                a.this.enH.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0542a {
        void bGA();

        void btJ();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.cVi = tbPageContext;
        this.hQn = view.findViewById(R.id.agree_me_layout);
        c(tbPageContext);
        this.hPG = new e(tbPageContext, this.BK);
    }

    public void a(InterfaceC0542a interfaceC0542a) {
        this.hQo = interfaceC0542a;
    }

    private void c(TbPageContext tbPageContext) {
        if (this.hQn != null) {
            if (this.mPullView == null) {
                this.mPullView = new h(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.esh);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.elw == null) {
                this.elw = new PbListView(tbPageContext.getPageActivity());
                this.elw.getView();
            }
            this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.elw.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.elw.setLineGone();
            this.elw.setTextSize(R.dimen.tbfontsize33);
            this.elw.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elw.setOnClickListener(this.hPQ);
            this.elv = (NoNetworkView) this.hQn.findViewById(R.id.no_networkview);
            this.elv.onChangeSkinType(this.cVi, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.hQn.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.hQn.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.cVi.getString(R.string.agree_me));
            this.enH = (BdSwipeRefreshLayout) this.hQn.findViewById(R.id.agree_me_pull_refresh_layout);
            this.enH.setProgressView(this.mPullView);
            this.BK = (BdTypeRecyclerView) this.hQn.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.BK.getItemAnimator()).setSupportsChangeAnimations(false);
            this.BK.setLayoutManager(new LinearLayoutManager(this.cVi.getContext()));
            this.BK.setFadingEdgeLength(0);
            this.BK.setBackgroundColor(am.getColor(R.color.transparent));
            this.BK.setOverScrollMode(2);
            this.BK.addItemDecoration(new d());
            this.BK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.BK.setNextPage(this.elw);
            this.BK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.elw != null && a.this.hQo != null) {
                        a.this.elw.showEmptyView(0);
                        a.this.elw.setOnClickListener(null);
                        a.this.elw.showLoading();
                        a.this.hQo.btJ();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.enH != null && this.elw != null && this.BK != null && this.hPG != null) {
            this.enH.setRefreshing(false);
            if (z) {
                this.elw.showEmptyView(0);
                this.elw.endLoadData();
                this.elw.setOnClickListener(this.hPQ);
            } else {
                this.elw.showEmptyView(0);
                this.elw.endLoadData();
                this.elw.setText(this.cVi.getResources().getString(R.string.list_no_more));
                this.elw.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.cVi.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cA(null, this.cVi.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.hPJ) {
                    this.hPJ = true;
                    this.BK.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.cVi, TbadkCoreApplication.getInst().getSkinType());
                }
                this.BK.setNextPage(null);
                return;
            }
            this.BK.removeHeaderView(this.mNoDataView);
            this.hPJ = false;
            this.BK.setNextPage(this.elw);
            this.hPG.setData(arrayList);
            this.hPG.notifyDataSetChanged();
        }
    }

    public void oi(boolean z) {
        if (this.enH != null) {
            this.enH.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.elv != null) {
            this.elv.onChangeSkinType(this.cVi, i);
        }
        if (this.elw != null) {
            this.elw.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elw.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cVi, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cVi, i);
        }
        if (this.hPG != null) {
            this.hPG.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.hQn, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.enH, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.BK, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.hPG != null) {
            this.hPG.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(s sVar) {
        if (this.hPG != null) {
            this.hPG.e(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.BK == null) {
            return null;
        }
        return this.BK.getData();
    }

    public View getRootView() {
        return this.hQn;
    }

    public RelativeLayout bcP() {
        return this.mContainer;
    }
}
