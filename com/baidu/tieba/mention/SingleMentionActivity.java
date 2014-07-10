package com.baidu.tieba.mention;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.bn;
/* loaded from: classes.dex */
public class SingleMentionActivity extends BaseFragmentActivity {
    f c;
    private boolean d;

    static {
        TbadkApplication.m252getInst().RegisterIntent(bn.class, SingleMentionActivity.class);
        bn.a(SingleMentionActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Bundle a = a(bundle);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.c = new f();
        this.c.setArguments(a);
        this.d = this.c.getArguments().getBoolean("is_show_chat");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        if (this.d) {
            str = "tag_three";
        } else {
            str = "tag_two";
        }
        beginTransaction.add(16908290, this.c, str);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        String str;
        String str2;
        super.onNewIntent(intent);
        boolean booleanExtra = intent.getBooleanExtra("is_show_chat", false);
        if (this.d != booleanExtra) {
            if (this.d) {
                str = "tag_three";
            } else {
                str = "tag_two";
            }
            this.d = booleanExtra;
            if (this.d) {
                str2 = "tag_three";
            } else {
                str2 = "tag_two";
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(str);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            Bundle a = a(intent);
            this.c = null;
            this.c = new f();
            this.c.setArguments(a);
            beginTransaction.add(16908290, this.c, str2);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_show_chat", this.d);
    }

    private Bundle a(Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putAll(intent.getExtras());
        return bundle;
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
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResumeFragments() {
        super.onResumeFragments();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.c != null) {
            this.c.onActivityResult(i, i2, intent);
        }
    }
}
