package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public class o90 {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile o90 f;
    public static int g;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public ka0 c;
    public ScheduledExecutorService d;
    public ConcurrentHashMap<Integer, p90> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947986947, "Lcom/baidu/tieba/o90;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947986947, "Lcom/baidu/tieba/o90;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o90 a;

        public a(o90 o90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o90Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public p90 a;
        public final /* synthetic */ o90 b;

        public b(o90 o90Var, p90 p90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o90Var, p90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o90Var;
            this.a = p90Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c.k(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public p90 a;
        public final /* synthetic */ o90 b;

        public c(o90 o90Var, p90 p90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o90Var, p90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o90Var;
            this.a = p90Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c.f(this.a);
            }
        }
    }

    public o90(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new ConcurrentHashMap<>();
        this.a = context;
        this.b = s90.g(context, "flow_handle", g);
        this.c = ka0.j(this.a);
        this.d = Executors.newSingleThreadScheduledExecutor();
    }

    public synchronized void e(p90 p90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, p90Var) == null) {
            synchronized (this) {
                if (!this.e.containsKey(Integer.valueOf(p90Var.a))) {
                    return;
                }
                if (xa0.a) {
                    ya0.a("BehaviorProcess", "flow endFlow " + p90Var.f());
                }
                this.e.remove(Integer.valueOf(p90Var.a));
                ya0.a("BehaviorProcess", "flow endFlow");
                this.d.execute(new c(this, p90Var));
            }
        }
    }

    public synchronized p90 b(int i) {
        InterceptResult invokeI;
        p90 d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            synchronized (this) {
                d = d(i);
            }
            return d;
        }
        return (p90) invokeI.objValue;
    }

    public synchronized p90 g(int i) {
        InterceptResult invokeI;
        p90 d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            synchronized (this) {
                d = d(i);
            }
            return d;
        }
        return (p90) invokeI.objValue;
    }

    public static o90 h(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f == null) {
                synchronized (o90.class) {
                    if (f == null) {
                        f = new o90(context.getApplicationContext());
                    }
                }
            }
            return f;
        }
        return (o90) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d.execute(new a(this));
        }
    }

    public ScheduledExecutorService f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    public final p90 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (!this.e.containsKey(Integer.valueOf(i))) {
                this.b++;
                if (xa0.a) {
                    ya0.a("BehaviorProcess", "FlowHandle:" + this.b);
                }
                p90 p90Var = new p90(this.a, i, this.b);
                this.e.put(Integer.valueOf(i), p90Var);
                this.d.execute(new b(this, p90Var));
                s90.j(this.a, "flow_handle", this.b);
                return p90Var;
            }
            return this.e.get(Integer.valueOf(i));
        }
        return (p90) invokeI.objValue;
    }
}
