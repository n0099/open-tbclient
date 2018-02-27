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
    private View aHS;
    private BdListView auY;
    private BaseActivity<UserMuteListActivity> bSC;
    private NoNetworkView dpi;
    private a gOC;
    private NavigationBar mNavigationBar;
    private h mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bSC = baseActivity;
        this.gOC = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.auY;
    }

    private void initUI() {
        this.bSC.setContentView(d.h.user_mute_list_activity);
        this.aHS = this.bSC.findViewById(d.g.root_view);
        this.dpi = (NoNetworkView) this.aHS.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aHS.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.user_mute_list_text);
        this.auY = (BdListView) this.aHS.findViewById(d.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bSC.getPageContext().getContext(), this.aHS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bCJ), NoDataViewFactory.d.gp(d.j.user_mute_list_no_data_text), null);
        Em();
    }

    private void Em() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bSC.getLayoutMode().aQ(skinType == 1);
        this.bSC.getLayoutMode().aM(this.aHS);
        this.mNavigationBar.onChangeSkinType(this.bSC.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bSC.getPageContext(), skinType);
        this.dpi.onChangeSkinType(this.bSC.getPageContext(), skinType);
    }

    public void bsd() {
        this.auY.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.user_mute_list_no_data_text));
    }

    public void bse() {
        this.auY.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.refresh_view_title_text));
    }
}
