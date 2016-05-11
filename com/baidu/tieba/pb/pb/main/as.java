package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements c.b {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        cw cwVar;
        String str5;
        String str6;
        String str7;
        cw cwVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.djE.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.djE;
            str6 = this.djE.dif;
            pbActivity.dif = str6.trim();
            Activity pageActivity = this.djE.getPageContext().getPageActivity();
            str7 = this.djE.dif;
            UtilHelper.callPhone(pageActivity, str7);
            cwVar2 = this.djE.dih;
            String threadID = cwVar2.getThreadID();
            str8 = this.djE.dif;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.djE.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.djE;
            str3 = this.djE.dif;
            pbActivity2.dif = str3.trim();
            Activity pageActivity2 = this.djE.getPageContext().getPageActivity();
            str4 = this.djE.dif;
            UtilHelper.smsPhone(pageActivity2, str4);
            cwVar = this.djE.dih;
            String threadID2 = cwVar.getThreadID();
            str5 = this.djE.dif;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.djE;
            str = this.djE.dif;
            pbActivity3.dif = str.trim();
            Activity pageActivity3 = this.djE.getPageContext().getPageActivity();
            str2 = this.djE.dif;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
