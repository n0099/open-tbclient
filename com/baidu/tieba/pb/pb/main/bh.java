package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements c.b {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        PbModel pbModel;
        String str5;
        String str6;
        String str7;
        PbModel pbModel2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.ewh.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.ewh;
            str6 = this.ewh.euc;
            pbActivity.euc = str6.trim();
            Activity pageActivity = this.ewh.getPageContext().getPageActivity();
            str7 = this.ewh.euc;
            UtilHelper.callPhone(pageActivity, str7);
            pbModel2 = this.ewh.eue;
            String threadID = pbModel2.getThreadID();
            str8 = this.ewh.euc;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.ewh.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.ewh;
            str3 = this.ewh.euc;
            pbActivity2.euc = str3.trim();
            Activity pageActivity2 = this.ewh.getPageContext().getPageActivity();
            str4 = this.ewh.euc;
            UtilHelper.smsPhone(pageActivity2, str4);
            pbModel = this.ewh.eue;
            String threadID2 = pbModel.getThreadID();
            str5 = this.ewh.euc;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.ewh;
            str = this.ewh.euc;
            pbActivity3.euc = str.trim();
            Activity pageActivity3 = this.ewh.getPageContext().getPageActivity();
            str2 = this.ewh.euc;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
