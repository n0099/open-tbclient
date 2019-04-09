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
    private View buc;
    private BaseActivity<UserMuteListActivity> cNd;
    private NoNetworkView eCf;
    private a iuA;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.cNd = baseActivity;
        this.iuA = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.Pj;
    }

    private void initUI() {
        this.cNd.setContentView(d.h.user_mute_list_activity);
        this.buc = this.cNd.findViewById(d.g.root_view);
        this.eCf = (NoNetworkView) this.buc.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.buc.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.user_mute_list_text);
        this.Pj = (BdListView) this.buc.findViewById(d.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.cNd.getPageContext().getContext(), this.buc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.csY), NoDataViewFactory.d.hT(d.j.user_mute_list_no_data_text), null);
        aeH();
    }

    private void aeH() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.cNd.getLayoutMode().setNightMode(skinType == 1);
        this.cNd.getLayoutMode().onModeChanged(this.buc);
        this.mNavigationBar.onChangeSkinType(this.cNd.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.cNd.getPageContext(), skinType);
        this.eCf.onChangeSkinType(this.cNd.getPageContext(), skinType);
    }

    public void bhq() {
        this.Pj.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.user_mute_list_no_data_text));
    }

    public void caI() {
        this.Pj.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.refresh_view_title_text));
    }
}
