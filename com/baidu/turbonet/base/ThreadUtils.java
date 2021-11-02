package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes10.dex */
public class ThreadUtils {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f56389a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f56390b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f56391c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1618725168, "Lcom/baidu/turbonet/base/ThreadUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1618725168, "Lcom/baidu/turbonet/base/ThreadUtils;");
                return;
            }
        }
        f56389a = new Object();
    }

    public ThreadUtils() {
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

    public static Handler a() {
        InterceptResult invokeV;
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (f56389a) {
                if (f56391c == null) {
                    if (!f56390b) {
                        f56391c = new Handler(Looper.getMainLooper());
                    } else {
                        throw new RuntimeException("Did not yet override the UI thread");
                    }
                }
                handler = f56391c;
            }
            return handler;
        }
        return (Handler) invokeV.objValue;
    }

    public static void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            a().post(runnable);
        }
    }

    public static void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) {
            if (d()) {
                runnable.run();
            } else {
                a().post(runnable);
            }
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? a().getLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    @CalledByNative
    public static boolean isThreadPriorityAudio(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? Process.getThreadPriority(i2) == -16 : invokeI.booleanValue;
    }

    @CalledByNative
    public static void setThreadPriorityAudio(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i2) == null) {
            Process.setThreadPriority(i2, -16);
        }
    }
}
