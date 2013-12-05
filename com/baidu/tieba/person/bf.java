package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f2331a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PersonInfoActivity personInfoActivity) {
        this.f2331a = personInfoActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.model.bx bxVar;
        com.baidu.tieba.model.bx bxVar2;
        com.baidu.tieba.model.bx bxVar3;
        com.baidu.tieba.model.bx bxVar4;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("new_bookmark", 0L);
        bxVar = this.f2331a.e;
        if (bxVar != null) {
            bxVar3 = this.f2331a.e;
            bxVar3.a(longExtra);
            bxVar4 = this.f2331a.e;
            bxVar4.c(longExtra2);
        }
        if (this.f2331a.f2296a != null) {
            bj bjVar = this.f2331a.f2296a;
            bxVar2 = this.f2331a.e;
            bjVar.d(bxVar2);
        }
    }
}
