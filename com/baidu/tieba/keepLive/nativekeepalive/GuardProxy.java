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
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.keepLive.nativekeepalive.GuardConfigurations;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes4.dex */
public class GuardProxy {
    public static final String INDICATOR_DAEMON_ASSISTANT_FILENAME = "indicator_d";
    public static final String INDICATOR_DIR_NAME = "indicators";
    public static final String INDICATOR_PERSISTENT_FILENAME = "indicator_p";
    public static final String OBSERVER_DAEMON_ASSISTANT_FILENAME = "observer_d";
    public static final String OBSERVER_PERSISTENT_FILENAME = "observer_p";
    public GuardConfigurations mConfigs;

    /* loaded from: classes4.dex */
    public class a implements IGuard {

        /* renamed from: a  reason: collision with root package name */
        public AlarmManager f17765a;

        /* renamed from: b  reason: collision with root package name */
        public PendingIntent f17766b;

        /* renamed from: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0188a extends Thread {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f17767e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GuardConfigurations f17768f;

            public C0188a(a aVar, Context context, GuardConfigurations guardConfigurations) {
                this.f17767e = context;
                this.f17768f = guardConfigurations;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                new NativeGuardLow(this.f17767e).doDaemon(this.f17767e.getPackageName(), this.f17768f.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME, new File(this.f17767e.getDir("bin", 0), "daemon").getAbsolutePath());
            }
        }

        public a(GuardProxy guardProxy) {
        }

        public final void a(Context context, String str, File file, String str2) throws IOException, InterruptedException {
            b(file, context.getAssets().open(str), str2);
        }

        public final void b(File file, InputStream inputStream, String str) throws IOException, InterruptedException {
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
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec("chmod " + str + " " + absolutePath).waitFor();
                    return;
                }
            }
        }

        public final void c(Context context, String str) {
            if (this.f17765a == null) {
                this.f17765a = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            }
            if (this.f17766b == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), str));
                intent.setFlags(16);
                this.f17766b = PendingIntent.getService(context, 0, intent, 0);
            }
            this.f17765a.cancel(this.f17766b);
        }

        public final boolean d(Context context, String str, String str2, String str3) {
            String str4;
            File file = new File(context.getDir(str, 0), str3);
            if (file.exists()) {
                return true;
            }
            try {
                StringBuilder sb = new StringBuilder();
                if (TextUtils.isEmpty(str2)) {
                    str4 = "";
                } else {
                    str4 = str2 + File.separator;
                }
                sb.append(str4);
                sb.append(str3);
                a(context, sb.toString(), file, "700");
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }

        public final boolean e(Context context) {
            String str = Build.CPU_ABI;
            String str2 = "armeabi-v7a";
            if (!str.startsWith("armeabi-v7a")) {
                str2 = str.startsWith("x86") ? "x86" : "armeabi";
            }
            return d(context, "bin", str2, "daemon");
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations) {
            GuardConfigurations.DaemonListener daemonListener;
            if (TbadkCoreApplication.getKeepLiveSwitch(context)) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME));
                context.startService(intent);
                if (guardConfigurations != null && (daemonListener = guardConfigurations.LISTENER) != null) {
                    daemonListener.onWatchDaemonDaed();
                }
                Process.killProcess(Process.myPid());
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
                this.f17765a.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.f17766b);
                Process.killProcess(Process.myPid());
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public boolean onInitialization(Context context) {
            return e(context);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onPersistentCreate(Context context, GuardConfigurations guardConfigurations) {
            GuardConfigurations.DaemonListener daemonListener;
            if (TbadkCoreApplication.getKeepLiveSwitch(context)) {
                c(context, guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
                C0188a c0188a = new C0188a(this, context, guardConfigurations);
                c0188a.setPriority(10);
                c0188a.start();
                if (guardConfigurations == null || (daemonListener = guardConfigurations.LISTENER) == null) {
                    return;
                }
                daemonListener.onPersistentStart(context);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements IGuard {

        /* renamed from: a  reason: collision with root package name */
        public AlarmManager f17769a;

        /* renamed from: b  reason: collision with root package name */
        public PendingIntent f17770b;

        /* loaded from: classes4.dex */
        public class a extends Thread {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f17772e;

            public a(b bVar, Context context) {
                this.f17772e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = this.f17772e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                new NativeGuardHigh(this.f17772e).doDaemon(new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
            }
        }

        /* renamed from: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0189b extends Thread {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f17773e;

            public C0189b(b bVar, Context context) {
                this.f17773e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = this.f17773e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                new NativeGuardHigh(this.f17773e).doDaemon(new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
            }
        }

        public b() {
        }

        public final void a(Context context, String str) {
            if (this.f17769a == null) {
                this.f17769a = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            }
            if (this.f17770b == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), str));
                intent.setFlags(16);
                this.f17770b = PendingIntent.getService(context, 0, intent, 0);
            }
            this.f17769a.cancel(this.f17770b);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME));
            context.startService(intent);
            a(context, guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
            C0189b c0189b = new C0189b(this, context);
            c0189b.setPriority(10);
            c0189b.start();
            if (guardConfigurations == null || guardConfigurations.LISTENER == null) {
                return;
            }
            GuardProxy.this.mConfigs = guardConfigurations;
            guardConfigurations.LISTENER.onDaemonAssistantStart(context);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
                this.f17769a.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.f17770b);
                if (GuardProxy.this.mConfigs != null && GuardProxy.this.mConfigs.LISTENER != null) {
                    GuardProxy.this.mConfigs.LISTENER.onWatchDaemonDaed();
                }
                Process.killProcess(Process.myPid());
                return;
            }
            Process.killProcess(Process.myPid());
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public boolean onInitialization(Context context) {
            return GuardProxy.this.initIndicators(context);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onPersistentCreate(Context context, GuardConfigurations guardConfigurations) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME));
            context.startService(intent);
            a(context, guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
            a aVar = new a(this, context);
            aVar.setPriority(10);
            aVar.start();
            if (guardConfigurations == null || guardConfigurations.LISTENER == null) {
                return;
            }
            GuardProxy.this.mConfigs = guardConfigurations;
            guardConfigurations.LISTENER.onPersistentStart(context);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements IGuard {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f17774a;

        /* renamed from: b  reason: collision with root package name */
        public Parcel f17775b;

        /* loaded from: classes4.dex */
        public class a extends Thread {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f17777e;

            public a(c cVar, Context context) {
                this.f17777e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = this.f17777e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                new NativeGuardHigh(this.f17777e).doDaemon(new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
            }
        }

        /* loaded from: classes4.dex */
        public class b extends Thread {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f17778e;

            public b(c cVar, Context context) {
                this.f17778e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = this.f17778e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                new NativeGuardHigh(this.f17778e).doDaemon(new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
            }
        }

        public c() {
        }

        public final void a() {
            try {
                Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                Field declaredField = invoke.getClass().getDeclaredField("mRemote");
                declaredField.setAccessible(true);
                this.f17774a = (IBinder) declaredField.get(invoke);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            } catch (NoSuchFieldException e5) {
                e5.printStackTrace();
            } catch (NoSuchMethodException e6) {
                e6.printStackTrace();
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
            }
        }

        @SuppressLint({"Recycle"})
        public final void b(Context context, String str) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), str));
            Parcel obtain = Parcel.obtain();
            this.f17775b = obtain;
            obtain.writeInterfaceToken("android.app.IActivityManager");
            this.f17775b.writeStrongBinder(null);
            intent.writeToParcel(this.f17775b, 0);
            this.f17775b.writeString(null);
            this.f17775b.writeInt(0);
        }

        public final boolean c() {
            try {
                if (this.f17774a != null && this.f17775b != null) {
                    this.f17774a.transact(34, this.f17775b, null, 0);
                    return true;
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations) {
            a();
            b(context, guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
            c();
            new b(this, context).start();
            if (guardConfigurations == null || guardConfigurations.LISTENER == null) {
                return;
            }
            GuardProxy.this.mConfigs = guardConfigurations;
            guardConfigurations.LISTENER.onDaemonAssistantStart(context);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
                if (c()) {
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

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public boolean onInitialization(Context context) {
            return GuardProxy.this.initIndicators(context);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onPersistentCreate(Context context, GuardConfigurations guardConfigurations) {
            a();
            b(context, guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
            c();
            new a(this, context).start();
            if (guardConfigurations == null || guardConfigurations.LISTENER == null) {
                return;
            }
            GuardProxy.this.mConfigs = guardConfigurations;
            guardConfigurations.LISTENER.onPersistentStart(context);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements IGuard {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f17779a;

        /* renamed from: b  reason: collision with root package name */
        public Parcel f17780b;

        /* loaded from: classes4.dex */
        public class a extends Thread {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f17782e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GuardConfigurations f17783f;

            public a(d dVar, Context context, GuardConfigurations guardConfigurations) {
                this.f17782e = context;
                this.f17783f = guardConfigurations;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                new NativeGuardLow(this.f17782e).doDaemon(this.f17782e.getPackageName(), this.f17783f.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME, new File(this.f17782e.getDir("bin", 0), "daemon").getAbsolutePath());
            }
        }

        public d() {
        }

        public final void a(Context context, String str, File file, String str2) throws IOException, InterruptedException {
            b(file, context.getAssets().open(str), str2);
        }

        public final void b(File file, InputStream inputStream, String str) throws IOException, InterruptedException {
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
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec("chmod " + str + " " + absolutePath).waitFor();
                    return;
                }
            }
        }

        public final void c() {
            try {
                Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                Field declaredField = invoke.getClass().getDeclaredField("mRemote");
                declaredField.setAccessible(true);
                this.f17779a = (IBinder) declaredField.get(invoke);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            } catch (NoSuchFieldException e5) {
                e5.printStackTrace();
            } catch (NoSuchMethodException e6) {
                e6.printStackTrace();
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
            }
        }

        @SuppressLint({"Recycle"})
        public final void d(Context context, String str) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), str));
            Parcel obtain = Parcel.obtain();
            this.f17780b = obtain;
            obtain.writeInterfaceToken("android.app.IActivityManager");
            this.f17780b.writeStrongBinder(null);
            intent.writeToParcel(this.f17780b, 0);
            this.f17780b.writeString(null);
            this.f17780b.writeInt(0);
        }

        public final boolean e(Context context, String str, String str2, String str3) {
            String str4;
            File file = new File(context.getDir(str, 0), str3);
            if (file.exists()) {
                return true;
            }
            try {
                StringBuilder sb = new StringBuilder();
                if (TextUtils.isEmpty(str2)) {
                    str4 = "";
                } else {
                    str4 = str2 + File.separator;
                }
                sb.append(str4);
                sb.append(str3);
                a(context, sb.toString(), file, "700");
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final boolean f(Context context) {
            return e(context, "bin", null, "daemon");
        }

        public final boolean g() {
            try {
                if (this.f17779a != null && this.f17780b != null) {
                    this.f17779a.transact(34, this.f17780b, null, 0);
                    return true;
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations) {
            GuardConfigurations.DaemonListener daemonListener;
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME));
            context.startService(intent);
            if (guardConfigurations != null && (daemonListener = guardConfigurations.LISTENER) != null) {
                daemonListener.onWatchDaemonDaed();
            }
            Process.killProcess(Process.myPid());
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            if (g()) {
                if (GuardProxy.this.mConfigs != null && GuardProxy.this.mConfigs.LISTENER != null) {
                    GuardProxy.this.mConfigs.LISTENER.onWatchDaemonDaed();
                }
                Process.killProcess(Process.myPid());
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public boolean onInitialization(Context context) {
            return f(context);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onPersistentCreate(Context context, GuardConfigurations guardConfigurations) {
            c();
            d(context, guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
            a aVar = new a(this, context, guardConfigurations);
            aVar.setPriority(10);
            aVar.start();
            if (guardConfigurations == null || guardConfigurations.LISTENER == null) {
                return;
            }
            GuardProxy.this.mConfigs = guardConfigurations;
            guardConfigurations.LISTENER.onPersistentStart(context);
        }
    }

    private void createNewFile(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.exists()) {
            return;
        }
        file2.createNewFile();
    }

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
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
