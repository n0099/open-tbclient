package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.PriorityQueue;
/* loaded from: classes7.dex */
public class o2a {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static MainTabScheduleStrategy b;
    public static boolean c;
    public static final PriorityQueue<u2a> d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
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
                o2a.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
                o2a.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u2a a;

        public c(u2a u2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u2aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947981739, "Lcom/baidu/tieba/o2a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947981739, "Lcom/baidu/tieba/o2a;");
                return;
            }
        }
        b = MainTabScheduleStrategy.FLUSHING;
        c = false;
        d = new PriorityQueue<>();
    }

    public static void b(MainTabScheduleStrategy mainTabScheduleStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mainTabScheduleStrategy) == null) {
            m2a.a("MainTabScheduler changeScheduleStrategy:" + mainTabScheduleStrategy);
            b = mainTabScheduleStrategy;
            if (mainTabScheduleStrategy != MainTabScheduleStrategy.UNSCHEDULE && !c) {
                g(true);
            }
        }
    }

    public static void c(u2a u2aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, u2aVar) == null) {
            m2a.a("MainTabScheduler execStep onStep:" + u2aVar.a);
            System.nanoTime();
            u2aVar.b();
            xg.a().postAtFrontOfQueue(new c(u2aVar));
        }
    }

    public static void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65543, null, z) != null) || c) {
            return;
        }
        c = true;
        if (z) {
            xg.a().postAtFrontOfQueue(new a());
        } else {
            xg.a().post(new b());
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            c = false;
            if (d.isEmpty() || b == MainTabScheduleStrategy.UNSCHEDULE) {
                return;
            }
            if (b == MainTabScheduleStrategy.FLUSHING) {
                e();
                return;
            }
            if (d.peek() != null && a >= d.peek().a) {
                u2a poll = d.poll();
                if (poll == null) {
                    return;
                }
                c(poll);
            }
            if (b == MainTabScheduleStrategy.SCHEDULE) {
                g(false);
            }
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            while (!d.isEmpty()) {
                u2a poll = d.poll();
                if (poll != null) {
                    m2a.a("MainTabScheduler flushAllSteps onStep:" + poll.a);
                    poll.b();
                    poll.c();
                }
            }
        }
    }

    public static void f(u2a u2aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, u2aVar) != null) || u2aVar == null) {
            return;
        }
        if (b == MainTabScheduleStrategy.FLUSHING) {
            if (!(u2aVar instanceof v2a)) {
                m2a.a("MainTabScheduler registerNextStep onStep:" + u2aVar.a);
                u2aVar.d();
                u2aVar.b();
            }
            u2aVar.c();
            return;
        }
        u2aVar.d();
        m2a.a("MainTabScheduler registerNextStep:" + u2aVar.a);
        d.add(u2aVar);
        if (b != MainTabScheduleStrategy.UNSCHEDULE && !c) {
            g(false);
        }
    }
}
