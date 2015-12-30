package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<UserMuteListActivity> {
    private NoNetworkView aUd;
    private BaseActivity<UserMuteListActivity> bbA;
    private h dwe;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private o mNoDataView;
    private View mRoot;

    public l(BaseActivity<UserMuteListActivity> baseActivity, h hVar) {
        super(baseActivity.getPageContext());
        this.bbA = baseActivity;
        this.dwe = hVar;
        initUI();
    }

    public BdListView getListView() {
        return this.mListView;
    }

    private void initUI() {
        this.bbA.setContentView(n.h.user_mute_list_activity);
        this.mRoot = this.bbA.findViewById(n.g.root_view);
        this.aUd = (NoNetworkView) this.mRoot.findViewById(n.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.user_mute_list_text);
        this.mListView = (BdListView) this.mRoot.findViewById(n.g.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.bbA.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cM(n.j.user_mute_list_no_data_text), null);
        vR();
    }

    private void vR() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bbA.getLayoutMode().ac(skinType == 1);
        this.bbA.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bbA.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bbA.getPageContext(), skinType);
        this.aUd.onChangeSkinType(this.bbA.getPageContext(), skinType);
    }

    public void showNoData() {
        this.mListView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.user_mute_list_no_data_text));
    }

    public void ajD() {
        this.mListView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.refresh_view_title_text));
    }
}
