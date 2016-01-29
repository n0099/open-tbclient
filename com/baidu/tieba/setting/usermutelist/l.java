package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<UserMuteListActivity> {
    private BdListView IY;
    private View Sn;
    private NoNetworkView aWk;
    private BaseActivity<UserMuteListActivity> bdK;
    private h dMi;
    private NavigationBar mNavigationBar;
    private o mNoDataView;

    public l(BaseActivity<UserMuteListActivity> baseActivity, h hVar) {
        super(baseActivity.getPageContext());
        this.bdK = baseActivity;
        this.dMi = hVar;
        qD();
    }

    public BdListView KM() {
        return this.IY;
    }

    private void qD() {
        this.bdK.setContentView(t.h.user_mute_list_activity);
        this.Sn = this.bdK.findViewById(t.g.root_view);
        this.aWk = (NoNetworkView) this.Sn.findViewById(t.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Sn.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(t.j.user_mute_list_text);
        this.IY = (BdListView) this.Sn.findViewById(t.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bdK.getPageContext().getContext(), this.Sn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dd(t.j.user_mute_list_no_data_text), null);
        xf();
    }

    private void xf() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bdK.getLayoutMode().ac(skinType == 1);
        this.bdK.getLayoutMode().x(this.Sn);
        this.mNavigationBar.onChangeSkinType(this.bdK.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bdK.getPageContext(), skinType);
        this.aWk.onChangeSkinType(this.bdK.getPageContext(), skinType);
    }

    public void Ri() {
        this.IY.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.user_mute_list_no_data_text));
    }

    public void anB() {
        this.IY.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.refresh_view_title_text));
    }
}
