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
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView OE;
    private View aix;
    private NoNetworkView dgC;
    private IMBlackListActivity eTO;
    private a eTS;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.eTO = iMBlackListActivity;
        initialize();
    }

    public void LO() {
        this.mProgress.setVisibility(0);
    }

    public void aTI() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.eTS.b(blackListItemData);
        if (this.eTS.getCount() <= 0) {
            this.OE.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OE.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eTS.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.eTS.getCount() <= 0) {
            this.OE.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OE.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eTS.notifyDataSetChanged();
    }

    public void Z(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.OE.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OE.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eTS.setData(arrayList);
        this.eTS.notifyDataSetChanged();
    }

    private void initialize() {
        this.eTO.setContentView(e.h.im_black_list);
        this.aix = this.eTO.findViewById(e.g.root_view);
        this.dgC = (NoNetworkView) this.aix.findViewById(e.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aix.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.chat_black_list_title);
        this.OE = (BdListView) this.aix.findViewById(e.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.eTO.getPageContext().getContext(), this.aix, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bdY), NoDataViewFactory.d.dO(e.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.aix.findViewById(e.g.progress);
        this.eTS = new a(this.eTO);
        this.OE.setAdapter((ListAdapter) this.eTS);
        DV();
    }

    private void DV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eTO.getLayoutMode().setNightMode(skinType == 1);
        this.eTO.getLayoutMode().onModeChanged(this.aix);
        this.mNavigationBar.onChangeSkinType(this.eTO.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eTO.getPageContext(), skinType);
        this.dgC.onChangeSkinType(this.eTO.getPageContext(), skinType);
    }
}
