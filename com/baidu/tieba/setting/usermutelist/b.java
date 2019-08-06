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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends c<UserMuteListActivity> {
    private BdListView Ni;
    private BaseActivity<UserMuteListActivity> cWT;
    private NoNetworkView eXf;
    private a iUQ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRoot;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.cWT = baseActivity;
        this.iUQ = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.Ni;
    }

    private void initUI() {
        this.cWT.setContentView((int) R.layout.user_mute_list_activity);
        this.mRoot = this.cWT.findViewById(R.id.root_view);
        this.eXf = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.user_mute_list_text);
        this.Ni = (BdListView) this.mRoot.findViewById(R.id.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.cWT.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cCG), NoDataViewFactory.d.iN(R.string.user_mute_list_no_data_text), null);
        akN();
    }

    private void akN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.cWT.getLayoutMode().setNightMode(skinType == 1);
        this.cWT.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.cWT.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.cWT.getPageContext(), skinType);
        this.eXf.onChangeSkinType(this.cWT.getPageContext(), skinType);
    }

    public void brc() {
        this.Ni.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.user_mute_list_no_data_text));
    }

    public void clZ() {
        this.Ni.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.refresh_view_title_text));
    }
}
