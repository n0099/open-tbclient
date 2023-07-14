package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ub8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            te8.n();
            hf8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            af8.n().o(TbadkCoreApplication.getInst().getContext());
            if8.b().c();
            df8.i();
            lf8.k();
        }
    }
}
