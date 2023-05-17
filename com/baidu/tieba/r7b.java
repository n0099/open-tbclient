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
public final class r7b {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<r7b> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final k7b a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948075948, "Lcom/baidu/tieba/r7b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948075948, "Lcom/baidu/tieba/r7b;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static r7b a() {
        r7b r7bVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                r7b r7bVar2 = b.get();
                if (r7bVar2 != null) {
                    return r7bVar2;
                }
                r7bVar = new r7b();
            } while (!b.compareAndSet(null, r7bVar));
            return r7bVar;
        }
        return (r7b) invokeV.objValue;
    }

    public static k7b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (k7b) invokeV.objValue;
    }

    public r7b() {
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
        k7b b2 = p7b.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new s7b(Looper.getMainLooper());
        }
    }
}
