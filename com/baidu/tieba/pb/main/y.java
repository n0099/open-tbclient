package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.dialog.l {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.bvg = pbActivity;
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
            TiebaStatic.eventStat(this.bvg, "pb_phone_call", "call");
            PbActivity pbActivity = this.bvg;
            str6 = this.bvg.buq;
            pbActivity.buq = str6.trim();
            PbActivity pbActivity2 = this.bvg;
            str7 = this.bvg.buq;
            com.baidu.tieba.util.q.F(pbActivity2, str7);
            bnVar2 = this.bvg.buG;
            String WF = bnVar2.WF();
            str8 = this.bvg.buq;
            new a(WF, str8, "1").start();
            iVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.bvg, "pb_phone_sms", "sms");
            PbActivity pbActivity3 = this.bvg;
            str3 = this.bvg.buq;
            pbActivity3.buq = str3.trim();
            PbActivity pbActivity4 = this.bvg;
            str4 = this.bvg.buq;
            com.baidu.tieba.util.q.G(pbActivity4, str4);
            bnVar = this.bvg.buG;
            String WF2 = bnVar.WF();
            str5 = this.bvg.buq;
            new a(WF2, str5, TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT).start();
            iVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity5 = this.bvg;
            str = this.bvg.buq;
            pbActivity5.buq = str.trim();
            PbActivity pbActivity6 = this.bvg;
            str2 = this.bvg.buq;
            com.baidu.tieba.util.q.H(pbActivity6, str2);
            iVar.dismiss();
        }
    }
}
