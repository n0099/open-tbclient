package com.baidu.tieba.screenlocknotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class l extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SCREEN_ON")) {
            f.agc().bYN = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            f.agc().bYN = 1;
            f.agc().bYM.afZ();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            f.agc().bYN = 0;
        }
    }
}
