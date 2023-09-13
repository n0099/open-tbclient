package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes8.dex */
public class yj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static File a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return vj1.r(str);
        }
        return (File) invokeL.objValue;
    }
}
