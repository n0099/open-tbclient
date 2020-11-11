package com.baidu.tieba.square;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes22.dex */
public class ForumSquareActivity extends BaseActivity<ForumSquareActivity> {
    private a mPw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPw = new a(this, getPageContext());
        this.mPw.V(getIntent());
        setContentView(this.mPw.mPy.getRootLayout());
        this.mPw.startLoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPw.mPy != null) {
            this.mPw.mPy.changeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public a dHU() {
        return this.mPw;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a073";
    }
}
