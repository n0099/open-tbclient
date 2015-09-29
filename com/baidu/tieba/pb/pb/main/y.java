package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
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
            TiebaStatic.eventStat(this.ciz.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.ciz;
            str6 = this.ciz.chI;
            pbActivity.chI = str6.trim();
            Activity pageActivity = this.ciz.getPageContext().getPageActivity();
            str7 = this.ciz.chI;
            UtilHelper.callPhone(pageActivity, str7);
            blVar2 = this.ciz.chV;
            String threadID = blVar2.getThreadID();
            str8 = this.ciz.chI;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.ciz.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.ciz;
            str3 = this.ciz.chI;
            pbActivity2.chI = str3.trim();
            Activity pageActivity2 = this.ciz.getPageContext().getPageActivity();
            str4 = this.ciz.chI;
            UtilHelper.smsPhone(pageActivity2, str4);
            blVar = this.ciz.chV;
            String threadID2 = blVar.getThreadID();
            str5 = this.ciz.chI;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.ciz;
            str = this.ciz.chI;
            pbActivity3.chI = str.trim();
            Activity pageActivity3 = this.ciz.getPageContext().getPageActivity();
            str2 = this.ciz.chI;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
