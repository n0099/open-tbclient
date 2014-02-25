package com.baidu.tieba.mention;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
/* loaded from: classes.dex */
public class SingleMentionActivity extends com.baidu.tieba.k {
    c d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle a = a(bundle);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.d = new c();
        this.d.setArguments(a);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.add(16908290, this.d);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    private Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                bundle2.putAll(intent.getExtras());
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResumeFragments() {
        super.onResumeFragments();
    }

    @Override // com.baidu.tieba.k
    protected void b(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.d != null) {
            this.d.onActivityResult(i, i2, intent);
        }
    }
}
