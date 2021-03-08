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
    private BdListView Yj;
    private NoNetworkView gzT;
    private IMBlackListActivity kRb;
    private a kRf;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.kRb = iMBlackListActivity;
        initialize();
    }

    public void preLoad() {
        this.mProgress.setVisibility(0);
    }

    public void cYL() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.kRf.b(blackListItemData);
        if (this.kRf.getCount() <= 0) {
            this.Yj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Yj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kRf.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.kRf.getCount() <= 0) {
            this.Yj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Yj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kRf.notifyDataSetChanged();
    }

    public void aF(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Yj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Yj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kRf.setData(arrayList);
        this.kRf.notifyDataSetChanged();
    }

    private void initialize() {
        this.kRb.setContentView(R.layout.im_black_list);
        this.mRoot = this.kRb.findViewById(R.id.root_view);
        this.gzT = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.Yj = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.kRb.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fOd), NoDataViewFactory.d.pA(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kRf = new a(this.kRb);
        this.Yj.setAdapter((ListAdapter) this.kRf);
        bus();
    }

    private void bus() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kRb.getLayoutMode().setNightMode(skinType == 1);
        this.kRb.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.kRb.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kRb.getPageContext(), skinType);
        this.gzT.onChangeSkinType(this.kRb.getPageContext(), skinType);
    }
}
