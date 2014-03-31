package com.baidu.tieba.person;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
/* loaded from: classes.dex */
public class SingleMyPersonInfoActivity extends com.baidu.tbadk.core.e {
    private PersonInfoActivity c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                bundle2.putAll(intent.getExtras());
            }
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.c = new PersonInfoActivity();
        this.c.setArguments(bundle2);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.add(16908290, this.c);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.baidu.tbadk.core.e
    protected final void c(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.c != null) {
            this.c.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.e, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
