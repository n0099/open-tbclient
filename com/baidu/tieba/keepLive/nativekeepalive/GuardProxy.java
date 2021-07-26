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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.keepLive.nativekeepalive.GuardConfigurations;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes4.dex */
public class GuardProxy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INDICATOR_DAEMON_ASSISTANT_FILENAME = "indicator_d";
    public static final String INDICATOR_DIR_NAME = "indicators";
    public static final String INDICATOR_PERSISTENT_FILENAME = "indicator_p";
    public static final String OBSERVER_DAEMON_ASSISTANT_FILENAME = "observer_d";
    public static final String OBSERVER_PERSISTENT_FILENAME = "observer_p";
    public transient /* synthetic */ FieldHolder $fh;
    public GuardConfigurations mConfigs;

    /* loaded from: classes4.dex */
    public class a implements IGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AlarmManager f18145a;

        /* renamed from: b  reason: collision with root package name */
        public PendingIntent f18146b;

        /* renamed from: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0211a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18147e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GuardConfigurations f18148f;

            public C0211a(a aVar, Context context, GuardConfigurations guardConfigurations) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, guardConfigurations};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18147e = context;
                this.f18148f = guardConfigurations;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    new NativeGuardLow(this.f18147e).doDaemon(this.f18147e.getPackageName(), this.f18148f.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME, new File(this.f18147e.getDir("bin", 0), "daemon").getAbsolutePath());
                }
            }
        }

        public a(GuardProxy guardProxy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guardProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void a(Context context, String str, File file, String str2) throws IOException, InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, file, str2) == null) {
                b(file, context.getAssets().open(str), str2);
            }
        }

        public final void b(File file, InputStream inputStream, String str) throws IOException, InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file, inputStream, str) != null) {
                return;
            }
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
                if (this.f18145a == null) {
                    this.f18145a = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                }
                if (this.f18146b == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(context.getPackageName(), str));
                    intent.setFlags(16);
                    this.f18146b = PendingIntent.getService(context, 0, intent, 0);
                }
                this.f18145a.cancel(this.f18146b);
            }
        }

        public final boolean d(Context context, String str, String str2, String str3) {
            InterceptResult invokeLLLL;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, str, str2, str3)) == null) {
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
            return invokeLLLL.booleanValue;
        }

        public final boolean e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
                String str = Build.CPU_ABI;
                String str2 = "armeabi-v7a";
                if (!str.startsWith("armeabi-v7a")) {
                    str2 = str.startsWith("x86") ? "x86" : "armeabi";
                }
                return d(context, "bin", str2, "daemon");
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations) {
            GuardConfigurations.DaemonListener daemonListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048581, this, context, guardConfigurations) == null) && TbadkCoreApplication.getKeepLiveSwitch(context)) {
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
                this.f18145a.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.f18146b);
                Process.killProcess(Process.myPid());
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public boolean onInitialization(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? e(context) : invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onPersistentCreate(Context context, GuardConfigurations guardConfigurations) {
            GuardConfigurations.DaemonListener daemonListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, guardConfigurations) == null) && TbadkCoreApplication.getKeepLiveSwitch(context)) {
                c(context, guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
                C0211a c0211a = new C0211a(this, context, guardConfigurations);
                c0211a.setPriority(10);
                c0211a.start();
                if (guardConfigurations == null || (daemonListener = guardConfigurations.LISTENER) == null) {
                    return;
                }
                daemonListener.onPersistentStart(context);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements IGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AlarmManager f18149a;

        /* renamed from: b  reason: collision with root package name */
        public PendingIntent f18150b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GuardProxy f18151c;

        /* loaded from: classes4.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18152e;

            public a(b bVar, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18152e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    File dir = this.f18152e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                    new NativeGuardHigh(this.f18152e).doDaemon(new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
                }
            }
        }

        /* renamed from: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0212b extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18153e;

            public C0212b(b bVar, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18153e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    File dir = this.f18153e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                    new NativeGuardHigh(this.f18153e).doDaemon(new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
                }
            }
        }

        public b(GuardProxy guardProxy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guardProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18151c = guardProxy;
        }

        public final void a(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
                if (this.f18149a == null) {
                    this.f18149a = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                }
                if (this.f18150b == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(context.getPackageName(), str));
                    intent.setFlags(16);
                    this.f18150b = PendingIntent.getService(context, 0, intent, 0);
                }
                this.f18149a.cancel(this.f18150b);
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, guardConfigurations) == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME));
                context.startService(intent);
                a(context, guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
                C0212b c0212b = new C0212b(this, context);
                c0212b.setPriority(10);
                c0212b.start();
                if (guardConfigurations == null || guardConfigurations.LISTENER == null) {
                    return;
                }
                this.f18151c.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onDaemonAssistantStart(context);
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
                    this.f18149a.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.f18150b);
                    if (this.f18151c.mConfigs != null && this.f18151c.mConfigs.LISTENER != null) {
                        this.f18151c.mConfigs.LISTENER.onWatchDaemonDaed();
                    }
                    Process.killProcess(Process.myPid());
                    return;
                }
                Process.killProcess(Process.myPid());
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public boolean onInitialization(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? this.f18151c.initIndicators(context) : invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onPersistentCreate(Context context, GuardConfigurations guardConfigurations) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, context, guardConfigurations) == null) {
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
                this.f18151c.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onPersistentStart(context);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements IGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IBinder f18154a;

        /* renamed from: b  reason: collision with root package name */
        public Parcel f18155b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GuardProxy f18156c;

        /* loaded from: classes4.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18157e;

            public a(c cVar, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18157e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    File dir = this.f18157e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                    new NativeGuardHigh(this.f18157e).doDaemon(new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18158e;

            public b(c cVar, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18158e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    File dir = this.f18158e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                    new NativeGuardHigh(this.f18158e).doDaemon(new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
                }
            }
        }

        public c(GuardProxy guardProxy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guardProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18156c = guardProxy;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                    Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                    Field declaredField = invoke.getClass().getDeclaredField("mRemote");
                    declaredField.setAccessible(true);
                    this.f18154a = (IBinder) declaredField.get(invoke);
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
        }

        @SuppressLint({"Recycle"})
        public final void b(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), str));
                Parcel obtain = Parcel.obtain();
                this.f18155b = obtain;
                obtain.writeInterfaceToken("android.app.IActivityManager");
                this.f18155b.writeStrongBinder(null);
                intent.writeToParcel(this.f18155b, 0);
                this.f18155b.writeString(null);
                this.f18155b.writeInt(0);
            }
        }

        public final boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                try {
                    if (this.f18154a != null && this.f18155b != null) {
                        this.f18154a.transact(34, this.f18155b, null, 0);
                        return true;
                    }
                    return false;
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, context, guardConfigurations) == null) {
                a();
                b(context, guardConfigurations.PERSISTENT_CONFIG.SERVICE_NAME);
                c();
                new b(this, context).start();
                if (guardConfigurations == null || guardConfigurations.LISTENER == null) {
                    return;
                }
                this.f18156c.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onDaemonAssistantStart(context);
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
                    if (c()) {
                        if (this.f18156c.mConfigs != null && this.f18156c.mConfigs.LISTENER != null) {
                            this.f18156c.mConfigs.LISTENER.onWatchDaemonDaed();
                        }
                        Process.killProcess(Process.myPid());
                        return;
                    }
                    return;
                }
                Process.killProcess(Process.myPid());
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public boolean onInitialization(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? this.f18156c.initIndicators(context) : invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onPersistentCreate(Context context, GuardConfigurations guardConfigurations) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, context, guardConfigurations) == null) {
                a();
                b(context, guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
                c();
                new a(this, context).start();
                if (guardConfigurations == null || guardConfigurations.LISTENER == null) {
                    return;
                }
                this.f18156c.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onPersistentStart(context);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements IGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IBinder f18159a;

        /* renamed from: b  reason: collision with root package name */
        public Parcel f18160b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GuardProxy f18161c;

        /* loaded from: classes4.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18162e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GuardConfigurations f18163f;

            public a(d dVar, Context context, GuardConfigurations guardConfigurations) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, context, guardConfigurations};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18162e = context;
                this.f18163f = guardConfigurations;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    new NativeGuardLow(this.f18162e).doDaemon(this.f18162e.getPackageName(), this.f18163f.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME, new File(this.f18162e.getDir("bin", 0), "daemon").getAbsolutePath());
                }
            }
        }

        public d(GuardProxy guardProxy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guardProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18161c = guardProxy;
        }

        public final void a(Context context, String str, File file, String str2) throws IOException, InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, file, str2) == null) {
                b(file, context.getAssets().open(str), str2);
            }
        }

        public final void b(File file, InputStream inputStream, String str) throws IOException, InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file, inputStream, str) != null) {
                return;
            }
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                    Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                    Field declaredField = invoke.getClass().getDeclaredField("mRemote");
                    declaredField.setAccessible(true);
                    this.f18159a = (IBinder) declaredField.get(invoke);
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
        }

        @SuppressLint({"Recycle"})
        public final void d(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), str));
                Parcel obtain = Parcel.obtain();
                this.f18160b = obtain;
                obtain.writeInterfaceToken("android.app.IActivityManager");
                this.f18160b.writeStrongBinder(null);
                intent.writeToParcel(this.f18160b, 0);
                this.f18160b.writeString(null);
                this.f18160b.writeInt(0);
            }
        }

        public final boolean e(Context context, String str, String str2, String str3) {
            InterceptResult invokeLLLL;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, str, str2, str3)) == null) {
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
            return invokeLLLL.booleanValue;
        }

        public final boolean f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? e(context, "bin", null, "daemon") : invokeL.booleanValue;
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                try {
                    if (this.f18159a != null && this.f18160b != null) {
                        this.f18159a.transact(34, this.f18160b, null, 0);
                        return true;
                    }
                    return false;
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations) {
            GuardConfigurations.DaemonListener daemonListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, context, guardConfigurations) == null) {
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && g()) {
                if (this.f18161c.mConfigs != null && this.f18161c.mConfigs.LISTENER != null) {
                    this.f18161c.mConfigs.LISTENER.onWatchDaemonDaed();
                }
                Process.killProcess(Process.myPid());
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public boolean onInitialization(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? f(context) : invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onPersistentCreate(Context context, GuardConfigurations guardConfigurations) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, context, guardConfigurations) == null) {
                c();
                d(context, guardConfigurations.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME);
                a aVar = new a(this, context, guardConfigurations);
                aVar.setPriority(10);
                aVar.start();
                if (guardConfigurations == null || guardConfigurations.LISTENER == null) {
                    return;
                }
                this.f18161c.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onPersistentStart(context);
            }
        }
    }

    public GuardProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void createNewFile(File file, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, file, str) == null) {
            File file2 = new File(file, str);
            if (file2.exists()) {
                return;
            }
            file2.createNewFile();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initIndicators(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
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
        return invokeL.booleanValue;
    }
}
