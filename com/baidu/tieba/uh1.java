package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uh1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "https://afd.baidu.com/afd/entry";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948210891, "Lcom/baidu/tieba/uh1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948210891, "Lcom/baidu/tieba/uh1;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (tf0.a && !TextUtils.isEmpty(ii0.d().j())) {
                return ii0.d().j();
            }
            if (TextUtils.isEmpty(a)) {
                return "https://afd.baidu.com/afd/entry";
            }
            return a;
        }
        return (String) invokeV.objValue;
    }
}
