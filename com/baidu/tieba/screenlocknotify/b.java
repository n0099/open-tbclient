package com.baidu.tieba.screenlocknotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes3.dex */
class b extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SCREEN_ON")) {
            a.cjd().iOA = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            a.cjd().iOA = 1;
            a.cjd().iOz.ctu();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            a.cjd().iOA = 0;
        }
    }
}
