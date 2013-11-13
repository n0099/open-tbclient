package com.baidu.tieba.mention;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.BaseFragmentActivity;
/* loaded from: classes.dex */
public class SingleMentionActivity extends BaseFragmentActivity {
    MentionActivity b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle a2 = a(bundle);
        android.support.v4.app.t supportFragmentManager = getSupportFragmentManager();
        this.b = new MentionActivity();
        this.b.g(a2);
        android.support.v4.app.ae a3 = supportFragmentManager.a();
        a3.a(16908290, this.b);
        a3.a();
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
