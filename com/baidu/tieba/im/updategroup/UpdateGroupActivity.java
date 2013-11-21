package com.baidu.tieba.im.updategroup;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tieba.im.model.x;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class UpdateGroupActivity extends com.baidu.tieba.j {
    private x d;
    private a c = null;
    private int e = 1;
    private d f = null;

    /* renamed from: a  reason: collision with root package name */
    DialogInterface.OnClickListener f1785a = new b(this);
    DialogInterface.OnClickListener b = new c(this);

    public static void a(Activity activity, int i, int i2, int i3, String str) {
        Intent intent = new Intent(activity, UpdateGroupActivity.class);
        intent.putExtra("group_id", i2);
        intent.putExtra("edit_type", i3);
        intent.putExtra("group_text", str);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (i < 0) {
            showToast(R.string.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("edit_type", 1);
        int intExtra2 = intent.getIntExtra("group_id", 0);
        String stringExtra = intent.getStringExtra("group_text");
        a(intExtra, intExtra2);
        this.d = new x();
        this.c.a(stringExtra);
        this.c.a(this.b);
        this.c.b(this.f1785a);
        a();
    }

    private void a() {
        this.f = new d(this);
        com.baidu.tieba.im.messageCenter.f.a().a(103102, this.f);
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
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.c.b(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.c.d()) {
            if (this.c.m() && this.c.j()) {
                c();
            } else {
                showToast(this.c.k());
            }
        } else if (view == this.c.e()) {
            this.c.g();
        } else if (view == this.c.f() && !b()) {
            finish();
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && b()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean b() {
        if (TextUtils.isEmpty(this.c.l()) || !this.c.j() || this.c.l().equals(this.c.e_())) {
            return false;
        }
        this.c.f_();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.c.a(true);
        this.d.a(this.c.i());
        if (this.e == 1) {
            this.d.a(this.c.l());
            this.d.b(2);
        } else if (this.e == 2) {
            this.d.b(this.c.l());
            this.d.b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.f.a().a(this.f);
        this.d.g();
    }
}
