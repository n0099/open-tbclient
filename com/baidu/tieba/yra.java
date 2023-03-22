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
public final class yra {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<yra> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final rra a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948341153, "Lcom/baidu/tieba/yra;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948341153, "Lcom/baidu/tieba/yra;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static yra a() {
        yra yraVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                yra yraVar2 = b.get();
                if (yraVar2 != null) {
                    return yraVar2;
                }
                yraVar = new yra();
            } while (!b.compareAndSet(null, yraVar));
            return yraVar;
        }
        return (yra) invokeV.objValue;
    }

    public static rra b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (rra) invokeV.objValue;
    }

    public yra() {
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
        rra b2 = wra.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new zra(Looper.getMainLooper());
        }
    }
}
