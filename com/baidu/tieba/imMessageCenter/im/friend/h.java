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
    private BdListView Ck;
    private View MJ;
    private ProgressBar ban;
    private NoNetworkView bpG;
    private IMBlackListActivity dau;
    private f daz;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mNoDataView;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dau = iMBlackListActivity;
        ww();
    }

    public void DI() {
        this.ban.setVisibility(0);
    }

    public void aud() {
        this.ban.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.daz.b(aVar);
        if (this.daz.getCount() <= 0) {
            this.Ck.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ck.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.daz.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.daz.getCount() <= 0) {
            this.Ck.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ck.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.daz.notifyDataSetChanged();
    }

    public void Q(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Ck.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ck.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.daz.setData(arrayList);
        this.daz.notifyDataSetChanged();
    }

    private void ww() {
        this.dau.setContentView(r.h.im_black_list);
        this.MJ = this.dau.findViewById(r.g.root_view);
        this.bpG = (NoNetworkView) this.MJ.findViewById(r.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.MJ.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(r.j.chat_black_list_title);
        this.Ck = (BdListView) this.MJ.findViewById(r.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dau.getPageContext().getContext(), this.MJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aEq), NoDataViewFactory.d.dh(r.j.black_list_no_data_text), null);
        this.ban = (ProgressBar) this.MJ.findViewById(r.g.progress);
        this.daz = new f(this.dau);
        this.Ck.setAdapter((ListAdapter) this.daz);
        wx();
    }

    private void wx() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dau.getLayoutMode().ai(skinType == 1);
        this.dau.getLayoutMode().x(this.MJ);
        this.mNavigationBar.onChangeSkinType(this.dau.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dau.getPageContext(), skinType);
        this.bpG.onChangeSkinType(this.dau.getPageContext(), skinType);
    }
}
