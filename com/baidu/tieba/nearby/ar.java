package com.baidu.tieba.nearby;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ aq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.a = aqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (com.baidu.adp.lib.c.c.b(this.a.a, "com.baidu.tieba.local")) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.baidu.tieba.local", "com.baidu.tieba.local.activity.logo.LogoActivity"));
                this.a.a.startActivity(intent);
            } else {
                this.a.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://static.tieba.baidu.com/client/android/youliao_kehuduan.apk")));
            }
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this.a.a, "lbs_list_goto_local", "lbsclick", 1);
            }
        } catch (Exception e) {
        }
    }
}
