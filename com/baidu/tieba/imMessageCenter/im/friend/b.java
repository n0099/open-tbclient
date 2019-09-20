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
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView Nj;
    private NoNetworkView eYL;
    private IMBlackListActivity gVG;
    private a gVK;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.gVG = iMBlackListActivity;
        initialize();
    }

    public void atv() {
        this.mProgress.setVisibility(0);
    }

    public void bIh() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.gVK.b(blackListItemData);
        if (this.gVK.getCount() <= 0) {
            this.Nj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Nj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gVK.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.gVK.getCount() <= 0) {
            this.Nj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Nj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gVK.notifyDataSetChanged();
    }

    public void ag(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Nj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Nj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gVK.setData(arrayList);
        this.gVK.notifyDataSetChanged();
    }

    private void initialize() {
        this.gVG.setContentView(R.layout.im_black_list);
        this.mRoot = this.gVG.findViewById(R.id.root_view);
        this.eYL = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.Nj = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.gVG.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cDC), NoDataViewFactory.d.iQ(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.gVK = new a(this.gVG);
        this.Nj.setAdapter((ListAdapter) this.gVK);
        akZ();
    }

    private void akZ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gVG.getLayoutMode().setNightMode(skinType == 1);
        this.gVG.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gVG.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gVG.getPageContext(), skinType);
        this.eYL.onChangeSkinType(this.gVG.getPageContext(), skinType);
    }
}
