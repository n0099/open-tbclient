package com.baidu.tieba;

import android.view.LayoutInflater;
import com.baidu.tieba.lq4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, nq4 nq4Var) {
        lq4.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, nq4Var) == null) {
            if (nq4Var != null) {
                aVar = new lq4.a(nq4Var);
            } else {
                aVar = null;
            }
            layoutInflater.setFactory2(aVar);
        }
    }
}
