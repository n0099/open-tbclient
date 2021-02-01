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
    private int nGH;
    private BackgroundPreviewModel nGZ;
    private j nHa;
    private int nHb;
    private BackgroundPreviewModel.a nHc = new BackgroundPreviewModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundPreviewModel.a
        public void a(int i, String str, DressItemData dressItemData) {
            BackgroundPreviewActivity.this.hideLoadingView(BackgroundPreviewActivity.this.nHa.getRootView());
            if (i == 0) {
                BackgroundPreviewActivity.this.nHa.g(dressItemData);
                return;
            }
            BackgroundPreviewActivity.this.showToast(str);
            BackgroundPreviewActivity.this.nHa.cAH();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.nGH = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.PROPID, 0);
            this.nHb = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.INUSE, 0);
            this.mFrom = intent.getIntExtra("from", -1);
        }
        this.nGZ = new BackgroundPreviewModel(this.nGH, this.nHb);
        this.nGZ.a(this.nHc);
        this.nHa = new j(this);
        showLoadingView(this.nHa.getRootView());
        this.nHa.setExpandListRefreshListener(new BdExpandListView.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity.2
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
        this.nGZ.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nHa.getRootView());
            this.nGZ.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            com.baidu.tbadk.getUserInfo.b.bCI().bCJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nHa != null) {
            this.nHa.bzn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nGZ != null) {
            this.nGZ.destroy();
        }
        if (this.nHa != null) {
            this.nHa.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nGZ != null && this.nHa != null) {
            showLoadingView(this.nHa.getRootView());
            this.nGZ.LoadData();
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
            pageStayDurationItem.objID = String.valueOf(this.nGH);
        }
        return pageStayDurationItem;
    }

    public int getFrom() {
        return this.mFrom;
    }
}
