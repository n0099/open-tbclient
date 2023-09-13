package com.baidu.tieba;

import android.view.LayoutInflater;
import com.baidu.tieba.xp4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, zp4 zp4Var) {
        xp4.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, zp4Var) == null) {
            if (zp4Var != null) {
                aVar = new xp4.a(zp4Var);
            } else {
                aVar = null;
            }
            layoutInflater.setFactory2(aVar);
        }
    }
}
