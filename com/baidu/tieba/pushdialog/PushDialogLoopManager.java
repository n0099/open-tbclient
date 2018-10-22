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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.pushdialog.data.PullTidHttpRespMessage;
import com.baidu.tieba.pushdialog.data.PullTidReqNetMessage;
import com.baidu.tieba.pushdialog.data.PullTidSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class PushDialogLoopManager {
    private static PushDialogLoopManager gzD;
    private AlarmManager fbX;
    private String gzE;
    private boolean gzH;
    private boolean gzF = false;
    private boolean gzG = false;
    private Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    PushDialogLoopManager.this.bsd();
                    PushDialogLoopManager.bsc().bse();
                    return true;
                default:
                    return false;
            }
        }
    });

    private PushDialogLoopManager() {
        this.gzE = "";
        this.gzH = false;
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
                if (!StringUtils.isNull(str) && responsedMessage.getError() == 0 && !PushDialogLoopManager.this.gzE.equals(str) && !"0".equals(str)) {
                    PushDialogLoopManager.this.gzE = str;
                    if (com.baidu.tieba.screenlocknotify.a.buG().gLD.isScreenOn()) {
                        PushDialogLoopManager.this.gzF = true;
                    } else {
                        PushDialogLoopManager.this.tE(str);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(1003) { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                PushDialogLoopManager.this.bsd();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001371) { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PushDialogLoopManager.this.bsf();
            }
        });
        this.gzE = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_push_dialog_last_show_tid", "0");
        TbadkCoreApplication.getInst().registerReceiver(new a(), new IntentFilter("android.intent.action.SCREEN_OFF"));
        this.fbX = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                TbadkCoreApplication.getInst().startService(new Intent().setClass(TbadkCoreApplication.getInst(), PushDialogJobService.class));
                this.gzH = true;
            }
        } catch (Throwable th) {
            BdLog.e(th);
            this.gzH = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PushDialogLoopManager bsc() {
        if (gzD == null) {
            synchronized (PushDialogLoopManager.class) {
                if (gzD == null) {
                    gzD = new PushDialogLoopManager();
                }
            }
        }
        return gzD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsd() {
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            MessageManager.getInstance().sendMessage(new PullTidReqNetMessage(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, 309618));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bse() {
        if (this.handler.hasMessages(1)) {
            this.handler.removeMessages(1);
        }
        this.handler.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bhb() {
        this.gzG = false;
        tE(this.gzE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tE(String str) {
        if (!com.baidu.tieba.screenlocknotify.a.buG().gLD.isScreenOn() && TbSingleton.getInstance().getLastResumeTime() <= UtilHelper.getTodayZeroTime()) {
            Activity fX = com.baidu.adp.base.a.fW().fX();
            if (fX != null && fX.getClass() != null && fX.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                fX.finish();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(TbadkCoreApplication.getInst(), 0L, str)));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_push_dialog_last_show_tid", str);
            this.gzF = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsf() {
        this.handler.removeMessages(1);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbSingleton.getInstance().getPushDialogLoopTime() > 0) {
            this.handler.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsg() {
        if (this.gzF && com.baidu.tieba.screenlocknotify.a.buG().buK() && !this.gzG) {
            if (Build.VERSION.SDK_INT >= 21 && this.gzH) {
                try {
                    ((JobScheduler) TbadkCoreApplication.getInst().getSystemService("jobscheduler")).schedule(new JobInfo.Builder(29467, new ComponentName(TbadkCoreApplication.getInst(), PushDialogJobService.class)).setMinimumLatency(TbSingleton.getInstance().getPushDialogShowTime()).setOverrideDeadline(TbSingleton.getInstance().getPushDialogShowTime()).setRequiredNetworkType(1).setRequiresCharging(false).setRequiresDeviceIdle(false).build());
                } catch (Throwable th) {
                    BdLog.e(th);
                    bsh();
                }
            } else {
                bsh();
            }
            this.gzG = true;
            TiebaStatic.log(new am("c13196").x("obj_type", 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).ax("tid", this.gzE));
        }
    }

    private void bsh() {
        this.fbX.set(0, System.currentTimeMillis() + TbSingleton.getInstance().getPushDialogShowTime(), PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 29467, new Intent(TbadkCoreApplication.getInst().getApp(), PushAlarmReceiver.class), 134217728));
    }

    /* loaded from: classes3.dex */
    public static class PushAlarmReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PushDialogLoopManager.bsc().bhb();
        }
    }

    /* loaded from: classes3.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                PushDialogLoopManager.bsc().bsg();
            }
        }
    }
}
