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
public class k64 {
    public static /* synthetic */ Interceptable $ic;
    public static final ReentrantLock c;
    public static volatile k64 d;
    public transient /* synthetic */ FieldHolder $fh;
    public List<m64> a;
    public n64 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947865024, "Lcom/baidu/tieba/k64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947865024, "Lcom/baidu/tieba/k64;");
                return;
            }
        }
        c = new ReentrantLock();
    }

    public k64() {
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

    public static k64 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (k64.class) {
                    if (d == null) {
                        d = new k64();
                    }
                }
            }
            return d;
        }
        return (k64) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = null;
            this.a.clear();
        }
    }

    public final void c(m64 m64Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m64Var) == null) {
            c.lock();
            try {
                if (this.b != null) {
                    this.b.a(m64Var);
                } else {
                    this.a.add(m64Var);
                }
            } finally {
                c.unlock();
            }
        }
    }

    public void f(n64 n64Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, n64Var) == null) {
            this.b = n64Var;
            e();
        }
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            e12.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
            m64 m64Var = new m64(str);
            m64Var.hasUpdate = z;
            c(m64Var);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.a.isEmpty() && this.b != null) {
            c.lock();
            try {
                for (m64 m64Var : this.a) {
                    this.b.a(m64Var);
                }
                this.a.clear();
            } finally {
                c.unlock();
            }
        }
    }
}
