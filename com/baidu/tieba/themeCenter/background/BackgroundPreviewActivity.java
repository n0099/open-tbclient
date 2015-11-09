package com.baidu.tieba.themeCenter.background;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tieba.themeCenter.background.y;
/* loaded from: classes.dex */
public class BackgroundPreviewActivity extends BaseActivity<BackgroundPreviewActivity> {
    private int dgZ;
    private y dhq;
    private aa dhr;
    private int dhs;
    private y.a dht = new s(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.dgZ = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.PROPID, 0);
            this.dhs = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.INUSE, 0);
        }
        this.dhq = new y(this.dgZ, this.dhs);
        this.dhq.a(this.dht);
        this.dhr = new aa(this);
        showLoadingView(this.dhr.getRootView());
        this.dhr.setExpandListRefreshListener(new t(this));
        this.dhq.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dhr != null) {
            this.dhr.oP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dhq != null) {
            this.dhq.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dhq != null && this.dhr != null) {
            showLoadingView(this.dhr.getRootView());
            this.dhq.LoadData();
        }
    }
}
