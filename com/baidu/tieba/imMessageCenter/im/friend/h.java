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
    private NoNetworkView aMY;
    private IMBlackListActivity bNq;
    private f bNv;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.bNq = iMBlackListActivity;
        initialize();
    }

    public void BH() {
        this.mProgress.setVisibility(0);
    }

    public void Zy() {
        this.mProgress.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.bNv.b(aVar);
        if (this.bNv.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bNv.notifyDataSetChanged();
    }

    public void KA() {
        if (this.bNv.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bNv.notifyDataSetChanged();
    }

    public void F(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bNv.setData(arrayList);
        this.bNv.notifyDataSetChanged();
    }

    private void initialize() {
        this.bNq.setContentView(i.g.im_black_list);
        this.mRoot = this.bNq.findViewById(i.f.root_view);
        this.aMY = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.chat_black_list_title);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.bNq.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        this.bNv = new f(this.bNq);
        this.mListView.setAdapter((ListAdapter) this.bNv);
        vB();
    }

    private void vB() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bNq.getLayoutMode().ad(skinType == 1);
        this.bNq.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bNq.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bNq.getPageContext(), skinType);
        this.aMY.onChangeSkinType(this.bNq.getPageContext(), skinType);
    }
}
