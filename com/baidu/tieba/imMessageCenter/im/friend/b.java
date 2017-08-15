package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private BdListView JE;
    private View Sf;
    private NoNetworkView bFB;
    private IMBlackListActivity dDZ;
    private a dEd;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dDZ = iMBlackListActivity;
        bg();
    }

    public void Eg() {
        this.mProgress.setVisibility(0);
    }

    public void azs() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dEd.b(blackListItemData);
        if (this.dEd.getCount() <= 0) {
            this.JE.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.JE.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dEd.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dEd.getCount() <= 0) {
            this.JE.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.JE.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dEd.notifyDataSetChanged();
    }

    public void T(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.JE.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.JE.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dEd.setData(arrayList);
        this.dEd.notifyDataSetChanged();
    }

    private void bg() {
        this.dDZ.setContentView(d.j.im_black_list);
        this.Sf = this.dDZ.findViewById(d.h.root_view);
        this.bFB = (NoNetworkView) this.Sf.findViewById(d.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Sf.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.l.chat_black_list_title);
        this.JE = (BdListView) this.Sf.findViewById(d.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dDZ.getPageContext().getContext(), this.Sf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMx), NoDataViewFactory.d.dk(d.l.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Sf.findViewById(d.h.progress);
        this.dEd = new a(this.dDZ);
        this.JE.setAdapter((ListAdapter) this.dEd);
        xd();
    }

    private void xd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dDZ.getLayoutMode().ah(skinType == 1);
        this.dDZ.getLayoutMode().t(this.Sf);
        this.mNavigationBar.onChangeSkinType(this.dDZ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dDZ.getPageContext(), skinType);
        this.bFB.onChangeSkinType(this.dDZ.getPageContext(), skinType);
    }
}
