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
    private NoNetworkView aMF;
    private BaseActivity<UserMuteListActivity> aRT;
    private h cOA;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private View mRoot;

    public l(BaseActivity<UserMuteListActivity> baseActivity, h hVar) {
        super(baseActivity.getPageContext());
        this.aRT = baseActivity;
        this.cOA = hVar;
        initUI();
    }

    public BdListView getListView() {
        return this.mListView;
    }

    private void initUI() {
        this.aRT.setContentView(i.g.user_mute_list_activity);
        this.mRoot = this.aRT.findViewById(i.f.root_view);
        this.aMF = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.user_mute_list_text);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.aRT.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.user_mute_list_no_data_text), null);
        vA();
    }

    private void vA() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aRT.getLayoutMode().ad(skinType == 1);
        this.aRT.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.aRT.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.aRT.getPageContext(), skinType);
        this.aMF.onChangeSkinType(this.aRT.getPageContext(), skinType);
    }

    public void showNoData() {
        this.mListView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }
}
