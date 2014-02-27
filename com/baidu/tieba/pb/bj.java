package com.baidu.tieba.pb;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
final class bj implements com.baidu.tieba.view.dialog.f {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.dialog.f
    public final void a(com.baidu.tieba.view.dialog.d dVar, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.tieba.model.bb bbVar;
        String str5;
        String str6;
        String str7;
        com.baidu.tieba.model.bb bbVar2;
        String str8;
        if (i == 0) {
            com.baidu.tieba.util.cb.a(this.a, "pb_phone_call", "call");
            NewPbActivity newPbActivity = this.a;
            str6 = this.a.F;
            newPbActivity.F = str6.trim();
            NewPbActivity newPbActivity2 = this.a;
            str7 = this.a.F;
            UtilHelper.g(newPbActivity2, str7);
            bbVar2 = this.a.w;
            String g = bbVar2.g();
            str8 = this.a.F;
            new com.baidu.tieba.account.v(g, str8, SocialConstants.TRUE).start();
            dVar.c();
        } else if (i == 1) {
            com.baidu.tieba.util.cb.a(this.a, "pb_phone_sms", "sms");
            NewPbActivity newPbActivity3 = this.a;
            str3 = this.a.F;
            newPbActivity3.F = str3.trim();
            NewPbActivity newPbActivity4 = this.a;
            str4 = this.a.F;
            UtilHelper.h(newPbActivity4, str4);
            bbVar = this.a.w;
            String g2 = bbVar.g();
            str5 = this.a.F;
            new com.baidu.tieba.account.v(g2, str5, "2").start();
            dVar.c();
        } else if (i == 2) {
            NewPbActivity newPbActivity5 = this.a;
            str = this.a.F;
            newPbActivity5.F = str.trim();
            NewPbActivity newPbActivity6 = this.a;
            str2 = this.a.F;
            UtilHelper.i(newPbActivity6, str2);
            dVar.c();
        }
    }
}
