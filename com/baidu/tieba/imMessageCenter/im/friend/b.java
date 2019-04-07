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
    private BdListView Pj;
    private View bub;
    private NoNetworkView eCe;
    private IMBlackListActivity gvu;
    private a gvy;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.gvu = iMBlackListActivity;
        initialize();
    }

    public void amX() {
        this.mProgress.setVisibility(0);
    }

    public void bwM() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.gvy.b(blackListItemData);
        if (this.gvy.getCount() <= 0) {
            this.Pj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Pj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gvy.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.gvy.getCount() <= 0) {
            this.Pj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Pj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gvy.notifyDataSetChanged();
    }

    public void ac(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Pj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Pj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gvy.setData(arrayList);
        this.gvy.notifyDataSetChanged();
    }

    private void initialize() {
        this.gvu.setContentView(d.h.im_black_list);
        this.bub = this.gvu.findViewById(d.g.root_view);
        this.eCe = (NoNetworkView) this.bub.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.bub.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.Pj = (BdListView) this.bub.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.gvu.getPageContext().getContext(), this.bub, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.csX), NoDataViewFactory.d.hT(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.bub.findViewById(d.g.progress);
        this.gvy = new a(this.gvu);
        this.Pj.setAdapter((ListAdapter) this.gvy);
        aeH();
    }

    private void aeH() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gvu.getLayoutMode().setNightMode(skinType == 1);
        this.gvu.getLayoutMode().onModeChanged(this.bub);
        this.mNavigationBar.onChangeSkinType(this.gvu.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gvu.getPageContext(), skinType);
        this.eCe.onChangeSkinType(this.gvu.getPageContext(), skinType);
    }
}
