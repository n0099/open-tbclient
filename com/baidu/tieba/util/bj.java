package com.baidu.tieba.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class bj extends BroadcastReceiver {
    final /* synthetic */ bh a;

    private bj(bh bhVar) {
        this.a = bhVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.b();
    }
}
