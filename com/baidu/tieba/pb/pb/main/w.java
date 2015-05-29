package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        bo boVar;
        String str5;
        String str6;
        String str7;
        bo boVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.bKT.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.bKT;
            str6 = this.bKT.mPhoneNumber;
            pbActivity.mPhoneNumber = str6.trim();
            Activity pageActivity = this.bKT.getPageContext().getPageActivity();
            str7 = this.bKT.mPhoneNumber;
            UtilHelper.callPhone(pageActivity, str7);
            boVar2 = this.bKT.bKv;
            String abo = boVar2.abo();
            str8 = this.bKT.mPhoneNumber;
            new a(abo, str8, "1").start();
            eVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.bKT.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.bKT;
            str3 = this.bKT.mPhoneNumber;
            pbActivity2.mPhoneNumber = str3.trim();
            Activity pageActivity2 = this.bKT.getPageContext().getPageActivity();
            str4 = this.bKT.mPhoneNumber;
            UtilHelper.smsPhone(pageActivity2, str4);
            boVar = this.bKT.bKv;
            String abo2 = boVar.abo();
            str5 = this.bKT.mPhoneNumber;
            new a(abo2, str5, "2").start();
            eVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.bKT;
            str = this.bKT.mPhoneNumber;
            pbActivity3.mPhoneNumber = str.trim();
            Activity pageActivity3 = this.bKT.getPageContext().getPageActivity();
            str2 = this.bKT.mPhoneNumber;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            eVar.dismiss();
        }
    }
}
