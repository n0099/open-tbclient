package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class v3b {
    public static /* synthetic */ Interceptable $ic;
    public static final v3b a;
    public static final Map<String, w3b> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948191268, "Lcom/baidu/tieba/v3b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948191268, "Lcom/baidu/tieba/v3b;");
                return;
            }
        }
        a = new v3b();
        b = new LinkedHashMap();
    }

    public v3b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final boolean a(String tid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tid)) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            return b.containsKey(tid);
        }
        return invokeL.booleanValue;
    }

    public final w3b b(String tid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tid)) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            w3b w3bVar = b.get(tid);
            if (w3bVar == null) {
                w3bVar = new w3b();
            }
            b.put(tid, w3bVar);
            return w3bVar;
        }
        return (w3b) invokeL.objValue;
    }

    public final void c(String tid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tid) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            w3b remove = b.remove(tid);
            if (remove != null) {
                remove.a();
            }
        }
    }
}
