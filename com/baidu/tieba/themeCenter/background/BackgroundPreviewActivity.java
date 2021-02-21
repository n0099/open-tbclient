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
    private j nHA;
    private int nHB;
    private BackgroundPreviewModel.a nHC = new BackgroundPreviewModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundPreviewModel.a
        public void a(int i, String str, DressItemData dressItemData) {
            BackgroundPreviewActivity.this.hideLoadingView(BackgroundPreviewActivity.this.nHA.getRootView());
            if (i == 0) {
                BackgroundPreviewActivity.this.nHA.g(dressItemData);
                return;
            }
            BackgroundPreviewActivity.this.showToast(str);
            BackgroundPreviewActivity.this.nHA.cAO();
        }
    };
    private int nHh;
    private BackgroundPreviewModel nHz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.nHh = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.PROPID, 0);
            this.nHB = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.INUSE, 0);
            this.mFrom = intent.getIntExtra("from", -1);
        }
        this.nHz = new BackgroundPreviewModel(this.nHh, this.nHB);
        this.nHz.a(this.nHC);
        this.nHA = new j(this);
        showLoadingView(this.nHA.getRootView());
        this.nHA.setExpandListRefreshListener(new BdExpandListView.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity.2
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
        this.nHz.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nHA.getRootView());
            this.nHz.LoadData();
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
        if (this.nHA != null) {
            this.nHA.bzn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nHz != null) {
            this.nHz.destroy();
        }
        if (this.nHA != null) {
            this.nHA.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nHz != null && this.nHA != null) {
            showLoadingView(this.nHA.getRootView());
            this.nHz.LoadData();
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
            pageStayDurationItem.objID = String.valueOf(this.nHh);
        }
        return pageStayDurationItem;
    }

    public int getFrom() {
        return this.mFrom;
    }
}
