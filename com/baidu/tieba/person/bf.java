package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends BroadcastReceiver {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.model.bx bxVar;
        com.baidu.tieba.model.bx bxVar2;
        com.baidu.tieba.model.bx bxVar3;
        com.baidu.tieba.model.bx bxVar4;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("new_bookmark", 0L);
        bxVar = this.a.e;
        if (bxVar != null) {
            bxVar3 = this.a.e;
            bxVar3.a(longExtra);
            bxVar4 = this.a.e;
            bxVar4.c(longExtra2);
        }
        if (this.a.a != null) {
            bm bmVar = this.a.a;
            bxVar2 = this.a.e;
            bmVar.e(bxVar2);
        }
    }
}
