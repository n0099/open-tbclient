package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class th2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static ei2 a(@NonNull ci2 ci2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ci2Var)) == null) {
            int i = ci2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new di2(ci2Var);
                        }
                        return new hi2(ci2Var);
                    }
                    return new fi2(ci2Var);
                }
                return new ii2(ci2Var);
            }
            return new gi2(ci2Var);
        }
        return (ei2) invokeL.objValue;
    }
}
