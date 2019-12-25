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
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView Ak;
    private NoNetworkView fPl;
    private IMBlackListActivity hGS;
    private a hGW;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.hGS = iMBlackListActivity;
        initialize();
    }

    public void aMM() {
        this.mProgress.setVisibility(0);
    }

    public void bWc() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.hGW.b(blackListItemData);
        if (this.hGW.getCount() <= 0) {
            this.Ak.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ak.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.hGW.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.hGW.getCount() <= 0) {
            this.Ak.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ak.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.hGW.notifyDataSetChanged();
    }

    public void av(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Ak.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ak.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.hGW.setData(arrayList);
        this.hGW.notifyDataSetChanged();
    }

    private void initialize() {
        this.hGS.setContentView(R.layout.im_black_list);
        this.mRoot = this.hGS.findViewById(R.id.root_view);
        this.fPl = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.Ak = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.hGS.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.kQ(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.hGW = new a(this.hGS);
        this.Ak.setAdapter((ListAdapter) this.hGW);
        aFd();
    }

    private void aFd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hGS.getLayoutMode().setNightMode(skinType == 1);
        this.hGS.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hGS.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.hGS.getPageContext(), skinType);
        this.fPl.onChangeSkinType(this.hGS.getPageContext(), skinType);
    }
}
