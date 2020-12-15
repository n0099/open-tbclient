package com.baidu.tieba.square;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes22.dex */
public class ForumSquareActivity extends BaseActivity<ForumSquareActivity> {

    /* renamed from: new  reason: not valid java name */
    private a f5new;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5new = new a(this, getPageContext());
        this.f5new.V(getIntent());
        setContentView(this.f5new.ney.getRootLayout());
        this.f5new.startLoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.f5new.ney != null) {
            this.f5new.ney.changeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public a dNc() {
        return this.f5new;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a073";
    }
}
