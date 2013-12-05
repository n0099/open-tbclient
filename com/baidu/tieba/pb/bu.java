package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(NewPbActivity newPbActivity) {
        this.f2195a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        com.baidu.tieba.model.bm bmVar;
        String str3;
        StatService.onEvent(this.f2195a, "pb_phone_call", "call");
        NewPbActivity newPbActivity = this.f2195a;
        str = this.f2195a.C;
        newPbActivity.C = str.trim();
        NewPbActivity newPbActivity2 = this.f2195a;
        str2 = this.f2195a.C;
        UtilHelper.f(newPbActivity2, str2);
        bmVar = this.f2195a.s;
        String b = bmVar.b();
        str3 = this.f2195a.C;
        new com.baidu.tieba.account.k(b, str3, SocialConstants.TRUE).start();
        dialogInterface.cancel();
    }
}
