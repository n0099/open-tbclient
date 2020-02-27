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
    private NoNetworkView fUO;
    private IMBlackListActivity hMt;
    private a hMx;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.hMt = iMBlackListActivity;
        initialize();
    }

    public void aPB() {
        this.mProgress.setVisibility(0);
    }

    public void bYM() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.hMx.b(blackListItemData);
        if (this.hMx.getCount() <= 0) {
            this.AG.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.AG.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.hMx.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.hMx.getCount() <= 0) {
            this.AG.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.AG.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.hMx.notifyDataSetChanged();
    }

    public void av(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.AG.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.AG.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.hMx.setData(arrayList);
        this.hMx.notifyDataSetChanged();
    }

    private void initialize() {
        this.hMt.setContentView(R.layout.im_black_list);
        this.mRoot = this.hMt.findViewById(R.id.root_view);
        this.fUO = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.AG = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.hMt.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.lh(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.hMx = new a(this.hMt);
        this.AG.setAdapter((ListAdapter) this.hMx);
        aHL();
    }

    private void aHL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hMt.getLayoutMode().setNightMode(skinType == 1);
        this.hMt.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hMt.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.hMt.getPageContext(), skinType);
        this.fUO.onChangeSkinType(this.hMt.getPageContext(), skinType);
    }
}
