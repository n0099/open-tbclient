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
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView WX;
    private NoNetworkView gpw;
    private IMBlackListActivity kGd;
    private a kGh;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.kGd = iMBlackListActivity;
        initialize();
    }

    public void bDG() {
        this.mProgress.setVisibility(0);
    }

    public void daN() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.kGh.b(blackListItemData);
        if (this.kGh.getCount() <= 0) {
            this.WX.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.WX.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kGh.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.kGh.getCount() <= 0) {
            this.WX.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.WX.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kGh.notifyDataSetChanged();
    }

    public void aL(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.WX.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.WX.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.kGh.setData(arrayList);
        this.kGh.notifyDataSetChanged();
    }

    private void initialize() {
        this.kGd.setContentView(R.layout.im_black_list);
        this.mRoot = this.kGd.findViewById(R.id.root_view);
        this.gpw = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.WX = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.kGd.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fFw), NoDataViewFactory.d.qP(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kGh = new a(this.kGd);
        this.WX.setAdapter((ListAdapter) this.kGh);
        bvt();
    }

    private void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kGd.getLayoutMode().setNightMode(skinType == 1);
        this.kGd.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.kGd.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kGd.getPageContext(), skinType);
        this.gpw.onChangeSkinType(this.kGd.getPageContext(), skinType);
    }
}
