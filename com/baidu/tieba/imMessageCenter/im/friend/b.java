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
/* loaded from: classes21.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView VG;
    private NoNetworkView fFC;
    private IMBlackListActivity jKD;
    private a jKH;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.jKD = iMBlackListActivity;
        initialize();
    }

    public void btO() {
        this.mProgress.setVisibility(0);
    }

    public void cME() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.jKH.b(blackListItemData);
        if (this.jKH.getCount() <= 0) {
            this.VG.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.VG.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jKH.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.jKH.getCount() <= 0) {
            this.VG.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.VG.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jKH.notifyDataSetChanged();
    }

    public void aH(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.VG.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.VG.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jKH.setData(arrayList);
        this.jKH.notifyDataSetChanged();
    }

    private void initialize() {
        this.jKD.setContentView(R.layout.im_black_list);
        this.mRoot = this.jKD.findViewById(R.id.root_view);
        this.fFC = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.VG = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.jKD.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eXP), NoDataViewFactory.d.oW(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.jKH = new a(this.jKD);
        this.VG.setAdapter((ListAdapter) this.jKH);
        blA();
    }

    private void blA() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jKD.getLayoutMode().setNightMode(skinType == 1);
        this.jKD.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jKD.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.jKD.getPageContext(), skinType);
        this.fFC.onChangeSkinType(this.jKD.getPageContext(), skinType);
    }
}
