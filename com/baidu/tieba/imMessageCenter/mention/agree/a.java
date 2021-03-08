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
import com.baidu.tieba.imMessageCenter.mention.base.DeviderLineDecoration;
import com.baidu.tieba.imMessageCenter.mention.base.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Zq;
    private TbPageContext eWx;
    private NoNetworkView gCe;
    private PbListView gCf;
    protected BdSwipeRefreshLayout gEz;
    private boolean kUA;
    private d kUz;
    private View kVd;
    private InterfaceC0776a kVe;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener kUE = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gCf != null && a.this.kVe != null) {
                a.this.gCf.showEmptyView(0);
                a.this.gCf.setOnClickListener(null);
                a.this.gCf.startLoadData();
                a.this.kVe.cra();
            }
        }
    };
    private final f.c gJi = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.kVe != null) {
                    a.this.kVe.cFR();
                }
            } else if (a.this.gEz != null) {
                a.this.gEz.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0776a {
        void cFR();

        void cra();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.eWx = tbPageContext;
        this.kVd = view.findViewById(R.id.agree_me_layout);
        x(tbPageContext);
        this.kUz = new d(tbPageContext, this.Zq);
    }

    public void a(InterfaceC0776a interfaceC0776a) {
        this.kVe = interfaceC0776a;
    }

    private void x(TbPageContext tbPageContext) {
        if (this.kVd != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.gJi);
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
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gCf.setOnClickListener(this.kUE);
            this.gCe = (NoNetworkView) this.kVd.findViewById(R.id.no_networkview);
            this.gCe.onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.kVd.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.kVd.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.eWx.getString(R.string.agree_me));
            this.gEz = (BdSwipeRefreshLayout) this.kVd.findViewById(R.id.agree_me_pull_refresh_layout);
            this.gEz.setProgressView(this.mPullView);
            this.Zq = (BdTypeRecyclerView) this.kVd.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Zq.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Zq.setLayoutManager(new LinearLayoutManager(this.eWx.getContext()));
            this.Zq.setFadingEdgeLength(0);
            this.Zq.setBackgroundColor(ap.getColor(R.color.transparent));
            this.Zq.setOverScrollMode(2);
            this.Zq.addItemDecoration(new DeviderLineDecoration());
            this.Zq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Zq.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.gCf != null && a.this.kVe != null) {
                        a.this.gCf.showEmptyView(0);
                        a.this.gCf.setOnClickListener(null);
                        a.this.gCf.showLoading();
                        a.this.kVe.cra();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<n> arrayList) {
        if (this.gEz != null && this.gCf != null && this.Zq != null && this.kUz != null) {
            this.gEz.setRefreshing(false);
            if (z) {
                this.gCf.showEmptyView(0);
                this.gCf.endLoadData();
                this.gCf.setOnClickListener(this.kUE);
            } else {
                this.gCf.showEmptyView(0);
                this.gCf.endLoadData();
                this.gCf.setText(this.eWx.getResources().getString(R.string.list_no_more));
                this.gCf.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.eWx.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dS(null, this.eWx.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kUA) {
                    this.kUA = true;
                    this.Zq.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Zq.setNextPage(null);
                return;
            }
            this.Zq.removeHeaderView(this.mNoDataView);
            this.kUA = false;
            this.Zq.setNextPage(this.gCf);
            this.kUz.setData(arrayList);
            this.kUz.notifyDataSetChanged();
        }
    }

    public void tn(boolean z) {
        if (this.gEz != null) {
            this.gEz.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.eWx, i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eWx, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eWx, i);
        }
        if (this.kUz != null) {
            this.kUz.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.kVd, R.color.CAM_X0205);
        ap.setBackgroundColor(this.mContainer, R.color.CAM_X0205);
        ap.setBackgroundColor(this.gEz, R.color.CAM_X0205);
        ap.setBackgroundColor(this.Zq, R.color.CAM_X0204);
    }

    public void onDestroy() {
        if (this.kUz != null) {
            this.kUz.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(w wVar) {
        if (this.kUz != null) {
            this.kUz.e(wVar);
        }
    }

    public List<n> getDatas() {
        if (this.Zq == null) {
            return null;
        }
        return this.Zq.getData();
    }

    public View getRootView() {
        return this.kVd;
    }

    public RelativeLayout bRY() {
        return this.mContainer;
    }
}
