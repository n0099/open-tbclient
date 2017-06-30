package com.baidu.tieba.screenlocknotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
class p extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SCREEN_ON")) {
            i.bfe().fwp = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            i.bfe().fwp = 1;
            i.bfe().fwo.bfj();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            i.bfe().fwp = 0;
        }
    }
}
