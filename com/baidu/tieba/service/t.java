package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public final class t extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent(context, DealIntentService.class);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("type");
            String stringExtra2 = intent.getStringExtra("from");
            if (stringExtra2 == null) {
                stringExtra2 = "aladdin_wake";
            }
            if (stringExtra != null) {
                if (stringExtra.equals("web")) {
                    intent2.putExtra("class", 0);
                    intent2.putExtra("url", intent.getStringExtra("url"));
                    intent2.putExtra("from", stringExtra2);
                    new ax(stringExtra2, "url").start();
                } else if (stringExtra.equals("pb")) {
                    intent2.putExtra("class", 1);
                    intent2.putExtra("id", intent.getStringExtra("id"));
                    intent2.putExtra("from", stringExtra2);
                } else if (stringExtra.equals("frs")) {
                    intent2.putExtra("class", 2);
                    intent2.putExtra("fname", intent.getStringExtra("fname"));
                    intent2.putExtra("from", stringExtra2);
                } else if (stringExtra.equals("groupinfo")) {
                    intent2.putExtra("class", 13);
                    intent2.putExtra("groupid", intent.getStringExtra("groupid"));
                } else {
                    return;
                }
                context.startService(intent2);
            }
        }
    }
}
