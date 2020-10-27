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
    private TbPageContext eCn;
    private NoNetworkView gdx;
    private PbListView gdy;
    protected BdSwipeRefreshLayout gfT;
    private e kpA;
    private boolean kpB;
    private View kqe;
    private InterfaceC0759a kqf;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener kpF = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gdy != null && a.this.kqf != null) {
                a.this.gdy.showEmptyView(0);
                a.this.gdy.setOnClickListener(null);
                a.this.gdy.startLoadData();
                a.this.kqf.ckj();
            }
        }
    };
    private final f.c gkz = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.kqf != null) {
                    a.this.kqf.cyS();
                }
            } else if (a.this.gfT != null) {
                a.this.gfT.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0759a {
        void ckj();

        void cyS();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.eCn = tbPageContext;
        this.kqe = view.findViewById(R.id.agree_me_layout);
        w(tbPageContext);
        this.kpA = new e(tbPageContext, this.Xe);
    }

    public void a(InterfaceC0759a interfaceC0759a) {
        this.kqf = interfaceC0759a;
    }

    private void w(TbPageContext tbPageContext) {
        if (this.kqe != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.gkz);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.gdy == null) {
                this.gdy = new PbListView(tbPageContext.getPageActivity());
                this.gdy.getView();
            }
            this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.gdy.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.gdy.setLineGone();
            this.gdy.setTextSize(R.dimen.tbfontsize33);
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
            this.gdy.setOnClickListener(this.kpF);
            this.gdx = (NoNetworkView) this.kqe.findViewById(R.id.no_networkview);
            this.gdx.onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.kqe.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.kqe.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.eCn.getString(R.string.agree_me));
            this.gfT = (BdSwipeRefreshLayout) this.kqe.findViewById(R.id.agree_me_pull_refresh_layout);
            this.gfT.setProgressView(this.mPullView);
            this.Xe = (BdTypeRecyclerView) this.kqe.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Xe.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Xe.setLayoutManager(new LinearLayoutManager(this.eCn.getContext()));
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
            this.Xe.setNextPage(this.gdy);
            this.Xe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.gdy != null && a.this.kqf != null) {
                        a.this.gdy.showEmptyView(0);
                        a.this.gdy.setOnClickListener(null);
                        a.this.gdy.showLoading();
                        a.this.kqf.ckj();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<q> arrayList) {
        if (this.gfT != null && this.gdy != null && this.Xe != null && this.kpA != null) {
            this.gfT.setRefreshing(false);
            if (z) {
                this.gdy.showEmptyView(0);
                this.gdy.endLoadData();
                this.gdy.setOnClickListener(this.kpF);
            } else {
                this.gdy.showEmptyView(0);
                this.gdy.endLoadData();
                this.gdy.setText(this.eCn.getResources().getString(R.string.list_no_more));
                this.gdy.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.eCn.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dS(null, this.eCn.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.kpB) {
                    this.kpB = true;
                    this.Xe.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Xe.setNextPage(null);
                return;
            }
            this.Xe.removeHeaderView(this.mNoDataView);
            this.kpB = false;
            this.Xe.setNextPage(this.gdy);
            this.kpA.setData(arrayList);
            this.kpA.notifyDataSetChanged();
        }
    }

    public void sp(boolean z) {
        if (this.gfT != null) {
            this.gfT.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gdx != null) {
            this.gdx.onChangeSkinType(this.eCn, i);
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gdy.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eCn, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eCn, i);
        }
        if (this.kpA != null) {
            this.kpA.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.kqe, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.gfT, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.Xe, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.kpA != null) {
            this.kpA.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(ab abVar) {
        if (this.kpA != null) {
            this.kpA.e(abVar);
        }
    }

    public List<q> getDatas() {
        if (this.Xe == null) {
            return null;
        }
        return this.Xe.getData();
    }

    public View getRootView() {
        return this.kqe;
    }

    public RelativeLayout bMS() {
        return this.mContainer;
    }
}
