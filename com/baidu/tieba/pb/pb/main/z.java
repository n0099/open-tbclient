package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        br brVar;
        String str5;
        String str6;
        String str7;
        br brVar2;
        String str8;
        if (i == 0) {
            TiebaStatic.eventStat(this.bIJ.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.bIJ;
            str6 = this.bIJ.mPhoneNumber;
            pbActivity.mPhoneNumber = str6.trim();
            Activity pageActivity = this.bIJ.getPageContext().getPageActivity();
            str7 = this.bIJ.mPhoneNumber;
            UtilHelper.callPhone(pageActivity, str7);
            brVar2 = this.bIJ.bIg;
            String aaa = brVar2.aaa();
            str8 = this.bIJ.mPhoneNumber;
            new a(aaa, str8, "1").start();
            eVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.bIJ.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.bIJ;
            str3 = this.bIJ.mPhoneNumber;
            pbActivity2.mPhoneNumber = str3.trim();
            Activity pageActivity2 = this.bIJ.getPageContext().getPageActivity();
            str4 = this.bIJ.mPhoneNumber;
            UtilHelper.smsPhone(pageActivity2, str4);
            brVar = this.bIJ.bIg;
            String aaa2 = brVar.aaa();
            str5 = this.bIJ.mPhoneNumber;
            new a(aaa2, str5, "2").start();
            eVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.bIJ;
            str = this.bIJ.mPhoneNumber;
            pbActivity3.mPhoneNumber = str.trim();
            Activity pageActivity3 = this.bIJ.getPageContext().getPageActivity();
            str2 = this.bIJ.mPhoneNumber;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            eVar.dismiss();
        }
    }
}
