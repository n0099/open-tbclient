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
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private NoNetworkView faF;
    private IMBlackListActivity gSP;
    private a gST;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private BdListView xL;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.gSP = iMBlackListActivity;
        initialize();
    }

    public void avd() {
        this.mProgress.setVisibility(0);
    }

    public void bEQ() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.gST.b(blackListItemData);
        if (this.gST.getCount() <= 0) {
            this.xL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.xL.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gST.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.gST.getCount() <= 0) {
            this.xL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.xL.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gST.notifyDataSetChanged();
    }

    public void ak(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.xL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.xL.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gST.setData(arrayList);
        this.gST.notifyDataSetChanged();
    }

    private void initialize() {
        this.gSP.setContentView(R.layout.im_black_list);
        this.mRoot = this.gSP.findViewById(R.id.root_view);
        this.faF = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.xL = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.gSP.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.iK(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.gST = new a(this.gSP);
        this.xL.setAdapter((ListAdapter) this.gST);
        anM();
    }

    private void anM() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gSP.getLayoutMode().setNightMode(skinType == 1);
        this.gSP.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gSP.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gSP.getPageContext(), skinType);
        this.faF.onChangeSkinType(this.gSP.getPageContext(), skinType);
    }
}
