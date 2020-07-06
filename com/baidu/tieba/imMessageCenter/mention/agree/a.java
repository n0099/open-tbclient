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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private BdTypeRecyclerView Wa;
    private TbPageContext dPv;
    private NoNetworkView fns;
    private PbListView fnt;
    protected BdSwipeRefreshLayout fpF;
    private e jhG;
    private boolean jhK;
    private View jit;
    private InterfaceC0664a jiu;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener jhS = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fnt != null && a.this.jiu != null) {
                a.this.fnt.showEmptyView(0);
                a.this.fnt.setOnClickListener(null);
                a.this.fnt.startLoadData();
                a.this.jiu.bMX();
            }
        }
    };
    private final f.c fum = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.jiu != null) {
                    a.this.jiu.caY();
                }
            } else if (a.this.fpF != null) {
                a.this.fpF.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0664a {
        void bMX();

        void caY();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.dPv = tbPageContext;
        this.jit = view.findViewById(R.id.agree_me_layout);
        x(tbPageContext);
        this.jhG = new e(tbPageContext, this.Wa);
    }

    public void a(InterfaceC0664a interfaceC0664a) {
        this.jiu = interfaceC0664a;
    }

    private void x(TbPageContext tbPageContext) {
        if (this.jit != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.fum);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.fnt == null) {
                this.fnt = new PbListView(tbPageContext.getPageActivity());
                this.fnt.getView();
            }
            this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fnt.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.fnt.setLineGone();
            this.fnt.setTextSize(R.dimen.tbfontsize33);
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
            this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fnt.setOnClickListener(this.jhS);
            this.fns = (NoNetworkView) this.jit.findViewById(R.id.no_networkview);
            this.fns.onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.jit.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.jit.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.dPv.getString(R.string.agree_me));
            this.fpF = (BdSwipeRefreshLayout) this.jit.findViewById(R.id.agree_me_pull_refresh_layout);
            this.fpF.setProgressView(this.mPullView);
            this.Wa = (BdTypeRecyclerView) this.jit.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Wa.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Wa.setLayoutManager(new LinearLayoutManager(this.dPv.getContext()));
            this.Wa.setFadingEdgeLength(0);
            this.Wa.setBackgroundColor(an.getColor(R.color.transparent));
            this.Wa.setOverScrollMode(2);
            this.Wa.addItemDecoration(new d());
            this.Wa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Wa.setNextPage(this.fnt);
            this.Wa.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.fnt != null && a.this.jiu != null) {
                        a.this.fnt.showEmptyView(0);
                        a.this.fnt.setOnClickListener(null);
                        a.this.fnt.showLoading();
                        a.this.jiu.bMX();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<q> arrayList) {
        if (this.fpF != null && this.fnt != null && this.Wa != null && this.jhG != null) {
            this.fpF.setRefreshing(false);
            if (z) {
                this.fnt.showEmptyView(0);
                this.fnt.endLoadData();
                this.fnt.setOnClickListener(this.jhS);
            } else {
                this.fnt.showEmptyView(0);
                this.fnt.endLoadData();
                this.fnt.setText(this.dPv.getResources().getString(R.string.list_no_more));
                this.fnt.setOnClickListener(null);
            }
            if (w.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.dPv.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dm(null, this.dPv.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    an.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.jhK) {
                    this.jhK = true;
                    this.Wa.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Wa.setNextPage(null);
                return;
            }
            this.Wa.removeHeaderView(this.mNoDataView);
            this.jhK = false;
            this.Wa.setNextPage(this.fnt);
            this.jhG.setData(arrayList);
            this.jhG.notifyDataSetChanged();
        }
    }

    public void pY(boolean z) {
        if (this.fpF != null) {
            this.fpF.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fns != null) {
            this.fns.onChangeSkinType(this.dPv, i);
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
            this.fnt.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dPv, i);
            an.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dPv, i);
        }
        if (this.jhG != null) {
            this.jhG.notifyDataSetChanged();
        }
        an.setBackgroundColor(this.jit, R.color.cp_bg_line_e);
        an.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        an.setBackgroundColor(this.fpF, R.color.cp_bg_line_e);
        an.setBackgroundColor(this.Wa, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.jhG != null) {
            this.jhG.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(z zVar) {
        if (this.jhG != null) {
            this.jhG.e(zVar);
        }
    }

    public List<q> getDatas() {
        if (this.Wa == null) {
            return null;
        }
        return this.Wa.getData();
    }

    public View getRootView() {
        return this.jit;
    }

    public RelativeLayout buf() {
        return this.mContainer;
    }
}
