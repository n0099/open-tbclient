package com.baidu.tieba.screenlocknotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class n extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SCREEN_ON")) {
            f.acG().bOd = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            f.acG().bOd = 1;
            f.acG().bOc.acM();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            f.acG().bOd = 0;
        }
    }
}
