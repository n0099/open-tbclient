package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.base.c<IMBlackListActivity> {
    private NoNetworkView fbw;
    private IMBlackListActivity gTG;
    private a gTK;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private BdListView yl;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.gTG = iMBlackListActivity;
        initialize();
    }

    public void avf() {
        this.mProgress.setVisibility(0);
    }

    public void bES() {
        this.mProgress.setVisibility(8);
    }

    public void b(BlackListItemData blackListItemData) {
        this.gTK.b(blackListItemData);
        if (this.gTK.getCount() <= 0) {
            this.yl.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.yl.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gTK.notifyDataSetChanged();
    }

    public void refreshData() {
        if (this.gTK.getCount() <= 0) {
            this.yl.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.yl.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gTK.notifyDataSetChanged();
    }

    public void ak(ArrayList<BlackListItemData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.yl.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.yl.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.gTK.setData(arrayList);
        this.gTK.notifyDataSetChanged();
    }

    private void initialize() {
        this.gTG.setContentView(R.layout.im_black_list);
        this.mRoot = this.gTG.findViewById(R.id.root_view);
        this.fbw = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.chat_black_list_title);
        this.yl = (BdListView) this.mRoot.findViewById(R.id.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.gTG.getPageContext().getContext(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.iL(R.string.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.gTK = new a(this.gTG);
        this.yl.setAdapter((ListAdapter) this.gTK);
        anO();
    }

    private void anO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gTG.getLayoutMode().setNightMode(skinType == 1);
        this.gTG.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gTG.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gTG.getPageContext(), skinType);
        this.fbw.onChangeSkinType(this.gTG.getPageContext(), skinType);
    }
}
