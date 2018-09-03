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
import android.support.v4.app.NotificationCompat;
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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.pushdialog.data.PullTidHttpRespMessage;
import com.baidu.tieba.pushdialog.data.PullTidReqNetMessage;
import com.baidu.tieba.pushdialog.data.PullTidSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class PushDialogLoopManager {
    private static PushDialogLoopManager gkK;
    private AlarmManager eMT;
    private String gkL;
    private boolean gkO;
    private boolean gkM = false;
    private boolean gkN = false;
    private Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    PushDialogLoopManager.this.Pd();
                    PushDialogLoopManager.bmh().bmi();
                    return true;
                default:
                    return false;
            }
        }
    });

    private PushDialogLoopManager() {
        this.gkL = "";
        this.gkO = false;
        this.handler.sendEmptyMessage(1);
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, 309618) { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof PullTidHttpRespMessage) {
                    str = ((PullTidHttpRespMessage) responsedMessage).getTid();
                } else if (responsedMessage instanceof PullTidSocketResponseMessage) {
                    str = ((PullTidSocketResponseMessage) responsedMessage).getTid();
                }
                if (!StringUtils.isNull(str) && responsedMessage.getError() == 0 && !PushDialogLoopManager.this.gkL.equals(str) && !"0".equals(str)) {
                    PushDialogLoopManager.this.gkL = str;
                    if (com.baidu.tieba.screenlocknotify.a.boK().gwN.isScreenOn()) {
                        PushDialogLoopManager.this.gkM = true;
                    } else {
                        PushDialogLoopManager.this.sx(str);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(1003) { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                PushDialogLoopManager.this.Pd();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001371) { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PushDialogLoopManager.this.bmj();
            }
        });
        this.gkL = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_push_dialog_last_show_tid", "0");
        TbadkCoreApplication.getInst().registerReceiver(new a(), new IntentFilter("android.intent.action.SCREEN_OFF"));
        this.eMT = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                TbadkCoreApplication.getInst().startService(new Intent().setClass(TbadkCoreApplication.getInst(), PushDialogJobService.class));
                this.gkO = true;
            }
        } catch (Throwable th) {
            BdLog.e(th);
            this.gkO = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PushDialogLoopManager bmh() {
        if (gkK == null) {
            synchronized (PushDialogLoopManager.class) {
                if (gkK == null) {
                    gkK = new PushDialogLoopManager();
                }
            }
        }
        return gkK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pd() {
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            MessageManager.getInstance().sendMessage(new PullTidReqNetMessage(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, 309618));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmi() {
        if (this.handler.hasMessages(1)) {
            this.handler.removeMessages(1);
        }
        this.handler.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bbn() {
        this.gkN = false;
        sx(this.gkL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sx(String str) {
        if (!com.baidu.tieba.screenlocknotify.a.boK().gwN.isScreenOn() && TbSingleton.getInstance().getLastResumeTime() <= UtilHelper.getTodayZeroTime()) {
            Activity ex = com.baidu.adp.base.a.ew().ex();
            if (ex != null && ex.getClass() != null && ex.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                ex.finish();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(TbadkCoreApplication.getInst(), 0L, str)));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_push_dialog_last_show_tid", str);
            this.gkM = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmj() {
        this.handler.removeMessages(1);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbSingleton.getInstance().getPushDialogLoopTime() > 0) {
            this.handler.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmk() {
        if (this.gkM && com.baidu.tieba.screenlocknotify.a.boK().boO() && !this.gkN) {
            if (Build.VERSION.SDK_INT >= 21 && this.gkO) {
                try {
                    ((JobScheduler) TbadkCoreApplication.getInst().getSystemService("jobscheduler")).schedule(new JobInfo.Builder(29467, new ComponentName(TbadkCoreApplication.getInst(), PushDialogJobService.class)).setMinimumLatency(TbSingleton.getInstance().getPushDialogShowTime()).setOverrideDeadline(TbSingleton.getInstance().getPushDialogShowTime()).setRequiredNetworkType(1).setRequiresCharging(false).setRequiresDeviceIdle(false).build());
                } catch (Throwable th) {
                    BdLog.e(th);
                    bml();
                }
            } else {
                bml();
            }
            this.gkN = true;
            TiebaStatic.log(new an("c13196").r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).ae("tid", this.gkL));
        }
    }

    private void bml() {
        this.eMT.set(0, System.currentTimeMillis() + TbSingleton.getInstance().getPushDialogShowTime(), PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 29467, new Intent(TbadkCoreApplication.getInst().getApp(), PushAlarmReceiver.class), 134217728));
    }

    /* loaded from: classes3.dex */
    public static class PushAlarmReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PushDialogLoopManager.bmh().bbn();
        }
    }

    /* loaded from: classes3.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                PushDialogLoopManager.bmh().bmk();
            }
        }
    }
}
