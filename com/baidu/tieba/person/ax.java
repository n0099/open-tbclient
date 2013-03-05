package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BroadcastReceiver {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.b.s sVar;
        com.baidu.tieba.b.s sVar2;
        com.baidu.tieba.b.s sVar3;
        com.baidu.tieba.b.s sVar4;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        sVar = this.a.p;
        if (sVar != null) {
            sVar2 = this.a.p;
            sVar2.a(longExtra);
            sVar3 = this.a.p;
            sVar3.c(longExtra2);
            sVar4 = this.a.p;
            sVar4.b(longExtra3);
        }
        this.a.k();
    }
}
