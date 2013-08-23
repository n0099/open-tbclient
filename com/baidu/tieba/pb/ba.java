package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(NewPbActivity newPbActivity) {
        this.f1504a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        com.baidu.tieba.model.bb bbVar;
        String str3;
        StatService.onEvent(this.f1504a, "pb_phone_sms", "sms");
        NewPbActivity newPbActivity = this.f1504a;
        str = this.f1504a.u;
        newPbActivity.u = str.trim();
        NewPbActivity newPbActivity2 = this.f1504a;
        str2 = this.f1504a.u;
        UtilHelper.h(newPbActivity2, str2);
        bbVar = this.f1504a.k;
        String a2 = bbVar.a();
        str3 = this.f1504a.u;
        new com.baidu.tieba.account.j(a2, str3, "2").start();
        dialogInterface.cancel();
    }
}
