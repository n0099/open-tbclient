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
/* loaded from: classes8.dex */
public final class x7c {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<x7c> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final q7c a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948254725, "Lcom/baidu/tieba/x7c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948254725, "Lcom/baidu/tieba/x7c;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static x7c a() {
        x7c x7cVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                x7c x7cVar2 = b.get();
                if (x7cVar2 != null) {
                    return x7cVar2;
                }
                x7cVar = new x7c();
            } while (!b.compareAndSet(null, x7cVar));
            return x7cVar;
        }
        return (x7c) invokeV.objValue;
    }

    public static q7c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (q7c) invokeV.objValue;
    }

    public x7c() {
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
        q7c b2 = v7c.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new y7c(Looper.getMainLooper());
        }
    }
}
