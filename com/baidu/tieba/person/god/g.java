package com.baidu.tieba.person.god;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g {
    private NoNetworkView NZ;
    private BdTypeListView bcd;
    private PbListView bcf;
    private int bcg;
    private final BaseActivity<?> bix;
    private int dwV = t.d.cp_bg_line_d;
    private NavigationBar mNavigationBar;
    private p mNoDataView;
    private u mPullView;
    private View mRootView;

    public BdTypeListView aCf() {
        return this.bcd;
    }

    public g(BaseActivity<?> baseActivity) {
        this.bcd = null;
        this.mPullView = null;
        this.bix = baseActivity;
        baseActivity.setContentView(t.h.activity_god_thread_list);
        this.mRootView = baseActivity.findViewById(t.g.root_layout);
        this.NZ = (NoNetworkView) this.mRootView.findViewById(t.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(t.g.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(baseActivity.getPageContext().getString(t.j.title_god_thread_list));
        this.bcd = (BdTypeListView) this.mRootView.findViewById(t.g.listview);
        this.bcd.setDividerHeight(0);
        this.mPullView = new u(baseActivity.getPageContext());
        this.mPullView.setTag(this.bix.getUniqueId());
        this.bcd.setPullRefresh(this.mPullView);
        this.bcf = new PbListView(baseActivity.getActivity());
        this.bcf.mZ();
        this.bcf.di(t.d.cp_bg_line_c);
        this.bcf.setTextColor(at.getColor(t.d.cp_cont_d));
        this.bcf.dj(TbadkCoreApplication.m411getInst().getSkinType());
        this.bcd.setNextPage(this.bcf);
        this.bcg = this.bix.getResources().getDimensionPixelOffset(t.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        at.l(this.mRootView, this.dwV);
        if (this.mPullView != null) {
            this.mPullView.dj(i);
        }
        if (this.bcf != null) {
            this.bcf.dj(i);
        }
        if (this.NZ != null) {
            this.NZ.onChangeSkinType(this.bix.getPageContext(), i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bix.getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bix.getPageContext(), i);
        }
    }

    public void a(NoNetworkView.a aVar) {
        this.NZ.a(aVar);
    }

    public void a(s.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.bcd.setOnSrollToBottomListener(eVar);
    }

    public void nk() {
        this.bcd.nk();
    }

    public void Op() {
        this.bcd.nj();
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bcd.removeHeaderView(this.mNoDataView);
        }
    }

    public void mf(String str) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bix.getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.bcg), NoDataViewFactory.d.dS(str), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(str));
        this.mNoDataView.onChangeSkinType(this.bix.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bcd.removeHeaderView(this.mNoDataView);
        this.bcd.addHeaderView(this.mNoDataView);
        aCh();
        this.dwV = t.d.cp_bg_line_d;
        at.l(this.mRootView, this.dwV);
    }

    public void PQ() {
        if (this.bcf != null && this.bcf.getView() != null) {
            this.bcf.getView().setVisibility(0);
            this.bcf.xu();
            this.dwV = t.d.cp_bg_line_c;
            at.l(this.mRootView, this.dwV);
        }
    }

    public void aCg() {
        if (this.bcf != null && this.bcf.getView() != null) {
            this.bcf.getView().setVisibility(0);
            this.bcf.setText(this.bix.getResources().getString(t.j.list_no_more_god_threads));
            this.bcf.xv();
            this.dwV = t.d.cp_bg_line_c;
            at.l(this.mRootView, this.dwV);
        }
    }

    public void aCh() {
        if (this.bcf != null && this.bcf.getView() != null) {
            this.bcf.getView().setVisibility(8);
        }
    }
}
