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
    private View KB;
    private NoNetworkView bkT;
    private ProgressBar cbl;
    private IMBlackListActivity dbN;
    private f dbR;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private BdListView zt;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dbN = iMBlackListActivity;
        initialize();
    }

    public void CB() {
        this.cbl.setVisibility(0);
    }

    public void asM() {
        this.cbl.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.dbR.b(aVar);
        if (this.dbR.getCount() <= 0) {
            this.zt.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.zt.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dbR.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dbR.getCount() <= 0) {
            this.zt.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.zt.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dbR.notifyDataSetChanged();
    }

    public void V(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.zt.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.zt.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dbR.setData(arrayList);
        this.dbR.notifyDataSetChanged();
    }

    private void initialize() {
        this.dbN.setContentView(u.h.im_black_list);
        this.KB = this.dbN.findViewById(u.g.root_view);
        this.bkT = (NoNetworkView) this.KB.findViewById(u.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.KB.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(u.j.chat_black_list_title);
        this.zt = (BdListView) this.KB.findViewById(u.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dbN.getPageContext().getContext(), this.KB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aAL), NoDataViewFactory.d.cQ(u.j.black_list_no_data_text), null);
        this.cbl = (ProgressBar) this.KB.findViewById(u.g.progress);
        this.dbR = new f(this.dbN);
        this.zt.setAdapter((ListAdapter) this.dbR);
        vm();
    }

    private void vm() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dbN.getLayoutMode().ad(skinType == 1);
        this.dbN.getLayoutMode().w(this.KB);
        this.mNavigationBar.onChangeSkinType(this.dbN.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dbN.getPageContext(), skinType);
        this.bkT.onChangeSkinType(this.dbN.getPageContext(), skinType);
    }
}
