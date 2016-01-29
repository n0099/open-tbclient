package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements c.b {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        cm cmVar;
        String str5;
        String str6;
        String str7;
        cm cmVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.cNq.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.cNq;
            str6 = this.cNq.cMf;
            pbActivity.cMf = str6.trim();
            Activity pageActivity = this.cNq.getPageContext().getPageActivity();
            str7 = this.cNq.cMf;
            UtilHelper.callPhone(pageActivity, str7);
            cmVar2 = this.cNq.cMF;
            String threadID = cmVar2.getThreadID();
            str8 = this.cNq.cMf;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.cNq.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.cNq;
            str3 = this.cNq.cMf;
            pbActivity2.cMf = str3.trim();
            Activity pageActivity2 = this.cNq.getPageContext().getPageActivity();
            str4 = this.cNq.cMf;
            UtilHelper.smsPhone(pageActivity2, str4);
            cmVar = this.cNq.cMF;
            String threadID2 = cmVar.getThreadID();
            str5 = this.cNq.cMf;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.cNq;
            str = this.cNq.cMf;
            pbActivity3.cMf = str.trim();
            Activity pageActivity3 = this.cNq.getPageContext().getPageActivity();
            str2 = this.cNq.cMf;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
