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
    private TbPageContext aRG;
    private NoNetworkView caX;
    private PbListView caY;
    private BdTypeRecyclerView cdO;
    protected BdSwipeRefreshLayout cdP;
    private e eSY;
    private View eTB;
    private InterfaceC0186a eTC;
    private boolean eTb;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private k mPullView;
    private View.OnClickListener eTh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.caY != null && a.this.eTC != null) {
                a.this.caY.gy(0);
                a.this.caY.setOnClickListener(null);
                a.this.caY.Ef();
                a.this.eTC.aNK();
            }
        }
    };
    private final j.b cdV = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bw(boolean z) {
            if (com.baidu.adp.lib.util.j.oJ()) {
                if (a.this.eTC != null) {
                    a.this.eTC.aNJ();
                }
            } else if (a.this.cdP != null) {
                a.this.cdP.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0186a {
        void aNJ();

        void aNK();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.aRG = tbPageContext;
        this.eTB = view.findViewById(d.g.agree_me_layout);
        n(tbPageContext);
        this.eSY = new e(tbPageContext, this.cdO);
    }

    public void a(InterfaceC0186a interfaceC0186a) {
        this.eTC = interfaceC0186a;
    }

    private void n(TbPageContext tbPageContext) {
        if (this.eTB != null) {
            if (this.mPullView == null) {
                this.mPullView = new k(tbPageContext);
                this.mPullView.a(this.cdV);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.caY == null) {
                this.caY = new PbListView(tbPageContext.getPageActivity());
                this.caY.getView();
            }
            this.caY.gw(d.C0141d.cp_bg_line_e);
            this.caY.setHeight(l.t(tbPageContext.getContext(), d.e.tbds182));
            this.caY.Ec();
            this.caY.setTextSize(d.e.tbfontsize33);
            this.caY.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            this.caY.gv(d.C0141d.cp_cont_e);
            this.caY.setOnClickListener(this.eTh);
            this.caX = (NoNetworkView) this.eTB.findViewById(d.g.no_networkview);
            this.caX.onChangeSkinType(this.aRG, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar = (NavigationBar) this.eTB.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.aRG.getString(d.j.agree_me));
            this.cdP = (BdSwipeRefreshLayout) this.eTB.findViewById(d.g.agree_me_pull_refresh_layout);
            this.cdP.setProgressView(this.mPullView);
            this.cdO = (BdTypeRecyclerView) this.eTB.findViewById(d.g.agree_me_recycler_view);
            ((DefaultItemAnimator) this.cdO.getItemAnimator()).setSupportsChangeAnimations(false);
            this.cdO.setLayoutManager(new LinearLayoutManager(this.aRG.getContext()));
            this.cdO.setFadingEdgeLength(0);
            this.cdO.setOverScrollMode(2);
            this.cdO.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
            this.cdO.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.cdO.setNextPage(this.caY);
            this.cdO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.caY != null && a.this.eTC != null) {
                        a.this.caY.gy(0);
                        a.this.caY.setOnClickListener(null);
                        a.this.caY.showLoading();
                        a.this.eTC.aNK();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<i> arrayList) {
        if (this.cdP != null && this.caY != null && this.cdO != null && this.eSY != null) {
            this.cdP.setRefreshing(false);
            if (z) {
                this.caY.gy(0);
                this.caY.Eg();
                this.caY.setOnClickListener(this.eTh);
            } else {
                this.caY.gy(0);
                this.caY.Eg();
                this.caY.setText(this.aRG.getResources().getString(d.j.list_no_more));
                this.caY.setOnClickListener(null);
            }
            if (v.E(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.aRG.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.aRG.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.agree_me_nodata), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    aj.t(this.mNoDataView, d.C0141d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eTb) {
                    this.eTb = true;
                    this.cdO.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.aRG, TbadkCoreApplication.getInst().getSkinType());
                }
                this.cdO.setNextPage(null);
                return;
            }
            this.cdO.removeHeaderView(this.mNoDataView);
            this.eTb = false;
            this.cdO.setNextPage(this.caY);
            this.eSY.setData(arrayList);
            this.eSY.notifyDataSetChanged();
        }
    }

    public void ik(boolean z) {
        if (this.cdP != null) {
            this.cdP.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.caX != null) {
            this.caX.onChangeSkinType(this.aRG, i);
        }
        if (this.caY != null) {
            this.caY.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            this.caY.gx(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aRG, i);
            aj.t(this.mNoDataView, d.C0141d.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.aRG, i);
        }
        if (this.eSY != null) {
            this.eSY.notifyDataSetChanged();
        }
        aj.t(this.cdO, d.C0141d.cp_bg_line_e);
        aj.t(this.cdP, d.C0141d.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.eSY != null) {
            this.eSY.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void d(o oVar) {
        if (this.eSY != null) {
            this.eSY.d(oVar);
        }
    }

    public List<i> getDatas() {
        if (this.cdO == null) {
            return null;
        }
        return this.cdO.getData();
    }

    public View getRootView() {
        return this.eTB;
    }
}
