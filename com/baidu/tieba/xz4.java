package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.wz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.PriorityQueue;
/* loaded from: classes8.dex */
public class xz4 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<wz4> b;
    public static final PriorityQueue<wz4> c;
    public static final Handler d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements wz4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wz4 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;

        /* renamed from: com.baidu.tieba.xz4$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0526a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0526a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    xz4.k(this.a.a);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    xz4.h(aVar.b, aVar.c + 1);
                }
            }
        }

        public a(wz4 wz4Var, List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz4Var, list, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wz4Var;
            this.b = list;
            this.c = i;
        }

        @Override // com.baidu.tieba.wz4.a
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    xz4.d.post(new RunnableC0526a(this));
                } else {
                    xz4.d.post(new b(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            boolean unused = xz4.a = false;
            WeakReference unused2 = xz4.b = null;
            xz4.k((wz4) xz4.c.poll());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948317655, "Lcom/baidu/tieba/xz4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948317655, "Lcom/baidu/tieba/xz4;");
                return;
            }
        }
        c = new PriorityQueue<>();
        d = new Handler(Looper.getMainLooper());
    }

    public static void i() {
        wz4 wz4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            a = false;
            WeakReference<wz4> weakReference = b;
            if (weakReference != null && (wz4Var = weakReference.get()) != null) {
                wz4Var.b();
            }
            b = null;
            c.clear();
            d.removeCallbacksAndMessages(null);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            d.postDelayed(new b(), 500L);
        }
    }

    public static void g(List<wz4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, list) == null) {
            h(list, 0);
        }
    }

    public static void h(List<wz4> list, int i) {
        wz4 wz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65544, null, list, i) != null) || list == null || list.size() <= i || (wz4Var = list.get(i)) == null) {
            return;
        }
        if (wz4Var.b != TbadkCoreApplication.getInst().getCurrentActivity()) {
            for (wz4 wz4Var2 : list) {
                wz4Var2.f();
            }
            return;
        }
        wz4Var.d(new a(wz4Var, list, i));
    }

    public static void k(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, wz4Var) != null) || wz4Var == null) {
            return;
        }
        if (wz4Var.b != TbadkCoreApplication.getInst().getCurrentActivity()) {
            wz4Var.f();
            if (!a) {
                j();
            }
        } else if (a) {
            c.offer(wz4Var);
        } else {
            a = true;
            wz4Var.e();
            b = new WeakReference<>(wz4Var);
        }
    }
}
