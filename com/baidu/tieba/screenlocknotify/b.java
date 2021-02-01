package com.baidu.tieba.screenlocknotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes8.dex */
class b extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SCREEN_ON")) {
            a.dFh().nbX = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            a.dFh().nbX = 1;
            a.dFh().nbW.dRJ();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            a.dFh().nbX = 0;
        }
    }
}
