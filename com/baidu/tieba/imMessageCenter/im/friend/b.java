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
    private View aGJ;
    private BdListView avk;
    private NoNetworkView dhH;
    private IMBlackListActivity eKt;
    private a eKx;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.eKt = iMBlackListActivity;
        DZ();
    }

    public void LM() {
        this.mProgress.setVisibility(0);
    }

    public void aLc() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.eKx.b(blackListItemData);
        if (this.eKx.getCount() <= 0) {
            this.avk.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.avk.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eKx.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.eKx.getCount() <= 0) {
            this.avk.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.avk.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eKx.notifyDataSetChanged();
    }

    public void S(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.avk.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.avk.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eKx.setData(arrayList);
        this.eKx.notifyDataSetChanged();
    }

    private void DZ() {
        this.eKt.setContentView(d.h.im_black_list);
        this.aGJ = this.eKt.findViewById(d.g.root_view);
        this.dhH = (NoNetworkView) this.aGJ.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aGJ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.avk = (BdListView) this.aGJ.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.eKt.getPageContext().getContext(), this.aGJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bAB), NoDataViewFactory.d.gp(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.aGJ.findViewById(d.g.progress);
        this.eKx = new a(this.eKt);
        this.avk.setAdapter((ListAdapter) this.eKx);
        Ea();
    }

    private void Ea() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eKt.getLayoutMode().aM(skinType == 1);
        this.eKt.getLayoutMode().aM(this.aGJ);
        this.mNavigationBar.onChangeSkinType(this.eKt.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eKt.getPageContext(), skinType);
        this.dhH.onChangeSkinType(this.eKt.getPageContext(), skinType);
    }
}
