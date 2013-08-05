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
public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsHeaderView f1846a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsHeaderView frsHeaderView) {
        this.f1846a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        String str;
        Activity activity4;
        try {
            activity = this.f1846a.v;
            if (com.baidu.adp.lib.e.e.b(activity, "com.baidu.tieba.local")) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.baidu.tieba.local", "com.baidu.tieba.local.activity.logo.LogoActivity"));
                str = this.f1846a.w;
                intent.putExtra("fname", str);
                activity4 = this.f1846a.v;
                activity4.startActivityForResult(intent, -1);
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://static.tieba.baidu.com/client/android/youliao_kehuduan.apk"));
                activity2 = this.f1846a.v;
                activity2.startActivity(intent2);
            }
            if (TiebaApplication.f().t()) {
                activity3 = this.f1846a.v;
                StatService.onEvent(activity3, "frs_start_local", "frsclick", 1);
            }
        } catch (Exception e) {
        }
    }
}
