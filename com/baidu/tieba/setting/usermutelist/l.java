package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<UserMuteListActivity> {
    private NoNetworkView aNx;
    private BaseActivity<UserMuteListActivity> aSJ;
    private h czb;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private u mNoDataView;
    private View mRoot;

    public l(BaseActivity<UserMuteListActivity> baseActivity, h hVar) {
        super(baseActivity.getPageContext());
        this.aSJ = baseActivity;
        this.czb = hVar;
        initUI();
    }

    public BdListView getListView() {
        return this.mListView;
    }

    private void initUI() {
        this.aSJ.setContentView(i.g.user_mute_list_activity);
        this.mRoot = this.aSJ.findViewById(i.f.root_view);
        this.aNx = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.C0057i.user_mute_list_text);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.aSJ.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cD(i.C0057i.user_mute_list_no_data_text), null);
        vD();
    }

    private void vD() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aSJ.getLayoutMode().ad(skinType == 1);
        this.aSJ.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.aSJ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.aSJ.getPageContext(), skinType);
        this.aNx.onChangeSkinType(this.aSJ.getPageContext(), skinType);
    }

    public void showNoData() {
        this.mListView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }
}
