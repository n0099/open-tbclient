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
/* loaded from: classes9.dex */
public final class z7c {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<z7c> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final s7c a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948314307, "Lcom/baidu/tieba/z7c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948314307, "Lcom/baidu/tieba/z7c;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static z7c a() {
        z7c z7cVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                z7c z7cVar2 = b.get();
                if (z7cVar2 != null) {
                    return z7cVar2;
                }
                z7cVar = new z7c();
            } while (!b.compareAndSet(null, z7cVar));
            return z7cVar;
        }
        return (z7c) invokeV.objValue;
    }

    public static s7c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (s7c) invokeV.objValue;
    }

    public z7c() {
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
        s7c b2 = x7c.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new a8c(Looper.getMainLooper());
        }
    }
}
