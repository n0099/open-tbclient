package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SignAlertReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.baidu.tieba.broadcast.signalert")) {
            try {
                Intent intent2 = new Intent(context, DealIntentService.class);
                intent2.putExtra("class", 9);
                intent2.putExtra("is_message_pv", true);
                intent2.putExtra("is_notify", true);
                intent2.putExtra("refresh_all", true);
                intent2.putExtra("close_dialog", true);
                intent2.putExtra("goto_type", "goto_home");
                intent2.setFlags(603979776);
                PendingIntent service = PendingIntent.getService(context, 0, intent2, 134217728);
                String string = context.getString(R.string.sign_notification_content);
                Notification notification = new Notification(R.drawable.icon, string, System.currentTimeMillis());
                String string2 = context.getString(R.string.app_name);
                notification.icon = R.drawable.icon;
                notification.setLatestEventInfo(context, string2, string, service);
                notification.defaults = -1;
                notification.defaults &= -3;
                notification.flags |= 16;
                notification.audioStreamType = 5;
                ((NotificationManager) context.getSystemService("notification")).notify(12, notification);
            } catch (Throwable th) {
                try {
                    if (com.baidu.adp.lib.e.d.a()) {
                        com.baidu.adp.lib.e.d.a(th.getMessage());
                    }
                } finally {
                    TiebaApplication.f().am();
                }
            }
        }
    }
}
