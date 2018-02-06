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
    private View aId;
    private BdListView avh;
    private NoNetworkView dpu;
    private a eQB;
    private IMBlackListActivity eQx;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.eQx = iMBlackListActivity;
        Em();
    }

    public void Mi() {
        this.mProgress.setVisibility(0);
    }

    public void aMO() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.eQB.b(blackListItemData);
        if (this.eQB.getCount() <= 0) {
            this.avh.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.avh.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eQB.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.eQB.getCount() <= 0) {
            this.avh.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.avh.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eQB.notifyDataSetChanged();
    }

    public void S(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.avh.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.avh.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eQB.setData(arrayList);
        this.eQB.notifyDataSetChanged();
    }

    private void Em() {
        this.eQx.setContentView(d.h.im_black_list);
        this.aId = this.eQx.findViewById(d.g.root_view);
        this.dpu = (NoNetworkView) this.aId.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aId.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.avh = (BdListView) this.aId.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.eQx.getPageContext().getContext(), this.aId, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bCW), NoDataViewFactory.d.gp(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.aId.findViewById(d.g.progress);
        this.eQB = new a(this.eQx);
        this.avh.setAdapter((ListAdapter) this.eQB);
        En();
    }

    private void En() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eQx.getLayoutMode().aQ(skinType == 1);
        this.eQx.getLayoutMode().aM(this.aId);
        this.mNavigationBar.onChangeSkinType(this.eQx.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eQx.getPageContext(), skinType);
        this.dpu.onChangeSkinType(this.eQx.getPageContext(), skinType);
    }
}
