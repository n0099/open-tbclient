package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.aj;
/* loaded from: classes.dex */
public class StartMessageReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        aj.a(getClass().getName(), "onReceive", intent.getAction());
        if (TiebaApplication.f().U()) {
            context.startService(new Intent(context, MessagePullService.class));
        }
    }
}
