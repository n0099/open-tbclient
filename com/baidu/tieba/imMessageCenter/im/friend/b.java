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
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView Pi;
    private View btW;
    private NoNetworkView eCx;
    private IMBlackListActivity gvH;
    private a gvL;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.gvH = iMBlackListActivity;
        initialize();
    }

    public void anb() {
        this.mProgress.setVisibility(0);
    }

    public void bwP() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.gvL.b(blackListItemData);
        if (this.gvL.getCount() <= 0) {
            this.Pi.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Pi.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gvL.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.gvL.getCount() <= 0) {
            this.Pi.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Pi.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gvL.notifyDataSetChanged();
    }

    public void ac(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Pi.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Pi.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gvL.setData(arrayList);
        this.gvL.notifyDataSetChanged();
    }

    private void initialize() {
        this.gvH.setContentView(d.h.im_black_list);
        this.btW = this.gvH.findViewById(d.g.root_view);
        this.eCx = (NoNetworkView) this.btW.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.btW.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.Pi = (BdListView) this.btW.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.gvH.getPageContext().getContext(), this.btW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.csY), NoDataViewFactory.d.hU(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.btW.findViewById(d.g.progress);
        this.gvL = new a(this.gvH);
        this.Pi.setAdapter((ListAdapter) this.gvL);
        aeK();
    }

    private void aeK() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gvH.getLayoutMode().setNightMode(skinType == 1);
        this.gvH.getLayoutMode().onModeChanged(this.btW);
        this.mNavigationBar.onChangeSkinType(this.gvH.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gvH.getPageContext(), skinType);
        this.eCx.onChangeSkinType(this.gvH.getPageContext(), skinType);
    }
}
