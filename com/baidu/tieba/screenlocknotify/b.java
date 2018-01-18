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
            a.bob().gHk = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            a.bob().gHk = 1;
            a.bob().gHj.bog();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            a.bob().gHk = 0;
        }
    }
}
