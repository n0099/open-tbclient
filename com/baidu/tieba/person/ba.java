package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.model.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f2218a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PersonInfoActivity personInfoActivity) {
        this.f2218a = personInfoActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        bx bxVar;
        bx bxVar2;
        bx bxVar3;
        bx bxVar4;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("new_bookmark", 0L);
        bxVar = this.f2218a.e;
        if (bxVar != null) {
            bxVar3 = this.f2218a.e;
            bxVar3.a(longExtra);
            bxVar4 = this.f2218a.e;
            bxVar4.c(longExtra2);
        }
        if (this.f2218a.f2188a != null) {
            bd bdVar = this.f2218a.f2188a;
            bxVar2 = this.f2218a.e;
            bdVar.d(bxVar2);
        }
    }
}
