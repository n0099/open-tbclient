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
    private BdTypeRecyclerView Yc;
    private TbPageContext eXu;
    private NoNetworkView gCe;
    private PbListView gCf;
    protected BdSwipeRefreshLayout gEz;
    private d kOL;
    private boolean kOM;
    private View kPp;
    private InterfaceC0784a kPq;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener kOQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gCf != null && a.this.kPq != null) {
                a.this.gCf.showEmptyView(0);
                a.this.gCf.setOnClickListener(null);
                a.this.gCf.startLoadData();
                a.this.kPq.ctv();
            }
        }
    };
    private final f.c gJh = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.kPq != null) {
                    a.this.kPq.cIj();
                }
            } else if (a.this.gEz != null) {
                a.this.gEz.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0784a {
        void cIj();

        void ctv();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.eXu = tbPageContext;
        this.kPp = view.findViewById(R.id.agree_me_layout);
        v(tbPageContext);
        this.kOL = new d(tbPageContext, this.Yc);
    }

    public void a(InterfaceC0784a interfaceC0784a) {
        this.kPq = interfaceC0784a;
    }

    private void v(TbPageContext tbPageContext) {
        if (this.kPp != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.gJh);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.gCf == null) {
                this.gCf = new PbListView(tbPageContext.getPageActivity());
                this.gCf.getView();
            }
            this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gCf.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.gCf.setLineGone();
            this.gCf.setTextSize(R.dimen.tbfontsize33);
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gCf.setOnClickListener(this.kOQ);
            this.gCe = (NoNetworkView) this.kPp.findViewById(R.id.no_networkview);
            this.gCe.onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.kPp.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.kPp.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.eXu.getString(R.string.agree_me));
            this.gEz = (BdSwipeRefreshLayout) this.kPp.findViewById(R.id.agree_me_pull_refresh_layout);
            this.gEz.setProgressView(this.mPullView);
            this.Yc = (BdTypeRecyclerView) this.kPp.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Yc.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Yc.setLayoutManager(new LinearLayoutManager(this.eXu.getContext()));
            this.Yc.setFadingEdgeLength(0);
            this.Yc.setBackgroundColor(ao.getColor(R.color.transparent));
            this.Yc.setOverScrollMode(2);
            this.Yc.addItemDecoration(new DeviderLineDecoration());
            this.Yc.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Yc.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.gCf != null && a.this.kPq != null) {
                        a.this.gCf.showEmptyView(0);
                        a.this.gCf.setOnClickListener(null);
                        a.this.gCf.showLoading();
                        a.this.kPq.ctv();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<n> arrayList) {
        if (this.gEz != null && this.gCf != null && this.Yc != null && this.kOL != null) {
            this.gEz.setRefreshing(false);
            if (z) {
                this.gCf.showEmptyView(0);
                this.gCf.endLoadData();
                this.gCf.setOnClickListener(this.kOQ);
            } else {
                this.gCf.showEmptyView(0);
                this.gCf.endLoadData();
                this.gCf.setText(this.eXu.getResources().getString(R.string.list_no_more));
                this.gCf.setOnClickListener(null);
            }
            if (x.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.eXu.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dY(null, this.eXu.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kOM) {
                    this.kOM = true;
                    this.Yc.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Yc.setNextPage(null);
                return;
            }
            this.Yc.removeHeaderView(this.mNoDataView);
            this.kOM = false;
            this.Yc.setNextPage(this.gCf);
            this.kOL.setData(arrayList);
            this.kOL.notifyDataSetChanged();
        }
    }

    public void te(boolean z) {
        if (this.gEz != null) {
            this.gEz.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.eXu, i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eXu, i);
            ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eXu, i);
        }
        if (this.kOL != null) {
            this.kOL.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.kPp, R.color.CAM_X0205);
        ao.setBackgroundColor(this.mContainer, R.color.CAM_X0205);
        ao.setBackgroundColor(this.gEz, R.color.CAM_X0205);
        ao.setBackgroundColor(this.Yc, R.color.CAM_X0204);
    }

    public void onDestroy() {
        if (this.kOL != null) {
            this.kOL.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(w wVar) {
        if (this.kOL != null) {
            this.kOL.e(wVar);
        }
    }

    public List<n> getDatas() {
        if (this.Yc == null) {
            return null;
        }
        return this.Yc.getData();
    }

    public View getRootView() {
        return this.kPp;
    }

    public RelativeLayout bVa() {
        return this.mContainer;
    }
}
