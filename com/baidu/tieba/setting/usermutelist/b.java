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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends c<UserMuteListActivity> {
    private BdListView LO;
    private View aaV;
    private BaseActivity<UserMuteListActivity> bmZ;
    private NoNetworkView cSy;
    private a gBA;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bmZ = baseActivity;
        this.gBA = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.LO;
    }

    private void initUI() {
        this.bmZ.setContentView(d.h.user_mute_list_activity);
        this.aaV = this.bmZ.findViewById(d.g.root_view);
        this.cSy = (NoNetworkView) this.aaV.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aaV.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.user_mute_list_text);
        this.LO = (BdListView) this.aaV.findViewById(d.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bmZ.getPageContext().getContext(), this.aaV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aWi), NoDataViewFactory.d.du(d.j.user_mute_list_no_data_text), null);
        AG();
    }

    private void AG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bmZ.getLayoutMode().setNightMode(skinType == 1);
        this.bmZ.getLayoutMode().onModeChanged(this.aaV);
        this.mNavigationBar.onChangeSkinType(this.bmZ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bmZ.getPageContext(), skinType);
        this.cSy.onChangeSkinType(this.bmZ.getPageContext(), skinType);
    }

    public void azj() {
        this.LO.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.user_mute_list_no_data_text));
    }

    public void bro() {
        this.LO.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.refresh_view_title_text));
    }
}
