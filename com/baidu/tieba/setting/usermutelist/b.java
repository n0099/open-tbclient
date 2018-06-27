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
    private BdListView LS;
    private View abt;
    private BaseActivity<UserMuteListActivity> bmt;
    private NoNetworkView cPM;
    private a gAs;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bmt = baseActivity;
        this.gAs = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.LS;
    }

    private void initUI() {
        this.bmt.setContentView(d.i.user_mute_list_activity);
        this.abt = this.bmt.findViewById(d.g.root_view);
        this.cPM = (NoNetworkView) this.abt.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.abt.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.user_mute_list_text);
        this.LS = (BdListView) this.abt.findViewById(d.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bmt.getPageContext().getContext(), this.abt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aWg), NoDataViewFactory.d.ds(d.k.user_mute_list_no_data_text), null);
        AP();
    }

    private void AP() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bmt.getLayoutMode().setNightMode(skinType == 1);
        this.bmt.getLayoutMode().onModeChanged(this.abt);
        this.mNavigationBar.onChangeSkinType(this.bmt.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bmt.getPageContext(), skinType);
        this.cPM.onChangeSkinType(this.bmt.getPageContext(), skinType);
    }

    public void ayE() {
        this.LS.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.user_mute_list_no_data_text));
    }

    public void bsL() {
        this.LS.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.refresh_view_title_text));
    }
}
