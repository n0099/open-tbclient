package com.baidu.tieba.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f1840a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.f1840a = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        String str;
        Activity activity4;
        try {
            activity = this.f1840a.u;
            if (com.baidu.adp.lib.e.e.b(activity, "com.baidu.tieba.local")) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.baidu.tieba.local", "com.baidu.tieba.local.activity.logo.LogoActivity"));
                str = this.f1840a.v;
                intent.putExtra("fname", str);
                activity4 = this.f1840a.u;
                activity4.startActivityForResult(intent, -1);
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://static.tieba.baidu.com/client/android/youliao_kehuduan.apk"));
                activity2 = this.f1840a.u;
                activity2.startActivity(intent2);
            }
            if (TiebaApplication.g().u()) {
                activity3 = this.f1840a.u;
                StatService.onEvent(activity3, "frs_start_local", "frsclick", 1);
            }
        } catch (Exception e) {
        }
    }
}
