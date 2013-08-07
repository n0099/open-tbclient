package com.baidu.tieba.service;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.an;
import com.baidu.tieba.data.ay;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.util.am;
import com.slidingmenu.lib.R;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.u f1698a;
    final /* synthetic */ MessagePullService b;

    private f(MessagePullService messagePullService) {
        this.b = messagePullService;
        this.f1698a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(MessagePullService messagePullService, f fVar) {
        this(messagePullService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        aj.a(getClass().getName(), "doBackGround", "pull message...");
        try {
            this.f1698a = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/m/getmsg");
            this.f1698a.a("message_id", String.valueOf(TiebaApplication.f().aW()));
            this.f1698a.a("pk_before_id", TiebaApplication.f().ay());
            this.f1698a.a("pk_after_id", TiebaApplication.f().az());
            return this.f1698a.k();
        } catch (Exception e) {
            aj.b(getClass().getName(), "doBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.f1686a = null;
        if (this.f1698a != null) {
            this.f1698a.i();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0069, code lost:
        if (r0.a() > com.baidu.tieba.TiebaApplication.f().aW()) goto L11;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        ay ayVar;
        ay ayVar2;
        ay ayVar3;
        ay ayVar4;
        ay ayVar5;
        ay ayVar6;
        if (this.f1698a.e()) {
            aj.a(getClass().getName(), "onPostExecute", "result=" + str);
            if (this.f1698a.d()) {
                an anVar = new an();
                anVar.a(str);
                if (!a(this.b, anVar)) {
                    ayVar = this.b.b;
                    ayVar.a(str);
                    ayVar2 = this.b.b;
                    if (ayVar2.a() != -1) {
                        ayVar6 = this.b.b;
                    }
                    ayVar3 = this.b.b;
                    if (ayVar3.a() != -1) {
                        TiebaApplication f = TiebaApplication.f();
                        ayVar5 = this.b.b;
                        f.f(ayVar5.a());
                    }
                    MessagePullService messagePullService = this.b;
                    ayVar4 = this.b.b;
                    am.a(messagePullService, ayVar4, 13);
                }
            }
        }
        this.b.f1686a = null;
    }

    boolean a(Context context, an anVar) {
        if (TiebaApplication.E() == null || TiebaApplication.I() == null || TiebaApplication.f().S() <= 0) {
            return false;
        }
        int hours = new Date(System.currentTimeMillis()).getHours();
        if ((hours >= 0 && hours <= 7) || hours >= 23) {
            return false;
        }
        long b = anVar.b();
        long c = anVar.c();
        long a2 = anVar.a();
        long d = anVar.d();
        if (b <= TiebaApplication.f().af() && c <= TiebaApplication.f().ag() && a2 <= TiebaApplication.f().ae() && d <= TiebaApplication.f().ah()) {
            return false;
        }
        boolean z = false;
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) TiebaApplication.f().getSystemService("activity")).getRunningTasks(BdWebErrorView.ERROR_CODE_500)) {
            if (runningTaskInfo.baseActivity.getClassName().startsWith(this.b.getPackageName())) {
                z = true;
            }
        }
        if (z) {
            return false;
        }
        Notification notification = new Notification(R.drawable.icon, this.b.getString(R.string.notify_text), System.currentTimeMillis());
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("reply_me", a2);
        intent.putExtra("at_me", b);
        intent.putExtra("fans", c);
        intent.putExtra("chat", d);
        intent.putExtra("is_notify", true);
        PendingIntent service = PendingIntent.getService(context, 0, intent, 134217728);
        StringBuffer stringBuffer = new StringBuffer();
        if (a2 > 0 || b > 0) {
            stringBuffer.append(String.valueOf(b + a2));
            stringBuffer.append(this.b.getString(R.string.notify_msg));
        }
        if (c > 0) {
            stringBuffer.append(String.valueOf(c));
            stringBuffer.append(this.b.getString(R.string.notify_fans));
        }
        if (d > 0) {
            stringBuffer.append(String.valueOf(d));
            stringBuffer.append(this.b.getString(R.string.notify_chat));
        }
        stringBuffer.append(this.b.getString(R.string.notify_click));
        notification.setLatestEventInfo(context, context.getString(R.string.app_name), stringBuffer, service);
        notification.defaults = -1;
        notification.defaults &= -3;
        notification.flags |= 16;
        notification.audioStreamType = 5;
        ((NotificationManager) context.getSystemService("notification")).notify(11, notification);
        return true;
    }
}
