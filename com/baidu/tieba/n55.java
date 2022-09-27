package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class n55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static o55 a(Context context, s55 s55Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, s55Var, i)) == null) {
            if (i != 1) {
                return new DLauncher(context, s55Var);
            }
            return new BLauncher(context, s55Var);
        }
        return (o55) invokeLLI.objValue;
    }
}
