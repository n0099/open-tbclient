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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.f<IMBlackListActivity> {
    private BdListView Cj;
    private View MN;
    private NoNetworkView blV;
    private ProgressBar coz;
    private IMBlackListActivity dqs;
    private f dqw;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dqs = iMBlackListActivity;
        initialize();
    }

    public void DV() {
        this.coz.setVisibility(0);
    }

    public void aym() {
        this.coz.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.dqw.b(aVar);
        if (this.dqw.getCount() <= 0) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Cj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dqw.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dqw.getCount() <= 0) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Cj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dqw.notifyDataSetChanged();
    }

    public void X(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Cj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dqw.setData(arrayList);
        this.dqw.notifyDataSetChanged();
    }

    private void initialize() {
        this.dqs.setContentView(t.h.im_black_list);
        this.MN = this.dqs.findViewById(t.g.root_view);
        this.blV = (NoNetworkView) this.MN.findViewById(t.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.MN.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(t.j.chat_black_list_title);
        this.Cj = (BdListView) this.MN.findViewById(t.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dqs.getPageContext().getContext(), this.MN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aEI), NoDataViewFactory.d.de(t.j.black_list_no_data_text), null);
        this.coz = (ProgressBar) this.MN.findViewById(t.g.progress);
        this.dqw = new f(this.dqs);
        this.Cj.setAdapter((ListAdapter) this.dqw);
        wq();
    }

    private void wq() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dqs.getLayoutMode().ah(skinType == 1);
        this.dqs.getLayoutMode().x(this.MN);
        this.mNavigationBar.onChangeSkinType(this.dqs.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dqs.getPageContext(), skinType);
        this.blV.onChangeSkinType(this.dqs.getPageContext(), skinType);
    }
}
