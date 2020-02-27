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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes8.dex */
public class PushDialogLoopManager {
    private static PushDialogLoopManager jBS;
    private AlarmManager hVd;
    private String jBT;
    private boolean jBW;
    private boolean jBU = false;
    private boolean jBV = false;
    private Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    PushDialogLoopManager.this.cBf();
                    PushDialogLoopManager.cBe().cBg();
                    return true;
                default:
                    return false;
            }
        }
    });

    private PushDialogLoopManager() {
        this.jBT = "";
        this.jBW = false;
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
                if (!StringUtils.isNull(str) && responsedMessage.getError() == 0 && !PushDialogLoopManager.this.jBT.equals(str) && !"0".equals(str)) {
                    PushDialogLoopManager.this.jBT = str;
                    if (com.baidu.tieba.screenlocknotify.a.cDZ().jPc.cOY()) {
                        PushDialogLoopManager.this.jBU = true;
                    } else {
                        PushDialogLoopManager.this.Ht(str);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(1003) { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                PushDialogLoopManager.this.cBf();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PushDialogLoopManager.this.cBi();
            }
        });
        this.jBT = com.baidu.tbadk.core.sharedPref.b.aFB().getString("key_push_dialog_last_show_tid", "0");
        TbadkCoreApplication.getInst().registerReceiver(new a(), new IntentFilter("android.intent.action.SCREEN_OFF"));
        this.hVd = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                TbadkCoreApplication.getInst().startService(new Intent().setClass(TbadkCoreApplication.getInst(), PushDialogJobService.class));
                this.jBW = true;
            }
        } catch (Throwable th) {
            BdLog.e(th);
            this.jBW = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PushDialogLoopManager cBe() {
        if (jBS == null) {
            synchronized (PushDialogLoopManager.class) {
                if (jBS == null) {
                    jBS = new PushDialogLoopManager();
                }
            }
        }
        return jBS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBf() {
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            MessageManager.getInstance().sendMessage(new PullTidReqNetMessage(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, 309618));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBg() {
        if (this.handler.hasMessages(1)) {
            this.handler.removeMessages(1);
        }
        this.handler.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cBh() {
        this.jBV = false;
        Ht(this.jBT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ht(String str) {
        if (!com.baidu.tieba.screenlocknotify.a.cDZ().jPc.cOY() && TbSingleton.getInstance().getLastResumeTime() <= UtilHelper.getTodayZeroTime()) {
            Activity currentActivity = com.baidu.adp.base.a.eH().currentActivity();
            if (currentActivity != null && currentActivity.getClass() != null && currentActivity.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                currentActivity.finish();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushDialogActivityConfig(TbadkCoreApplication.getInst(), 0L, str)));
            com.baidu.tbadk.core.sharedPref.b.aFB().putString("key_push_dialog_last_show_tid", str);
            this.jBU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBi() {
        this.handler.removeMessages(1);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbSingleton.getInstance().getPushDialogLoopTime() > 0) {
            this.handler.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBj() {
        if (this.jBU && com.baidu.tieba.screenlocknotify.a.cDZ().cEd() && !this.jBV) {
            if (Build.VERSION.SDK_INT >= 21 && this.jBW) {
                try {
                    ((JobScheduler) TbadkCoreApplication.getInst().getSystemService("jobscheduler")).schedule(new JobInfo.Builder(29467, new ComponentName(TbadkCoreApplication.getInst(), PushDialogJobService.class)).setMinimumLatency(TbSingleton.getInstance().getPushDialogShowTime()).setOverrideDeadline(TbSingleton.getInstance().getPushDialogShowTime()).setRequiredNetworkType(1).setRequiresCharging(false).setRequiresDeviceIdle(false).build());
                } catch (Throwable th) {
                    BdLog.e(th);
                    cBk();
                }
            } else {
                cBk();
            }
            this.jBV = true;
            TiebaStatic.log(new an("c13196").X("obj_type", 1).X("obj_source", 2).cy("tid", this.jBT));
        }
    }

    private void cBk() {
        this.hVd.set(0, System.currentTimeMillis() + TbSingleton.getInstance().getPushDialogShowTime(), PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 29467, new Intent(TbadkCoreApplication.getInst().getApp(), PushAlarmReceiver.class), 134217728));
    }

    /* loaded from: classes8.dex */
    public static class PushAlarmReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PushDialogLoopManager.cBe().cBh();
        }
    }

    /* loaded from: classes8.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                PushDialogLoopManager.cBe().cBj();
            }
        }
    }
}
