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
/* loaded from: classes6.dex */
public class lfa {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static MainTabScheduleStrategy b;
    public static boolean c;
    public static final PriorityQueue<rfa> d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                lfa.d();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                lfa.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rfa a;

        public c(rfa rfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rfaVar;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947942338, "Lcom/baidu/tieba/lfa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947942338, "Lcom/baidu/tieba/lfa;");
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
            jfa.a("MainTabScheduler changeScheduleStrategy:" + mainTabScheduleStrategy);
            b = mainTabScheduleStrategy;
            if (mainTabScheduleStrategy != MainTabScheduleStrategy.UNSCHEDULE && !c) {
                g(true);
            }
        }
    }

    public static void c(rfa rfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, rfaVar) == null) {
            jfa.a("MainTabScheduler execStep onStep:" + rfaVar.a);
            System.nanoTime();
            rfaVar.b();
            zg.a().postAtFrontOfQueue(new c(rfaVar));
        }
    }

    public static void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65543, null, z) != null) || c) {
            return;
        }
        c = true;
        if (z) {
            zg.a().postAtFrontOfQueue(new a());
        } else {
            zg.a().post(new b());
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
                rfa poll = d.poll();
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
                rfa poll = d.poll();
                if (poll != null) {
                    jfa.a("MainTabScheduler flushAllSteps onStep:" + poll.a);
                    poll.b();
                    poll.c();
                }
            }
        }
    }

    public static void f(rfa rfaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, rfaVar) != null) || rfaVar == null) {
            return;
        }
        if (b == MainTabScheduleStrategy.FLUSHING) {
            if (!(rfaVar instanceof sfa)) {
                jfa.a("MainTabScheduler registerNextStep onStep:" + rfaVar.a);
                rfaVar.d();
                rfaVar.b();
            }
            rfaVar.c();
            return;
        }
        rfaVar.d();
        jfa.a("MainTabScheduler registerNextStep:" + rfaVar.a);
        d.add(rfaVar);
        if (b != MainTabScheduleStrategy.UNSCHEDULE && !c) {
            g(false);
        }
    }
}
