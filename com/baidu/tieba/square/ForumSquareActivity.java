package com.baidu.tieba.square;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes2.dex */
public class ForumSquareActivity extends BaseActivity<ForumSquareActivity> {
    private a npF;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.npF = new a(this, getPageContext());
        this.npF.W(getIntent());
        setContentView(this.npF.npH.getRootLayout());
        this.npF.startLoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.npF.npH != null) {
            this.npF.npH.changeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public a dLw() {
        return this.npF;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a073";
    }
}
