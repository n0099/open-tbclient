package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.f<IMBlackListActivity> {
    private BdListView Je;
    private View PL;
    private ProgressBar aQj;
    private NoNetworkView baT;
    private IMBlackListActivity cvA;
    private f cvE;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.p mNoDataView;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.cvA = iMBlackListActivity;
        initialize();
    }

    public void Ez() {
        this.aQj.setVisibility(0);
    }

    public void akr() {
        this.aQj.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.cvE.b(aVar);
        if (this.cvE.getCount() <= 0) {
            this.Je.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Je.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.cvE.notifyDataSetChanged();
    }

    public void PW() {
        if (this.cvE.getCount() <= 0) {
            this.Je.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Je.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.cvE.notifyDataSetChanged();
    }

    public void K(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Je.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Je.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.cvE.setData(arrayList);
        this.cvE.notifyDataSetChanged();
    }

    private void initialize() {
        this.cvA.setContentView(t.h.im_black_list);
        this.PL = this.cvA.findViewById(t.g.root_view);
        this.baT = (NoNetworkView) this.PL.findViewById(t.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.PL.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(t.j.chat_black_list_title);
        this.Je = (BdListView) this.PL.findViewById(t.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.cvA.getPageContext().getContext(), this.PL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dg(t.j.black_list_no_data_text), null);
        this.aQj = (ProgressBar) this.PL.findViewById(t.g.progress);
        this.cvE = new f(this.cvA);
        this.Je.setAdapter((ListAdapter) this.cvE);
        xy();
    }

    private void xy() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.cvA.getLayoutMode().ab(skinType == 1);
        this.cvA.getLayoutMode().x(this.PL);
        this.mNavigationBar.onChangeSkinType(this.cvA.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.cvA.getPageContext(), skinType);
        this.baT.onChangeSkinType(this.cvA.getPageContext(), skinType);
    }
}
