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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.base.e<IMBlackListActivity> {
    private BdListView Im;
    private View QK;
    private NoNetworkView bGF;
    private IMBlackListActivity deT;
    private f deX;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private ProgressBar mProgress;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.deT = iMBlackListActivity;
        wv();
    }

    public void Dy() {
        this.mProgress.setVisibility(0);
    }

    public void ast() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.deX.b(blackListItemData);
        if (this.deX.getCount() <= 0) {
            this.Im.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Im.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.deX.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.deX.getCount() <= 0) {
            this.Im.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Im.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.deX.notifyDataSetChanged();
    }

    public void R(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.Im.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.Im.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.deX.setData(arrayList);
        this.deX.notifyDataSetChanged();
    }

    private void wv() {
        this.deT.setContentView(w.j.im_black_list);
        this.QK = this.deT.findViewById(w.h.root_view);
        this.bGF = (NoNetworkView) this.QK.findViewById(w.h.view_no_network);
        this.mNavigationBar = (NavigationBar) this.QK.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(w.l.chat_black_list_title);
        this.Im = (BdListView) this.QK.findViewById(w.h.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.deT.getPageContext().getContext(), this.QK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aIX), NoDataViewFactory.d.dd(w.l.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.QK.findViewById(w.h.progress);
        this.deX = new f(this.deT);
        this.Im.setAdapter((ListAdapter) this.deX);
        ww();
    }

    private void ww() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.deT.getLayoutMode().ai(skinType == 1);
        this.deT.getLayoutMode().t(this.QK);
        this.mNavigationBar.onChangeSkinType(this.deT.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.deT.getPageContext(), skinType);
        this.bGF.onChangeSkinType(this.deT.getPageContext(), skinType);
    }
}
