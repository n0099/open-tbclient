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
public final class p1b {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<p1b> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final i1b a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948010600, "Lcom/baidu/tieba/p1b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948010600, "Lcom/baidu/tieba/p1b;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static p1b a() {
        p1b p1bVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                p1b p1bVar2 = b.get();
                if (p1bVar2 != null) {
                    return p1bVar2;
                }
                p1bVar = new p1b();
            } while (!b.compareAndSet(null, p1bVar));
            return p1bVar;
        }
        return (p1b) invokeV.objValue;
    }

    public static i1b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (i1b) invokeV.objValue;
    }

    public p1b() {
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
        i1b b2 = n1b.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new q1b(Looper.getMainLooper());
        }
    }
}
