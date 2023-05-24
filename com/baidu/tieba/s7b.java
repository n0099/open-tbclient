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
public final class s7b {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<s7b> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final l7b a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948105739, "Lcom/baidu/tieba/s7b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948105739, "Lcom/baidu/tieba/s7b;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static s7b a() {
        s7b s7bVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                s7b s7bVar2 = b.get();
                if (s7bVar2 != null) {
                    return s7bVar2;
                }
                s7bVar = new s7b();
            } while (!b.compareAndSet(null, s7bVar));
            return s7bVar;
        }
        return (s7b) invokeV.objValue;
    }

    public static l7b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (l7b) invokeV.objValue;
    }

    public s7b() {
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
        l7b b2 = q7b.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new t7b(Looper.getMainLooper());
        }
    }
}
