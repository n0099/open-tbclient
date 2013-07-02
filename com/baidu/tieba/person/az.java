package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BroadcastReceiver {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        long longExtra4 = intent.getLongExtra("pletter", 0L);
        if (this.a.b != null) {
            this.a.b.a(longExtra);
            this.a.b.d(longExtra2);
            this.a.b.c(longExtra3);
            this.a.b.b(longExtra4);
        }
        if (this.a.a != null) {
            this.a.a.a(this.a.b);
        }
    }
}
