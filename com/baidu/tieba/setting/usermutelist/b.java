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
    private BaseActivity<UserMuteListActivity> cWM;
    private NoNetworkView eWV;
    private a iTM;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRoot;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.cWM = baseActivity;
        this.iTM = aVar;
        initUI();
    }

    public BdListView getListView() {
        return this.Ni;
    }

    private void initUI() {
        this.cWM.setContentView((int) R.layout.user_mute_list_activity);
        this.mRoot = this.cWM.findViewById(R.id.root_view);
        this.eWV = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.user_mute_list_text);
        this.Ni = (BdListView) this.mRoot.findViewById(R.id.mute_user_list);
        this.mNoDataView = NoDataViewFactory.a(this.cWM.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cCz), NoDataViewFactory.d.iN(R.string.user_mute_list_no_data_text), null);
        akL();
    }

    private void akL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.cWM.getLayoutMode().setNightMode(skinType == 1);
        this.cWM.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.cWM.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.cWM.getPageContext(), skinType);
        this.eWV.onChangeSkinType(this.cWM.getPageContext(), skinType);
    }

    public void bqP() {
        this.Ni.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.user_mute_list_no_data_text));
    }

    public void clH() {
        this.Ni.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.refresh_view_title_text));
    }
}
