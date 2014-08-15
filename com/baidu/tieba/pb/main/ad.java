package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void a(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        bl blVar;
        String str5;
        String str6;
        String str7;
        bl blVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.a, "pb_phone_call", "call");
            PbActivity pbActivity = this.a;
            str6 = this.a.I;
            pbActivity.I = str6.trim();
            PbActivity pbActivity2 = this.a;
            str7 = this.a.I;
            com.baidu.tieba.util.r.a(pbActivity2, str7);
            blVar2 = this.a.x;
            String g = blVar2.g();
            str8 = this.a.I;
            new a(g, str8, TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK).start();
            eVar.c();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.a, "pb_phone_sms", "sms");
            PbActivity pbActivity3 = this.a;
            str3 = this.a.I;
            pbActivity3.I = str3.trim();
            PbActivity pbActivity4 = this.a;
            str4 = this.a.I;
            com.baidu.tieba.util.r.b(pbActivity4, str4);
            blVar = this.a.x;
            String g2 = blVar.g();
            str5 = this.a.I;
            new a(g2, str5, TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT).start();
            eVar.c();
        } else if (i == 2) {
            PbActivity pbActivity5 = this.a;
            str = this.a.I;
            pbActivity5.I = str.trim();
            PbActivity pbActivity6 = this.a;
            str2 = this.a.I;
            com.baidu.tieba.util.r.c(pbActivity6, str2);
            eVar.c();
        }
    }
}
