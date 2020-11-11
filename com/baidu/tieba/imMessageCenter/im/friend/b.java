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
    private BdListView VY;
    private NoNetworkView ghD;
    private IMBlackListActivity krW;
    private a ksa;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.krW = iMBlackListActivity;
        initialize();
    }

    public void bAQ() {
        this.mProgress.setVisibility(0);
    }

    public void cVU() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.ksa.b(blackListItemData);
        if (this.ksa.getCount() <= 0) {
            this.VY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.VY.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ksa.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.ksa.getCount() <= 0) {
            this.VY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.VY.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ksa.notifyDataSetChanged();
    }

    public void aI(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.VY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.VY.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ksa.setData(arrayList);
        this.ksa.notifyDataSetChanged();
    }

    private void initialize() {
        this.krW.setContentView(R.layout.im_black_list);
        this.mRoot = this.krW.findViewById(R.id.root_view);
        this.ghD = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.VY = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.krW.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fys), NoDataViewFactory.d.pQ(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.ksa = new a(this.krW);
        this.VY.setAdapter((ListAdapter) this.ksa);
        bsD();
    }

    private void bsD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.krW.getLayoutMode().setNightMode(skinType == 1);
        this.krW.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.krW.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.krW.getPageContext(), skinType);
        this.ghD.onChangeSkinType(this.krW.getPageContext(), skinType);
    }
}
