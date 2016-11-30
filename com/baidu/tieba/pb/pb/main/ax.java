package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements c.b {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        dj djVar;
        String str5;
        String str6;
        String str7;
        dj djVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.evL.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.evL;
            str6 = this.evL.eud;
            pbActivity.eud = str6.trim();
            Activity pageActivity = this.evL.getPageContext().getPageActivity();
            str7 = this.evL.eud;
            UtilHelper.callPhone(pageActivity, str7);
            djVar2 = this.evL.euf;
            String threadID = djVar2.getThreadID();
            str8 = this.evL.eud;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.evL.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.evL;
            str3 = this.evL.eud;
            pbActivity2.eud = str3.trim();
            Activity pageActivity2 = this.evL.getPageContext().getPageActivity();
            str4 = this.evL.eud;
            UtilHelper.smsPhone(pageActivity2, str4);
            djVar = this.evL.euf;
            String threadID2 = djVar.getThreadID();
            str5 = this.evL.eud;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.evL;
            str = this.evL.eud;
            pbActivity3.eud = str.trim();
            Activity pageActivity3 = this.evL.getPageContext().getPageActivity();
            str2 = this.evL.eud;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
