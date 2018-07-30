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
    private BdListView LO;
    private View aaV;
    private NoNetworkView cSy;
    private IMBlackListActivity eEU;
    private a eEY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.eEU = iMBlackListActivity;
        AF();
    }

    public void IA() {
        this.mProgress.setVisibility(0);
    }

    public void aOi() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.eEY.b(blackListItemData);
        if (this.eEY.getCount() <= 0) {
            this.LO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.LO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eEY.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.eEY.getCount() <= 0) {
            this.LO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.LO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eEY.notifyDataSetChanged();
    }

    public void Z(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.LO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.LO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eEY.setData(arrayList);
        this.eEY.notifyDataSetChanged();
    }

    private void AF() {
        this.eEU.setContentView(d.h.im_black_list);
        this.aaV = this.eEU.findViewById(d.g.root_view);
        this.cSy = (NoNetworkView) this.aaV.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aaV.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.LO = (BdListView) this.aaV.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.eEU.getPageContext().getContext(), this.aaV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aWi), NoDataViewFactory.d.du(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.aaV.findViewById(d.g.progress);
        this.eEY = new a(this.eEU);
        this.LO.setAdapter((ListAdapter) this.eEY);
        AG();
    }

    private void AG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eEU.getLayoutMode().setNightMode(skinType == 1);
        this.eEU.getLayoutMode().onModeChanged(this.aaV);
        this.mNavigationBar.onChangeSkinType(this.eEU.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eEU.getPageContext(), skinType);
        this.cSy.onChangeSkinType(this.eEU.getPageContext(), skinType);
    }
}
