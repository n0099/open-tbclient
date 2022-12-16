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
/* loaded from: classes5.dex */
public final class l3a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<l3a> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final e3a a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947893327, "Lcom/baidu/tieba/l3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947893327, "Lcom/baidu/tieba/l3a;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static l3a a() {
        l3a l3aVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                l3a l3aVar2 = b.get();
                if (l3aVar2 != null) {
                    return l3aVar2;
                }
                l3aVar = new l3a();
            } while (!b.compareAndSet(null, l3aVar));
            return l3aVar;
        }
        return (l3a) invokeV.objValue;
    }

    public static e3a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (e3a) invokeV.objValue;
    }

    public l3a() {
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
        e3a b2 = j3a.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new m3a(Looper.getMainLooper());
        }
    }
}
