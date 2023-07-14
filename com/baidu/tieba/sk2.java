package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static dl2 a(@NonNull bl2 bl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bl2Var)) == null) {
            int i = bl2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new cl2(bl2Var);
                        }
                        return new gl2(bl2Var);
                    }
                    return new el2(bl2Var);
                }
                return new hl2(bl2Var);
            }
            return new fl2(bl2Var);
        }
        return (dl2) invokeL.objValue;
    }
}
