package com.baidu.tieba.themeCenter.background;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tieba.themeCenter.background.y;
/* loaded from: classes.dex */
public class BackgroundPreviewActivity extends BaseActivity<BackgroundPreviewActivity> {
    private int deT;
    private y dfk;
    private aa dfl;
    private int dfm;
    private y.a dfn = new s(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.deT = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.PROPID, 0);
            this.dfm = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.INUSE, 0);
        }
        this.dfk = new y(this.deT, this.dfm);
        this.dfk.a(this.dfn);
        this.dfl = new aa(this);
        showLoadingView(this.dfl.getRootView());
        this.dfl.setExpandListRefreshListener(new t(this));
        this.dfk.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dfl != null) {
            this.dfl.oO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dfk != null) {
            this.dfk.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dfk != null && this.dfl != null) {
            showLoadingView(this.dfl.getRootView());
            this.dfk.LoadData();
        }
    }
}
