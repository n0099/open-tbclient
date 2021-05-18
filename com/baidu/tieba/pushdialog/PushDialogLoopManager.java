package com.baidu.tieba.pushdialog;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pushdialog.data.PullTidHttpRespMessage;
import com.baidu.tieba.pushdialog.data.PullTidReqNetMessage;
import com.baidu.tieba.pushdialog.data.PullTidSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
/* loaded from: classes5.dex */
public class PushDialogLoopManager {

    /* renamed from: g  reason: collision with root package name */
    public static PushDialogLoopManager f20134g;

    /* renamed from: a  reason: collision with root package name */
    public Handler f20135a;

    /* renamed from: b  reason: collision with root package name */
    public String f20136b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20137c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20138d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20139e;

    /* renamed from: f  reason: collision with root package name */
    public AlarmManager f20140f;

    /* loaded from: classes5.dex */
    public static class PushAlarmReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PushDialogLoopManager.i().o();
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            PushDialogLoopManager.this.n();
            PushDialogLoopManager.i().l();
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String tid;
            if (responsedMessage instanceof PullTidHttpRespMessage) {
                tid = ((PullTidHttpRespMessage) responsedMessage).getTid();
            } else {
                tid = responsedMessage instanceof PullTidSocketResponseMessage ? ((PullTidSocketResponseMessage) responsedMessage).getTid() : "";
            }
            if (StringUtils.isNull(tid) || responsedMessage.getError() != 0 || PushDialogLoopManager.this.f20136b.equals(tid) || "0".equals(tid)) {
                return;
            }
            PushDialogLoopManager.this.f20136b = tid;
            if (d.a.k0.u2.a.j().f62153d.c()) {
                PushDialogLoopManager.this.f20137c = true;
            } else {
                PushDialogLoopManager.this.p(tid);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.a.c.c.g.c {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PushDialogLoopManager.this.n();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PushDialogLoopManager.this.m();
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                return;
            }
            PushDialogLoopManager.i().j();
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public PushDialogLoopManager() {
        this.f20136b = "";
        this.f20139e = false;
        Handler handler = new Handler(Looper.getMainLooper(), new a());
        this.f20135a = handler;
        handler.sendEmptyMessage(1);
        MessageManager.getInstance().registerListener(new b(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, 309618));
        MessageManager.getInstance().registerListener(new c(1003));
        MessageManager.getInstance().registerListener(new d(2001371));
        this.f20136b = d.a.j0.r.d0.b.j().p("key_push_dialog_last_show_tid", "0");
        TbadkCoreApplication.getInst().registerReceiver(new e(null), new IntentFilter("android.intent.action.SCREEN_OFF"));
        this.f20140f = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                TbadkCoreApplication.getInst().startService(new Intent().setClass(TbadkCoreApplication.getInst(), PushDialogJobService.class));
                this.f20139e = true;
            }
        } catch (Throwable th) {
            BdLog.e(th);
            this.f20139e = false;
        }
    }

    public static PushDialogLoopManager i() {
        if (f20134g == null) {
            synchronized (PushDialogLoopManager.class) {
                if (f20134g == null) {
                    f20134g = new PushDialogLoopManager();
                }
            }
        }
        return f20134g;
    }

    public final void j() {
        if (this.f20137c && d.a.k0.u2.a.j().g() && !this.f20138d) {
            if (Build.VERSION.SDK_INT >= 21 && this.f20139e) {
                try {
                    ((JobScheduler) TbadkCoreApplication.getInst().getSystemService("jobscheduler")).schedule(new JobInfo.Builder(29467, new ComponentName(TbadkCoreApplication.getInst(), PushDialogJobService.class)).setMinimumLatency(TbSingleton.getInstance().getPushDialogShowTime()).setOverrideDeadline(TbSingleton.getInstance().getPushDialogShowTime()).setRequiredNetworkType(1).setRequiresCharging(false).setRequiresDeviceIdle(false).build());
                } catch (Throwable th) {
                    BdLog.e(th);
                    k();
                }
            } else {
                k();
            }
            this.f20138d = true;
            TiebaStatic.log(new StatisticItem("c13196").param("obj_type", 1).param("obj_source", 2).param("tid", this.f20136b));
        }
    }

    public final void k() {
        this.f20140f.set(0, System.currentTimeMillis() + TbSingleton.getInstance().getPushDialogShowTime(), PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 29467, new Intent(TbadkCoreApplication.getInst().getApp(), PushAlarmReceiver.class), 134217728));
    }

    public final void l() {
        if (this.f20135a.hasMessages(1)) {
            this.f20135a.removeMessages(1);
        }
        this.f20135a.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
    }

    public final void m() {
        this.f20135a.removeMessages(1);
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) || TbSingleton.getInstance().getPushDialogLoopTime() <= 0) {
            return;
        }
        this.f20135a.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
    }

    public final void n() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        MessageManager.getInstance().sendMessage(new PullTidReqNetMessage(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, 309618));
    }

    public void o() {
        this.f20138d = false;
        p(this.f20136b);
    }

    public final void p(String str) {
        if (!d.a.k0.u2.a.j().f62153d.c() && TbSingleton.getInstance().getLastResumeTime() <= UtilHelper.getTodayZeroTime()) {
            Activity b2 = d.a.c.a.b.f().b();
            if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                b2.finish();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(TbadkCoreApplication.getInst(), 0L, str)));
            d.a.j0.r.d0.b.j().x("key_push_dialog_last_show_tid", str);
            this.f20137c = false;
        }
    }
}
