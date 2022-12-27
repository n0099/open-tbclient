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
public final class m3a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<m3a> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final f3a a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947923118, "Lcom/baidu/tieba/m3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947923118, "Lcom/baidu/tieba/m3a;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static m3a a() {
        m3a m3aVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                m3a m3aVar2 = b.get();
                if (m3aVar2 != null) {
                    return m3aVar2;
                }
                m3aVar = new m3a();
            } while (!b.compareAndSet(null, m3aVar));
            return m3aVar;
        }
        return (m3a) invokeV.objValue;
    }

    public static f3a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (f3a) invokeV.objValue;
    }

    public m3a() {
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
        f3a b2 = k3a.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new n3a(Looper.getMainLooper());
        }
    }
}
