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
/* loaded from: classes6.dex */
public class jd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final ReentrantLock c;
    public static volatile jd4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ld4> a;
    public md4 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947879439, "Lcom/baidu/tieba/jd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947879439, "Lcom/baidu/tieba/jd4;");
                return;
            }
        }
        c = new ReentrantLock();
    }

    public jd4() {
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

    public static jd4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (jd4.class) {
                    if (d == null) {
                        d = new jd4();
                    }
                }
            }
            return d;
        }
        return (jd4) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = null;
            this.a.clear();
        }
    }

    public final void c(ld4 ld4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ld4Var) == null) {
            c.lock();
            try {
                if (this.b != null) {
                    this.b.a(ld4Var);
                } else {
                    this.a.add(ld4Var);
                }
            } finally {
                c.unlock();
            }
        }
    }

    public void f(md4 md4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, md4Var) == null) {
            this.b = md4Var;
            e();
        }
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            d82.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
            ld4 ld4Var = new ld4(str);
            ld4Var.hasUpdate = z;
            c(ld4Var);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.a.isEmpty() && this.b != null) {
            c.lock();
            try {
                for (ld4 ld4Var : this.a) {
                    this.b.a(ld4Var);
                }
                this.a.clear();
            } finally {
                c.unlock();
            }
        }
    }
}
