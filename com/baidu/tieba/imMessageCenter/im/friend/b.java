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
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView Op;
    private View adA;
    private NoNetworkView cYm;
    private IMBlackListActivity eMg;
    private a eMk;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.eMg = iMBlackListActivity;
        BP();
    }

    public void JQ() {
        this.mProgress.setVisibility(0);
    }

    public void aQu() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.eMk.b(blackListItemData);
        if (this.eMk.getCount() <= 0) {
            this.Op.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Op.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eMk.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.eMk.getCount() <= 0) {
            this.Op.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Op.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eMk.notifyDataSetChanged();
    }

    public void Z(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Op.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Op.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eMk.setData(arrayList);
        this.eMk.notifyDataSetChanged();
    }

    private void BP() {
        this.eMg.setContentView(e.h.im_black_list);
        this.adA = this.eMg.findViewById(e.g.root_view);
        this.cYm = (NoNetworkView) this.adA.findViewById(e.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.adA.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.chat_black_list_title);
        this.Op = (BdListView) this.adA.findViewById(e.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.eMg.getPageContext().getContext(), this.adA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aZy), NoDataViewFactory.d.dE(e.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.adA.findViewById(e.g.progress);
        this.eMk = new a(this.eMg);
        this.Op.setAdapter((ListAdapter) this.eMk);
        BQ();
    }

    private void BQ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eMg.getLayoutMode().setNightMode(skinType == 1);
        this.eMg.getLayoutMode().onModeChanged(this.adA);
        this.mNavigationBar.onChangeSkinType(this.eMg.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eMg.getPageContext(), skinType);
        this.cYm.onChangeSkinType(this.eMg.getPageContext(), skinType);
    }
}
