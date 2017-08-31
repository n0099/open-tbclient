package com.baidu.tieba.keepLive.nativekeepalive.strategy;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.keepLive.nativekeepalive.DaemonConfigurations;
import com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy;
import com.baidu.tieba.keepLive.nativekeepalive.NativeDaemonAPI20;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class DaemonStrategyUnder21 implements IDaemonStrategy {
    private final String BINARY_DEST_DIR_NAME = "bin";
    private final String BINARY_FILE_NAME = "daemon";
    private AlarmManager mAlarmManager;
    private PendingIntent mPendingIntent;

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public boolean onInitialization(Context context) {
        return installBinary(context);
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onPersistentCreate(final Context context, final DaemonConfigurations daemonConfigurations) {
        if (TbadkCoreApplication.getKeepLiveSwitch(context)) {
            initAlarm(context, daemonConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
            Thread thread = new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategyUnder21.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    new NativeDaemonAPI20(context).doDaemon(context.getPackageName(), daemonConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME, new File(context.getDir("bin", 0), "daemon").getAbsolutePath());
                }
            };
            thread.setPriority(10);
            thread.start();
            if (daemonConfigurations != null && daemonConfigurations.LISTENER != null) {
                daemonConfigurations.LISTENER.onPersistentStart(context);
            }
        }
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onDaemonAssistantCreate(Context context, DaemonConfigurations daemonConfigurations) {
        if (TbadkCoreApplication.getKeepLiveSwitch(context)) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), daemonConfigurations.PERSISTENT_CONFIG.SERVICE_NAME));
            context.startService(intent);
            if (daemonConfigurations != null && daemonConfigurations.LISTENER != null) {
                daemonConfigurations.LISTENER.onWatchDaemonDaed();
            }
            Process.killProcess(Process.myPid());
        }
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onDaemonDead() {
        if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
            this.mAlarmManager.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.mPendingIntent);
            Process.killProcess(Process.myPid());
        }
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

    private boolean installBinary(Context context) {
        String str;
        String str2 = Build.CPU_ABI;
        if (str2.startsWith("armeabi-v7a")) {
            str = "armeabi-v7a";
        } else if (str2.startsWith("x86")) {
            str = "x86";
        } else {
            str = "armeabi";
        }
        return install(context, "bin", str, "daemon");
    }

    private boolean install(Context context, String str, String str2, String str3) {
        File file = new File(context.getDir(str, 0), str3);
        if (file.exists()) {
            return true;
        }
        try {
            copyAssets(context, (TextUtils.isEmpty(str2) ? "" : str2 + File.separator) + str3, file, "700");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void copyAssets(Context context, String str, File file, String str2) throws IOException, InterruptedException {
        copyFile(file, context.getAssets().open(str), str2);
    }

    private void copyFile(File file, InputStream inputStream, String str) throws IOException, InterruptedException {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.close();
                inputStream.close();
                Runtime.getRuntime().exec("chmod " + str + " " + absolutePath).waitFor();
                return;
            }
        }
    }
}
