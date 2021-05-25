package com.baidu.tieba.newinterest.activity;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import d.a.n0.a2.f.a;
/* loaded from: classes4.dex */
public class InterestGuideActivity extends BaseFragmentActivity {
    public a mGuideView;
    public int mScene;

    private void initData() {
        if (getIntent() != null) {
            this.mScene = getIntent().getIntExtra(InterestGuideActivityConfig.KEY_INTEREST_GUID_SHOW_SCENE, 2);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this.mGuideView.g();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        this.mGuideView.h();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        initData();
        a aVar = new a(this, this.mScene);
        this.mGuideView = aVar;
        setContentView(aVar.c());
    }
}
