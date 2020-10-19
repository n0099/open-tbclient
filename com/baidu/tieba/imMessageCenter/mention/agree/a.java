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
    private BdTypeRecyclerView Xc;
    private TbPageContext etO;
    private NoNetworkView fTu;
    private PbListView fTv;
    protected BdSwipeRefreshLayout fVP;
    private View kdF;
    private InterfaceC0743a kdG;
    private e kdb;
    private boolean kdc;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener kdg = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fTv != null && a.this.kdG != null) {
                a.this.fTv.showEmptyView(0);
                a.this.fTv.setOnClickListener(null);
                a.this.fTv.startLoadData();
                a.this.kdG.chc();
            }
        }
    };
    private final f.c gav = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.kdG != null) {
                    a.this.kdG.cvL();
                }
            } else if (a.this.fVP != null) {
                a.this.fVP.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0743a {
        void chc();

        void cvL();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.etO = tbPageContext;
        this.kdF = view.findViewById(R.id.agree_me_layout);
        w(tbPageContext);
        this.kdb = new e(tbPageContext, this.Xc);
    }

    public void a(InterfaceC0743a interfaceC0743a) {
        this.kdG = interfaceC0743a;
    }

    private void w(TbPageContext tbPageContext) {
        if (this.kdF != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.gav);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.fTv == null) {
                this.fTv = new PbListView(tbPageContext.getPageActivity());
                this.fTv.getView();
            }
            this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fTv.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.fTv.setLineGone();
            this.fTv.setTextSize(R.dimen.tbfontsize33);
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fTv.setOnClickListener(this.kdg);
            this.fTu = (NoNetworkView) this.kdF.findViewById(R.id.no_networkview);
            this.fTu.onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.kdF.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.kdF.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.etO.getString(R.string.agree_me));
            this.fVP = (BdSwipeRefreshLayout) this.kdF.findViewById(R.id.agree_me_pull_refresh_layout);
            this.fVP.setProgressView(this.mPullView);
            this.Xc = (BdTypeRecyclerView) this.kdF.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Xc.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Xc.setLayoutManager(new LinearLayoutManager(this.etO.getContext()));
            this.Xc.setFadingEdgeLength(0);
            this.Xc.setBackgroundColor(ap.getColor(R.color.transparent));
            this.Xc.setOverScrollMode(2);
            this.Xc.addItemDecoration(new d());
            this.Xc.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Xc.setNextPage(this.fTv);
            this.Xc.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.fTv != null && a.this.kdG != null) {
                        a.this.fTv.showEmptyView(0);
                        a.this.fTv.setOnClickListener(null);
                        a.this.fTv.showLoading();
                        a.this.kdG.chc();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<q> arrayList) {
        if (this.fVP != null && this.fTv != null && this.Xc != null && this.kdb != null) {
            this.fVP.setRefreshing(false);
            if (z) {
                this.fTv.showEmptyView(0);
                this.fTv.endLoadData();
                this.fTv.setOnClickListener(this.kdg);
            } else {
                this.fTv.showEmptyView(0);
                this.fTv.endLoadData();
                this.fTv.setText(this.etO.getResources().getString(R.string.list_no_more));
                this.fTv.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.etO.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dL(null, this.etO.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.kdc) {
                    this.kdc = true;
                    this.Xc.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Xc.setNextPage(null);
                return;
            }
            this.Xc.removeHeaderView(this.mNoDataView);
            this.kdc = false;
            this.Xc.setNextPage(this.fTv);
            this.kdb.setData(arrayList);
            this.kdb.notifyDataSetChanged();
        }
    }

    public void rX(boolean z) {
        if (this.fVP != null) {
            this.fVP.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fTu != null) {
            this.fTu.onChangeSkinType(this.etO, i);
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fTv.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.etO, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.etO, i);
        }
        if (this.kdb != null) {
            this.kdb.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.kdF, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.fVP, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.Xc, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.kdb != null) {
            this.kdb.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(ab abVar) {
        if (this.kdb != null) {
            this.kdb.e(abVar);
        }
    }

    public List<q> getDatas() {
        if (this.Xc == null) {
            return null;
        }
        return this.Xc.getData();
    }

    public View getRootView() {
        return this.kdF;
    }

    public RelativeLayout bKq() {
        return this.mContainer;
    }
}
