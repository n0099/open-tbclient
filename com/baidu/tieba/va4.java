package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.n44;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class va4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948234048, "Lcom/baidu/tieba/va4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948234048, "Lcom/baidu/tieba/va4;");
                return;
            }
        }
        boolean z = ho1.a;
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
            x73 q = w73.K().q();
            if (!q.I() || q.k0() == null || (h = n44.d.h(q.getAppId(), q.k0())) == null || !h.exists()) {
                return null;
            }
            return "file://" + h.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }
}
