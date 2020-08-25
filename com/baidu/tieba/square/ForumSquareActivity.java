package com.baidu.tieba.square;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes16.dex */
public class ForumSquareActivity extends BaseActivity<ForumSquareActivity> {
    private a lXw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lXw = new a(this, getPageContext());
        this.lXw.Y(getIntent());
        setContentView(this.lXw.lXy.getRootLayout());
        this.lXw.startLoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lXw.lXy != null) {
            this.lXw.lXy.changeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public a duB() {
        return this.lXw;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a073";
    }
}
