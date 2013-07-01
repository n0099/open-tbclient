package com.baidu.tieba.nearby;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewNearbyActivity f1147a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewNearbyActivity newNearbyActivity) {
        this.f1147a = newNearbyActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.f1147a.m;
        dialog.dismiss();
        try {
            if (com.baidu.adp.lib.c.c.b(this.f1147a, "com.baidu.tieba.local")) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.baidu.tieba.local", "com.baidu.tieba.local.activity.logo.LogoActivity"));
                this.f1147a.startActivityForResult(intent, -1);
            } else {
                this.f1147a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://static.tieba.baidu.com/client/android/youliao_kehuduan.apk")));
            }
        } catch (Exception e) {
        }
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this.f1147a, "nearby_goto_local", "lbsclick", 1);
        }
    }
}
