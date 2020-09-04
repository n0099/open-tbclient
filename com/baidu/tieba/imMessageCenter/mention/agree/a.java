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
/* loaded from: classes16.dex */
public class a {
    private BdTypeRecyclerView Wu;
    private TbPageContext efr;
    private NoNetworkView fDZ;
    private PbListView fEa;
    protected BdSwipeRefreshLayout fGm;
    private e jFB;
    private boolean jFC;
    private View jGf;
    private InterfaceC0728a jGg;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener jFG = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fEa != null && a.this.jGg != null) {
                a.this.fEa.showEmptyView(0);
                a.this.fEa.setOnClickListener(null);
                a.this.fEa.startLoadData();
                a.this.jGg.cau();
            }
        }
    };
    private final f.c fKP = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.jGg != null) {
                    a.this.jGg.cpb();
                }
            } else if (a.this.fGm != null) {
                a.this.fGm.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0728a {
        void cau();

        void cpb();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.efr = tbPageContext;
        this.jGf = view.findViewById(R.id.agree_me_layout);
        w(tbPageContext);
        this.jFB = new e(tbPageContext, this.Wu);
    }

    public void a(InterfaceC0728a interfaceC0728a) {
        this.jGg = interfaceC0728a;
    }

    private void w(TbPageContext tbPageContext) {
        if (this.jGf != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.fKP);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.fEa == null) {
                this.fEa = new PbListView(tbPageContext.getPageActivity());
                this.fEa.getView();
            }
            this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fEa.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.fEa.setLineGone();
            this.fEa.setTextSize(R.dimen.tbfontsize33);
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fEa.setOnClickListener(this.jFG);
            this.fDZ = (NoNetworkView) this.jGf.findViewById(R.id.no_networkview);
            this.fDZ.onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.jGf.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.jGf.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.efr.getString(R.string.agree_me));
            this.fGm = (BdSwipeRefreshLayout) this.jGf.findViewById(R.id.agree_me_pull_refresh_layout);
            this.fGm.setProgressView(this.mPullView);
            this.Wu = (BdTypeRecyclerView) this.jGf.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Wu.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Wu.setLayoutManager(new LinearLayoutManager(this.efr.getContext()));
            this.Wu.setFadingEdgeLength(0);
            this.Wu.setBackgroundColor(ap.getColor(R.color.transparent));
            this.Wu.setOverScrollMode(2);
            this.Wu.addItemDecoration(new d());
            this.Wu.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Wu.setNextPage(this.fEa);
            this.Wu.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.fEa != null && a.this.jGg != null) {
                        a.this.fEa.showEmptyView(0);
                        a.this.fEa.setOnClickListener(null);
                        a.this.fEa.showLoading();
                        a.this.jGg.cau();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<q> arrayList) {
        if (this.fGm != null && this.fEa != null && this.Wu != null && this.jFB != null) {
            this.fGm.setRefreshing(false);
            if (z) {
                this.fEa.showEmptyView(0);
                this.fEa.endLoadData();
                this.fEa.setOnClickListener(this.jFG);
            } else {
                this.fEa.showEmptyView(0);
                this.fEa.endLoadData();
                this.fEa.setText(this.efr.getResources().getString(R.string.list_no_more));
                this.fEa.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.efr.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dE(null, this.efr.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.jFC) {
                    this.jFC = true;
                    this.Wu.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Wu.setNextPage(null);
                return;
            }
            this.Wu.removeHeaderView(this.mNoDataView);
            this.jFC = false;
            this.Wu.setNextPage(this.fEa);
            this.jFB.setData(arrayList);
            this.jFB.notifyDataSetChanged();
        }
    }

    public void rj(boolean z) {
        if (this.fGm != null) {
            this.fGm.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fDZ != null) {
            this.fDZ.onChangeSkinType(this.efr, i);
        }
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fEa.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.efr, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.efr, i);
        }
        if (this.jFB != null) {
            this.jFB.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.jGf, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.fGm, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.Wu, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.jFB != null) {
            this.jFB.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(ab abVar) {
        if (this.jFB != null) {
            this.jFB.e(abVar);
        }
    }

    public List<q> getDatas() {
        if (this.Wu == null) {
            return null;
        }
        return this.Wu.getData();
    }

    public View getRootView() {
        return this.jGf;
    }

    public RelativeLayout bGo() {
        return this.mContainer;
    }
}
