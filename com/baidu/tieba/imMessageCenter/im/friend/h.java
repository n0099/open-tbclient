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
    private BdListView Ib;
    private View Qr;
    private NoNetworkView bzB;
    private IMBlackListActivity dsj;
    private f dsn;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private ProgressBar mProgress;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dsj = iMBlackListActivity;
        wJ();
    }

    public void DM() {
        this.mProgress.setVisibility(0);
    }

    public void awX() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dsn.b(blackListItemData);
        if (this.dsn.getCount() <= 0) {
            this.Ib.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ib.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dsn.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dsn.getCount() <= 0) {
            this.Ib.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ib.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dsn.notifyDataSetChanged();
    }

    public void T(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Ib.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ib.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dsn.setData(arrayList);
        this.dsn.notifyDataSetChanged();
    }

    private void wJ() {
        this.dsj.setContentView(w.j.im_black_list);
        this.Qr = this.dsj.findViewById(w.h.root_view);
        this.bzB = (NoNetworkView) this.Qr.findViewById(w.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Qr.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(w.l.chat_black_list_title);
        this.Ib = (BdListView) this.Qr.findViewById(w.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dsj.getPageContext().getContext(), this.Qr, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aJZ), NoDataViewFactory.d.dg(w.l.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Qr.findViewById(w.h.progress);
        this.dsn = new f(this.dsj);
        this.Ib.setAdapter((ListAdapter) this.dsn);
        wK();
    }

    private void wK() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dsj.getLayoutMode().ah(skinType == 1);
        this.dsj.getLayoutMode().t(this.Qr);
        this.mNavigationBar.onChangeSkinType(this.dsj.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dsj.getPageContext(), skinType);
        this.bzB.onChangeSkinType(this.dsj.getPageContext(), skinType);
    }
}
