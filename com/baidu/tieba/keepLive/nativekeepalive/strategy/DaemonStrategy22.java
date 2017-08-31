package com.baidu.tieba.keepLive.nativekeepalive.strategy;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.keepLive.nativekeepalive.DaemonConfigurations;
import com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy;
import com.baidu.tieba.keepLive.nativekeepalive.NativeDaemonAPI21;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class DaemonStrategy22 implements IDaemonStrategy {
    private static final String INDICATOR_DAEMON_ASSISTANT_FILENAME = "indicator_d";
    private static final String INDICATOR_DIR_NAME = "indicators";
    private static final String INDICATOR_PERSISTENT_FILENAME = "indicator_p";
    private static final String OBSERVER_DAEMON_ASSISTANT_FILENAME = "observer_d";
    private static final String OBSERVER_PERSISTENT_FILENAME = "observer_p";
    private DaemonConfigurations mConfigs;
    private IBinder mRemote;
    private Parcel mServiceData;

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public boolean onInitialization(Context context) {
        return initIndicatorFiles(context);
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onPersistentCreate(final Context context, DaemonConfigurations daemonConfigurations) {
        initAmsBinder();
        initServiceParcel(context, daemonConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
        startServiceByAmsBinder();
        new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategy22.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = context.getDir(DaemonStrategy22.INDICATOR_DIR_NAME, 0);
                new NativeDaemonAPI21(context).doDaemon(new File(dir, DaemonStrategy22.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy22.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy22.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy22.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
            }
        }.start();
        if (daemonConfigurations != null && daemonConfigurations.LISTENER != null) {
            this.mConfigs = daemonConfigurations;
            daemonConfigurations.LISTENER.onPersistentStart(context);
        }
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onDaemonAssistantCreate(final Context context, DaemonConfigurations daemonConfigurations) {
        initAmsBinder();
        initServiceParcel(context, daemonConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
        startServiceByAmsBinder();
        new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategy22.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = context.getDir(DaemonStrategy22.INDICATOR_DIR_NAME, 0);
                new NativeDaemonAPI21(context).doDaemon(new File(dir, DaemonStrategy22.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy22.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy22.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy22.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
            }
        }.start();
        if (daemonConfigurations != null && daemonConfigurations.LISTENER != null) {
            this.mConfigs = daemonConfigurations;
            daemonConfigurations.LISTENER.onDaemonAssistantStart(context);
        }
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onDaemonDead() {
        if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
            if (startServiceByAmsBinder()) {
                if (this.mConfigs != null && this.mConfigs.LISTENER != null) {
                    this.mConfigs.LISTENER.onWatchDaemonDaed();
                }
                Process.killProcess(Process.myPid());
                return;
            }
            return;
        }
        Process.killProcess(Process.myPid());
    }

    private void initAmsBinder() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityManagerNative");
            Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
            Field declaredField = invoke.getClass().getDeclaredField("mRemote");
            declaredField.setAccessible(true);
            this.mRemote = (IBinder) declaredField.get(invoke);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        }
    }

    @SuppressLint({"Recycle"})
    private void initServiceParcel(Context context, String str) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), str));
        this.mServiceData = Parcel.obtain();
        this.mServiceData.writeInterfaceToken("android.app.IActivityManager");
        this.mServiceData.writeStrongBinder(null);
        intent.writeToParcel(this.mServiceData, 0);
        this.mServiceData.writeString(null);
        this.mServiceData.writeInt(0);
    }

    private boolean startServiceByAmsBinder() {
        try {
            if (this.mRemote == null || this.mServiceData == null) {
                return false;
            }
            this.mRemote.transact(34, this.mServiceData, null, 0);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean initIndicatorFiles(Context context) {
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
