package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.v;
/* loaded from: classes.dex */
public class TiebaReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String A = TiebaApplication.A();
        if (action.equals(com.baidu.tieba.data.i.e())) {
            int intExtra = intent.getIntExtra("relay", 0);
            int intExtra2 = intent.getIntExtra("at_me", 0);
            int intExtra3 = intent.getIntExtra("fans", 0);
            int intExtra4 = intent.getIntExtra("pletter", 0);
            int intExtra5 = intent.getIntExtra("new_bookmark", 0);
            com.baidu.adp.lib.util.f.a(getClass().getName(), "broadcastNotify ", "receiveData: " + String.format("%d %d %d %d %d", Integer.valueOf(intExtra), Integer.valueOf(intExtra2), Integer.valueOf(intExtra3), Integer.valueOf(intExtra4), Integer.valueOf(intExtra5)));
            if (A != null && A.length() > 0) {
                v.a().a(intExtra, intExtra2, intExtra3, intExtra4, intExtra5);
            }
        } else if (action.equals(com.baidu.tieba.data.i.g())) {
            com.baidu.adp.lib.util.f.a(getClass().getName(), "broadcastNewVersion ", "receiveData");
            TiebaApplication.g().x(true);
        }
    }
}
