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
    private BdListView LQ;
    private View abp;
    private BaseActivity<UserMuteListActivity> bkU;
    private NoNetworkView cRO;
    private a gwz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bkU = baseActivity;
        this.gwz = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.LQ;
    }

    private void initUI() {
        this.bkU.setContentView(d.i.user_mute_list_activity);
        this.abp = this.bkU.findViewById(d.g.root_view);
        this.cRO = (NoNetworkView) this.abp.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.abp.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.user_mute_list_text);
        this.LQ = (BdListView) this.abp.findViewById(d.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bkU.getPageContext().getContext(), this.abp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aVl), NoDataViewFactory.d.dr(d.k.user_mute_list_no_data_text), null);
        Ay();
    }

    private void Ay() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bkU.getLayoutMode().setNightMode(skinType == 1);
        this.bkU.getLayoutMode().onModeChanged(this.abp);
        this.mNavigationBar.onChangeSkinType(this.bkU.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bkU.getPageContext(), skinType);
        this.cRO.onChangeSkinType(this.bkU.getPageContext(), skinType);
    }

    public void axZ() {
        this.LQ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.user_mute_list_no_data_text));
    }

    public void bsk() {
        this.LQ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.refresh_view_title_text));
    }
}
