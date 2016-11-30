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
    private NoNetworkView bpe;
    private ProgressBar cub;
    private f dxA;
    private IMBlackListActivity dxw;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mNoDataView;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dxw = iMBlackListActivity;
        initialize();
    }

    public void Ea() {
        this.cub.setVisibility(0);
    }

    public void aAH() {
        this.cub.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.dxA.b(aVar);
        if (this.dxA.getCount() <= 0) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Cj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dxA.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dxA.getCount() <= 0) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Cj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dxA.notifyDataSetChanged();
    }

    public void aa(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Cj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dxA.setData(arrayList);
        this.dxA.notifyDataSetChanged();
    }

    private void initialize() {
        this.dxw.setContentView(r.h.im_black_list);
        this.MM = this.dxw.findViewById(r.g.root_view);
        this.bpe = (NoNetworkView) this.MM.findViewById(r.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.MM.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(r.j.chat_black_list_title);
        this.Cj = (BdListView) this.MM.findViewById(r.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dxw.getPageContext().getContext(), this.MM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aEW), NoDataViewFactory.d.df(r.j.black_list_no_data_text), null);
        this.cub = (ProgressBar) this.MM.findViewById(r.g.progress);
        this.dxA = new f(this.dxw);
        this.Cj.setAdapter((ListAdapter) this.dxA);
        wM();
    }

    private void wM() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dxw.getLayoutMode().ai(skinType == 1);
        this.dxw.getLayoutMode().x(this.MM);
        this.mNavigationBar.onChangeSkinType(this.dxw.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dxw.getPageContext(), skinType);
        this.bpe.onChangeSkinType(this.dxw.getPageContext(), skinType);
    }
}
