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
    private BdListView Hw;
    private View Rh;
    private NoNetworkView bJn;
    private a dLC;
    private IMBlackListActivity dLy;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dLy = iMBlackListActivity;
        xb();
    }

    public void Ed() {
        this.mProgress.setVisibility(0);
    }

    public void aBn() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dLC.b(blackListItemData);
        if (this.dLC.getCount() <= 0) {
            this.Hw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hw.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dLC.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dLC.getCount() <= 0) {
            this.Hw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hw.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dLC.notifyDataSetChanged();
    }

    public void T(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Hw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hw.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dLC.setData(arrayList);
        this.dLC.notifyDataSetChanged();
    }

    private void xb() {
        this.dLy.setContentView(d.j.im_black_list);
        this.Rh = this.dLy.findViewById(d.h.root_view);
        this.bJn = (NoNetworkView) this.Rh.findViewById(d.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Rh.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.l.chat_black_list_title);
        this.Hw = (BdListView) this.Rh.findViewById(d.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dLy.getPageContext().getContext(), this.Rh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMb), NoDataViewFactory.d.dl(d.l.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Rh.findViewById(d.h.progress);
        this.dLC = new a(this.dLy);
        this.Hw.setAdapter((ListAdapter) this.dLC);
        xc();
    }

    private void xc() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dLy.getLayoutMode().ah(skinType == 1);
        this.dLy.getLayoutMode().t(this.Rh);
        this.mNavigationBar.onChangeSkinType(this.dLy.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dLy.getPageContext(), skinType);
        this.bJn.onChangeSkinType(this.dLy.getPageContext(), skinType);
    }
}
