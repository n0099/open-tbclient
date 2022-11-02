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
public final class qz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<qz9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final jz9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948109273, "Lcom/baidu/tieba/qz9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948109273, "Lcom/baidu/tieba/qz9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static qz9 a() {
        qz9 qz9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                qz9 qz9Var2 = b.get();
                if (qz9Var2 != null) {
                    return qz9Var2;
                }
                qz9Var = new qz9();
            } while (!b.compareAndSet(null, qz9Var));
            return qz9Var;
        }
        return (qz9) invokeV.objValue;
    }

    public static jz9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (jz9) invokeV.objValue;
    }

    public qz9() {
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
        jz9 b2 = oz9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new rz9(Looper.getMainLooper());
        }
    }
}
