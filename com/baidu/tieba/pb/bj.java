package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2073a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(NewPbActivity newPbActivity) {
        this.f2073a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        com.baidu.tieba.model.bl blVar;
        String str3;
        StatService.onEvent(this.f2073a, "pb_phone_sms", "sms");
        NewPbActivity newPbActivity = this.f2073a;
        str = this.f2073a.y;
        newPbActivity.y = str.trim();
        NewPbActivity newPbActivity2 = this.f2073a;
        str2 = this.f2073a.y;
        UtilHelper.h(newPbActivity2, str2);
        blVar = this.f2073a.o;
        String a2 = blVar.a();
        str3 = this.f2073a.y;
        new com.baidu.tieba.account.k(a2, str3, "2").start();
        dialogInterface.cancel();
    }
}
