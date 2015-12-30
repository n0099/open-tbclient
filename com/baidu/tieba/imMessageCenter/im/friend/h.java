package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.f<IMBlackListActivity> {
    private NoNetworkView aUd;
    private IMBlackListActivity cgu;
    private f cgz;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.cgu = iMBlackListActivity;
        initialize();
    }

    public void Cx() {
        this.mProgress.setVisibility(0);
    }

    public void adN() {
        this.mProgress.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.cgz.b(aVar);
        if (this.cgz.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.cgz.notifyDataSetChanged();
    }

    public void Mo() {
        if (this.cgz.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.cgz.notifyDataSetChanged();
    }

    public void K(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.cgz.setData(arrayList);
        this.cgz.notifyDataSetChanged();
    }

    private void initialize() {
        this.cgu.setContentView(n.h.im_black_list);
        this.mRoot = this.cgu.findViewById(n.g.root_view);
        this.aUd = (NoNetworkView) this.mRoot.findViewById(n.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.chat_black_list_title);
        this.mListView = (BdListView) this.mRoot.findViewById(n.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.cgu.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cM(n.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(n.g.progress);
        this.cgz = new f(this.cgu);
        this.mListView.setAdapter((ListAdapter) this.cgz);
        vR();
    }

    private void vR() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.cgu.getLayoutMode().ac(skinType == 1);
        this.cgu.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.cgu.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.cgu.getPageContext(), skinType);
        this.aUd.onChangeSkinType(this.cgu.getPageContext(), skinType);
    }
}
