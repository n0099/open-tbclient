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
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.b.r rVar3;
        com.baidu.tieba.b.r rVar4;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        rVar = this.a.p;
        if (rVar != null) {
            rVar2 = this.a.p;
            rVar2.a(longExtra);
            rVar3 = this.a.p;
            rVar3.c(longExtra2);
            rVar4 = this.a.p;
            rVar4.b(longExtra3);
        }
        this.a.k();
    }
}
