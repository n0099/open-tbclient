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
    private BdListView FL;
    private View Tl;
    private BaseActivity<UserMuteListActivity> bcJ;
    private NoNetworkView cHB;
    private a gjY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bcJ = baseActivity;
        this.gjY = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.FL;
    }

    private void initUI() {
        this.bcJ.setContentView(d.i.user_mute_list_activity);
        this.Tl = this.bcJ.findViewById(d.g.root_view);
        this.cHB = (NoNetworkView) this.Tl.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Tl.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.user_mute_list_text);
        this.FL = (BdListView) this.Tl.findViewById(d.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bcJ.getPageContext().getContext(), this.Tl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aNm), NoDataViewFactory.d.dp(d.k.user_mute_list_no_data_text), null);
        wY();
    }

    private void wY() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bcJ.getLayoutMode().setNightMode(skinType == 1);
        this.bcJ.getLayoutMode().u(this.Tl);
        this.mNavigationBar.onChangeSkinType(this.bcJ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bcJ.getPageContext(), skinType);
        this.cHB.onChangeSkinType(this.bcJ.getPageContext(), skinType);
    }

    public void atN() {
        this.FL.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.user_mute_list_no_data_text));
    }

    public void bnn() {
        this.FL.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.refresh_view_title_text));
    }
}
