package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.model.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f1583a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonInfoActivity personInfoActivity) {
        this.f1583a = personInfoActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bn bnVar4;
        bn bnVar5;
        bn bnVar6;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        long longExtra4 = intent.getLongExtra("pletter", 0L);
        bnVar = this.f1583a.b;
        if (bnVar != null) {
            bnVar3 = this.f1583a.b;
            bnVar3.a(longExtra);
            bnVar4 = this.f1583a.b;
            bnVar4.d(longExtra2);
            bnVar5 = this.f1583a.b;
            bnVar5.c(longExtra3);
            bnVar6 = this.f1583a.b;
            bnVar6.b(longExtra4);
        }
        if (this.f1583a.f1555a != null) {
            bb bbVar = this.f1583a.f1555a;
            bnVar2 = this.f1583a.b;
            bbVar.a(bnVar2);
        }
    }
}
