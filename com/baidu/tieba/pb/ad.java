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
        if (intExtra >= 0) {
            this.a.K = intExtra;
            if (this.a.H != null && intExtra + 5 >= this.a.H.h().size() && this.a.H.h().size() != this.a.H.k()) {
                abVar = this.a.c;
                if (abVar == null) {
                    this.a.a(this.a.H.l(), 0, 10, false);
                }
            }
        } else if (this.a.K == 0 || (this.a.K >= this.a.H.k() - 1 && this.a.H.h().size() == this.a.H.k())) {
            int intExtra2 = intent.getIntExtra("state", -1);
            this.a.a(intExtra2);
            com.baidu.tieba.c.af.a(getClass().getName(), "find_bug_onReceive", "state=" + String.valueOf(intExtra2));
        }
    }
}
