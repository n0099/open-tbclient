package com.baidu.tieba.pb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1481a;

    private ae(ImagePbActivity imagePbActivity) {
        this.f1481a = imagePbActivity;
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
            this.f1481a.K = intExtra;
            if (this.f1481a.H != null && intExtra + 5 >= this.f1481a.H.h().size() && this.f1481a.H.h().size() != this.f1481a.H.k()) {
                acVar = this.f1481a.f1472a;
                if (acVar == null) {
                    this.f1481a.a(this.f1481a.H.l(), 0, 10, false);
                }
            }
        } else if (this.f1481a.K == 0 || (this.f1481a.K >= this.f1481a.H.k() - 1 && this.f1481a.H.h().size() == this.f1481a.H.k())) {
            int intExtra2 = intent.getIntExtra("state", -1);
            this.f1481a.b_(intExtra2);
            com.baidu.tieba.util.aq.a(getClass().getName(), "find_bug_onReceive", "state=" + String.valueOf(intExtra2));
        }
    }
}
