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
    private BdListView FH;
    private View Th;
    private BaseActivity<UserMuteListActivity> bcK;
    private NoNetworkView cIH;
    private a glb;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bcK = baseActivity;
        this.glb = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.FH;
    }

    private void initUI() {
        this.bcK.setContentView(d.i.user_mute_list_activity);
        this.Th = this.bcK.findViewById(d.g.root_view);
        this.cIH = (NoNetworkView) this.Th.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Th.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.user_mute_list_text);
        this.FH = (BdListView) this.Th.findViewById(d.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bcK.getPageContext().getContext(), this.Th, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aNn), NoDataViewFactory.d.dp(d.k.user_mute_list_no_data_text), null);
        wX();
    }

    private void wX() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bcK.getLayoutMode().setNightMode(skinType == 1);
        this.bcK.getLayoutMode().u(this.Th);
        this.mNavigationBar.onChangeSkinType(this.bcK.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bcK.getPageContext(), skinType);
        this.cIH.onChangeSkinType(this.bcK.getPageContext(), skinType);
    }

    public void atM() {
        this.FH.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.user_mute_list_no_data_text));
    }

    public void bnl() {
        this.FH.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.refresh_view_title_text));
    }
}
