package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ug2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static fh2 a(@NonNull dh2 dh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dh2Var)) == null) {
            int i = dh2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new eh2(dh2Var);
                        }
                        return new ih2(dh2Var);
                    }
                    return new gh2(dh2Var);
                }
                return new jh2(dh2Var);
            }
            return new hh2(dh2Var);
        }
        return (fh2) invokeL.objValue;
    }
}
