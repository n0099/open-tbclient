package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.yv4;
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
/* loaded from: classes6.dex */
public class zv4 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<yv4> b;
    public static final PriorityQueue<yv4> c;
    public static final Handler d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements yv4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv4 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;

        /* renamed from: com.baidu.tieba.zv4$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0490a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0490a(a aVar) {
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
                    zv4.k(this.a.a);
                }
            }
        }

        /* loaded from: classes6.dex */
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
                    zv4.h(aVar.b, aVar.c + 1);
                }
            }
        }

        public a(yv4 yv4Var, List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv4Var, list, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yv4Var;
            this.b = list;
            this.c = i;
        }

        @Override // com.baidu.tieba.yv4.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    zv4.d.post(new RunnableC0490a(this));
                } else {
                    zv4.d.post(new b(this));
                }
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            boolean unused = zv4.a = false;
            WeakReference unused2 = zv4.b = null;
            zv4.k((yv4) zv4.c.poll());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948373393, "Lcom/baidu/tieba/zv4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948373393, "Lcom/baidu/tieba/zv4;");
                return;
            }
        }
        c = new PriorityQueue<>();
        d = new Handler(Looper.getMainLooper());
    }

    public static void i() {
        yv4 yv4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            a = false;
            WeakReference<yv4> weakReference = b;
            if (weakReference != null && (yv4Var = weakReference.get()) != null) {
                yv4Var.b();
            }
            b = null;
            c.clear();
            d.removeCallbacksAndMessages(null);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            d.post(new b());
        }
    }

    public static void g(List<yv4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, list) == null) {
            h(list, 0);
        }
    }

    public static void h(List<yv4> list, int i) {
        yv4 yv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65544, null, list, i) != null) || list == null || list.size() <= i || (yv4Var = list.get(i)) == null || yv4Var.b != TbadkCoreApplication.getInst().getCurrentActivity()) {
            return;
        }
        yv4Var.d(new a(yv4Var, list, i));
    }

    public static void k(yv4 yv4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, yv4Var) != null) || yv4Var == null) {
            return;
        }
        if (yv4Var.b != TbadkCoreApplication.getInst().getCurrentActivity()) {
            if (!a) {
                j();
            }
        } else if (a) {
            c.offer(yv4Var);
        } else {
            a = true;
            yv4Var.e();
            b = new WeakReference<>(yv4Var);
        }
    }
}
