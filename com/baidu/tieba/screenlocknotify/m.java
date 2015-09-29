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
            f.aqB().cJT = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            f.aqB().cJT = 1;
            f.aqB().cJS.aqJ();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            f.aqB().cJT = 0;
        }
    }
}
