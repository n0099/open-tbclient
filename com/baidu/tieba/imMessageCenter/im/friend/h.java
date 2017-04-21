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
    private BdListView Im;
    private View Rt;
    private NoNetworkView bGI;
    private IMBlackListActivity dkQ;
    private f dkU;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private ProgressBar mProgress;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dkQ = iMBlackListActivity;
        xk();
    }

    public void Eu() {
        this.mProgress.setVisibility(0);
    }

    public void avy() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dkU.b(blackListItemData);
        if (this.dkU.getCount() <= 0) {
            this.Im.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Im.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dkU.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dkU.getCount() <= 0) {
            this.Im.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Im.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dkU.notifyDataSetChanged();
    }

    public void S(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Im.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Im.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dkU.setData(arrayList);
        this.dkU.notifyDataSetChanged();
    }

    private void xk() {
        this.dkQ.setContentView(w.j.im_black_list);
        this.Rt = this.dkQ.findViewById(w.h.root_view);
        this.bGI = (NoNetworkView) this.Rt.findViewById(w.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Rt.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(w.l.chat_black_list_title);
        this.Im = (BdListView) this.Rt.findViewById(w.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dkQ.getPageContext().getContext(), this.Rt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aIV), NoDataViewFactory.d.dh(w.l.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Rt.findViewById(w.h.progress);
        this.dkU = new f(this.dkQ);
        this.Im.setAdapter((ListAdapter) this.dkU);
        xl();
    }

    private void xl() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dkQ.getLayoutMode().aj(skinType == 1);
        this.dkQ.getLayoutMode().t(this.Rt);
        this.mNavigationBar.onChangeSkinType(this.dkQ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dkQ.getPageContext(), skinType);
        this.bGI.onChangeSkinType(this.dkQ.getPageContext(), skinType);
    }
}
