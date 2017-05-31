package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements c.b {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity) {
        this.enc = pbActivity;
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
            TiebaStatic.eventStat(this.enc.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.enc;
            str6 = this.enc.elc;
            pbActivity.elc = str6.trim();
            Activity pageActivity = this.enc.getPageContext().getPageActivity();
            str7 = this.enc.elc;
            UtilHelper.callPhone(pageActivity, str7);
            pbModel2 = this.enc.ele;
            String threadID = pbModel2.getThreadID();
            str8 = this.enc.elc;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.enc.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.enc;
            str3 = this.enc.elc;
            pbActivity2.elc = str3.trim();
            Activity pageActivity2 = this.enc.getPageContext().getPageActivity();
            str4 = this.enc.elc;
            UtilHelper.smsPhone(pageActivity2, str4);
            pbModel = this.enc.ele;
            String threadID2 = pbModel.getThreadID();
            str5 = this.enc.elc;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.enc;
            str = this.enc.elc;
            pbActivity3.elc = str.trim();
            Activity pageActivity3 = this.enc.getPageContext().getPageActivity();
            str2 = this.enc.elc;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
