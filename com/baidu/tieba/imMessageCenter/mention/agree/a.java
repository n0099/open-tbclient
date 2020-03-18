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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.base.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView BK;
    private TbPageContext cVv;
    private NoNetworkView elL;
    private PbListView elM;
    protected BdSwipeRefreshLayout enY;
    private View hRN;
    private InterfaceC0543a hRO;
    private e hRg;
    private boolean hRj;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View.OnClickListener hRq = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.elM != null && a.this.hRO != null) {
                a.this.elM.showEmptyView(0);
                a.this.elM.setOnClickListener(null);
                a.this.elM.startLoadData();
                a.this.hRO.btO();
            }
        }
    };
    private final g.c esD = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.hRO != null) {
                    a.this.hRO.bGM();
                }
            } else if (a.this.enY != null) {
                a.this.enY.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0543a {
        void bGM();

        void btO();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.cVv = tbPageContext;
        this.hRN = view.findViewById(R.id.agree_me_layout);
        c(tbPageContext);
        this.hRg = new e(tbPageContext, this.BK);
    }

    public void a(InterfaceC0543a interfaceC0543a) {
        this.hRO = interfaceC0543a;
    }

    private void c(TbPageContext tbPageContext) {
        if (this.hRN != null) {
            if (this.mPullView == null) {
                this.mPullView = new h(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.esD);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.elM == null) {
                this.elM = new PbListView(tbPageContext.getPageActivity());
                this.elM.getView();
            }
            this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.elM.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.elM.setLineGone();
            this.elM.setTextSize(R.dimen.tbfontsize33);
            this.elM.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elM.setOnClickListener(this.hRq);
            this.elL = (NoNetworkView) this.hRN.findViewById(R.id.no_networkview);
            this.elL.onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.hRN.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.hRN.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.cVv.getString(R.string.agree_me));
            this.enY = (BdSwipeRefreshLayout) this.hRN.findViewById(R.id.agree_me_pull_refresh_layout);
            this.enY.setProgressView(this.mPullView);
            this.BK = (BdTypeRecyclerView) this.hRN.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.BK.getItemAnimator()).setSupportsChangeAnimations(false);
            this.BK.setLayoutManager(new LinearLayoutManager(this.cVv.getContext()));
            this.BK.setFadingEdgeLength(0);
            this.BK.setBackgroundColor(am.getColor(R.color.transparent));
            this.BK.setOverScrollMode(2);
            this.BK.addItemDecoration(new d());
            this.BK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.BK.setNextPage(this.elM);
            this.BK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.elM != null && a.this.hRO != null) {
                        a.this.elM.showEmptyView(0);
                        a.this.elM.setOnClickListener(null);
                        a.this.elM.showLoading();
                        a.this.hRO.btO();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.enY != null && this.elM != null && this.BK != null && this.hRg != null) {
            this.enY.setRefreshing(false);
            if (z) {
                this.elM.showEmptyView(0);
                this.elM.endLoadData();
                this.elM.setOnClickListener(this.hRq);
            } else {
                this.elM.showEmptyView(0);
                this.elM.endLoadData();
                this.elM.setText(this.cVv.getResources().getString(R.string.list_no_more));
                this.elM.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.cVv.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cz(null, this.cVv.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.hRj) {
                    this.hRj = true;
                    this.BK.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
                }
                this.BK.setNextPage(null);
                return;
            }
            this.BK.removeHeaderView(this.mNoDataView);
            this.hRj = false;
            this.BK.setNextPage(this.elM);
            this.hRg.setData(arrayList);
            this.hRg.notifyDataSetChanged();
        }
    }

    public void oo(boolean z) {
        if (this.enY != null) {
            this.enY.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.elL != null) {
            this.elL.onChangeSkinType(this.cVv, i);
        }
        if (this.elM != null) {
            this.elM.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elM.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cVv, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cVv, i);
        }
        if (this.hRg != null) {
            this.hRg.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.hRN, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.enY, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.BK, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.hRg != null) {
            this.hRg.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(s sVar) {
        if (this.hRg != null) {
            this.hRg.e(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.BK == null) {
            return null;
        }
        return this.BK.getData();
    }

    public View getRootView() {
        return this.hRN;
    }

    public RelativeLayout bcT() {
        return this.mContainer;
    }
}
