package com.baidu.tieba.themeCenter.background;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tieba.themeCenter.background.y;
/* loaded from: classes.dex */
public class BackgroundPreviewActivity extends BaseActivity<BackgroundPreviewActivity> {
    private y dfK;
    private aa dfL;
    private int dfM;
    private y.a dfN = new s(this);
    private int dft;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.dft = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.PROPID, 0);
            this.dfM = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.INUSE, 0);
        }
        this.dfK = new y(this.dft, this.dfM);
        this.dfK.a(this.dfN);
        this.dfL = new aa(this);
        showLoadingView(this.dfL.getRootView());
        this.dfL.setExpandListRefreshListener(new t(this));
        this.dfK.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dfL != null) {
            this.dfL.oO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dfK != null) {
            this.dfK.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dfK != null && this.dfL != null) {
            showLoadingView(this.dfL.getRootView());
            this.dfK.LoadData();
        }
    }
}
