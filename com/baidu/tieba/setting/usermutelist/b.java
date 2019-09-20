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
    private BdListView Nj;
    private BaseActivity<UserMuteListActivity> cXM;
    private NoNetworkView eYL;
    private a iXl;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRoot;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.cXM = baseActivity;
        this.iXl = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.Nj;
    }

    private void initUI() {
        this.cXM.setContentView((int) R.layout.user_mute_list_activity);
        this.mRoot = this.cXM.findViewById(R.id.root_view);
        this.eYL = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.user_mute_list_text);
        this.Nj = (BdListView) this.mRoot.findViewById(R.id.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.cXM.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cDC), NoDataViewFactory.d.iQ(R.string.user_mute_list_no_data_text), null);
        akZ();
    }

    private void akZ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.cXM.getLayoutMode().setNightMode(skinType == 1);
        this.cXM.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.cXM.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.cXM.getPageContext(), skinType);
        this.eYL.onChangeSkinType(this.cXM.getPageContext(), skinType);
    }

    public void brN() {
        this.Nj.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.user_mute_list_no_data_text));
    }

    public void cmL() {
        this.Nj.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.refresh_view_title_text));
    }
}
