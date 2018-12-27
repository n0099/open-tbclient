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
    private BdListView OF;
    private View amM;
    private BaseActivity<UserMuteListActivity> bBi;
    private NoNetworkView drf;
    private a hbY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bBi = baseActivity;
        this.hbY = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.OF;
    }

    private void initUI() {
        this.bBi.setContentView(e.h.user_mute_list_activity);
        this.amM = this.bBi.findViewById(e.g.root_view);
        this.drf = (NoNetworkView) this.amM.findViewById(e.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.user_mute_list_text);
        this.OF = (BdListView) this.amM.findViewById(e.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bBi.getPageContext().getContext(), this.amM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bir), NoDataViewFactory.d.eq(e.j.user_mute_list_no_data_text), null);
        Fj();
    }

    private void Fj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bBi.getLayoutMode().setNightMode(skinType == 1);
        this.bBi.getLayoutMode().onModeChanged(this.amM);
        this.mNavigationBar.onChangeSkinType(this.bBi.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bBi.getPageContext(), skinType);
        this.drf.onChangeSkinType(this.bBi.getPageContext(), skinType);
    }

    public void aGF() {
        this.OF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.user_mute_list_no_data_text));
    }

    public void bzm() {
        this.OF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.refresh_view_title_text));
    }
}
