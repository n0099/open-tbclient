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
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView VX;
    private NoNetworkView fRL;
    private IMBlackListActivity jZA;
    private a jZE;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.jZA = iMBlackListActivity;
        initialize();
    }

    public void bwy() {
        this.mProgress.setVisibility(0);
    }

    public void cQm() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.jZE.b(blackListItemData);
        if (this.jZE.getCount() <= 0) {
            this.VX.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.VX.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jZE.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.jZE.getCount() <= 0) {
            this.VX.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.VX.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jZE.notifyDataSetChanged();
    }

    public void aH(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.VX.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.VX.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jZE.setData(arrayList);
        this.jZE.notifyDataSetChanged();
    }

    private void initialize() {
        this.jZA.setContentView(R.layout.im_black_list);
        this.mRoot = this.jZA.findViewById(R.id.root_view);
        this.fRL = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.VX = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.jZA.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fkb), NoDataViewFactory.d.pv(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.jZE = new a(this.jZA);
        this.VX.setAdapter((ListAdapter) this.jZE);
        bok();
    }

    private void bok() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jZA.getLayoutMode().setNightMode(skinType == 1);
        this.jZA.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jZA.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.jZA.getPageContext(), skinType);
        this.fRL.onChangeSkinType(this.jZA.getPageContext(), skinType);
    }
}
