package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            nc8.n();
            bd8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            uc8.n().o(TbadkCoreApplication.getInst().getContext());
            cd8.b().c();
            xc8.i();
            fd8.k();
        }
    }
}
