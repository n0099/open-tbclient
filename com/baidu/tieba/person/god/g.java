package com.baidu.tieba.person.god;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g {
    private NoNetworkView NR;
    private BdTypeListView aXu;
    private PbListView aXw;
    private int aXx;
    private final BaseActivity<?> bdK;
    private int dcs = t.d.cp_bg_line_d;
    private NavigationBar mNavigationBar;
    private o mNoDataView;
    private com.baidu.tbadk.core.view.t mPullView;
    private View mRootView;

    public BdTypeListView auz() {
        return this.aXu;
    }

    public g(BaseActivity<?> baseActivity) {
        this.aXu = null;
        this.mPullView = null;
        this.bdK = baseActivity;
        baseActivity.setContentView(t.h.activity_god_thread_list);
        this.mRootView = baseActivity.findViewById(t.g.root_layout);
        this.NR = (NoNetworkView) this.mRootView.findViewById(t.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(t.g.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(baseActivity.getPageContext().getString(t.j.title_god_thread_list));
        this.aXu = (BdTypeListView) this.mRootView.findViewById(t.g.listview);
        this.aXu.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.t(baseActivity.getPageContext());
        this.mPullView.setTag(this.bdK.getUniqueId());
        this.aXu.setPullRefresh(this.mPullView);
        this.aXw = new PbListView(baseActivity.getActivity());
        this.aXw.ni();
        this.aXw.df(t.d.cp_bg_line_c);
        this.aXw.setTextColor(ar.getColor(t.d.cp_cont_d));
        this.aXw.dg(TbadkCoreApplication.m411getInst().getSkinType());
        this.aXu.setNextPage(this.aXw);
        this.aXx = this.bdK.getResources().getDimensionPixelOffset(t.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        ar.l(this.mRootView, this.dcs);
        if (this.mPullView != null) {
            this.mPullView.dg(i);
        }
        if (this.aXw != null) {
            this.aXw.dg(i);
        }
        if (this.NR != null) {
            this.NR.onChangeSkinType(this.bdK.getPageContext(), i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bdK.getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bdK.getPageContext(), i);
        }
    }

    public void a(NoNetworkView.a aVar) {
        this.NR.a(aVar);
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.aXu.setOnSrollToBottomListener(eVar);
    }

    public void ns() {
        this.aXu.ns();
    }

    public void MB() {
        this.aXu.nr();
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aXu.removeHeaderView(this.mNoDataView);
        }
    }

    public void hw(String str) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bdK.getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.aXx), NoDataViewFactory.d.dM(str), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dM(str));
        this.mNoDataView.onChangeSkinType(this.bdK.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.aXu.removeHeaderView(this.mNoDataView);
        this.aXu.addHeaderView(this.mNoDataView);
        auB();
        this.dcs = t.d.cp_bg_line_d;
        ar.l(this.mRootView, this.dcs);
    }

    public void Ob() {
        if (this.aXw != null && this.aXw.getView() != null) {
            this.aXw.getView().setVisibility(0);
            this.aXw.xb();
            this.dcs = t.d.cp_bg_line_c;
            ar.l(this.mRootView, this.dcs);
        }
    }

    public void auA() {
        if (this.aXw != null && this.aXw.getView() != null) {
            this.aXw.getView().setVisibility(0);
            this.aXw.setText(this.bdK.getResources().getString(t.j.list_no_more_god_threads));
            this.aXw.xc();
            this.dcs = t.d.cp_bg_line_c;
            ar.l(this.mRootView, this.dcs);
        }
    }

    public void auB() {
        if (this.aXw != null && this.aXw.getView() != null) {
            this.aXw.getView().setVisibility(8);
        }
    }
}
