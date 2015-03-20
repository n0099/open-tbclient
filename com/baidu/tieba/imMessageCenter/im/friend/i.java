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
    private NoNetworkView aDO;
    private IMBlackListActivity bsf;
    private f bsk;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public i(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.bsf = iMBlackListActivity;
        initialize();
    }

    public void Vl() {
        this.mProgress.setVisibility(0);
    }

    public void Vm() {
        this.mProgress.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.bsk.b(aVar);
        if (this.bsk.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bsk.notifyDataSetChanged();
    }

    public void Vn() {
        if (this.bsk.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bsk.notifyDataSetChanged();
    }

    public void A(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bsk.p(arrayList);
        this.bsk.notifyDataSetChanged();
    }

    private void initialize() {
        this.bsf.setContentView(com.baidu.tieba.w.im_black_list);
        this.mRoot = this.bsf.findViewById(com.baidu.tieba.v.root_view);
        this.aDO = (NoNetworkView) this.mRoot.findViewById(com.baidu.tieba.v.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(com.baidu.tieba.y.chat_black_list_title);
        this.mListView = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.bsf.getPageContext().getContext(), this.mRoot, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        this.bsk = new f(this.bsf);
        this.mListView.setAdapter((ListAdapter) this.bsk);
        tP();
    }

    private void tP() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bsf.getLayoutMode().X(skinType == 1);
        this.bsf.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bsf.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bsf.getPageContext(), skinType);
        this.aDO.onChangeSkinType(this.bsf.getPageContext(), skinType);
    }
}
