package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            v18.n();
            j28.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            c28.n().o(TbadkCoreApplication.getInst().getContext());
            k28.b().c();
            f28.i();
            n28.k();
        }
    }
}
