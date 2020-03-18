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
    private BdListView AG;
    private NoNetworkView fVM;
    private IMBlackListActivity hOh;
    private a hOl;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.hOh = iMBlackListActivity;
        initialize();
    }

    public void aPI() {
        this.mProgress.setVisibility(0);
    }

    public void bZh() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.hOl.b(blackListItemData);
        if (this.hOl.getCount() <= 0) {
            this.AG.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.AG.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.hOl.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.hOl.getCount() <= 0) {
            this.AG.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.AG.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.hOl.notifyDataSetChanged();
    }

    public void av(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.AG.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.AG.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.hOl.setData(arrayList);
        this.hOl.notifyDataSetChanged();
    }

    private void initialize() {
        this.hOh.setContentView(R.layout.im_black_list);
        this.mRoot = this.hOh.findViewById(R.id.root_view);
        this.fVM = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.AG = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.hOh.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.lh(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.hOl = new a(this.hOh);
        this.AG.setAdapter((ListAdapter) this.hOl);
        aHS();
    }

    private void aHS() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hOh.getLayoutMode().setNightMode(skinType == 1);
        this.hOh.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hOh.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.hOh.getPageContext(), skinType);
        this.fVM.onChangeSkinType(this.hOh.getPageContext(), skinType);
    }
}
