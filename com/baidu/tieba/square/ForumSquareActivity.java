package com.baidu.tieba.square;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import d.b.i0.z2.a;
import d.b.i0.z2.b;
/* loaded from: classes5.dex */
public class ForumSquareActivity extends BaseActivity<ForumSquareActivity> {
    public a mDelegate;

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a073";
    }

    public a getDelegate() {
        return this.mDelegate;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        b bVar = this.mDelegate.f63441d;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(this, getPageContext());
        this.mDelegate = aVar;
        aVar.j(getIntent());
        setContentView(this.mDelegate.f63441d.d());
        this.mDelegate.m();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
