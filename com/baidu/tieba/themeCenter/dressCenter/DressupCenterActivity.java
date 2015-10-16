package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.dressCenter.d;
/* loaded from: classes.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    private f dgf;
    private d dgg;
    private d.a dgh = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dgg = new d();
        this.dgg.a(this.dgh);
        this.dgf = new f(this);
        showLoadingView(this.dgf.getRootView());
        this.dgg.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dgf != null) {
            this.dgf.oO();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dgg != null && this.dgf != null) {
            showLoadingView(this.dgf.getRootView());
            this.dgg.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dgg != null) {
            this.dgg.destroy();
        }
    }
}
