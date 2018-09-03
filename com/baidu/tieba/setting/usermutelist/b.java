package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b extends c<UserMuteListActivity> {
    private BdListView LO;
    private View aaW;
    private BaseActivity<UserMuteListActivity> bnc;
    private NoNetworkView cSv;
    private a gBD;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bnc = baseActivity;
        this.gBD = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.LO;
    }

    private void initUI() {
        this.bnc.setContentView(f.h.user_mute_list_activity);
        this.aaW = this.bnc.findViewById(f.g.root_view);
        this.cSv = (NoNetworkView) this.aaW.findViewById(f.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aaW.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(f.j.user_mute_list_text);
        this.LO = (BdListView) this.aaW.findViewById(f.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bnc.getPageContext().getContext(), this.aaW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aWi), NoDataViewFactory.d.dt(f.j.user_mute_list_no_data_text), null);
        AD();
    }

    private void AD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bnc.getLayoutMode().setNightMode(skinType == 1);
        this.bnc.getLayoutMode().onModeChanged(this.aaW);
        this.mNavigationBar.onChangeSkinType(this.bnc.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bnc.getPageContext(), skinType);
        this.cSv.onChangeSkinType(this.bnc.getPageContext(), skinType);
    }

    public void azh() {
        this.LO.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.user_mute_list_no_data_text));
    }

    public void brp() {
        this.LO.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.refresh_view_title_text));
    }
}
