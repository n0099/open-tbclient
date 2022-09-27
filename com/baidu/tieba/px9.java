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
public final class px9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<px9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ix9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948077560, "Lcom/baidu/tieba/px9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948077560, "Lcom/baidu/tieba/px9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public px9() {
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
        ix9 b2 = nx9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new qx9(Looper.getMainLooper());
        }
    }

    public static px9 a() {
        px9 px9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                px9 px9Var2 = b.get();
                if (px9Var2 != null) {
                    return px9Var2;
                }
                px9Var = new px9();
            } while (!b.compareAndSet(null, px9Var));
            return px9Var;
        }
        return (px9) invokeV.objValue;
    }

    public static ix9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a().a : (ix9) invokeV.objValue;
    }
}
