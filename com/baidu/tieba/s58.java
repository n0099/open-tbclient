package com.baidu.tieba;

import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class s58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static r58 a(w58 w58Var, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, w58Var, intent)) == null) {
            int intExtra = intent.getIntExtra("transition_type", 0);
            if (intExtra == 1) {
                return new x58(w58Var, intent);
            }
            if (intExtra == 2) {
                return new q58(w58Var, intent);
            }
            return null;
        }
        return (r58) invokeLL.objValue;
    }
}
