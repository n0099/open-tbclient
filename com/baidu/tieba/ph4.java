package com.baidu.tieba;

import android.view.LayoutInflater;
import com.baidu.tieba.oh4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ph4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, qh4 qh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, qh4Var) == null) {
            layoutInflater.setFactory2(qh4Var != null ? new oh4.a(qh4Var) : null);
        }
    }
}
