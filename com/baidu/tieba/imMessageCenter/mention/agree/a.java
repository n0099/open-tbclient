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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.base.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private BdTypeRecyclerView Xi;
    private TbPageContext eGu;
    private NoNetworkView giU;
    private PbListView giV;
    protected BdSwipeRefreshLayout glp;
    private View kwK;
    private InterfaceC0775a kwL;
    private e kwg;
    private boolean kwh;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener kwl = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.giV != null && a.this.kwL != null) {
                a.this.giV.showEmptyView(0);
                a.this.giV.setOnClickListener(null);
                a.this.giV.startLoadData();
                a.this.kwL.cmn();
            }
        }
    };
    private final f.c gpT = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.kwL != null) {
                    a.this.kwL.cAW();
                }
            } else if (a.this.glp != null) {
                a.this.glp.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0775a {
        void cAW();

        void cmn();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.eGu = tbPageContext;
        this.kwK = view.findViewById(R.id.agree_me_layout);
        w(tbPageContext);
        this.kwg = new e(tbPageContext, this.Xi);
    }

    public void a(InterfaceC0775a interfaceC0775a) {
        this.kwL = interfaceC0775a;
    }

    private void w(TbPageContext tbPageContext) {
        if (this.kwK != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.gpT);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.giV == null) {
                this.giV = new PbListView(tbPageContext.getPageActivity());
                this.giV.getView();
            }
            this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.giV.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.giV.setLineGone();
            this.giV.setTextSize(R.dimen.tbfontsize33);
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
            this.giV.setOnClickListener(this.kwl);
            this.giU = (NoNetworkView) this.kwK.findViewById(R.id.no_networkview);
            this.giU.onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.kwK.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.kwK.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.eGu.getString(R.string.agree_me));
            this.glp = (BdSwipeRefreshLayout) this.kwK.findViewById(R.id.agree_me_pull_refresh_layout);
            this.glp.setProgressView(this.mPullView);
            this.Xi = (BdTypeRecyclerView) this.kwK.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Xi.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Xi.setLayoutManager(new LinearLayoutManager(this.eGu.getContext()));
            this.Xi.setFadingEdgeLength(0);
            this.Xi.setBackgroundColor(ap.getColor(R.color.transparent));
            this.Xi.setOverScrollMode(2);
            this.Xi.addItemDecoration(new d());
            this.Xi.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Xi.setNextPage(this.giV);
            this.Xi.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.giV != null && a.this.kwL != null) {
                        a.this.giV.showEmptyView(0);
                        a.this.giV.setOnClickListener(null);
                        a.this.giV.showLoading();
                        a.this.kwL.cmn();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<q> arrayList) {
        if (this.glp != null && this.giV != null && this.Xi != null && this.kwg != null) {
            this.glp.setRefreshing(false);
            if (z) {
                this.giV.showEmptyView(0);
                this.giV.endLoadData();
                this.giV.setOnClickListener(this.kwl);
            } else {
                this.giV.showEmptyView(0);
                this.giV.endLoadData();
                this.giV.setText(this.eGu.getResources().getString(R.string.list_no_more));
                this.giV.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.eGu.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dS(null, this.eGu.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kwh) {
                    this.kwh = true;
                    this.Xi.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Xi.setNextPage(null);
                return;
            }
            this.Xi.removeHeaderView(this.mNoDataView);
            this.kwh = false;
            this.Xi.setNextPage(this.giV);
            this.kwg.setData(arrayList);
            this.kwg.notifyDataSetChanged();
        }
    }

    public void sB(boolean z) {
        if (this.glp != null) {
            this.glp.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.giU != null) {
            this.giU.onChangeSkinType(this.eGu, i);
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.giV.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eGu, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eGu, i);
        }
        if (this.kwg != null) {
            this.kwg.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.kwK, R.color.CAM_X0205);
        ap.setBackgroundColor(this.mContainer, R.color.CAM_X0205);
        ap.setBackgroundColor(this.glp, R.color.CAM_X0205);
        ap.setBackgroundColor(this.Xi, R.color.CAM_X0204);
    }

    public void onDestroy() {
        if (this.kwg != null) {
            this.kwg.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(ab abVar) {
        if (this.kwg != null) {
            this.kwg.e(abVar);
        }
    }

    public List<q> getDatas() {
        if (this.Xi == null) {
            return null;
        }
        return this.Xi.getData();
    }

    public View getRootView() {
        return this.kwK;
    }

    public RelativeLayout bOL() {
        return this.mContainer;
    }
}
