package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class od7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(String str, String errorMessage) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, errorMessage)) == null) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return str;
            }
            throw new IllegalStateException(errorMessage);
        }
        return (String) invokeLL.objValue;
    }

    public static /* synthetic */ String b(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "string must not empty!";
        }
        a(str, str2);
        return str;
    }
}
