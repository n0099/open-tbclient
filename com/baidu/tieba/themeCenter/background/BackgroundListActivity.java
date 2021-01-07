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
    private BackgroundListModel nBG;
    private f nBH;
    d nBh;
    private BackgroundListModel.a nBI = new BackgroundListModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundListModel.a
        public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.e eVar, List<DressItemData> list) {
            BackgroundListActivity.this.nBH.bUP();
            BackgroundListActivity.this.hideLoadingView(BackgroundListActivity.this.nBH.getRootView());
            if (i == 0) {
                BackgroundListActivity.this.nBH.a(eVar, list, BackgroundListActivity.this.nBG.dSM());
                return;
            }
            BackgroundListActivity.this.showToast(str);
            BackgroundListActivity.this.nBH.cDo();
        }
    };
    private BdListView.e gDl = new BdListView.e() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (BackgroundListActivity.this.nBG != null) {
                BackgroundListActivity.this.nBG.dSL();
            }
        }
    };
    private final f.c gJh = new f.c() { // from class: com.baidu.tieba.themeCenter.background.BackgroundListActivity.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (BackgroundListActivity.this.nBG != null) {
                BackgroundListActivity.this.nBG.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.nBG = new BackgroundListModel(this);
        this.nBG.a(this.nBI);
        this.nBh = new d(this.mPageContext, this.nBG.getUniqueId());
        this.nBh.setFrom(0);
        this.nBH = new f(this, this.nBh);
        this.nBH.a(this.gDl, this.gJh);
        showLoadingView(this.nBH.getRootView());
        this.nBG.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nBH.getRootView());
            this.nBG.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nBH != null) {
            this.nBH.bCP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nBG != null) {
            this.nBG.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nBG != null && this.nBH != null) {
            showLoadingView(this.nBH.getRootView());
            this.nBG.LoadData();
        }
    }

    public int getPropId() {
        return this.nBh.getPropId();
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
