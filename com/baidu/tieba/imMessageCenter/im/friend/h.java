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
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.e<IMBlackListActivity> {
    private BdListView Ik;
    private View Rr;
    private NoNetworkView bEr;
    private f diD;
    private IMBlackListActivity diz;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private ProgressBar mProgress;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.diz = iMBlackListActivity;
        xk();
    }

    public void Eu() {
        this.mProgress.setVisibility(0);
    }

    public void aux() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.diD.b(blackListItemData);
        if (this.diD.getCount() <= 0) {
            this.Ik.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ik.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.diD.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.diD.getCount() <= 0) {
            this.Ik.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ik.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.diD.notifyDataSetChanged();
    }

    public void S(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Ik.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ik.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.diD.setData(arrayList);
        this.diD.notifyDataSetChanged();
    }

    private void xk() {
        this.diz.setContentView(w.j.im_black_list);
        this.Rr = this.diz.findViewById(w.h.root_view);
        this.bEr = (NoNetworkView) this.Rr.findViewById(w.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Rr.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(w.l.chat_black_list_title);
        this.Ik = (BdListView) this.Rr.findViewById(w.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.diz.getPageContext().getContext(), this.Rr, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aIT), NoDataViewFactory.d.dh(w.l.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Rr.findViewById(w.h.progress);
        this.diD = new f(this.diz);
        this.Ik.setAdapter((ListAdapter) this.diD);
        xl();
    }

    private void xl() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.diz.getLayoutMode().aj(skinType == 1);
        this.diz.getLayoutMode().t(this.Rr);
        this.mNavigationBar.onChangeSkinType(this.diz.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.diz.getPageContext(), skinType);
        this.bEr.onChangeSkinType(this.diz.getPageContext(), skinType);
    }
}
