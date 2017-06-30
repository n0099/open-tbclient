package com.baidu.tieba.write.album;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BroadcastReceiver {
    final /* synthetic */ q this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.this$0 = qVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.ab(intent);
    }
}
