package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements c.b {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        dh dhVar;
        String str5;
        String str6;
        String str7;
        dh dhVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.ebT.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.ebT;
            str6 = this.ebT.eaq;
            pbActivity.eaq = str6.trim();
            Activity pageActivity = this.ebT.getPageContext().getPageActivity();
            str7 = this.ebT.eaq;
            UtilHelper.callPhone(pageActivity, str7);
            dhVar2 = this.ebT.eas;
            String threadID = dhVar2.getThreadID();
            str8 = this.ebT.eaq;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.ebT.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.ebT;
            str3 = this.ebT.eaq;
            pbActivity2.eaq = str3.trim();
            Activity pageActivity2 = this.ebT.getPageContext().getPageActivity();
            str4 = this.ebT.eaq;
            UtilHelper.smsPhone(pageActivity2, str4);
            dhVar = this.ebT.eas;
            String threadID2 = dhVar.getThreadID();
            str5 = this.ebT.eaq;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.ebT;
            str = this.ebT.eaq;
            pbActivity3.eaq = str.trim();
            Activity pageActivity3 = this.ebT.getPageContext().getPageActivity();
            str2 = this.ebT.eaq;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
