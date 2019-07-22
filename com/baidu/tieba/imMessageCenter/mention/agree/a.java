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
    private BdTypeRecyclerView Op;
    private NoNetworkView dnF;
    private PbListView dnG;
    protected BdSwipeRefreshLayout dpi;
    private e gVT;
    private boolean gVW;
    private InterfaceC0343a gWA;
    private View gWz;
    private TbPageContext mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View.OnClickListener gWe = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dnG != null && a.this.gWA != null) {
                a.this.dnG.iW(0);
                a.this.dnG.setOnClickListener(null);
                a.this.dnG.akD();
                a.this.gWA.aYo();
            }
        }
    };
    private final h.c duh = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            if (j.kc()) {
                if (a.this.gWA != null) {
                    a.this.gWA.box();
                }
            } else if (a.this.dpi != null) {
                a.this.dpi.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0343a {
        void aYo();

        void box();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.gWz = view.findViewById(R.id.agree_me_layout);
        q(tbPageContext);
        this.gVT = new e(tbPageContext, this.Op);
    }

    public void a(InterfaceC0343a interfaceC0343a) {
        this.gWA = interfaceC0343a;
    }

    private void q(TbPageContext tbPageContext) {
        if (this.gWz != null) {
            if (this.mPullView == null) {
                this.mPullView = new i(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.duh);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.dnG == null) {
                this.dnG = new PbListView(tbPageContext.getPageActivity());
                this.dnG.getView();
            }
            this.dnG.iU(R.color.cp_bg_line_e);
            this.dnG.setHeight(l.g(tbPageContext.getContext(), R.dimen.tbds182));
            this.dnG.akA();
            this.dnG.setTextSize(R.dimen.tbfontsize33);
            this.dnG.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dnG.iT(R.color.cp_cont_e);
            this.dnG.setOnClickListener(this.gWe);
            this.dnF = (NoNetworkView) this.gWz.findViewById(R.id.no_networkview);
            this.dnF.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.gWz.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mContext.getString(R.string.agree_me));
            this.dpi = (BdSwipeRefreshLayout) this.gWz.findViewById(R.id.agree_me_pull_refresh_layout);
            this.dpi.setProgressView(this.mPullView);
            this.Op = (BdTypeRecyclerView) this.gWz.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.Op.getItemAnimator()).setSupportsChangeAnimations(false);
            this.Op.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.Op.setFadingEdgeLength(0);
            this.Op.setBackgroundColor(am.getColor(R.color.transparent));
            this.Op.setOverScrollMode(2);
            this.Op.addItemDecoration(new d());
            this.Op.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.Op.setNextPage(this.dnG);
            this.Op.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.dnG != null && a.this.gWA != null) {
                        a.this.dnG.iW(0);
                        a.this.dnG.setOnClickListener(null);
                        a.this.dnG.showLoading();
                        a.this.gWA.aYo();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<m> arrayList) {
        if (this.dpi != null && this.dnG != null && this.Op != null && this.gVT != null) {
            this.dpi.setRefreshing(false);
            if (z) {
                this.dnG.iW(0);
                this.dnG.akE();
                this.dnG.setOnClickListener(this.gWe);
            } else {
                this.dnG.iW(0);
                this.dnG.akE();
                this.dnG.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.dnG.setOnClickListener(null);
            }
            if (v.aa(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iN(R.string.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    am.l(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gVW) {
                    this.gVW = true;
                    this.Op.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Op.setNextPage(null);
                return;
            }
            this.Op.removeHeaderView(this.mNoDataView);
            this.gVW = false;
            this.Op.setNextPage(this.dnG);
            this.gVT.setData(arrayList);
            this.gVT.notifyDataSetChanged();
        }
    }

    public void mQ(boolean z) {
        if (this.dpi != null) {
            this.dpi.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.dnF != null) {
            this.dnF.onChangeSkinType(this.mContext, i);
        }
        if (this.dnG != null) {
            this.dnG.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dnG.iV(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.l(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mContext, i);
        }
        if (this.gVT != null) {
            this.gVT.notifyDataSetChanged();
        }
        am.l(this.gWz, R.color.cp_bg_line_e);
        am.l(this.dpi, R.color.cp_bg_line_e);
    }

    public void onDestroy() {
        if (this.gVT != null) {
            this.gVT.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(s sVar) {
        if (this.gVT != null) {
            this.gVT.d(sVar);
        }
    }

    public List<m> getDatas() {
        if (this.Op == null) {
            return null;
        }
        return this.Op.getData();
    }

    public View getRootView() {
        return this.gWz;
    }
}
