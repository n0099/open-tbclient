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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.f<IMBlackListActivity> {
    private BdListView Cj;
    private View MM;
    private NoNetworkView bmi;
    private ProgressBar coW;
    private IMBlackListActivity drP;
    private f drT;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.v mNoDataView;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.drP = iMBlackListActivity;
        initialize();
    }

    public void DV() {
        this.coW.setVisibility(0);
    }

    public void ayK() {
        this.coW.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.drT.b(aVar);
        if (this.drT.getCount() <= 0) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Cj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.drT.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.drT.getCount() <= 0) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Cj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.drT.notifyDataSetChanged();
    }

    public void X(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Cj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.drT.setData(arrayList);
        this.drT.notifyDataSetChanged();
    }

    private void initialize() {
        this.drP.setContentView(r.h.im_black_list);
        this.MM = this.drP.findViewById(r.g.root_view);
        this.bmi = (NoNetworkView) this.MM.findViewById(r.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.MM.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(r.j.chat_black_list_title);
        this.Cj = (BdListView) this.MM.findViewById(r.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.drP.getPageContext().getContext(), this.MM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aEg), NoDataViewFactory.d.de(r.j.black_list_no_data_text), null);
        this.coW = (ProgressBar) this.MM.findViewById(r.g.progress);
        this.drT = new f(this.drP);
        this.Cj.setAdapter((ListAdapter) this.drT);
        wH();
    }

    private void wH() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.drP.getLayoutMode().ah(skinType == 1);
        this.drP.getLayoutMode().x(this.MM);
        this.mNavigationBar.onChangeSkinType(this.drP.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.drP.getPageContext(), skinType);
        this.bmi.onChangeSkinType(this.drP.getPageContext(), skinType);
    }
}
