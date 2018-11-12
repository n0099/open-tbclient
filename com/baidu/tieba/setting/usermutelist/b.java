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
    private View ajk;
    private BaseActivity<UserMuteListActivity> bxI;
    private NoNetworkView dhH;
    private a gSe;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bxI = baseActivity;
        this.gSe = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.OF;
    }

    private void initUI() {
        this.bxI.setContentView(e.h.user_mute_list_activity);
        this.ajk = this.bxI.findViewById(e.g.root_view);
        this.dhH = (NoNetworkView) this.ajk.findViewById(e.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.ajk.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.user_mute_list_text);
        this.OF = (BdListView) this.ajk.findViewById(e.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bxI.getPageContext().getContext(), this.ajk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.beN), NoDataViewFactory.d.ec(e.j.user_mute_list_no_data_text), null);
        Ef();
    }

    private void Ef() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.bxI.getLayoutMode().setNightMode(skinType == 1);
        this.bxI.getLayoutMode().onModeChanged(this.ajk);
        this.mNavigationBar.onChangeSkinType(this.bxI.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bxI.getPageContext(), skinType);
        this.dhH.onChangeSkinType(this.bxI.getPageContext(), skinType);
    }

    public void aEe() {
        this.OF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.user_mute_list_no_data_text));
    }

    public void bwE() {
        this.OF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.refresh_view_title_text));
    }
}
