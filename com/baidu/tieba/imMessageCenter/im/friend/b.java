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
    private BdListView WV;
    private NoNetworkView gzT;
    private IMBlackListActivity kLm;
    private a kLq;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.kLm = iMBlackListActivity;
        initialize();
    }

    public void preLoad() {
        this.mProgress.setVisibility(0);
    }

    public void daq() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.kLq.b(blackListItemData);
        if (this.kLq.getCount() <= 0) {
            this.WV.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.WV.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kLq.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.kLq.getCount() <= 0) {
            this.WV.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.WV.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kLq.notifyDataSetChanged();
    }

    public void aL(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.WV.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.WV.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kLq.setData(arrayList);
        this.kLq.notifyDataSetChanged();
    }

    private void initialize() {
        this.kLm.setContentView(R.layout.im_black_list);
        this.mRoot = this.kLm.findViewById(R.id.root_view);
        this.gzT = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.WV = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.kLm.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fOZ), NoDataViewFactory.d.ra(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kLq = new a(this.kLm);
        this.WV.setAdapter((ListAdapter) this.kLq);
        bxO();
    }

    private void bxO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kLm.getLayoutMode().setNightMode(skinType == 1);
        this.kLm.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.kLm.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kLm.getPageContext(), skinType);
        this.gzT.onChangeSkinType(this.kLm.getPageContext(), skinType);
    }
}
