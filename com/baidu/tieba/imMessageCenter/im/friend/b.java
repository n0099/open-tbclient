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
    private View buc;
    private NoNetworkView eCf;
    private IMBlackListActivity gvv;
    private a gvz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.gvv = iMBlackListActivity;
        initialize();
    }

    public void amX() {
        this.mProgress.setVisibility(0);
    }

    public void bwM() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.gvz.b(blackListItemData);
        if (this.gvz.getCount() <= 0) {
            this.Pj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Pj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gvz.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.gvz.getCount() <= 0) {
            this.Pj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Pj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gvz.notifyDataSetChanged();
    }

    public void ac(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Pj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Pj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gvz.setData(arrayList);
        this.gvz.notifyDataSetChanged();
    }

    private void initialize() {
        this.gvv.setContentView(d.h.im_black_list);
        this.buc = this.gvv.findViewById(d.g.root_view);
        this.eCf = (NoNetworkView) this.buc.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.buc.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.Pj = (BdListView) this.buc.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.gvv.getPageContext().getContext(), this.buc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.csY), NoDataViewFactory.d.hT(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.buc.findViewById(d.g.progress);
        this.gvz = new a(this.gvv);
        this.Pj.setAdapter((ListAdapter) this.gvz);
        aeH();
    }

    private void aeH() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gvv.getLayoutMode().setNightMode(skinType == 1);
        this.gvv.getLayoutMode().onModeChanged(this.buc);
        this.mNavigationBar.onChangeSkinType(this.gvv.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gvv.getPageContext(), skinType);
        this.eCf.onChangeSkinType(this.gvv.getPageContext(), skinType);
    }
}
