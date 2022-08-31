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
public final class iv9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<iv9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final bv9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947867101, "Lcom/baidu/tieba/iv9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947867101, "Lcom/baidu/tieba/iv9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public iv9() {
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
        bv9 b2 = gv9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new jv9(Looper.getMainLooper());
        }
    }

    public static iv9 a() {
        iv9 iv9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                iv9 iv9Var2 = b.get();
                if (iv9Var2 != null) {
                    return iv9Var2;
                }
                iv9Var = new iv9();
            } while (!b.compareAndSet(null, iv9Var));
            return iv9Var;
        }
        return (iv9) invokeV.objValue;
    }

    public static bv9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a().a : (bv9) invokeV.objValue;
    }
}
