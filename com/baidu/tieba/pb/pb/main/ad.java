package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements c.b {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        cc ccVar;
        String str5;
        String str6;
        String str7;
        cc ccVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.cCm.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.cCm;
            str6 = this.cCm.cBj;
            pbActivity.cBj = str6.trim();
            Activity pageActivity = this.cCm.getPageContext().getPageActivity();
            str7 = this.cCm.cBj;
            UtilHelper.callPhone(pageActivity, str7);
            ccVar2 = this.cCm.cBG;
            String threadID = ccVar2.getThreadID();
            str8 = this.cCm.cBj;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.cCm.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.cCm;
            str3 = this.cCm.cBj;
            pbActivity2.cBj = str3.trim();
            Activity pageActivity2 = this.cCm.getPageContext().getPageActivity();
            str4 = this.cCm.cBj;
            UtilHelper.smsPhone(pageActivity2, str4);
            ccVar = this.cCm.cBG;
            String threadID2 = ccVar.getThreadID();
            str5 = this.cCm.cBj;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.cCm;
            str = this.cCm.cBj;
            pbActivity3.cBj = str.trim();
            Activity pageActivity3 = this.cCm.getPageContext().getPageActivity();
            str2 = this.cCm.cBj;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
