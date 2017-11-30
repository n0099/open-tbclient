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
    private BdListView Hj;
    private View Sh;
    private NoNetworkView csW;
    private IMBlackListActivity dXh;
    private a dXl;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dXh = iMBlackListActivity;
        wD();
    }

    public void Ek() {
        this.mProgress.setVisibility(0);
    }

    public void aDS() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dXl.b(blackListItemData);
        if (this.dXl.getCount() <= 0) {
            this.Hj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dXl.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dXl.getCount() <= 0) {
            this.Hj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dXl.notifyDataSetChanged();
    }

    public void R(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Hj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dXl.setData(arrayList);
        this.dXl.notifyDataSetChanged();
    }

    private void wD() {
        this.dXh.setContentView(d.h.im_black_list);
        this.Sh = this.dXh.findViewById(d.g.root_view);
        this.csW = (NoNetworkView) this.Sh.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Sh.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.Hj = (BdListView) this.Sh.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dXh.getPageContext().getContext(), this.Sh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMI), NoDataViewFactory.d.dq(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Sh.findViewById(d.g.progress);
        this.dXl = new a(this.dXh);
        this.Hj.setAdapter((ListAdapter) this.dXl);
        wE();
    }

    private void wE() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dXh.getLayoutMode().ag(skinType == 1);
        this.dXh.getLayoutMode().t(this.Sh);
        this.mNavigationBar.onChangeSkinType(this.dXh.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dXh.getPageContext(), skinType);
        this.csW.onChangeSkinType(this.dXh.getPageContext(), skinType);
    }
}
