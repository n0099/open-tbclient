package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2074a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(NewPbActivity newPbActivity) {
        this.f2074a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        com.baidu.tieba.model.bl blVar;
        String str3;
        StatService.onEvent(this.f2074a, "pb_phone_call", "call");
        NewPbActivity newPbActivity = this.f2074a;
        str = this.f2074a.y;
        newPbActivity.y = str.trim();
        NewPbActivity newPbActivity2 = this.f2074a;
        str2 = this.f2074a.y;
        UtilHelper.g(newPbActivity2, str2);
        blVar = this.f2074a.o;
        String a2 = blVar.a();
        str3 = this.f2074a.y;
        new com.baidu.tieba.account.k(a2, str3, SocialConstants.TRUE).start();
        dialogInterface.cancel();
    }
}
