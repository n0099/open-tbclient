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
/* loaded from: classes26.dex */
public class b extends c<UserMuteListActivity> {
    private BdListView VY;
    private NoNetworkView gbO;
    private BaseActivity<UserMuteListActivity> mActivity;
    private a mEn;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRoot;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.mActivity = baseActivity;
        this.mEn = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.VY;
    }

    private void initUI() {
        this.mActivity.setContentView(R.layout.user_mute_list_activity);
        this.mRoot = this.mActivity.findViewById(R.id.root_view);
        this.gbO = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.user_mute_list_text);
        this.VY = (BdListView) this.mRoot.findViewById(R.id.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.mActivity.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fsA), NoDataViewFactory.d.pG(R.string.user_mute_list_no_data_text), null);
        bqd();
    }

    private void bqd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.mActivity.getLayoutMode().setNightMode(skinType == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.mActivity.getPageContext(), skinType);
        this.gbO.onChangeSkinType(this.mActivity.getPageContext(), skinType);
    }

    public void cBr() {
        this.VY.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pG(R.string.user_mute_list_no_data_text));
    }

    public void dDc() {
        this.VY.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pG(R.string.refresh_view_title_text));
    }
}
