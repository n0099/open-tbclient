package com.baidu.tieba.themeCenter.background;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewModel;
/* loaded from: classes9.dex */
public class BackgroundPreviewActivity extends BaseActivity<BackgroundPreviewActivity> {
    private int mFrom;
    private int nBB;
    private BackgroundPreviewModel nBT;
    private j nBU;
    private int nBV;
    private BackgroundPreviewModel.a nBW = new BackgroundPreviewModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundPreviewModel.a
        public void a(int i, String str, DressItemData dressItemData) {
            BackgroundPreviewActivity.this.hideLoadingView(BackgroundPreviewActivity.this.nBU.getRootView());
            if (i == 0) {
                BackgroundPreviewActivity.this.nBU.g(dressItemData);
                return;
            }
            BackgroundPreviewActivity.this.showToast(str);
            BackgroundPreviewActivity.this.nBU.cDo();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.nBB = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.PROPID, 0);
            this.nBV = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.INUSE, 0);
            this.mFrom = intent.getIntExtra("from", -1);
        }
        this.nBT = new BackgroundPreviewModel(this.nBB, this.nBV);
        this.nBT.a(this.nBW);
        this.nBU = new j(this);
        showLoadingView(this.nBU.getRootView());
        this.nBU.setExpandListRefreshListener(new BdExpandListView.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity.2
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
        this.nBT.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nBU.getRootView());
            this.nBT.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            com.baidu.tbadk.getUserInfo.b.bGj().bGk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nBU != null) {
            this.nBU.bCP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nBT != null) {
            this.nBT.destroy();
        }
        if (this.nBU != null) {
            this.nBU.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nBT != null && this.nBU != null) {
            showLoadingView(this.nBU.getRootView());
            this.nBT.LoadData();
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
            pageStayDurationItem.objID = String.valueOf(this.nBB);
        }
        return pageStayDurationItem;
    }

    public int getFrom() {
        return this.mFrom;
    }
}
