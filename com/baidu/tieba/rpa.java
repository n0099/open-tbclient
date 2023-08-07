package com.baidu.tieba;

import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class rpa {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;
    public static final xka b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948130694, "Lcom/baidu/tieba/rpa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948130694, "Lcom/baidu/tieba/rpa;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(5L);
        b = new xka("camera_last_api", 0, "camera_last_api_stamp");
        c = "Lenovo K520".equals(DeviceInfoHelper.getModel());
    }
}
