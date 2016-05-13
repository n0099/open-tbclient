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
    private View KB;
    private NoNetworkView aWZ;
    private ProgressBar bDI;
    private f cwB;
    private IMBlackListActivity cwx;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private BdListView zu;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.cwx = iMBlackListActivity;
        vl();
    }

    public void Ct() {
        this.bDI.setVisibility(0);
    }

    public void akz() {
        this.bDI.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.cwB.b(aVar);
        if (this.cwB.getCount() <= 0) {
            this.zu.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.zu.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.cwB.notifyDataSetChanged();
    }

    public void OR() {
        if (this.cwB.getCount() <= 0) {
            this.zu.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.zu.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.cwB.notifyDataSetChanged();
    }

    public void L(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.zu.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.zu.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.cwB.setData(arrayList);
        this.cwB.notifyDataSetChanged();
    }

    private void vl() {
        this.cwx.setContentView(t.h.im_black_list);
        this.KB = this.cwx.findViewById(t.g.root_view);
        this.aWZ = (NoNetworkView) this.KB.findViewById(t.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.KB.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(t.j.chat_black_list_title);
        this.zu = (BdListView) this.KB.findViewById(t.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.cwx.getPageContext().getContext(), this.KB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.azU), NoDataViewFactory.d.cO(t.j.black_list_no_data_text), null);
        this.bDI = (ProgressBar) this.KB.findViewById(t.g.progress);
        this.cwB = new f(this.cwx);
        this.zu.setAdapter((ListAdapter) this.cwB);
        vm();
    }

    private void vm() {
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        this.cwx.getLayoutMode().ae(skinType == 1);
        this.cwx.getLayoutMode().x(this.KB);
        this.mNavigationBar.onChangeSkinType(this.cwx.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.cwx.getPageContext(), skinType);
        this.aWZ.onChangeSkinType(this.cwx.getPageContext(), skinType);
    }
}
