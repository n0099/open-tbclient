package com.baidu.tieba.imMessageCenter.mention.agree;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private TbPageContext aRI;
    private NoNetworkView cba;
    private PbListView cbb;
    private BdTypeRecyclerView cdR;
    protected BdSwipeRefreshLayout cdS;
    private View eTQ;
    private InterfaceC0186a eTR;
    private e eTn;
    private boolean eTq;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private k mPullView;
    private View.OnClickListener eTw = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.cbb != null && a.this.eTR != null) {
                a.this.cbb.gy(0);
                a.this.cbb.setOnClickListener(null);
                a.this.cbb.Eg();
                a.this.eTR.aNL();
            }
        }
    };
    private final j.b cdY = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bw(boolean z) {
            if (com.baidu.adp.lib.util.j.oJ()) {
                if (a.this.eTR != null) {
                    a.this.eTR.aNK();
                }
            } else if (a.this.cdS != null) {
                a.this.cdS.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0186a {
        void aNK();

        void aNL();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.aRI = tbPageContext;
        this.eTQ = view.findViewById(d.g.agree_me_layout);
        n(tbPageContext);
        this.eTn = new e(tbPageContext, this.cdR);
    }

    public void a(InterfaceC0186a interfaceC0186a) {
        this.eTR = interfaceC0186a;
    }

    private void n(TbPageContext tbPageContext) {
        if (this.eTQ != null) {
            if (this.mPullView == null) {
                this.mPullView = new k(tbPageContext);
                this.mPullView.a(this.cdY);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.cbb == null) {
                this.cbb = new PbListView(tbPageContext.getPageActivity());
                this.cbb.getView();
            }
            this.cbb.gw(d.C0141d.cp_bg_line_e);
            this.cbb.setHeight(l.t(tbPageContext.getContext(), d.e.tbds182));
            this.cbb.Ed();
            this.cbb.setTextSize(d.e.tbfontsize33);
            this.cbb.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            this.cbb.gv(d.C0141d.cp_cont_e);
            this.cbb.setOnClickListener(this.eTw);
            this.cba = (NoNetworkView) this.eTQ.findViewById(d.g.no_networkview);
            this.cba.onChangeSkinType(this.aRI, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.eTQ.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.aRI.getString(d.j.agree_me));
            this.cdS = (BdSwipeRefreshLayout) this.eTQ.findViewById(d.g.agree_me_pull_refresh_layout);
            this.cdS.setProgressView(this.mPullView);
            this.cdR = (BdTypeRecyclerView) this.eTQ.findViewById(d.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.cdR.getItemAnimator()).setSupportsChangeAnimations(false);
            this.cdR.setLayoutManager(new LinearLayoutManager(this.aRI.getContext()));
            this.cdR.setFadingEdgeLength(0);
            this.cdR.setOverScrollMode(2);
            this.cdR.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
            this.cdR.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.cdR.setNextPage(this.cbb);
            this.cdR.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.cbb != null && a.this.eTR != null) {
                        a.this.cbb.gy(0);
                        a.this.cbb.setOnClickListener(null);
                        a.this.cbb.showLoading();
                        a.this.eTR.aNL();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<i> arrayList) {
        if (this.cdS != null && this.cbb != null && this.cdR != null && this.eTn != null) {
            this.cdS.setRefreshing(false);
            if (z) {
                this.cbb.gy(0);
                this.cbb.Eh();
                this.cbb.setOnClickListener(this.eTw);
            } else {
                this.cbb.gy(0);
                this.cbb.Eh();
                this.cbb.setText(this.aRI.getResources().getString(d.j.list_no_more));
                this.cbb.setOnClickListener(null);
            }
            if (v.E(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.aRI.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.aRI.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    aj.t(this.mNoDataView, d.C0141d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eTq) {
                    this.eTq = true;
                    this.cdR.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.aRI, TbadkCoreApplication.getInst().getSkinType());
                }
                this.cdR.setNextPage(null);
                return;
            }
            this.cdR.removeHeaderView(this.mNoDataView);
            this.eTq = false;
            this.cdR.setNextPage(this.cbb);
            this.eTn.setData(arrayList);
            this.eTn.notifyDataSetChanged();
        }
    }

    public void ip(boolean z) {
        if (this.cdS != null) {
            this.cdS.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.cba != null) {
            this.cba.onChangeSkinType(this.aRI, i);
        }
        if (this.cbb != null) {
            this.cbb.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            this.cbb.gx(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aRI, i);
            aj.t(this.mNoDataView, d.C0141d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.aRI, i);
        }
        if (this.eTn != null) {
            this.eTn.notifyDataSetChanged();
        }
        aj.t(this.cdR, d.C0141d.cp_bg_line_e);
        aj.t(this.cdS, d.C0141d.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.eTn != null) {
            this.eTn.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(o oVar) {
        if (this.eTn != null) {
            this.eTn.d(oVar);
        }
    }

    public List<i> getDatas() {
        if (this.cdR == null) {
            return null;
        }
        return this.cdR.getData();
    }

    public View getRootView() {
        return this.eTQ;
    }
}
