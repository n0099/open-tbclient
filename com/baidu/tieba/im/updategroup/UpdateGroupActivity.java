package com.baidu.tieba.im.updategroup;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.model.bx;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class UpdateGroupActivity extends BaseActivity {
    private bx d;
    private a c = null;
    private int e = 1;
    DialogInterface.OnClickListener a = new b(this);
    DialogInterface.OnClickListener b = new c(this);
    private com.baidu.adp.framework.listener.b f = new d(this, MessageTypes.CMD_UPDATE_GROUP);

    public static void a(Activity activity, int i, int i2, int i3, String str) {
        Intent intent = new Intent(activity, UpdateGroupActivity.class);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, i2);
        intent.putExtra("edit_type", i3);
        intent.putExtra("group_text", str);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (i < 0) {
            showToast(u.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("edit_type", 1);
        int intExtra2 = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0);
        String stringExtra = intent.getStringExtra("group_text");
        a(intExtra, intExtra2);
        this.d = new bx();
        this.d.setUniqueId(getUniqueId());
        this.c.a(stringExtra);
        this.c.a(this.b);
        this.c.b(this.a);
        a();
    }

    private void a() {
        registerListener(this.f);
    }

    private void a(int i, int i2) {
        if (i == 1) {
            this.c = new f(this);
        } else if (i == 2) {
            this.c = new e(this);
        }
        this.e = i;
        this.c.a(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.c.b(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.c.c()) {
            if (this.c.l() && this.c.i()) {
                c();
            } else {
                showToast(this.c.j());
            }
        } else if (view == this.c.d()) {
            this.c.f();
        } else if (view == this.c.e() && !b()) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && b()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean b() {
        if (TextUtils.isEmpty(this.c.k()) || !this.c.i() || this.c.k().equals(this.c.b())) {
            return false;
        }
        this.c.a();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.c.a(true);
        this.d.a(this.c.h());
        if (this.e == 1) {
            this.d.a(this.c.k());
            this.d.c(2);
        } else if (this.e == 2) {
            this.d.b(this.c.k());
            this.d.c(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.d.cancelMessage();
    }
}
