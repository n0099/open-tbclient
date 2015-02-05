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
            f.acB().bOc = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            f.acB().bOc = 1;
            f.acB().bOb.acH();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            f.acB().bOc = 0;
        }
    }
}
