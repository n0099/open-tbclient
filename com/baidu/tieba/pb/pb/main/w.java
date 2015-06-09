package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.bKU = pbActivity;
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
            TiebaStatic.eventStat(this.bKU.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.bKU;
            str6 = this.bKU.mPhoneNumber;
            pbActivity.mPhoneNumber = str6.trim();
            Activity pageActivity = this.bKU.getPageContext().getPageActivity();
            str7 = this.bKU.mPhoneNumber;
            UtilHelper.callPhone(pageActivity, str7);
            boVar2 = this.bKU.bKw;
            String abp = boVar2.abp();
            str8 = this.bKU.mPhoneNumber;
            new a(abp, str8, "1").start();
            eVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.bKU.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.bKU;
            str3 = this.bKU.mPhoneNumber;
            pbActivity2.mPhoneNumber = str3.trim();
            Activity pageActivity2 = this.bKU.getPageContext().getPageActivity();
            str4 = this.bKU.mPhoneNumber;
            UtilHelper.smsPhone(pageActivity2, str4);
            boVar = this.bKU.bKw;
            String abp2 = boVar.abp();
            str5 = this.bKU.mPhoneNumber;
            new a(abp2, str5, "2").start();
            eVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.bKU;
            str = this.bKU.mPhoneNumber;
            pbActivity3.mPhoneNumber = str.trim();
            Activity pageActivity3 = this.bKU.getPageContext().getPageActivity();
            str2 = this.bKU.mPhoneNumber;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            eVar.dismiss();
        }
    }
}
