package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements com.baidu.tieba.view.dialog.f {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.dialog.f
    public void a(com.baidu.tieba.view.dialog.d dVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.tieba.model.bm bmVar;
        String str5;
        String str6;
        String str7;
        com.baidu.tieba.model.bm bmVar2;
        String str8;
        if (i == 0) {
            com.baidu.tieba.util.by.a(this.a, "pb_phone_call", "call");
            NewPbActivity newPbActivity = this.a;
            str6 = this.a.D;
            newPbActivity.D = str6.trim();
            NewPbActivity newPbActivity2 = this.a;
            str7 = this.a.D;
            UtilHelper.g(newPbActivity2, str7);
            bmVar2 = this.a.u;
            String b = bmVar2.b();
            str8 = this.a.D;
            new com.baidu.tieba.account.u(b, str8, SocialConstants.TRUE).start();
            dVar.c();
        } else if (i == 1) {
            com.baidu.tieba.util.by.a(this.a, "pb_phone_sms", "sms");
            NewPbActivity newPbActivity3 = this.a;
            str3 = this.a.D;
            newPbActivity3.D = str3.trim();
            NewPbActivity newPbActivity4 = this.a;
            str4 = this.a.D;
            UtilHelper.h(newPbActivity4, str4);
            bmVar = this.a.u;
            String b2 = bmVar.b();
            str5 = this.a.D;
            new com.baidu.tieba.account.u(b2, str5, "2").start();
            dVar.c();
        } else if (i == 2) {
            NewPbActivity newPbActivity5 = this.a;
            str = this.a.D;
            newPbActivity5.D = str.trim();
            NewPbActivity newPbActivity6 = this.a;
            str2 = this.a.D;
            UtilHelper.i(newPbActivity6, str2);
            dVar.c();
        }
    }
}
