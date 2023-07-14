package com.baidu.turbonet.net.impl;

import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.a1b;
import com.baidu.tieba.b1b;
import com.baidu.tieba.z1b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.net.NetworkChangeNotifier;
@JNINamespace("cronet")
@VisibleForTesting
/* loaded from: classes8.dex */
public class CronetLibraryLoader {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static final HandlerThread b;
    public static volatile boolean c;
    public static volatile boolean d;
    public static final ConditionVariable e;
    public static List<Runnable> f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface b {
        void a();

        String b();

        long c();
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                CronetLibraryLoader.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(29753957, "Lcom/baidu/turbonet/net/impl/CronetLibraryLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(29753957, "Lcom/baidu/turbonet/net/impl/CronetLibraryLoader;");
                return;
            }
        }
        a = new Object();
        b = new HandlerThread("CronetInit");
        c = false;
        e = new ConditionVariable();
        f = new ArrayList();
    }

    public CronetLibraryLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d) {
                return b1b.d().c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (b.getLooper() == Looper.myLooper()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    public static void ensureInitializedFromNative() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            synchronized (a) {
                c = true;
                e.open();
            }
            a(ContextUtils.getApplicationContext(), null);
        }
    }

    @CalledByNative
    public static String getDefaultUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return z1b.b(ContextUtils.getApplicationContext());
        }
        return (String) invokeV.objValue;
    }

    public static void a(Context context, a1b a1bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, a1bVar) == null) {
            synchronized (a) {
                if (!d) {
                    ContextUtils.initApplicationContext(context);
                    if (!b.isAlive()) {
                        b.start();
                    }
                    e(new a());
                }
                if (!c) {
                    if (a1bVar.v() != null) {
                        a1bVar.v().a("turbonet");
                    } else {
                        System.loadLibrary("turbonet");
                    }
                    Log.i("CronetLibraryLoader", "TurboNet version: %s, arch: %s", b1b.d().b(), System.getProperty("os.arch"));
                    c = true;
                    e.open();
                }
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65539, null) != null) || d) {
            return;
        }
        NetworkChangeNotifier.init();
        NetworkChangeNotifier.registerToReceiveNotificationsAlways();
        e.block();
        b1b.d().a();
        d = true;
        synchronized (f) {
            for (Runnable runnable : f) {
                runnable.run();
            }
            f.clear();
        }
    }

    public static void e(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, runnable) == null) {
            if (d()) {
                runnable.run();
            } else {
                new Handler(b.getLooper()).post(runnable);
            }
        }
    }

    @CalledByNative
    public static void setNetworkThreadPriorityOnNetworkThread(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i) == null) {
            Process.setThreadPriority(i);
        }
    }
}
