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
    private BdListView OQ;
    private View anp;
    private BaseActivity<UserMuteListActivity> bBW;
    private NoNetworkView drP;
    private a hde;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bBW = baseActivity;
        this.hde = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.OQ;
    }

    private void initUI() {
        this.bBW.setContentView(e.h.user_mute_list_activity);
        this.anp = this.bBW.findViewById(e.g.root_view);
        this.drP = (NoNetworkView) this.anp.findViewById(e.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.anp.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.user_mute_list_text);
        this.OQ = (BdListView) this.anp.findViewById(e.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bBW.getPageContext().getContext(), this.anp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bjb), NoDataViewFactory.d.eq(e.j.user_mute_list_no_data_text), null);
        Fw();
    }

    private void Fw() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bBW.getLayoutMode().setNightMode(skinType == 1);
        this.bBW.getLayoutMode().onModeChanged(this.anp);
        this.mNavigationBar.onChangeSkinType(this.bBW.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bBW.getPageContext(), skinType);
        this.drP.onChangeSkinType(this.bBW.getPageContext(), skinType);
    }

    public void aHc() {
        this.OQ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.user_mute_list_no_data_text));
    }

    public void bzV() {
        this.OQ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.refresh_view_title_text));
    }
}
