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
        public AlarmManager f18190a;

        /* renamed from: b  reason: collision with root package name */
        public PendingIntent f18191b;

        /* renamed from: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0205a extends Thread {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18192e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GuardConfigurations f18193f;

            public C0205a(a aVar, Context context, GuardConfigurations guardConfigurations) {
                this.f18192e = context;
                this.f18193f = guardConfigurations;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                new NativeGuardLow(this.f18192e).doDaemon(this.f18192e.getPackageName(), this.f18193f.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME, new File(this.f18192e.getDir("bin", 0), "daemon").getAbsolutePath());
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
            if (this.f18190a == null) {
                this.f18190a = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            }
            if (this.f18191b == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), str));
                intent.setFlags(16);
                this.f18191b = PendingIntent.getService(context, 0, intent, 0);
            }
            this.f18190a.cancel(this.f18191b);
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
                this.f18190a.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.f18191b);
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
                C0205a c0205a = new C0205a(this, context, guardConfigurations);
                c0205a.setPriority(10);
                c0205a.start();
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
        public AlarmManager f18194a;

        /* renamed from: b  reason: collision with root package name */
        public PendingIntent f18195b;

        /* loaded from: classes4.dex */
        public class a extends Thread {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18197e;

            public a(b bVar, Context context) {
                this.f18197e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = this.f18197e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                new NativeGuardHigh(this.f18197e).doDaemon(new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
            }
        }

        /* renamed from: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0206b extends Thread {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18198e;

            public C0206b(b bVar, Context context) {
                this.f18198e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = this.f18198e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                new NativeGuardHigh(this.f18198e).doDaemon(new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
            }
        }

        public b() {
        }

        public final void a(Context context, String str) {
            if (this.f18194a == null) {
                this.f18194a = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            }
            if (this.f18195b == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), str));
                intent.setFlags(16);
                this.f18195b = PendingIntent.getService(context, 0, intent, 0);
            }
            this.f18194a.cancel(this.f18195b);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME));
            context.startService(intent);
            a(context, guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
            C0206b c0206b = new C0206b(this, context);
            c0206b.setPriority(10);
            c0206b.start();
            if (guardConfigurations == null || guardConfigurations.LISTENER == null) {
                return;
            }
            GuardProxy.this.mConfigs = guardConfigurations;
            guardConfigurations.LISTENER.onDaemonAssistantStart(context);
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
                this.f18194a.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.f18195b);
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
        public IBinder f18199a;

        /* renamed from: b  reason: collision with root package name */
        public Parcel f18200b;

        /* loaded from: classes4.dex */
        public class a extends Thread {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18202e;

            public a(c cVar, Context context) {
                this.f18202e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = this.f18202e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                new NativeGuardHigh(this.f18202e).doDaemon(new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
            }
        }

        /* loaded from: classes4.dex */
        public class b extends Thread {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18203e;

            public b(c cVar, Context context) {
                this.f18203e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File dir = this.f18203e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                new NativeGuardHigh(this.f18203e).doDaemon(new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
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
                this.f18199a = (IBinder) declaredField.get(invoke);
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
            this.f18200b = obtain;
            obtain.writeInterfaceToken("android.app.IActivityManager");
            this.f18200b.writeStrongBinder(null);
            intent.writeToParcel(this.f18200b, 0);
            this.f18200b.writeString(null);
            this.f18200b.writeInt(0);
        }

        public final boolean c() {
            try {
                if (this.f18199a != null && this.f18200b != null) {
                    this.f18199a.transact(34, this.f18200b, null, 0);
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
        public IBinder f18204a;

        /* renamed from: b  reason: collision with root package name */
        public Parcel f18205b;

        /* loaded from: classes4.dex */
        public class a extends Thread {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18207e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GuardConfigurations f18208f;

            public a(d dVar, Context context, GuardConfigurations guardConfigurations) {
                this.f18207e = context;
                this.f18208f = guardConfigurations;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                new NativeGuardLow(this.f18207e).doDaemon(this.f18207e.getPackageName(), this.f18208f.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME, new File(this.f18207e.getDir("bin", 0), "daemon").getAbsolutePath());
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
                this.f18204a = (IBinder) declaredField.get(invoke);
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
            this.f18205b = obtain;
            obtain.writeInterfaceToken("android.app.IActivityManager");
            this.f18205b.writeStrongBinder(null);
            intent.writeToParcel(this.f18205b, 0);
            this.f18205b.writeString(null);
            this.f18205b.writeInt(0);
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
                if (this.f18204a != null && this.f18205b != null) {
                    this.f18204a.transact(34, this.f18205b, null, 0);
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
