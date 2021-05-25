package com.baidu.tieba.memberCenter.index;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.tbadk.core.BaseFragmentActivity;
import d.a.m0.k0.d;
/* loaded from: classes3.dex */
public class MembercenterActivity extends BaseFragmentActivity {
    public MemberCenterFragment mFragment;
    public FragmentManager mFragmentManager;
    public FragmentTransaction mFragmentTransaction;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "b016";
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.f49436a = true;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_url");
        MemberCenterFragment memberCenterFragment = new MemberCenterFragment();
        this.mFragment = memberCenterFragment;
        memberCenterFragment.I0(stringExtra);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.mFragmentManager = supportFragmentManager;
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        this.mFragmentTransaction = beginTransaction;
        beginTransaction.add(16908290, this.mFragment);
        this.mFragmentTransaction.commit();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MemberCenterFragment memberCenterFragment = this.mFragment;
        if (memberCenterFragment != null) {
            memberCenterFragment.loadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
