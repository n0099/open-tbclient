package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public class r54 {
    public static /* synthetic */ Interceptable $ic;
    public static final ReentrantLock c;
    public static volatile r54 d;
    public transient /* synthetic */ FieldHolder $fh;
    public List<t54> a;
    public u54 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948072600, "Lcom/baidu/tieba/r54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948072600, "Lcom/baidu/tieba/r54;");
                return;
            }
        }
        c = new ReentrantLock();
    }

    public r54() {
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
        this.a = new ArrayList(3);
    }

    public static r54 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (r54.class) {
                    if (d == null) {
                        d = new r54();
                    }
                }
            }
            return d;
        }
        return (r54) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = null;
            this.a.clear();
        }
    }

    public final void c(t54 t54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t54Var) == null) {
            c.lock();
            try {
                if (this.b != null) {
                    this.b.a(t54Var);
                } else {
                    this.a.add(t54Var);
                }
            } finally {
                c.unlock();
            }
        }
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            l02.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
            t54 t54Var = new t54(str);
            t54Var.hasUpdate = z;
            c(t54Var);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.isEmpty() || this.b == null) {
            return;
        }
        c.lock();
        try {
            for (t54 t54Var : this.a) {
                this.b.a(t54Var);
            }
            this.a.clear();
        } finally {
            c.unlock();
        }
    }

    public void f(u54 u54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, u54Var) == null) {
            this.b = u54Var;
            e();
        }
    }
}
