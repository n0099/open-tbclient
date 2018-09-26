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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends c<UserMuteListActivity> {
    private BdListView Op;
    private View adA;
    private BaseActivity<UserMuteListActivity> bsQ;
    private NoNetworkView cYm;
    private a gJh;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bsQ = baseActivity;
        this.gJh = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.Op;
    }

    private void initUI() {
        this.bsQ.setContentView(e.h.user_mute_list_activity);
        this.adA = this.bsQ.findViewById(e.g.root_view);
        this.cYm = (NoNetworkView) this.adA.findViewById(e.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.adA.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.user_mute_list_text);
        this.Op = (BdListView) this.adA.findViewById(e.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bsQ.getPageContext().getContext(), this.adA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aZy), NoDataViewFactory.d.dE(e.j.user_mute_list_no_data_text), null);
        BQ();
    }

    private void BQ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bsQ.getLayoutMode().setNightMode(skinType == 1);
        this.bsQ.getLayoutMode().onModeChanged(this.adA);
        this.mNavigationBar.onChangeSkinType(this.bsQ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bsQ.getPageContext(), skinType);
        this.cYm.onChangeSkinType(this.bsQ.getPageContext(), skinType);
    }

    public void aBp() {
        this.Op.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.user_mute_list_no_data_text));
    }

    public void btT() {
        this.Op.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.refresh_view_title_text));
    }
}
