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
    private View aHS;
    private BdListView auY;
    private NoNetworkView dpi;
    private IMBlackListActivity eQl;
    private a eQp;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.eQl = iMBlackListActivity;
        El();
    }

    public void Mh() {
        this.mProgress.setVisibility(0);
    }

    public void aMN() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.eQp.b(blackListItemData);
        if (this.eQp.getCount() <= 0) {
            this.auY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.auY.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eQp.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.eQp.getCount() <= 0) {
            this.auY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.auY.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eQp.notifyDataSetChanged();
    }

    public void S(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.auY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.auY.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eQp.setData(arrayList);
        this.eQp.notifyDataSetChanged();
    }

    private void El() {
        this.eQl.setContentView(d.h.im_black_list);
        this.aHS = this.eQl.findViewById(d.g.root_view);
        this.dpi = (NoNetworkView) this.aHS.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aHS.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.auY = (BdListView) this.aHS.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.eQl.getPageContext().getContext(), this.aHS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bCJ), NoDataViewFactory.d.gp(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.aHS.findViewById(d.g.progress);
        this.eQp = new a(this.eQl);
        this.auY.setAdapter((ListAdapter) this.eQp);
        Em();
    }

    private void Em() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eQl.getLayoutMode().aQ(skinType == 1);
        this.eQl.getLayoutMode().aM(this.aHS);
        this.mNavigationBar.onChangeSkinType(this.eQl.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eQl.getPageContext(), skinType);
        this.dpi.onChangeSkinType(this.eQl.getPageContext(), skinType);
    }
}
