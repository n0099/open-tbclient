package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.core.dialog.l {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.l
    public void itemClick(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        bq bqVar;
        String str5;
        String str6;
        String str7;
        bq bqVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.bAT.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.bAT;
            str6 = this.bAT.mPhoneNumber;
            pbActivity.mPhoneNumber = str6.trim();
            Activity pageActivity = this.bAT.getPageContext().getPageActivity();
            str7 = this.bAT.mPhoneNumber;
            UtilHelper.callPhone(pageActivity, str7);
            bqVar2 = this.bAT.bAs;
            String XK = bqVar2.XK();
            str8 = this.bAT.mPhoneNumber;
            new a(XK, str8, "1").start();
            iVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.bAT.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.bAT;
            str3 = this.bAT.mPhoneNumber;
            pbActivity2.mPhoneNumber = str3.trim();
            Activity pageActivity2 = this.bAT.getPageContext().getPageActivity();
            str4 = this.bAT.mPhoneNumber;
            UtilHelper.smsPhone(pageActivity2, str4);
            bqVar = this.bAT.bAs;
            String XK2 = bqVar.XK();
            str5 = this.bAT.mPhoneNumber;
            new a(XK2, str5, "2").start();
            iVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.bAT;
            str = this.bAT.mPhoneNumber;
            pbActivity3.mPhoneNumber = str.trim();
            Activity pageActivity3 = this.bAT.getPageContext().getPageActivity();
            str2 = this.bAT.mPhoneNumber;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            iVar.dismiss();
        }
    }
}
