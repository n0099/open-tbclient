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
    private NoNetworkView aNx;
    private IMBlackListActivity bIY;
    private f bJd;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.bIY = iMBlackListActivity;
        initialize();
    }

    public void BQ() {
        this.mProgress.setVisibility(0);
    }

    public void Yx() {
        this.mProgress.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.bJd.b(aVar);
        if (this.bJd.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bJd.notifyDataSetChanged();
    }

    public void KF() {
        if (this.bJd.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bJd.notifyDataSetChanged();
    }

    public void G(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bJd.setData(arrayList);
        this.bJd.notifyDataSetChanged();
    }

    private void initialize() {
        this.bIY.setContentView(i.g.im_black_list);
        this.mRoot = this.bIY.findViewById(i.f.root_view);
        this.aNx = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.C0057i.chat_black_list_title);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.bIY.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cD(i.C0057i.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        this.bJd = new f(this.bIY);
        this.mListView.setAdapter((ListAdapter) this.bJd);
        vD();
    }

    private void vD() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bIY.getLayoutMode().ad(skinType == 1);
        this.bIY.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bIY.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bIY.getPageContext(), skinType);
        this.aNx.onChangeSkinType(this.bIY.getPageContext(), skinType);
    }
}
