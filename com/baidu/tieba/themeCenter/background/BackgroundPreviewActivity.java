package com.baidu.tieba.themeCenter.background;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tieba.themeCenter.background.y;
/* loaded from: classes.dex */
public class BackgroundPreviewActivity extends BaseActivity<BackgroundPreviewActivity> {
    private int dED;
    private y dEW;
    private aa dEX;
    private int dEY;
    private y.a dEZ = new s(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.dED = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.PROPID, 0);
            this.dEY = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.INUSE, 0);
        }
        this.dEW = new y(this.dED, this.dEY);
        this.dEW.a(this.dEZ);
        this.dEX = new aa(this);
        showLoadingView(this.dEX.getRootView());
        this.dEX.setExpandListRefreshListener(new t(this));
        this.dEW.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.m411getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
            showLoadingView(this.dEX.getRootView());
            this.dEW.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dEX != null) {
            this.dEX.oV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dEW != null) {
            this.dEW.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dEW != null && this.dEX != null) {
            showLoadingView(this.dEX.getRootView());
            this.dEW.LoadData();
        }
    }
}
