package com.baidu.tieba;

import android.view.LayoutInflater;
import com.baidu.tieba.of4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, qf4Var) == null) {
            layoutInflater.setFactory2(qf4Var != null ? new of4.a(qf4Var) : null);
        }
    }
}
