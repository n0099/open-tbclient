package com.bytedance.pangle.util;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f61524a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f61525b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f61526c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ExecutorService f61527d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1401945232, "Lcom/bytedance/pangle/util/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1401945232, "Lcom/bytedance/pangle/util/j;");
                return;
            }
        }
        f61524a = !j.class.desiredAssertionStatus();
        f61525b = new Object();
        f61526c = null;
    }

    public j() {
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

    public static ExecutorService a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f61527d == null) {
                synchronized (j.class) {
                    if (f61527d == null) {
                        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(availableProcessors, availableProcessors, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        f61527d = threadPoolExecutor;
                    }
                }
            }
            return f61527d;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static Handler b() {
        InterceptResult invokeV;
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (f61525b) {
                if (f61526c == null) {
                    f61526c = new Handler(Looper.getMainLooper());
                }
                handler = f61526c;
            }
            return handler;
        }
        return (Handler) invokeV.objValue;
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            if (b().getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                b().post(runnable);
            }
        }
    }
}
