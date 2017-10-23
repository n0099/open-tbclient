package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView HO;
    private View Rh;
    private NoNetworkView ccF;
    private a dHD;
    private IMBlackListActivity dHz;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dHz = iMBlackListActivity;
        wt();
    }

    public void DB() {
        this.mProgress.setVisibility(0);
    }

    public void azT() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dHD.b(blackListItemData);
        if (this.dHD.getCount() <= 0) {
            this.HO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.HO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dHD.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dHD.getCount() <= 0) {
            this.HO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.HO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dHD.notifyDataSetChanged();
    }

    public void R(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.HO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.HO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dHD.setData(arrayList);
        this.dHD.notifyDataSetChanged();
    }

    private void wt() {
        this.dHz.setContentView(d.j.im_black_list);
        this.Rh = this.dHz.findViewById(d.h.root_view);
        this.ccF = (NoNetworkView) this.Rh.findViewById(d.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Rh.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.l.chat_black_list_title);
        this.HO = (BdListView) this.Rh.findViewById(d.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dHz.getPageContext().getContext(), this.Rh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aLq), NoDataViewFactory.d.dp(d.l.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Rh.findViewById(d.h.progress);
        this.dHD = new a(this.dHz);
        this.HO.setAdapter((ListAdapter) this.dHD);
        wu();
    }

    private void wu() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dHz.getLayoutMode().ah(skinType == 1);
        this.dHz.getLayoutMode().t(this.Rh);
        this.mNavigationBar.onChangeSkinType(this.dHz.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dHz.getPageContext(), skinType);
        this.ccF.onChangeSkinType(this.dHz.getPageContext(), skinType);
    }
}
