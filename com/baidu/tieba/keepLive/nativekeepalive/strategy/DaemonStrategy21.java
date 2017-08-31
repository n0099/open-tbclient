package com.baidu.tieba.keepLive.nativekeepalive.strategy;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.keepLive.nativekeepalive.DaemonConfigurations;
import com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy;
import com.baidu.tieba.keepLive.nativekeepalive.NativeDaemonAPI21;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public class DaemonStrategy21 implements IDaemonStrategy {
    private static final String INDICATOR_DAEMON_ASSISTANT_FILENAME = "indicator_d";
    private static final String INDICATOR_DIR_NAME = "indicators";
    private static final String INDICATOR_PERSISTENT_FILENAME = "indicator_p";
    private static final String OBSERVER_DAEMON_ASSISTANT_FILENAME = "observer_d";
    private static final String OBSERVER_PERSISTENT_FILENAME = "observer_p";
    private AlarmManager mAlarmManager;
    private DaemonConfigurations mConfigs;
    private PendingIntent mPendingIntent;

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public boolean onInitialization(Context context) {
        return initIndicators(context);
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onPersistentCreate(final Context context, DaemonConfigurations daemonConfigurations) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), daemonConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME));
        context.startService(intent);
        initAlarm(context, daemonConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
        Thread thread = new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategy21.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = context.getDir(DaemonStrategy21.INDICATOR_DIR_NAME, 0);
                new NativeDaemonAPI21(context).doDaemon(new File(dir, DaemonStrategy21.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy21.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy21.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy21.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
            }
        };
        thread.setPriority(10);
        thread.start();
        if (daemonConfigurations != null && daemonConfigurations.LISTENER != null) {
            this.mConfigs = daemonConfigurations;
            daemonConfigurations.LISTENER.onPersistentStart(context);
        }
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onDaemonAssistantCreate(final Context context, DaemonConfigurations daemonConfigurations) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), daemonConfigurations.PERSISTENT_CONFIG.SERVICE_NAME));
        context.startService(intent);
        initAlarm(context, daemonConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
        Thread thread = new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategy21.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = context.getDir(DaemonStrategy21.INDICATOR_DIR_NAME, 0);
                new NativeDaemonAPI21(context).doDaemon(new File(dir, DaemonStrategy21.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy21.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy21.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy21.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
            }
        };
        thread.setPriority(10);
        thread.start();
        if (daemonConfigurations != null && daemonConfigurations.LISTENER != null) {
            this.mConfigs = daemonConfigurations;
            daemonConfigurations.LISTENER.onDaemonAssistantStart(context);
        }
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onDaemonDead() {
        if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
            this.mAlarmManager.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.mPendingIntent);
            if (this.mConfigs != null && this.mConfigs.LISTENER != null) {
                this.mConfigs.LISTENER.onWatchDaemonDaed();
            }
            Process.killProcess(Process.myPid());
            return;
        }
        Process.killProcess(Process.myPid());
    }

    private void initAlarm(Context context, String str) {
        if (this.mAlarmManager == null) {
            this.mAlarmManager = (AlarmManager) context.getSystemService("alarm");
        }
        if (this.mPendingIntent == null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), str));
            intent.setFlags(16);
            this.mPendingIntent = PendingIntent.getService(context, 0, intent, 0);
        }
        this.mAlarmManager.cancel(this.mPendingIntent);
    }

    private boolean initIndicators(Context context) {
        File dir = context.getDir(INDICATOR_DIR_NAME, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            createNewFile(dir, INDICATOR_PERSISTENT_FILENAME);
            createNewFile(dir, INDICATOR_DAEMON_ASSISTANT_FILENAME);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void createNewFile(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.createNewFile();
        }
    }
}
