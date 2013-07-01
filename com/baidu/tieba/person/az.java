package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f1333a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonInfoActivity personInfoActivity) {
        this.f1333a = personInfoActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.model.bi biVar;
        com.baidu.tieba.model.bi biVar2;
        com.baidu.tieba.model.bi biVar3;
        com.baidu.tieba.model.bi biVar4;
        com.baidu.tieba.model.bi biVar5;
        com.baidu.tieba.model.bi biVar6;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        long longExtra4 = intent.getLongExtra("pletter", 0L);
        biVar = this.f1333a.b;
        if (biVar != null) {
            biVar3 = this.f1333a.b;
            biVar3.a(longExtra);
            biVar4 = this.f1333a.b;
            biVar4.d(longExtra2);
            biVar5 = this.f1333a.b;
            biVar5.c(longExtra3);
            biVar6 = this.f1333a.b;
            biVar6.b(longExtra4);
        }
        if (this.f1333a.f1304a != null) {
            bb bbVar = this.f1333a.f1304a;
            biVar2 = this.f1333a.b;
            bbVar.a(biVar2);
        }
    }
}
