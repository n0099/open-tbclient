package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        bl blVar;
        String str5;
        String str6;
        String str7;
        bl blVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.ciK.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.ciK;
            str6 = this.ciK.chT;
            pbActivity.chT = str6.trim();
            Activity pageActivity = this.ciK.getPageContext().getPageActivity();
            str7 = this.ciK.chT;
            UtilHelper.callPhone(pageActivity, str7);
            blVar2 = this.ciK.cih;
            String threadID = blVar2.getThreadID();
            str8 = this.ciK.chT;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.ciK.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.ciK;
            str3 = this.ciK.chT;
            pbActivity2.chT = str3.trim();
            Activity pageActivity2 = this.ciK.getPageContext().getPageActivity();
            str4 = this.ciK.chT;
            UtilHelper.smsPhone(pageActivity2, str4);
            blVar = this.ciK.cih;
            String threadID2 = blVar.getThreadID();
            str5 = this.ciK.chT;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.ciK;
            str = this.ciK.chT;
            pbActivity3.chT = str.trim();
            Activity pageActivity3 = this.ciK.getPageContext().getPageActivity();
            str2 = this.ciK.chT;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
