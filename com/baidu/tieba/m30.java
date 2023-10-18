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
public class m30 {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile m30 f;
    public static int g;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public i40 c;
    public ScheduledExecutorService d;
    public ConcurrentHashMap<Integer, n30> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947921599, "Lcom/baidu/tieba/m30;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947921599, "Lcom/baidu/tieba/m30;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m30 a;

        public a(m30 m30Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m30Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m30Var;
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
        public n30 a;
        public final /* synthetic */ m30 b;

        public b(m30 m30Var, n30 n30Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m30Var, n30Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m30Var;
            this.a = n30Var;
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
        public n30 a;
        public final /* synthetic */ m30 b;

        public c(m30 m30Var, n30 n30Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m30Var, n30Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m30Var;
            this.a = n30Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c.f(this.a);
            }
        }
    }

    public m30(Context context) {
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
        this.b = q30.g(context, "flow_handle", g);
        this.c = i40.j(this.a);
        this.d = Executors.newSingleThreadScheduledExecutor();
    }

    public synchronized void e(n30 n30Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, n30Var) == null) {
            synchronized (this) {
                if (!this.e.containsKey(Integer.valueOf(n30Var.a))) {
                    return;
                }
                if (v40.a) {
                    w40.a("BehaviorProcess", "flow endFlow " + n30Var.f());
                }
                this.e.remove(Integer.valueOf(n30Var.a));
                w40.a("BehaviorProcess", "flow endFlow");
                this.d.execute(new c(this, n30Var));
            }
        }
    }

    public synchronized n30 b(int i) {
        InterceptResult invokeI;
        n30 d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            synchronized (this) {
                d = d(i);
            }
            return d;
        }
        return (n30) invokeI.objValue;
    }

    public synchronized n30 g(int i) {
        InterceptResult invokeI;
        n30 d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            synchronized (this) {
                d = d(i);
            }
            return d;
        }
        return (n30) invokeI.objValue;
    }

    public static m30 h(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f == null) {
                synchronized (m30.class) {
                    if (f == null) {
                        f = new m30(context.getApplicationContext());
                    }
                }
            }
            return f;
        }
        return (m30) invokeL.objValue;
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

    public final n30 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (!this.e.containsKey(Integer.valueOf(i))) {
                this.b++;
                if (v40.a) {
                    w40.a("BehaviorProcess", "FlowHandle:" + this.b);
                }
                n30 n30Var = new n30(this.a, i, this.b);
                this.e.put(Integer.valueOf(i), n30Var);
                this.d.execute(new b(this, n30Var));
                q30.j(this.a, "flow_handle", this.b);
                return n30Var;
            }
            return this.e.get(Integer.valueOf(i));
        }
        return (n30) invokeI.objValue;
    }
}
