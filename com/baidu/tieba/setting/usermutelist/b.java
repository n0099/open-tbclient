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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends c<UserMuteListActivity> {
    private BdListView MS;
    private View bBg;
    private BaseActivity<UserMuteListActivity> cVp;
    private NoNetworkView eRV;
    private a iNq;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.cVp = baseActivity;
        this.iNq = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.MS;
    }

    private void initUI() {
        this.cVp.setContentView((int) R.layout.user_mute_list_activity);
        this.bBg = this.cVp.findViewById(R.id.root_view);
        this.eRV = (NoNetworkView) this.bBg.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.user_mute_list_text);
        this.MS = (BdListView) this.bBg.findViewById(R.id.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.cVp.getPageContext().getContext(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cBh), NoDataViewFactory.d.iH(R.string.user_mute_list_no_data_text), null);
        ajG();
    }

    private void ajG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.cVp.getLayoutMode().setNightMode(skinType == 1);
        this.cVp.getLayoutMode().onModeChanged(this.bBg);
        this.mNavigationBar.onChangeSkinType(this.cVp.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.cVp.getPageContext(), skinType);
        this.eRV.onChangeSkinType(this.cVp.getPageContext(), skinType);
    }

    public void boM() {
        this.MS.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.user_mute_list_no_data_text));
    }

    public void ciO() {
        this.MS.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.refresh_view_title_text));
    }
}
