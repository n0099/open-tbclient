package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements c.b {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity) {
        this.ehy = pbActivity;
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
            TiebaStatic.eventStat(this.ehy.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.ehy;
            str6 = this.ehy.efC;
            pbActivity.efC = str6.trim();
            Activity pageActivity = this.ehy.getPageContext().getPageActivity();
            str7 = this.ehy.efC;
            UtilHelper.callPhone(pageActivity, str7);
            pbModel2 = this.ehy.efE;
            String threadID = pbModel2.getThreadID();
            str8 = this.ehy.efC;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.ehy.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.ehy;
            str3 = this.ehy.efC;
            pbActivity2.efC = str3.trim();
            Activity pageActivity2 = this.ehy.getPageContext().getPageActivity();
            str4 = this.ehy.efC;
            UtilHelper.smsPhone(pageActivity2, str4);
            pbModel = this.ehy.efE;
            String threadID2 = pbModel.getThreadID();
            str5 = this.ehy.efC;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.ehy;
            str = this.ehy.efC;
            pbActivity3.efC = str.trim();
            Activity pageActivity3 = this.ehy.getPageContext().getPageActivity();
            str2 = this.ehy.efC;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
