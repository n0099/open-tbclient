package com.baidu.tieba.person.god;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class h {
    private NoNetworkView Ev;
    private PbListView biC;
    private final BaseActivity<?> bkc;
    private BdTypeListView bou;
    private int eiH;
    private int eiI = u.d.cp_bg_line_d;
    private NavigationBar mNavigationBar;
    private q mNoDataView;
    private w mPullView;
    private View mRootView;

    public BdTypeListView aLu() {
        return this.bou;
    }

    public h(BaseActivity<?> baseActivity) {
        this.bou = null;
        this.mPullView = null;
        this.bkc = baseActivity;
        baseActivity.setContentView(u.h.activity_god_thread_list);
        this.mRootView = baseActivity.findViewById(u.g.root_layout);
        this.Ev = (NoNetworkView) this.mRootView.findViewById(u.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(u.g.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(baseActivity.getPageContext().getString(u.j.title_god_thread_list));
        this.bou = (BdTypeListView) this.mRootView.findViewById(u.g.listview);
        this.bou.setDividerHeight(0);
        this.mPullView = new w(baseActivity.getPageContext());
        this.mPullView.setTag(this.bkc.getUniqueId());
        this.bou.setPullRefresh(this.mPullView);
        this.biC = new PbListView(baseActivity.getActivity());
        this.biC.jq();
        this.biC.cS(u.d.cp_bg_line_c);
        this.biC.setTextColor(av.getColor(u.d.cp_cont_d));
        this.biC.cT(TbadkCoreApplication.m9getInst().getSkinType());
        this.bou.setNextPage(this.biC);
        this.eiH = this.bkc.getResources().getDimensionPixelOffset(u.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        av.l(this.mRootView, this.eiI);
        if (this.mPullView != null) {
            this.mPullView.cT(i);
        }
        if (this.biC != null) {
            this.biC.cT(i);
        }
        if (this.Ev != null) {
            this.Ev.onChangeSkinType(this.bkc.getPageContext(), i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bkc.getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bkc.getPageContext(), i);
        }
    }

    public void a(NoNetworkView.a aVar) {
        this.Ev.a(aVar);
    }

    public void a(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.bou.setOnSrollToBottomListener(eVar);
    }

    public void jB() {
        this.bou.jB();
    }

    public void SQ() {
        this.bou.k(2000L);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bou.removeHeaderView(this.mNoDataView);
        }
    }

    public void nK(String str) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bkc.getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.eiH), NoDataViewFactory.d.dT(str), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dT(str));
        this.mNoDataView.onChangeSkinType(this.bkc.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bou.removeHeaderView(this.mNoDataView);
        this.bou.addHeaderView(this.mNoDataView);
        aLw();
        this.eiI = u.d.cp_bg_line_d;
        av.l(this.mRootView, this.eiI);
    }

    public void Un() {
        if (this.biC != null && this.biC.getView() != null) {
            this.biC.getView().setVisibility(0);
            this.biC.vh();
            this.eiI = u.d.cp_bg_line_c;
            av.l(this.mRootView, this.eiI);
        }
    }

    public void aLv() {
        if (this.biC != null && this.biC.getView() != null) {
            this.biC.getView().setVisibility(0);
            this.biC.setText(this.bkc.getResources().getString(u.j.list_no_more_god_threads));
            this.biC.vi();
            this.eiI = u.d.cp_bg_line_c;
            av.l(this.mRootView, this.eiI);
        }
    }

    public void aLw() {
        if (this.biC != null && this.biC.getView() != null) {
            this.biC.getView().setVisibility(8);
        }
    }
}
