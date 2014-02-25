package com.baidu.tieba.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class bh extends BroadcastReceiver {
    final /* synthetic */ bg a;

    private bh(bg bgVar) {
        this.a = bgVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bh(bg bgVar, bh bhVar) {
        this(bgVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.b();
    }
}
