package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
final class ad implements com.baidu.tbadk.core.dialog.g {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.g
    public final void a(com.baidu.tbadk.core.dialog.d dVar, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        bd bdVar;
        String str5;
        String str6;
        String str7;
        bd bdVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.a(this.a, "pb_phone_call", "call");
            PbActivity pbActivity = this.a;
            str6 = this.a.I;
            pbActivity.I = str6.trim();
            PbActivity pbActivity2 = this.a;
            str7 = this.a.I;
            UtilHelper.callPhone(pbActivity2, str7);
            bdVar2 = this.a.x;
            String f = bdVar2.f();
            str8 = this.a.I;
            new a(f, str8, "1").start();
            dVar.c();
        } else if (i == 1) {
            TiebaStatic.a(this.a, "pb_phone_sms", "sms");
            PbActivity pbActivity3 = this.a;
            str3 = this.a.I;
            pbActivity3.I = str3.trim();
            PbActivity pbActivity4 = this.a;
            str4 = this.a.I;
            UtilHelper.smsPhone(pbActivity4, str4);
            bdVar = this.a.x;
            String f2 = bdVar.f();
            str5 = this.a.I;
            new a(f2, str5, "2").start();
            dVar.c();
        } else if (i == 2) {
            PbActivity pbActivity5 = this.a;
            str = this.a.I;
            pbActivity5.I = str.trim();
            PbActivity pbActivity6 = this.a;
            str2 = this.a.I;
            UtilHelper.startBaiDuBar(pbActivity6, str2);
            dVar.c();
        }
    }
}
