package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private View aGH;
    private BdListView avj;
    private NoNetworkView dmi;
    private IMBlackListActivity eLT;
    private a eLX;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgress;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.eLT = iMBlackListActivity;
        DQ();
    }

    public void LA() {
        this.mProgress.setVisibility(0);
    }

    public void aLh() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.eLX.b(blackListItemData);
        if (this.eLX.getCount() <= 0) {
            this.avj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.avj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eLX.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.eLX.getCount() <= 0) {
            this.avj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.avj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eLX.notifyDataSetChanged();
    }

    public void S(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.avj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.avj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.eLX.setData(arrayList);
        this.eLX.notifyDataSetChanged();
    }

    private void DQ() {
        this.eLT.setContentView(d.h.im_black_list);
        this.aGH = this.eLT.findViewById(d.g.root_view);
        this.dmi = (NoNetworkView) this.aGH.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.aGH.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.chat_black_list_title);
        this.avj = (BdListView) this.aGH.findViewById(d.g.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.eLT.getPageContext().getContext(), this.aGH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bAK), NoDataViewFactory.d.gn(d.j.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.aGH.findViewById(d.g.progress);
        this.eLX = new a(this.eLT);
        this.avj.setAdapter((ListAdapter) this.eLX);
        DR();
    }

    private void DR() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eLT.getLayoutMode().aM(skinType == 1);
        this.eLT.getLayoutMode().aM(this.aGH);
        this.mNavigationBar.onChangeSkinType(this.eLT.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eLT.getPageContext(), skinType);
        this.dmi.onChangeSkinType(this.eLT.getPageContext(), skinType);
    }
}
