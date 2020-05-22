package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView Um;
    private NoNetworkView fan;
    private IMBlackListActivity iMK;
    private a iMO;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.iMK = iMBlackListActivity;
        initialize();
    }

    public void beg() {
        this.mProgress.setVisibility(0);
    }

    public void cqf() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.iMO.b(blackListItemData);
        if (this.iMO.getCount() <= 0) {
            this.Um.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Um.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.iMO.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.iMO.getCount() <= 0) {
            this.Um.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Um.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.iMO.notifyDataSetChanged();
    }

    public void ax(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Um.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Um.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.iMO.setData(arrayList);
        this.iMO.notifyDataSetChanged();
    }

    private void initialize() {
        this.iMK.setContentView(R.layout.im_black_list);
        this.mRoot = this.iMK.findViewById(R.id.root_view);
        this.fan = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.Um = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.iMK.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.euP), NoDataViewFactory.d.lT(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.iMO = new a(this.iMK);
        this.Um.setAdapter((ListAdapter) this.iMO);
        aWq();
    }

    private void aWq() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iMK.getLayoutMode().setNightMode(skinType == 1);
        this.iMK.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.iMK.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.iMK.getPageContext(), skinType);
        this.fan.onChangeSkinType(this.iMK.getPageContext(), skinType);
    }
}
