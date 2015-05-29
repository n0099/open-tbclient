package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.g<IMBlackListActivity> {
    private NoNetworkView aFX;
    private IMBlackListActivity bvh;
    private f bvl;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public i(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.bvh = iMBlackListActivity;
        initialize();
    }

    public void WQ() {
        this.mProgress.setVisibility(0);
    }

    public void WR() {
        this.mProgress.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.bvl.b(aVar);
        if (this.bvl.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bvl.notifyDataSetChanged();
    }

    public void WS() {
        if (this.bvl.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bvl.notifyDataSetChanged();
    }

    public void A(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bvl.setData(arrayList);
        this.bvl.notifyDataSetChanged();
    }

    private void initialize() {
        this.bvh.setContentView(com.baidu.tieba.r.im_black_list);
        this.mRoot = this.bvh.findViewById(com.baidu.tieba.q.root_view);
        this.aFX = (NoNetworkView) this.mRoot.findViewById(com.baidu.tieba.q.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(com.baidu.tieba.t.chat_black_list_title);
        this.mListView = (BdListView) this.mRoot.findViewById(com.baidu.tieba.q.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.bvh.getPageContext().getContext(), this.mRoot, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.q.progress);
        this.bvl = new f(this.bvh);
        this.mListView.setAdapter((ListAdapter) this.bvl);
        uy();
    }

    private void uy() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bvh.getLayoutMode().ab(skinType == 1);
        this.bvh.getLayoutMode().j(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bvh.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bvh.getPageContext(), skinType);
        this.aFX.onChangeSkinType(this.bvh.getPageContext(), skinType);
    }
}
