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
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView Ao;
    private NoNetworkView fSu;
    private IMBlackListActivity hKv;
    private a hKz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.hKv = iMBlackListActivity;
        initialize();
    }

    public void aNf() {
        this.mProgress.setVisibility(0);
    }

    public void bXl() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.hKz.b(blackListItemData);
        if (this.hKz.getCount() <= 0) {
            this.Ao.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ao.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.hKz.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.hKz.getCount() <= 0) {
            this.Ao.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ao.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.hKz.notifyDataSetChanged();
    }

    public void av(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Ao.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ao.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.hKz.setData(arrayList);
        this.hKz.notifyDataSetChanged();
    }

    private void initialize() {
        this.hKv.setContentView(R.layout.im_black_list);
        this.mRoot = this.hKv.findViewById(R.id.root_view);
        this.fSu = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.Ao = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.hKv.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.kQ(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.hKz = new a(this.hKv);
        this.Ao.setAdapter((ListAdapter) this.hKz);
        aFw();
    }

    private void aFw() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hKv.getLayoutMode().setNightMode(skinType == 1);
        this.hKv.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hKv.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.hKv.getPageContext(), skinType);
        this.fSu.onChangeSkinType(this.hKv.getPageContext(), skinType);
    }
}
