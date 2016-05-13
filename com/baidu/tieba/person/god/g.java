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
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g {
    private NoNetworkView Ep;
    private BdTypeListView bej;
    private final BaseActivity<?> bek;
    private PbListView bkd;
    private int dAa;
    private int dAb = t.d.cp_bg_line_d;
    private NavigationBar mNavigationBar;
    private q mNoDataView;
    private w mPullView;
    private View mRootView;

    public BdTypeListView aCz() {
        return this.bej;
    }

    public g(BaseActivity<?> baseActivity) {
        this.bej = null;
        this.mPullView = null;
        this.bek = baseActivity;
        baseActivity.setContentView(t.h.activity_god_thread_list);
        this.mRootView = baseActivity.findViewById(t.g.root_layout);
        this.Ep = (NoNetworkView) this.mRootView.findViewById(t.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(t.g.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(baseActivity.getPageContext().getString(t.j.title_god_thread_list));
        this.bej = (BdTypeListView) this.mRootView.findViewById(t.g.listview);
        this.bej.setDividerHeight(0);
        this.mPullView = new w(baseActivity.getPageContext());
        this.mPullView.setTag(this.bek.getUniqueId());
        this.bej.setPullRefresh(this.mPullView);
        this.bkd = new PbListView(baseActivity.getActivity());
        this.bkd.jn();
        this.bkd.cQ(t.d.cp_bg_line_c);
        this.bkd.setTextColor(at.getColor(t.d.cp_cont_d));
        this.bkd.cR(TbadkCoreApplication.m11getInst().getSkinType());
        this.bej.setNextPage(this.bkd);
        this.dAa = this.bek.getResources().getDimensionPixelOffset(t.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        at.l(this.mRootView, this.dAb);
        if (this.mPullView != null) {
            this.mPullView.cR(i);
        }
        if (this.bkd != null) {
            this.bkd.cR(i);
        }
        if (this.Ep != null) {
            this.Ep.onChangeSkinType(this.bek.getPageContext(), i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bek.getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bek.getPageContext(), i);
        }
    }

    public void a(NoNetworkView.a aVar) {
        this.Ep.a(aVar);
    }

    public void a(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.bej.setOnSrollToBottomListener(eVar);
    }

    public void jy() {
        this.bej.jy();
    }

    public void Np() {
        this.bej.k(2000L);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bej.removeHeaderView(this.mNoDataView);
        }
    }

    public void mj(String str) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bek.getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.dAa), NoDataViewFactory.d.dP(str), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dP(str));
        this.mNoDataView.onChangeSkinType(this.bek.getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bej.removeHeaderView(this.mNoDataView);
        this.bej.addHeaderView(this.mNoDataView);
        aCB();
        this.dAb = t.d.cp_bg_line_d;
        at.l(this.mRootView, this.dAb);
    }

    public void OL() {
        if (this.bkd != null && this.bkd.getView() != null) {
            this.bkd.getView().setVisibility(0);
            this.bkd.vh();
            this.dAb = t.d.cp_bg_line_c;
            at.l(this.mRootView, this.dAb);
        }
    }

    public void aCA() {
        if (this.bkd != null && this.bkd.getView() != null) {
            this.bkd.getView().setVisibility(0);
            this.bkd.setText(this.bek.getResources().getString(t.j.list_no_more_god_threads));
            this.bkd.vi();
            this.dAb = t.d.cp_bg_line_c;
            at.l(this.mRootView, this.dAb);
        }
    }

    public void aCB() {
        if (this.bkd != null && this.bkd.getView() != null) {
            this.bkd.getView().setVisibility(8);
        }
    }
}
