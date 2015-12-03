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
    private NoNetworkView aQl;
    private IMBlackListActivity ccu;
    private f ccz;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.ccu = iMBlackListActivity;
        initialize();
    }

    public void CI() {
        this.mProgress.setVisibility(0);
    }

    public void acE() {
        this.mProgress.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.ccz.b(aVar);
        if (this.ccz.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ccz.notifyDataSetChanged();
    }

    public void LV() {
        if (this.ccz.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ccz.notifyDataSetChanged();
    }

    public void L(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.ccz.setData(arrayList);
        this.ccz.notifyDataSetChanged();
    }

    private void initialize() {
        this.ccu.setContentView(n.g.im_black_list);
        this.mRoot = this.ccu.findViewById(n.f.root_view);
        this.aQl = (NoNetworkView) this.mRoot.findViewById(n.f.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.chat_black_list_title);
        this.mListView = (BdListView) this.mRoot.findViewById(n.f.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.ccu.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cS(n.i.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(n.f.progress);
        this.ccz = new f(this.ccu);
        this.mListView.setAdapter((ListAdapter) this.ccz);
        wh();
    }

    private void wh() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.ccu.getLayoutMode().af(skinType == 1);
        this.ccu.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.ccu.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.ccu.getPageContext(), skinType);
        this.aQl.onChangeSkinType(this.ccu.getPageContext(), skinType);
    }
}
