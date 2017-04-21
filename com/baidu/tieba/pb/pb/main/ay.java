package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements c.b {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity) {
        this.emk = pbActivity;
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
            TiebaStatic.eventStat(this.emk.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.emk;
            str6 = this.emk.ekt;
            pbActivity.ekt = str6.trim();
            Activity pageActivity = this.emk.getPageContext().getPageActivity();
            str7 = this.emk.ekt;
            UtilHelper.callPhone(pageActivity, str7);
            pbModel2 = this.emk.ekv;
            String threadID = pbModel2.getThreadID();
            str8 = this.emk.ekt;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.emk.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.emk;
            str3 = this.emk.ekt;
            pbActivity2.ekt = str3.trim();
            Activity pageActivity2 = this.emk.getPageContext().getPageActivity();
            str4 = this.emk.ekt;
            UtilHelper.smsPhone(pageActivity2, str4);
            pbModel = this.emk.ekv;
            String threadID2 = pbModel.getThreadID();
            str5 = this.emk.ekt;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.emk;
            str = this.emk.ekt;
            pbActivity3.ekt = str.trim();
            Activity pageActivity3 = this.emk.getPageContext().getPageActivity();
            str2 = this.emk.ekt;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
