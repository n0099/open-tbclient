package com.baidu.tieba.screenlocknotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class a extends BroadcastReceiver {
    final /* synthetic */ ScreenLockActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ScreenLockActivity screenLockActivity) {
        this.this$0 = screenLockActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
            f.arj().cLN.arr();
            this.this$0.finish();
        }
    }
}
