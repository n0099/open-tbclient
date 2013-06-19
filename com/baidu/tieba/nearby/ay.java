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
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.a.m;
        dialog.dismiss();
        try {
            if (com.baidu.adp.lib.e.c.b(this.a, "com.baidu.tieba.local")) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.baidu.tieba.local", "com.baidu.tieba.local.activity.logo.LogoActivity"));
                this.a.startActivityForResult(intent, -1);
            } else {
                this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://static.tieba.baidu.com/client/android/youliao_kehuduan.apk")));
            }
        } catch (Exception e) {
        }
        if (TiebaApplication.e().p()) {
            StatService.onEvent(this.a, "nearby_goto_local", "lbsclick", 1);
        }
    }
}
