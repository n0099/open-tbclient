package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.dressCenter.d;
/* loaded from: classes.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    private f dFT;
    private d dFU;
    private d.a dFV = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dFU = new d(this);
        this.dFU.a(this.dFV);
        this.dFT = new f(this);
        showLoadingView(this.dFT.getRootView());
        this.dFU.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dFT != null) {
            this.dFT.oV();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dFU != null && this.dFT != null) {
            showLoadingView(this.dFT.getRootView());
            this.dFU.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dFU != null) {
            this.dFU.destroy();
        }
    }
}
