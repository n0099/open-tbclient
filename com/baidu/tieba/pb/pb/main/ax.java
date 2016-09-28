package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements c.b {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity) {
        this.eqa = pbActivity;
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
            TiebaStatic.eventStat(this.eqa.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.eqa;
            str6 = this.eqa.eot;
            pbActivity.eot = str6.trim();
            Activity pageActivity = this.eqa.getPageContext().getPageActivity();
            str7 = this.eqa.eot;
            UtilHelper.callPhone(pageActivity, str7);
            dhVar2 = this.eqa.eov;
            String threadID = dhVar2.getThreadID();
            str8 = this.eqa.eot;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.eqa.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.eqa;
            str3 = this.eqa.eot;
            pbActivity2.eot = str3.trim();
            Activity pageActivity2 = this.eqa.getPageContext().getPageActivity();
            str4 = this.eqa.eot;
            UtilHelper.smsPhone(pageActivity2, str4);
            dhVar = this.eqa.eov;
            String threadID2 = dhVar.getThreadID();
            str5 = this.eqa.eot;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.eqa;
            str = this.eqa.eot;
            pbActivity3.eot = str.trim();
            Activity pageActivity3 = this.eqa.getPageContext().getPageActivity();
            str2 = this.eqa.eot;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
