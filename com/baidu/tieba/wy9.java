package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class wy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(File file, Object obj) {
        InterceptResult invokeLL;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, file, obj)) == null) {
            synchronized (obj) {
                b = xy9.b(file);
            }
            return b;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b(String str, File file, boolean z, Object obj) {
        InterceptResult invokeCommon;
        boolean e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, file, Boolean.valueOf(z), obj})) == null) {
            synchronized (obj) {
                e = xy9.e(str, file, z);
            }
            return e;
        }
        return invokeCommon.booleanValue;
    }
}
