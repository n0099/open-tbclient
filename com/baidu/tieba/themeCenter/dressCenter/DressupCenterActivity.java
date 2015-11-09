package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.dressCenter.d;
/* loaded from: classes.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    private f dhL;
    private d dhM;
    private d.a dhN = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dhM = new d();
        this.dhM.a(this.dhN);
        this.dhL = new f(this);
        showLoadingView(this.dhL.getRootView());
        this.dhM.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dhL != null) {
            this.dhL.oP();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dhM != null && this.dhL != null) {
            showLoadingView(this.dhL.getRootView());
            this.dhM.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dhM != null) {
            this.dhM.destroy();
        }
    }
}
