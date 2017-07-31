package com.baidu.tieba.screenlocknotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
class b extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SCREEN_ON")) {
            a.biP().fKL = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            a.biP().fKL = 1;
            a.biP().fKK.biU();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            a.biP().fKL = 0;
        }
    }
}
