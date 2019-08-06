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
    private BdListView Ni;
    private NoNetworkView eXf;
    private IMBlackListActivity gTN;
    private a gTR;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.gTN = iMBlackListActivity;
        initialize();
    }

    public void atj() {
        this.mProgress.setVisibility(0);
    }

    public void bHt() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.gTR.b(blackListItemData);
        if (this.gTR.getCount() <= 0) {
            this.Ni.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ni.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gTR.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.gTR.getCount() <= 0) {
            this.Ni.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ni.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gTR.notifyDataSetChanged();
    }

    public void ag(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Ni.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Ni.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gTR.setData(arrayList);
        this.gTR.notifyDataSetChanged();
    }

    private void initialize() {
        this.gTN.setContentView(R.layout.im_black_list);
        this.mRoot = this.gTN.findViewById(R.id.root_view);
        this.eXf = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.Ni = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.gTN.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cCG), NoDataViewFactory.d.iN(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.gTR = new a(this.gTN);
        this.Ni.setAdapter((ListAdapter) this.gTR);
        akN();
    }

    private void akN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gTN.getLayoutMode().setNightMode(skinType == 1);
        this.gTN.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gTN.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gTN.getPageContext(), skinType);
        this.eXf.onChangeSkinType(this.gTN.getPageContext(), skinType);
    }
}
