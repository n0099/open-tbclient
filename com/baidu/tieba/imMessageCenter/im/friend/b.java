package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView FL;
    private View Tl;
    private NoNetworkView cHy;
    private IMBlackListActivity ekM;
    private a ekQ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.ekM = iMBlackListActivity;
        initialize();
    }

    public void EL() {
        this.mProgress.setVisibility(0);
    }

    public void aHJ() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.ekQ.b(blackListItemData);
        if (this.ekQ.getCount() <= 0) {
            this.FL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.FL.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ekQ.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.ekQ.getCount() <= 0) {
            this.FL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.FL.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ekQ.notifyDataSetChanged();
    }

    public void T(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.FL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.FL.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ekQ.setData(arrayList);
        this.ekQ.notifyDataSetChanged();
    }

    private void initialize() {
        this.ekM.setContentView(d.i.im_black_list);
        this.Tl = this.ekM.findViewById(d.g.root_view);
        this.cHy = (NoNetworkView) this.Tl.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Tl.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.chat_black_list_title);
        this.FL = (BdListView) this.Tl.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.ekM.getPageContext().getContext(), this.Tl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aNm), NoDataViewFactory.d.m16do(d.k.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Tl.findViewById(d.g.progress);
        this.ekQ = new a(this.ekM);
        this.FL.setAdapter((ListAdapter) this.ekQ);
        wY();
    }

    private void wY() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ekM.getLayoutMode().setNightMode(skinType == 1);
        this.ekM.getLayoutMode().u(this.Tl);
        this.mNavigationBar.onChangeSkinType(this.ekM.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.ekM.getPageContext(), skinType);
        this.cHy.onChangeSkinType(this.ekM.getPageContext(), skinType);
    }
}
