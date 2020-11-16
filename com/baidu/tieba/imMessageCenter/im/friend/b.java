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
/* loaded from: classes21.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView Wa;
    private NoNetworkView ghk;
    private IMBlackListActivity ksG;
    private a ksK;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.ksG = iMBlackListActivity;
        initialize();
    }

    public void bAg() {
        this.mProgress.setVisibility(0);
    }

    public void cVA() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.ksK.b(blackListItemData);
        if (this.ksK.getCount() <= 0) {
            this.Wa.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Wa.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ksK.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.ksK.getCount() <= 0) {
            this.Wa.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Wa.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ksK.notifyDataSetChanged();
    }

    public void aJ(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Wa.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Wa.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ksK.setData(arrayList);
        this.ksK.notifyDataSetChanged();
    }

    private void initialize() {
        this.ksG.setContentView(R.layout.im_black_list);
        this.mRoot = this.ksG.findViewById(R.id.root_view);
        this.ghk = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.Wa = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.ksG.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fxH), NoDataViewFactory.d.qo(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.ksK = new a(this.ksG);
        this.Wa.setAdapter((ListAdapter) this.ksK);
        brT();
    }

    private void brT() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ksG.getLayoutMode().setNightMode(skinType == 1);
        this.ksG.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.ksG.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.ksG.getPageContext(), skinType);
        this.ghk.onChangeSkinType(this.ksG.getPageContext(), skinType);
    }
}
