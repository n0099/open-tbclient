package com.bytedance.sdk.component.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.e.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f28876a;

    /* renamed from: b  reason: collision with root package name */
    public static c f28877b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f28878c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f28879d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f28880e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f28881f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ScheduledExecutorService f28882g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2130990683, "Lcom/bytedance/sdk/component/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2130990683, "Lcom/bytedance/sdk/component/e/e;");
                return;
            }
        }
        f28876a = Runtime.getRuntime().availableProcessors();
        f28878c = true;
    }

    public e() {
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
            if (f28879d == null) {
                synchronized (e.class) {
                    if (f28879d == null) {
                        f28879d = new a.C0324a().a("io").a(0).b(Integer.MAX_VALUE).a(20L).a(TimeUnit.SECONDS).a(new SynchronousQueue()).a(f()).a();
                        f28879d.allowCoreThreadTimeOut(true);
                    }
                }
            }
            return f28879d;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f28880e == null) {
                synchronized (e.class) {
                    if (f28880e == null) {
                        f28880e = new a.C0324a().a(TbConfig.TMP_LOG_DIR_NAME).a(2).b(4).a(20L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                        f28880e.allowCoreThreadTimeOut(true);
                    }
                }
            }
            return f28880e;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static void c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, gVar) == null) {
            if (f28881f == null) {
                c();
            }
            if (f28881f != null) {
                f28881f.execute(gVar);
            }
        }
    }

    public static ScheduledExecutorService d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f28882g == null) {
                synchronized (e.class) {
                    if (f28882g == null) {
                        f28882g = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                    }
                }
            }
            return f28882g;
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? f28878c : invokeV.booleanValue;
    }

    public static RejectedExecutionHandler f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.e.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, runnable, threadPoolExecutor) == null) {
                }
            }
        } : (RejectedExecutionHandler) invokeV.objValue;
    }

    public static c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f28877b : (c) invokeV.objValue;
    }

    public static void c(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, gVar, i2) == null) {
            if (f28881f == null) {
                c();
            }
            if (f28881f != null) {
                f28881f.execute(gVar);
            }
        }
    }

    public static ExecutorService c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f28881f == null) {
                synchronized (e.class) {
                    if (f28881f == null) {
                        f28881f = new a.C0324a().a("aidl").a(0).b(4).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                        f28881f.allowCoreThreadTimeOut(true);
                    }
                }
            }
            return f28881f;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gVar) == null) {
            if (f28879d == null) {
                a();
            }
            if (f28879d != null) {
                f28879d.execute(gVar);
            }
        }
    }

    public static void b(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, gVar) == null) {
            if (f28880e == null) {
                b();
            }
            if (f28880e != null) {
                f28880e.execute(gVar);
            }
        }
    }

    public static void a(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, gVar, i2) == null) {
            if (f28879d == null) {
                a();
            }
            if (f28879d != null) {
                f28879d.execute(gVar);
            }
        }
    }

    public static void b(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, gVar, i2) == null) {
            if (f28880e == null) {
                b();
            }
            if (f28880e != null) {
                f28880e.execute(gVar);
            }
        }
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, null, z) == null) {
            f28878c = z;
        }
    }

    public static void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cVar) == null) {
            f28877b = cVar;
        }
    }
}
