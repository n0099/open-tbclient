package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static gk2 a(@NonNull ek2 ek2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ek2Var)) == null) {
            int i = ek2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new fk2(ek2Var);
                        }
                        return new jk2(ek2Var);
                    }
                    return new hk2(ek2Var);
                }
                return new kk2(ek2Var);
            }
            return new ik2(ek2Var);
        }
        return (gk2) invokeL.objValue;
    }
}
