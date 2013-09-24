package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1549a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NewPbActivity newPbActivity) {
        this.f1549a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        com.baidu.tieba.model.bd bdVar;
        String str3;
        StatService.onEvent(this.f1549a, "pb_phone_sms", "sms");
        NewPbActivity newPbActivity = this.f1549a;
        str = this.f1549a.x;
        newPbActivity.x = str.trim();
        NewPbActivity newPbActivity2 = this.f1549a;
        str2 = this.f1549a.x;
        UtilHelper.h(newPbActivity2, str2);
        bdVar = this.f1549a.n;
        String a2 = bdVar.a();
        str3 = this.f1549a.x;
        new com.baidu.tieba.account.j(a2, str3, "2").start();
        dialogInterface.cancel();
    }
}
