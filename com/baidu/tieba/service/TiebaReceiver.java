package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.av;
/* loaded from: classes.dex */
public class TiebaReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String C = TiebaApplication.C();
        if (action.equals("com.baidu.tieba.broadcast.service")) {
            long longExtra = intent.getLongExtra("relay", 0L);
            long longExtra2 = intent.getLongExtra("at_me", 0L);
            long longExtra3 = intent.getLongExtra("fans", 0L);
            long longExtra4 = intent.getLongExtra("pletter", 0L);
            long longExtra5 = intent.getLongExtra("new_bookmark", 0L);
            av.a(getClass().getName(), "broadcastNotify ", "receiveData: " + String.format("%d %d %d %d %d", Long.valueOf(longExtra), Long.valueOf(longExtra2), Long.valueOf(longExtra3), Long.valueOf(longExtra4), Long.valueOf(longExtra5)));
            if (C != null && C.length() > 0) {
                com.baidu.tieba.mention.s.a().a(longExtra, longExtra2, longExtra3, longExtra4, longExtra5);
            }
        } else if (action.equals("com.baidu.tieba.broadcast.sync")) {
            av.a(getClass().getName(), "broadcastNewVersion ", "receiveData");
            TiebaApplication.g().u(true);
        }
    }
}
