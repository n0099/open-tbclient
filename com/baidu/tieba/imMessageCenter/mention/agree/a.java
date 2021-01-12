package com.baidu.tieba.imMessageCenter.mention.agree;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.base.DeviderLineDecoration;
import com.baidu.tieba.imMessageCenter.mention.base.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Ya;
    private TbPageContext eSJ;
    private NoNetworkView gxx;
    private PbListView gxy;
    protected BdSwipeRefreshLayout gzS;
    private View kKK;
    private InterfaceC0767a kKL;
    private d kKg;
    private boolean kKh;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener kKl = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gxy != null && a.this.kKL != null) {
                a.this.gxy.showEmptyView(0);
                a.this.gxy.setOnClickListener(null);
                a.this.gxy.startLoadData();
                a.this.kKL.cpD();
            }
        }
    };
    private final f.c gEB = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.kKL != null) {
                    a.this.kKL.cEr();
                }
            } else if (a.this.gzS != null) {
                a.this.gzS.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0767a {
        void cEr();

        void cpD();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.eSJ = tbPageContext;
        this.kKK = view.findViewById(R.id.agree_me_layout);
        v(tbPageContext);
        this.kKg = new d(tbPageContext, this.Ya);
    }

    public void a(InterfaceC0767a interfaceC0767a) {
        this.kKL = interfaceC0767a;
    }

    private void v(TbPageContext tbPageContext) {
        if (this.kKK != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.gEB);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.gxy == null) {
                this.gxy = new PbListView(tbPageContext.getPageActivity());
                this.gxy.getView();
            }
            this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gxy.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.gxy.setLineGone();
            this.gxy.setTextSize(R.dimen.tbfontsize33);
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gxy.setOnClickListener(this.kKl);
            this.gxx = (NoNetworkView) this.kKK.findViewById(R.id.no_networkview);
            this.gxx.onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.kKK.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.kKK.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.eSJ.getString(R.string.agree_me));
            this.gzS = (BdSwipeRefreshLayout) this.kKK.findViewById(R.id.agree_me_pull_refresh_layout);
            this.gzS.setProgressView(this.mPullView);
            this.Ya = (BdTypeRecyclerView) this.kKK.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Ya.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Ya.setLayoutManager(new LinearLayoutManager(this.eSJ.getContext()));
            this.Ya.setFadingEdgeLength(0);
            this.Ya.setBackgroundColor(ao.getColor(R.color.transparent));
            this.Ya.setOverScrollMode(2);
            this.Ya.addItemDecoration(new DeviderLineDecoration());
            this.Ya.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Ya.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.gxy != null && a.this.kKL != null) {
                        a.this.gxy.showEmptyView(0);
                        a.this.gxy.setOnClickListener(null);
                        a.this.gxy.showLoading();
                        a.this.kKL.cpD();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<n> arrayList) {
        if (this.gzS != null && this.gxy != null && this.Ya != null && this.kKg != null) {
            this.gzS.setRefreshing(false);
            if (z) {
                this.gxy.showEmptyView(0);
                this.gxy.endLoadData();
                this.gxy.setOnClickListener(this.kKl);
            } else {
                this.gxy.showEmptyView(0);
                this.gxy.endLoadData();
                this.gxy.setText(this.eSJ.getResources().getString(R.string.list_no_more));
                this.gxy.setOnClickListener(null);
            }
            if (x.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.eSJ.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dX(null, this.eSJ.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kKh) {
                    this.kKh = true;
                    this.Ya.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Ya.setNextPage(null);
                return;
            }
            this.Ya.removeHeaderView(this.mNoDataView);
            this.kKh = false;
            this.Ya.setNextPage(this.gxy);
            this.kKg.setData(arrayList);
            this.kKg.notifyDataSetChanged();
        }
    }

    public void ta(boolean z) {
        if (this.gzS != null) {
            this.gzS.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gxx != null) {
            this.gxx.onChangeSkinType(this.eSJ, i);
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gxy.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eSJ, i);
            ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eSJ, i);
        }
        if (this.kKg != null) {
            this.kKg.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.kKK, R.color.CAM_X0205);
        ao.setBackgroundColor(this.mContainer, R.color.CAM_X0205);
        ao.setBackgroundColor(this.gzS, R.color.CAM_X0205);
        ao.setBackgroundColor(this.Ya, R.color.CAM_X0204);
    }

    public void onDestroy() {
        if (this.kKg != null) {
            this.kKg.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(w wVar) {
        if (this.kKg != null) {
            this.kKg.e(wVar);
        }
    }

    public List<n> getDatas() {
        if (this.Ya == null) {
            return null;
        }
        return this.Ya.getData();
    }

    public View getRootView() {
        return this.kKK;
    }

    public RelativeLayout bRi() {
        return this.mContainer;
    }
}
