package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends BroadcastReceiver {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.b.t tVar;
        com.baidu.tieba.b.t tVar2;
        com.baidu.tieba.b.t tVar3;
        com.baidu.tieba.b.t tVar4;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        tVar = this.a.p;
        if (tVar != null) {
            tVar2 = this.a.p;
            tVar2.a(longExtra);
            tVar3 = this.a.p;
            tVar3.c(longExtra2);
            tVar4 = this.a.p;
            tVar4.b(longExtra3);
        }
        this.a.k();
    }
}
