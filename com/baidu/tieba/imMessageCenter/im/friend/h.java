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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.f<IMBlackListActivity> {
    private View KA;
    private NoNetworkView bmB;
    private ProgressBar cdm;
    private IMBlackListActivity deL;
    private f deP;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private BdListView zU;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.deL = iMBlackListActivity;
        initialize();
    }

    public void CA() {
        this.cdm.setVisibility(0);
    }

    public void aty() {
        this.cdm.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.deP.b(aVar);
        if (this.deP.getCount() <= 0) {
            this.zU.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.zU.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.deP.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.deP.getCount() <= 0) {
            this.zU.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.zU.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.deP.notifyDataSetChanged();
    }

    public void X(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.zU.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.zU.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.deP.setData(arrayList);
        this.deP.notifyDataSetChanged();
    }

    private void initialize() {
        this.deL.setContentView(u.h.im_black_list);
        this.KA = this.deL.findViewById(u.g.root_view);
        this.bmB = (NoNetworkView) this.KA.findViewById(u.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.KA.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(u.j.chat_black_list_title);
        this.zU = (BdListView) this.KA.findViewById(u.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.deL.getPageContext().getContext(), this.KA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aBB), NoDataViewFactory.d.cQ(u.j.black_list_no_data_text), null);
        this.cdm = (ProgressBar) this.KA.findViewById(u.g.progress);
        this.deP = new f(this.deL);
        this.zU.setAdapter((ListAdapter) this.deP);
        vm();
    }

    private void vm() {
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        this.deL.getLayoutMode().af(skinType == 1);
        this.deL.getLayoutMode().w(this.KA);
        this.mNavigationBar.onChangeSkinType(this.deL.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.deL.getPageContext(), skinType);
        this.bmB.onChangeSkinType(this.deL.getPageContext(), skinType);
    }
}
