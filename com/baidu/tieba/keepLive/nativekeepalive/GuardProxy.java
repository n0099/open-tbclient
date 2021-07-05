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
/* loaded from: classes5.dex */
public class GuardProxy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INDICATOR_DAEMON_ASSISTANT_FILENAME = "indicator_d";
    public static final String INDICATOR_DIR_NAME = "indicators";
    public static final String INDICATOR_PERSISTENT_FILENAME = "indicator_p";
    public static final String OBSERVER_DAEMON_ASSISTANT_FILENAME = "observer_d";
    public static final String OBSERVER_PERSISTENT_FILENAME = "observer_p";
    public transient /* synthetic */ FieldHolder $fh;
    public GuardConfigurations mConfigs;

    /* loaded from: classes5.dex */
    public class a implements IGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AlarmManager f18049a;

        /* renamed from: b  reason: collision with root package name */
        public PendingIntent f18050b;

        /* renamed from: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0211a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18051e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GuardConfigurations f18052f;

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
                this.f18051e = context;
                this.f18052f = guardConfigurations;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    new NativeGuardLow(this.f18051e).doDaemon(this.f18051e.getPackageName(), this.f18052f.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME, new File(this.f18051e.getDir("bin", 0), "daemon").getAbsolutePath());
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
                if (this.f18049a == null) {
                    this.f18049a = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                }
                if (this.f18050b == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(context.getPackageName(), str));
                    intent.setFlags(16);
                    this.f18050b = PendingIntent.getService(context, 0, intent, 0);
                }
                this.f18049a.cancel(this.f18050b);
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
                this.f18049a.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.f18050b);
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

    /* loaded from: classes5.dex */
    public class b implements IGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AlarmManager f18053a;

        /* renamed from: b  reason: collision with root package name */
        public PendingIntent f18054b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GuardProxy f18055c;

        /* loaded from: classes5.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18056e;

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
                this.f18056e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    File dir = this.f18056e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                    new NativeGuardHigh(this.f18056e).doDaemon(new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
                }
            }
        }

        /* renamed from: com.baidu.tieba.keepLive.nativekeepalive.GuardProxy$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0212b extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18057e;

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
                this.f18057e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    File dir = this.f18057e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                    new NativeGuardHigh(this.f18057e).doDaemon(new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
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
            this.f18055c = guardProxy;
        }

        public final void a(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
                if (this.f18053a == null) {
                    this.f18053a = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                }
                if (this.f18054b == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(context.getPackageName(), str));
                    intent.setFlags(16);
                    this.f18054b = PendingIntent.getService(context, 0, intent, 0);
                }
                this.f18053a.cancel(this.f18054b);
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
                this.f18055c.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onDaemonAssistantStart(context);
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
                    this.f18053a.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.f18054b);
                    if (this.f18055c.mConfigs != null && this.f18055c.mConfigs.LISTENER != null) {
                        this.f18055c.mConfigs.LISTENER.onWatchDaemonDaed();
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? this.f18055c.initIndicators(context) : invokeL.booleanValue;
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
                this.f18055c.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onPersistentStart(context);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements IGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IBinder f18058a;

        /* renamed from: b  reason: collision with root package name */
        public Parcel f18059b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GuardProxy f18060c;

        /* loaded from: classes5.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18061e;

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
                this.f18061e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    File dir = this.f18061e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                    new NativeGuardHigh(this.f18061e).doDaemon(new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath());
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18062e;

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
                this.f18062e = context;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    File dir = this.f18062e.getDir(GuardProxy.INDICATOR_DIR_NAME, 0);
                    new NativeGuardHigh(this.f18062e).doDaemon(new File(dir, GuardProxy.INDICATOR_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.INDICATOR_PERSISTENT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_DAEMON_ASSISTANT_FILENAME).getAbsolutePath(), new File(dir, GuardProxy.OBSERVER_PERSISTENT_FILENAME).getAbsolutePath());
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
            this.f18060c = guardProxy;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                    Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                    Field declaredField = invoke.getClass().getDeclaredField("mRemote");
                    declaredField.setAccessible(true);
                    this.f18058a = (IBinder) declaredField.get(invoke);
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
                this.f18059b = obtain;
                obtain.writeInterfaceToken("android.app.IActivityManager");
                this.f18059b.writeStrongBinder(null);
                intent.writeToParcel(this.f18059b, 0);
                this.f18059b.writeString(null);
                this.f18059b.writeInt(0);
            }
        }

        public final boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                try {
                    if (this.f18058a != null && this.f18059b != null) {
                        this.f18058a.transact(34, this.f18059b, null, 0);
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
                this.f18060c.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onDaemonAssistantStart(context);
            }
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuard
        public void onDaemonDead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (TbadkCoreApplication.getKeepLiveSwitch(TbadkCoreApplication.getInst())) {
                    if (c()) {
                        if (this.f18060c.mConfigs != null && this.f18060c.mConfigs.LISTENER != null) {
                            this.f18060c.mConfigs.LISTENER.onWatchDaemonDaed();
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? this.f18060c.initIndicators(context) : invokeL.booleanValue;
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
                this.f18060c.mConfigs = guardConfigurations;
                guardConfigurations.LISTENER.onPersistentStart(context);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements IGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IBinder f18063a;

        /* renamed from: b  reason: collision with root package name */
        public Parcel f18064b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GuardProxy f18065c;

        /* loaded from: classes5.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f18066e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GuardConfigurations f18067f;

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
                this.f18066e = context;
                this.f18067f = guardConfigurations;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    new NativeGuardLow(this.f18066e).doDaemon(this.f18066e.getPackageName(), this.f18067f.DAEMON_ASSISTANT_CONFIG.SERVICE_NAME, new File(this.f18066e.getDir("bin", 0), "daemon").getAbsolutePath());
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
            this.f18065c = guardProxy;
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
                    this.f18063a = (IBinder) declaredField.get(invoke);
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
                this.f18064b = obtain;
                obtain.writeInterfaceToken("android.app.IActivityManager");
                this.f18064b.writeStrongBinder(null);
                intent.writeToParcel(this.f18064b, 0);
                this.f18064b.writeString(null);
                this.f18064b.writeInt(0);
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
                    if (this.f18063a != null && this.f18064b != null) {
                        this.f18063a.transact(34, this.f18064b, null, 0);
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
                if (this.f18065c.mConfigs != null && this.f18065c.mConfigs.LISTENER != null) {
                    this.f18065c.mConfigs.LISTENER.onWatchDaemonDaed();
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
                this.f18065c.mConfigs = guardConfigurations;
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
        if (interceptable == null || interceptable.invokeLL(65540, this, file, str) == null) {
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
