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
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.d<IMBlackListActivity> {
    private BdListView WO;
    private NoNetworkView gxW;
    private IMBlackListActivity kOL;
    private a kOP;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.kOL = iMBlackListActivity;
        initialize();
    }

    public void preLoad() {
        this.mProgress.setVisibility(0);
    }

    public void cYx() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.kOP.b(blackListItemData);
        if (this.kOP.getCount() <= 0) {
            this.WO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.WO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kOP.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.kOP.getCount() <= 0) {
            this.WO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.WO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kOP.notifyDataSetChanged();
    }

    public void aF(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.WO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.WO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kOP.setData(arrayList);
        this.kOP.notifyDataSetChanged();
    }

    private void initialize() {
        this.kOL.setContentView(R.layout.im_black_list);
        this.mRoot = this.kOL.findViewById(R.id.root_view);
        this.gxW = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.WO = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.kOL.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fMD), NoDataViewFactory.d.pz(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kOP = new a(this.kOL);
        this.WO.setAdapter((ListAdapter) this.kOP);
        bup();
    }

    private void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kOL.getLayoutMode().setNightMode(skinType == 1);
        this.kOL.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.kOL.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kOL.getPageContext(), skinType);
        this.gxW.onChangeSkinType(this.kOL.getPageContext(), skinType);
    }
}
