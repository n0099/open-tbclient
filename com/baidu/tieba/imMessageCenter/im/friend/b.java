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
    private BdListView LQ;
    private View abp;
    private NoNetworkView cRO;
    private IMBlackListActivity exk;
    private a exo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.exk = iMBlackListActivity;
        initialize();
    }

    public void In() {
        this.mProgress.setVisibility(0);
    }

    public void aMC() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.exo.b(blackListItemData);
        if (this.exo.getCount() <= 0) {
            this.LQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.LQ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.exo.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.exo.getCount() <= 0) {
            this.LQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.LQ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.exo.notifyDataSetChanged();
    }

    public void T(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.LQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.LQ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.exo.setData(arrayList);
        this.exo.notifyDataSetChanged();
    }

    private void initialize() {
        this.exk.setContentView(d.i.im_black_list);
        this.abp = this.exk.findViewById(d.g.root_view);
        this.cRO = (NoNetworkView) this.abp.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.abp.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.chat_black_list_title);
        this.LQ = (BdListView) this.abp.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.exk.getPageContext().getContext(), this.abp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aVl), NoDataViewFactory.d.dr(d.k.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.abp.findViewById(d.g.progress);
        this.exo = new a(this.exk);
        this.LQ.setAdapter((ListAdapter) this.exo);
        Ay();
    }

    private void Ay() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.exk.getLayoutMode().setNightMode(skinType == 1);
        this.exk.getLayoutMode().onModeChanged(this.abp);
        this.mNavigationBar.onChangeSkinType(this.exk.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.exk.getPageContext(), skinType);
        this.cRO.onChangeSkinType(this.exk.getPageContext(), skinType);
    }
}
