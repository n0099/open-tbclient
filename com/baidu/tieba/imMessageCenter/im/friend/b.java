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
    private NoNetworkView fay;
    private a iNB;
    private IMBlackListActivity iNx;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.iNx = iMBlackListActivity;
        initialize();
    }

    public void beh() {
        this.mProgress.setVisibility(0);
    }

    public void cqo() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.iNB.b(blackListItemData);
        if (this.iNB.getCount() <= 0) {
            this.Um.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Um.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.iNB.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.iNB.getCount() <= 0) {
            this.Um.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Um.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.iNB.notifyDataSetChanged();
    }

    public void ax(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Um.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Um.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.iNB.setData(arrayList);
        this.iNB.notifyDataSetChanged();
    }

    private void initialize() {
        this.iNx.setContentView(R.layout.im_black_list);
        this.mRoot = this.iNx.findViewById(R.id.root_view);
        this.fay = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.Um = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.iNx.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.euP), NoDataViewFactory.d.lV(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.iNB = new a(this.iNx);
        this.Um.setAdapter((ListAdapter) this.iNB);
        aWr();
    }

    private void aWr() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iNx.getLayoutMode().setNightMode(skinType == 1);
        this.iNx.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.iNx.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.iNx.getPageContext(), skinType);
        this.fay.onChangeSkinType(this.iNx.getPageContext(), skinType);
    }
}
