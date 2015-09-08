package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        bk bkVar;
        String str5;
        String str6;
        String str7;
        bk bkVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.ccj.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.ccj;
            str6 = this.ccj.cbt;
            pbActivity.cbt = str6.trim();
            Activity pageActivity = this.ccj.getPageContext().getPageActivity();
            str7 = this.ccj.cbt;
            UtilHelper.callPhone(pageActivity, str7);
            bkVar2 = this.ccj.cbG;
            String threadID = bkVar2.getThreadID();
            str8 = this.ccj.cbt;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.ccj.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.ccj;
            str3 = this.ccj.cbt;
            pbActivity2.cbt = str3.trim();
            Activity pageActivity2 = this.ccj.getPageContext().getPageActivity();
            str4 = this.ccj.cbt;
            UtilHelper.smsPhone(pageActivity2, str4);
            bkVar = this.ccj.cbG;
            String threadID2 = bkVar.getThreadID();
            str5 = this.ccj.cbt;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.ccj;
            str = this.ccj.cbt;
            pbActivity3.cbt = str.trim();
            Activity pageActivity3 = this.ccj.getPageContext().getPageActivity();
            str2 = this.ccj.cbt;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
