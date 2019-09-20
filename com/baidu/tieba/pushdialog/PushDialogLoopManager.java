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
    private static PushDialogLoopManager iFw;
    private AlarmManager heg;
    private String iFx;
    private boolean iFz;
    private boolean dpW = false;
    private boolean iFy = false;
    private Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    PushDialogLoopManager.this.chz();
                    PushDialogLoopManager.chy().chA();
                    return true;
                default:
                    return false;
            }
        }
    });

    private PushDialogLoopManager() {
        this.iFx = "";
        this.iFz = false;
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
                if (!StringUtils.isNull(str) && responsedMessage.getError() == 0 && !PushDialogLoopManager.this.iFx.equals(str) && !"0".equals(str)) {
                    PushDialogLoopManager.this.iFx = str;
                    if (com.baidu.tieba.screenlocknotify.a.ckh().iRZ.cuH()) {
                        PushDialogLoopManager.this.dpW = true;
                    } else {
                        PushDialogLoopManager.this.DN(str);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(1003) { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                PushDialogLoopManager.this.chz();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001371) { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PushDialogLoopManager.this.chB();
            }
        });
        this.iFx = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_push_dialog_last_show_tid", "0");
        TbadkCoreApplication.getInst().registerReceiver(new a(), new IntentFilter("android.intent.action.SCREEN_OFF"));
        this.heg = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                TbadkCoreApplication.getInst().startService(new Intent().setClass(TbadkCoreApplication.getInst(), PushDialogJobService.class));
                this.iFz = true;
            }
        } catch (Throwable th) {
            BdLog.e(th);
            this.iFz = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PushDialogLoopManager chy() {
        if (iFw == null) {
            synchronized (PushDialogLoopManager.class) {
                if (iFw == null) {
                    iFw = new PushDialogLoopManager();
                }
            }
        }
        return iFw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chz() {
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            MessageManager.getInstance().sendMessage(new PullTidReqNetMessage(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, 309618));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chA() {
        if (this.handler.hasMessages(1)) {
            this.handler.removeMessages(1);
        }
        this.handler.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bVG() {
        this.iFy = false;
        DN(this.iFx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DN(String str) {
        if (!com.baidu.tieba.screenlocknotify.a.ckh().iRZ.cuH() && TbSingleton.getInstance().getLastResumeTime() <= UtilHelper.getTodayZeroTime()) {
            Activity eU = com.baidu.adp.base.a.eT().eU();
            if (eU != null && eU.getClass() != null && eU.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                eU.finish();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(TbadkCoreApplication.getInst(), 0L, str)));
            com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_push_dialog_last_show_tid", str);
            this.dpW = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chB() {
        this.handler.removeMessages(1);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbSingleton.getInstance().getPushDialogLoopTime() > 0) {
            this.handler.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chC() {
        if (this.dpW && com.baidu.tieba.screenlocknotify.a.ckh().ckl() && !this.iFy) {
            if (Build.VERSION.SDK_INT >= 21 && this.iFz) {
                try {
                    ((JobScheduler) TbadkCoreApplication.getInst().getSystemService("jobscheduler")).schedule(new JobInfo.Builder(29467, new ComponentName(TbadkCoreApplication.getInst(), PushDialogJobService.class)).setMinimumLatency(TbSingleton.getInstance().getPushDialogShowTime()).setOverrideDeadline(TbSingleton.getInstance().getPushDialogShowTime()).setRequiredNetworkType(1).setRequiresCharging(false).setRequiresDeviceIdle(false).build());
                } catch (Throwable th) {
                    BdLog.e(th);
                    chD();
                }
            } else {
                chD();
            }
            this.iFy = true;
            TiebaStatic.log(new an("c13196").P("obj_type", 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).bT("tid", this.iFx));
        }
    }

    private void chD() {
        this.heg.set(0, System.currentTimeMillis() + TbSingleton.getInstance().getPushDialogShowTime(), PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 29467, new Intent(TbadkCoreApplication.getInst().getApp(), PushAlarmReceiver.class), 134217728));
    }

    /* loaded from: classes3.dex */
    public static class PushAlarmReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PushDialogLoopManager.chy().bVG();
        }
    }

    /* loaded from: classes3.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                PushDialogLoopManager.chy().chC();
            }
        }
    }
}
