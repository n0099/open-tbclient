package com.baidu.tieba.imMessageCenter.mention.agree;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.base.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView Oo;
    private NoNetworkView dpy;
    private PbListView dpz;
    protected BdSwipeRefreshLayout dra;
    private e gYF;
    private boolean gYI;
    private View gZl;
    private InterfaceC0360a gZm;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View.OnClickListener gYQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dpz != null && a.this.gZm != null) {
                a.this.dpz.iZ(0);
                a.this.dpz.setOnClickListener(null);
                a.this.dpz.akR();
                a.this.gZm.aYU();
            }
        }
    };
    private final h.c dvZ = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void eu(boolean z) {
            if (j.kc()) {
                if (a.this.gZm != null) {
                    a.this.gZm.bpv();
                }
            } else if (a.this.dra != null) {
                a.this.dra.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0360a {
        void aYU();

        void bpv();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.gZl = view.findViewById(R.id.agree_me_layout);
        q(tbPageContext);
        this.gYF = new e(tbPageContext, this.Oo);
    }

    public void a(InterfaceC0360a interfaceC0360a) {
        this.gZm = interfaceC0360a;
    }

    private void q(TbPageContext tbPageContext) {
        if (this.gZl != null) {
            if (this.mPullView == null) {
                this.mPullView = new i(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.dvZ);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.dpz == null) {
                this.dpz = new PbListView(tbPageContext.getPageActivity());
                this.dpz.getView();
            }
            this.dpz.iX(R.color.cp_bg_line_e);
            this.dpz.setHeight(l.g(tbPageContext.getContext(), R.dimen.tbds182));
            this.dpz.akO();
            this.dpz.setTextSize(R.dimen.tbfontsize33);
            this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dpz.iW(R.color.cp_cont_e);
            this.dpz.setOnClickListener(this.gYQ);
            this.dpy = (NoNetworkView) this.gZl.findViewById(R.id.no_networkview);
            this.dpy.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.gZl.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(R.string.agree_me));
            this.dra = (BdSwipeRefreshLayout) this.gZl.findViewById(R.id.agree_me_pull_refresh_layout);
            this.dra.setProgressView(this.mPullView);
            this.Oo = (BdTypeRecyclerView) this.gZl.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Oo.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Oo.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.Oo.setFadingEdgeLength(0);
            this.Oo.setBackgroundColor(am.getColor(R.color.transparent));
            this.Oo.setOverScrollMode(2);
            this.Oo.addItemDecoration(new d());
            this.Oo.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Oo.setNextPage(this.dpz);
            this.Oo.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.dpz != null && a.this.gZm != null) {
                        a.this.dpz.iZ(0);
                        a.this.dpz.setOnClickListener(null);
                        a.this.dpz.showLoading();
                        a.this.gZm.aYU();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.dra != null && this.dpz != null && this.Oo != null && this.gYF != null) {
            this.dra.setRefreshing(false);
            if (z) {
                this.dpz.iZ(0);
                this.dpz.akS();
                this.dpz.setOnClickListener(this.gYQ);
            } else {
                this.dpz.iZ(0);
                this.dpz.akS();
                this.dpz.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.dpz.setOnClickListener(null);
            }
            if (v.aa(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iQ(R.string.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.l(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gYI) {
                    this.gYI = true;
                    this.Oo.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Oo.setNextPage(null);
                return;
            }
            this.Oo.removeHeaderView(this.mNoDataView);
            this.gYI = false;
            this.Oo.setNextPage(this.dpz);
            this.gYF.setData(arrayList);
            this.gYF.notifyDataSetChanged();
        }
    }

    public void mT(boolean z) {
        if (this.dra != null) {
            this.dra.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
        if (this.dpy != null) {
            this.dpy.onChangeSkinType(this.mContext, i);
        }
        if (this.dpz != null) {
            this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dpz.iY(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.l(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.gYF != null) {
            this.gYF.notifyDataSetChanged();
        }
        am.l(this.gZl, R.color.cp_bg_line_e);
        am.l(this.dra, R.color.cp_bg_line_e);
        am.l(this.Oo, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.gYF != null) {
            this.gYF.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(s sVar) {
        if (this.gYF != null) {
            this.gYF.d(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.Oo == null) {
            return null;
        }
        return this.Oo.getData();
    }

    public View getRootView() {
        return this.gZl;
    }
}
