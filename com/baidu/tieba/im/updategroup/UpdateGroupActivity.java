package com.baidu.tieba.im.updategroup;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tieba.im.model.ao;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class UpdateGroupActivity extends com.baidu.tieba.f {
    private ao d;
    private a c = null;
    private int e = 1;
    private d f = null;
    DialogInterface.OnClickListener a = new b(this);
    DialogInterface.OnClickListener b = new c(this);

    public static void a(Activity activity, int i, int i2, int i3, String str) {
        Intent intent = new Intent(activity, UpdateGroupActivity.class);
        intent.putExtra("group_id", i2);
        intent.putExtra("edit_type", i3);
        intent.putExtra("group_text", str);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(UpdateGroupActivity updateGroupActivity, String str, int i) {
        if (i < 0) {
            updateGroupActivity.showToast(R.string.neterror);
        } else if (TextUtils.isEmpty(str)) {
        } else {
            updateGroupActivity.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("edit_type", 1);
        int intExtra2 = intent.getIntExtra("group_id", 0);
        String stringExtra = intent.getStringExtra("group_text");
        if (intExtra == 1) {
            this.c = new f(this);
        } else if (intExtra == 2) {
            this.c = new e(this);
        }
        this.e = intExtra;
        this.c.a(intExtra2);
        this.d = new ao();
        this.c.a(stringExtra);
        this.c.a(this.b);
        this.c.b(this.a);
        this.f = new d(this);
        com.baidu.tieba.im.messageCenter.d.a().a(103102, this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.c.b(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.c.d_()) {
            if (this.c.l() && this.c.i()) {
                b();
            } else {
                showToast(this.c.j());
            }
        } else if (view == this.c.d()) {
            this.c.f();
        } else if (view == this.c.e() && !a()) {
            finish();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && a()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean a() {
        if (TextUtils.isEmpty(this.c.k()) || !this.c.i() || this.c.k().equals(this.c.e_())) {
            return false;
        }
        this.c.a();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.d.a().a(this.f);
        this.d.d();
    }
}
