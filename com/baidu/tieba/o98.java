package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            mc8.n();
            ad8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            tc8.n().o(TbadkCoreApplication.getInst().getContext());
            bd8.b().c();
            wc8.i();
            ed8.k();
        }
    }
}
