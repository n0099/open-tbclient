package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            r98.n();
            fa8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            y98.n().o(TbadkCoreApplication.getInst().getContext());
            ga8.b().c();
            ba8.i();
            ja8.k();
        }
    }
}
