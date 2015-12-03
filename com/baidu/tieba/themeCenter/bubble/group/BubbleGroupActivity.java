package com.baidu.tieba.themeCenter.bubble.group;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.bubble.group.d;
/* loaded from: classes.dex */
public class BubbleGroupActivity extends BaseActivity<BubbleGroupActivity> {
    private d dFv;
    private g dFw;
    private com.baidu.tieba.themeCenter.bubble.all.a dFx;
    private d.a dFy = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dFv = new d(this);
        this.dFv.a(this.dFy);
        this.dFx = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.dFw = new g(this, this.dFx);
        this.dFw.aFp();
        showLoadingView(this.dFw.getRootView());
        this.dFv.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dFw != null) {
            this.dFw.oV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dFv != null && this.dFw != null) {
            showLoadingView(this.dFw.getRootView());
            this.dFv.LoadData();
        }
    }
}
