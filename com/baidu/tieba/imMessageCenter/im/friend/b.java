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
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView OF;
    private View ajk;
    private NoNetworkView dhH;
    private IMBlackListActivity eVh;
    private a eVl;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.eVh = iMBlackListActivity;
        initialize();
    }

    public void Ma() {
        this.mProgress.setVisibility(0);
    }

    public void aTf() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.eVl.b(blackListItemData);
        if (this.eVl.getCount() <= 0) {
            this.OF.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OF.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eVl.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.eVl.getCount() <= 0) {
            this.OF.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OF.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eVl.notifyDataSetChanged();
    }

    public void Y(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.OF.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OF.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eVl.setData(arrayList);
        this.eVl.notifyDataSetChanged();
    }

    private void initialize() {
        this.eVh.setContentView(e.h.im_black_list);
        this.ajk = this.eVh.findViewById(e.g.root_view);
        this.dhH = (NoNetworkView) this.ajk.findViewById(e.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.ajk.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.chat_black_list_title);
        this.OF = (BdListView) this.ajk.findViewById(e.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.eVh.getPageContext().getContext(), this.ajk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.beN), NoDataViewFactory.d.ec(e.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.ajk.findViewById(e.g.progress);
        this.eVl = new a(this.eVh);
        this.OF.setAdapter((ListAdapter) this.eVl);
        Ef();
    }

    private void Ef() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eVh.getLayoutMode().setNightMode(skinType == 1);
        this.eVh.getLayoutMode().onModeChanged(this.ajk);
        this.mNavigationBar.onChangeSkinType(this.eVh.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eVh.getPageContext(), skinType);
        this.dhH.onChangeSkinType(this.eVh.getPageContext(), skinType);
    }
}
