package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.af;
/* loaded from: classes.dex */
public class StartMessageReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        af.a(getClass().getName(), "onReceive", intent.getAction());
        if (TiebaApplication.b().M()) {
            context.startService(new Intent(context, MessagePullService.class));
        }
    }
}
