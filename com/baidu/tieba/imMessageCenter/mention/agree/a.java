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
    private TbPageContext cfl;
    private NoNetworkView dwI;
    private PbListView dwJ;
    protected BdSwipeRefreshLayout dyk;
    private e gWG;
    private boolean gWJ;
    private View gXm;
    private InterfaceC0449a gXn;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private BdTypeRecyclerView zj;
    private View.OnClickListener gWR = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dwJ != null && a.this.gXn != null) {
                a.this.dwJ.showEmptyView(0);
                a.this.dwJ.setOnClickListener(null);
                a.this.dwJ.startLoadData();
                a.this.gXn.aYY();
            }
        }
    };
    private final h.c dCB = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.gXn != null) {
                    a.this.gXn.bmA();
                }
            } else if (a.this.dyk != null) {
                a.this.dyk.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0449a {
        void aYY();

        void bmA();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.cfl = tbPageContext;
        this.gXm = view.findViewById(R.id.agree_me_layout);
        q(tbPageContext);
        this.gWG = new e(tbPageContext, this.zj);
    }

    public void a(InterfaceC0449a interfaceC0449a) {
        this.gXn = interfaceC0449a;
    }

    private void q(TbPageContext tbPageContext) {
        if (this.gXm != null) {
            if (this.mPullView == null) {
                this.mPullView = new i(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.dCB);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.dwJ == null) {
                this.dwJ = new PbListView(tbPageContext.getPageActivity());
                this.dwJ.getView();
            }
            this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.dwJ.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.dwJ.setLineGone();
            this.dwJ.setTextSize(R.dimen.tbfontsize33);
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dwJ.setOnClickListener(this.gWR);
            this.dwI = (NoNetworkView) this.gXm.findViewById(R.id.no_networkview);
            this.dwI.onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.gXm.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.cfl.getString(R.string.agree_me));
            this.dyk = (BdSwipeRefreshLayout) this.gXm.findViewById(R.id.agree_me_pull_refresh_layout);
            this.dyk.setProgressView(this.mPullView);
            this.zj = (BdTypeRecyclerView) this.gXm.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.zj.getItemAnimator()).setSupportsChangeAnimations(false);
            this.zj.setLayoutManager(new LinearLayoutManager(this.cfl.getContext()));
            this.zj.setFadingEdgeLength(0);
            this.zj.setBackgroundColor(am.getColor(R.color.transparent));
            this.zj.setOverScrollMode(2);
            this.zj.addItemDecoration(new d());
            this.zj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.zj.setNextPage(this.dwJ);
            this.zj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.dwJ != null && a.this.gXn != null) {
                        a.this.dwJ.showEmptyView(0);
                        a.this.dwJ.setOnClickListener(null);
                        a.this.dwJ.showLoading();
                        a.this.gXn.aYY();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.dyk != null && this.dwJ != null && this.zj != null && this.gWG != null) {
            this.dyk.setRefreshing(false);
            if (z) {
                this.dwJ.showEmptyView(0);
                this.dwJ.endLoadData();
                this.dwJ.setOnClickListener(this.gWR);
            } else {
                this.dwJ.showEmptyView(0);
                this.dwJ.endLoadData();
                this.dwJ.setText(this.cfl.getResources().getString(R.string.list_no_more));
                this.dwJ.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.cfl.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iL(R.string.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gWJ) {
                    this.gWJ = true;
                    this.zj.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
                }
                this.zj.setNextPage(null);
                return;
            }
            this.zj.removeHeaderView(this.mNoDataView);
            this.gWJ = false;
            this.zj.setNextPage(this.dwJ);
            this.gWG.setData(arrayList);
            this.gWG.notifyDataSetChanged();
        }
    }

    public void mH(boolean z) {
        if (this.dyk != null) {
            this.dyk.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.dwI != null) {
            this.dwI.onChangeSkinType(this.cfl, i);
        }
        if (this.dwJ != null) {
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dwJ.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cfl, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cfl, i);
        }
        if (this.gWG != null) {
            this.gWG.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.gXm, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.dyk, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.zj, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.gWG != null) {
            this.gWG.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(s sVar) {
        if (this.gWG != null) {
            this.gWG.e(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.zj == null) {
            return null;
        }
        return this.zj.getData();
    }

    public View getRootView() {
        return this.gXm;
    }
}
