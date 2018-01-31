package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private View aGK;
    private BdListView avm;
    private NoNetworkView dmD;
    private IMBlackListActivity eMo;
    private a eMs;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.eMo = iMBlackListActivity;
        DS();
    }

    public void LC() {
        this.mProgress.setVisibility(0);
    }

    public void aLm() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.eMs.b(blackListItemData);
        if (this.eMs.getCount() <= 0) {
            this.avm.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.avm.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eMs.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.eMs.getCount() <= 0) {
            this.avm.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.avm.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eMs.notifyDataSetChanged();
    }

    public void S(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.avm.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.avm.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eMs.setData(arrayList);
        this.eMs.notifyDataSetChanged();
    }

    private void DS() {
        this.eMo.setContentView(d.h.im_black_list);
        this.aGK = this.eMo.findViewById(d.g.root_view);
        this.dmD = (NoNetworkView) this.aGK.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aGK.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.avm = (BdListView) this.aGK.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.eMo.getPageContext().getContext(), this.aGK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bAS), NoDataViewFactory.d.gn(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.aGK.findViewById(d.g.progress);
        this.eMs = new a(this.eMo);
        this.avm.setAdapter((ListAdapter) this.eMs);
        DT();
    }

    private void DT() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eMo.getLayoutMode().aN(skinType == 1);
        this.eMo.getLayoutMode().aM(this.aGK);
        this.mNavigationBar.onChangeSkinType(this.eMo.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eMo.getPageContext(), skinType);
        this.dmD.onChangeSkinType(this.eMo.getPageContext(), skinType);
    }
}
