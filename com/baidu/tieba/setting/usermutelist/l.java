package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<UserMuteListActivity> {
    private NoNetworkView aMY;
    private BaseActivity<UserMuteListActivity> aSm;
    private h cQv;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private View mRoot;

    public l(BaseActivity<UserMuteListActivity> baseActivity, h hVar) {
        super(baseActivity.getPageContext());
        this.aSm = baseActivity;
        this.cQv = hVar;
        initUI();
    }

    public BdListView getListView() {
        return this.mListView;
    }

    private void initUI() {
        this.aSm.setContentView(i.g.user_mute_list_activity);
        this.mRoot = this.aSm.findViewById(i.f.root_view);
        this.aMY = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.user_mute_list_text);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.aSm.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.user_mute_list_no_data_text), null);
        vB();
    }

    private void vB() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aSm.getLayoutMode().ad(skinType == 1);
        this.aSm.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.aSm.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.aSm.getPageContext(), skinType);
        this.aMY.onChangeSkinType(this.aSm.getPageContext(), skinType);
    }

    public void showNoData() {
        this.mListView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }
}
