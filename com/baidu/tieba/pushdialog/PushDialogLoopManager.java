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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.pushdialog.data.PullTidHttpRespMessage;
import com.baidu.tieba.pushdialog.data.PullTidReqNetMessage;
import com.baidu.tieba.pushdialog.data.PullTidSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class PushDialogLoopManager {
    private static PushDialogLoopManager mNF;
    private AlarmManager kYL;
    private String mNG;
    private boolean mNJ;
    private boolean mNH = false;
    private boolean mNI = false;
    private Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    PushDialogLoopManager.this.dCc();
                    PushDialogLoopManager.dCb().dCd();
                    return true;
                default:
                    return false;
            }
        }
    });

    private PushDialogLoopManager() {
        this.mNG = "";
        this.mNJ = false;
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
                if (!StringUtils.isNull(str) && responsedMessage.getError() == 0 && !PushDialogLoopManager.this.mNG.equals(str) && !"0".equals(str)) {
                    PushDialogLoopManager.this.mNG = str;
                    if (com.baidu.tieba.screenlocknotify.a.dFp().ncw.dRU()) {
                        PushDialogLoopManager.this.mNH = true;
                    } else {
                        PushDialogLoopManager.this.QQ(str);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(1003) { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                PushDialogLoopManager.this.dCc();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.pushdialog.PushDialogLoopManager.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PushDialogLoopManager.this.dCf();
            }
        });
        this.mNG = com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_push_dialog_last_show_tid", "0");
        TbadkCoreApplication.getInst().registerReceiver(new a(), new IntentFilter("android.intent.action.SCREEN_OFF"));
        this.kYL = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                TbadkCoreApplication.getInst().startService(new Intent().setClass(TbadkCoreApplication.getInst(), PushDialogJobService.class));
                this.mNJ = true;
            }
        } catch (Throwable th) {
            BdLog.e(th);
            this.mNJ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PushDialogLoopManager dCb() {
        if (mNF == null) {
            synchronized (PushDialogLoopManager.class) {
                if (mNF == null) {
                    mNF = new PushDialogLoopManager();
                }
            }
        }
        return mNF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCc() {
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            MessageManager.getInstance().sendMessage(new PullTidReqNetMessage(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, 309618));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCd() {
        if (this.handler.hasMessages(1)) {
            this.handler.removeMessages(1);
        }
        this.handler.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dCe() {
        this.mNI = false;
        QQ(this.mNG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QQ(String str) {
        if (!com.baidu.tieba.screenlocknotify.a.dFp().ncw.dRU() && TbSingleton.getInstance().getLastResumeTime() <= UtilHelper.getTodayZeroTime()) {
            Activity currentActivity = com.baidu.adp.base.b.kB().currentActivity();
            if (currentActivity != null && currentActivity.getClass() != null && currentActivity.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                currentActivity.finish();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushDialogActivityConfig(TbadkCoreApplication.getInst(), 0L, str)));
            com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_push_dialog_last_show_tid", str);
            this.mNH = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCf() {
        this.handler.removeMessages(1);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbSingleton.getInstance().getPushDialogLoopTime() > 0) {
            this.handler.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCg() {
        if (this.mNH && com.baidu.tieba.screenlocknotify.a.dFp().dFt() && !this.mNI) {
            if (Build.VERSION.SDK_INT >= 21 && this.mNJ) {
                try {
                    ((JobScheduler) TbadkCoreApplication.getInst().getSystemService("jobscheduler")).schedule(new JobInfo.Builder(29467, new ComponentName(TbadkCoreApplication.getInst(), PushDialogJobService.class)).setMinimumLatency(TbSingleton.getInstance().getPushDialogShowTime()).setOverrideDeadline(TbSingleton.getInstance().getPushDialogShowTime()).setRequiredNetworkType(1).setRequiresCharging(false).setRequiresDeviceIdle(false).build());
                } catch (Throwable th) {
                    BdLog.e(th);
                    dCh();
                }
            } else {
                dCh();
            }
            this.mNI = true;
            TiebaStatic.log(new ar("c13196").ap("obj_type", 1).ap("obj_source", 2).dR("tid", this.mNG));
        }
    }

    private void dCh() {
        this.kYL.set(0, System.currentTimeMillis() + TbSingleton.getInstance().getPushDialogShowTime(), PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 29467, new Intent(TbadkCoreApplication.getInst().getApp(), PushAlarmReceiver.class), 134217728));
    }

    /* loaded from: classes8.dex */
    public static class PushAlarmReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PushDialogLoopManager.dCb().dCe();
        }
    }

    /* loaded from: classes8.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                PushDialogLoopManager.dCb().dCg();
            }
        }
    }
}
