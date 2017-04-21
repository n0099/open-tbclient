package com.baidu.tieba.screenlocknotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class p extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SCREEN_ON")) {
            i.bbW().fio = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            i.bbW().fio = 1;
            i.bbW().fin.bcb();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            i.bbW().fio = 0;
        }
    }
}
