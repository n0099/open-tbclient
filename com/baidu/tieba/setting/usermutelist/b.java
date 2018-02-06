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
    private View aId;
    private BdListView avh;
    private BaseActivity<UserMuteListActivity> bSO;
    private NoNetworkView dpu;
    private a gOR;
    private NavigationBar mNavigationBar;
    private h mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bSO = baseActivity;
        this.gOR = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.avh;
    }

    private void initUI() {
        this.bSO.setContentView(d.h.user_mute_list_activity);
        this.aId = this.bSO.findViewById(d.g.root_view);
        this.dpu = (NoNetworkView) this.aId.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aId.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.user_mute_list_text);
        this.avh = (BdListView) this.aId.findViewById(d.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bSO.getPageContext().getContext(), this.aId, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bCW), NoDataViewFactory.d.gp(d.j.user_mute_list_no_data_text), null);
        En();
    }

    private void En() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bSO.getLayoutMode().aQ(skinType == 1);
        this.bSO.getLayoutMode().aM(this.aId);
        this.mNavigationBar.onChangeSkinType(this.bSO.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bSO.getPageContext(), skinType);
        this.dpu.onChangeSkinType(this.bSO.getPageContext(), skinType);
    }

    public void bse() {
        this.avh.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.user_mute_list_no_data_text));
    }

    public void bsf() {
        this.avh.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.refresh_view_title_text));
    }
}
