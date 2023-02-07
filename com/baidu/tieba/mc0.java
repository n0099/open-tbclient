package com.baidu.tieba;

import android.os.Build;
import com.baidu.live.framework.usersecurity.LiveUserSecurityDeviceInfoManagerKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class mc0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947967727, "Lcom/baidu/tieba/mc0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947967727, "Lcom/baidu/tieba/mc0;");
        }
    }

    @JvmStatic
    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (LiveUserSecurityDeviceInfoManagerKt.d()) {
                return LiveUserSecurityDeviceInfoManagerKt.b(null, 1, null);
            }
            String str = Build.MANUFACTURER;
            Intrinsics.checkExpressionValueIsNotNull(str, "Build.MANUFACTURER");
            return str;
        }
        return (String) invokeV.objValue;
    }
}
