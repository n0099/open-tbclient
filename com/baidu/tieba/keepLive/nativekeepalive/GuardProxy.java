package com.baidu.tieba.keepLive.nativekeepalive;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class GuardProxy {
    private static final String INDICATOR_DAEMON_ASSISTANT_FILENAME = "indicator_d";
    private static final String INDICATOR_DIR_NAME = "indicators";
    private static final String INDICATOR_PERSISTENT_FILENAME = "indicator_p";
    private static final String OBSERVER_DAEMON_ASSISTANT_FILENAME = "observer_d";
    private static final String OBSERVER_PERSISTENT_FILENAME = "observer_p";
    private GuardConfigurations mConfigs;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initIndicators(Context context) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements IGuard {
        private Parcel iGT;
        private IBinder mRemote;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public boolean onInitialization(Context context) {
            return GuardProxy.this.initIndicators(context);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onPersistentCreate(final Context context, GuardConfigurations guardConfigurations) {
            cmf();
            aH(context, guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
            cmg();
            new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy.c.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    File dir = context.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                    new NativeGuardHigh(context).doDaemon(new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
                }
            }.start();
            if (guardConfigurations != null && guardConfigurations.LISTENER != null) {
                GuardProxy.this.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onPersistentStart(context);
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(final Context context, GuardConfigurations guardConfigurations) {
            cmf();
            aH(context, guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
            cmg();
            new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy.c.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    File dir = context.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                    new NativeGuardHigh(context).doDaemon(new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
                }
            }.start();
            if (guardConfigurations != null && guardConfigurations.LISTENER != null) {
                GuardProxy.this.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onDaemonAssistantStart(context);
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
                if (cmg()) {
                    if (GuardProxy.this.mConfigs != null && GuardProxy.this.mConfigs.LISTENER != null) {
                        GuardProxy.this.mConfigs.LISTENER.onWatchDaemonDaed();
                    }
                    Process.killProcess(Process.myPid());
                    return;
                }
                return;
            }
            Process.killProcess(Process.myPid());
        }

        private void cmf() {
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
        private void aH(Context context, String str) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), str));
            this.iGT = Parcel.obtain();
            this.iGT.writeInterfaceToken("android.app.IActivityManager");
            this.iGT.writeStrongBinder(null);
            intent.writeToParcel(this.iGT, 0);
            this.iGT.writeString(null);
            this.iGT.writeInt(0);
        }

        private boolean cmg() {
            try {
                if (this.mRemote == null || this.iGT == null) {
                    return false;
                }
                this.mRemote.transact(34, this.iGT, null, 0);
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements IGuard {
        private AlarmManager iGN;
        private PendingIntent iGO;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public boolean onInitialization(Context context) {
            return GuardProxy.this.initIndicators(context);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onPersistentCreate(final Context context, GuardConfigurations guardConfigurations) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME));
            context.startService(intent);
            aG(context, guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
            Thread thread = new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy.b.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    File dir = context.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                    new NativeGuardHigh(context).doDaemon(new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
                }
            };
            thread.setPriority(10);
            thread.start();
            if (guardConfigurations != null && guardConfigurations.LISTENER != null) {
                GuardProxy.this.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onPersistentStart(context);
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(final Context context, GuardConfigurations guardConfigurations) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME));
            context.startService(intent);
            aG(context, guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
            Thread thread = new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy.b.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    File dir = context.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                    new NativeGuardHigh(context).doDaemon(new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
                }
            };
            thread.setPriority(10);
            thread.start();
            if (guardConfigurations != null && guardConfigurations.LISTENER != null) {
                GuardProxy.this.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onDaemonAssistantStart(context);
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
                this.iGN.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.iGO);
                if (GuardProxy.this.mConfigs != null && GuardProxy.this.mConfigs.LISTENER != null) {
                    GuardProxy.this.mConfigs.LISTENER.onWatchDaemonDaed();
                }
                Process.killProcess(Process.myPid());
                return;
            }
            Process.killProcess(Process.myPid());
        }

        private void aG(Context context, String str) {
            if (this.iGN == null) {
                this.iGN = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            }
            if (this.iGO == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), str));
                intent.setFlags(16);
                this.iGO = PendingIntent.getService(context, 0, intent, 0);
            }
            this.iGN.cancel(this.iGO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements IGuard {
        private final String iGL = "bin";
        private final String iGM = "daemon";
        private AlarmManager iGN;
        private PendingIntent iGO;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public boolean onInitialization(Context context) {
            return eH(context);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onPersistentCreate(final Context context, final GuardConfigurations guardConfigurations) {
            if (TbadkCoreApplication.getKeepLiveSwitch(context)) {
                aG(context, guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
                Thread thread = new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy.a.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        new NativeGuardLow(context).doDaemon(context.getPackageName(), guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME, new File(context.getDir("bin", 0), "daemon").getAbsolutePath());
                    }
                };
                thread.setPriority(10);
                thread.start();
                if (guardConfigurations != null && guardConfigurations.LISTENER != null) {
                    guardConfigurations.LISTENER.onPersistentStart(context);
                }
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations) {
            if (TbadkCoreApplication.getKeepLiveSwitch(context)) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME));
                context.startService(intent);
                if (guardConfigurations != null && guardConfigurations.LISTENER != null) {
                    guardConfigurations.LISTENER.onWatchDaemonDaed();
                }
                Process.killProcess(Process.myPid());
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
                this.iGN.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.iGO);
                Process.killProcess(Process.myPid());
            }
        }

        private void aG(Context context, String str) {
            if (this.iGN == null) {
                this.iGN = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            }
            if (this.iGO == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), str));
                intent.setFlags(16);
                this.iGO = PendingIntent.getService(context, 0, intent, 0);
            }
            this.iGN.cancel(this.iGO);
        }

        private boolean eH(Context context) {
            String str;
            String str2 = Build.CPU_ABI;
            if (str2.startsWith("armeabi-v7a")) {
                str = "armeabi-v7a";
            } else if (str2.startsWith("x86")) {
                str = "x86";
            } else {
                str = "armeabi";
            }
            return f(context, "bin", str, "daemon");
        }

        private boolean f(Context context, String str, String str2, String str3) {
            File file = new File(context.getDir(str, 0), str3);
            if (file.exists()) {
                return true;
            }
            try {
                a(context, (TextUtils.isEmpty(str2) ? "" : str2 + File.separator) + str3, file, "700");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        private void a(Context context, String str, File file, String str2) throws IOException, InterruptedException {
            a(file, context.getAssets().open(str), str2);
        }

        private void a(File file, InputStream inputStream, String str) throws IOException, InterruptedException {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements IGuard {
        private final String iGL = "bin";
        private final String iGM = "daemon";
        private Parcel iGT;
        private IBinder mRemote;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d() {
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public boolean onInitialization(Context context) {
            return eH(context);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onPersistentCreate(final Context context, final GuardConfigurations guardConfigurations) {
            cmf();
            aH(context, guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
            Thread thread = new Thread() { // from class: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy.d.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    new NativeGuardLow(context).doDaemon(context.getPackageName(), guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME, new File(context.getDir("bin", 0), "daemon").getAbsolutePath());
                }
            };
            thread.setPriority(10);
            thread.start();
            if (guardConfigurations != null && guardConfigurations.LISTENER != null) {
                GuardProxy.this.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onPersistentStart(context);
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME));
            context.startService(intent);
            if (guardConfigurations != null && guardConfigurations.LISTENER != null) {
                guardConfigurations.LISTENER.onWatchDaemonDaed();
            }
            Process.killProcess(Process.myPid());
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            if (cmg()) {
                if (GuardProxy.this.mConfigs != null && GuardProxy.this.mConfigs.LISTENER != null) {
                    GuardProxy.this.mConfigs.LISTENER.onWatchDaemonDaed();
                }
                Process.killProcess(Process.myPid());
            }
        }

        private void cmf() {
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
        private void aH(Context context, String str) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), str));
            this.iGT = Parcel.obtain();
            this.iGT.writeInterfaceToken("android.app.IActivityManager");
            this.iGT.writeStrongBinder(null);
            intent.writeToParcel(this.iGT, 0);
            this.iGT.writeString(null);
            this.iGT.writeInt(0);
        }

        private boolean cmg() {
            try {
                if (this.mRemote == null || this.iGT == null) {
                    return false;
                }
                this.mRemote.transact(34, this.iGT, null, 0);
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }

        private boolean eH(Context context) {
            return f(context, "bin", null, "daemon");
        }

        private boolean f(Context context, String str, String str2, String str3) {
            File file = new File(context.getDir(str, 0), str3);
            if (file.exists()) {
                return true;
            }
            try {
                a(context, (TextUtils.isEmpty(str2) ? "" : str2 + File.separator) + str3, file, "700");
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        private void a(Context context, String str, File file, String str2) throws IOException, InterruptedException {
            a(file, context.getAssets().open(str), str2);
        }

        private void a(File file, InputStream inputStream, String str) throws IOException, InterruptedException {
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
}
