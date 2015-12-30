package com.baidu.tieba.themeCenter.bubble.group;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.bubble.group.d;
/* loaded from: classes.dex */
public class BubbleGroupActivity extends BaseActivity<BubbleGroupActivity> {
    private d dMX;
    private g dMY;
    private com.baidu.tieba.themeCenter.bubble.all.a dMZ;
    private d.a dNa = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dMX = new d(this);
        this.dMX.a(this.dNa);
        this.dMZ = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.dMY = new g(this, this.dMZ);
        this.dMY.aHE();
        showLoadingView(this.dMY.getRootView());
        this.dMX.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dMY != null) {
            this.dMY.ot();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dMX != null && this.dMY != null) {
            showLoadingView(this.dMY.getRootView());
            this.dMX.LoadData();
        }
    }
}
