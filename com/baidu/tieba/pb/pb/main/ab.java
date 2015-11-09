package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements c.b {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        ca caVar;
        String str5;
        String str6;
        String str7;
        ca caVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.cjN.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.cjN;
            str6 = this.cjN.ciN;
            pbActivity.ciN = str6.trim();
            Activity pageActivity = this.cjN.getPageContext().getPageActivity();
            str7 = this.cjN.ciN;
            UtilHelper.callPhone(pageActivity, str7);
            caVar2 = this.cjN.cjj;
            String threadID = caVar2.getThreadID();
            str8 = this.cjN.ciN;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.cjN.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.cjN;
            str3 = this.cjN.ciN;
            pbActivity2.ciN = str3.trim();
            Activity pageActivity2 = this.cjN.getPageContext().getPageActivity();
            str4 = this.cjN.ciN;
            UtilHelper.smsPhone(pageActivity2, str4);
            caVar = this.cjN.cjj;
            String threadID2 = caVar.getThreadID();
            str5 = this.cjN.ciN;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.cjN;
            str = this.cjN.ciN;
            pbActivity3.ciN = str.trim();
            Activity pageActivity3 = this.cjN.getPageContext().getPageActivity();
            str2 = this.cjN.ciN;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
