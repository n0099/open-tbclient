package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.adp.base.d;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class b extends d<UserMuteListActivity> {
    private BdListView WT;
    private NoNetworkView gvm;
    private BaseActivity<UserMuteListActivity> mActivity;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRoot;
    private a mZQ;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.mActivity = baseActivity;
        this.mZQ = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.WT;
    }

    private void initUI() {
        this.mActivity.setContentView(R.layout.user_mute_list_activity);
        this.mRoot = this.mActivity.findViewById(R.id.root_view);
        this.gvm = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.user_mute_list_text);
        this.WT = (BdListView) this.mRoot.findViewById(R.id.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.mActivity.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fKs), NoDataViewFactory.d.pu(R.string.user_mute_list_no_data_text), null);
        btV();
    }

    private void btV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.mActivity.getLayoutMode().setNightMode(skinType == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.mActivity.getPageContext(), skinType);
        this.gvm.onChangeSkinType(this.mActivity.getPageContext(), skinType);
    }

    public void cHT() {
        this.WT.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pu(R.string.user_mute_list_no_data_text));
    }

    public void dGD() {
        this.WT.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pu(R.string.refresh_view_title_text));
    }
}
