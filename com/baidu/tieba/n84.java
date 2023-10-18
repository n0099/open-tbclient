package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.f24;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class n84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947956319, "Lcom/baidu/tieba/n84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947956319, "Lcom/baidu/tieba/n84;");
                return;
            }
        }
        boolean z = am1.a;
    }

    public static PathType a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return PathType.ERROR;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                return PathType.RELATIVE;
            }
            return PathType.NETWORK;
        }
        return (PathType) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        File h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            p53 q = o53.K().q();
            if (!q.I() || q.l0() == null || (h = f24.d.h(q.getAppId(), q.l0())) == null || !h.exists()) {
                return null;
            }
            return "file://" + h.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }
}
