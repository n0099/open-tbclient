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
/* loaded from: classes16.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView UL;
    private NoNetworkView fqQ;
    private IMBlackListActivity jmX;
    private a jnb;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.jmX = iMBlackListActivity;
        initialize();
    }

    public void bjX() {
        this.mProgress.setVisibility(0);
    }

    public void cyg() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.jnb.b(blackListItemData);
        if (this.jnb.getCount() <= 0) {
            this.UL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.UL.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jnb.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.jnb.getCount() <= 0) {
            this.UL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.UL.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jnb.notifyDataSetChanged();
    }

    public void az(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.UL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.UL.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jnb.setData(arrayList);
        this.jnb.notifyDataSetChanged();
    }

    private void initialize() {
        this.jmX.setContentView(R.layout.im_black_list);
        this.mRoot = this.jmX.findViewById(R.id.root_view);
        this.fqQ = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.UL = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.jmX.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eKp), NoDataViewFactory.d.mF(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.jnb = new a(this.jmX);
        this.UL.setAdapter((ListAdapter) this.jnb);
        bci();
    }

    private void bci() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jmX.getLayoutMode().setNightMode(skinType == 1);
        this.jmX.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jmX.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.jmX.getPageContext(), skinType);
        this.fqQ.onChangeSkinType(this.jmX.getPageContext(), skinType);
    }
}
