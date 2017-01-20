package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.e<IMBlackListActivity> {
    private BdListView Bw;
    private View LW;
    private ProgressBar bkd;
    private NoNetworkView bxs;
    private IMBlackListActivity dhI;
    private f dhM;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.dhI = iMBlackListActivity;
        wr();
    }

    public void DD() {
        this.bkd.setVisibility(0);
    }

    public void avj() {
        this.bkd.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.dhM.b(blackListItemData);
        if (this.dhM.getCount() <= 0) {
            this.Bw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Bw.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dhM.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.dhM.getCount() <= 0) {
            this.Bw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Bw.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dhM.notifyDataSetChanged();
    }

    public void S(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Bw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Bw.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.dhM.setData(arrayList);
        this.dhM.notifyDataSetChanged();
    }

    private void wr() {
        this.dhI.setContentView(r.j.im_black_list);
        this.LW = this.dhI.findViewById(r.h.root_view);
        this.bxs = (NoNetworkView) this.LW.findViewById(r.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.LW.findViewById(r.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(r.l.chat_black_list_title);
        this.Bw = (BdListView) this.LW.findViewById(r.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.dhI.getPageContext().getContext(), this.LW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aDg), NoDataViewFactory.d.di(r.l.black_list_no_data_text), null);
        this.bkd = (ProgressBar) this.LW.findViewById(r.h.progress);
        this.dhM = new f(this.dhI);
        this.Bw.setAdapter((ListAdapter) this.dhM);
        ws();
    }

    private void ws() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dhI.getLayoutMode().ai(skinType == 1);
        this.dhI.getLayoutMode().v(this.LW);
        this.mNavigationBar.onChangeSkinType(this.dhI.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dhI.getPageContext(), skinType);
        this.bxs.onChangeSkinType(this.dhI.getPageContext(), skinType);
    }
}
