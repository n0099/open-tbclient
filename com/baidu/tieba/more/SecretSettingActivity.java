package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.im.friend.IMBlackListActivity;
/* loaded from: classes.dex */
public class SecretSettingActivity extends com.baidu.tieba.j implements View.OnClickListener {
    private com.baidu.tieba.im.model.l a;
    private an b;
    private com.baidu.tieba.im.messageCenter.g c = new am(this);

    public static void a(Context context) {
        context.startActivity(new Intent(context, SecretSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new an(this);
        this.b.a(this);
        b();
        a();
        c();
    }

    private void a() {
        this.a.a(this.c);
    }

    private void b() {
        this.a = new com.baidu.tieba.im.model.l();
    }

    private void c() {
        this.b.a();
        this.a.a(8);
    }

    private void a(boolean z) {
        this.b.f();
        this.a.a(8, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.b(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.b.e();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.b.h().performClick();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.b.h()) {
            finish();
        } else if (view == this.b.j()) {
            d();
        } else if (view == this.b.i()) {
            boolean z = !view.isSelected();
            this.b.i().setTag(Boolean.valueOf(z));
            a(z);
        }
    }

    private void d() {
        IMBlackListActivity.a(this);
    }
}
