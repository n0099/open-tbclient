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
    private BdListView OQ;
    private View anp;
    private NoNetworkView drP;
    private IMBlackListActivity ffB;
    private a ffF;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.ffB = iMBlackListActivity;
        initialize();
    }

    public void Nw() {
        this.mProgress.setVisibility(0);
    }

    public void aWk() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.ffF.b(blackListItemData);
        if (this.ffF.getCount() <= 0) {
            this.OQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OQ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ffF.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.ffF.getCount() <= 0) {
            this.OQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OQ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ffF.notifyDataSetChanged();
    }

    public void Y(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.OQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OQ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ffF.setData(arrayList);
        this.ffF.notifyDataSetChanged();
    }

    private void initialize() {
        this.ffB.setContentView(e.h.im_black_list);
        this.anp = this.ffB.findViewById(e.g.root_view);
        this.drP = (NoNetworkView) this.anp.findViewById(e.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.anp.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.chat_black_list_title);
        this.OQ = (BdListView) this.anp.findViewById(e.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.ffB.getPageContext().getContext(), this.anp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bjb), NoDataViewFactory.d.eq(e.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.anp.findViewById(e.g.progress);
        this.ffF = new a(this.ffB);
        this.OQ.setAdapter((ListAdapter) this.ffF);
        Fw();
    }

    private void Fw() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ffB.getLayoutMode().setNightMode(skinType == 1);
        this.ffB.getLayoutMode().onModeChanged(this.anp);
        this.mNavigationBar.onChangeSkinType(this.ffB.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.ffB.getPageContext(), skinType);
        this.drP.onChangeSkinType(this.ffB.getPageContext(), skinType);
    }
}
