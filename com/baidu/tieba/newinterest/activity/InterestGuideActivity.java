package com.baidu.tieba.newinterest.activity;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.newinterest.d.a;
/* loaded from: classes10.dex */
public class InterestGuideActivity extends BaseFragmentActivity {
    private a jTr;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.jTr = new a(this);
        setContentView(this.jTr.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.jTr.onChangeSkinType();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this.jTr.onBackPressed();
    }
}
