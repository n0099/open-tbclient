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
public final class ucc {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<ucc> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ncc a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948207636, "Lcom/baidu/tieba/ucc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948207636, "Lcom/baidu/tieba/ucc;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static ucc a() {
        ucc uccVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                ucc uccVar2 = b.get();
                if (uccVar2 != null) {
                    return uccVar2;
                }
                uccVar = new ucc();
            } while (!b.compareAndSet(null, uccVar));
            return uccVar;
        }
        return (ucc) invokeV.objValue;
    }

    public static ncc b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (ncc) invokeV.objValue;
    }

    public ucc() {
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
        ncc b2 = scc.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new vcc(Looper.getMainLooper());
        }
    }
}
