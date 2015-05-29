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
            f.ahP().ccY = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            f.ahP().ccY = 1;
            f.ahP().ccX.ahV();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            f.ahP().ccY = 0;
        }
    }
}
