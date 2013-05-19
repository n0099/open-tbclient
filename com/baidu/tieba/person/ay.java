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
        com.baidu.tieba.c.bf bfVar;
        com.baidu.tieba.c.bf bfVar2;
        com.baidu.tieba.c.bf bfVar3;
        com.baidu.tieba.c.bf bfVar4;
        com.baidu.tieba.c.bf bfVar5;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        bfVar = this.a.d;
        if (bfVar != null) {
            bfVar3 = this.a.d;
            bfVar3.a(longExtra);
            bfVar4 = this.a.d;
            bfVar4.c(longExtra2);
            bfVar5 = this.a.d;
            bfVar5.b(longExtra3);
        }
        if (this.a.c != null) {
            ba baVar = this.a.c;
            bfVar2 = this.a.d;
            baVar.a(bfVar2);
        }
    }
}
