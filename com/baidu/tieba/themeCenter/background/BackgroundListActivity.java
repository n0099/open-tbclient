package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.themeCenter.background.BackgroundListModel;
import java.util.List;
/* loaded from: classes8.dex */
public class BackgroundListActivity extends BaseActivity<BackgroundListActivity> {
    private TbPageContext<?> mPageContext;
    d nwC;
    private BackgroundListModel nxb;
    private f nxc;
    private BackgroundListModel.a nxd = new BackgroundListModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundListModel.a
        public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.e eVar, List<DressItemData> list) {
            BackgroundListActivity.this.nxc.bQX();
            BackgroundListActivity.this.hideLoadingView(BackgroundListActivity.this.nxc.getRootView());
            if (i == 0) {
                BackgroundListActivity.this.nxc.a(eVar, list, BackgroundListActivity.this.nxb.dOU());
                return;
            }
            BackgroundListActivity.this.showToast(str);
            BackgroundListActivity.this.nxc.czw();
        }
    };
    private BdListView.e gyE = new BdListView.e() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (BackgroundListActivity.this.nxb != null) {
                BackgroundListActivity.this.nxb.dOT();
            }
        }
    };
    private final f.c gEB = new f.c() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (BackgroundListActivity.this.nxb != null) {
                BackgroundListActivity.this.nxb.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.nxb = new BackgroundListModel(this);
        this.nxb.a(this.nxd);
        this.nwC = new d(this.mPageContext, this.nxb.getUniqueId());
        this.nwC.setFrom(0);
        this.nxc = new f(this, this.nwC);
        this.nxc.a(this.gyE, this.gEB);
        showLoadingView(this.nxc.getRootView());
        this.nxb.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nxc.getRootView());
            this.nxb.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nxc != null) {
            this.nxc.byV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nxb != null) {
            this.nxb.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nxb != null && this.nxc != null) {
            showLoadingView(this.nxc.getRootView());
            this.nxb.LoadData();
        }
    }

    public int getPropId() {
        return this.nwC.getPropId();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.BACKGROUND_ALL;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.isRouteStat = true;
        }
        return pageStayDurationItem;
    }
}
