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
    private NoNetworkView grd;
    private PbListView gre;
    protected BdSwipeRefreshLayout gty;
    private e kJA;
    private boolean kJB;
    private View kKe;
    private InterfaceC0791a kKf;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener kJF = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gre != null && a.this.kKf != null) {
                a.this.gre.showEmptyView(0);
                a.this.gre.setOnClickListener(null);
                a.this.gre.startLoadData();
                a.this.kKf.cqA();
            }
        }
    };
    private final f.c gyc = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.kKf != null) {
                    a.this.kKf.cFm();
                }
            } else if (a.this.gty != null) {
                a.this.gty.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0791a {
        void cFm();

        void cqA();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.eNx = tbPageContext;
        this.kKe = view.findViewById(R.id.agree_me_layout);
        w(tbPageContext);
        this.kJA = new e(tbPageContext, this.Yf);
    }

    public void a(InterfaceC0791a interfaceC0791a) {
        this.kKf = interfaceC0791a;
    }

    private void w(TbPageContext tbPageContext) {
        if (this.kKe != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.gyc);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.gre == null) {
                this.gre = new PbListView(tbPageContext.getPageActivity());
                this.gre.getView();
            }
            this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gre.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.gre.setLineGone();
            this.gre.setTextSize(R.dimen.tbfontsize33);
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gre.setOnClickListener(this.kJF);
            this.grd = (NoNetworkView) this.kKe.findViewById(R.id.no_networkview);
            this.grd.onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.kKe.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.kKe.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.eNx.getString(R.string.agree_me));
            this.gty = (BdSwipeRefreshLayout) this.kKe.findViewById(R.id.agree_me_pull_refresh_layout);
            this.gty.setProgressView(this.mPullView);
            this.Yf = (BdTypeRecyclerView) this.kKe.findViewById(R.id.agree_me_recycler_view);
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
                    if (a.this.gre != null && a.this.kKf != null) {
                        a.this.gre.showEmptyView(0);
                        a.this.gre.setOnClickListener(null);
                        a.this.gre.showLoading();
                        a.this.kKf.cqA();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<q> arrayList) {
        if (this.gty != null && this.gre != null && this.Yf != null && this.kJA != null) {
            this.gty.setRefreshing(false);
            if (z) {
                this.gre.showEmptyView(0);
                this.gre.endLoadData();
                this.gre.setOnClickListener(this.kJF);
            } else {
                this.gre.showEmptyView(0);
                this.gre.endLoadData();
                this.gre.setText(this.eNx.getResources().getString(R.string.list_no_more));
                this.gre.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.eNx.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dZ(null, this.eNx.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kJB) {
                    this.kJB = true;
                    this.Yf.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Yf.setNextPage(null);
                return;
            }
            this.Yf.removeHeaderView(this.mNoDataView);
            this.kJB = false;
            this.Yf.setNextPage(this.gre);
            this.kJA.setData(arrayList);
            this.kJA.notifyDataSetChanged();
        }
    }

    public void td(boolean z) {
        if (this.gty != null) {
            this.gty.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grd != null) {
            this.grd.onChangeSkinType(this.eNx, i);
        }
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gre.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eNx, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eNx, i);
        }
        if (this.kJA != null) {
            this.kJA.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.kKe, R.color.CAM_X0205);
        ap.setBackgroundColor(this.mContainer, R.color.CAM_X0205);
        ap.setBackgroundColor(this.gty, R.color.CAM_X0205);
        ap.setBackgroundColor(this.Yf, R.color.CAM_X0204);
    }

    public void onDestroy() {
        if (this.kJA != null) {
            this.kJA.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(ab abVar) {
        if (this.kJA != null) {
            this.kJA.e(abVar);
        }
    }

    public List<q> getDatas() {
        if (this.Yf == null) {
            return null;
        }
        return this.Yf.getData();
    }

    public View getRootView() {
        return this.kKe;
    }

    public RelativeLayout bSw() {
        return this.mContainer;
    }
}
