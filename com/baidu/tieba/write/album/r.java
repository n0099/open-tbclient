package com.baidu.tieba.write.album;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BroadcastReceiver {
    final /* synthetic */ p this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.this$0 = pVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.D(intent);
    }
}
