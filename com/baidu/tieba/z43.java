package com.baidu.tieba;

import android.os.Looper;
import android.os.MessageQueue;
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
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public class z43 implements lw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean c;
    public boolean d;
    public List<Runnable> e;
    public d63 f;

    /* loaded from: classes9.dex */
    public class a implements d63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z43 c;

        @Override // com.baidu.tieba.d63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.d63
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
            }
        }

        @Override // com.baidu.tieba.d63
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "IdleHandler" : (String) invokeV.objValue;
        }

        public a(z43 z43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z43Var;
        }

        @Override // com.baidu.tieba.d63
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048579, this, z) != null) {
                return;
            }
            this.c.c = false;
            this.c.k();
            this.c.o();
        }

        @Override // com.baidu.tieba.d63
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048580, this, str) != null) {
                return;
            }
            this.c.c = true;
            this.c.n();
            this.c.p();
        }

        @Override // com.baidu.tieba.d63
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.c.c = false;
            this.c.k();
            this.c.d = false;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z43 a;

        public b(z43 z43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z43Var;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.c) {
                    this.a.l();
                } else {
                    this.a.k();
                }
                return this.a.c;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final z43 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-279911535, "Lcom/baidu/tieba/z43$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-279911535, "Lcom/baidu/tieba/z43$c;");
                    return;
                }
            }
            a = new z43(null);
        }
    }

    public z43() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = false;
        this.e = new CopyOnWriteArrayList();
        this.f = new a(this);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.d) {
            this.d = true;
            ou2.p0().b(3000);
            if (lw2.a) {
                Log.d("SwanPerformance", "YaLog block time = 3000");
            }
        }
    }

    public /* synthetic */ z43(a aVar) {
        this();
    }

    public boolean i(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            if (runnable == null) {
                return false;
            }
            if (this.c) {
                this.e.add(runnable);
                return true;
            }
            bp3.a0(runnable);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static z43 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return c.a;
        }
        return (z43) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b63.g().i(this.f, 5000);
            this.c = true;
            p();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Looper.getMainLooper();
            Looper.myQueue().addIdleHandler(new b(this));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.d) {
            this.d = false;
            ou2.p0().c();
            if (lw2.a) {
                Log.d("SwanPerformance", "YaLog notify");
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.e.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Runnable runnable : this.e) {
            gb3.M().post(runnable);
        }
        if (lw2.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "idle handle all, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.e.size());
        }
        this.e.clear();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.e.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Runnable remove = this.e.remove(0);
        if (remove != null) {
            gb3.M().post(remove);
        }
        if (lw2.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "idle handle one, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.e.size());
        }
    }
}
