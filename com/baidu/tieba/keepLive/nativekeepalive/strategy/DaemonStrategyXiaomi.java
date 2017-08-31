package com.baidu.tieba.keepLive.nativekeepalive.strategy;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.tieba.keepLive.nativekeepalive.DaemonConfigurations;
import com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy;
import com.baidu.tieba.keepLive.nativekeepalive.NativeDaemonAPI20;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class DaemonStrategyXiaomi implements IDaemonStrategy {
    private final String BINARY_DEST_DIR_NAME = "bin";
    private final String BINARY_FILE_NAME = "daemon";
    private DaemonConfigurations mConfigs;
    private IBinder mRemote;
    private Parcel mServiceData;

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public boolean onInitialization(Context context) {
        return installBinary(context);
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onPersistentCreate(final Context context, final DaemonConfigurations daemonConfigurations) {
        initAmsBinder();
        initServiceParcel(context, daemonConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
        Thread thread = new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.strategy.DaemonStrategyXiaomi.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                new NativeDaemonAPI20(context).doDaemon(context.getPackageName(), daemonConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME, new File(context.getDir("bin", 0), "daemon").getAbsolutePath());
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
    public void onDaemonAssistantCreate(Context context, DaemonConfigurations daemonConfigurations) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), daemonConfigurations.PERSISTENT_CONFIG.SERVICE_NAME));
        context.startService(intent);
        if (daemonConfigurations != null && daemonConfigurations.LISTENER != null) {
            daemonConfigurations.LISTENER.onWatchDaemonDaed();
        }
        Process.killProcess(Process.myPid());
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy
    public void onDaemonDead() {
        if (startServiceByAmsBinder()) {
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

    private boolean installBinary(Context context) {
        return install(context, "bin", null, "daemon");
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
