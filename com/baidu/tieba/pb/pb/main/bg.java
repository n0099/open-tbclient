package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements c.b {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        df dfVar;
        String str5;
        String str6;
        String str7;
        df dfVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.dht.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.dht;
            str6 = this.dht.dfD;
            pbActivity.dfD = str6.trim();
            Activity pageActivity = this.dht.getPageContext().getPageActivity();
            str7 = this.dht.dfD;
            UtilHelper.callPhone(pageActivity, str7);
            dfVar2 = this.dht.dfV;
            String threadID = dfVar2.getThreadID();
            str8 = this.dht.dfD;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.dht.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.dht;
            str3 = this.dht.dfD;
            pbActivity2.dfD = str3.trim();
            Activity pageActivity2 = this.dht.getPageContext().getPageActivity();
            str4 = this.dht.dfD;
            UtilHelper.smsPhone(pageActivity2, str4);
            dfVar = this.dht.dfV;
            String threadID2 = dfVar.getThreadID();
            str5 = this.dht.dfD;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.dht;
            str = this.dht.dfD;
            pbActivity3.dfD = str.trim();
            Activity pageActivity3 = this.dht.getPageContext().getPageActivity();
            str2 = this.dht.dfD;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
