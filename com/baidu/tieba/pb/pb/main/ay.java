package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements c.b {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity) {
        this.elO = pbActivity;
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
            TiebaStatic.eventStat(this.elO.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.elO;
            str6 = this.elO.ejX;
            pbActivity.ejX = str6.trim();
            Activity pageActivity = this.elO.getPageContext().getPageActivity();
            str7 = this.elO.ejX;
            UtilHelper.callPhone(pageActivity, str7);
            pbModel2 = this.elO.ejZ;
            String threadID = pbModel2.getThreadID();
            str8 = this.elO.ejX;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.elO.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.elO;
            str3 = this.elO.ejX;
            pbActivity2.ejX = str3.trim();
            Activity pageActivity2 = this.elO.getPageContext().getPageActivity();
            str4 = this.elO.ejX;
            UtilHelper.smsPhone(pageActivity2, str4);
            pbModel = this.elO.ejZ;
            String threadID2 = pbModel.getThreadID();
            str5 = this.elO.ejX;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.elO;
            str = this.elO.ejX;
            pbActivity3.ejX = str.trim();
            Activity pageActivity3 = this.elO.getPageContext().getPageActivity();
            str2 = this.elO.ejX;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
