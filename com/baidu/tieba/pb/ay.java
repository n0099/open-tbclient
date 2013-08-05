package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1466a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewPbActivity newPbActivity) {
        this.f1466a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        com.baidu.tieba.model.bc bcVar;
        String str3;
        StatService.onEvent(this.f1466a, "pb_phone_call", "call");
        NewPbActivity newPbActivity = this.f1466a;
        str = this.f1466a.t;
        newPbActivity.t = str.trim();
        NewPbActivity newPbActivity2 = this.f1466a;
        str2 = this.f1466a.t;
        com.baidu.tieba.util.am.g(newPbActivity2, str2);
        bcVar = this.f1466a.j;
        String a2 = bcVar.a();
        str3 = this.f1466a.t;
        new com.baidu.tieba.account.j(a2, str3, "1").start();
        dialogInterface.cancel();
    }
}
