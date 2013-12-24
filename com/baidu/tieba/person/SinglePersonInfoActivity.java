package com.baidu.tieba.person;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.BaseFragmentActivity;
/* loaded from: classes.dex */
public class SinglePersonInfoActivity extends BaseFragmentActivity {
    private PersonInfoActivity b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle a = a(bundle);
        android.support.v4.app.t supportFragmentManager = getSupportFragmentManager();
        this.b = new PersonInfoActivity();
        this.b.g(a);
        android.support.v4.app.ae a2 = supportFragmentManager.a();
        a2.a(16908290, this.b);
        a2.a();
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

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.b != null) {
            this.b.a(i, i2, intent);
        }
    }
}
