package com.baidu.tieba.themeCenter.background;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewModel;
/* loaded from: classes8.dex */
public class BackgroundPreviewActivity extends BaseActivity<BackgroundPreviewActivity> {
    private int mFrom;
    private BackgroundPreviewModel nJF;
    private j nJG;
    private int nJH;
    private BackgroundPreviewModel.a nJI = new BackgroundPreviewModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundPreviewModel.a
        public void a(int i, String str, DressItemData dressItemData) {
            BackgroundPreviewActivity.this.hideLoadingView(BackgroundPreviewActivity.this.nJG.getRootView());
            if (i == 0) {
                BackgroundPreviewActivity.this.nJG.g(dressItemData);
                return;
            }
            BackgroundPreviewActivity.this.showToast(str);
            BackgroundPreviewActivity.this.nJG.cAU();
        }
    };
    private int nJn;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.nJn = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.PROPID, 0);
            this.nJH = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.INUSE, 0);
            this.mFrom = intent.getIntExtra("from", -1);
        }
        this.nJF = new BackgroundPreviewModel(this.nJn, this.nJH);
        this.nJF.a(this.nJI);
        this.nJG = new j(this);
        showLoadingView(this.nJG.getRootView());
        this.nJG.setExpandListRefreshListener(new BdExpandListView.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity.2
            @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
            public void onRefresh() {
            }

            @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
            public void onNotExpanding() {
            }

            @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
            public void onExpandingDegree(float f) {
            }
        });
        this.nJF.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nJG.getRootView());
            this.nJF.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            com.baidu.tbadk.getUserInfo.b.bCL().bCM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nJG != null) {
            this.nJG.bzq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nJF != null) {
            this.nJF.destroy();
        }
        if (this.nJG != null) {
            this.nJG.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nJF != null && this.nJG != null) {
            showLoadingView(this.nJG.getRootView());
            this.nJF.LoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.BACKGROUND_DETAIL;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.isRouteStat = true;
            pageStayDurationItem.objID = String.valueOf(this.nJn);
        }
        return pageStayDurationItem;
    }

    public int getFrom() {
        return this.mFrom;
    }
}
