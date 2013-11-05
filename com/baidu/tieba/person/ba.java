package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.model.bw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f2191a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PersonInfoActivity personInfoActivity) {
        this.f2191a = personInfoActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        bw bwVar;
        bw bwVar2;
        bw bwVar3;
        bw bwVar4;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("new_bookmark", 0L);
        bwVar = this.f2191a.d;
        if (bwVar != null) {
            bwVar3 = this.f2191a.d;
            bwVar3.a(longExtra);
            bwVar4 = this.f2191a.d;
            bwVar4.c(longExtra2);
        }
        if (this.f2191a.f2161a != null) {
            bj bjVar = this.f2191a.f2161a;
            bwVar2 = this.f2191a.d;
            bjVar.d(bwVar2);
        }
    }
}
