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
/* loaded from: classes16.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView Vo;
    private NoNetworkView fCm;
    private IMBlackListActivity jBV;
    private a jBZ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.jBV = iMBlackListActivity;
        initialize();
    }

    public void bsJ() {
        this.mProgress.setVisibility(0);
    }

    public void cIX() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.jBZ.b(blackListItemData);
        if (this.jBZ.getCount() <= 0) {
            this.Vo.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Vo.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jBZ.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.jBZ.getCount() <= 0) {
            this.Vo.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Vo.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jBZ.notifyDataSetChanged();
    }

    public void aF(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Vo.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Vo.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jBZ.setData(arrayList);
        this.jBZ.notifyDataSetChanged();
    }

    private void initialize() {
        this.jBV.setContentView(R.layout.im_black_list);
        this.mRoot = this.jBV.findViewById(R.id.root_view);
        this.fCm = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.Vo = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.jBV.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eUU), NoDataViewFactory.d.oK(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.jBZ = new a(this.jBV);
        this.Vo.setAdapter((ListAdapter) this.jBZ);
        bkF();
    }

    private void bkF() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jBV.getLayoutMode().setNightMode(skinType == 1);
        this.jBV.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jBV.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.jBV.getPageContext(), skinType);
        this.fCm.onChangeSkinType(this.jBV.getPageContext(), skinType);
    }
}
