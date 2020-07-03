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
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView US;
    private NoNetworkView flI;
    private a jeD;
    private IMBlackListActivity jez;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.jez = iMBlackListActivity;
        initialize();
    }

    public void bgm() {
        this.mProgress.setVisibility(0);
    }

    public void cud() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.jeD.b(blackListItemData);
        if (this.jeD.getCount() <= 0) {
            this.US.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.US.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jeD.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.jeD.getCount() <= 0) {
            this.US.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.US.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jeD.notifyDataSetChanged();
    }

    public void ay(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.US.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.US.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.jeD.setData(arrayList);
        this.jeD.notifyDataSetChanged();
    }

    private void initialize() {
        this.jez.setContentView(R.layout.im_black_list);
        this.mRoot = this.jez.findViewById(R.id.root_view);
        this.flI = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.US = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.jez.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eDT), NoDataViewFactory.d.mm(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.jeD = new a(this.jez);
        this.US.setAdapter((ListAdapter) this.jeD);
        aYj();
    }

    private void aYj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jez.getLayoutMode().setNightMode(skinType == 1);
        this.jez.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jez.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.jez.getPageContext(), skinType);
        this.flI.onChangeSkinType(this.jez.getPageContext(), skinType);
    }
}
