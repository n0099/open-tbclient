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
    private BdTypeRecyclerView Vf;
    private TbPageContext duG;
    private NoNetworkView ePl;
    private PbListView ePm;
    protected BdSwipeRefreshLayout eRw;
    private e iAX;
    private View iBE;
    private InterfaceC0580a iBF;
    private boolean iBa;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View.OnClickListener iBh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ePm != null && a.this.iBF != null) {
                a.this.ePm.showEmptyView(0);
                a.this.ePm.setOnClickListener(null);
                a.this.ePm.startLoadData();
                a.this.iBF.bDz();
            }
        }
    };
    private final g.c eVZ = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.iBF != null) {
                    a.this.iBF.bRn();
                }
            } else if (a.this.eRw != null) {
                a.this.eRw.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0580a {
        void bDz();

        void bRn();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.duG = tbPageContext;
        this.iBE = view.findViewById(R.id.agree_me_layout);
        c(tbPageContext);
        this.iAX = new e(tbPageContext, this.Vf);
    }

    public void a(InterfaceC0580a interfaceC0580a) {
        this.iBF = interfaceC0580a;
    }

    private void c(TbPageContext tbPageContext) {
        if (this.iBE != null) {
            if (this.mPullView == null) {
                this.mPullView = new h(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.eVZ);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.ePm == null) {
                this.ePm = new PbListView(tbPageContext.getPageActivity());
                this.ePm.getView();
            }
            this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.ePm.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.ePm.setLineGone();
            this.ePm.setTextSize(R.dimen.tbfontsize33);
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ePm.setOnClickListener(this.iBh);
            this.ePl = (NoNetworkView) this.iBE.findViewById(R.id.no_networkview);
            this.ePl.onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.iBE.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.iBE.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.duG.getString(R.string.agree_me));
            this.eRw = (BdSwipeRefreshLayout) this.iBE.findViewById(R.id.agree_me_pull_refresh_layout);
            this.eRw.setProgressView(this.mPullView);
            this.Vf = (BdTypeRecyclerView) this.iBE.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Vf.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Vf.setLayoutManager(new LinearLayoutManager(this.duG.getContext()));
            this.Vf.setFadingEdgeLength(0);
            this.Vf.setBackgroundColor(am.getColor(R.color.transparent));
            this.Vf.setOverScrollMode(2);
            this.Vf.addItemDecoration(new d());
            this.Vf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Vf.setNextPage(this.ePm);
            this.Vf.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.ePm != null && a.this.iBF != null) {
                        a.this.ePm.showEmptyView(0);
                        a.this.ePm.setOnClickListener(null);
                        a.this.ePm.showLoading();
                        a.this.iBF.bDz();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.eRw != null && this.ePm != null && this.Vf != null && this.iAX != null) {
            this.eRw.setRefreshing(false);
            if (z) {
                this.ePm.showEmptyView(0);
                this.ePm.endLoadData();
                this.ePm.setOnClickListener(this.iBh);
            } else {
                this.ePm.showEmptyView(0);
                this.ePm.endLoadData();
                this.ePm.setText(this.duG.getResources().getString(R.string.list_no_more));
                this.ePm.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.duG.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cK(null, this.duG.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.iBa) {
                    this.iBa = true;
                    this.Vf.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Vf.setNextPage(null);
                return;
            }
            this.Vf.removeHeaderView(this.mNoDataView);
            this.iBa = false;
            this.Vf.setNextPage(this.ePm);
            this.iAX.setData(arrayList);
            this.iAX.notifyDataSetChanged();
        }
    }

    public void ps(boolean z) {
        if (this.eRw != null) {
            this.eRw.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ePl != null) {
            this.ePl.onChangeSkinType(this.duG, i);
        }
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ePm.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.duG, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.duG, i);
        }
        if (this.iAX != null) {
            this.iAX.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.iBE, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.eRw, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.Vf, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.iAX != null) {
            this.iAX.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(com.baidu.adp.widget.ListView.v vVar) {
        if (this.iAX != null) {
            this.iAX.e(vVar);
        }
    }

    public List<m> getDatas() {
        if (this.Vf == null) {
            return null;
        }
        return this.Vf.getData();
    }

    public View getRootView() {
        return this.iBE;
    }

    public RelativeLayout blK() {
        return this.mContainer;
    }
}
