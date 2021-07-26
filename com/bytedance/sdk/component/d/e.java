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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f28812a;

    /* renamed from: b  reason: collision with root package name */
    public static c f28813b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f28814c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f28815d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f28816e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f28817f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ScheduledExecutorService f28818g;
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
        f28812a = Runtime.getRuntime().availableProcessors();
        f28814c = true;
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
            if (f28815d == null) {
                synchronized (e.class) {
                    if (f28815d == null) {
                        f28815d = new a.C0323a().a("io").a(4).b(10).a(10L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue(f28812a)).a(f()).a();
                        f28815d.allowCoreThreadTimeOut(true);
                    }
                }
            }
            return f28815d;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f28816e == null) {
                synchronized (e.class) {
                    if (f28816e == null) {
                        f28816e = new a.C0323a().a(TbConfig.TMP_LOG_DIR_NAME).b(5).a(2).a(10L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                        f28816e.allowCoreThreadTimeOut(true);
                    }
                }
            }
            return f28816e;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static void c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, gVar) == null) {
            if (f28817f == null) {
                c();
            }
            if (f28817f != null) {
                f28817f.execute(gVar);
            }
        }
    }

    public static ScheduledExecutorService d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f28818g == null) {
                synchronized (e.class) {
                    if (f28818g == null) {
                        f28818g = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                    }
                }
            }
            return f28818g;
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? f28814c : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f28813b : (c) invokeV.objValue;
    }

    public static void c(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, gVar, i2) == null) {
            if (f28817f == null) {
                c();
            }
            if (gVar == null || f28817f == null) {
                return;
            }
            gVar.a(i2);
            f28817f.execute(gVar);
        }
    }

    public static ExecutorService c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f28817f == null) {
                synchronized (e.class) {
                    if (f28817f == null) {
                        f28817f = new a.C0323a().a("aidl").b(9).a(1).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                        f28817f.allowCoreThreadTimeOut(true);
                    }
                }
            }
            return f28817f;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gVar) == null) {
            if (f28815d == null) {
                a();
            }
            if (f28815d != null) {
                f28815d.execute(gVar);
            }
        }
    }

    public static void b(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, gVar) == null) {
            if (f28816e == null) {
                b();
            }
            if (f28816e != null) {
                f28816e.execute(gVar);
            }
        }
    }

    public static void a(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, gVar, i2) == null) {
            if (f28815d == null) {
                a();
            }
            if (gVar == null || f28815d == null) {
                return;
            }
            gVar.a(i2);
            f28815d.execute(gVar);
        }
    }

    public static void b(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, gVar, i2) == null) {
            if (f28816e == null) {
                b();
            }
            if (gVar == null || f28816e == null) {
                return;
            }
            gVar.a(i2);
            f28816e.execute(gVar);
        }
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, null, z) == null) {
            f28814c = z;
        }
    }

    public static void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cVar) == null) {
            f28813b = cVar;
        }
    }
}
