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
    private BdListView TX;
    private NoNetworkView gAG;
    private IMBlackListActivity ixY;
    private a iyc;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.ixY = iMBlackListActivity;
        initialize();
    }

    public void aXZ() {
        this.mProgress.setVisibility(0);
    }

    public void cjI() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.iyc.b(blackListItemData);
        if (this.iyc.getCount() <= 0) {
            this.TX.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.TX.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.iyc.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.iyc.getCount() <= 0) {
            this.TX.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.TX.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.iyc.notifyDataSetChanged();
    }

    public void ax(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.TX.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.TX.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.iyc.setData(arrayList);
        this.iyc.notifyDataSetChanged();
    }

    private void initialize() {
        this.ixY.setContentView(R.layout.im_black_list);
        this.mRoot = this.ixY.findViewById(R.id.root_view);
        this.gAG = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.TX = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.ixY.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.egw), NoDataViewFactory.d.lr(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.iyc = new a(this.ixY);
        this.TX.setAdapter((ListAdapter) this.iyc);
        aQp();
    }

    private void aQp() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ixY.getLayoutMode().setNightMode(skinType == 1);
        this.ixY.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.ixY.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.ixY.getPageContext(), skinType);
        this.gAG.onChangeSkinType(this.ixY.getPageContext(), skinType);
    }
}
