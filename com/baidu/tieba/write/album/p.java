package com.baidu.tieba.write.album;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BroadcastReceiver {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.this$0 = nVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.X(intent);
    }
}
