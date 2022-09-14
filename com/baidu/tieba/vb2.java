package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vb2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static gc2 a(@NonNull ec2 ec2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ec2Var)) == null) {
            int i = ec2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new fc2(ec2Var);
                        }
                        return new jc2(ec2Var);
                    }
                    return new hc2(ec2Var);
                }
                return new kc2(ec2Var);
            }
            return new ic2(ec2Var);
        }
        return (gc2) invokeL.objValue;
    }
}
