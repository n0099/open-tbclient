package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class SignAlertReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(com.baidu.tieba.data.d.e())) {
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
                String string = context.getString(com.baidu.tieba.a.k.sign_notification_content);
                Notification notification = new Notification(com.baidu.tieba.a.g.icon, string, System.currentTimeMillis());
                String string2 = context.getString(com.baidu.tieba.a.k.app_name);
                notification.icon = com.baidu.tieba.a.g.icon;
                notification.setLatestEventInfo(context, string2, string, service);
                notification.defaults = -1;
                if (com.baidu.tbadk.coreExtra.messageCenter.a.c()) {
                    notification.defaults &= -2;
                    notification.defaults &= -3;
                } else {
                    if (!TbadkApplication.j().aq()) {
                        notification.defaults &= -3;
                    }
                    if (!TbadkApplication.j().ar()) {
                        notification.defaults &= -2;
                    } else {
                        notification.audioStreamType = 5;
                    }
                }
                notification.flags |= 16;
                ((NotificationManager) context.getSystemService("notification")).notify(12, notification);
            } catch (Throwable th) {
                try {
                    if (com.baidu.adp.lib.util.f.a()) {
                        com.baidu.adp.lib.util.f.b(th.getMessage());
                    }
                } finally {
                    com.baidu.tieba.p.c().r();
                }
            }
        }
    }
}
