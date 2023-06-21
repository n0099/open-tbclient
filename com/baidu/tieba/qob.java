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
public final class qob {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<qob> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final job a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948099973, "Lcom/baidu/tieba/qob;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948099973, "Lcom/baidu/tieba/qob;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static qob a() {
        qob qobVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                qob qobVar2 = b.get();
                if (qobVar2 != null) {
                    return qobVar2;
                }
                qobVar = new qob();
            } while (!b.compareAndSet(null, qobVar));
            return qobVar;
        }
        return (qob) invokeV.objValue;
    }

    public static job b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (job) invokeV.objValue;
    }

    public qob() {
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
        job b2 = oob.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new rob(Looper.getMainLooper());
        }
    }
}
