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
    private TbPageContext aRR;
    private NoNetworkView cbj;
    private PbListView cbk;
    private BdTypeRecyclerView cea;
    protected BdSwipeRefreshLayout ceb;
    private View eTN;
    private InterfaceC0185a eTO;
    private e eTk;
    private boolean eTn;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private k mPullView;
    private View.OnClickListener eTt = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.cbk != null && a.this.eTO != null) {
                a.this.cbk.gy(0);
                a.this.cbk.setOnClickListener(null);
                a.this.cbk.Eg();
                a.this.eTO.aNL();
            }
        }
    };
    private final j.b ceh = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bw(boolean z) {
            if (com.baidu.adp.lib.util.j.oJ()) {
                if (a.this.eTO != null) {
                    a.this.eTO.aNK();
                }
            } else if (a.this.ceb != null) {
                a.this.ceb.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0185a {
        void aNK();

        void aNL();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.aRR = tbPageContext;
        this.eTN = view.findViewById(d.g.agree_me_layout);
        n(tbPageContext);
        this.eTk = new e(tbPageContext, this.cea);
    }

    public void a(InterfaceC0185a interfaceC0185a) {
        this.eTO = interfaceC0185a;
    }

    private void n(TbPageContext tbPageContext) {
        if (this.eTN != null) {
            if (this.mPullView == null) {
                this.mPullView = new k(tbPageContext);
                this.mPullView.a(this.ceh);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.cbk == null) {
                this.cbk = new PbListView(tbPageContext.getPageActivity());
                this.cbk.getView();
            }
            this.cbk.gw(d.C0140d.cp_bg_line_e);
            this.cbk.setHeight(l.t(tbPageContext.getContext(), d.e.tbds182));
            this.cbk.Ed();
            this.cbk.setTextSize(d.e.tbfontsize33);
            this.cbk.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
            this.cbk.gv(d.C0140d.cp_cont_e);
            this.cbk.setOnClickListener(this.eTt);
            this.cbj = (NoNetworkView) this.eTN.findViewById(d.g.no_networkview);
            this.cbj.onChangeSkinType(this.aRR, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.eTN.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.aRR.getString(d.j.agree_me));
            this.ceb = (BdSwipeRefreshLayout) this.eTN.findViewById(d.g.agree_me_pull_refresh_layout);
            this.ceb.setProgressView(this.mPullView);
            this.cea = (BdTypeRecyclerView) this.eTN.findViewById(d.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.cea.getItemAnimator()).setSupportsChangeAnimations(false);
            this.cea.setLayoutManager(new LinearLayoutManager(this.aRR.getContext()));
            this.cea.setFadingEdgeLength(0);
            this.cea.setOverScrollMode(2);
            this.cea.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
            this.cea.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.cea.setNextPage(this.cbk);
            this.cea.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.cbk != null && a.this.eTO != null) {
                        a.this.cbk.gy(0);
                        a.this.cbk.setOnClickListener(null);
                        a.this.cbk.showLoading();
                        a.this.eTO.aNL();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<i> arrayList) {
        if (this.ceb != null && this.cbk != null && this.cea != null && this.eTk != null) {
            this.ceb.setRefreshing(false);
            if (z) {
                this.cbk.gy(0);
                this.cbk.Eh();
                this.cbk.setOnClickListener(this.eTt);
            } else {
                this.cbk.gy(0);
                this.cbk.Eh();
                this.cbk.setText(this.aRR.getResources().getString(d.j.list_no_more));
                this.cbk.setOnClickListener(null);
            }
            if (v.E(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.aRR.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.aRR.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    aj.t(this.mNoDataView, d.C0140d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eTn) {
                    this.eTn = true;
                    this.cea.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.aRR, TbadkCoreApplication.getInst().getSkinType());
                }
                this.cea.setNextPage(null);
                return;
            }
            this.cea.removeHeaderView(this.mNoDataView);
            this.eTn = false;
            this.cea.setNextPage(this.cbk);
            this.eTk.setData(arrayList);
            this.eTk.notifyDataSetChanged();
        }
    }

    public void ik(boolean z) {
        if (this.ceb != null) {
            this.ceb.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.cbj != null) {
            this.cbj.onChangeSkinType(this.aRR, i);
        }
        if (this.cbk != null) {
            this.cbk.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
            this.cbk.gx(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aRR, i);
            aj.t(this.mNoDataView, d.C0140d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.aRR, i);
        }
        if (this.eTk != null) {
            this.eTk.notifyDataSetChanged();
        }
        aj.t(this.cea, d.C0140d.cp_bg_line_e);
        aj.t(this.ceb, d.C0140d.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.eTk != null) {
            this.eTk.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(o oVar) {
        if (this.eTk != null) {
            this.eTk.d(oVar);
        }
    }

    public List<i> getDatas() {
        if (this.cea == null) {
            return null;
        }
        return this.cea.getData();
    }

    public View getRootView() {
        return this.eTN;
    }
}
