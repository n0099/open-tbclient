package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class s65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static t65 a(Context context, x65 x65Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, x65Var, i)) == null) {
            if (i != 1) {
                return new DLauncher(context, x65Var);
            }
            return new BLauncher(context, x65Var);
        }
        return (t65) invokeLLI.objValue;
    }
}
