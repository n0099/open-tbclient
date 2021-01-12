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
    private BdListView WT;
    private NoNetworkView gvm;
    private IMBlackListActivity kGH;
    private a kGL;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.kGH = iMBlackListActivity;
        initialize();
    }

    public void preLoad() {
        this.mProgress.setVisibility(0);
    }

    public void cWz() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.kGL.b(blackListItemData);
        if (this.kGL.getCount() <= 0) {
            this.WT.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.WT.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kGL.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.kGL.getCount() <= 0) {
            this.WT.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.WT.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kGL.notifyDataSetChanged();
    }

    public void aG(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.WT.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.WT.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kGL.setData(arrayList);
        this.kGL.notifyDataSetChanged();
    }

    private void initialize() {
        this.kGH.setContentView(R.layout.im_black_list);
        this.mRoot = this.kGH.findViewById(R.id.root_view);
        this.gvm = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.WT = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.kGH.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fKs), NoDataViewFactory.d.pu(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kGL = new a(this.kGH);
        this.WT.setAdapter((ListAdapter) this.kGL);
        btV();
    }

    private void btV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kGH.getLayoutMode().setNightMode(skinType == 1);
        this.kGH.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.kGH.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kGH.getPageContext(), skinType);
        this.gvm.onChangeSkinType(this.kGH.getPageContext(), skinType);
    }
}
