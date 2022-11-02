package com.baidu.tieba;

import android.view.LayoutInflater;
import com.baidu.tieba.ui4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, wi4 wi4Var) {
        ui4.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, wi4Var) == null) {
            if (wi4Var != null) {
                aVar = new ui4.a(wi4Var);
            } else {
                aVar = null;
            }
            layoutInflater.setFactory2(aVar);
        }
    }
}
