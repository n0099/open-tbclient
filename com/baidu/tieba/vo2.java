package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.davemorrissey.labs.subscaleview.ImageSource;
/* loaded from: classes6.dex */
public class vo2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str.startsWith(ImageSource.FILE_SCHEME)) {
                str = str.substring(8);
            }
            t73 M = t73.M();
            if (bf3.E(str) && M != null) {
                return bf3.H(str, M);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
