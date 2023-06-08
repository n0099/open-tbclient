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
public final class xmb {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<xmb> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final qmb a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948306588, "Lcom/baidu/tieba/xmb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948306588, "Lcom/baidu/tieba/xmb;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static xmb a() {
        xmb xmbVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                xmb xmbVar2 = b.get();
                if (xmbVar2 != null) {
                    return xmbVar2;
                }
                xmbVar = new xmb();
            } while (!b.compareAndSet(null, xmbVar));
            return xmbVar;
        }
        return (xmb) invokeV.objValue;
    }

    public static qmb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (qmb) invokeV.objValue;
    }

    public xmb() {
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
        qmb b2 = vmb.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new ymb(Looper.getMainLooper());
        }
    }
}
