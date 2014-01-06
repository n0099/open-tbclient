package com.baidu.tieba.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class bf extends BroadcastReceiver {
    final /* synthetic */ bd a;

    private bf(bd bdVar) {
        this.a = bdVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.b();
    }
}
