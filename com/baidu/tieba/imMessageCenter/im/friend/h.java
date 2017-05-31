package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.base.e<IMBlackListActivity> {
    private BdListView Ic;
    private View Qx;
    private NoNetworkView byr;
    private IMBlackListActivity dkn;
    private f dkr;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private ProgressBar mProgress;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dkn = iMBlackListActivity;
        wr();
    }

    public void Ds() {
        this.mProgress.setVisibility(0);
    }

    public void atp() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dkr.b(blackListItemData);
        if (this.dkr.getCount() <= 0) {
            this.Ic.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ic.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dkr.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dkr.getCount() <= 0) {
            this.Ic.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ic.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dkr.notifyDataSetChanged();
    }

    public void R(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Ic.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ic.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dkr.setData(arrayList);
        this.dkr.notifyDataSetChanged();
    }

    private void wr() {
        this.dkn.setContentView(w.j.im_black_list);
        this.Qx = this.dkn.findViewById(w.h.root_view);
        this.byr = (NoNetworkView) this.Qx.findViewById(w.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Qx.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(w.l.chat_black_list_title);
        this.Ic = (BdListView) this.Qx.findViewById(w.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dkn.getPageContext().getContext(), this.Qx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aIK), NoDataViewFactory.d.de(w.l.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Qx.findViewById(w.h.progress);
        this.dkr = new f(this.dkn);
        this.Ic.setAdapter((ListAdapter) this.dkr);
        ws();
    }

    private void ws() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dkn.getLayoutMode().ah(skinType == 1);
        this.dkn.getLayoutMode().t(this.Qx);
        this.mNavigationBar.onChangeSkinType(this.dkn.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dkn.getPageContext(), skinType);
        this.byr.onChangeSkinType(this.dkn.getPageContext(), skinType);
    }
}
