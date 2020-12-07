package com.baidu.tieba.square;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes22.dex */
public class ForumSquareActivity extends BaseActivity<ForumSquareActivity> {
    private a neu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.neu = new a(this, getPageContext());
        this.neu.V(getIntent());
        setContentView(this.neu.f5new.getRootLayout());
        this.neu.startLoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.neu.f5new != null) {
            this.neu.f5new.changeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public a dNb() {
        return this.neu;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a073";
    }
}
