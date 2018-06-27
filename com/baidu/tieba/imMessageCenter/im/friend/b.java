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
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView LS;
    private View abt;
    private NoNetworkView cPM;
    private IMBlackListActivity eBb;
    private a eBf;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.eBb = iMBlackListActivity;
        initialize();
    }

    public void IF() {
        this.mProgress.setVisibility(0);
    }

    public void aNi() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.eBf.b(blackListItemData);
        if (this.eBf.getCount() <= 0) {
            this.LS.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.LS.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eBf.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.eBf.getCount() <= 0) {
            this.LS.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.LS.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eBf.notifyDataSetChanged();
    }

    public void Z(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.LS.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.LS.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eBf.setData(arrayList);
        this.eBf.notifyDataSetChanged();
    }

    private void initialize() {
        this.eBb.setContentView(d.i.im_black_list);
        this.abt = this.eBb.findViewById(d.g.root_view);
        this.cPM = (NoNetworkView) this.abt.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.abt.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.chat_black_list_title);
        this.LS = (BdListView) this.abt.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.eBb.getPageContext().getContext(), this.abt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aWg), NoDataViewFactory.d.ds(d.k.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.abt.findViewById(d.g.progress);
        this.eBf = new a(this.eBb);
        this.LS.setAdapter((ListAdapter) this.eBf);
        AP();
    }

    private void AP() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eBb.getLayoutMode().setNightMode(skinType == 1);
        this.eBb.getLayoutMode().onModeChanged(this.abt);
        this.mNavigationBar.onChangeSkinType(this.eBb.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eBb.getPageContext(), skinType);
        this.cPM.onChangeSkinType(this.eBb.getPageContext(), skinType);
    }
}
