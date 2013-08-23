package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.aq;
/* loaded from: classes.dex */
public class StartMessageReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        aq.a(getClass().getName(), "onReceive", intent.getAction());
        if (TiebaApplication.g().U()) {
            context.startService(new Intent(context, MessagePullService.class));
        }
    }
}
