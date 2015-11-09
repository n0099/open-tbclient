package com.baidu.tieba.themeCenter.theme.top;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.theme.top.d;
/* loaded from: classes.dex */
public class TopThemeListActivity extends BaseActivity<TopThemeListActivity> {
    private com.baidu.tieba.themeCenter.d dhX;
    private d.a dhY = new b(this);
    private d dja;
    private h djb;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dhX = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.djb = new h(this, this.dhX.aAc());
        this.dja = new d();
        this.dja.a(this.dhY);
        showLoadingView(this.djb.getRootView());
        this.dja.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.djb != null) {
            this.djb.oP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dja != null) {
            this.dja.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dja != null && this.djb != null) {
            showLoadingView(this.djb.getRootView());
            this.dja.LoadData();
        }
    }
}
