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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Vw;
    private TbPageContext dIF;
    private NoNetworkView fci;
    private PbListView fcj;
    protected BdSwipeRefreshLayout feu;
    private boolean iQB;
    private e iQx;
    private View iRh;
    private InterfaceC0651a iRi;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener iQJ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fcj != null && a.this.iRi != null) {
                a.this.fcj.showEmptyView(0);
                a.this.fcj.setOnClickListener(null);
                a.this.fcj.startLoadData();
                a.this.iRi.bJR();
            }
        }
    };
    private final f.c fiZ = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.iRi != null) {
                    a.this.iRi.bXK();
                }
            } else if (a.this.feu != null) {
                a.this.feu.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0651a {
        void bJR();

        void bXK();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.dIF = tbPageContext;
        this.iRh = view.findViewById(R.id.agree_me_layout);
        u(tbPageContext);
        this.iQx = new e(tbPageContext, this.Vw);
    }

    public void a(InterfaceC0651a interfaceC0651a) {
        this.iRi = interfaceC0651a;
    }

    private void u(TbPageContext tbPageContext) {
        if (this.iRh != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.fiZ);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.fcj == null) {
                this.fcj = new PbListView(tbPageContext.getPageActivity());
                this.fcj.getView();
            }
            this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fcj.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.fcj.setLineGone();
            this.fcj.setTextSize(R.dimen.tbfontsize33);
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_d));
            this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fcj.setOnClickListener(this.iQJ);
            this.fci = (NoNetworkView) this.iRh.findViewById(R.id.no_networkview);
            this.fci.onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.iRh.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.iRh.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.dIF.getString(R.string.agree_me));
            this.feu = (BdSwipeRefreshLayout) this.iRh.findViewById(R.id.agree_me_pull_refresh_layout);
            this.feu.setProgressView(this.mPullView);
            this.Vw = (BdTypeRecyclerView) this.iRh.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Vw.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Vw.setLayoutManager(new LinearLayoutManager(this.dIF.getContext()));
            this.Vw.setFadingEdgeLength(0);
            this.Vw.setBackgroundColor(am.getColor(R.color.transparent));
            this.Vw.setOverScrollMode(2);
            this.Vw.addItemDecoration(new d());
            this.Vw.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Vw.setNextPage(this.fcj);
            this.Vw.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.fcj != null && a.this.iRi != null) {
                        a.this.fcj.showEmptyView(0);
                        a.this.fcj.setOnClickListener(null);
                        a.this.fcj.showLoading();
                        a.this.iRi.bJR();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<o> arrayList) {
        if (this.feu != null && this.fcj != null && this.Vw != null && this.iQx != null) {
            this.feu.setRefreshing(false);
            if (z) {
                this.fcj.showEmptyView(0);
                this.fcj.endLoadData();
                this.fcj.setOnClickListener(this.iQJ);
            } else {
                this.fcj.showEmptyView(0);
                this.fcj.endLoadData();
                this.fcj.setText(this.dIF.getResources().getString(R.string.list_no_more));
                this.fcj.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.dIF.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dj(null, this.dIF.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.iQB) {
                    this.iQB = true;
                    this.Vw.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Vw.setNextPage(null);
                return;
            }
            this.Vw.removeHeaderView(this.mNoDataView);
            this.iQB = false;
            this.Vw.setNextPage(this.fcj);
            this.iQx.setData(arrayList);
            this.iQx.notifyDataSetChanged();
        }
    }

    public void pO(boolean z) {
        if (this.feu != null) {
            this.feu.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fci != null) {
            this.fci.onChangeSkinType(this.dIF, i);
        }
        if (this.fcj != null) {
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_d));
            this.fcj.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dIF, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dIF, i);
        }
        if (this.iQx != null) {
            this.iQx.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.iRh, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.feu, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.Vw, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.iQx != null) {
            this.iQx.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(x xVar) {
        if (this.iQx != null) {
            this.iQx.e(xVar);
        }
    }

    public List<o> getDatas() {
        if (this.Vw == null) {
            return null;
        }
        return this.Vw.getData();
    }

    public View getRootView() {
        return this.iRh;
    }

    public RelativeLayout bri() {
        return this.mContainer;
    }
}
