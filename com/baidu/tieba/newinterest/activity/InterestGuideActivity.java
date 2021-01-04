package com.baidu.tieba.newinterest.activity;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.newinterest.c.a;
/* loaded from: classes8.dex */
public class InterestGuideActivity extends BaseFragmentActivity {
    private a lAz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.lAz = new a(this);
        setContentView(this.lAz.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.lAz.onChangeSkinType();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this.lAz.onBackPressed();
    }
}
