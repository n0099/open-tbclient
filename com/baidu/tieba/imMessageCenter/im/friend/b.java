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
    private BdListView Ua;
    private NoNetworkView gAM;
    private IMBlackListActivity iye;
    private a iyi;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.iye = iMBlackListActivity;
        initialize();
    }

    public void aXX() {
        this.mProgress.setVisibility(0);
    }

    public void cjG() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.iyi.b(blackListItemData);
        if (this.iyi.getCount() <= 0) {
            this.Ua.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ua.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.iyi.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.iyi.getCount() <= 0) {
            this.Ua.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ua.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.iyi.notifyDataSetChanged();
    }

    public void ax(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Ua.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ua.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.iyi.setData(arrayList);
        this.iyi.notifyDataSetChanged();
    }

    private void initialize() {
        this.iye.setContentView(R.layout.im_black_list);
        this.mRoot = this.iye.findViewById(R.id.root_view);
        this.gAM = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.Ua = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.iye.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.egB), NoDataViewFactory.d.lr(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.iyi = new a(this.iye);
        this.Ua.setAdapter((ListAdapter) this.iyi);
        aQm();
    }

    private void aQm() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iye.getLayoutMode().setNightMode(skinType == 1);
        this.iye.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.iye.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.iye.getPageContext(), skinType);
        this.gAM.onChangeSkinType(this.iye.getPageContext(), skinType);
    }
}
