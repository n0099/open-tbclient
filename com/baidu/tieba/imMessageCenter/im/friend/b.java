package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView Hi;
    private View Sf;
    private NoNetworkView ctj;
    private IMBlackListActivity dYq;
    private a dYu;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dYq = iMBlackListActivity;
        wB();
    }

    public void El() {
        this.mProgress.setVisibility(0);
    }

    public void aEb() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dYu.b(blackListItemData);
        if (this.dYu.getCount() <= 0) {
            this.Hi.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hi.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dYu.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dYu.getCount() <= 0) {
            this.Hi.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hi.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dYu.notifyDataSetChanged();
    }

    public void S(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Hi.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Hi.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dYu.setData(arrayList);
        this.dYu.notifyDataSetChanged();
    }

    private void wB() {
        this.dYq.setContentView(d.h.im_black_list);
        this.Sf = this.dYq.findViewById(d.g.root_view);
        this.ctj = (NoNetworkView) this.Sf.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Sf.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.Hi = (BdListView) this.Sf.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dYq.getPageContext().getContext(), this.Sf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMO), NoDataViewFactory.d.dq(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Sf.findViewById(d.g.progress);
        this.dYu = new a(this.dYq);
        this.Hi.setAdapter((ListAdapter) this.dYu);
        wC();
    }

    private void wC() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dYq.getLayoutMode().ag(skinType == 1);
        this.dYq.getLayoutMode().t(this.Sf);
        this.mNavigationBar.onChangeSkinType(this.dYq.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dYq.getPageContext(), skinType);
        this.ctj.onChangeSkinType(this.dYq.getPageContext(), skinType);
    }
}
