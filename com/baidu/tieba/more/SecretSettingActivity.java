package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.im.friend.IMBlackListActivity;
/* loaded from: classes.dex */
public class SecretSettingActivity extends com.baidu.tieba.f implements View.OnClickListener, com.baidu.adp.widget.BdSwitchView.c {
    private com.baidu.tieba.im.model.k a;
    private am b;
    private com.baidu.tieba.im.messageCenter.g c = new al(this);

    public static void a(Context context) {
        context.startActivity(new Intent(context, SecretSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new am(this);
        this.b.a(this);
        b();
        a();
        c();
    }

    private void a() {
        this.a.a(this.c);
    }

    private void b() {
        this.a = new com.baidu.tieba.im.model.k();
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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.b(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
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
        }
    }

    private void d() {
        IMBlackListActivity.a(this);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            a(true);
        } else {
            a(false);
        }
    }
}
