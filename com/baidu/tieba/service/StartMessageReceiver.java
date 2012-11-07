package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class StartMessageReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        TiebaLog.i(getClass().getName(), "onReceive", intent.getAction());
        if (TiebaApplication.app.isPromotedMessageOn()) {
            Intent newIntent = new Intent(context, MessagePullService.class);
            context.startService(newIntent);
        }
    }
}
