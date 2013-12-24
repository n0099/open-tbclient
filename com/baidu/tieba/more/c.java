package com.baidu.tieba.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BroadcastReceiver {
    final /* synthetic */ AboutActivity a;

    private c(AboutActivity aboutActivity) {
        this.a = aboutActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(AboutActivity aboutActivity, a aVar) {
        this(aboutActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        d dVar;
        d dVar2;
        dVar = this.a.a;
        if (dVar != null) {
            dVar2 = this.a.a;
            dVar2.f();
        }
    }
}
