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
    private BackgroundListModel nGM;
    private f nGN;
    d nGn;
    private BackgroundListModel.a nGO = new BackgroundListModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundListModel.a
        public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.e eVar, List<DressItemData> list) {
            BackgroundListActivity.this.nGN.bRB();
            BackgroundListActivity.this.hideLoadingView(BackgroundListActivity.this.nGN.getRootView());
            if (i == 0) {
                BackgroundListActivity.this.nGN.a(eVar, list, BackgroundListActivity.this.nGM.dRf());
                return;
            }
            BackgroundListActivity.this.showToast(str);
            BackgroundListActivity.this.nGN.cAH();
        }
    };
    private BdListView.e gBo = new BdListView.e() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (BackgroundListActivity.this.nGM != null) {
                BackgroundListActivity.this.nGM.dRe();
            }
        }
    };
    private final f.c gHl = new f.c() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (BackgroundListActivity.this.nGM != null) {
                BackgroundListActivity.this.nGM.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.nGM = new BackgroundListModel(this);
        this.nGM.a(this.nGO);
        this.nGn = new d(this.mPageContext, this.nGM.getUniqueId());
        this.nGn.setFrom(0);
        this.nGN = new f(this, this.nGn);
        this.nGN.a(this.gBo, this.gHl);
        showLoadingView(this.nGN.getRootView());
        this.nGM.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nGN.getRootView());
            this.nGM.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nGN != null) {
            this.nGN.bzn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nGM != null) {
            this.nGM.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nGM != null && this.nGN != null) {
            showLoadingView(this.nGN.getRootView());
            this.nGM.LoadData();
        }
    }

    public int getPropId() {
        return this.nGn.getPropId();
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
