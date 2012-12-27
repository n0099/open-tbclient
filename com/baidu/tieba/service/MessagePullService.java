package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.an;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.pb.PbActivity;
import java.util.Date;
import java.util.Random;
/* loaded from: classes.dex */
public class MessagePullService extends Service {
    private e a = null;
    private an b = null;
    private Runnable c = new d(this);
    private Handler d;

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a != null) {
            this.a.a();
        }
        this.a = new e(this, null);
        this.a.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, an anVar) {
        Intent intent;
        int hours = new Date(System.currentTimeMillis()).getHours();
        if ((hours < 0 || hours > 7) && hours < 23) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String c = anVar.c();
            String b = anVar.b();
            if (TiebaApplication.a().I()) {
                Notification notification = new Notification(R.drawable.icon, c, System.currentTimeMillis());
                if (b == null || b.length() <= 0) {
                    return;
                }
                if (b.startsWith("http:")) {
                    String substring = b.substring(b.lastIndexOf("/") + 1);
                    intent = new Intent(context, PbActivity.class);
                    intent.putExtra("id", substring);
                    intent.putExtra("sequence", true);
                    intent.putExtra("is_message_pv", true);
                    intent.putExtra("hostMode", false);
                    intent.putExtra("message_push_entry", true);
                    intent.setFlags(268435456);
                    intent.putExtra("message_id", anVar.a());
                } else if (!b.equals("tab://1")) {
                    return;
                } else {
                    intent = new Intent(context, MainTabActivity.class);
                    intent.putExtra("is_message_pv", true);
                    intent.putExtra("refresh_all", true);
                    intent.putExtra("close_dialog", true);
                    intent.putExtra("goto_type", "goto_recommend");
                    intent.setFlags(603979776);
                    intent.putExtra("message_id", anVar.a());
                    TiebaApplication.a().h(0);
                }
                PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
                String string = context.getString(R.string.app_name);
                notification.icon = R.drawable.icon;
                notification.setLatestEventInfo(context, string, c, activity);
                notification.defaults = -1;
                notification.defaults &= -3;
                notification.flags |= 16;
                notification.audioStreamType = 5;
                notificationManager.notify(11, notification);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.b = new an();
        this.d = new Handler();
        Random random = new Random(System.currentTimeMillis());
        ae.a(getClass().getName(), "onCreate", "Create message service");
        if (!TiebaApplication.a().I()) {
            stopSelf();
            return;
        }
        this.d.removeCallbacks(this.c);
        this.d.postDelayed(this.c, random.nextLong() % com.baidu.tieba.a.h.a.longValue());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.d.removeCallbacks(this.c);
        if (this.a != null) {
            this.a.cancel(true);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }
}
