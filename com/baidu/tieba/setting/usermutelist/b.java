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
    private BdListView Pj;
    private View btY;
    private BaseActivity<UserMuteListActivity> cNa;
    private NoNetworkView eCt;
    private a iuP;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.cNa = baseActivity;
        this.iuP = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.Pj;
    }

    private void initUI() {
        this.cNa.setContentView(d.h.user_mute_list_activity);
        this.btY = this.cNa.findViewById(d.g.root_view);
        this.eCt = (NoNetworkView) this.btY.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.btY.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.user_mute_list_text);
        this.Pj = (BdListView) this.btY.findViewById(d.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.cNa.getPageContext().getContext(), this.btY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.csV), NoDataViewFactory.d.hU(d.j.user_mute_list_no_data_text), null);
        aeK();
    }

    private void aeK() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.cNa.getLayoutMode().setNightMode(skinType == 1);
        this.cNa.getLayoutMode().onModeChanged(this.btY);
        this.mNavigationBar.onChangeSkinType(this.cNa.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.cNa.getPageContext(), skinType);
        this.eCt.onChangeSkinType(this.cNa.getPageContext(), skinType);
    }

    public void bhs() {
        this.Pj.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.user_mute_list_no_data_text));
    }

    public void caM() {
        this.Pj.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.refresh_view_title_text));
    }
}
