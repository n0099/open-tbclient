package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.core.dialog.l {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.bzj = pbActivity;
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
            TiebaStatic.eventStat(this.bzj.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.bzj;
            str6 = this.bzj.mPhoneNumber;
            pbActivity.mPhoneNumber = str6.trim();
            Activity pageActivity = this.bzj.getPageContext().getPageActivity();
            str7 = this.bzj.mPhoneNumber;
            UtilHelper.callPhone(pageActivity, str7);
            bqVar2 = this.bzj.byJ;
            String Xf = bqVar2.Xf();
            str8 = this.bzj.mPhoneNumber;
            new a(Xf, str8, "1").start();
            iVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.bzj.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.bzj;
            str3 = this.bzj.mPhoneNumber;
            pbActivity2.mPhoneNumber = str3.trim();
            Activity pageActivity2 = this.bzj.getPageContext().getPageActivity();
            str4 = this.bzj.mPhoneNumber;
            UtilHelper.smsPhone(pageActivity2, str4);
            bqVar = this.bzj.byJ;
            String Xf2 = bqVar.Xf();
            str5 = this.bzj.mPhoneNumber;
            new a(Xf2, str5, "2").start();
            iVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.bzj;
            str = this.bzj.mPhoneNumber;
            pbActivity3.mPhoneNumber = str.trim();
            Activity pageActivity3 = this.bzj.getPageContext().getPageActivity();
            str2 = this.bzj.mPhoneNumber;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            iVar.dismiss();
        }
    }
}
