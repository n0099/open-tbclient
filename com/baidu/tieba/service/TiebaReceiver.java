package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.d.ae;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TiebaReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.tieba.broadcast.service")) {
            long longExtra = intent.getLongExtra("relay", 0L);
            long longExtra2 = intent.getLongExtra("at_me", 0L);
            long longExtra3 = intent.getLongExtra("fans", 0L);
            ae.a(getClass().getName(), "broadcastNotify ", "receiveData: " + String.format("%d %d %d", Long.valueOf(longExtra), Long.valueOf(longExtra2), Long.valueOf(longExtra3)));
            TiebaApplication.d().a(longExtra, longExtra2, longExtra3);
        } else if (action.equals("com.baidu.tieba.broadcast.sync")) {
            ae.a(getClass().getName(), "broadcastNewVersion ", "receiveData");
            TiebaApplication.d().s(true);
        } else if (action.equals("com.baidu.tieba.broadcast.lottery")) {
            ae.b("lottery");
            Serializable serializableExtra = intent.getSerializableExtra("lottery");
            if (serializableExtra != null && (serializableExtra instanceof com.baidu.tieba.a.c)) {
                TiebaApplication.d().a((com.baidu.tieba.a.c) serializableExtra);
            } else {
                TiebaApplication.d().a((com.baidu.tieba.a.c) null);
            }
        }
    }
}
