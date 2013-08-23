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
import com.baidu.tieba.data.aj;
import com.baidu.tieba.data.au;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.v f1715a;
    final /* synthetic */ MessagePullService b;

    private f(MessagePullService messagePullService) {
        this.b = messagePullService;
        this.f1715a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(MessagePullService messagePullService, f fVar) {
        this(messagePullService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        aq.a(getClass().getName(), "doBackGround", "pull message...");
        try {
            this.f1715a = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/m/getmsg");
            this.f1715a.a("message_id", String.valueOf(TiebaApplication.g().aN()));
            this.f1715a.a("pk_before_id", TiebaApplication.g().ar());
            this.f1715a.a("pk_after_id", TiebaApplication.g().as());
            return this.f1715a.j();
        } catch (Exception e) {
            aq.b(getClass().getName(), "doBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.f1703a = null;
        if (this.f1715a != null) {
            this.f1715a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0069, code lost:
        if (r0.a() > com.baidu.tieba.TiebaApplication.g().aN()) goto L11;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        au auVar;
        au auVar2;
        au auVar3;
        au auVar4;
        au auVar5;
        au auVar6;
        if (this.f1715a.d()) {
            aq.a(getClass().getName(), "onPostExecute", "result=" + str);
            if (this.f1715a.c()) {
                aj ajVar = new aj();
                ajVar.a(str);
                if (!a(this.b, ajVar)) {
                    auVar = this.b.b;
                    auVar.a(str);
                    auVar2 = this.b.b;
                    if (auVar2.a() != -1) {
                        auVar6 = this.b.b;
                    }
                    auVar3 = this.b.b;
                    if (auVar3.a() != -1) {
                        TiebaApplication g = TiebaApplication.g();
                        auVar5 = this.b.b;
                        g.c(auVar5.a());
                    }
                    MessagePullService messagePullService = this.b;
                    auVar4 = this.b.b;
                    UtilHelper.a(messagePullService, auVar4, 13);
                }
            }
        }
        this.b.f1703a = null;
    }

    boolean a(Context context, aj ajVar) {
        if (TiebaApplication.E() == null || TiebaApplication.I() == null || TiebaApplication.g().S() <= 0) {
            return false;
        }
        int hours = new Date(System.currentTimeMillis()).getHours();
        if ((hours >= 0 && hours <= 7) || hours >= 23) {
            return false;
        }
        long b = ajVar.b();
        long c = ajVar.c();
        long a2 = ajVar.a();
        long d = ajVar.d();
        if (b <= com.baidu.tieba.mention.r.a().h() && c <= com.baidu.tieba.mention.r.a().i() && a2 <= com.baidu.tieba.mention.r.a().g() && d <= com.baidu.tieba.mention.r.a().j()) {
            return false;
        }
        boolean z = false;
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) TiebaApplication.g().getSystemService("activity")).getRunningTasks(BdWebErrorView.ERROR_CODE_500)) {
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
        if (a2 > 0 || b > 0 || d > 0) {
            stringBuffer.append(String.valueOf(b + a2 + d));
            stringBuffer.append(this.b.getString(R.string.notify_msg));
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
