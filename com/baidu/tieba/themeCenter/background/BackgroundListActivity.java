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
/* loaded from: classes9.dex */
public class BackgroundListActivity extends BaseActivity<BackgroundListActivity> {
    private TbPageContext<?> mPageContext;
    d nGN;
    private BackgroundListModel nHm;
    private f nHn;
    private BackgroundListModel.a nHo = new BackgroundListModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundListModel.a
        public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.e eVar, List<DressItemData> list) {
            BackgroundListActivity.this.nHn.bRI();
            BackgroundListActivity.this.hideLoadingView(BackgroundListActivity.this.nHn.getRootView());
            if (i == 0) {
                BackgroundListActivity.this.nHn.a(eVar, list, BackgroundListActivity.this.nHm.dRn());
                return;
            }
            BackgroundListActivity.this.showToast(str);
            BackgroundListActivity.this.nHn.cAO();
        }
    };
    private BdListView.e gBC = new BdListView.e() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (BackgroundListActivity.this.nHm != null) {
                BackgroundListActivity.this.nHm.dRm();
            }
        }
    };
    private final f.c gHz = new f.c() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (BackgroundListActivity.this.nHm != null) {
                BackgroundListActivity.this.nHm.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.nHm = new BackgroundListModel(this);
        this.nHm.a(this.nHo);
        this.nGN = new d(this.mPageContext, this.nHm.getUniqueId());
        this.nGN.setFrom(0);
        this.nHn = new f(this, this.nGN);
        this.nHn.a(this.gBC, this.gHz);
        showLoadingView(this.nHn.getRootView());
        this.nHm.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nHn.getRootView());
            this.nHm.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nHn != null) {
            this.nHn.bzn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nHm != null) {
            this.nHm.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nHm != null && this.nHn != null) {
            showLoadingView(this.nHn.getRootView());
            this.nHm.LoadData();
        }
    }

    public int getPropId() {
        return this.nGN.getPropId();
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
