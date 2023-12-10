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
public final class ooc {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<ooc> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final hoc a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948040422, "Lcom/baidu/tieba/ooc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948040422, "Lcom/baidu/tieba/ooc;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static ooc a() {
        ooc oocVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                ooc oocVar2 = b.get();
                if (oocVar2 != null) {
                    return oocVar2;
                }
                oocVar = new ooc();
            } while (!b.compareAndSet(null, oocVar));
            return oocVar;
        }
        return (ooc) invokeV.objValue;
    }

    public static hoc b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (hoc) invokeV.objValue;
    }

    public ooc() {
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
        hoc b2 = moc.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new poc(Looper.getMainLooper());
        }
    }
}
