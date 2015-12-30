package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.dressCenter.d;
/* loaded from: classes.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    private f dNv;
    private d dNw;
    private d.a dNx = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dNw = new d(this);
        this.dNw.a(this.dNx);
        this.dNv = new f(this);
        showLoadingView(this.dNv.getRootView());
        this.dNw.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dNv != null) {
            this.dNv.ot();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dNw != null && this.dNv != null) {
            showLoadingView(this.dNv.getRootView());
            this.dNw.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dNw != null) {
            this.dNw.destroy();
        }
    }
}
