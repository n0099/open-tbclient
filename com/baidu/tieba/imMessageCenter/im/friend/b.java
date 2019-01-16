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
    private View ano;
    private NoNetworkView drO;
    private IMBlackListActivity ffA;
    private a ffE;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.ffA = iMBlackListActivity;
        initialize();
    }

    public void Nw() {
        this.mProgress.setVisibility(0);
    }

    public void aWk() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.ffE.b(blackListItemData);
        if (this.ffE.getCount() <= 0) {
            this.OQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OQ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ffE.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.ffE.getCount() <= 0) {
            this.OQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OQ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ffE.notifyDataSetChanged();
    }

    public void Y(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.OQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OQ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ffE.setData(arrayList);
        this.ffE.notifyDataSetChanged();
    }

    private void initialize() {
        this.ffA.setContentView(e.h.im_black_list);
        this.ano = this.ffA.findViewById(e.g.root_view);
        this.drO = (NoNetworkView) this.ano.findViewById(e.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.ano.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.chat_black_list_title);
        this.OQ = (BdListView) this.ano.findViewById(e.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.ffA.getPageContext().getContext(), this.ano, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bja), NoDataViewFactory.d.eq(e.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.ano.findViewById(e.g.progress);
        this.ffE = new a(this.ffA);
        this.OQ.setAdapter((ListAdapter) this.ffE);
        Fw();
    }

    private void Fw() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ffA.getLayoutMode().setNightMode(skinType == 1);
        this.ffA.getLayoutMode().onModeChanged(this.ano);
        this.mNavigationBar.onChangeSkinType(this.ffA.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.ffA.getPageContext(), skinType);
        this.drO.onChangeSkinType(this.ffA.getPageContext(), skinType);
    }
}
