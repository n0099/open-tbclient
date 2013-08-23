package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1502a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(NewPbActivity newPbActivity) {
        this.f1502a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        com.baidu.tieba.model.bb bbVar;
        String str3;
        StatService.onEvent(this.f1502a, "pb_phone_call", "call");
        NewPbActivity newPbActivity = this.f1502a;
        str = this.f1502a.u;
        newPbActivity.u = str.trim();
        NewPbActivity newPbActivity2 = this.f1502a;
        str2 = this.f1502a.u;
        UtilHelper.g(newPbActivity2, str2);
        bbVar = this.f1502a.k;
        String a2 = bbVar.a();
        str3 = this.f1502a.u;
        new com.baidu.tieba.account.j(a2, str3, "1").start();
        dialogInterface.cancel();
    }
}
