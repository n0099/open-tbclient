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
    private BdListView JC;
    private View Sd;
    private NoNetworkView bES;
    private IMBlackListActivity dCc;
    private a dCg;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dCc = iMBlackListActivity;
        bg();
    }

    public void Eg() {
        this.mProgress.setVisibility(0);
    }

    public void ayL() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dCg.b(blackListItemData);
        if (this.dCg.getCount() <= 0) {
            this.JC.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.JC.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dCg.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dCg.getCount() <= 0) {
            this.JC.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.JC.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dCg.notifyDataSetChanged();
    }

    public void T(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.JC.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.JC.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dCg.setData(arrayList);
        this.dCg.notifyDataSetChanged();
    }

    private void bg() {
        this.dCc.setContentView(d.j.im_black_list);
        this.Sd = this.dCc.findViewById(d.h.root_view);
        this.bES = (NoNetworkView) this.Sd.findViewById(d.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.Sd.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.l.chat_black_list_title);
        this.JC = (BdListView) this.Sd.findViewById(d.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dCc.getPageContext().getContext(), this.Sd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMw), NoDataViewFactory.d.dk(d.l.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.Sd.findViewById(d.h.progress);
        this.dCg = new a(this.dCc);
        this.JC.setAdapter((ListAdapter) this.dCg);
        xd();
    }

    private void xd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dCc.getLayoutMode().ah(skinType == 1);
        this.dCc.getLayoutMode().t(this.Sd);
        this.mNavigationBar.onChangeSkinType(this.dCc.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dCc.getPageContext(), skinType);
        this.bES.onChangeSkinType(this.dCc.getPageContext(), skinType);
    }
}
