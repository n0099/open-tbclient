package com.baidu.tieba.service;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.af;
import com.baidu.tieba.data.ap;
import com.baidu.tieba.util.z;
import com.slidingmenu.lib.R;
import java.util.Date;
import java.util.Random;
/* loaded from: classes.dex */
public class MessagePullService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private f f1397a = null;
    private ap b = null;
    private Runnable c = new e(this);
    private Handler d;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.b = new ap();
        this.d = new Handler();
        Random random = new Random(System.currentTimeMillis());
        z.a(getClass().getName(), "onCreate", "Create message service");
        if (TiebaApplication.f().T()) {
            this.d.removeCallbacks(this.c);
            this.d.postDelayed(this.c, random.nextLong() % com.baidu.tieba.data.g.b.longValue());
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
        if (this.f1397a != null) {
            this.f1397a.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f1397a != null) {
            this.f1397a.cancel();
        }
        this.f1397a = new f(this, null);
        this.f1397a.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Context context, af afVar) {
        if (TiebaApplication.E() == null || TiebaApplication.H() == null || TiebaApplication.f().R() <= 0) {
            return false;
        }
        int hours = new Date(System.currentTimeMillis()).getHours();
        if ((hours >= 0 && hours <= 7) || hours >= 23) {
            return false;
        }
        long b = afVar.b();
        long c = afVar.c();
        long a2 = afVar.a();
        long d = afVar.d();
        if (b <= TiebaApplication.f().ae() && c <= TiebaApplication.f().af() && a2 <= TiebaApplication.f().ad() && d <= TiebaApplication.f().ag()) {
            return false;
        }
        boolean z = false;
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) TiebaApplication.f().getSystemService("activity")).getRunningTasks(BdWebErrorView.ERROR_CODE_500)) {
            if (runningTaskInfo.baseActivity.getClassName().startsWith(getPackageName())) {
                z = true;
            }
        }
        if (z) {
            return false;
        }
        Notification notification = new Notification(R.drawable.icon, getString(R.string.notify_text), System.currentTimeMillis());
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("reply_me", a2);
        intent.putExtra("at_me", b);
        intent.putExtra("fans", c);
        intent.putExtra("chat", d);
        PendingIntent service = PendingIntent.getService(context, 0, intent, 134217728);
        StringBuffer stringBuffer = new StringBuffer();
        if (a2 > 0 || b > 0) {
            stringBuffer.append(String.valueOf(b + a2));
            stringBuffer.append(getString(R.string.notify_msg));
        }
        if (c > 0) {
            stringBuffer.append(String.valueOf(c));
            stringBuffer.append(getString(R.string.notify_fans));
        }
        if (d > 0) {
            stringBuffer.append(String.valueOf(d));
            stringBuffer.append(getString(R.string.notify_chat));
        }
        stringBuffer.append(getString(R.string.notify_click));
        notification.setLatestEventInfo(context, context.getString(R.string.app_name), stringBuffer, service);
        notification.defaults = -1;
        notification.defaults &= -3;
        notification.flags |= 16;
        notification.audioStreamType = 5;
        ((NotificationManager) context.getSystemService("notification")).notify(11, notification);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, ap apVar) {
        Intent intent;
        int hours = new Date(System.currentTimeMillis()).getHours();
        if ((hours < 0 || hours > 7) && hours < 23) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String c = apVar.c();
            String b = apVar.b();
            if (TiebaApplication.f().T()) {
                Notification notification = new Notification(R.drawable.icon, c, System.currentTimeMillis());
                if (b != null && b.length() > 0) {
                    if (b.startsWith("http:")) {
                        String substring = b.substring(b.lastIndexOf("/") + 1);
                        intent = new Intent(context, DealIntentService.class);
                        intent.putExtra("class", 1);
                        intent.putExtra("id", substring);
                        intent.putExtra("is_message_pv", true);
                        intent.putExtra("message_id", apVar.a());
                    } else if (b.equals("tab://1")) {
                        intent = new Intent(context, DealIntentService.class);
                        intent.putExtra("class", 3);
                        intent.putExtra("is_message_pv", true);
                        intent.putExtra("refresh_all", true);
                        intent.putExtra("close_dialog", true);
                        intent.putExtra("goto_type", "goto_recommend");
                        intent.setFlags(603979776);
                        intent.putExtra("message_id", apVar.a());
                        TiebaApplication.f().l(0);
                        TiebaApplication.f().b(0L);
                    } else if (b.startsWith("opfeature:")) {
                        try {
                            intent = new Intent(context, DealIntentService.class);
                            intent.putExtra("class", 0);
                            intent.putExtra("url", b.replaceFirst("opfeature:", com.baidu.loginshare.e.f));
                            intent.putExtra("message_id", apVar.a());
                            intent.putExtra("is_message_pv", true);
                        } catch (Exception e) {
                            z.a("MessagePullService", "showNotification", e.toString());
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
                    notificationManager.notify(13, notification);
                }
            }
        }
    }
}
