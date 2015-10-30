package com.baidu.tieba.screenlocknotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class m extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SCREEN_ON")) {
            f.aqD().cKs = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            f.aqD().cKs = 1;
            f.aqD().cKr.aqL();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            f.aqD().cKs = 0;
        }
    }
}
