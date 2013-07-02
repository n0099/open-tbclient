package com.baidu.tieba.pb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BroadcastReceiver {
    final /* synthetic */ ImagePbActivity a;

    private ae(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ae(ImagePbActivity imagePbActivity, ae aeVar) {
        this(imagePbActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ac acVar;
        int intExtra = intent.getIntExtra("index", -1);
        if (intExtra >= 0) {
            this.a.K = intExtra;
            if (this.a.H != null && intExtra + 5 >= this.a.H.h().size() && this.a.H.h().size() != this.a.H.k()) {
                acVar = this.a.a;
                if (acVar == null) {
                    this.a.a(this.a.H.l(), 0, 10, false);
                }
            }
        } else if (this.a.K == 0 || (this.a.K >= this.a.H.k() - 1 && this.a.H.h().size() == this.a.H.k())) {
            int intExtra2 = intent.getIntExtra("state", -1);
            this.a.b_(intExtra2);
            com.baidu.tieba.util.z.a(getClass().getName(), "find_bug_onReceive", "state=" + String.valueOf(intExtra2));
        }
    }
}
