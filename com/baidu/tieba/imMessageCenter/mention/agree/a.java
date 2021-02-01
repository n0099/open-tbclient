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
    private BdTypeRecyclerView XW;
    private TbPageContext eUY;
    private NoNetworkView gAh;
    private PbListView gAi;
    protected BdSwipeRefreshLayout gCC;
    private View kSN;
    private InterfaceC0769a kSO;
    private d kSj;
    private boolean kSk;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener kSo = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gAi != null && a.this.kSO != null) {
                a.this.gAi.showEmptyView(0);
                a.this.gAi.setOnClickListener(null);
                a.this.gAi.startLoadData();
                a.this.kSO.cqN();
            }
        }
    };
    private final f.c gHl = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.kSO != null) {
                    a.this.kSO.cFE();
                }
            } else if (a.this.gCC != null) {
                a.this.gCC.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0769a {
        void cFE();

        void cqN();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.eUY = tbPageContext;
        this.kSN = view.findViewById(R.id.agree_me_layout);
        x(tbPageContext);
        this.kSj = new d(tbPageContext, this.XW);
    }

    public void a(InterfaceC0769a interfaceC0769a) {
        this.kSO = interfaceC0769a;
    }

    private void x(TbPageContext tbPageContext) {
        if (this.kSN != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.gHl);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.gAi == null) {
                this.gAi = new PbListView(tbPageContext.getPageActivity());
                this.gAi.getView();
            }
            this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gAi.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.gAi.setLineGone();
            this.gAi.setTextSize(R.dimen.tbfontsize33);
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gAi.setOnClickListener(this.kSo);
            this.gAh = (NoNetworkView) this.kSN.findViewById(R.id.no_networkview);
            this.gAh.onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.kSN.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.kSN.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.eUY.getString(R.string.agree_me));
            this.gCC = (BdSwipeRefreshLayout) this.kSN.findViewById(R.id.agree_me_pull_refresh_layout);
            this.gCC.setProgressView(this.mPullView);
            this.XW = (BdTypeRecyclerView) this.kSN.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.XW.getItemAnimator()).setSupportsChangeAnimations(false);
            this.XW.setLayoutManager(new LinearLayoutManager(this.eUY.getContext()));
            this.XW.setFadingEdgeLength(0);
            this.XW.setBackgroundColor(ap.getColor(R.color.transparent));
            this.XW.setOverScrollMode(2);
            this.XW.addItemDecoration(new DeviderLineDecoration());
            this.XW.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.XW.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.gAi != null && a.this.kSO != null) {
                        a.this.gAi.showEmptyView(0);
                        a.this.gAi.setOnClickListener(null);
                        a.this.gAi.showLoading();
                        a.this.kSO.cqN();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<n> arrayList) {
        if (this.gCC != null && this.gAi != null && this.XW != null && this.kSj != null) {
            this.gCC.setRefreshing(false);
            if (z) {
                this.gAi.showEmptyView(0);
                this.gAi.endLoadData();
                this.gAi.setOnClickListener(this.kSo);
            } else {
                this.gAi.showEmptyView(0);
                this.gAi.endLoadData();
                this.gAi.setText(this.eUY.getResources().getString(R.string.list_no_more));
                this.gAi.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.eUY.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dS(null, this.eUY.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kSk) {
                    this.kSk = true;
                    this.XW.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
                }
                this.XW.setNextPage(null);
                return;
            }
            this.XW.removeHeaderView(this.mNoDataView);
            this.kSk = false;
            this.XW.setNextPage(this.gAi);
            this.kSj.setData(arrayList);
            this.kSj.notifyDataSetChanged();
        }
    }

    public void tn(boolean z) {
        if (this.gCC != null) {
            this.gCC.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAh != null) {
            this.gAh.onChangeSkinType(this.eUY, i);
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAi.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eUY, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eUY, i);
        }
        if (this.kSj != null) {
            this.kSj.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.kSN, R.color.CAM_X0205);
        ap.setBackgroundColor(this.mContainer, R.color.CAM_X0205);
        ap.setBackgroundColor(this.gCC, R.color.CAM_X0205);
        ap.setBackgroundColor(this.XW, R.color.CAM_X0204);
    }

    public void onDestroy() {
        if (this.kSj != null) {
            this.kSj.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(w wVar) {
        if (this.kSj != null) {
            this.kSj.e(wVar);
        }
    }

    public List<n> getDatas() {
        if (this.XW == null) {
            return null;
        }
        return this.XW.getData();
    }

    public View getRootView() {
        return this.kSN;
    }

    public RelativeLayout bRL() {
        return this.mContainer;
    }
}
