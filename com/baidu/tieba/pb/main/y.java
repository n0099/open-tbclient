package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.dialog.l {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.l
    public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        bn bnVar;
        String str5;
        String str6;
        String str7;
        bn bnVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.bvu, "pb_phone_call", "call");
            PbActivity pbActivity = this.bvu;
            str6 = this.bvu.buE;
            pbActivity.buE = str6.trim();
            PbActivity pbActivity2 = this.bvu;
            str7 = this.bvu.buE;
            com.baidu.tieba.util.q.F(pbActivity2, str7);
            bnVar2 = this.bvu.buU;
            String WI = bnVar2.WI();
            str8 = this.bvu.buE;
            new a(WI, str8, "1").start();
            iVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.bvu, "pb_phone_sms", "sms");
            PbActivity pbActivity3 = this.bvu;
            str3 = this.bvu.buE;
            pbActivity3.buE = str3.trim();
            PbActivity pbActivity4 = this.bvu;
            str4 = this.bvu.buE;
            com.baidu.tieba.util.q.G(pbActivity4, str4);
            bnVar = this.bvu.buU;
            String WI2 = bnVar.WI();
            str5 = this.bvu.buE;
            new a(WI2, str5, TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT).start();
            iVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity5 = this.bvu;
            str = this.bvu.buE;
            pbActivity5.buE = str.trim();
            PbActivity pbActivity6 = this.bvu;
            str2 = this.bvu.buE;
            com.baidu.tieba.util.q.H(pbActivity6, str2);
            iVar.dismiss();
        }
    }
}
