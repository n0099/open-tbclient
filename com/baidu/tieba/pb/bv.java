package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements com.baidu.tieba.view.dialog.c {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.dialog.c
    public void a(com.baidu.tieba.view.dialog.a aVar, int i, View view) {
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
            StatService.onEvent(this.a, "pb_phone_call", "call");
            NewPbActivity newPbActivity = this.a;
            str6 = this.a.C;
            newPbActivity.C = str6.trim();
            NewPbActivity newPbActivity2 = this.a;
            str7 = this.a.C;
            UtilHelper.g(newPbActivity2, str7);
            bmVar2 = this.a.t;
            String b = bmVar2.b();
            str8 = this.a.C;
            new com.baidu.tieba.account.u(b, str8, SocialConstants.TRUE).start();
            aVar.c();
        } else if (i == 1) {
            StatService.onEvent(this.a, "pb_phone_sms", "sms");
            NewPbActivity newPbActivity3 = this.a;
            str3 = this.a.C;
            newPbActivity3.C = str3.trim();
            NewPbActivity newPbActivity4 = this.a;
            str4 = this.a.C;
            UtilHelper.h(newPbActivity4, str4);
            bmVar = this.a.t;
            String b2 = bmVar.b();
            str5 = this.a.C;
            new com.baidu.tieba.account.u(b2, str5, "2").start();
            aVar.c();
        } else if (i == 2) {
            NewPbActivity newPbActivity5 = this.a;
            str = this.a.C;
            newPbActivity5.C = str.trim();
            NewPbActivity newPbActivity6 = this.a;
            str2 = this.a.C;
            UtilHelper.i(newPbActivity6, str2);
            aVar.c();
        }
    }
}
