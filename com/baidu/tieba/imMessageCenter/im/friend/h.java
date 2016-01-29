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
    private BdListView IY;
    private View Sn;
    private ProgressBar aNo;
    private NoNetworkView aWk;
    private IMBlackListActivity ckU;
    private f ckZ;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.ckU = iMBlackListActivity;
        initialize();
    }

    public void DN() {
        this.aNo.setVisibility(0);
    }

    public void agX() {
        this.aNo.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.ckZ.b(aVar);
        if (this.ckZ.getCount() <= 0) {
            this.IY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.IY.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ckZ.notifyDataSetChanged();
    }

    public void Oh() {
        if (this.ckZ.getCount() <= 0) {
            this.IY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.IY.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ckZ.notifyDataSetChanged();
    }

    public void L(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.IY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.IY.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ckZ.setData(arrayList);
        this.ckZ.notifyDataSetChanged();
    }

    private void initialize() {
        this.ckU.setContentView(t.h.im_black_list);
        this.Sn = this.ckU.findViewById(t.g.root_view);
        this.aWk = (NoNetworkView) this.Sn.findViewById(t.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Sn.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(t.j.chat_black_list_title);
        this.IY = (BdListView) this.Sn.findViewById(t.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.ckU.getPageContext().getContext(), this.Sn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dd(t.j.black_list_no_data_text), null);
        this.aNo = (ProgressBar) this.Sn.findViewById(t.g.progress);
        this.ckZ = new f(this.ckU);
        this.IY.setAdapter((ListAdapter) this.ckZ);
        xf();
    }

    private void xf() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.ckU.getLayoutMode().ac(skinType == 1);
        this.ckU.getLayoutMode().x(this.Sn);
        this.mNavigationBar.onChangeSkinType(this.ckU.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.ckU.getPageContext(), skinType);
        this.aWk.onChangeSkinType(this.ckU.getPageContext(), skinType);
    }
}
