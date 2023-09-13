package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mw0 extends ww0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ww0 w(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            return ww0.m(str, 3);
        }
        return (ww0) invokeL.objValue;
    }
}
