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
public final class sjc {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<sjc> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ljc a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948154781, "Lcom/baidu/tieba/sjc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948154781, "Lcom/baidu/tieba/sjc;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static sjc a() {
        sjc sjcVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                sjc sjcVar2 = b.get();
                if (sjcVar2 != null) {
                    return sjcVar2;
                }
                sjcVar = new sjc();
            } while (!b.compareAndSet(null, sjcVar));
            return sjcVar;
        }
        return (sjc) invokeV.objValue;
    }

    public static ljc b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (ljc) invokeV.objValue;
    }

    public sjc() {
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
        ljc b2 = qjc.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new tjc(Looper.getMainLooper());
        }
    }
}
