package com.baidu.tieba.themeCenter.background;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tieba.themeCenter.background.y;
/* loaded from: classes.dex */
public class BackgroundPreviewActivity extends BaseActivity<BackgroundPreviewActivity> {
    private int dMA;
    private y.a dMB = new s(this);
    private int dMg;
    private y dMy;
    private aa dMz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.dMg = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.PROPID, 0);
            this.dMA = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.INUSE, 0);
        }
        this.dMy = new y(this.dMg, this.dMA);
        this.dMy.a(this.dMB);
        this.dMz = new aa(this);
        showLoadingView(this.dMz.getRootView());
        this.dMz.setExpandListRefreshListener(new t(this));
        this.dMy.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.m411getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
            showLoadingView(this.dMz.getRootView());
            this.dMy.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dMz != null) {
            this.dMz.ot();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dMy != null) {
            this.dMy.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dMy != null && this.dMz != null) {
            showLoadingView(this.dMz.getRootView());
            this.dMy.LoadData();
        }
    }
}
