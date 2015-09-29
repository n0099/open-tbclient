package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.dressCenter.d;
/* loaded from: classes.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    private f dfF;
    private d dfG;
    private d.a dfH = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dfG = new d();
        this.dfG.a(this.dfH);
        this.dfF = new f(this);
        showLoadingView(this.dfF.getRootView());
        this.dfG.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dfF != null) {
            this.dfF.oO();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dfG != null && this.dfF != null) {
            showLoadingView(this.dfF.getRootView());
            this.dfG.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dfG != null) {
            this.dfG.destroy();
        }
    }
}
