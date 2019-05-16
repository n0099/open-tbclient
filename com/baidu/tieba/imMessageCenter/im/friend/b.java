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
    private BdListView MS;
    private View bBg;
    private NoNetworkView eRU;
    private IMBlackListActivity gMI;
    private a gMM;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.gMI = iMBlackListActivity;
        initialize();
    }

    public void asa() {
        this.mProgress.setVisibility(0);
    }

    public void bEu() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.gMM.b(blackListItemData);
        if (this.gMM.getCount() <= 0) {
            this.MS.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.MS.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gMM.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.gMM.getCount() <= 0) {
            this.MS.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.MS.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gMM.notifyDataSetChanged();
    }

    public void ag(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.MS.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.MS.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gMM.setData(arrayList);
        this.gMM.notifyDataSetChanged();
    }

    private void initialize() {
        this.gMI.setContentView(R.layout.im_black_list);
        this.bBg = this.gMI.findViewById(R.id.root_view);
        this.eRU = (NoNetworkView) this.bBg.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.MS = (BdListView) this.bBg.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.gMI.getPageContext().getContext(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cBh), NoDataViewFactory.d.iH(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.bBg.findViewById(R.id.progress);
        this.gMM = new a(this.gMI);
        this.MS.setAdapter((ListAdapter) this.gMM);
        ajG();
    }

    private void ajG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gMI.getLayoutMode().setNightMode(skinType == 1);
        this.gMI.getLayoutMode().onModeChanged(this.bBg);
        this.mNavigationBar.onChangeSkinType(this.gMI.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gMI.getPageContext(), skinType);
        this.eRU.onChangeSkinType(this.gMI.getPageContext(), skinType);
    }
}
