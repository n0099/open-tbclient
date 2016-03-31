package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<UserMuteListActivity> {
    private BdListView Je;
    private View PL;
    private NoNetworkView baT;
    private BaseActivity<UserMuteListActivity> bix;
    private h eeI;
    private NavigationBar mNavigationBar;
    private p mNoDataView;

    public l(BaseActivity<UserMuteListActivity> baseActivity, h hVar) {
        super(baseActivity.getPageContext());
        this.bix = baseActivity;
        this.eeI = hVar;
        pU();
    }

    public BdListView Mg() {
        return this.Je;
    }

    private void pU() {
        this.bix.setContentView(t.h.user_mute_list_activity);
        this.PL = this.bix.findViewById(t.g.root_view);
        this.baT = (NoNetworkView) this.PL.findViewById(t.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.PL.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(t.j.user_mute_list_text);
        this.Je = (BdListView) this.PL.findViewById(t.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bix.getPageContext().getContext(), this.PL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dg(t.j.user_mute_list_no_data_text), null);
        xy();
    }

    private void xy() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bix.getLayoutMode().ab(skinType == 1);
        this.bix.getLayoutMode().x(this.PL);
        this.mNavigationBar.onChangeSkinType(this.bix.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bix.getPageContext(), skinType);
        this.baT.onChangeSkinType(this.bix.getPageContext(), skinType);
    }

    public void SV() {
        this.Je.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.user_mute_list_no_data_text));
    }

    public void aPq() {
        this.Je.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.refresh_view_title_text));
    }
}
