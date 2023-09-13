package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static aj5 a(Context context, ej5 ej5Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, ej5Var, i)) == null) {
            if (i != 1) {
                return new DLauncher(context, ej5Var);
            }
            return new BLauncher(context, ej5Var);
        }
        return (aj5) invokeLLI.objValue;
    }
}
