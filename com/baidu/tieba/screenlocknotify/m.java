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
            f.bbM().fcM = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            f.bbM().fcM = 1;
            f.bbM().fcL.bbU();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            f.bbM().fcM = 0;
        }
    }
}
