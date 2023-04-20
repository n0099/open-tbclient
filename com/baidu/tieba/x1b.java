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
public final class x1b {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<x1b> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final q1b a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948248928, "Lcom/baidu/tieba/x1b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948248928, "Lcom/baidu/tieba/x1b;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static x1b a() {
        x1b x1bVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                x1b x1bVar2 = b.get();
                if (x1bVar2 != null) {
                    return x1bVar2;
                }
                x1bVar = new x1b();
            } while (!b.compareAndSet(null, x1bVar));
            return x1bVar;
        }
        return (x1b) invokeV.objValue;
    }

    public static q1b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (q1b) invokeV.objValue;
    }

    public x1b() {
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
        q1b b2 = v1b.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new y1b(Looper.getMainLooper());
        }
    }
}
