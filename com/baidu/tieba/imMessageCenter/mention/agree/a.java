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
    private BdTypeRecyclerView Yf;
    private TbPageContext eNx;
    private NoNetworkView grf;
    private PbListView grg;
    protected BdSwipeRefreshLayout gtA;
    private e kJC;
    private boolean kJD;
    private View kKg;
    private InterfaceC0791a kKh;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener kJH = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.grg != null && a.this.kKh != null) {
                a.this.grg.showEmptyView(0);
                a.this.grg.setOnClickListener(null);
                a.this.grg.startLoadData();
                a.this.kKh.cqB();
            }
        }
    };
    private final f.c gye = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.kKh != null) {
                    a.this.kKh.cFn();
                }
            } else if (a.this.gtA != null) {
                a.this.gtA.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0791a {
        void cFn();

        void cqB();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.eNx = tbPageContext;
        this.kKg = view.findViewById(R.id.agree_me_layout);
        w(tbPageContext);
        this.kJC = new e(tbPageContext, this.Yf);
    }

    public void a(InterfaceC0791a interfaceC0791a) {
        this.kKh = interfaceC0791a;
    }

    private void w(TbPageContext tbPageContext) {
        if (this.kKg != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.gye);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.grg == null) {
                this.grg = new PbListView(tbPageContext.getPageActivity());
                this.grg.getView();
            }
            this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.grg.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.grg.setLineGone();
            this.grg.setTextSize(R.dimen.tbfontsize33);
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
            this.grg.setOnClickListener(this.kJH);
            this.grf = (NoNetworkView) this.kKg.findViewById(R.id.no_networkview);
            this.grf.onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.kKg.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.kKg.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.eNx.getString(R.string.agree_me));
            this.gtA = (BdSwipeRefreshLayout) this.kKg.findViewById(R.id.agree_me_pull_refresh_layout);
            this.gtA.setProgressView(this.mPullView);
            this.Yf = (BdTypeRecyclerView) this.kKg.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Yf.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Yf.setLayoutManager(new LinearLayoutManager(this.eNx.getContext()));
            this.Yf.setFadingEdgeLength(0);
            this.Yf.setBackgroundColor(ap.getColor(R.color.transparent));
            this.Yf.setOverScrollMode(2);
            this.Yf.addItemDecoration(new d());
            this.Yf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Yf.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.grg != null && a.this.kKh != null) {
                        a.this.grg.showEmptyView(0);
                        a.this.grg.setOnClickListener(null);
                        a.this.grg.showLoading();
                        a.this.kKh.cqB();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<q> arrayList) {
        if (this.gtA != null && this.grg != null && this.Yf != null && this.kJC != null) {
            this.gtA.setRefreshing(false);
            if (z) {
                this.grg.showEmptyView(0);
                this.grg.endLoadData();
                this.grg.setOnClickListener(this.kJH);
            } else {
                this.grg.showEmptyView(0);
                this.grg.endLoadData();
                this.grg.setText(this.eNx.getResources().getString(R.string.list_no_more));
                this.grg.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.eNx.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dZ(null, this.eNx.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kJD) {
                    this.kJD = true;
                    this.Yf.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Yf.setNextPage(null);
                return;
            }
            this.Yf.removeHeaderView(this.mNoDataView);
            this.kJD = false;
            this.Yf.setNextPage(this.grg);
            this.kJC.setData(arrayList);
            this.kJC.notifyDataSetChanged();
        }
    }

    public void td(boolean z) {
        if (this.gtA != null) {
            this.gtA.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grf != null) {
            this.grf.onChangeSkinType(this.eNx, i);
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.grg.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eNx, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eNx, i);
        }
        if (this.kJC != null) {
            this.kJC.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.kKg, R.color.CAM_X0205);
        ap.setBackgroundColor(this.mContainer, R.color.CAM_X0205);
        ap.setBackgroundColor(this.gtA, R.color.CAM_X0205);
        ap.setBackgroundColor(this.Yf, R.color.CAM_X0204);
    }

    public void onDestroy() {
        if (this.kJC != null) {
            this.kJC.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(ab abVar) {
        if (this.kJC != null) {
            this.kJC.e(abVar);
        }
    }

    public List<q> getDatas() {
        if (this.Yf == null) {
            return null;
        }
        return this.Yf.getData();
    }

    public View getRootView() {
        return this.kKg;
    }

    public RelativeLayout bSx() {
        return this.mContainer;
    }
}
