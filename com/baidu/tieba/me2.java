package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class me2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static xe2 a(@NonNull ve2 ve2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ve2Var)) == null) {
            int i = ve2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new we2(ve2Var);
                        }
                        return new af2(ve2Var);
                    }
                    return new ye2(ve2Var);
                }
                return new bf2(ve2Var);
            }
            return new ze2(ve2Var);
        }
        return (xe2) invokeL.objValue;
    }
}
