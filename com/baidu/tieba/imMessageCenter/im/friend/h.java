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
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.e<IMBlackListActivity> {
    private BdListView IK;
    private View QZ;
    private NoNetworkView bEy;
    private ProgressBar bqO;
    private IMBlackListActivity dka;
    private f dke;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dka = iMBlackListActivity;
        wO();
    }

    public void DW() {
        this.bqO.setVisibility(0);
    }

    public void auE() {
        this.bqO.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dke.b(blackListItemData);
        if (this.dke.getCount() <= 0) {
            this.IK.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.IK.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dke.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dke.getCount() <= 0) {
            this.IK.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.IK.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dke.notifyDataSetChanged();
    }

    public void S(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.IK.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.IK.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dke.setData(arrayList);
        this.dke.notifyDataSetChanged();
    }

    private void wO() {
        this.dka.setContentView(w.j.im_black_list);
        this.QZ = this.dka.findViewById(w.h.root_view);
        this.bEy = (NoNetworkView) this.QZ.findViewById(w.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.QZ.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(w.l.chat_black_list_title);
        this.IK = (BdListView) this.QZ.findViewById(w.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dka.getPageContext().getContext(), this.QZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aID), NoDataViewFactory.d.de(w.l.black_list_no_data_text), null);
        this.bqO = (ProgressBar) this.QZ.findViewById(w.h.progress);
        this.dke = new f(this.dka);
        this.IK.setAdapter((ListAdapter) this.dke);
        wP();
    }

    private void wP() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dka.getLayoutMode().ah(skinType == 1);
        this.dka.getLayoutMode().t(this.QZ);
        this.mNavigationBar.onChangeSkinType(this.dka.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dka.getPageContext(), skinType);
        this.bEy.onChangeSkinType(this.dka.getPageContext(), skinType);
    }
}
