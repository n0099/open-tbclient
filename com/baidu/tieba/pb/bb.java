package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1548a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NewPbActivity newPbActivity) {
        this.f1548a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        com.baidu.tieba.model.bd bdVar;
        String str3;
        StatService.onEvent(this.f1548a, "pb_phone_call", "call");
        NewPbActivity newPbActivity = this.f1548a;
        str = this.f1548a.x;
        newPbActivity.x = str.trim();
        NewPbActivity newPbActivity2 = this.f1548a;
        str2 = this.f1548a.x;
        UtilHelper.g(newPbActivity2, str2);
        bdVar = this.f1548a.n;
        String a2 = bdVar.a();
        str3 = this.f1548a.x;
        new com.baidu.tieba.account.j(a2, str3, "1").start();
        dialogInterface.cancel();
    }
}
