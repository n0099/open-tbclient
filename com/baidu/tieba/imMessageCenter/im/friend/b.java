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
    private BdListView Hj;
    private View Ry;
    private NoNetworkView cks;
    private IMBlackListActivity dPs;
    private a dPw;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dPs = iMBlackListActivity;
        wA();
    }

    public void Ec() {
        this.mProgress.setVisibility(0);
    }

    public void aCs() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dPw.b(blackListItemData);
        if (this.dPw.getCount() <= 0) {
            this.Hj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dPw.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dPw.getCount() <= 0) {
            this.Hj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dPw.notifyDataSetChanged();
    }

    public void R(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Hj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dPw.setData(arrayList);
        this.dPw.notifyDataSetChanged();
    }

    private void wA() {
        this.dPs.setContentView(d.h.im_black_list);
        this.Ry = this.dPs.findViewById(d.g.root_view);
        this.cks = (NoNetworkView) this.Ry.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Ry.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.Hj = (BdListView) this.Ry.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dPs.getPageContext().getContext(), this.Ry, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMh), NoDataViewFactory.d.dp(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Ry.findViewById(d.g.progress);
        this.dPw = new a(this.dPs);
        this.Hj.setAdapter((ListAdapter) this.dPw);
        wB();
    }

    private void wB() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dPs.getLayoutMode().ag(skinType == 1);
        this.dPs.getLayoutMode().t(this.Ry);
        this.mNavigationBar.onChangeSkinType(this.dPs.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dPs.getPageContext(), skinType);
        this.cks.onChangeSkinType(this.dPs.getPageContext(), skinType);
    }
}
