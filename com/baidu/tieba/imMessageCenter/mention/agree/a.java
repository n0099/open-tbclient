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
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Xe;
    private TbPageContext eIc;
    private NoNetworkView gjn;
    private PbListView gjo;
    protected BdSwipeRefreshLayout glI;
    private e kvw;
    private boolean kvx;
    private View kwa;
    private InterfaceC0773a kwb;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener kvB = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gjo != null && a.this.kwb != null) {
                a.this.gjo.showEmptyView(0);
                a.this.gjo.setOnClickListener(null);
                a.this.gjo.startLoadData();
                a.this.kwb.cmL();
            }
        }
    };
    private final f.c gqm = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.kwb != null) {
                    a.this.kwb.cBt();
                }
            } else if (a.this.glI != null) {
                a.this.glI.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0773a {
        void cBt();

        void cmL();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.eIc = tbPageContext;
        this.kwa = view.findViewById(R.id.agree_me_layout);
        w(tbPageContext);
        this.kvw = new e(tbPageContext, this.Xe);
    }

    public void a(InterfaceC0773a interfaceC0773a) {
        this.kwb = interfaceC0773a;
    }

    private void w(TbPageContext tbPageContext) {
        if (this.kwa != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.gqm);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.gjo == null) {
                this.gjo = new PbListView(tbPageContext.getPageActivity());
                this.gjo.getView();
            }
            this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.gjo.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.gjo.setLineGone();
            this.gjo.setTextSize(R.dimen.tbfontsize33);
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
            this.gjo.setOnClickListener(this.kvB);
            this.gjn = (NoNetworkView) this.kwa.findViewById(R.id.no_networkview);
            this.gjn.onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.kwa.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.kwa.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.eIc.getString(R.string.agree_me));
            this.glI = (BdSwipeRefreshLayout) this.kwa.findViewById(R.id.agree_me_pull_refresh_layout);
            this.glI.setProgressView(this.mPullView);
            this.Xe = (BdTypeRecyclerView) this.kwa.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Xe.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Xe.setLayoutManager(new LinearLayoutManager(this.eIc.getContext()));
            this.Xe.setFadingEdgeLength(0);
            this.Xe.setBackgroundColor(ap.getColor(R.color.transparent));
            this.Xe.setOverScrollMode(2);
            this.Xe.addItemDecoration(new d());
            this.Xe.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Xe.setNextPage(this.gjo);
            this.Xe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.gjo != null && a.this.kwb != null) {
                        a.this.gjo.showEmptyView(0);
                        a.this.gjo.setOnClickListener(null);
                        a.this.gjo.showLoading();
                        a.this.kwb.cmL();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<q> arrayList) {
        if (this.glI != null && this.gjo != null && this.Xe != null && this.kvw != null) {
            this.glI.setRefreshing(false);
            if (z) {
                this.gjo.showEmptyView(0);
                this.gjo.endLoadData();
                this.gjo.setOnClickListener(this.kvB);
            } else {
                this.gjo.showEmptyView(0);
                this.gjo.endLoadData();
                this.gjo.setText(this.eIc.getResources().getString(R.string.list_no_more));
                this.gjo.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.eIc.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dS(null, this.eIc.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.kvx) {
                    this.kvx = true;
                    this.Xe.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Xe.setNextPage(null);
                return;
            }
            this.Xe.removeHeaderView(this.mNoDataView);
            this.kvx = false;
            this.Xe.setNextPage(this.gjo);
            this.kvw.setData(arrayList);
            this.kvw.notifyDataSetChanged();
        }
    }

    public void sy(boolean z) {
        if (this.glI != null) {
            this.glI.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gjn != null) {
            this.gjn.onChangeSkinType(this.eIc, i);
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gjo.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eIc, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eIc, i);
        }
        if (this.kvw != null) {
            this.kvw.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.kwa, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.glI, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.Xe, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.kvw != null) {
            this.kvw.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(ab abVar) {
        if (this.kvw != null) {
            this.kvw.e(abVar);
        }
    }

    public List<q> getDatas() {
        if (this.Xe == null) {
            return null;
        }
        return this.Xe.getData();
    }

    public View getRootView() {
        return this.kwa;
    }

    public RelativeLayout bPs() {
        return this.mContainer;
    }
}
