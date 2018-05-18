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
    private BdListView FH;
    private View Th;
    private NoNetworkView cIH;
    private IMBlackListActivity elT;
    private a elX;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.elT = iMBlackListActivity;
        initialize();
    }

    public void EJ() {
        this.mProgress.setVisibility(0);
    }

    public void aHH() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.elX.b(blackListItemData);
        if (this.elX.getCount() <= 0) {
            this.FH.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.FH.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.elX.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.elX.getCount() <= 0) {
            this.FH.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.FH.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.elX.notifyDataSetChanged();
    }

    public void T(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.FH.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.FH.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.elX.setData(arrayList);
        this.elX.notifyDataSetChanged();
    }

    private void initialize() {
        this.elT.setContentView(d.i.im_black_list);
        this.Th = this.elT.findViewById(d.g.root_view);
        this.cIH = (NoNetworkView) this.Th.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Th.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.chat_black_list_title);
        this.FH = (BdListView) this.Th.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.elT.getPageContext().getContext(), this.Th, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aNn), NoDataViewFactory.d.dp(d.k.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Th.findViewById(d.g.progress);
        this.elX = new a(this.elT);
        this.FH.setAdapter((ListAdapter) this.elX);
        wX();
    }

    private void wX() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.elT.getLayoutMode().setNightMode(skinType == 1);
        this.elT.getLayoutMode().u(this.Th);
        this.mNavigationBar.onChangeSkinType(this.elT.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.elT.getPageContext(), skinType);
        this.cIH.onChangeSkinType(this.elT.getPageContext(), skinType);
    }
}
