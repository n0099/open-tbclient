package com.baidu.tieba;

import android.view.LayoutInflater;
import com.baidu.tieba.tp4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class up4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, vp4 vp4Var) {
        tp4.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, vp4Var) == null) {
            if (vp4Var != null) {
                aVar = new tp4.a(vp4Var);
            } else {
                aVar = null;
            }
            layoutInflater.setFactory2(aVar);
        }
    }
}
