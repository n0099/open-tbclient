package com.baidu.tieba.service;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.messageCenter.a;
import com.baidu.tbadk.coreExtra.messageCenter.b;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SignAlertReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(TbConfig.getBroadcastActionSignAlert())) {
            try {
                Intent intent2 = new Intent(context, DealIntentService.class);
                intent2.putExtra("class", 9);
                intent2.putExtra("is_message_pv", true);
                intent2.putExtra("is_notify", true);
                intent2.putExtra(FrsActivityConfig.KEY_REFRESH, true);
                intent2.putExtra("close_dialog", true);
                intent2.putExtra("locate_type", 1);
                intent2.setFlags(603979776);
                PendingIntent service = PendingIntent.getService(context, 0, intent2, 134217728);
                String string = context.getString(d.j.sign_notification_content);
                String string2 = context.getString(d.j.app_name);
                a.yK().G(a.yK().dW(12), 12);
                NotificationHelper.showNotification(context, 12, string2, string, string, service, false);
            } catch (Throwable th) {
                try {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(th.getMessage());
                    }
                } finally {
                    b.zh().updateSignAlarm();
                }
            }
        }
    }
}
