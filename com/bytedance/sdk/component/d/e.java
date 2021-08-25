package com.bytedance.sdk.component.d;

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
import com.bytedance.sdk.component.d.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f64874a;

    /* renamed from: b  reason: collision with root package name */
    public static c f64875b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f64876c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f64877d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f64878e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f64879f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ScheduledExecutorService f64880g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2131020474, "Lcom/bytedance/sdk/component/d/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2131020474, "Lcom/bytedance/sdk/component/d/e;");
                return;
            }
        }
        f64874a = Runtime.getRuntime().availableProcessors();
        f64876c = true;
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
            if (f64877d == null) {
                synchronized (e.class) {
                    if (f64877d == null) {
                        f64877d = new a.C1887a().a("io").a(4).b(10).a(10L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue(f64874a)).a(f()).a();
                        f64877d.allowCoreThreadTimeOut(true);
                    }
                }
            }
            return f64877d;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f64878e == null) {
                synchronized (e.class) {
                    if (f64878e == null) {
                        f64878e = new a.C1887a().a(TbConfig.TMP_LOG_DIR_NAME).b(5).a(2).a(10L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                        f64878e.allowCoreThreadTimeOut(true);
                    }
                }
            }
            return f64878e;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static void c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, gVar) == null) {
            if (f64879f == null) {
                c();
            }
            if (f64879f != null) {
                f64879f.execute(gVar);
            }
        }
    }

    public static ScheduledExecutorService d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f64880g == null) {
                synchronized (e.class) {
                    if (f64880g == null) {
                        f64880g = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                    }
                }
            }
            return f64880g;
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? f64876c : invokeV.booleanValue;
    }

    public static RejectedExecutionHandler f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.d.e.1
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f64875b : (c) invokeV.objValue;
    }

    public static void c(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, gVar, i2) == null) {
            if (f64879f == null) {
                c();
            }
            if (gVar == null || f64879f == null) {
                return;
            }
            gVar.a(i2);
            f64879f.execute(gVar);
        }
    }

    public static ExecutorService c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f64879f == null) {
                synchronized (e.class) {
                    if (f64879f == null) {
                        f64879f = new a.C1887a().a("aidl").b(9).a(1).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                        f64879f.allowCoreThreadTimeOut(true);
                    }
                }
            }
            return f64879f;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gVar) == null) {
            if (f64877d == null) {
                a();
            }
            if (f64877d != null) {
                f64877d.execute(gVar);
            }
        }
    }

    public static void b(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, gVar) == null) {
            if (f64878e == null) {
                b();
            }
            if (f64878e != null) {
                f64878e.execute(gVar);
            }
        }
    }

    public static void a(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, gVar, i2) == null) {
            if (f64877d == null) {
                a();
            }
            if (gVar == null || f64877d == null) {
                return;
            }
            gVar.a(i2);
            f64877d.execute(gVar);
        }
    }

    public static void b(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, gVar, i2) == null) {
            if (f64878e == null) {
                b();
            }
            if (gVar == null || f64878e == null) {
                return;
            }
            gVar.a(i2);
            f64878e.execute(gVar);
        }
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, null, z) == null) {
            f64876c = z;
        }
    }

    public static void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cVar) == null) {
            f64875b = cVar;
        }
    }
}
