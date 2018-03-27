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
    private View aHT;
    private BdListView auZ;
    private NoNetworkView dpl;
    private IMBlackListActivity eQA;
    private a eQE;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.eQA = iMBlackListActivity;
        Em();
    }

    public void Mi() {
        this.mProgress.setVisibility(0);
    }

    public void aMO() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.eQE.b(blackListItemData);
        if (this.eQE.getCount() <= 0) {
            this.auZ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.auZ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eQE.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.eQE.getCount() <= 0) {
            this.auZ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.auZ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eQE.notifyDataSetChanged();
    }

    public void S(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.auZ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.auZ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eQE.setData(arrayList);
        this.eQE.notifyDataSetChanged();
    }

    private void Em() {
        this.eQA.setContentView(d.h.im_black_list);
        this.aHT = this.eQA.findViewById(d.g.root_view);
        this.dpl = (NoNetworkView) this.aHT.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aHT.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.auZ = (BdListView) this.aHT.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.eQA.getPageContext().getContext(), this.aHT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bCM), NoDataViewFactory.d.gp(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.aHT.findViewById(d.g.progress);
        this.eQE = new a(this.eQA);
        this.auZ.setAdapter((ListAdapter) this.eQE);
        En();
    }

    private void En() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eQA.getLayoutMode().aQ(skinType == 1);
        this.eQA.getLayoutMode().aM(this.aHT);
        this.mNavigationBar.onChangeSkinType(this.eQA.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eQA.getPageContext(), skinType);
        this.dpl.onChangeSkinType(this.eQA.getPageContext(), skinType);
    }
}
