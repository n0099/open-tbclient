package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f1621a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonInfoActivity personInfoActivity) {
        this.f1621a = personInfoActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.bm bmVar4;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("new_bookmark", 0L);
        bmVar = this.f1621a.d;
        if (bmVar != null) {
            bmVar3 = this.f1621a.d;
            bmVar3.a(longExtra);
            bmVar4 = this.f1621a.d;
            bmVar4.c(longExtra2);
        }
        if (this.f1621a.f1593a != null) {
            bi biVar = this.f1621a.f1593a;
            bmVar2 = this.f1621a.d;
            biVar.d(bmVar2);
        }
    }
}
