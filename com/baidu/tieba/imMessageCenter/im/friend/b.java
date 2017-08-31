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
    private NoNetworkView bIw;
    private IMBlackListActivity dKD;
    private a dKH;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dKD = iMBlackListActivity;
        xb();
    }

    public void Ed() {
        this.mProgress.setVisibility(0);
    }

    public void aBc() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dKH.b(blackListItemData);
        if (this.dKH.getCount() <= 0) {
            this.Hw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hw.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dKH.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dKH.getCount() <= 0) {
            this.Hw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hw.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dKH.notifyDataSetChanged();
    }

    public void T(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Hw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hw.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dKH.setData(arrayList);
        this.dKH.notifyDataSetChanged();
    }

    private void xb() {
        this.dKD.setContentView(d.j.im_black_list);
        this.Rh = this.dKD.findViewById(d.h.root_view);
        this.bIw = (NoNetworkView) this.Rh.findViewById(d.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Rh.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.l.chat_black_list_title);
        this.Hw = (BdListView) this.Rh.findViewById(d.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dKD.getPageContext().getContext(), this.Rh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMe), NoDataViewFactory.d.dl(d.l.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Rh.findViewById(d.h.progress);
        this.dKH = new a(this.dKD);
        this.Hw.setAdapter((ListAdapter) this.dKH);
        xc();
    }

    private void xc() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dKD.getLayoutMode().ah(skinType == 1);
        this.dKD.getLayoutMode().t(this.Rh);
        this.mNavigationBar.onChangeSkinType(this.dKD.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dKD.getPageContext(), skinType);
        this.bIw.onChangeSkinType(this.dKD.getPageContext(), skinType);
    }
}
