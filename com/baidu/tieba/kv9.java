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
/* loaded from: classes4.dex */
public final class kv9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<kv9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final dv9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947926683, "Lcom/baidu/tieba/kv9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947926683, "Lcom/baidu/tieba/kv9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public kv9() {
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
        dv9 b2 = iv9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new lv9(Looper.getMainLooper());
        }
    }

    public static kv9 a() {
        kv9 kv9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                kv9 kv9Var2 = b.get();
                if (kv9Var2 != null) {
                    return kv9Var2;
                }
                kv9Var = new kv9();
            } while (!b.compareAndSet(null, kv9Var));
            return kv9Var;
        }
        return (kv9) invokeV.objValue;
    }

    public static dv9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a().a : (dv9) invokeV.objValue;
    }
}
