package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
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
            TiebaStatic.eventStat(this.bIv.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.bIv;
            str6 = this.bIv.mPhoneNumber;
            pbActivity.mPhoneNumber = str6.trim();
            Activity pageActivity = this.bIv.getPageContext().getPageActivity();
            str7 = this.bIv.mPhoneNumber;
            UtilHelper.callPhone(pageActivity, str7);
            bqVar2 = this.bIv.bHT;
            String ZN = bqVar2.ZN();
            str8 = this.bIv.mPhoneNumber;
            new a(ZN, str8, "1").start();
            eVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.bIv.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.bIv;
            str3 = this.bIv.mPhoneNumber;
            pbActivity2.mPhoneNumber = str3.trim();
            Activity pageActivity2 = this.bIv.getPageContext().getPageActivity();
            str4 = this.bIv.mPhoneNumber;
            UtilHelper.smsPhone(pageActivity2, str4);
            bqVar = this.bIv.bHT;
            String ZN2 = bqVar.ZN();
            str5 = this.bIv.mPhoneNumber;
            new a(ZN2, str5, "2").start();
            eVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.bIv;
            str = this.bIv.mPhoneNumber;
            pbActivity3.mPhoneNumber = str.trim();
            Activity pageActivity3 = this.bIv.getPageContext().getPageActivity();
            str2 = this.bIv.mPhoneNumber;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            eVar.dismiss();
        }
    }
}
