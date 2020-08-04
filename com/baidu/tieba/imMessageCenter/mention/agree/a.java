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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
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
import com.baidu.tieba.imMessageCenter.mention.base.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private BdTypeRecyclerView VT;
    private TbPageContext dVN;
    private NoNetworkView fsB;
    private PbListView fsC;
    protected BdSwipeRefreshLayout fuP;
    private e jqx;
    private boolean jqy;
    private View jrb;
    private InterfaceC0676a jrc;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener jqC = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fsC != null && a.this.jrc != null) {
                a.this.fsC.showEmptyView(0);
                a.this.fsC.setOnClickListener(null);
                a.this.fsC.startLoadData();
                a.this.jrc.bQi();
            }
        }
    };
    private final f.c fzt = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.jrc != null) {
                    a.this.jrc.cew();
                }
            } else if (a.this.fuP != null) {
                a.this.fuP.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0676a {
        void bQi();

        void cew();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.dVN = tbPageContext;
        this.jrb = view.findViewById(R.id.agree_me_layout);
        w(tbPageContext);
        this.jqx = new e(tbPageContext, this.VT);
    }

    public void a(InterfaceC0676a interfaceC0676a) {
        this.jrc = interfaceC0676a;
    }

    private void w(TbPageContext tbPageContext) {
        if (this.jrb != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.fzt);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.fsC == null) {
                this.fsC = new PbListView(tbPageContext.getPageActivity());
                this.fsC.getView();
            }
            this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fsC.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.fsC.setLineGone();
            this.fsC.setTextSize(R.dimen.tbfontsize33);
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
            this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fsC.setOnClickListener(this.jqC);
            this.fsB = (NoNetworkView) this.jrb.findViewById(R.id.no_networkview);
            this.fsB.onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.jrb.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.jrb.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.dVN.getString(R.string.agree_me));
            this.fuP = (BdSwipeRefreshLayout) this.jrb.findViewById(R.id.agree_me_pull_refresh_layout);
            this.fuP.setProgressView(this.mPullView);
            this.VT = (BdTypeRecyclerView) this.jrb.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.VT.getItemAnimator()).setSupportsChangeAnimations(false);
            this.VT.setLayoutManager(new LinearLayoutManager(this.dVN.getContext()));
            this.VT.setFadingEdgeLength(0);
            this.VT.setBackgroundColor(ao.getColor(R.color.transparent));
            this.VT.setOverScrollMode(2);
            this.VT.addItemDecoration(new d());
            this.VT.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.VT.setNextPage(this.fsC);
            this.VT.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.fsC != null && a.this.jrc != null) {
                        a.this.fsC.showEmptyView(0);
                        a.this.fsC.setOnClickListener(null);
                        a.this.fsC.showLoading();
                        a.this.jrc.bQi();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<q> arrayList) {
        if (this.fuP != null && this.fsC != null && this.VT != null && this.jqx != null) {
            this.fuP.setRefreshing(false);
            if (z) {
                this.fsC.showEmptyView(0);
                this.fsC.endLoadData();
                this.fsC.setOnClickListener(this.jqC);
            } else {
                this.fsC.showEmptyView(0);
                this.fsC.endLoadData();
                this.fsC.setText(this.dVN.getResources().getString(R.string.list_no_more));
                this.fsC.setOnClickListener(null);
            }
            if (x.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.dVN.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.m31do(null, this.dVN.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ao.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.jqy) {
                    this.jqy = true;
                    this.VT.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
                }
                this.VT.setNextPage(null);
                return;
            }
            this.VT.removeHeaderView(this.mNoDataView);
            this.jqy = false;
            this.VT.setNextPage(this.fsC);
            this.jqx.setData(arrayList);
            this.jqx.notifyDataSetChanged();
        }
    }

    public void qB(boolean z) {
        if (this.fuP != null) {
            this.fuP.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fsB != null) {
            this.fsB.onChangeSkinType(this.dVN, i);
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
            this.fsC.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dVN, i);
            ao.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dVN, i);
        }
        if (this.jqx != null) {
            this.jqx.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.jrb, R.color.cp_bg_line_e);
        ao.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        ao.setBackgroundColor(this.fuP, R.color.cp_bg_line_e);
        ao.setBackgroundColor(this.VT, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.jqx != null) {
            this.jqx.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(z zVar) {
        if (this.jqx != null) {
            this.jqx.e(zVar);
        }
    }

    public List<q> getDatas() {
        if (this.VT == null) {
            return null;
        }
        return this.VT.getData();
    }

    public View getRootView() {
        return this.jrb;
    }

    public RelativeLayout bxo() {
        return this.mContainer;
    }
}
