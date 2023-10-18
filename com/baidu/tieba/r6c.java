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
/* loaded from: classes7.dex */
public final class r6c {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<r6c> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final k6c a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948075018, "Lcom/baidu/tieba/r6c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948075018, "Lcom/baidu/tieba/r6c;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static r6c a() {
        r6c r6cVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                r6c r6cVar2 = b.get();
                if (r6cVar2 != null) {
                    return r6cVar2;
                }
                r6cVar = new r6c();
            } while (!b.compareAndSet(null, r6cVar));
            return r6cVar;
        }
        return (r6c) invokeV.objValue;
    }

    public static k6c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (k6c) invokeV.objValue;
    }

    public r6c() {
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
        k6c b2 = p6c.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new s6c(Looper.getMainLooper());
        }
    }
}
