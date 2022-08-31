package com.baidu.tieba;

import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class ix8 {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;
    public static final rs8 b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947868992, "Lcom/baidu/tieba/ix8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947868992, "Lcom/baidu/tieba/ix8;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(5L);
        b = new rs8("camera_last_api", 0, "camera_last_api_stamp");
        c = "Lenovo K520".equals(Build.MODEL);
    }
}
