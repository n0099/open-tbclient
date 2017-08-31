package com.baidu.tieba.keepLive.nativekeepalive.strategy;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.tieba.keepLive.nativekeepalive.DaemonConfigurations;
import com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy;
import com.baidu.tieba.keepLive.nativekeepalive.NativeDaemonAPI21;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class DaemonStrategy23 implements IDaemonStrategy {
    private static final String INDICATOR_DAEMON_ASSISTANT_FILENAME = "indicator_d";
    private static final String INDICATOR_DIR_NAME = "indicators";
    private static final String INDICATOR_PERSISTENT_FILENAME = "indicator_p";
    private static final String OBSERVER_DAEMON_ASSISTANT_FILENAME = "observer_d";
    private static final String OBSERVER_PERSISTENT_FILENAME = "observer_p";
    private Parcel mBroadcastData;
    private DaemonConfigurations mConfigs;
    private IBinder mRemote;

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public boolean onInitialization(Context context) {
        return initIndicatorFiles(context);
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onPersistentCreate(final Context context, DaemonConfigurations daemonConfigurations) {
        initAmsBinder();
        initBroadcastParcel(context, daemonConfigurations.DAEMON_ASSISTANT_CONFIG.RECEIVER_NAME);
        sendBroadcastByAmsBinder();
        new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategy23.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = context.getDir(DaemonStrategy23.INDICATOR_DIR_NAME, 0);
                new NativeDaemonAPI21(context).doDaemon(new File(dir, DaemonStrategy23.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy23.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy23.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy23.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
            }
        }.start();
        ComponentName componentName = new ComponentName(context.getPackageName(), daemonConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        context.startService(intent);
        if (daemonConfigurations != null && daemonConfigurations.LISTENER != null) {
            this.mConfigs = daemonConfigurations;
            daemonConfigurations.LISTENER.onPersistentStart(context);
        }
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onDaemonAssistantCreate(final Context context, DaemonConfigurations daemonConfigurations) {
        initAmsBinder();
        initBroadcastParcel(context, daemonConfigurations.PERSISTENT_CONFIG.RECEIVER_NAME);
        sendBroadcastByAmsBinder();
        new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategy23.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = context.getDir(DaemonStrategy23.INDICATOR_DIR_NAME, 0);
                new NativeDaemonAPI21(context).doDaemon(new File(dir, DaemonStrategy23.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy23.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy23.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, DaemonStrategy23.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
            }
        }.start();
        ComponentName componentName = new ComponentName(context.getPackageName(), daemonConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        context.startService(intent);
        if (daemonConfigurations != null && daemonConfigurations.LISTENER != null) {
            this.mConfigs = daemonConfigurations;
            daemonConfigurations.LISTENER.onDaemonAssistantStart(context);
        }
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onDaemonDead() {
        if (sendBroadcastByAmsBinder()) {
            if (this.mConfigs != null && this.mConfigs.LISTENER != null) {
                this.mConfigs.LISTENER.onWatchDaemonDaed();
            }
            Process.killProcess(Process.myPid());
        }
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
    private void initBroadcastParcel(Context context, String str) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), str));
        intent.setFlags(32);
        this.mBroadcastData = Parcel.obtain();
        this.mBroadcastData.writeInterfaceToken("android.app.IActivityManager");
        this.mBroadcastData.writeStrongBinder(null);
        intent.writeToParcel(this.mBroadcastData, 0);
        this.mBroadcastData.writeString(intent.resolveTypeIfNeeded(context.getContentResolver()));
        this.mBroadcastData.writeStrongBinder(null);
        this.mBroadcastData.writeInt(-1);
        this.mBroadcastData.writeString(null);
        this.mBroadcastData.writeBundle(null);
        this.mBroadcastData.writeString(null);
        this.mBroadcastData.writeInt(-1);
        this.mBroadcastData.writeInt(0);
        this.mBroadcastData.writeInt(0);
        this.mBroadcastData.writeInt(0);
    }

    private boolean sendBroadcastByAmsBinder() {
        boolean z = false;
        try {
            if (this.mRemote == null || this.mBroadcastData == null) {
                Log.e("Daemon", "REMOTE IS NULL or PARCEL IS NULL !!!");
            } else {
                this.mRemote.transact(14, this.mBroadcastData, null, 0);
                z = true;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return z;
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
