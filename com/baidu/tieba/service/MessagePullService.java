package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ao;
import com.baidu.tieba.c.af;
import java.util.Date;
import java.util.Random;
/* loaded from: classes.dex */
public class MessagePullService extends Service {
    private f a = null;
    private ao b = null;
    private Runnable c = new e(this);
    private Handler d;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.b = new ao();
        this.d = new Handler();
        Random random = new Random(System.currentTimeMillis());
        af.a(getClass().getName(), "onCreate", "Create message service");
        if (TiebaApplication.b().M()) {
            this.d.removeCallbacks(this.c);
            this.d.postDelayed(this.c, random.nextLong() % com.baidu.tieba.a.i.a.longValue());
            return;
        }
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.d.removeCallbacks(this.c);
        if (this.a != null) {
            this.a.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a != null) {
            this.a.a();
        }
        this.a = new f(this, null);
        this.a.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, ao aoVar) {
        Intent intent;
        int hours = new Date(System.currentTimeMillis()).getHours();
        if ((hours < 0 || hours > 7) && hours < 23) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String c = aoVar.c();
            String b = aoVar.b();
            if (TiebaApplication.b().M()) {
                Notification notification = new Notification(R.drawable.icon, c, System.currentTimeMillis());
                if (b != null && b.length() > 0) {
                    if (b.startsWith("http:")) {
                        String substring = b.substring(b.lastIndexOf("/") + 1);
                        intent = new Intent(context, DealIntentService.class);
                        intent.putExtra("class", 1);
                        intent.putExtra("id", substring);
                        intent.putExtra("is_message_pv", true);
                        intent.putExtra("message_id", aoVar.a());
                    } else if (b.equals("tab://1")) {
                        intent = new Intent(context, DealIntentService.class);
                        intent.putExtra("class", 3);
                        intent.putExtra("is_message_pv", true);
                        intent.putExtra("refresh_all", true);
                        intent.putExtra("close_dialog", true);
                        intent.putExtra("goto_type", "goto_recommend");
                        intent.setFlags(603979776);
                        intent.putExtra("message_id", aoVar.a());
                        TiebaApplication.b().j(0);
                        TiebaApplication.b().a(0L);
                    } else if (b.startsWith("opfeature:")) {
                        try {
                            intent = new Intent(context, DealIntentService.class);
                            intent.putExtra("class", 0);
                            intent.putExtra("url", b.replaceFirst("opfeature:", com.baidu.loginshare.e.f));
                            intent.putExtra("message_id", aoVar.a());
                            intent.putExtra("is_message_pv", true);
                        } catch (Exception e) {
                            af.a("MessagePullService", "showNotification", e.toString());
                            return;
                        }
                    } else {
                        return;
                    }
                    PendingIntent service = PendingIntent.getService(context, 0, intent, 134217728);
                    String string = context.getString(R.string.app_name);
                    notification.icon = R.drawable.icon;
                    notification.setLatestEventInfo(context, string, c, service);
                    notification.defaults = -1;
                    notification.defaults &= -3;
                    notification.flags |= 16;
                    notification.audioStreamType = 5;
                    notificationManager.notify(11, notification);
                }
            }
        }
    }
}
