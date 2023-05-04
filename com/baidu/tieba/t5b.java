package com.baidu.tieba;

import android.os.Looper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class t5b {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<t5b> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final m5b a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948133608, "Lcom/baidu/tieba/t5b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948133608, "Lcom/baidu/tieba/t5b;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static t5b a() {
        t5b t5bVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                t5b t5bVar2 = b.get();
                if (t5bVar2 != null) {
                    return t5bVar2;
                }
                t5bVar = new t5b();
            } while (!b.compareAndSet(null, t5bVar));
            return t5bVar;
        }
        return (t5b) invokeV.objValue;
    }

    public static m5b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (m5b) invokeV.objValue;
    }

    public t5b() {
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
        m5b b2 = r5b.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new u5b(Looper.getMainLooper());
        }
    }
}
