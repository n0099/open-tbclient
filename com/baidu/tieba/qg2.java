package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static bh2 a(@NonNull zg2 zg2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zg2Var)) == null) {
            int i = zg2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new ah2(zg2Var);
                        }
                        return new eh2(zg2Var);
                    }
                    return new ch2(zg2Var);
                }
                return new fh2(zg2Var);
            }
            return new dh2(zg2Var);
        }
        return (bh2) invokeL.objValue;
    }
}
