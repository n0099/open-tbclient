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
public final class tjc {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<tjc> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final mjc a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948184572, "Lcom/baidu/tieba/tjc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948184572, "Lcom/baidu/tieba/tjc;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static tjc a() {
        tjc tjcVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                tjc tjcVar2 = b.get();
                if (tjcVar2 != null) {
                    return tjcVar2;
                }
                tjcVar = new tjc();
            } while (!b.compareAndSet(null, tjcVar));
            return tjcVar;
        }
        return (tjc) invokeV.objValue;
    }

    public static mjc b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (mjc) invokeV.objValue;
    }

    public tjc() {
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
        mjc b2 = rjc.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new ujc(Looper.getMainLooper());
        }
    }
}
