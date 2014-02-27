package com.baidu.tieba.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class bh extends BroadcastReceiver {
    final /* synthetic */ bg a;

    private bh(bg bgVar) {
        this.a = bgVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bh(bg bgVar, byte b) {
        this(bgVar);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.b();
    }
}
