package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.o05;
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
/* loaded from: classes7.dex */
public class p05 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<o05> b;
    public static final PriorityQueue<o05> c;
    public static final Handler d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements o05.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o05 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;

        /* renamed from: com.baidu.tieba.p05$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0432a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0432a(a aVar) {
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
                    p05.k(this.a.a);
                }
            }
        }

        /* loaded from: classes7.dex */
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
                    p05.h(aVar.b, aVar.c + 1);
                }
            }
        }

        public a(o05 o05Var, List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o05Var, list, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o05Var;
            this.b = list;
            this.c = i;
        }

        @Override // com.baidu.tieba.o05.a
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    p05.d.post(new RunnableC0432a(this));
                } else {
                    p05.d.post(new b(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            boolean unused = p05.a = false;
            WeakReference unused2 = p05.b = null;
            p05.k((o05) p05.c.poll());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948008244, "Lcom/baidu/tieba/p05;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948008244, "Lcom/baidu/tieba/p05;");
                return;
            }
        }
        c = new PriorityQueue<>();
        d = new Handler(Looper.getMainLooper());
    }

    public static void i() {
        o05 o05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            a = false;
            WeakReference<o05> weakReference = b;
            if (weakReference != null && (o05Var = weakReference.get()) != null) {
                o05Var.b();
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

    public static void g(List<o05> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, list) == null) {
            h(list, 0);
        }
    }

    public static void h(List<o05> list, int i) {
        o05 o05Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65544, null, list, i) != null) || list == null || list.size() <= i || (o05Var = list.get(i)) == null) {
            return;
        }
        if (o05Var.b != TbadkCoreApplication.getInst().getCurrentActivity()) {
            for (o05 o05Var2 : list) {
                o05Var2.f();
            }
            return;
        }
        o05Var.d(new a(o05Var, list, i));
    }

    public static void k(o05 o05Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, o05Var) != null) || o05Var == null) {
            return;
        }
        if (o05Var.b != TbadkCoreApplication.getInst().getCurrentActivity()) {
            o05Var.f();
            if (!a) {
                j();
            }
        } else if (a) {
            c.offer(o05Var);
        } else {
            a = true;
            o05Var.e();
            b = new WeakReference<>(o05Var);
        }
    }
}
