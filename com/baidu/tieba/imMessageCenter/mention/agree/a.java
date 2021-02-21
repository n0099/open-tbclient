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
    private NoNetworkView gAv;
    private PbListView gAw;
    protected BdSwipeRefreshLayout gCQ;
    private d kSx;
    private boolean kSy;
    private View kTb;
    private InterfaceC0770a kTc;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener kSC = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gAw != null && a.this.kTc != null) {
                a.this.gAw.showEmptyView(0);
                a.this.gAw.setOnClickListener(null);
                a.this.gAw.startLoadData();
                a.this.kTc.cqU();
            }
        }
    };
    private final f.c gHz = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.kTc != null) {
                    a.this.kTc.cFL();
                }
            } else if (a.this.gCQ != null) {
                a.this.gCQ.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0770a {
        void cFL();

        void cqU();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.eUY = tbPageContext;
        this.kTb = view.findViewById(R.id.agree_me_layout);
        x(tbPageContext);
        this.kSx = new d(tbPageContext, this.XW);
    }

    public void a(InterfaceC0770a interfaceC0770a) {
        this.kTc = interfaceC0770a;
    }

    private void x(TbPageContext tbPageContext) {
        if (this.kTb != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.gHz);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.gAw == null) {
                this.gAw = new PbListView(tbPageContext.getPageActivity());
                this.gAw.getView();
            }
            this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gAw.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.gAw.setLineGone();
            this.gAw.setTextSize(R.dimen.tbfontsize33);
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gAw.setOnClickListener(this.kSC);
            this.gAv = (NoNetworkView) this.kTb.findViewById(R.id.no_networkview);
            this.gAv.onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.kTb.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.kTb.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.eUY.getString(R.string.agree_me));
            this.gCQ = (BdSwipeRefreshLayout) this.kTb.findViewById(R.id.agree_me_pull_refresh_layout);
            this.gCQ.setProgressView(this.mPullView);
            this.XW = (BdTypeRecyclerView) this.kTb.findViewById(R.id.agree_me_recycler_view);
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
                    if (a.this.gAw != null && a.this.kTc != null) {
                        a.this.gAw.showEmptyView(0);
                        a.this.gAw.setOnClickListener(null);
                        a.this.gAw.showLoading();
                        a.this.kTc.cqU();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<n> arrayList) {
        if (this.gCQ != null && this.gAw != null && this.XW != null && this.kSx != null) {
            this.gCQ.setRefreshing(false);
            if (z) {
                this.gAw.showEmptyView(0);
                this.gAw.endLoadData();
                this.gAw.setOnClickListener(this.kSC);
            } else {
                this.gAw.showEmptyView(0);
                this.gAw.endLoadData();
                this.gAw.setText(this.eUY.getResources().getString(R.string.list_no_more));
                this.gAw.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.eUY.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dS(null, this.eUY.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kSy) {
                    this.kSy = true;
                    this.XW.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
                }
                this.XW.setNextPage(null);
                return;
            }
            this.XW.removeHeaderView(this.mNoDataView);
            this.kSy = false;
            this.XW.setNextPage(this.gAw);
            this.kSx.setData(arrayList);
            this.kSx.notifyDataSetChanged();
        }
    }

    public void tn(boolean z) {
        if (this.gCQ != null) {
            this.gCQ.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAv != null) {
            this.gAv.onChangeSkinType(this.eUY, i);
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAw.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eUY, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eUY, i);
        }
        if (this.kSx != null) {
            this.kSx.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.kTb, R.color.CAM_X0205);
        ap.setBackgroundColor(this.mContainer, R.color.CAM_X0205);
        ap.setBackgroundColor(this.gCQ, R.color.CAM_X0205);
        ap.setBackgroundColor(this.XW, R.color.CAM_X0204);
    }

    public void onDestroy() {
        if (this.kSx != null) {
            this.kSx.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(w wVar) {
        if (this.kSx != null) {
            this.kSx.e(wVar);
        }
    }

    public List<n> getDatas() {
        if (this.XW == null) {
            return null;
        }
        return this.XW.getData();
    }

    public View getRootView() {
        return this.kTb;
    }

    public RelativeLayout bRS() {
        return this.mContainer;
    }
}
