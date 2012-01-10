package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
/* loaded from: classes.dex */
public class TiebaReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long r = intent.getLongExtra(Config.BROADCAST_RELAY_ME_NUM, 0L);
        long a = intent.getLongExtra(Config.BROADCAST_AT_ME_NUM, 0L);
        long f = intent.getLongExtra(Config.BROADCAST_FANS_NUM, 0L);
        TiebaApplication.app.refreshMsg(r, a, f);
    }
}
