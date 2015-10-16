package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.f<IMBlackListActivity> {
    private NoNetworkView aMQ;
    private IMBlackListActivity bMV;
    private f bNa;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.bMV = iMBlackListActivity;
        initialize();
    }

    public void BR() {
        this.mProgress.setVisibility(0);
    }

    public void Zh() {
        this.mProgress.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.bNa.b(aVar);
        if (this.bNa.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bNa.notifyDataSetChanged();
    }

    public void Ko() {
        if (this.bNa.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bNa.notifyDataSetChanged();
    }

    public void F(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bNa.setData(arrayList);
        this.bNa.notifyDataSetChanged();
    }

    private void initialize() {
        this.bMV.setContentView(i.g.im_black_list);
        this.mRoot = this.bMV.findViewById(i.f.root_view);
        this.aMQ = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.chat_black_list_title);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.bMV.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        this.bNa = new f(this.bMV);
        this.mListView.setAdapter((ListAdapter) this.bNa);
        vA();
    }

    private void vA() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bMV.getLayoutMode().ad(skinType == 1);
        this.bMV.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bMV.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bMV.getPageContext(), skinType);
        this.aMQ.onChangeSkinType(this.bMV.getPageContext(), skinType);
    }
}
