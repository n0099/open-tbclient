package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements c.b {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        dg dgVar;
        String str5;
        String str6;
        String str7;
        dg dgVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.dPF.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.dPF;
            str6 = this.dPF.dOd;
            pbActivity.dOd = str6.trim();
            Activity pageActivity = this.dPF.getPageContext().getPageActivity();
            str7 = this.dPF.dOd;
            UtilHelper.callPhone(pageActivity, str7);
            dgVar2 = this.dPF.dOf;
            String threadID = dgVar2.getThreadID();
            str8 = this.dPF.dOd;
            new a(threadID, str8, "1").start();
            cVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.dPF.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.dPF;
            str3 = this.dPF.dOd;
            pbActivity2.dOd = str3.trim();
            Activity pageActivity2 = this.dPF.getPageContext().getPageActivity();
            str4 = this.dPF.dOd;
            UtilHelper.smsPhone(pageActivity2, str4);
            dgVar = this.dPF.dOf;
            String threadID2 = dgVar.getThreadID();
            str5 = this.dPF.dOd;
            new a(threadID2, str5, "2").start();
            cVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.dPF;
            str = this.dPF.dOd;
            pbActivity3.dOd = str.trim();
            Activity pageActivity3 = this.dPF.getPageContext().getPageActivity();
            str2 = this.dPF.dOd;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            cVar.dismiss();
        }
    }
}
