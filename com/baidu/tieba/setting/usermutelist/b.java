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
    private BaseActivity<UserMuteListActivity> bBf;
    private NoNetworkView dop;
    private a gYU;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bBf = baseActivity;
        this.gYU = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.OF;
    }

    private void initUI() {
        this.bBf.setContentView(e.h.user_mute_list_activity);
        this.amM = this.bBf.findViewById(e.g.root_view);
        this.dop = (NoNetworkView) this.amM.findViewById(e.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.user_mute_list_text);
        this.OF = (BdListView) this.amM.findViewById(e.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bBf.getPageContext().getContext(), this.amM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bio), NoDataViewFactory.d.eq(e.j.user_mute_list_no_data_text), null);
        Fj();
    }

    private void Fj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bBf.getLayoutMode().setNightMode(skinType == 1);
        this.bBf.getLayoutMode().onModeChanged(this.amM);
        this.mNavigationBar.onChangeSkinType(this.bBf.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bBf.getPageContext(), skinType);
        this.dop.onChangeSkinType(this.bBf.getPageContext(), skinType);
    }

    public void aFQ() {
        this.OF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.user_mute_list_no_data_text));
    }

    public void byx() {
        this.OF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.refresh_view_title_text));
    }
}
