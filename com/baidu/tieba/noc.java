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
public final class noc {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<noc> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final goc a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948010631, "Lcom/baidu/tieba/noc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948010631, "Lcom/baidu/tieba/noc;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static noc a() {
        noc nocVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                noc nocVar2 = b.get();
                if (nocVar2 != null) {
                    return nocVar2;
                }
                nocVar = new noc();
            } while (!b.compareAndSet(null, nocVar));
            return nocVar;
        }
        return (noc) invokeV.objValue;
    }

    public static goc b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (goc) invokeV.objValue;
    }

    public noc() {
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
        goc b2 = loc.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new ooc(Looper.getMainLooper());
        }
    }
}
