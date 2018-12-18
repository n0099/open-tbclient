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
    private View amM;
    private NoNetworkView dop;
    private IMBlackListActivity fbW;
    private a fca;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.fbW = iMBlackListActivity;
        initialize();
    }

    public void Ne() {
        this.mProgress.setVisibility(0);
    }

    public void aUW() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.fca.b(blackListItemData);
        if (this.fca.getCount() <= 0) {
            this.OF.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OF.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.fca.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.fca.getCount() <= 0) {
            this.OF.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OF.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.fca.notifyDataSetChanged();
    }

    public void Y(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.OF.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.OF.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.fca.setData(arrayList);
        this.fca.notifyDataSetChanged();
    }

    private void initialize() {
        this.fbW.setContentView(e.h.im_black_list);
        this.amM = this.fbW.findViewById(e.g.root_view);
        this.dop = (NoNetworkView) this.amM.findViewById(e.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.chat_black_list_title);
        this.OF = (BdListView) this.amM.findViewById(e.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.fbW.getPageContext().getContext(), this.amM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bio), NoDataViewFactory.d.eq(e.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.amM.findViewById(e.g.progress);
        this.fca = new a(this.fbW);
        this.OF.setAdapter((ListAdapter) this.fca);
        Fj();
    }

    private void Fj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fbW.getLayoutMode().setNightMode(skinType == 1);
        this.fbW.getLayoutMode().onModeChanged(this.amM);
        this.mNavigationBar.onChangeSkinType(this.fbW.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.fbW.getPageContext(), skinType);
        this.dop.onChangeSkinType(this.fbW.getPageContext(), skinType);
    }
}
