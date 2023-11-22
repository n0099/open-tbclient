package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class sj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            ts8.n();
            ht8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            at8.n().o(TbadkCoreApplication.getInst().getContext());
            it8.b().c();
            dt8.i();
            mt8.k();
        }
    }
}
