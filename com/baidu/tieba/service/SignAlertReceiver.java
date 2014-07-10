package com.baidu.tieba.service;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.ai;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class SignAlertReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(com.baidu.tieba.data.e.e())) {
            try {
                Intent intent2 = new Intent(context, DealIntentService.class);
                intent2.putExtra("class", 9);
                intent2.putExtra("is_message_pv", true);
                intent2.putExtra("is_notify", true);
                intent2.putExtra("refresh_all", true);
                intent2.putExtra("close_dialog", true);
                intent2.putExtra("locate_type", 1);
                intent2.setFlags(603979776);
                PendingIntent service = PendingIntent.getService(context, 0, intent2, 134217728);
                String string = context.getString(y.sign_notification_content);
                bb.a(context, 12, context.getString(y.app_name), string, string, service, false);
            } catch (Throwable th) {
                try {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(th.getMessage());
                    }
                } finally {
                    ai.c().v();
                }
            }
        }
    }
}
