package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            uf8.n();
            ig8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            bg8.n().o(TbadkCoreApplication.getInst().getContext());
            jg8.b().c();
            eg8.i();
            ng8.k();
        }
    }
}
