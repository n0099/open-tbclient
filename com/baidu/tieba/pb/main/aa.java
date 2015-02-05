package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.core.dialog.l {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.bAS = pbActivity;
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
            TiebaStatic.eventStat(this.bAS.getPageContext().getPageActivity(), "pb_phone_call", "call");
            PbActivity pbActivity = this.bAS;
            str6 = this.bAS.mPhoneNumber;
            pbActivity.mPhoneNumber = str6.trim();
            Activity pageActivity = this.bAS.getPageContext().getPageActivity();
            str7 = this.bAS.mPhoneNumber;
            UtilHelper.callPhone(pageActivity, str7);
            bqVar2 = this.bAS.bAr;
            String XF = bqVar2.XF();
            str8 = this.bAS.mPhoneNumber;
            new a(XF, str8, "1").start();
            iVar.dismiss();
        } else if (i == 1) {
            TiebaStatic.eventStat(this.bAS.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
            PbActivity pbActivity2 = this.bAS;
            str3 = this.bAS.mPhoneNumber;
            pbActivity2.mPhoneNumber = str3.trim();
            Activity pageActivity2 = this.bAS.getPageContext().getPageActivity();
            str4 = this.bAS.mPhoneNumber;
            UtilHelper.smsPhone(pageActivity2, str4);
            bqVar = this.bAS.bAr;
            String XF2 = bqVar.XF();
            str5 = this.bAS.mPhoneNumber;
            new a(XF2, str5, "2").start();
            iVar.dismiss();
        } else if (i == 2) {
            PbActivity pbActivity3 = this.bAS;
            str = this.bAS.mPhoneNumber;
            pbActivity3.mPhoneNumber = str.trim();
            Activity pageActivity3 = this.bAS.getPageContext().getPageActivity();
            str2 = this.bAS.mPhoneNumber;
            UtilHelper.startBaiDuBar(pageActivity3, str2);
            iVar.dismiss();
        }
    }
}
