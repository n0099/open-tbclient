package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView Hh;
    private View Se;
    private NoNetworkView ctf;
    private IMBlackListActivity dYm;
    private a dYq;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dYm = iMBlackListActivity;
        wB();
    }

    public void El() {
        this.mProgress.setVisibility(0);
    }

    public void aEb() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dYq.b(blackListItemData);
        if (this.dYq.getCount() <= 0) {
            this.Hh.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hh.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dYq.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dYq.getCount() <= 0) {
            this.Hh.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hh.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dYq.notifyDataSetChanged();
    }

    public void S(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Hh.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hh.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dYq.setData(arrayList);
        this.dYq.notifyDataSetChanged();
    }

    private void wB() {
        this.dYm.setContentView(d.h.im_black_list);
        this.Se = this.dYm.findViewById(d.g.root_view);
        this.ctf = (NoNetworkView) this.Se.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Se.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.Hh = (BdListView) this.Se.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dYm.getPageContext().getContext(), this.Se, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aML), NoDataViewFactory.d.dq(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Se.findViewById(d.g.progress);
        this.dYq = new a(this.dYm);
        this.Hh.setAdapter((ListAdapter) this.dYq);
        wC();
    }

    private void wC() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dYm.getLayoutMode().ag(skinType == 1);
        this.dYm.getLayoutMode().t(this.Se);
        this.mNavigationBar.onChangeSkinType(this.dYm.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dYm.getPageContext(), skinType);
        this.ctf.onChangeSkinType(this.dYm.getPageContext(), skinType);
    }
}
