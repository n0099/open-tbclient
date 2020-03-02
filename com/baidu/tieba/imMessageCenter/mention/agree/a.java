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
    private TbPageContext cVh;
    private NoNetworkView eli;
    private PbListView elj;
    protected BdSwipeRefreshLayout ent;
    private e hPu;
    private boolean hPx;
    private View hQb;
    private InterfaceC0542a hQc;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View.OnClickListener hPE = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.elj != null && a.this.hQc != null) {
                a.this.elj.showEmptyView(0);
                a.this.elj.setOnClickListener(null);
                a.this.elj.startLoadData();
                a.this.hQc.btI();
            }
        }
    };
    private final g.c erU = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.hQc != null) {
                    a.this.hQc.bGz();
                }
            } else if (a.this.ent != null) {
                a.this.ent.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0542a {
        void bGz();

        void btI();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.cVh = tbPageContext;
        this.hQb = view.findViewById(R.id.agree_me_layout);
        c(tbPageContext);
        this.hPu = new e(tbPageContext, this.BK);
    }

    public void a(InterfaceC0542a interfaceC0542a) {
        this.hQc = interfaceC0542a;
    }

    private void c(TbPageContext tbPageContext) {
        if (this.hQb != null) {
            if (this.mPullView == null) {
                this.mPullView = new h(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.erU);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.elj == null) {
                this.elj = new PbListView(tbPageContext.getPageActivity());
                this.elj.getView();
            }
            this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.elj.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.elj.setLineGone();
            this.elj.setTextSize(R.dimen.tbfontsize33);
            this.elj.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elj.setOnClickListener(this.hPE);
            this.eli = (NoNetworkView) this.hQb.findViewById(R.id.no_networkview);
            this.eli.onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.hQb.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.hQb.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.cVh.getString(R.string.agree_me));
            this.ent = (BdSwipeRefreshLayout) this.hQb.findViewById(R.id.agree_me_pull_refresh_layout);
            this.ent.setProgressView(this.mPullView);
            this.BK = (BdTypeRecyclerView) this.hQb.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.BK.getItemAnimator()).setSupportsChangeAnimations(false);
            this.BK.setLayoutManager(new LinearLayoutManager(this.cVh.getContext()));
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
            this.BK.setNextPage(this.elj);
            this.BK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.elj != null && a.this.hQc != null) {
                        a.this.elj.showEmptyView(0);
                        a.this.elj.setOnClickListener(null);
                        a.this.elj.showLoading();
                        a.this.hQc.btI();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.ent != null && this.elj != null && this.BK != null && this.hPu != null) {
            this.ent.setRefreshing(false);
            if (z) {
                this.elj.showEmptyView(0);
                this.elj.endLoadData();
                this.elj.setOnClickListener(this.hPE);
            } else {
                this.elj.showEmptyView(0);
                this.elj.endLoadData();
                this.elj.setText(this.cVh.getResources().getString(R.string.list_no_more));
                this.elj.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.cVh.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cA(null, this.cVh.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.hPx) {
                    this.hPx = true;
                    this.BK.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
                }
                this.BK.setNextPage(null);
                return;
            }
            this.BK.removeHeaderView(this.mNoDataView);
            this.hPx = false;
            this.BK.setNextPage(this.elj);
            this.hPu.setData(arrayList);
            this.hPu.notifyDataSetChanged();
        }
    }

    public void oi(boolean z) {
        if (this.ent != null) {
            this.ent.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.eli != null) {
            this.eli.onChangeSkinType(this.cVh, i);
        }
        if (this.elj != null) {
            this.elj.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elj.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cVh, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cVh, i);
        }
        if (this.hPu != null) {
            this.hPu.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.hQb, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.ent, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.BK, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.hPu != null) {
            this.hPu.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(s sVar) {
        if (this.hPu != null) {
            this.hPu.e(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.BK == null) {
            return null;
        }
        return this.BK.getData();
    }

    public View getRootView() {
        return this.hQb;
    }

    public RelativeLayout bcO() {
        return this.mContainer;
    }
}
