package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements c.b {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        dc dcVar;
        String str5;
        String str6;
        String str7;
        dc dcVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.eah.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.eah;
            str6 = this.eah.dYy;
            pbActivity.dYy = str6.trim();
            Activity pageActivity = this.eah.getPageContext().getPageActivity();
            str7 = this.eah.dYy;
            UtilHelper.callPhone(pageActivity, str7);
            dcVar2 = this.eah.dYA;
            String threadID = dcVar2.getThreadID();
            str8 = this.eah.dYy;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.eah.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.eah;
            str3 = this.eah.dYy;
            pbActivity2.dYy = str3.trim();
            Activity pageActivity2 = this.eah.getPageContext().getPageActivity();
            str4 = this.eah.dYy;
            UtilHelper.smsPhone(pageActivity2, str4);
            dcVar = this.eah.dYA;
            String threadID2 = dcVar.getThreadID();
            str5 = this.eah.dYy;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.eah;
            str = this.eah.dYy;
            pbActivity3.dYy = str.trim();
            Activity pageActivity3 = this.eah.getPageContext().getPageActivity();
            str2 = this.eah.dYy;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
