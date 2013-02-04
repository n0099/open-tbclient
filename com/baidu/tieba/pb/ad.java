package com.baidu.tieba.pb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BroadcastReceiver {
    final /* synthetic */ ImagePbActivity a;

    private ad(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(ImagePbActivity imagePbActivity, ad adVar) {
        this(imagePbActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ab abVar;
        int intExtra = intent.getIntExtra("index", -1);
        if (intExtra < 0) {
            if (this.a.I == 0 || (this.a.I >= this.a.F.k() - 1 && this.a.F.h().size() == this.a.F.k())) {
                int intExtra2 = intent.getIntExtra("state", -1);
                this.a.a(intExtra2);
                com.baidu.tieba.c.ae.a(getClass().getName(), "find_bug_onReceive", "state=" + String.valueOf(intExtra2));
                return;
            }
            return;
        }
        this.a.I = intExtra;
        if (this.a.F == null || intExtra + 5 < this.a.F.h().size() || this.a.F.h().size() == this.a.F.k()) {
            return;
        }
        abVar = this.a.b;
        if (abVar == null) {
            this.a.a(this.a.F.l(), 0, 10, false);
        }
    }
}
