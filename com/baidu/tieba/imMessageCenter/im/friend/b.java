package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView Ib;
    private View QE;
    private NoNetworkView bDI;
    private IMBlackListActivity dAL;
    private a dAP;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dAL = iMBlackListActivity;
        wU();
    }

    public void DY() {
        this.mProgress.setVisibility(0);
    }

    public void ayA() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dAP.b(blackListItemData);
        if (this.dAP.getCount() <= 0) {
            this.Ib.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ib.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dAP.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dAP.getCount() <= 0) {
            this.Ib.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ib.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dAP.notifyDataSetChanged();
    }

    public void T(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Ib.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ib.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dAP.setData(arrayList);
        this.dAP.notifyDataSetChanged();
    }

    private void wU() {
        this.dAL.setContentView(d.j.im_black_list);
        this.QE = this.dAL.findViewById(d.h.root_view);
        this.bDI = (NoNetworkView) this.QE.findViewById(d.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.QE.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.l.chat_black_list_title);
        this.Ib = (BdListView) this.QE.findViewById(d.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dAL.getPageContext().getContext(), this.QE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aLh), NoDataViewFactory.d.di(d.l.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.QE.findViewById(d.h.progress);
        this.dAP = new a(this.dAL);
        this.Ib.setAdapter((ListAdapter) this.dAP);
        wV();
    }

    private void wV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dAL.getLayoutMode().ah(skinType == 1);
        this.dAL.getLayoutMode().t(this.QE);
        this.mNavigationBar.onChangeSkinType(this.dAL.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dAL.getPageContext(), skinType);
        this.bDI.onChangeSkinType(this.dAL.getPageContext(), skinType);
    }
}
