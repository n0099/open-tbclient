package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements c.b {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity) {
        this.eob = pbActivity;
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
            TiebaStatic.eventStat(this.eob.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.eob;
            str6 = this.eob.emv;
            pbActivity.emv = str6.trim();
            Activity pageActivity = this.eob.getPageContext().getPageActivity();
            str7 = this.eob.emv;
            UtilHelper.callPhone(pageActivity, str7);
            dhVar2 = this.eob.emx;
            String threadID = dhVar2.getThreadID();
            str8 = this.eob.emv;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.eob.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.eob;
            str3 = this.eob.emv;
            pbActivity2.emv = str3.trim();
            Activity pageActivity2 = this.eob.getPageContext().getPageActivity();
            str4 = this.eob.emv;
            UtilHelper.smsPhone(pageActivity2, str4);
            dhVar = this.eob.emx;
            String threadID2 = dhVar.getThreadID();
            str5 = this.eob.emv;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.eob;
            str = this.eob.emv;
            pbActivity3.emv = str.trim();
            Activity pageActivity3 = this.eob.getPageContext().getPageActivity();
            str2 = this.eob.emv;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
