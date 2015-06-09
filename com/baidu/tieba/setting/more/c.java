package com.baidu.tieba.setting.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BroadcastReceiver {
    final /* synthetic */ AboutActivity this$0;

    private c(AboutActivity aboutActivity) {
        this.this$0 = aboutActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(AboutActivity aboutActivity, c cVar) {
        this(aboutActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        d dVar;
        d dVar2;
        dVar = this.this$0.cev;
        if (dVar != null) {
            dVar2 = this.this$0.cev;
            dVar2.ait();
        }
    }
}
