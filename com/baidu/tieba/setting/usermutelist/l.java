package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<UserMuteListActivity> {
    private NoNetworkView aQl;
    private BaseActivity<UserMuteListActivity> aXA;
    private h doR;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private View mRoot;

    public l(BaseActivity<UserMuteListActivity> baseActivity, h hVar) {
        super(baseActivity.getPageContext());
        this.aXA = baseActivity;
        this.doR = hVar;
        initUI();
    }

    public BdListView getListView() {
        return this.mListView;
    }

    private void initUI() {
        this.aXA.setContentView(n.g.user_mute_list_activity);
        this.mRoot = this.aXA.findViewById(n.f.root_view);
        this.aQl = (NoNetworkView) this.mRoot.findViewById(n.f.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.user_mute_list_text);
        this.mListView = (BdListView) this.mRoot.findViewById(n.f.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.aXA.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cS(n.i.user_mute_list_no_data_text), null);
        wh();
    }

    private void wh() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aXA.getLayoutMode().af(skinType == 1);
        this.aXA.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.aXA.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.aXA.getPageContext(), skinType);
        this.aQl.onChangeSkinType(this.aXA.getPageContext(), skinType);
    }

    public void showNoData() {
        this.mListView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }
}
