package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements c.b {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        cf cfVar;
        String str5;
        String str6;
        String str7;
        cf cfVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.cFS.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.cFS;
            str6 = this.cFS.cEO;
            pbActivity.cEO = str6.trim();
            Activity pageActivity = this.cFS.getPageContext().getPageActivity();
            str7 = this.cFS.cEO;
            UtilHelper.callPhone(pageActivity, str7);
            cfVar2 = this.cFS.cFl;
            String threadID = cfVar2.getThreadID();
            str8 = this.cFS.cEO;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.cFS.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.cFS;
            str3 = this.cFS.cEO;
            pbActivity2.cEO = str3.trim();
            Activity pageActivity2 = this.cFS.getPageContext().getPageActivity();
            str4 = this.cFS.cEO;
            UtilHelper.smsPhone(pageActivity2, str4);
            cfVar = this.cFS.cFl;
            String threadID2 = cfVar.getThreadID();
            str5 = this.cFS.cEO;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.cFS;
            str = this.cFS.cEO;
            pbActivity3.cEO = str.trim();
            Activity pageActivity3 = this.cFS.getPageContext().getPageActivity();
            str2 = this.cFS.cEO;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
