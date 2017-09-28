package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView HN;
    private View Rt;
    private NoNetworkView ccR;
    private IMBlackListActivity dHN;
    private a dHR;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dHN = iMBlackListActivity;
        wA();
    }

    public void DH() {
        this.mProgress.setVisibility(0);
    }

    public void azY() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dHR.b(blackListItemData);
        if (this.dHR.getCount() <= 0) {
            this.HN.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.HN.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dHR.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dHR.getCount() <= 0) {
            this.HN.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.HN.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dHR.notifyDataSetChanged();
    }

    public void R(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.HN.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.HN.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dHR.setData(arrayList);
        this.dHR.notifyDataSetChanged();
    }

    private void wA() {
        this.dHN.setContentView(d.j.im_black_list);
        this.Rt = this.dHN.findViewById(d.h.root_view);
        this.ccR = (NoNetworkView) this.Rt.findViewById(d.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Rt.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.l.chat_black_list_title);
        this.HN = (BdListView) this.Rt.findViewById(d.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dHN.getPageContext().getContext(), this.Rt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aLD), NoDataViewFactory.d.dq(d.l.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Rt.findViewById(d.h.progress);
        this.dHR = new a(this.dHN);
        this.HN.setAdapter((ListAdapter) this.dHR);
        wB();
    }

    private void wB() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dHN.getLayoutMode().ai(skinType == 1);
        this.dHN.getLayoutMode().t(this.Rt);
        this.mNavigationBar.onChangeSkinType(this.dHN.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dHN.getPageContext(), skinType);
        this.ccR.onChangeSkinType(this.dHN.getPageContext(), skinType);
    }
}
