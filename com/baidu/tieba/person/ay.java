package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BroadcastReceiver {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.c.bi biVar;
        com.baidu.tieba.c.bi biVar2;
        com.baidu.tieba.c.bi biVar3;
        com.baidu.tieba.c.bi biVar4;
        com.baidu.tieba.c.bi biVar5;
        com.baidu.tieba.c.bi biVar6;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        long longExtra4 = intent.getLongExtra("pletter", 0L);
        biVar = this.a.d;
        if (biVar != null) {
            biVar3 = this.a.d;
            biVar3.a(longExtra);
            biVar4 = this.a.d;
            biVar4.d(longExtra2);
            biVar5 = this.a.d;
            biVar5.c(longExtra3);
            biVar6 = this.a.d;
            biVar6.b(longExtra4);
        }
        if (this.a.c != null) {
            ba baVar = this.a.c;
            biVar2 = this.a.d;
            baVar.a(biVar2);
        }
    }
}
