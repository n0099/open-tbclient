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
    private NoNetworkView EV;
    private final BaseActivity<?> bem;
    private PbListView bjZ;
    private BdTypeListView bqG;
    private int esL;
    private int esM = u.d.cp_bg_line_d;
    private NavigationBar mNavigationBar;
    private q mNoDataView;
    private w mPullView;
    private View mRootView;

    public BdTypeListView aNX() {
        return this.bqG;
    }

    public h(BaseActivity<?> baseActivity) {
        this.bqG = null;
        this.mPullView = null;
        this.bem = baseActivity;
        baseActivity.setContentView(u.h.activity_god_thread_list);
        this.mRootView = baseActivity.findViewById(u.g.root_layout);
        this.EV = (NoNetworkView) this.mRootView.findViewById(u.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(u.g.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(baseActivity.getPageContext().getString(u.j.title_god_thread_list));
        this.bqG = (BdTypeListView) this.mRootView.findViewById(u.g.listview);
        this.bqG.setDividerHeight(0);
        this.mPullView = new w(baseActivity.getPageContext());
        this.mPullView.setTag(this.bem.getUniqueId());
        this.bqG.setPullRefresh(this.mPullView);
        this.bjZ = new PbListView(baseActivity.getActivity());
        this.bjZ.jp();
        this.bjZ.cS(u.d.cp_bg_line_c);
        this.bjZ.setTextColor(av.getColor(u.d.cp_cont_d));
        this.bjZ.cT(TbadkCoreApplication.m10getInst().getSkinType());
        this.bqG.setNextPage(this.bjZ);
        this.esL = this.bem.getResources().getDimensionPixelOffset(u.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        av.l(this.mRootView, this.esM);
        if (this.mPullView != null) {
            this.mPullView.cT(i);
        }
        if (this.bjZ != null) {
            this.bjZ.cT(i);
        }
        if (this.EV != null) {
            this.EV.onChangeSkinType(this.bem.getPageContext(), i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bem.getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bem.getPageContext(), i);
        }
    }

    public void a(NoNetworkView.a aVar) {
        this.EV.a(aVar);
    }

    public void a(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.bqG.setOnSrollToBottomListener(eVar);
    }

    public void jA() {
        this.bqG.jA();
    }

    public void Ty() {
        this.bqG.l(2000L);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bqG.removeHeaderView(this.mNoDataView);
        }
    }

    public void ox(String str) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bem.getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.esL), NoDataViewFactory.d.dS(str), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(str));
        this.mNoDataView.onChangeSkinType(this.bem.getPageContext(), TbadkCoreApplication.m10getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bqG.removeHeaderView(this.mNoDataView);
        this.bqG.addHeaderView(this.mNoDataView);
        aNZ();
        this.esM = u.d.cp_bg_line_d;
        av.l(this.mRootView, this.esM);
    }

    public void UV() {
        if (this.bjZ != null && this.bjZ.getView() != null) {
            this.bjZ.getView().setVisibility(0);
            this.bjZ.vh();
            this.esM = u.d.cp_bg_line_c;
            av.l(this.mRootView, this.esM);
        }
    }

    public void aNY() {
        if (this.bjZ != null && this.bjZ.getView() != null) {
            this.bjZ.getView().setVisibility(0);
            this.bjZ.setText(this.bem.getResources().getString(u.j.list_no_more_god_threads));
            this.bjZ.vi();
            this.esM = u.d.cp_bg_line_c;
            av.l(this.mRootView, this.esM);
        }
    }

    public void aNZ() {
        if (this.bjZ != null && this.bjZ.getView() != null) {
            this.bjZ.getView().setVisibility(8);
        }
    }
}
