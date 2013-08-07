package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(NewPbActivity newPbActivity) {
        this.f1465a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        com.baidu.tieba.model.bc bcVar;
        String str3;
        StatService.onEvent(this.f1465a, "pb_phone_sms", "sms");
        NewPbActivity newPbActivity = this.f1465a;
        str = this.f1465a.t;
        newPbActivity.t = str.trim();
        NewPbActivity newPbActivity2 = this.f1465a;
        str2 = this.f1465a.t;
        com.baidu.tieba.util.am.h(newPbActivity2, str2);
        bcVar = this.f1465a.j;
        String a2 = bcVar.a();
        str3 = this.f1465a.t;
        new com.baidu.tieba.account.j(a2, str3, "2").start();
        dialogInterface.cancel();
    }
}
