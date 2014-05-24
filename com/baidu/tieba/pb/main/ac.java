package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.dialog.g {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.g
    public void a(com.baidu.tbadk.core.dialog.d dVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        bj bjVar;
        String str5;
        String str6;
        String str7;
        bj bjVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.a, "pb_phone_call", "call");
            PbActivity pbActivity = this.a;
            str6 = this.a.I;
            pbActivity.I = str6.trim();
            PbActivity pbActivity2 = this.a;
            str7 = this.a.I;
            com.baidu.tieba.util.r.b(pbActivity2, str7);
            bjVar2 = this.a.x;
            String f = bjVar2.f();
            str8 = this.a.I;
            new a(f, str8, TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK).start();
            dVar.c();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.a, "pb_phone_sms", "sms");
            PbActivity pbActivity3 = this.a;
            str3 = this.a.I;
            pbActivity3.I = str3.trim();
            PbActivity pbActivity4 = this.a;
            str4 = this.a.I;
            com.baidu.tieba.util.r.c(pbActivity4, str4);
            bjVar = this.a.x;
            String f2 = bjVar.f();
            str5 = this.a.I;
            new a(f2, str5, TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT).start();
            dVar.c();
        } else if (i == 2) {
            PbActivity pbActivity5 = this.a;
            str = this.a.I;
            pbActivity5.I = str.trim();
            PbActivity pbActivity6 = this.a;
            str2 = this.a.I;
            com.baidu.tieba.util.r.d(pbActivity6, str2);
            dVar.c();
        }
    }
}
