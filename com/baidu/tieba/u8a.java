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
public final class u8a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<u8a> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final n8a a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948166251, "Lcom/baidu/tieba/u8a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948166251, "Lcom/baidu/tieba/u8a;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static u8a a() {
        u8a u8aVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                u8a u8aVar2 = b.get();
                if (u8aVar2 != null) {
                    return u8aVar2;
                }
                u8aVar = new u8a();
            } while (!b.compareAndSet(null, u8aVar));
            return u8aVar;
        }
        return (u8a) invokeV.objValue;
    }

    public static n8a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (n8a) invokeV.objValue;
    }

    public u8a() {
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
        n8a b2 = s8a.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new v8a(Looper.getMainLooper());
        }
    }
}
