package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f1670a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PersonInfoActivity personInfoActivity) {
        this.f1670a = personInfoActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.model.bo boVar;
        com.baidu.tieba.model.bo boVar2;
        com.baidu.tieba.model.bo boVar3;
        com.baidu.tieba.model.bo boVar4;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("new_bookmark", 0L);
        boVar = this.f1670a.d;
        if (boVar != null) {
            boVar3 = this.f1670a.d;
            boVar3.a(longExtra);
            boVar4 = this.f1670a.d;
            boVar4.c(longExtra2);
        }
        if (this.f1670a.f1643a != null) {
            bh bhVar = this.f1670a.f1643a;
            boVar2 = this.f1670a.d;
            bhVar.d(boVar2);
        }
    }
}
