package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2087a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(NewPbActivity newPbActivity) {
        this.f2087a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        com.baidu.tieba.model.bm bmVar;
        String str3;
        StatService.onEvent(this.f2087a, "pb_phone_sms", "sms");
        NewPbActivity newPbActivity = this.f2087a;
        str = this.f2087a.C;
        newPbActivity.C = str.trim();
        NewPbActivity newPbActivity2 = this.f2087a;
        str2 = this.f2087a.C;
        UtilHelper.h(newPbActivity2, str2);
        bmVar = this.f2087a.s;
        String b = bmVar.b();
        str3 = this.f2087a.C;
        new com.baidu.tieba.account.k(b, str3, "2").start();
        dialogInterface.cancel();
    }
}
