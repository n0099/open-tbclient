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
    private TbPageContext cVg;
    private NoNetworkView elh;
    private PbListView eli;
    protected BdSwipeRefreshLayout ens;
    private View hPZ;
    private e hPs;
    private boolean hPv;
    private InterfaceC0542a hQa;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View.OnClickListener hPC = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eli != null && a.this.hQa != null) {
                a.this.eli.showEmptyView(0);
                a.this.eli.setOnClickListener(null);
                a.this.eli.startLoadData();
                a.this.hQa.btG();
            }
        }
    };
    private final g.c erT = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.hQa != null) {
                    a.this.hQa.bGx();
                }
            } else if (a.this.ens != null) {
                a.this.ens.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0542a {
        void bGx();

        void btG();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.cVg = tbPageContext;
        this.hPZ = view.findViewById(R.id.agree_me_layout);
        c(tbPageContext);
        this.hPs = new e(tbPageContext, this.BK);
    }

    public void a(InterfaceC0542a interfaceC0542a) {
        this.hQa = interfaceC0542a;
    }

    private void c(TbPageContext tbPageContext) {
        if (this.hPZ != null) {
            if (this.mPullView == null) {
                this.mPullView = new h(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.erT);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.eli == null) {
                this.eli = new PbListView(tbPageContext.getPageActivity());
                this.eli.getView();
            }
            this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.eli.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.eli.setLineGone();
            this.eli.setTextSize(R.dimen.tbfontsize33);
            this.eli.setTextColor(am.getColor(R.color.cp_cont_d));
            this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
            this.eli.setOnClickListener(this.hPC);
            this.elh = (NoNetworkView) this.hPZ.findViewById(R.id.no_networkview);
            this.elh.onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.hPZ.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.hPZ.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.cVg.getString(R.string.agree_me));
            this.ens = (BdSwipeRefreshLayout) this.hPZ.findViewById(R.id.agree_me_pull_refresh_layout);
            this.ens.setProgressView(this.mPullView);
            this.BK = (BdTypeRecyclerView) this.hPZ.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.BK.getItemAnimator()).setSupportsChangeAnimations(false);
            this.BK.setLayoutManager(new LinearLayoutManager(this.cVg.getContext()));
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
            this.BK.setNextPage(this.eli);
            this.BK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.eli != null && a.this.hQa != null) {
                        a.this.eli.showEmptyView(0);
                        a.this.eli.setOnClickListener(null);
                        a.this.eli.showLoading();
                        a.this.hQa.btG();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.ens != null && this.eli != null && this.BK != null && this.hPs != null) {
            this.ens.setRefreshing(false);
            if (z) {
                this.eli.showEmptyView(0);
                this.eli.endLoadData();
                this.eli.setOnClickListener(this.hPC);
            } else {
                this.eli.showEmptyView(0);
                this.eli.endLoadData();
                this.eli.setText(this.cVg.getResources().getString(R.string.list_no_more));
                this.eli.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.cVg.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cA(null, this.cVg.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.hPv) {
                    this.hPv = true;
                    this.BK.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
                }
                this.BK.setNextPage(null);
                return;
            }
            this.BK.removeHeaderView(this.mNoDataView);
            this.hPv = false;
            this.BK.setNextPage(this.eli);
            this.hPs.setData(arrayList);
            this.hPs.notifyDataSetChanged();
        }
    }

    public void oi(boolean z) {
        if (this.ens != null) {
            this.ens.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.elh != null) {
            this.elh.onChangeSkinType(this.cVg, i);
        }
        if (this.eli != null) {
            this.eli.setTextColor(am.getColor(R.color.cp_cont_d));
            this.eli.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cVg, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cVg, i);
        }
        if (this.hPs != null) {
            this.hPs.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.hPZ, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.ens, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.BK, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.hPs != null) {
            this.hPs.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(s sVar) {
        if (this.hPs != null) {
            this.hPs.e(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.BK == null) {
            return null;
        }
        return this.BK.getData();
    }

    public View getRootView() {
        return this.hPZ;
    }

    public RelativeLayout bcM() {
        return this.mContainer;
    }
}
