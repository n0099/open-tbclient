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
    private BdListView MR;
    private View bBg;
    private NoNetworkView eRV;
    private IMBlackListActivity gML;
    private a gMP;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.gML = iMBlackListActivity;
        initialize();
    }

    public void asa() {
        this.mProgress.setVisibility(0);
    }

    public void bEy() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.gMP.b(blackListItemData);
        if (this.gMP.getCount() <= 0) {
            this.MR.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.MR.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gMP.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.gMP.getCount() <= 0) {
            this.MR.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.MR.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gMP.notifyDataSetChanged();
    }

    public void ag(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.MR.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.MR.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gMP.setData(arrayList);
        this.gMP.notifyDataSetChanged();
    }

    private void initialize() {
        this.gML.setContentView(R.layout.im_black_list);
        this.bBg = this.gML.findViewById(R.id.root_view);
        this.eRV = (NoNetworkView) this.bBg.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.MR = (BdListView) this.bBg.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.gML.getPageContext().getContext(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cBi), NoDataViewFactory.d.iH(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.bBg.findViewById(R.id.progress);
        this.gMP = new a(this.gML);
        this.MR.setAdapter((ListAdapter) this.gMP);
        ajG();
    }

    private void ajG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gML.getLayoutMode().setNightMode(skinType == 1);
        this.gML.getLayoutMode().onModeChanged(this.bBg);
        this.mNavigationBar.onChangeSkinType(this.gML.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gML.getPageContext(), skinType);
        this.eRV.onChangeSkinType(this.gML.getPageContext(), skinType);
    }
}
