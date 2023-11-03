package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class zz2 implements xz2, kr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService e;
    public transient /* synthetic */ FieldHolder $fh;
    public final c13 c;
    public final c13 d;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public a(zz2 zz2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (xz2.b) {
                    try {
                        xz2.b.wait(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Runnable, String> c;
        public boolean d;

        @Override // com.baidu.tieba.c13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.c13
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "HighPriorityTask" : (String) invokeV.objValue;
        }

        public b(zz2 zz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = new ConcurrentHashMap();
            this.d = false;
        }

        @Override // com.baidu.tieba.c13
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.d = false;
                f();
            }
        }

        @Override // com.baidu.tieba.c13
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
                if (this.d) {
                    this.c.put(runnable, str);
                } else {
                    aj3.l(runnable, str);
                }
            }
        }

        @Override // com.baidu.tieba.c13
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.d = false;
                long currentTimeMillis = System.currentTimeMillis();
                int size = this.c.size();
                f();
                if (kr2.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanPerformance", "high task dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; task num = " + size);
                }
            }
        }

        @Override // com.baidu.tieba.c13
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.d = true;
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.c.isEmpty()) {
                return;
            }
            for (Map.Entry<Runnable, String> entry : this.c.entrySet()) {
                if (entry != null) {
                    aj3.l(entry.getKey(), entry.getValue());
                }
            }
            this.c.clear();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements c13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Runnable, String> c;
        public boolean d;
        public final /* synthetic */ zz2 e;

        @Override // com.baidu.tieba.c13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.c13
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "LowPriorityTask" : (String) invokeV.objValue;
        }

        public c(zz2 zz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zz2Var;
            this.c = new ConcurrentHashMap();
            this.d = false;
        }

        @Override // com.baidu.tieba.c13
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.d = false;
                f();
            }
        }

        @Override // com.baidu.tieba.c13
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
                if (this.d) {
                    this.c.put(runnable, str);
                } else {
                    aj3.l(runnable, str);
                }
            }
        }

        @Override // com.baidu.tieba.c13
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.d = false;
                long currentTimeMillis = System.currentTimeMillis();
                int size = this.c.size();
                f();
                if (kr2.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanPerformance", "low task dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; task num = " + size);
                }
                if (h03.e()) {
                    this.e.c();
                }
            }
        }

        @Override // com.baidu.tieba.c13
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.d = true;
                if (h03.e()) {
                    this.e.b(h03.f());
                }
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.c.isEmpty()) {
                return;
            }
            for (Map.Entry<Runnable, String> entry : this.c.entrySet()) {
                if (entry != null) {
                    aj3.l(entry.getKey(), entry.getValue());
                }
            }
            this.c.clear();
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final zz2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-215294825, "Lcom/baidu/tieba/zz2$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-215294825, "Lcom/baidu/tieba/zz2$d;");
                    return;
                }
            }
            a = new zz2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948377175, "Lcom/baidu/tieba/zz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948377175, "Lcom/baidu/tieba/zz2;");
                return;
            }
        }
        e = Executors.newSingleThreadExecutor();
    }

    public zz2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new b(this);
        this.d = new c(this);
    }

    public static zz2 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return d.a;
        }
        return (zz2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (kr2.a) {
                Log.d("SwanPerformance", "low priority thread notify");
            }
            synchronized (xz2.b) {
                try {
                    xz2.b.notifyAll();
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a13.g().i(this.c, 3000);
            a13.g().i(this.d, 5000);
        }
    }

    public /* synthetic */ zz2(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.xz2
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (kr2.a) {
                Log.d("SwanPerformance", "low priority thread wait = " + i);
            }
            e.execute(new a(this, i));
        }
    }

    public boolean d(@NonNull Runnable runnable, @NonNull String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, runnable, str, z)) == null) {
            if (z) {
                this.c.c(runnable, str);
                return true;
            } else if (h03.e()) {
                e.execute(runnable);
                return true;
            } else {
                this.d.c(runnable, str);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
