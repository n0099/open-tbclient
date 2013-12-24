package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements DialogInterface.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        com.baidu.tieba.model.bm bmVar;
        String str3;
        StatService.onEvent(this.a, "pb_phone_sms", "sms");
        NewPbActivity newPbActivity = this.a;
        str = this.a.B;
        newPbActivity.B = str.trim();
        NewPbActivity newPbActivity2 = this.a;
        str2 = this.a.B;
        UtilHelper.g(newPbActivity2, str2);
        bmVar = this.a.r;
        String b = bmVar.b();
        str3 = this.a.B;
        new com.baidu.tieba.account.u(b, str3, "2").start();
        dialogInterface.cancel();
    }
}
