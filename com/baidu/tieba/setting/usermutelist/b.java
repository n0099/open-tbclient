package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends c<UserMuteListActivity> {
    private View aHT;
    private BdListView auZ;
    private BaseActivity<UserMuteListActivity> bSF;
    private NoNetworkView dpl;
    private a gOS;
    private NavigationBar mNavigationBar;
    private h mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bSF = baseActivity;
        this.gOS = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.auZ;
    }

    private void initUI() {
        this.bSF.setContentView(d.h.user_mute_list_activity);
        this.aHT = this.bSF.findViewById(d.g.root_view);
        this.dpl = (NoNetworkView) this.aHT.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aHT.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.user_mute_list_text);
        this.auZ = (BdListView) this.aHT.findViewById(d.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bSF.getPageContext().getContext(), this.aHT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bCM), NoDataViewFactory.d.gp(d.j.user_mute_list_no_data_text), null);
        En();
    }

    private void En() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bSF.getLayoutMode().aQ(skinType == 1);
        this.bSF.getLayoutMode().aM(this.aHT);
        this.mNavigationBar.onChangeSkinType(this.bSF.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bSF.getPageContext(), skinType);
        this.dpl.onChangeSkinType(this.bSF.getPageContext(), skinType);
    }

    public void bse() {
        this.auZ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.user_mute_list_no_data_text));
    }

    public void bsf() {
        this.auZ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.refresh_view_title_text));
    }
}
