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
    d nIT;
    private BackgroundListModel nJs;
    private f nJt;
    private BackgroundListModel.a nJu = new BackgroundListModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundListModel.a
        public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.e eVar, List<DressItemData> list) {
            BackgroundListActivity.this.nJt.bRO();
            BackgroundListActivity.this.hideLoadingView(BackgroundListActivity.this.nJt.getRootView());
            if (i == 0) {
                BackgroundListActivity.this.nJt.a(eVar, list, BackgroundListActivity.this.nJs.dRw());
                return;
            }
            BackgroundListActivity.this.showToast(str);
            BackgroundListActivity.this.nJt.cAU();
        }
    };
    private BdListView.e gDl = new BdListView.e() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (BackgroundListActivity.this.nJs != null) {
                BackgroundListActivity.this.nJs.dRv();
            }
        }
    };
    private final f.c gJi = new f.c() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (BackgroundListActivity.this.nJs != null) {
                BackgroundListActivity.this.nJs.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.nJs = new BackgroundListModel(this);
        this.nJs.a(this.nJu);
        this.nIT = new d(this.mPageContext, this.nJs.getUniqueId());
        this.nIT.setFrom(0);
        this.nJt = new f(this, this.nIT);
        this.nJt.a(this.gDl, this.gJi);
        showLoadingView(this.nJt.getRootView());
        this.nJs.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nJt.getRootView());
            this.nJs.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nJt != null) {
            this.nJt.bzq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nJs != null) {
            this.nJs.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nJs != null && this.nJt != null) {
            showLoadingView(this.nJt.getRootView());
            this.nJs.LoadData();
        }
    }

    public int getPropId() {
        return this.nIT.getPropId();
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
