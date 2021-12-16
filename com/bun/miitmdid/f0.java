package com.bun.miitmdid;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class f0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, char[] cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, str, cArr)) != null) {
            return invokeLL.booleanValue;
        }
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= str.length()) {
                return true;
            }
            int length = cArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z = false;
                    break;
                } else if (cArr[i3] == str.charAt(i2)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                return false;
            }
            i2++;
        }
    }
}
