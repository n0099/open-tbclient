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
import com.baidu.tieba.f;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView LO;
    private View aaW;
    private NoNetworkView cSv;
    private IMBlackListActivity eEQ;
    private a eEU;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.eEQ = iMBlackListActivity;
        AC();
    }

    public void IA() {
        this.mProgress.setVisibility(0);
    }

    public void aOf() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.eEU.b(blackListItemData);
        if (this.eEU.getCount() <= 0) {
            this.LO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.LO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eEU.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.eEU.getCount() <= 0) {
            this.LO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.LO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eEU.notifyDataSetChanged();
    }

    public void Z(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.LO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.LO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eEU.setData(arrayList);
        this.eEU.notifyDataSetChanged();
    }

    private void AC() {
        this.eEQ.setContentView(f.h.im_black_list);
        this.aaW = this.eEQ.findViewById(f.g.root_view);
        this.cSv = (NoNetworkView) this.aaW.findViewById(f.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aaW.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(f.j.chat_black_list_title);
        this.LO = (BdListView) this.aaW.findViewById(f.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.eEQ.getPageContext().getContext(), this.aaW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aWi), NoDataViewFactory.d.dt(f.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.aaW.findViewById(f.g.progress);
        this.eEU = new a(this.eEQ);
        this.LO.setAdapter((ListAdapter) this.eEU);
        AD();
    }

    private void AD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eEQ.getLayoutMode().setNightMode(skinType == 1);
        this.eEQ.getLayoutMode().onModeChanged(this.aaW);
        this.mNavigationBar.onChangeSkinType(this.eEQ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eEQ.getPageContext(), skinType);
        this.cSv.onChangeSkinType(this.eEQ.getPageContext(), skinType);
    }
}
