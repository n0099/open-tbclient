package com.baidu.turbonet.net;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.ContextUtils;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.net.TurbonetEngine;
import java.util.ArrayList;
import java.util.List;
@JNINamespace
/* loaded from: classes10.dex */
public class CronetLibraryLoader {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f56420a;

    /* renamed from: b  reason: collision with root package name */
    public static final HandlerThread f56421b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f56422c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f56423d;

    /* renamed from: e  reason: collision with root package name */
    public static List<Runnable> f56424e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f56425e;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56425e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                CronetLibraryLoader.b(this.f56425e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-78473282, "Lcom/baidu/turbonet/net/CronetLibraryLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-78473282, "Lcom/baidu/turbonet/net/CronetLibraryLoader;");
                return;
            }
        }
        f56420a = new Object();
        f56421b = new HandlerThread("TurboNetInit");
        f56422c = false;
        f56423d = false;
        f56424e = new ArrayList();
    }

    public CronetLibraryLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(Context context, TurbonetEngine.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, builder) == null) {
            synchronized (f56420a) {
                if (f56422c) {
                    return;
                }
                f56422c = true;
                ContextUtils.b(context.getApplicationContext());
                builder.m();
                ContextUtils.c();
                b.a.s0.a.a.h("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.b(context.getApplicationContext());
                if (!f56421b.isAlive()) {
                    f56421b.start();
                }
                e(new a(context));
            }
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || f56423d) {
            return;
        }
        NetworkChangeNotifier.init(context);
        NetworkChangeNotifier.n();
        nativeCronetInitOnInitThread();
        for (Runnable runnable : f56424e) {
            runnable.run();
        }
        f56424e.clear();
        f56423d = true;
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f56423d) {
                return nativeGetTurboNetHandler();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f56421b.getLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    public static void e(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, runnable) == null) {
            if (d()) {
                runnable.run();
            } else {
                new Handler(f56421b.getLooper()).post(runnable);
            }
        }
    }

    public static native void nativeCronetInitOnInitThread();

    public static native String nativeGetCronetVersion();

    public static native long nativeGetTurboNetHandler();

    public static native String nativeGetTurboNetVersion();
}
